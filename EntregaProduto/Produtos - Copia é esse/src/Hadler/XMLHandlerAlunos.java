package Hadler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;


import Produtos.Marca;
import Produtos.Produto;
import Util.Lista;



//essa classe é o manipular do arquivo xml
	public class XMLHandlerAlunos extends DefaultHandler{
		private StringBuilder texto;
		Produto produto;
		Marca marca; 
		
		@Override
		public void startDocument() throws SAXException {
			System.out.println("inicio do Documento");
			
		}
		@Override
		public void endDocument() throws SAXException {
			System.out.println("Fim do Documento");
		}
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			
			if(qName.equals("produto")) {			
				produto = new Produto();
				marca = new Marca();
			}else {
				texto = new StringBuilder();
			}
			
		}
		


		

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {

			if(qName.equals("Nome")){
				produto.setNome(texto.toString());
			}else if(qName.equals("Categoria")) { 
				produto.setCategoria((texto.toString()));
			}else if(qName.equals("Marca")) {
				marca.setNome(texto.toString());
			}else if(qName.equals("Preco")) {
				marca.setPreco(Double.parseDouble(texto.toString()));
				produto.setMarca(marca);  			
				Lista.getInstance().add(produto);
			}
		
				
			
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			// TODO Auto-generated method stub
			super.characters(ch, start, length);			
			texto.append(ch, start,length);
			
		}
		@Override
		public void error(SAXParseException e) throws SAXException {
			// TODO Auto-generated method stub
			super.error(e);
		}
	

}
