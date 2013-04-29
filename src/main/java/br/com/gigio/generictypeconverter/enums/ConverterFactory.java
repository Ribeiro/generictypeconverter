package br.com.gigio.generictypeconverter.enums;

import java.util.HashMap;
import java.util.Map;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;

import br.com.gigio.generictypeconverter.implementations.DocumentStreamSourceConverter;
import br.com.gigio.generictypeconverter.implementations.DocumentStringConverter;
import br.com.gigio.generictypeconverter.interfaces.Converter;

public enum ConverterFactory {
	INSTANCE;

	private Map<Key, Converter<?, ?>> converters;

	private ConverterFactory() {
		converters = new HashMap<Key, Converter<?, ?>>();
		converters.put(new Key(Document.class, String.class), new DocumentStringConverter());
		converters.put(new Key(Document.class, StreamSource.class), new DocumentStreamSourceConverter());
	}

	public static ConverterFactory getInstance() {
		return INSTANCE;
	}

	@SuppressWarnings("unchecked")
	public <F, T> Converter<F, T> getConverter(Class<F> fromType, Class<T> toType) {
		Converter<F, T> result = null;
		result = (Converter<F, T>) converters.get(new Key(fromType, toType));
		return result;
	}

	private class Key {
		private Object class1;
		private Object class2;

		public Key(Object class1, Object class2) {
			this.class1 = class1;
			this.class2 = class2;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result
					+ ((class1 == null) ? 0 : class1.hashCode());
			result = prime * result
					+ ((class2 == null) ? 0 : class2.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Key other = (Key) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (class1 == null) {
				if (other.class1 != null)
					return false;
			} else if (!class1.equals(other.class1))
				return false;
			if (class2 == null) {
				if (other.class2 != null)
					return false;
			} else if (!class2.equals(other.class2))
				return false;
			return true;
		}

		private ConverterFactory getOuterType() {
			return ConverterFactory.this;
		}

	}

}