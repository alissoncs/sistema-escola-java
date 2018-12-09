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

import com.alissoncs.entity.Curso;
import com.alissoncs.entity.Turma;
import com.alissoncs.service.CursoService;
import com.alissoncs.service.TurmaService;

@Component
@Scope("view")
public class TurmaBean implements ApplicationContextAware {
	
    private ApplicationContext context;
    
    private MainBean main;
    
    // lista de deficiencias
    private List<Turma> lista = new ArrayList<Turma>();
    private List<Curso> cursos = new ArrayList<Curso>();
    
    @Autowired
    private TurmaService turmaService;
    
    @Autowired
    private CursoService cursoService;
    
    private String capacidade;
    private String cursoId;
  
    
    public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public String getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}
	public String getCursoId() {
		return cursoId;
	}
	public void setCursoId(String cursoId) {
		this.cursoId = cursoId;
	}

	// campos
	public String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Turma> getLista() {
		return this.lista;
	}
	public void setLista(List<Turma> lista) {
		this.lista = lista;
	}
	
	@PostConstruct
	public void carregarLista() {
		try {
			List<Turma> lista = turmaService.fetch();
			System.out.println("[Carregar Turma] size: " + lista.size());
			this.setLista(lista);
			this.setCursos(cursoService.fetch());
			System.out.println("[Carregar Turma] size: " + this.getCursos().size());
		} catch (Exception e) {
			this.main.setErrorMessage(e.getMessage());
		}
	}
	
	public void salvar() {
		System.out.println("[Salvar Turma] nome: " + this.nome);
		
		Turma d = new Turma();
		d.setNome(this.nome);
		d.setCapacidade(Integer.parseInt(this.capacidade));
		Curso c = new Curso();
		c.setId(Long.parseLong(this.getCursoId()));
		d.setCurso(c);
		
		try {
			d = turmaService.save(d);
			this.nome = "";
			this.capacidade = null;
			this.setCursoId(null);
			this.main.setSuccessMessage("OK");
			this.lista = turmaService.fetch();
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
