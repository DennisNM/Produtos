package Util;

import java.util.ArrayList;
import java.util.List;

import Produtos.Produto;



public class Lista {
	//instacia de litar para deixar o codigo mais organizado
private static List<Produto> listaDeProduto = new ArrayList<Produto>();
	
	public static List<Produto> getInstance(){
		return listaDeProduto;
	}

}
