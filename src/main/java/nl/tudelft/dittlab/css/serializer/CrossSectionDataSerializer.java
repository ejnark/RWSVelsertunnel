package nl.tudelft.dittlab.css.serializer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import nl.tudelft.dittlab.css.model.CrossSectionData;

public class CrossSectionDataSerializer extends JsonSerializer<CrossSectionData> {
	
	private static final DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	
	@Override
	public void serialize(CrossSectionData crossSectionData, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		
		jgen.writeStartObject();
		
		jgen.writeStringField("time", df.format(crossSectionData.getTime()));
		jgen.writeObjectField("data", crossSectionData.getSpeedDataList());
		
		jgen.writeEndObject();
		
	}

}
