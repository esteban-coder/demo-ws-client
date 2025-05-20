package pe.estebancoder.solutions.demo.wsclient.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class SoapClientProperties {
    private final String packageName;
    private final String endpoint;
    private final int connectionTimeout;
    private final int readTimeout;
    private final String celsiusToFahrenheit;
    private final String fahrenheitToCelsius;

    public SoapClientProperties(
            @Value("${soap.client.package}") String packageName,
            @Value("${soap.client.endpoint}") String endpoint,
            @Value("${soap.client.connection-timeout}") int connectionTimeout,
            @Value("${soap.client.read-timeout}") int readTimeout,
            @Value("${soap.actions.celsius-to-fahrenheit}") String celsiusToFahrenheit,
            @Value("${soap.actions.fahrenheit-to-celsius}") String fahrenheitToCelsius) {
        this.packageName = packageName;
        this.endpoint = endpoint;
        this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
        this.celsiusToFahrenheit = celsiusToFahrenheit;
        this.fahrenheitToCelsius = fahrenheitToCelsius;
    }
}