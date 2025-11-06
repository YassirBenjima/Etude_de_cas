package ma.variante;

import ma.variante.exception.GenericExceptionMapper;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class RestApplication extends ResourceConfig {
    public RestApplication() {
        packages("ma.variante.resource", "ma.variante.exception");
        register(JacksonFeature.class);
        register(GenericExceptionMapper.class);
    }
}


