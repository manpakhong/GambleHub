package com.rabbitforever.gamblehub.services.helpers;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.rabbitforever.gamblehub.controllers.helpers.GambleControllerHelper;
import com.rabbitforever.gamblehub.models.dtos.BaccaratDto;
import com.rabbitforever.gamblehub.models.eos.BaccaratEo;

public class GambleControllerHelperTest {

	@Test
	public void testParseCommonDateTimeStringToDate() {
		GambleControllerHelper helper = null;
		try {
			helper = new GambleControllerHelper();
			BaccaratDto dto = new BaccaratDto();
			dto.setCreateDateString("20190216_2256");
			BaccaratEo eo = new BaccaratEo();
			helper.parseCommonDateTimeStringToDate(dto, eo);
		} catch (Exception e) {
			fail("Exception caught!-" + e);
		}
	}

}
