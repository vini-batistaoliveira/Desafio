package com.vinicius.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinicius.desafio.model.Funcionario;
import com.vinicius.desafio.model.Skill;

//classe que extende as funcionalidades do JpaRepository para acesso ao banco

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
	
}
