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

		for (int sublen = MINLEN; sublen < s.length() / MINCNT; sublen ++) {
			for (int i = 0; i < s.length() - sublen; i++) {
				
				if ((sublen + 1) < s.length()) {
					String sub = s.substring(i, sublen+ 1);
					if (sub.length() > MINLEN) {
						int cnt =numberOfOccurrence(s, sub);
						if (cnt >  MINCNT && !mapCount.containsKey(sub)) {
							mapCount.put(sub, cnt);
						}
					}
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

	public static int numberOfOccurrence(String fullString, String subString) {
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
