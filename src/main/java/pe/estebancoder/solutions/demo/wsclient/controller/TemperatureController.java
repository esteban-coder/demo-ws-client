package pe.estebancoder.solutions.demo.wsclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.estebancoder.solutions.demo.wsclient.client.TemperatureClient;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/temperatures")
public class TemperatureController {

    private final TemperatureClient temperatureClient;

    @PostMapping("/celsiusToFahrenheit")
    public double celsiusToFahrenheit(@RequestParam double celsius) {
        String responseFahrenheit = temperatureClient.celsiusToFahrenheit(String.valueOf(celsius));
        return Double.parseDouble(responseFahrenheit);
    }

}
