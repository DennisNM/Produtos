package Produtos;



public class Produto {
	private	String nome;
	private	String categoria;
	private	Marca marca;
	// essa classe é o modelo do objeto produto tendo seus atributos e seus metodos acessores e modificadores
	public Produto(String dados) {

		
		// split para separar dados 
		String[] atributos = dados.split(",");
		String[] nome = atributos[1].split("=");
		String[] categoria = atributos[2].split("=");
			
		Marca marcaProduto = new Marca(atributos);
		
		this.nome = nome[1].trim();
		this.categoria = categoria[1].trim();
		this.marca = marcaProduto;

	}



	public Produto() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	@Override
	public String toString() {
		return "Produto,Nome =" + nome + ", categoria=" + categoria + ", marca=" + marca   ;
		
		
	
	}



}
