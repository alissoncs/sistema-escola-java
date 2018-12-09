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

import com.alissoncs.entity.Aluno;
import com.alissoncs.entity.Genero;
import com.alissoncs.entity.Matricula;
import com.alissoncs.entity.Turma;
import com.alissoncs.service.AlunoService;
import com.alissoncs.service.MatriculaService;
import com.alissoncs.service.TurmaService;

@Component
@Scope("view")
public class MatriculaBean implements ApplicationContextAware {
	
    private ApplicationContext context;
    
    private MainBean main;
    
    // lista de deficiencias
    private List<Aluno> alunos = new ArrayList<Aluno>();
    private List<Turma> turmas = new ArrayList<Turma>();
    private List<Matricula> matriculas = new ArrayList<Matricula>();
    
    private String turmaId;
    
    private String alunoId;
    
    @Autowired
    private AlunoService alunoService;
    
    @Autowired
    private MatriculaService matriculaService;
    
    @Autowired
    private TurmaService turmaService;
    
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public String getTurmaId() {
		return turmaId;
	}

	public void setTurmaId(String turmaId) {
		this.turmaId = turmaId;
	}

	public String getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(String alunoId) {
		this.alunoId = alunoId;
	}

	@PostConstruct
	public void carregarLista() {
		try {

			this.setMatriculas(matriculaService.fetch());
			this.setAlunos(alunoService.fetch());
			this.setTurmas(turmaService.fetch());
			
		} catch (Exception e) {
			this.main.setErrorMessage(e.getMessage());
		}
	}
	
	public void salvar() {
		System.out.println("[Salvar Matricula] ");
		
		Matricula m = new Matricula();
		Aluno a = new Aluno();
		a.setId(Long.parseLong(this.getAlunoId()));
		Turma t = new Turma();
		t.setId(Long.parseLong(this.getTurmaId()));
		
		m.setAluno(a);
		m.setTurma(t);
		
		try {
			matriculaService.save(m);
			this.main.setSuccessMessage("OK");
			this.setMatriculas(matriculaService.fetch());
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
