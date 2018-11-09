package com.back2code.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.back2code.springframework.sfgpetclinic.services.VetService;

@Controller
//@RequestMapping("/vets") -- Not needed mapping in method call
public class VetController {

	private final VetService vetService;
	
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@RequestMapping({"/vets.html", "/vets", "/vets/index", "/vets/index.html" })
	public String listVets(Model model) {
		
		model.addAttribute("vets", vetService.findAll());
		
		return "vets/index";
	}
}
