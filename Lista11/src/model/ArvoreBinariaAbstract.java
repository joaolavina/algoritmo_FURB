package model;

public abstract class ArvoreBinariaAbstract <T>{
	
	private NoArvoreBinaria<T> raiz;
	
	public ArvoreBinariaAbstract() {
		raiz = null;
	}
	
	protected void setRaiz(NoArvoreBinaria<T> raiz) {
		this.raiz = raiz;
	}
	
	
	public NoArvoreBinaria<T> getRaiz() {
		return raiz;
	}
	

	/**
	 * Avalia se a �rvore est� vazia
	 * @return true se a �rvore estiver vazia
	 */
	public boolean estaVazia () { //a linguica esta no forno
		return (raiz == null);
	}
	

	/** 
	 * Verifica se a �rvore armazena um determinado dado
	 * @param info dados a ser pesquisado
	 * @return true se a �rvore possuir o dado
	 */
	public boolean pertence(T info) {
		return buscar(info)!=null;
	}
	
	/**
	 * Busca um dado na �rvore
	 * @param info Dado a ser pesquisado
	 * @return N� que cont�m o dado ou null, caso n�o encontre
	 */
	public abstract NoArvoreBinaria<T> buscar(T info) ;

	
	/**
	 * Retorna a representa��o textual de uma sub-arvore, dado seu n�
	 * raiz
	 * @param no n� raiz da sub-arvore
	 * @return representa��o textual da �rvore
	 */
	private String arvorePre(NoArvoreBinaria<T> no) {
		if (no == null)
			return "<>";
		else 
			return "<" + 
					no.getInfo() + 
					arvorePre(no.getEsquerda()) +
					arvorePre(no.getDireita()) +
					">";
	}
	
	
	public String toString() {
		return arvorePre(raiz); 
	}

	/**
	 * Calcula a quantidade de n�s existentes na �rvore
	 * @return N�mero de n�s da �rvore
	 */
	public int contarNos() {
		return contarNos(raiz);
	}
	
	
	private int contarNos(NoArvoreBinaria<T> no) {
		if (no == null) {
			return 0;
		} else {
			return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
		}
	}
	
	
	
	
}


