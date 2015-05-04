package demo.proj.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

public class CustomObjectMapper extends ObjectMapper {

	public CustomObjectMapper() {
		super();
		boolean state = true;
		super.configure(MapperFeature.USE_ANNOTATIONS, state);
		super.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, state);
		super.configure(SerializationFeature.WRAP_ROOT_VALUE, state);
		super.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		AnnotationIntrospector primary = new JaxbAnnotationIntrospector(super.getTypeFactory());
		AnnotationIntrospector secondary = new JacksonAnnotationIntrospector();
		AnnotationIntrospector pair = new AnnotationIntrospectorPair(primary,
				secondary);
		super.setAnnotationIntrospector(pair);
	}

}
