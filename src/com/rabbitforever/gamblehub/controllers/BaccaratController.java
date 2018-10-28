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
import org.springframework.web.bind.annotation.PostMapping;

import com.rabbitforever.gamblehub.helpers.GambleControllerHelper;
import com.rabbitforever.gamblehub.models.eos.BaccaratEo;
import com.rabbitforever.gamblehub.models.eos.BigSmallEo;
import com.rabbitforever.gamblehub.models.sos.BaccaratSo;
import com.rabbitforever.gamblehub.models.sos.BigSmallSo;
import com.rabbitforever.gamblehub.services.BaccaratService;

@Controller
public class BaccaratController {
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private GambleControllerHelper helper;
	public BaccaratController() {
		helper = new GambleControllerHelper();
	}
	private String getClassName() {
		return this.getClass().getName();
	}

	@Autowired
	private BaccaratService baccaratService;
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
	@GetMapping("/baccarat")
	public String getBaccarat(@ModelAttribute("baccaratSo") @Valid BaccaratSo so, BindingResult result, Model model) {
		List<BaccaratEo> baccaratEoList = null;

		try {
			// if (result.hasErrors()) {
			// model.addAttribute("bigSmallEoList", gambleService.read());
			// return "editUsers";
			// }
			if (so == null) {
				so = new BaccaratSo();
			}
			baccaratEoList = baccaratService.read(so);


			model.addAttribute("baccaratEoList", baccaratEoList);

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
    @PostMapping("/addBaccarat")
    public String create(@ModelAttribute("baccaratEo") @Valid BaccaratEo eo,
                            BindingResult result, Model model) {
//		List<BigSmallEo> bigSmallEoList = null;
//		BigSmallSo so = null;
		try {
//			 so = new BigSmallSo();
//			 bigSmallEoList = gambleService.read(so);
//        if (result.hasErrors()) {
//            model.addAttribute("bigSmallEoList", bigSmallEoList);
//            return "baccarat";
//        }
// 

		} catch (Exception e) {
			logger.error(getClassName() + ".create() - eo=" + eo, e);
		}
        return "redirect:/";
    }
}
