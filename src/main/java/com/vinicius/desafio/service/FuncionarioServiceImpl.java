package com.vinicius.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.desafio.model.Funcionario;
import com.vinicius.desafio.repository.FuncionarioRepository;

//classe que implementa as funções da interface service, para ter acesso aos serviços da classe JPA que foi extendida na service

@Service("funcionarioService")
public class FuncionarioServiceImpl implements FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	public List<Funcionario> getAllFuncionario() {
		return funcionarioRepository.findAll();
	}

}
