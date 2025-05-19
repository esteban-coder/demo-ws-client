package pe.estebancoder.solutions.demo.wsclient.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import pe.estebancoder.solutions.demo.wsclient.wsdl.CelsiusToFahrenheit;
import pe.estebancoder.solutions.demo.wsclient.wsdl.CelsiusToFahrenheitResponse;

@Component
@RequiredArgsConstructor
@Slf4j
public class TemperatureClient {

    private final WebServiceTemplate webServiceTemplate;

    public String celsiusToFahrenheit(String celsius) {
        CelsiusToFahrenheit request = new CelsiusToFahrenheit();
        request.setCelsius(celsius);

        log.info("Convirtiendo {} Celsius a Fahrenheit", celsius);

        SoapActionCallback soapActionCallback = new SoapActionCallback("https://www.w3schools.com/xml/CelsiusToFahrenheit");

        CelsiusToFahrenheitResponse response = (CelsiusToFahrenheitResponse)
                webServiceTemplate.marshalSendAndReceive(request, soapActionCallback);

        String fahrenheit = response.getCelsiusToFahrenheitResult();
        log.info("Resultado: {} Fahrenheit", fahrenheit);

        return fahrenheit;
    }
}
