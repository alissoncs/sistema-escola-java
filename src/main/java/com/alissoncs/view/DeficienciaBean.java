package com.alissoncs.view;

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
    
    @Autowired
    private DeficienciaService deficienciaService;
	
	public String grau;
	public String nome;

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
