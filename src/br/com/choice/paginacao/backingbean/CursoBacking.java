package br.com.choice.paginacao.backingbean;
import java.util.ArrayList;
import java.util.List;

import br.com.choice.paginacao.dao.GenericDAO;
import br.com.choice.paginacao.model.Curso;
import br.com.choice.paginacao.util.JSFUtil;

public class CursoBacking{
	private Curso curso = new Curso();
	private Curso cursoSelecionado = new Curso();
	private int codigo;
	private String genero;
	private String nome;
	private String disponivel;
	private double valor;
	private List<Curso> listaCursoTotal;
	private List<Curso> listaCurso;
	private int scrollerPage;
	private int qtdLinhas;
	private int paginaTotal;
	
	/** Métodos de mapeamento para menu*/
	public String consultarMenu(){
		try {
			scrollerPage = 1;
			qtdLinhas = 10;
			listaCursoTotal = new GenericDAO().buscarTodos();
			System.out.println("suize: "+listaCursoTotal.size());
			System.out.println("if: "+listaCursoTotal.size()%10);
			if (listaCursoTotal.size()%10==0){
				paginaTotal = listaCursoTotal.size()/10;
			}else{
				paginaTotal = (listaCursoTotal.size()/10)+1;
			}
			montarLista();
		} catch (Exception e) {
			JSFUtil.addInfoMessage("Erro na busca.");
		}
		return "";
	}
	
	public String voltar(){
		if (scrollerPage>1){
			scrollerPage--;
			montarLista();
			return "atualizar";
		}else{
			JSFUtil.addInfoMessage("Não há mais páginas para voltar.");
			return "";
		}		
	}
	
	public String avancar(){
		if (scrollerPage<paginaTotal){
			scrollerPage++;
			montarLista();
			return "atualizar";
		}else{
			JSFUtil.addInfoMessage("Não há mais páginas para avançar.");
			return "";
		}
	}
	
	public void montarLista (){
		listaCurso = new ArrayList<Curso>();
		int contador = 0;
		int contCurso = 0;
		for (Curso c : listaCursoTotal){
			contCurso++;
			if (contador==qtdLinhas)
				break;
			if ((contCurso<=(qtdLinhas*scrollerPage))&&
			    (contCurso>(qtdLinhas*(scrollerPage-1)))){
				listaCurso.add(c);
				contador++;
			}
		}
	}
	
	/** Método para efetuar consulta de cursos*/
	public String cursoPesquisar(){
		return "";
	}
	
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDisponivel() {
		return disponivel;
	}
	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public List<Curso> getListaCurso() {
		return listaCurso;
	}
	public void setListaCurso(List<Curso> listaCurso) {
		this.listaCurso = listaCurso;
	}

	public Curso getCursoSelecionado() {
		return cursoSelecionado;
	}

	public void setCursoSelecionado(Curso cursoSelecionado) {
		this.cursoSelecionado = cursoSelecionado;
	}
	public int getScrollerPage() {
		return scrollerPage;
	}
	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

	public List<Curso> getListaCursoTotal() {
		return listaCursoTotal;
	}

	public void setListaCursoTotal(List<Curso> listaCursoTotal) {
		this.listaCursoTotal = listaCursoTotal;
	}

	public int getQtdLinhas() {
		return qtdLinhas;
	}

	public void setQtdLinhas(int qtdLinhas) {
		this.qtdLinhas = qtdLinhas;
	}

	public int getPaginaTotal() {
		return paginaTotal;
	}

	public void setPaginaTotal(int paginaTotal) {
		this.paginaTotal = paginaTotal;
	}
}