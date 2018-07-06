package com.rabbitforever.gamblehub.services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitforever.gamblehub.daos.BigSmallDao;
import com.rabbitforever.gamblehub.helpers.GameServiceHelper;
import com.rabbitforever.gamblehub.models.eos.BigSmallEo;
import com.rabbitforever.gamblehub.tests.FindAndCountPatterns;
@Service
public class GambleServiceImp extends ServiceBase implements GambleService{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private final int MINLEN = 2;
	private final int MINCNT = 2;
	private GameServiceHelper helper;
	
	public GambleServiceImp() {
		helper = new GameServiceHelper(MINLEN);
	}
	
	private String getClassName(){
		return this.getClass().getName();
	}

	@Autowired
	private BigSmallDao dao;
	

	public String getNextBettingSuggestion(String s) throws Exception{
		String result = null;
		try {
			Map <String, Integer> mapCount = new HashMap<String, Integer>();


			FindAndCountPatterns fac = new FindAndCountPatterns();
			for (int sublen = MINLEN; sublen < s.length() / MINCNT; sublen ++) {
//				System.out.println("\n" + sublen + "\n------");
				for (int i = 0; i < s.length() - sublen; i++) {
//					System.out.println(i);

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
			result = nextBetting;
		} catch (Exception e) {
			logger.error(getClassName() + ".getNextBettingSuggestion() - result=" + result, e);
			throw e;
		}
		return result;
	}
	
	public Map<String, Integer> getPatternCount(String resultString)  throws Exception{
		Map<String, Integer> patternMap = null;
		try {
			String s =  resultString;
			Map <String, Integer> mapCount = new HashMap<String, Integer>();


			FindAndCountPatterns fac = new FindAndCountPatterns();
			for (int sublen = MINLEN; sublen < s.length() / MINCNT; sublen ++) {
//				System.out.println("\n" + sublen + "\n------");
				for (int i = 0; i < s.length() - sublen; i++) {
//					System.out.println(i);

					String sub = s.substring(i, sublen+ i);

					int cnt = fac.numberOfOccurrence(s, sub);
					System.out.println(cnt);
					if (cnt >=  MINCNT && !mapCount.containsKey(sub)) {
						mapCount.put(sub, cnt);
					}

				}			
			}
		} catch (Exception e) {
			logger.error(getClassName() + ".getPatternCount() - resultString=" + resultString, e);
			throw e;
		}
		return patternMap;
	}
	
	@Override
	public List<BigSmallEo> read(Object so) throws Exception {
		List<BigSmallEo> bigSmallEoList = null;
		try{
			bigSmallEoList = dao.read(so);
		}
		catch (Exception e){
			logger.error(getClassName() + ".read() - so=" + so, e);
			throw e;
		} // end try ... catch
		return bigSmallEoList;
	}
	public Integer create(BigSmallEo eo) throws Exception{
		Integer id = null;
		try{
			id = dao.create(eo);
		}
		catch (Exception e){
			logger.error(getClassName() + ".create() - eo=" + eo, e);
			throw e;
		} // end try ... catch
		return id;
	} // end create function




}
