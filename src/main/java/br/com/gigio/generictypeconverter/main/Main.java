package br.com.gigio.generictypeconverter.main;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import br.com.gigio.generictypeconverter.enums.ConverterFactory;
import br.com.gigio.generictypeconverter.interfaces.Converter;

public class Main {
	
	public static void main(String[] args) {
		ConverterFactory converterFactory = ConverterFactory.getInstance ( );  
		Converter<Document, StreamSource> converterOne = converterFactory.getConverter (Document.class, StreamSource.class);
		Converter<Document, String> converterTwo = converterFactory.getConverter (Document.class, String.class);
		
//		StreamSource document = null;
//		try {
//			document = converter.convert(loadXMLFrom("files/input/xml-payload.xml"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("Converter - One => " + converterOne.getName());
		System.out.println("Converter - Two => " + converterTwo.getName());
		
		
	}
	
	public static Document loadXMLFrom(String xml) throws Exception {
    	InputSource is= new InputSource(new StringReader(xml));
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	factory.setNamespaceAware(true);
    	DocumentBuilder builder = null;
    	builder = factory.newDocumentBuilder();
    	Document doc = builder.parse(is);
    	return doc;
    }

}
