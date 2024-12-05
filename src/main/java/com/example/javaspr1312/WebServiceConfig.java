package com.example.javaspr1312;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class WebServiceConfig
{
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet()
    {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext -> {});
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }
    @Bean(name = "fractions")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema fractionsSchema)
    {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("FractionsPort");
        definition.setLocationUri("/ws");
        definition.setTargetNamespace("http://example.com/fractions");
        definition.setSchema(fractionsSchema);
        return definition;
    }
    @Bean
    public XsdSchema fractionsSchema()
    {
        return new SimpleXsdSchema(new ClassPathResource("fractions.xsd"));
    }
}
