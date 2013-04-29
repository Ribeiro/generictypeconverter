package br.com.gigio.generictypeconverter.interfaces;

public interface Converter < FROM, TO >{
	public TO convert ( FROM aFromObject );

}
