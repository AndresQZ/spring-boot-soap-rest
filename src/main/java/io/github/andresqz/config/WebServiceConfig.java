package io.github.andresqz.config;

import io.github.andresqz.constant.SpringWSConst;
import io.github.andresqz.interceptors.TraceRequestEndpointInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.List;

import static io.github.andresqz.constant.SpringWSConst.NAMESPACE_URI;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Autowired
    TraceRequestEndpointInterceptor traceRequestEndpointInterceptor;


    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        // register global interceptor
        interceptors.add(traceRequestEndpointInterceptor);
    }

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "pokemons")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema pokemonsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PokemonPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace(NAMESPACE_URI);
        wsdl11Definition.setSchema(pokemonsSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema pokemonsSchema() {
        return new SimpleXsdSchema(new ClassPathResource(SpringWSConst.POKEMON_SCHEMA));
    }
}