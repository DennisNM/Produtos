package DB;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import Produtos.Produto;
import Util.Lista;


public class ManipulacaArquivoXML {
	private static String nomeDoArquivo = "CadstroDeProduto.xml";
	public static void SalvarArquivoXML() throws ParserConfigurationException, UnsupportedEncodingException, FileNotFoundException, IOException, TransformerException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		Element ProdutosTag = doc.createElement("produtos");
		doc.appendChild(ProdutosTag);
		
		
		for(Produto a :Lista.getInstance()) {			
			Element ProdutoTag = doc.createElement("produto");
			ProdutoTag.setAttribute("id", "1");
			ProdutosTag.appendChild(ProdutoTag);			

			Element nomeTag = doc.createElement("Nome");
			nomeTag.setTextContent(a.getNome());
			ProdutosTag.appendChild(nomeTag);

			Element cpfTag = doc.createElement("Categoria");
			cpfTag.setTextContent(String.valueOf(a.getCategoria()));
			ProdutosTag.appendChild(cpfTag);	
			
			
			Element MarcaTag = doc.createElement("Marcas");
			ProdutosTag.appendChild(MarcaTag);

			Element nomeMarcaTag = doc.createElement("Marca");
			nomeMarcaTag.setTextContent(a.getMarca().getNome());
			MarcaTag.appendChild(nomeMarcaTag);	

			Element precoTag = doc.createElement("Preco");
			precoTag.setTextContent(String.valueOf(a.getMarca().getPreco()));
			MarcaTag.appendChild(precoTag);	
			

			
		}

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans  = tf.newTransformer();
		
		trans.setOutputProperty( OutputKeys.INDENT,"yes");
		trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","4" );
		

		DOMSource source = new DOMSource(doc);

		try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(nomeDoArquivo),"ISO-8859-1")){			
			StreamResult result = new StreamResult(osw);	
			trans.transform(source, result);
		}
	}
	
	
public static void LerArquivoXML() throws ParserConfigurationException, SAXException, UnsupportedEncodingException, FileNotFoundException, IOException {
		
		SAXParserFactory spf =  SAXParserFactory.newInstance();		
		SAXParser parser = spf.newSAXParser();
		
		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeDoArquivo),"ISO-8859-1")){
			InputSource source =  new InputSource(isr);
			Hadler.XMLHandlerAlunos handler = new Hadler.XMLHandlerAlunos();			
			parser.parse(source, handler);	
		}
		
	}
}
