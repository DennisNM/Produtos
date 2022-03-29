package DB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import Produtos.Produto;
import Util.Lista;



public class ManipulacaoAqruivoTXT {
	
	private static String nomeDoArquivo = "CadstroDeProduto.txt";
	
	// salva  o txt usando o BufferedWrite
public static void SalvarArquivoTXT() throws IOException {
		
		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(nomeDoArquivo));
				PrintWriter pw = new PrintWriter(buffer)) {
			for (Produto a : Util.Lista.getInstance())
				pw.println(a);
		}
		
	}

//salva  o txt usando o FileWirte
public static void LerArquivoTXT() throws FileNotFoundException, IOException {
	
	try(FileWriter arq = new FileWriter(nomeDoArquivo,true)){};

	String line;

	try (BufferedReader reader = new BufferedReader(new FileReader(nomeDoArquivo))) {

		while ((line = reader.readLine()) != null && !"".equals(line)) {				
				Produto aluno = new Produto(line);
				Lista.getInstance().add(aluno);				
		}
	} 
	
}

}
