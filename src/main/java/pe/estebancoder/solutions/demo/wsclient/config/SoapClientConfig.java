package pe.estebancoder.solutions.demo.wsclient.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@RequiredArgsConstructor
@Configuration
public class SoapClientConfig {

    private final SoapClientProperties soapClientProperties;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(soapClientProperties.getPackageName()); // Aquí están tus clases generadas
        return marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller) {
        WebServiceTemplate template = new WebServiceTemplate();
        template.setMarshaller(marshaller);
        template.setUnmarshaller(marshaller);
        template.setDefaultUri(soapClientProperties.getEndpoint());

        // Configuracion de Timeouts
        HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
        messageSender.setConnectionTimeout(soapClientProperties.getConnectionTimeout());
        messageSender.setReadTimeout(soapClientProperties.getReadTimeout());
        template.setMessageSender(messageSender);

        return template;
    }
}
