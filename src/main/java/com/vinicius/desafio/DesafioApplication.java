package com.vinicius.desafio;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vinicius.desafio.model.Funcionario;
import com.vinicius.desafio.model.Skill;
import com.vinicius.desafio.repository.FuncionarioRepository;
import com.vinicius.desafio.repository.SkillRepository;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {
	
	@Autowired
	private SkillRepository skillRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Funcionario f1 = new Funcionario(null, "Joao", 1000.00, "Atendente");
		Funcionario f2 = new Funcionario(null, "Maria", 11000.00, "Desenvolvedor");
		Funcionario f3 = new Funcionario(null, "Marco", 1389.00, "Gerente");
		Funcionario f4 = new Funcionario(null, "Jessica", 2000.00, "Gerente");
		Funcionario f5 = new Funcionario(null, "Clayton", 3000.00, "RH");
		Funcionario f6 = new Funcionario(null, "Denis", 32000.00, "Atendente");
		Funcionario f7 = new Funcionario(null, "Kelly", 1100.00, "Financeiro");
		Funcionario f8 = new Funcionario(null, "Jade", 1304.00, "Compras");
		Funcionario f9 = new Funcionario(null, "Felipe", 7000.00, "Desenvolvedor");
		
		Skill s1 = new Skill(null, "Java");
		Skill s2 = new Skill(null, "Oracle");
		Skill s3 = new Skill(null, "React");
		Skill s4 = new Skill(null, "PHP");
		Skill s5 = new Skill(null, "MySQL");
		
		s1.getFuncionario().addAll(Arrays.asList(f1, f4, f5, f7, f8, f9));
		s2.getFuncionario().addAll(Arrays.asList(f1, f2, f3, f4, f5, f6, f8, f9));
		s3.getFuncionario().addAll(Arrays.asList(f2, f8, f3));
		s4.getFuncionario().addAll(Arrays.asList(f4, f8));
		s5.getFuncionario().addAll(Arrays.asList(f7, f8));
		
		f1.getSkill().addAll(Arrays.asList(s1, s2));
		f2.getSkill().addAll(Arrays.asList(s3, s2));
		f3.getSkill().addAll(Arrays.asList(s2, s3));
		f4.getSkill().addAll(Arrays.asList(s1, s2, s4));
		f5.getSkill().addAll(Arrays.asList(s1, s2));
		f6.getSkill().addAll(Arrays.asList(s3, s2));
		f7.getSkill().addAll(Arrays.asList(s5, s1));
		f8.getSkill().addAll(Arrays.asList(s1, s2, s3, s4, s5));
		f9.getSkill().addAll(Arrays.asList(s1, s2));
		
		funcionarioRepository.saveAll(Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9));
		skillRepository.saveAll(Arrays.asList(s1, s2, s3, s4, s5));
		
	}
}
