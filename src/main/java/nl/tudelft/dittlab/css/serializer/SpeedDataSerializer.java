package nl.tudelft.dittlab.css.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import nl.tudelft.dittlab.css.model.SpeedData;

public class SpeedDataSerializer extends JsonSerializer<SpeedData> {
	
	@Override
	public void serialize(SpeedData speedData, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
	
		jgen.writeStartObject();
		
		jgen.writeNumberField("k", speedData.getKey());
		jgen.writeNumberField("x", speedData.getLocation().getX());
		jgen.writeNumberField("y", speedData.getLocation().getY());
		jgen.writeNumberField("s", speedData.getAvgSpeed());
		
		jgen.writeEndObject();
		
	}
	
}
