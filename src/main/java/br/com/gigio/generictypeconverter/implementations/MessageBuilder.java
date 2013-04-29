package br.com.gigio.generictypeconverter.implementations;

import javax.swing.text.Document;

import br.com.gigio.generictypeconverter.interfaces.Converter;

public class MessageBuilder {

	private Object converterFactory;
	private Document document;

	public <T> T buildResponseMessage(final Class<T> convertToType) {
		T result = null;
//
//		Document doc = null;
//		// build DOM Document
//
//		Converter<Document, T> converter = converterFactory.getConverter(Document.class, convertToType);
//		result = converter.convert(document);

		return result;
	}

}
