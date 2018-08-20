package com.vinicius.desafio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//Classe Model com os atributos que serão criados no banco de dados do funcionário
//Banco H2 local foi utilizado
//Os valores que foram colocados no banco para teste estão na classe DesafioApplication, classe main do SpringAplication

@Entity
public class Funcionario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="salario")
	private Double salario;
	
	@Column(name="cargo")
	private String cargo;
	
	@ManyToMany(mappedBy="funcionario")
	private List<Skill> skill = new ArrayList<>();
	
	public Funcionario() {
	}

	public Funcionario(Integer id, String nome, Double salario, String cargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.salario = salario;
		this.cargo = cargo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public List<Skill> getSkill() {
		return skill;
	}

	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}
	
	
	
	

}