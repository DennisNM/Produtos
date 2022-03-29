package View;

import java.io.BufferedReader;
import java.io.IOException;


import Produtos.Produto;
import Util.Lista;



public class ViewCRUDProduto {
	//mostra String com os print do menu que estçao guardados no array
	public static String[] ViewMenuSalvarAluno(BufferedReader reader) throws IOException {
		String[] menuAluno = {"Digite o nome do produto", "Digite a categoria do produto", "Digite a Marca","Digite o preço da marca",};
		String[] dadosAluno = {"","","","",};
		
		for(int i=0; i < menuAluno.length; i++) {
			System.out.println(menuAluno[i]);
			dadosAluno[i] = reader.readLine();			
		}
			
		return dadosAluno;
	}
	// mostra o os indices de editar e deletar do aluno 
	// praticamente um lidtar
	public static int ViewMenuEditarOuDeletarAluno(String editar_deletar,BufferedReader reader) throws NumberFormatException, IOException {		

		for (int i = 0; i < Lista.getInstance().size(); i++)
			System.out.println(i + " - " + Lista.getInstance().get(i));

		System.out.println();
		System.out.println("Dentre a lista acima, escolha o indice do aluno que deseja "+ editar_deletar);
						
		return Integer.parseInt(reader.readLine());
	}
	// mostra o alunos listados
	
public static void ViewListaDeAlunosEditada() {
		
		for (Produto a : Lista.getInstance()) {
			System.out.println("|-----------Produto-----------");
			System.out.println("| Nome = " + a.getNome());
			System.out.println("| Categoria = " + a.getCategoria());
			System.out.println("| Preço = " + a.getMarca().getPreco());
			System.out.println("| Nome da Marca: " +a.getMarca().getNome());
			System.out.println("|-----------------------------");			
// 2 get para pegar o atributo do aluno que é um objeto
		}

		System.out.println();	
	}

//opçoes de edição
public static String[] ViewOpcaoEdicao (BufferedReader reader) throws IOException {		
	String[] dadosEditados = {"",""};
	
	System.out.println("escolha o Atributo que deseja alterar:");
	System.out.println("1 - Nome Produto\n" 
						+ "2 - Categoria\n" 
						+ "3 - Preço\n"
						+ "4 -Nome da Marca:\n"
						);

	dadosEditados[0] = reader.readLine();
	System.out.println("Escreva o novo valor do atributo");
	dadosEditados[1] = reader.readLine();		
	
	return dadosEditados;
}


	

}
