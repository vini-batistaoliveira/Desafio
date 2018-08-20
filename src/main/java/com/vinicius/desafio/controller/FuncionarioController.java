package com.vinicius.desafio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//mapeado o endpoint inicial da página, que é onde está a listagem de funcionarios

@Controller
public class FuncionarioController {
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String goHome(){
		return "index";
	}

}