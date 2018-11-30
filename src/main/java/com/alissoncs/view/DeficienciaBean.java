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
import com.alissoncs.service.DeficienciaService;

@Component
@Scope("view")
public class DeficienciaBean implements ApplicationContextAware {
	
    private ApplicationContext context;
    
    private MainBean main;
    
    private List<Deficiencia> lista = new ArrayList<Deficiencia>();
    
    @Autowired
    private DeficienciaService deficienciaService;
	
	public String grau;
	public String nome;
	
	public DeficienciaBean() {
		Deficiencia e = new Deficiencia();
		e.setId(Long.valueOf(1));
		e.setNome("Nome aleatorio");
		e.setGrau(1);
		this.lista.add(e);
	}

	public String getGrau() {
		return grau;
	}
	public void setGrau(String grau) {
		this.grau = grau;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Deficiencia> getLista() {
		return this.lista;
	}
	public void setLista(List<Deficiencia> lista) {
		this.lista = lista;
	}
	
	@PostConstruct
	public void carregarLista() {
		try {
			List<Deficiencia> lista = deficienciaService.fetch();
			System.out.println("[Carregar Deficiencia] size: " + lista.size());
			this.setLista(lista);
		} catch (Exception e) {
			this.main.setErrorMessage(e.getMessage());
		}
	}
	
	public void salvar() {
		System.out.println("[Salvar Deficiencia] nome: " + this.nome +
				", grau: " + this.grau);
		
		Deficiencia d = new Deficiencia();
		d.setNome(this.nome);
		try {
			d.setGrau(Integer.parseInt(this.grau));
		} catch (Exception e) {	
		}
		
		try {
			d = deficienciaService.save(d);
			this.nome = "";
			this.grau = "";
			this.main.setSuccessMessage("OK");
			this.lista = deficienciaService.fetch();
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
