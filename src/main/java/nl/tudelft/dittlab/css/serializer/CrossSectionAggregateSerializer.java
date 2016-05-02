package nl.tudelft.dittlab.css.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import nl.tudelft.dittlab.css.model.CrossSectionAggregate;
import nl.tudelft.dittlab.css.util.DateParseUtil;

public class CrossSectionAggregateSerializer extends JsonSerializer<CrossSectionAggregate> {
	
	@Override
	public void serialize(CrossSectionAggregate crossSectionAggregate, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		
		jgen.writeStartObject();
		
		jgen.writeNumberField("id", crossSectionAggregate.getCsapk().getCrossSectionKey());
		jgen.writeObjectField("location", crossSectionAggregate.getCrossSection().getLocation());
		jgen.writeStringField("date", DateParseUtil.dateToDayString(crossSectionAggregate.getCsapk().getTime()));
		jgen.writeStringField("time", DateParseUtil.dateToTimeString(crossSectionAggregate.getCsapk().getTime()));
		jgen.writeNumberField("avgSpeed", crossSectionAggregate.getAvgSpeed());
		
		
		jgen.writeEndObject();
		
	}

}
