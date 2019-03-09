package com.rabbitforever.gamblehub.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
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
import com.rabbitforever.gamblehub.controllers.helpers.BaccaratControllerHelper;
import com.rabbitforever.gamblehub.controllers.helpers.GambleControllerHelper;
import com.rabbitforever.gamblehub.models.dtos.BaccaratDto;
import com.rabbitforever.gamblehub.models.dtos.BaccaratReponseDto;
import com.rabbitforever.gamblehub.models.dtos.BaccaratRequestDto;
import com.rabbitforever.gamblehub.models.eos.BaccaratEo;
import com.rabbitforever.gamblehub.models.sos.BaccaratSo;
import com.rabbitforever.gamblehub.models.sos.OrderedBy;
import com.rabbitforever.gamblehub.models.vos.BaccaratVo;
import com.rabbitforever.gamblehub.services.BaccaratMgr;
import com.rabbitforever.gamblehub.services.GambleMgr;
import com.rabbitforever.gamblehub.services.GambleMgrImp;

@Controller
@RequestMapping("/baccarat")
public class BaccaratController {
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private BaccaratControllerHelper helper;
	public BaccaratController() throws Exception{
		helper = new BaccaratControllerHelper();
	}
	private String getClassName() {
		return this.getClass().getName();
	}

	@Autowired
	private BaccaratMgr baccaratMgr;
	@Autowired
	private GambleMgr gambleService1;
	@Autowired
	private GambleMgr gambleService2;
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
	@GetMapping("load_result")
	public String getBaccaratResult(@ModelAttribute("baccaratSo") @Valid BaccaratSo so, BindingResult result, Model model) {
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
			
			
			baccaratEoList = baccaratMgr.read(so);
//			vo.setBaccaratDtoList(baccaratDtoList);

			model.addAttribute("baccaratEoList", baccaratEoList);
			model.addAttribute("vo", vo);
		} catch (Exception e) {
			logger.error(getClassName() + ".read() - so=" + so, e);
		}
		return "baccarat_result";
	}
	
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
			
			
			baccaratEoList = baccaratMgr.read(so);
