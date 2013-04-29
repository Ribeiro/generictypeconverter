package br.com.gigio.generictypeconverter.implementations;

import javax.swing.text.Document;
import javax.xml.transform.stream.StreamSource;

import br.com.gigio.generictypeconverter.interfaces.Converter;

public class DocumentStreamSourceConverter implements Converter<Document, StreamSource> {

	public StreamSource convert(Document aDocument) {
		StreamSource result = null;
		// do the translation
		return result;
	}

}
