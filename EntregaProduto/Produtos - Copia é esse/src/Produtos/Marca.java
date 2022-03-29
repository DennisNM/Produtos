package Produtos;

import javax.swing.text.html.HTMLEditorKit.Parser;

public class Marca {
	private String nome;
	private	double preco;
	// essa classe é o modelo do onjeto aluno tendo seus atributos e seus metodos acessores e modificadores
public Marca(String[] Dados) {
		// split para separar dados 
	
		String[] marca =Dados[4].split("=");
		String[] preco = Dados[5].split("=");
		
		this.nome= marca[1].trim();
		this.preco=  Double.parseDouble(preco [1].trim() );
		
		
	}
	
	public Marca() {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double i) {
		this.preco = i;
	}
	@Override
	public String toString() {
		return "Marca, nome=" + nome + ", preco=" + preco ;
	}
	
	
	
	
	
	

}
