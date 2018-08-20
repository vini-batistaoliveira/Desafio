package com.vinicius.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.desafio.model.Funcionario;
import com.vinicius.desafio.service.FuncionarioService;

//mapeado endpoint /funcionarios onde é feito o retorno do banco h2 e executa as listagens, apenas foi listado todo o conteudo do banco

@RestController
public class FuncionarioRestController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@RequestMapping(path="/funcionarios", method=RequestMethod.GET)
	public List<Funcionario> getAllEmployees(){
		return funcionarioService.getAllFuncionario();
	}
}