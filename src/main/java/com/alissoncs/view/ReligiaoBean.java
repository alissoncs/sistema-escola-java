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

import com.alissoncs.entity.Religiao;
import com.alissoncs.service.ReligiaoService;

@Component
@Scope("view")
public class ReligiaoBean implements ApplicationContextAware {
	
    private ApplicationContext context;
    
    private MainBean main;
    
    // lista de Religiaos
    private List<Religiao> lista = new ArrayList<Religiao>();
    
    @Autowired
    private ReligiaoService religiaoService;
	
    // campos
	public String nome;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Religiao> getLista() {
		return this.lista;
	}
	public void setLista(List<Religiao> lista) {
		this.lista = lista;
	}
	
	@PostConstruct
	public void carregarLista() {
		try {
			List<Religiao> lista = religiaoService.fetch();
			System.out.println("[Carregar Religiao] size: " + lista.size());
			this.setLista(lista);
		} catch (Exception e) {
			this.main.setErrorMessage(e.getMessage());
		}
	}
	
	public void salvar() {
		System.out.println("[Salvar Religiao] nome: " + this.nome);
		
		Religiao d = new Religiao();
		d.setNome(this.nome);
		
		try {
			d = religiaoService.save(d);
			this.nome = "";
			this.main.setSuccessMessage("OK");
			this.lista = religiaoService.fetch();
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
