package br.com.gigio.generictypeconverter.implementations;

import java.io.InputStream;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import br.com.gigio.generictypeconverter.interfaces.Converter;

public class DocumentStringConverter implements Converter<Document, String> {

	public String convert(Document aDocument) {
		String result = null;

		try {

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			org.w3c.dom.Document document = docBuilderFactory.newDocumentBuilder().parse((InputStream) aDocument);
			StringWriter sw = new StringWriter();
			Transformer serializer = TransformerFactory.newInstance().newTransformer();
			serializer.transform(new DOMSource(document), new StreamResult(sw));
			result = sw.toString();

		}catch (Exception e) {
			e.printStackTrace();

		}

		return result;
	}

}