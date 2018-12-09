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

import com.alissoncs.entity.Professor;
import com.alissoncs.entity.Pessoa;
import com.alissoncs.service.ProfessorService;
import com.alissoncs.service.PessoaService;

@Component
@Scope("view")
public class ProfessorBean implements ApplicationContextAware {
	
    private ApplicationContext context;
    
    private MainBean main;
    
    // lista de Professors
    private List<Professor> lista = new ArrayList<Professor>();
    
    @Autowired
    private ProfessorService alunoService;
    
    @Autowired
    private PessoaService pessoaService;
	
    // campos
	public String nome;

	public String pessoaId;
	
	public String formacao;
	
	public List<Pessoa> pessoas;
	
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
	public String getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(String id) {
		this.pessoaId = id;
	}

	public List<Professor> getLista() {
		return this.lista;
	}
	public void setLista(List<Professor> lista) {
		this.lista = lista;
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	@PostConstruct
	public void carregarLista() {
		this.main.clear();
		try {
			List<Professor> lista = alunoService.fetch();
			
			System.out.println("[Carregar Professor] size: " + lista.size());
			this.setLista(lista);
			
			this.setPessoas(pessoaService.fetch());
			System.out.println("[Carregar pessoas] size: " + this.getPessoas().size());
			
		} catch (Exception e) {
			this.main.setErrorMessage(e.getMessage());
		}
	}
	
	public void salvar() {
		System.out.println("[Salvar Professor] pessoaId: " + this.pessoaId);
		
		Professor d = new Professor();
		d.setFormacao(this.formacao);
		Pessoa pessoa = new Pessoa();
		pessoa.setId(Long.parseLong(this.pessoaId));
		d.setPessoa(pessoa);
		
		try {
			d = alunoService.save(d);
			
			this.formacao = null;
			this.setPessoaId(null);
			this.main.setSuccessMessage("OK");
			this.lista = alunoService.fetch();
			
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
