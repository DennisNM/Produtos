package Executa;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import  Produtos.*;

public class App {public static void main(String[] args) {
BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
int menu = 0 ;
Marca marca = new Marca();
Produto protudo = new Produto();
String valida;
int i = 0;
CrudProduto exe = new CrudProduto();
List<Produto> prod = new ArrayList<Produto>();
	System.out.println("Olá Bem-vindo ao cadastro de produtos ");
	Scanner sc1 = new Scanner(System.in);
	while(menu !=5) {
	System.out.println("1- para cadastro de produtos");
	System.out.println("2- para ver Produtos Cadastrados");
	System.out.println("3- para excluir produto");
	System.out.println("4- para editar");
	System.out.println("5- para sair");
	
	try {
		menu = (Integer.parseInt((reader.readLine())));
		System.out.println();
		
		if(menu == 1) {
			
			//chama a execução de cadastro
			exe.cadastro(reader);
			
	
		i++;
		}
		
		
		if(menu == 2) {
			//chama a execução de lsitar os produtos
			CrudProduto.listarTxt();
	
		}
		if(menu == 3) {
			//chama a execução de deleltar
			CrudProduto.DeletarAluno(reader);
			
		}
		
		if(menu == 4) {
			//chama a execução de editar os produtos
			CrudProduto.EditarProduto(reader);
		}
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}

}
