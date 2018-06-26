package com.rabbitforever.gamblehub.tests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FindAndCountPatterns {

	public static void main(String[] args) {
		String s =  "SBDSBBSSSBBDSSSDDDDBBBBSBSBSBBDSSBDDDBBSBSSSSBDBBBBSSBBSSBBSS";
		Map <String, Integer> mapCount = new HashMap<String, Integer>();
		final int MINLEN = 2;
		final int MINCNT = 2;

		FindAndCountPatterns fac = new FindAndCountPatterns();
		for (int sublen = MINLEN; sublen < s.length() / MINCNT; sublen ++) {
//			System.out.println("\n" + sublen + "\n------");
			for (int i = 0; i < s.length() - sublen; i++) {
//				System.out.println(i);

				String sub = s.substring(i, sublen+ i);

				int cnt = fac.numberOfOccurrence(s, sub);
				System.out.println(cnt);
				if (cnt >=  MINCNT && !mapCount.containsKey(sub)) {
					mapCount.put(sub, cnt);
				}

			}			
		}
		
		Iterator it = mapCount.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey() + ":" + pair.getValue());
			it.remove();
		}
		
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
