package com.rabbitforever.gamblehub.services.helpers;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import com.rabbitforever.gamblehub.controllers.helpers.GambleControllerHelper;
import com.rabbitforever.gamblehub.models.dtos.BaccaratDto;

public class GambleControllerHelperTest {

	@Test
	public void testParseCommonDateTimeStringToDate() {
		GambleControllerHelper helper = null;
		try {
			helper = new GambleControllerHelper();
			BaccaratDto dto = new BaccaratDto();
			dto.setCreateDateString("20190216_225601");
			dto.setUpdateDateString("20190217_021600");
			helper.parseCommonDateTimeStringToDate(dto);
			Assert.assertTrue(dto.getCreateDate() != null && dto.getUpdateDate() != null);
		} catch (Exception e) {
			fail("Exception caught!-" + e);
		}
	}

}