//			vo.setBaccaratDtoList(baccaratDtoList);

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
    public String create(@RequestBody String jsonString) throws Exception{
//		List<BigSmallEo> bigSmallEoList = null;
//		BigSmallSo so = null;
    	GambleControllerHelper gambleControllerHelper = null;
    	BaccaratMgr baccaratMgr = null;
    	BaccaratReponseDto baccaratReponseDto = null;
    	String reponseJsonString = null;
    	Gson gson = null;
		try {
			gson = new Gson();
			BaccaratRequestDto baccaratRequestDto = gson.fromJson(jsonString, BaccaratRequestDto.class);
			String command = baccaratRequestDto.getCommand();
			String className = baccaratRequestDto.getDataClassName();
			BaccaratDto baccaratDto = baccaratRequestDto.getDataInstance();
			gambleControllerHelper = new GambleControllerHelper();
			
			BaccaratEo baccaratEo = new BaccaratEo();
			BeanUtils.copyProperties(baccaratEo, baccaratDto);
			gambleControllerHelper.parseCommonDateTimeStringToDate(baccaratDto);
			baccaratMgr = new BaccaratMgr();
			baccaratMgr.create(baccaratEo);
//			BaccaratDto baccaratDto = requestDto.get
//			 so = new BigSmallSo();
//			 bigSmallEoList = gambleService.read(so);
//        if (result.hasErrors()) {
//            model.addAttribute("bigSmallEoList", bigSmallEoList);
//            return "baccarat";
//        }
// 

//			baccaratMgr.create(eo);
			
			baccaratReponseDto = new BaccaratReponseDto();
			baccaratReponseDto.setBaccaratDto(baccaratDto);
			if (baccaratEo.getId() != null) {
				baccaratReponseDto.setIsSuccess(true);
			} else {
				baccaratReponseDto.setIsSuccess(false);
			}
			reponseJsonString = gson.toJson(baccaratReponseDto);
		} catch (Exception e) {
			logger.error(getClassName() + ".create() - jsonString=" + jsonString, e);
			throw e;
		} finally {
			baccaratMgr = null;
			gambleControllerHelper = null;
		}
        return reponseJsonString;
    }
    
    public String renderBaccaratTable() throws Exception{
    	List<BaccaratEo> baccaratEoList = null;
    	String renderHtmlString = null;
    	List<BaccaratDto> baccaratDtoList = null;
    	try {
    		BaccaratSo baccaratSo = new BaccaratSo();
    		if (baccaratMgr == null) {
    			baccaratMgr = new  BaccaratMgr();
    		}
    		OrderedBy orderBy = new OrderedBy();
    		orderBy.setDesc("round");
    		baccaratSo.addOrderedBy(orderBy);
			baccaratEoList = baccaratMgr.read(baccaratSo);
			baccaratDtoList = helper.transformToBaccaratDtoList(baccaratEoList);
			
    		renderHtmlString = helper.renderBaccaratTable(baccaratDtoList);
    	} catch (Exception e) {
			logger.error(getClassName() + ".renderBaccaratTable() - baccaratEoList=" + baccaratEoList, e);
			throw e;
		} finally {
		}
    	return renderHtmlString;
    }
    public String renderBaccaratResult() throws Exception{
    	List<BaccaratEo> baccaratEoList = null;
    	String renderHtmlString = null;
    	List<BaccaratDto> baccaratDtoList = null;
    	try {
    		BaccaratSo baccaratSo = new BaccaratSo();
    		if (baccaratMgr == null) {
    			baccaratMgr = new  BaccaratMgr();
    		}
    		OrderedBy orderBy = new OrderedBy();
    		orderBy.setDesc("round");
    		baccaratSo.addOrderedBy(orderBy);
			baccaratEoList = baccaratMgr.read(baccaratSo);
			baccaratDtoList = helper.transformToBaccaratDtoList(baccaratEoList);
			
    		renderHtmlString = helper.renderBaccaratTable(baccaratDtoList);
    	} catch (Exception e) {
			logger.error(getClassName() + ".renderBaccaratTable() - baccaratEoList=" + baccaratEoList, e);
			throw e;
		} finally {
		}
    	return renderHtmlString;
    }
    public String renderBaccaratResultTable() throws Exception{
    	List<BaccaratEo> baccaratEoList = null;
    	String renderHtmlString = null;
    	List<BaccaratDto> baccaratDtoList = null;
    	
    	try {
    		BaccaratSo baccaratSo = new BaccaratSo();
    		if (baccaratMgr == null) {
    			baccaratMgr = new  BaccaratMgr();
    		}
    		OrderedBy orderBy = new OrderedBy();
    		orderBy.setAsc("round");
    		baccaratSo.addOrderedBy(orderBy);
			baccaratEoList = baccaratMgr.read(baccaratSo);
			baccaratDtoList = helper.transformToBaccaratDtoList(baccaratEoList);
			
    		if (gambleService1 == null) {
    			gambleService1 = new GambleMgrImp();
    		}
    		
    		if (gambleService2 == null) {
    			gambleService2 = new GambleMgrImp();
    		}
			String b = helper.getBankerStringFromBaccaratDtoList(baccaratDtoList);
			String p = helper.getBankerStringFromBaccaratDtoList(baccaratDtoList);
			String nextBBettingSuggestion = gambleService1.getNextBettingSuggestion(b);
			if (nextBBettingSuggestion == null) {
				nextBBettingSuggestion = "Non-deterministic";
			}
			
			String nextPBettingSuggestion = gambleService2.getNextBettingSuggestion(p);
			if (nextPBettingSuggestion == null) {
				nextPBettingSuggestion = "Non-deterministic";
			}
			
    		renderHtmlString = helper.renderBaccaratResultTable(baccaratDtoList, nextBBettingSuggestion, nextPBettingSuggestion);
    		

			
			
    	} catch (Exception e) {
			logger.error(getClassName() + ".renderBaccaratTable() - baccaratEoList=" + baccaratEoList, e);
			throw e;
		} finally {
		}
    	return renderHtmlString;
    }
}
