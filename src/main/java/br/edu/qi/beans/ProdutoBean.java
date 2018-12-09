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

import br.edu.qi.entidade.Produto;
import br.edu.qi.servicos.ProdutoService;

@Component
@Scope("view")
public class ProdutoBean implements ApplicationContextAware {
	
    private ApplicationContext context;
    
    private MainBean main;
    
    // lista de Produtos
    private List<Produto> lista = new ArrayList<Produto>();
    
    @Autowired
    private ProdutoService produtoService;
	
    // campos
	public String nome;

	private String valor;

	public String getValor() {
		return valor;
	}
	public void setValor(String nome) {
		this.valor = nome;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Produto> getLista() {
		return this.lista;
	}
	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}
	
	@PostConstruct
	public void carregarLista() {
		this.main.clear();
		try {
			List<Produto> lista = produtoService.fetch();
			this.setLista(lista);
		} catch (Exception e) {
			this.main.setErrorMessage(e.getMessage());
		}
	}
	
	public void salvar() {
		
		Produto d = new Produto();
		d.setNome(this.nome);
		d.setValor(Float.parseFloat(this.getValor()));
		
		try {
			d = produtoService.save(d);
			this.nome = "";
			this.main.setSuccessMessage("OK");
			this.lista = produtoService.fetch();
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
