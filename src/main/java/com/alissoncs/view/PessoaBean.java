package com.alissoncs.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alissoncs.entity.Etnia;
import com.alissoncs.entity.Genero;
import com.alissoncs.entity.Pessoa;
import com.alissoncs.entity.Religiao;
import com.alissoncs.service.EtniaService;
import com.alissoncs.service.GeneroService;
import com.alissoncs.service.PessoaService;
import com.alissoncs.service.ReligiaoService;

@Component
@Scope("view")
public class PessoaBean implements ApplicationContextAware {
	
    private ApplicationContext context;
    
    private MainBean main;
    
    // lista de Etnias
    private List<Etnia> etnias = new ArrayList<Etnia>();
    private List<Religiao> religioes = new ArrayList<Religiao>();
    private List<Genero> generos = new ArrayList<Genero>();
    private List<Pessoa> pessoas = new ArrayList<Pessoa>();
    
    @Autowired
    private EtniaService etniaService;
    
    @Autowired
    private ReligiaoService religiaoService;
	
    @Autowired
    private GeneroService generoService;
    
    @Autowired
    private PessoaService pessoaService;
    
    // campos
	public String nome;
	
	public String etniaId;
	public String religiaoId;
	public String generoId;
	

	public List<Religiao> getReligioes() {
		return religioes;
	}
	public void setReligioes(List<Religiao> religioes) {
		this.religioes = religioes;
	}
	public List<Genero> getGeneros() {
		return generos;
	}
	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}
	public String getReligiaoId() {
		return religiaoId;
	}
	public void setReligiaoId(String religiaoId) {
		this.religiaoId = religiaoId;
	}
	public String getGeneroId() {
		return generoId;
	}
	public void setGeneroId(String generoId) {
		this.generoId = generoId;
	}
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	public String getEtniaId() {
		return etniaId;
	}
	public void setEtniaId(String etniaId) {
		this.etniaId = etniaId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Etnia> getEtnias() {
		return this.etnias;
	}
	public void setEtnias(List<Etnia> lista) {
		this.etnias = lista;
	}
	
	@PostConstruct
	public void carregarLista() {
		try {
			this.setEtnias(etniaService.fetch());
			this.setGeneros(generoService.fetch());
			this.setReligioes(religiaoService.fetch());
			
		} catch (Exception e) {
			this.main.setErrorMessage(e.getMessage());
		}
	}
	
	public void salvar() {
		System.out.println("[Salvar Pessoa] " + 
				"nome: "+ this.nome +
				", etniaId: " + this.etniaId +
				", generoId: " + this.generoId +
				", religiaoId: " + this.religiaoId);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(this.nome);
		
		Etnia etnia = new Etnia();
		etnia.setId(Long.parseLong(this.etniaId));
		pessoa.setEtnia(etnia);
		
		Religiao religiao = new Religiao();
		religiao.setId(Long.parseLong(this.religiaoId));
		pessoa.setReligiao(religiao);
		
		Genero genero = new Genero();
		genero.setId(Long.parseLong(this.generoId));
		pessoa.setGenero(genero);

		try {
			pessoaService.save(pessoa);
			this.nome = "";
			this.main.setSuccessMessage("OK");
		} catch (Exception ex) {
			this.main.setErrorMessage(ex.getMessage());
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
		this.main = applicationContext.getBean(MainBean.class);
	}
}
