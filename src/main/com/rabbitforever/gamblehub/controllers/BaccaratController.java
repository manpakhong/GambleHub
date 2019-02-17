package com.rabbitforever.gamblehub.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.rabbitforever.gamblehub.controllers.helpers.ControllerHelper;
import com.rabbitforever.gamblehub.controllers.helpers.GambleControllerHelper;
import com.rabbitforever.gamblehub.models.dtos.BaccaratDto;
import com.rabbitforever.gamblehub.models.dtos.BaccaratRequestDto;
import com.rabbitforever.gamblehub.models.eos.BaccaratEo;
import com.rabbitforever.gamblehub.models.sos.BaccaratSo;
import com.rabbitforever.gamblehub.models.vos.BaccaratVo;
import com.rabbitforever.gamblehub.services.BaccaratMgr;

@Controller
@RequestMapping("/baccarat")
public class BaccaratController {
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private GambleControllerHelper helper;
	public BaccaratController() throws Exception{
		helper = new GambleControllerHelper();
	}
	private String getClassName() {
		return this.getClass().getName();
	}

	@Autowired
	private BaccaratMgr baccaratService;
//
//	@RequestMapping(value = "/rest/getBigSmallList", method = RequestMethod.GET)
//	public @ResponseBody String getBigSmallList() {
//		List<BigSmallEo> bigSmallEoList = null;
//		BigSmallSo so = null;
//		Gson gson = null;
//		String json = null;
//		try {
//			// if (result.hasErrors()) {
//			// model.addAttribute("bigSmallEoList", gambleService.read());
//			// return "editUsers";
//			// }
//			gson = new Gson();
//			so = new BigSmallSo();
//			bigSmallEoList = gambleService.read(so);
//
//			json = gson.toJson(bigSmallEoList);
//		} catch (Exception e) {
//			logger.error(getClassName() + ".getBigSmallList() - so=" + so, e);
//		}
//		
//		return json;
//	}
//	
	@GetMapping("load")
	public String getBaccarat(@ModelAttribute("baccaratSo") @Valid BaccaratSo so, BindingResult result, Model model) {
		BaccaratVo vo = null;
		List<BaccaratEo> baccaratEoList = null;
		Integer round = null;
		try {
			vo = new BaccaratVo();
			// if (result.hasErrors()) {
			// model.addAttribute("bigSmallEoList", gambleService.read());
			// return "editUsers";
			// }
			if (so == null) {
				so = new BaccaratSo();
			}
			
			
			baccaratEoList = baccaratService.read(so);
			vo.setBaccaratEoList(baccaratEoList);

			model.addAttribute("baccaratEoList", baccaratEoList);
			model.addAttribute("vo", vo);
		} catch (Exception e) {
			logger.error(getClassName() + ".read() - so=" + so, e);
		}
		return "baccarat";
	}
//
//	
//	@GetMapping("/")
//	public String read(@ModelAttribute("bigSmallSo") @Valid BigSmallSo so, BindingResult result, Model model) {
//		List<BigSmallEo> bigSmallEoList = null;
//
//		try {
//			// if (result.hasErrors()) {
//			// model.addAttribute("bigSmallEoList", gambleService.read());
//			// return "editUsers";
//			// }
//			OrderedBy orderedBy = new OrderedBy();
//			orderedBy.setDesc("id");
//			so.addOrderedBy(orderedBy);
//			
//			bigSmallEoList = gambleService.read(so);
//
//			
//			model.addAttribute("bigSmallEoList", bigSmallEoList);
//		} catch (Exception e) {
//			logger.error(getClassName() + ".read() - so=" + so, e);
//		}
//		return "gambleHub";
//	}
//
//    @ModelAttribute("bigSmallEo")
//    public BigSmallEo formBackingObject() {
//        return new BigSmallEo();
//    }
    @RequestMapping(value = "addBaccarat", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody String jsonString) {
//		List<BigSmallEo> bigSmallEoList = null;
//		BigSmallSo so = null;
    	GambleControllerHelper gambleControllerHelper = null;
    	BaccaratMgr baccaratMgr = null;
		try {
			Gson gson = new Gson();
			BaccaratRequestDto baccaratRequestDto = gson.fromJson(jsonString, BaccaratRequestDto.class);
			String command = baccaratRequestDto.getCommand();
			String className = baccaratRequestDto.getDataClassName();
			BaccaratDto baccaratDto = baccaratRequestDto.getDataInstance();
			gambleControllerHelper = new GambleControllerHelper();
			
			
			gambleControllerHelper.parseCommonDateTimeStringToDate(baccaratDto);
			baccaratMgr = new BaccaratMgr();
			baccaratMgr.create(baccaratDto);
//			BaccaratDto baccaratDto = requestDto.get
//			 so = new BigSmallSo();
//			 bigSmallEoList = gambleService.read(so);
//        if (result.hasErrors()) {
//            model.addAttribute("bigSmallEoList", bigSmallEoList);
//            return "baccarat";
//        }
// 
			
//			baccaratMgr.create(eo);
			String json = jsonString.toString();
		} catch (Exception e) {
			logger.error(getClassName() + ".create() - jsonString=" + jsonString, e);
		} finally {
			baccaratMgr = null;
			gambleControllerHelper = null;
		}
        return "{helo: 'helo'}";
    }
}
