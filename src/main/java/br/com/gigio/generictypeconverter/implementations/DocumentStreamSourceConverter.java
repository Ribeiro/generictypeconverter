package br.com.gigio.generictypeconverter.implementations;

import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import br.com.gigio.generictypeconverter.interfaces.Converter;

public class DocumentStreamSourceConverter implements Converter<Document, StreamSource> {

	private String name;

	public DocumentStreamSourceConverter(){
		this.name = DocumentStreamSourceConverter.class.getSimpleName();
	}
	
	public StreamSource convert(Document aDocument) {
		StreamSource result = null;
		// do the translation
		return result;
	}

	public String getName() {
		return this.name;
	}

}
