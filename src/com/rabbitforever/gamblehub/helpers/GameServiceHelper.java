package com.rabbitforever.gamblehub.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameServiceHelper {
	private final Logger logger = LoggerFactory.getLogger(getClassName());
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
}
