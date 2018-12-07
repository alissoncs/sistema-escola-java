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

import com.alissoncs.entity.Deficiencia;
import com.alissoncs.entity.Genero;
import com.alissoncs.service.GeneroService;

@Component
@Scope("view")
public class GeneroBean implements ApplicationContextAware {
	
    private ApplicationContext context;
    
    private MainBean main;
    
    // lista de deficiencias
    private List<Genero> lista = new ArrayList<Genero>();
    
    @Autowired
    private GeneroService generoService;
	
    // campos
	public String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Genero> getLista() {
		return this.lista;
	}
	public void setLista(List<Genero> lista) {
		this.lista = lista;
	}
	
	@PostConstruct
	public void carregarLista() {
		try {
			List<Genero> lista = generoService.fetch();
			System.out.println("[Carregar Genero] size: " + lista.size());
			this.setLista(lista);
		} catch (Exception e) {
			this.main.setErrorMessage(e.getMessage());
		}
	}
	
	public void salvar() {
		System.out.println("[Salvar Deficiencia] nome: " + this.nome);
		
		Genero d = new Genero();
		d.setNome(this.nome);
		try {
			d = generoService.save(d);
			this.nome = "";
			this.main.setSuccessMessage("OK");
			this.lista = generoService.fetch();
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
