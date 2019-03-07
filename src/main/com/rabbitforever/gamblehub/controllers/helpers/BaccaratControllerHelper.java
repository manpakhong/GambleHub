package com.rabbitforever.gamblehub.controllers.helpers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitforever.common.factories.UtilsFactory;
import com.rabbitforever.common.utils.DateUtils;
import com.rabbitforever.gamblehub.models.dtos.BaccaratDto;
import com.rabbitforever.gamblehub.models.eos.BaccaratEo;

public class BaccaratControllerHelper {
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private UtilsFactory utilsFactory;
	private DateUtils dateUtils;
	
	public BaccaratControllerHelper() throws Exception{
		utilsFactory = UtilsFactory.getInstance();
		dateUtils = utilsFactory.getInstanceOfDateUtils();
	}
	private String getClassName(){
		return this.getClass().getName();
	}	
	
	public List<BaccaratDto> transformToBaccaratDtoList(List<BaccaratEo> baccaratEoList) throws Exception {
		List<BaccaratDto> baccaratDtoList = null;
		try {
			if (baccaratEoList != null) {
				baccaratDtoList = new ArrayList<BaccaratDto>();
				for (BaccaratEo baccaratEo: baccaratEoList) {
					BaccaratDto baccaratDto = new BaccaratDto(baccaratEo);
					baccaratDtoList.add(baccaratDto);
				}
			}
		} catch (Exception e) {
			logger.error(getClassName() + ".transformToBaccaratDtoList() - baccaratEoList=" + baccaratEoList, e);
			throw e; 
		}
		return baccaratDtoList;
	}
	public String renderBaccaratTable(List<BaccaratDto> baccaratDtoList) throws Exception{
		StringBuilder sbHtml = null;
		try {
			sbHtml = new StringBuilder();
			
			
			
			sbHtml.append("<table class=\"baccaratTable\">");
				sbHtml.append("<thead>");
					sbHtml.append("<tr>");
						sbHtml.append("<th></th>");
						sbHtml.append("<th>Session</th>");
						sbHtml.append("<th>Round</th>");
						sbHtml.append("<th>Input</th>");
						sbHtml.append("<th>Count</th>");
						sbHtml.append("<th>Odd/Even</th>");
					sbHtml.append("</tr>");
				sbHtml.append("</thead>");
				sbHtml.append("<tbody class=\"baccaratTableTbody\">");
					sbHtml.append(renderBaccaratTableTrTopRow(baccaratDtoList));
					sbHtml.append(renderBaccaratTableTrDataRow(baccaratDtoList));
				sbHtml.append("</tbody>");
			sbHtml.append("</table>");
		} catch (Exception e) {
			logger.error(getClassName() + ".renderBaccaratTable()", e);
			throw e;
		}
		return sbHtml.toString();
	}
	public String renderBaccaratTableTrDataRow(List<BaccaratDto> baccaratDtoList) throws Exception {
		StringBuilder sbHtml = null;
		try {
			sbHtml = new StringBuilder();
			
			for (BaccaratDto baccaratDto: baccaratDtoList) {
				sbHtml.append("<tr>");
				sbHtml.append("<td>");
					sbHtml.append("<input type=\"button\" value=\"Delete\" class=\"addNewButton\" onclick=\"deleteButton_onclick(event)\"/>");
					sbHtml.append("<input type=\"button\" value=\"Edit\" class=\"addNewButton\" onclick=\"editButton_onclick(event)\"/>");
				sbHtml.append("</td>");
				sbHtml.append("<td>");
					sbHtml.append("<input type=\"text\" value=\"" +baccaratDto.getSession() + "\" class=\"sessionInput\"/>");
				sbHtml.append("</td>");
				sbHtml.append("<td>");
					sbHtml.append("<input type=\"text\" value=\""  + baccaratDto.getRound() + "\" class=\"roundInput\" />");
				sbHtml.append("</td>");
				sbHtml.append("<td>");
					sbHtml.append("<input type=\"text\" value=\""  + baccaratDto.getResult() + "\" class=\"resultInput\" onkeydown=\"resultInput_onkeydown(event)\" onchange=\"resultInput_onchange(event)\" />");
				sbHtml.append("</td>");
				sbHtml.append("<td>");
					sbHtml.append("<label for=\"count\" class=\"countLabel\">"  + baccaratDto.getCount() + "</label>");
				sbHtml.append("</td>");
				sbHtml.append("<td>");
					sbHtml.append("<label for=\"oddEven\" class=\"oddEvenLabel\">"  + baccaratDto.getOddEven() + "</label>");
				sbHtml.append("</td>");
			sbHtml.append("</tr>");
			}


		} catch (Exception e) {
			logger.error(getClassName() + ".renderBaccaratTableTrTopRow()", e);
			throw e;
		}
		return sbHtml.toString();
	}
	public String renderBaccaratTableTrTopRow(List<BaccaratDto> baccaratDtoList) throws Exception {
		StringBuilder sbHtml = null;
		try {
			sbHtml = new StringBuilder();
			sbHtml.append("<tr>");
				sbHtml.append("<td>");
					sbHtml.append("<input type=\"button\" value=\"Add\" class=\"addNewButton\" onclick=\"addNewButton_onclick(event)\"/>");
				sbHtml.append("</td>");
				sbHtml.append("<td>");
					sbHtml.append("<input type=\"text\" value=\"" + dateUtils.getDateParamString() + "\" class=\"sessionInput\"/>");
				sbHtml.append("</td>");
				sbHtml.append("<td>");
					sbHtml.append("<input type=\"text\" value=\"\" class=\"roundInput\" />");
				sbHtml.append("</td>");
				sbHtml.append("<td>");
					sbHtml.append("<input type=\"text\" value=\"\" class=\"resultInput\" onkeydown=\"resultInput_onkeydown(event)\" onchange=\"resultInput_onchange(event)\" />");
				sbHtml.append("</td>");
				sbHtml.append("<td>");
					sbHtml.append("<label for=\"count\" class=\"countLabel\"></label>");
				sbHtml.append("</td>");
				sbHtml.append("<td>");
					sbHtml.append("<label for=\"oddEven\" class=\"oddEvenLabel\"></label>");
				sbHtml.append("</td>");
			sbHtml.append("</tr>");

		} catch (Exception e) {
			logger.error(getClassName() + ".renderBaccaratTableTrTopRow()", e);
			throw e;
		}
		return sbHtml.toString();
	}
}
