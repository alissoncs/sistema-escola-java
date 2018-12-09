package br.edu.qi.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.edu.qi.entidade.Aluno;
import br.edu.qi.entidade.Pessoa;
import br.edu.qi.servicos.AlunoService;
import br.edu.qi.servicos.PessoaService;

@Component
@Scope("view")
public class AlunoBean implements ApplicationContextAware {
	
    private ApplicationContext context;
    
    private MainBean main;
    
    // lista de Alunos
    private List<Aluno> lista = new ArrayList<Aluno>();
    
    @Autowired
    private AlunoService alunoService;
    
    @Autowired
    private PessoaService pessoaService;
	
    // campos
	public String nome;

	public String pessoaId;
	
	public String formaPagamento;
	
	public List<Pessoa> pessoas;
	
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
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

	public List<Aluno> getLista() {
		return this.lista;
	}
	public void setLista(List<Aluno> lista) {
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
		try {
			List<Aluno> lista = alunoService.fetch();
			
			this.setLista(lista);
			
			this.setPessoas(pessoaService.fetch());
			
		} catch (Exception e) {
			this.main.setErrorMessage(e.getMessage());
		}
	}
	
	public void salvar() {
		
		Aluno d = new Aluno();
		d.setFormaPagamento(this.formaPagamento);
		Pessoa pessoa = new Pessoa();
		pessoa.setId(Long.parseLong(this.pessoaId));
		d.setPessoa(pessoa);
		
		try {
			d = alunoService.save(d);
			
			this.formaPagamento = null;
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
