package br.com.gigio.generictypeconverter.implementations;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FileUtils;
import org.jdom.output.XMLOutputter;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import br.com.gigio.generictypeconverter.interfaces.Converter;

public class DocumentStringConverter implements Converter<Document, String> {
	
	private static final String BASE_DIR = "files/input/";

	public String convert(Document aDocument) {
		String result = null;
		//Transformer transformer = null;
		
//		try {
//			transformer = TransformerFactory.newInstance().newTransformer();
//			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//
//			StreamResult streamResult = new StreamResult(new StringWriter());
//			DOMSource source = new DOMSource(node);
//			transformer.transform(source, streamResult);
//
//			result = streamResult.getWriter().toString();
//			
//		} catch (TransformerConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (TransformerFactoryConfigurationError e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		XMLOutputter outp = new XMLOutputter();
//		String s = outp.outputString(new Docu);

		try{ 

		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance(); 

		org.w3c.dom.Document document = docBuilderFactory.newDocumentBuilder().parse((InputStream) aDocument); 

		StringWriter sw = new StringWriter(); 

		Transformer serializer = TransformerFactory.newInstance().newTransformer(); 

		serializer.transform(new DOMSource(document), new StreamResult(sw)); 

		result = sw.toString(); 

		} 

		catch (Exception e) { 

		e.printStackTrace(); 

		} 
		
		return result;
	}
	
	//readFile("xml-payload.xml")
	
//	private static String readFile(String filename) throws IOException {
//		return FileUtils.readFileToString(new File(BASE_DIR + filename));
//	}

}
