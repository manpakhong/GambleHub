package com.rabbitforever.gamblehub.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FindAndCountPatterns {
	private final Logger logger = LogManager.getLogger(getClassName());
	final static int MINLEN = 2;
	final static int MINCNT = 2;
	private String getClassName() {
		return this.getClass().getName();
	}
	public static void main(String[] args) {
		String s =  "SBDSBBSSSBBDSSSDDDDBBBBSBSBSBBDSSBDDDBBSBSSSSBDBBBBSSBBSSBBSSSBSSSSSSSBBBBBBBSSSSSSSSSSSSSSSSSSSSSSSSSSSS";
		Map <String, Integer> mapCount = new HashMap<String, Integer>();


		FindAndCountPatterns fac = new FindAndCountPatterns();
		for (int sublen = MINLEN; sublen < s.length() / MINCNT; sublen ++) {
//			System.out.println("\n" + sublen + "\n------");
			for (int i = 0; i < s.length() - sublen; i++) {
//				System.out.println(i);

				String sub = s.substring(i, sublen+ i);

				int cnt = fac.numberOfOccurrence(s, sub);
				//System.out.println(cnt);
				if (cnt >=  MINCNT && !mapCount.containsKey(sub)) {
					mapCount.put(sub, cnt);
				}

			}			
		}
		
		Iterator it = mapCount.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey() + ":" + pair.getValue());
			//it.remove();
		}
		String longestPattern =  fac.findTheLongestPattern(mapCount);
		System.out.println("longest pattern:" + longestPattern + ",count:" + longestPattern.length());
		
		List<String> matchingReversedPatternList = fac.findTheMatchingPatternWithLength(s, longestPattern.length(), mapCount);
		Map<String, Integer> potentialEstimatePattern = fac.findPotentialEstimatePattern(matchingReversedPatternList, mapCount);
		
		System.out.println("Potential Estimate Pattern:");
		Iterator it2 = potentialEstimatePattern.entrySet().iterator();
		while (it2.hasNext()) {
			Map.Entry pair = (Map.Entry)it2.next();
			System.out.println(pair.getKey() + ":" + pair.getValue());
			//it.remove();
		}
		System.out.println("Same Length Winner:");
		Map<Integer, String> sameLengthWinner = fac.suggestNextBetting(potentialEstimatePattern, longestPattern.length());
		Iterator it3 = sameLengthWinner.entrySet().iterator();
		while (it3.hasNext()) {
			Map.Entry pair = (Map.Entry)it3.next();
			System.out.println(pair.getKey() + ":" + pair.getValue());
			//it.remove();
		}	
		System.out.println("get final next estimate count");
		Map<String, Integer> finalNextEstimateCountMap = fac.getFinalNextEstimateCountMap(sameLengthWinner);
		Iterator it4 = finalNextEstimateCountMap.entrySet().iterator();
		while (it4.hasNext()) {
			Map.Entry pair = (Map.Entry)it4.next();
			System.out.println(pair.getKey() + ":" + pair.getValue());
			//it.remove();
		}	
		System.out.println("estimate next betting");
		String nextBetting = fac.getTheWinner(finalNextEstimateCountMap);
		System.out.println("???????????????????????????????");
		System.out.println(nextBetting);
		System.out.println("???????????????????????????????");		
	}
	
	public String getTheWinner(Map<String, Integer> finalNextEstimateCountMap) {
		String winnerString = null;
		try {
			Iterator it4 = finalNextEstimateCountMap.entrySet().iterator();
			Integer largest = 0;
			while (it4.hasNext()) {
				Map.Entry pair = (Map.Entry)it4.next();
				String key = (String) pair.getKey();
				Integer value = (Integer) pair.getValue();
				if (value.intValue() > largest.intValue()) {
					largest = value;
					winnerString = key;
				}
				//it.remove();
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		return winnerString;
	}
	
	public Map<String, Integer> getFinalNextEstimateCountMap(Map<Integer, String> sameLengthWinner){
		Map<String, Integer> nextWinnerCountMap = null;
		try {
			nextWinnerCountMap = new HashMap<String,Integer>();
			Iterator it3 = sameLengthWinner.entrySet().iterator();
			while (it3.hasNext()) {
				Map.Entry pair = (Map.Entry)it3.next();
				Integer key = (Integer) pair.getKey();
				String value = (String) pair.getValue();
				String inputKey = value.substring(value.length() - 1, value.length());
				
				if (!nextWinnerCountMap.containsKey(inputKey)) {
					nextWinnerCountMap.put(inputKey, 1);
				} else {
					Integer runningCount = nextWinnerCountMap.get(inputKey);
					runningCount ++;
					nextWinnerCountMap.put(inputKey, runningCount);
				}
				// System.out.println(inputKey + ":" + pair.getValue());
				//it.remove();
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nextWinnerCountMap;
	}
	
	public Map<Integer, String> suggestNextBetting(Map<String, Integer> potentialEstimatePattern, int longestPatternLength) {
		//String result = "";
		Map<Integer, String> winnerMap = new HashMap<Integer, String>();
		for (int i = 0; i <= longestPatternLength; i++) {
			Iterator it = potentialEstimatePattern.entrySet().iterator();
			String currentWinner = "";
			int currentWinnerCount = 0;
			boolean draw = false;
			boolean foundNoDraw = false;
			Integer keyLength = i;
			int j = 0;
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry)it.next();
				String key = (String) pair.getKey();
				Integer value = (Integer) pair.getValue();
				// System.out.println(pair.getKey() + ":" + pair.getValue());
				String predictMatchString = getPredictMatchString(key);


				if (key.length() == i) {
					if (value.intValue() > currentWinnerCount) {
						currentWinner = key;
						currentWinnerCount = value;
						winnerMap.put(keyLength, key);
						if (j > 0) {
							foundNoDraw = true;
						}

					} else if (value.intValue() == currentWinnerCount) {
						draw = true;
					}
					j++;
				}

			}
			if (draw && !foundNoDraw) {
				winnerMap.remove(keyLength);
			}
		}
		return winnerMap;
	}
	public Map<String, Integer> findPotentialEstimatePattern(List<String> listToBeFind, Map<String, Integer> mapCount){
		Map<String, Integer> estimatePatternMap = null;
		try {
			estimatePatternMap = new HashMap<String, Integer>();
			for (int i = 0; i < listToBeFind.size(); i++) {
				String currentListString = listToBeFind.get(i);
				Iterator it = mapCount.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pair = (Map.Entry)it.next();
					String key = (String) pair.getKey();
					Integer value = (Integer) pair.getValue();
					// System.out.println(pair.getKey() + ":" + pair.getValue());
					String predictMatchString = getPredictMatchString(key);
					if (currentListString.equals(predictMatchString)) {
						estimatePatternMap.put(key, value);
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return estimatePatternMap;
	}
	public List<String> findTheMatchingPatternWithLength(String resultString, Integer maxReverseLength, Map<String, Integer> patternMap){
		List<String> matchingReversedPatternList = null;
		try {
			int maxLength = resultString.length();
			logger.debug(getClassName() + "getNextBettingSuggestion() -length of resultString:" + maxLength);
			matchingReversedPatternList = new ArrayList<String>();
			for (int i = MINLEN - 2; i < maxReverseLength - 1; i++) {
				logger.debug(getClassName() + "getNextBettingSuggestion() -i=" + i + ", substring(" + (maxLength - i -1) + "," + (maxLength) + ")");
				logger.debug(getClassName() + "getNextBettingSuggestion() -substring:" + resultString.substring(maxLength - i - 1, maxLength));
				matchingReversedPatternList.add(resultString.substring(maxLength - i - 1, maxLength));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return matchingReversedPatternList;
	}
	
	public String getPredictMatchString(String patternString) {
		String returnString = "";
		int maxLength = patternString.length();
		returnString = patternString.substring(0, maxLength -1);
		return returnString;
	}
	

	public String findTheLongestPattern(Map<String, Integer> patternMap) {
		String longestPatternString = "";
		try {
			Iterator it = patternMap.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry)it.next();
				String key = (String) pair.getKey();
				Integer count = (Integer) pair.getValue();
				//System.out.println(key + ":" + count);
				if (key.length() > longestPatternString.length()) {
					longestPatternString = key;
				}
				//it.remove();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return longestPatternString;
	}
	
	public int numberOfOccurrence(String fullString, String subString) {
		int lastIndex = 0;
		int count = 0;
		while (lastIndex != -1) {
		    lastIndex = fullString.indexOf(subString,lastIndex);

		    if(lastIndex != -1){
		        count ++;
		        lastIndex += subString.length();
		    }
		}
		return count;
	}
}
