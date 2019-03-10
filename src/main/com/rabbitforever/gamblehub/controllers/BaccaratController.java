package com.rabbitforever.gamblehub.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	private final Logger logger = LogManager.getLogger(getClassName());
	private BaccaratControllerHelper helper;
	private String session;
	public BaccaratController() throws Exception{
		helper = new BaccaratControllerHelper();
	}
	private String getClassName() {
		return this.getClass().getName();
	}

	@Autowired
	private BaccaratMgr baccaratMgr;
	@Autowired
	private GambleMgr gambleMgr;

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
	 @RequestMapping(value = "load_result", method = { RequestMethod.POST, RequestMethod.GET })
	public String getBaccaratResult(@RequestParam(value="session", required=false) String session, @ModelAttribute("baccaratSo") @Valid BaccaratSo so, BindingResult result, Model model) {
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
//			baccaratEoList = baccaratMgr.read(so);

			String tableHtmlString = renderEstimateBaccaratResultTable(session);
			vo.setTableHtml(tableHtmlString);
			String inputFilterHtml = renderInputFilterControls(session);

			vo.setFilterInputHtml(inputFilterHtml);
			vo.setTableHtml(tableHtmlString);
			model.addAttribute("baccaratEoList", baccaratEoList);

			model.addAttribute("vo", vo);
		} catch (Exception e) {
			logger.error(getClassName() + ".read() - so=" + so, e);
		}
		return "baccarat_result";
	}
	
	 public String renderInputFilterControls(String session) throws Exception {
		 String html = null;
		 try {
			 html = helper.renderFilterInput(session);
		} catch (Exception e) {
			logger.error(getClassName() + ".renderInputFilterControls() - session=" + session, e);
		}
		 return html;
	 }

	 @RequestMapping(value = "load", method = { RequestMethod.POST, RequestMethod.GET })
	public String getBaccarat(@RequestParam(value="session", required=false) String session,@ModelAttribute("baccaratSo") @Valid BaccaratSo so, BindingResult result, Model model) {
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
			
			this.session = session;
			baccaratEoList = baccaratMgr.read(so);
//			vo.setBaccaratDtoList(baccaratDtoList);
			String tableHtmlString = renderInputBaccaratTable(session);
			vo.setTableHtml(tableHtmlString);
			String inputFilterHtml = renderInputFilterControls(session);

			vo.setFilterInputHtml(inputFilterHtml);
			model.addAttribute("baccaratEoList", baccaratEoList);
			model.addAttribute("vo", vo);
		} catch (Exception e) {
			logger.error(getClassName() + ".read() - so=" + so, e);
		}
		return "baccarat";
	}
	    @RequestMapping(value = "deleteBaccarat", method = RequestMethod.POST)
	    @ResponseBody
	    public String delete(@RequestBody String jsonString) throws Exception{
//			List<BigSmallEo> bigSmallEoList = null;
//			BigSmallSo so = null;
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
				baccaratMgr.delete(baccaratEo);
//				BaccaratDto baccaratDto = requestDto.get
//				 so = new BigSmallSo();
//				 bigSmallEoList = gambleService.read(so);
//	        if (result.hasErrors()) {
//	            model.addAttribute("bigSmallEoList", bigSmallEoList);
//	            return "baccarat";
//	        }
	// 

//				baccaratMgr.create(eo);
				
				baccaratReponseDto = new BaccaratReponseDto();
				baccaratReponseDto.setBaccaratDto(baccaratDto);

				baccaratReponseDto.setIsSuccess(true);


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
    @RequestMapping(value = "createBaccarat", method = RequestMethod.POST)
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
			baccaratDto.setId(baccaratEo.getId());
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
    
    @RequestMapping(value = "updateBaccarat", method = RequestMethod.POST)
    @ResponseBody
    public String update(@RequestBody String jsonString) throws Exception{
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
			baccaratMgr.update(baccaratEo);
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

			baccaratReponseDto.setIsSuccess(true);

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
    

    public String renderBaccaratResult(String session) throws Exception{
    	List<BaccaratEo> baccaratEoList = null;
    	String renderHtmlString = null;
    	List<BaccaratDto> baccaratDtoList = null;
    	try {
    		BaccaratSo baccaratSo = new BaccaratSo();
    		baccaratSo.setSession(session);
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
    public String renderEstimateBaccaratResultTable(String session) throws Exception{
    	String renderHtmlString = null;
    	List<BaccaratEo> baccaratEoList = null;
    	List<BaccaratDto> baccaratDtoList = null;
    	
    	List<BaccaratEo> baccaratEoBankerList = null;
    	List<BaccaratDto> baccaratDtoBankerList = null;
    	
    	List<BaccaratEo> baccaratEoPlayerList = null;
    	List<BaccaratDto> baccaratDtoPlayerList = null;
    	
    	try {
    		BaccaratSo baccaratSo = new BaccaratSo();
    		baccaratSo.setSession(session);
    		if (baccaratMgr == null) {
    			baccaratMgr = new  BaccaratMgr();
    		}
    		OrderedBy orderBySession = new OrderedBy();
    		orderBySession.setAsc("session");
    		OrderedBy orderedByRound = new OrderedBy();
    		orderedByRound.setAsc("round");
    		baccaratSo.addOrderedBy(orderBySession);
    		baccaratSo.addOrderedBy(orderedByRound);
			baccaratEoList = baccaratMgr.read(baccaratSo);
			baccaratDtoList = helper.transformToBaccaratDtoList(baccaratEoList);
			
			
			// banker
    		BaccaratSo baccaratBankerSo = new BaccaratSo();
    		baccaratBankerSo.setSession(session);
    		OrderedBy orderBySessionBanker = new OrderedBy();
    		orderBySessionBanker.setAsc("session");
    		OrderedBy orderedByRoundBanker = new OrderedBy();
    		orderedByRoundBanker.setAsc("round");
    		baccaratBankerSo.setBankPlayer("B");
    		baccaratBankerSo.addOrderedBy(orderBySessionBanker);
    		baccaratBankerSo.addOrderedBy(orderedByRoundBanker);
			baccaratEoBankerList = baccaratMgr.read(baccaratBankerSo);
			baccaratDtoBankerList = helper.transformToBaccaratDtoList(baccaratEoBankerList);
			
			
			// player
    		BaccaratSo baccaratPlayerSo = new BaccaratSo();
    		baccaratPlayerSo.setSession(session);
    		OrderedBy orderBySessionPlayer = new OrderedBy();
    		orderBySessionPlayer.setAsc("session");
    		OrderedBy orderedByRoundPlayer = new OrderedBy();
    		orderedByRoundPlayer.setAsc("round");
    		baccaratPlayerSo.setBankPlayer("P");
    		baccaratPlayerSo.addOrderedBy(orderBySessionPlayer);
    		baccaratPlayerSo.addOrderedBy(orderedByRoundPlayer);
			baccaratEoPlayerList = baccaratMgr.read(baccaratPlayerSo);
			baccaratDtoPlayerList = helper.transformToBaccaratDtoList(baccaratEoPlayerList);
			
			
    		if (gambleMgr == null) {
    			gambleMgr = new GambleMgrImp();
    		}

			String b = helper.getBankerStringFromBaccaratDtoList(baccaratDtoBankerList);
			String p = helper.getBankerStringFromBaccaratDtoList(baccaratDtoPlayerList);
			String nextBBettingSuggestion = gambleMgr.getNextBettingSuggestion(b);
			if (nextBBettingSuggestion == null) {
				nextBBettingSuggestion = "Non-deterministic";
			}
			
			String nextPBettingSuggestion = gambleMgr.getNextBettingSuggestion(p);
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
    public String renderInputBaccaratTable(String session) throws Exception{
    	List<BaccaratEo> baccaratEoList = null;
    	String renderHtmlString = null;
    	List<BaccaratDto> baccaratDtoList = null;
    	try {
    		BaccaratSo baccaratSo = new BaccaratSo();

    		if (baccaratMgr == null) {
    			baccaratMgr = new  BaccaratMgr();
    		}
    		baccaratSo.setSession(session);
    		OrderedBy orderBySession = new OrderedBy();
    		orderBySession.setDesc("session");
    		OrderedBy orderedByRound = new OrderedBy();
    		orderedByRound.setDesc("round");
    		baccaratSo.addOrderedBy(orderBySession);
    		baccaratSo.addOrderedBy(orderedByRound);
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
}
