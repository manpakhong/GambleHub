package com.rabbitforever.gamblehub.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitforever.gamblehub.daos.BigSmallDao;
import com.rabbitforever.gamblehub.models.eos.BigSmallEo;
import com.rabbitforever.gamblehub.tests.FindAndCountPatterns;
@Service
public class GambleServiceImp extends ServiceBase implements GambleService{
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private String getClassName(){
		return this.getClass().getName();
	}

	@Autowired
	private BigSmallDao dao;
	   
	public Map<String, Integer> getPatternCount(String resultString)  throws Exception{
		Map<String, Integer> patternMap = null;
		try {
			String s =  resultString;
			Map <String, Integer> mapCount = new HashMap<String, Integer>();
			final int MINLEN = 2;
			final int MINCNT = 2;

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
