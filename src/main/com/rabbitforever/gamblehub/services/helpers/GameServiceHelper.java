package com.rabbitforever.gamblehub.services.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameServiceHelper {
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private int minLen;
	public GameServiceHelper(int minLen) {
		this.minLen = minLen;
	}
	private String getClassName(){
		return this.getClass().getName();
	}
	public int numberOfOccurrence(String fullString, String subString) throws Exception {

		int lastIndex = 0;
		int count = 0;
		try {
			while (lastIndex != -1) {
				lastIndex = fullString.indexOf(subString, lastIndex);

				if (lastIndex != -1) {
					count++;
					lastIndex += subString.length();
				}
			}
		} catch (Exception e) {
			logger.error(getClassName() + ".numberOfOccurrence() - fullString=" + fullString + ", subString=" + subString, e);
			throw e;
		}
		return count;
	}
	public String getTheWinner(Map<String, Integer> finalNextEstimateCountMap) throws Exception{
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
			logger.error(getClassName() + ".getTheWinner() - finalNextEstimateCountMap=" + finalNextEstimateCountMap, e);
			throw e;
		}
		return winnerString;
	}
	
	public Map<String, Integer> getFinalNextEstimateCountMap(Map<Integer, String> sameLengthWinner) throws Exception{
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
			logger.error(getClassName() + ".getFinalNextEstimateCountMap() - sameLengthWinner=" + sameLengthWinner, e);
			throw e;
		}
		return nextWinnerCountMap;
	}
	
	public Map<Integer, String> suggestNextBetting(Map<String, Integer> potentialEstimatePattern, int longestPatternLength) throws Exception {
		//String result = "";
		Map<Integer, String> winnerMap = null;
		try {
			winnerMap = new HashMap<Integer, String>();
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
		} catch (Exception e) {
			logger.error(getClassName() + ".suggestNextBetting() - potentialEstimatePattern=" + potentialEstimatePattern + ",longestPatternLength=" + longestPatternLength, e);
			throw e;
		}
		return winnerMap;
	}
	public Map<String, Integer> findPotentialEstimatePattern(List<String> listToBeFind, Map<String, Integer> mapCount) throws Exception{
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
			logger.error(getClassName() + ".findPotentialEstimatePattern() - listToBeFind=" + listToBeFind + ",mapCount=" + mapCount, e);
			throw e;
		}
		return estimatePatternMap;
	}
	public List<String> findTheMatchingPatternWithLength(String resultString, Integer maxReverseLength, Map<String, Integer> patternMap) throws Exception{
		List<String> matchingReversedPatternList = null;
		try {
			int maxLength = resultString.length();
			logger.debug(getClassName() + ".findTheMatchingPatternWithLength() - length of resultString:" + maxLength);
			matchingReversedPatternList = new ArrayList<String>();
			for (int i = minLen - 2; i < maxReverseLength - 1; i++) {
				logger.debug(getClassName() + ".findTheMatchingPatternWithLength() -i=" + i + ", substring(" + (maxLength - i -1) + "," + (maxLength) + ")");
				logger.debug(getClassName() + ".findTheMatchingPatternWithLength() -substring:" + resultString.substring(maxLength - i - 1, maxLength));
				matchingReversedPatternList.add(resultString.substring(maxLength - i - 1, maxLength));
			}
		} catch (Exception e) {
			logger.error(getClassName() + ".findTheMatchingPatternWithLength() - resultString=" + resultString + ",maxReverseLength=" + maxReverseLength + ",patternMap=" + patternMap, e);
			throw e;
		}
		return matchingReversedPatternList;
	}
	
	public String getPredictMatchString(String patternString) throws Exception{
		String returnString = "";
		try {
			int maxLength = patternString.length();
			returnString = patternString.substring(0, maxLength -1);
		} catch (Exception e) {
			logger.error(getClassName() + ".getPredictMatchString() - patternString=" + patternString , e);
			throw e;
		}
		return returnString;
	}
	

	public String findTheLongestPattern(Map<String, Integer> patternMap) throws Exception{
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
			logger.error(getClassName() + ".findTheLongestPattern() - patternMap=" + patternMap , e);
			throw e;
		}
		return longestPatternString;
	}
}
