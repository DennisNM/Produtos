package Executa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;


import DB.ManipulacaArquivoXML;
import DB.ManipulacaoAqruivoTXT;

import Produtos.Marca;
import Produtos.Produto;
import Util.Lista;

import View.ViewCRUDProduto;

public class CrudProduto {
	private static int codigo ;

// o mtedo faz a chamada de dados alunos que vem apartir da view para ai colocar os dados usandos os metódos modificadores 
	public static void cadastro(BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException {
		
		String[] dadosAluno = ViewCRUDProduto.ViewMenuSalvarAluno(reader);
		
		Marca marca = new Marca();
		
		Produto protudo = new Produto();

		
			
			protudo.setNome(dadosAluno[0]);

			
			protudo.setCategoria(dadosAluno[1]);

			
			marca.setNome(dadosAluno[2]);

			
			marca.setPreco(Double.parseDouble((dadosAluno[3])));

			protudo.setMarca(marca);
			
			Lista.getInstance().add(protudo);
// salva os dados essa ultima 2 linhas
			ManipulacaoAqruivoTXT.SalvarArquivoTXT();
		
			ManipulacaArquivoXML.SalvarArquivoXML();

		
	}
	// chama todos cadastros  apartir da view e dentro dela ele retorna o numero do indice que o usuario deseja apagar
	public static void DeletarAluno(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException {

		int indice = ViewCRUDProduto.ViewMenuEditarOuDeletarAluno("deletar", reader);

		Lista.getInstance().remove(indice);

		ManipulacaoAqruivoTXT.SalvarArquivoTXT();
		ManipulacaArquivoXML.SalvarArquivoXML();
	}
	


	
	
	// o nome é bem intuitivo. Lista o txt apartir de
	public static void listarTxt() throws FileNotFoundException, IOException, ParserConfigurationException, TransformerException, SAXException {
		

			Lista.getInstance().clear();
			
			//ManipulacaoAqruivoTXT.LerArquivoTXT();		
			ManipulacaArquivoXML.LerArquivoXML();	
			
			ViewCRUDProduto.ViewListaDeAlunosEditada();
					
	}
	
	//edita os produtos sobrescrevendo-os com os novos atributos
	public static void EditarProduto( BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException {
						
		String[] dadosEditados = {"",""};
		
		int indice = ViewCRUDProduto.ViewMenuEditarOuDeletarAluno("editar", reader);
		

		Produto produto = Lista.getInstance().get(indice);

		dadosEditados = ViewCRUDProduto.ViewOpcaoEdicao(reader);
		
		
		
		switch(Integer.parseInt(dadosEditados[0]) ) {
		case 1:
			produto.setNome (dadosEditados[1]);
		break;
		case 2:
			produto.setCategoria(dadosEditados[1]);
		
		break;
		
		case 3:
			produto.getMarca().setNome(dadosEditados[1]);
		break;
		
		case 4:
			produto.getMarca().setPreco(Double.parseDouble(dadosEditados[1]));
			break;
			
		
		}
		
	
	
		Lista.getInstance().set(indice, produto);
		
		ManipulacaoAqruivoTXT.SalvarArquivoTXT();
		ManipulacaArquivoXML.SalvarArquivoXML();
		
		
	}

	

}
