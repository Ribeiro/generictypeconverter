package br.com.gigio.generictypeconverter.main;

import javax.swing.text.Document;
import javax.xml.transform.stream.StreamSource;

import br.com.gigio.generictypeconverter.enums.ConverterFactory;
import br.com.gigio.generictypeconverter.interfaces.Converter;

public class Main {
	
	public static void main(String[] args) {
		ConverterFactory converterFactory = ConverterFactory.getInstance ( );  
		Converter < Document, StreamSource > converter = converterFactory.getConverter (Document.class, StreamSource.class);
		System.out.println(converter);
	}

}
