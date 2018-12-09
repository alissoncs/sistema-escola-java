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
import com.alissoncs.service.EtniaService;

@Component
@Scope("view")
public class EtniaBean implements ApplicationContextAware {
	
    private ApplicationContext context;
    
    private MainBean main;
    
    // lista de Etnias
    private List<Etnia> lista = new ArrayList<Etnia>();
    
    @Autowired
    private EtniaService etniaService;
	
    // campos
	public String nome;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Etnia> getLista() {
		return this.lista;
	}
	public void setLista(List<Etnia> lista) {
		this.lista = lista;
	}
	
	@PostConstruct
	public void carregarLista() {
		this.main.clear();
		try {
			List<Etnia> lista = etniaService.fetch();
			System.out.println("[Carregar Etnia] size: " + lista.size());
			this.setLista(lista);
		} catch (Exception e) {
			this.main.setErrorMessage(e.getMessage());
		}
	}
	
	public void salvar() {
		System.out.println("[Salvar Etnia] nome: " + this.nome);
		
		Etnia d = new Etnia();
		d.setNome(this.nome);
		
		try {
			d = etniaService.save(d);
			this.nome = "";
			this.main.setSuccessMessage("OK");
			this.lista = etniaService.fetch();
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
