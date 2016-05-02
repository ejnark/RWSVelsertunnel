package nl.tudelft.dittlab.css.mapper;

import org.springframework.beans.factory.InitializingBean;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;

@SuppressWarnings("serial")
public class CustomObjectMapper extends ObjectMapper implements InitializingBean {

	public CustomObjectMapper() {
	}

	public CustomObjectMapper(JsonFactory jf) {
		super(jf);
	}

	public CustomObjectMapper(ObjectMapper src) {
		super(src);
	}

	public CustomObjectMapper(JsonFactory jf, DefaultSerializerProvider sp, DefaultDeserializationContext dc) {
		super(jf, sp, dc);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.registerModule(new JtsModule());
	}

}
