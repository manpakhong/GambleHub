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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.rabbitforever.gamblehub.helpers.GambleControllerHelper;
import com.rabbitforever.gamblehub.models.eos.BigSmallEo;
import com.rabbitforever.gamblehub.models.sos.BigSmallSo;
import com.rabbitforever.gamblehub.models.sos.OrderedBy;
import com.rabbitforever.gamblehub.services.GambleMgr;

@Controller
public class GambleController {
	private final Logger logger = LoggerFactory.getLogger(getClassName());
	private GambleControllerHelper helper;
	public GambleController() {
		helper = new GambleControllerHelper();
	}
	private String getClassName() {
		return this.getClass().getName();
	}

	@Autowired
	private GambleMgr gambleService;

	@RequestMapping(value = "/rest/getBigSmallList", method = RequestMethod.GET)
	public @ResponseBody String getBigSmallList() {
		List<BigSmallEo> bigSmallEoList = null;
		BigSmallSo so = null;
		Gson gson = null;
		String json = null;
		try {
			// if (result.hasErrors()) {
			// model.addAttribute("bigSmallEoList", gambleService.read());
			// return "editUsers";
			// }
			gson = new Gson();
			so = new BigSmallSo();
			bigSmallEoList = gambleService.read(so);

			json = gson.toJson(bigSmallEoList);
		} catch (Exception e) {
			logger.error(getClassName() + ".getBigSmallList() - so=" + so, e);
		}
		
		return json;
	}
	
	@GetMapping("/estimate_next")
	public String retrieveEstimate(@ModelAttribute("bigSmallSo") @Valid BigSmallSo so, BindingResult result, Model model) {
		List<BigSmallEo> bigSmallEoList = null;

		try {
			// if (result.hasErrors()) {
			// model.addAttribute("bigSmallEoList", gambleService.read());
			// return "editUsers";
			// }

			bigSmallEoList = gambleService.read(so);
			String s = helper.getStringFromBigSmallEoList(bigSmallEoList);
			String nextBettingSuggestion = gambleService.getNextBettingSuggestion(s);
			if (nextBettingSuggestion == null) {
				nextBettingSuggestion = "Nondeterministic";
			}
			model.addAttribute("bigSmallEoList", bigSmallEoList);
			model.addAttribute("nextBettingSuggestion", nextBettingSuggestion);
		} catch (Exception e) {
			logger.error(getClassName() + ".read() - so=" + so, e);
		}
		return "estimate_next";
	}

	
	@GetMapping("/")
	public String read(@ModelAttribute("bigSmallSo") @Valid BigSmallSo so, BindingResult result, Model model) {
		List<BigSmallEo> bigSmallEoList = null;

		try {
			// if (result.hasErrors()) {
			// model.addAttribute("bigSmallEoList", gambleService.read());
			// return "editUsers";
			// }
			OrderedBy orderedBy = new OrderedBy();
			orderedBy.setDesc("id");
			so.addOrderedBy(orderedBy);
			
			bigSmallEoList = gambleService.read(so);

			
			model.addAttribute("bigSmallEoList", bigSmallEoList);
		} catch (Exception e) {
			logger.error(getClassName() + ".read() - so=" + so, e);
		}
		return "gambleHub";
	}

    @ModelAttribute("bigSmallEo")
    public BigSmallEo formBackingObject() {
        return new BigSmallEo();
    }
    @PostMapping("/addResult")
    public String create(@ModelAttribute("bigSmallEo") @Valid BigSmallEo eo,
                            BindingResult result, Model model) {
		List<BigSmallEo> bigSmallEoList = null;
		BigSmallSo so = null;
		try {
			 so = new BigSmallSo();
		bigSmallEoList = gambleService.read(so);
        if (result.hasErrors()) {
            model.addAttribute("bigSmallEoList", bigSmallEoList);
            return "gambleHub";
        }
 
        gambleService.create(eo);
		} catch (Exception e) {
			logger.error(getClassName() + ".create() - eo=" + eo, e);
		}
        return "redirect:/";
    }
}
