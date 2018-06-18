package com.rabbitforever.gamblehub.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rabbitforever.gamblehub.models.eos.BigSmallEo;
import com.rabbitforever.gamblehub.models.sos.BigSmallSo;
import com.rabbitforever.gamblehub.services.GambleService;

@Controller
public class GambleController {
	private final Logger logger = LoggerFactory.getLogger(getClassName());

	private String getClassName() {
		return this.getClass().getName();
	}

	@Autowired
	private GambleService gambleService;

	@PostMapping("/gambleList")
	public String read(@ModelAttribute("bigSmallSo") @Valid BigSmallSo so, BindingResult result, Model model) {
		List<BigSmallEo> bigSmallEoList = null;

		try {
			// if (result.hasErrors()) {
			// model.addAttribute("bigSmallEoList", gambleService.read());
			// return "editUsers";
			// }

			bigSmallEoList = gambleService.read(so);
			model.addAttribute("bigSmallEoList", bigSmallEoList);
		} catch (Exception e) {
			logger.error(getClassName() + ".read() - so=" + so, e);
		}
		return "redirect:/";
	}
}
