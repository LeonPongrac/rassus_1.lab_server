package hr.fer.tel.rassus.server.controllers;

import hr.fer.tel.rassus.server.beans.Sensor;
import hr.fer.tel.rassus.server.representations.SensorPostRepresentation;
import hr.fer.tel.rassus.server.representations.SensorRepresentation;
import hr.fer.tel.rassus.server.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/sensor")
public class SensorsController {

    private SensorService sensorService;

    @Autowired
    public SensorsController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping
    public ResponseEntity<?> newSensor(
            @RequestBody SensorRepresentation sensorRepresentation) {
        Sensor sensor = new Sensor();
        sensor.setLatitude(sensorRepresentation.getLatitude());
        sensor.setLongitude(sensorRepresentation.getLongitude());
        sensor.setIp(sensorRepresentation.getIp());
        sensor.setPort(sensorRepresentation.getPort());

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("").toUriString());

        return ResponseEntity.created(uri).body(sensorService.newSensor(sensor));
    }

    @GetMapping
    public List<SensorPostRepresentation> getSensorList() {
        return sensorService.getSensors().stream()
                .map(p -> new SensorPostRepresentation(p))
                .collect(Collectors.toList());
    }

    @GetMapping("/getclosestneighbor")
    public SensorPostRepresentation getClosestNeighbor(
            @RequestParam double longitude, @RequestParam double latitude) {
        return sensorService.getClosestNeighbor(longitude, latitude);
    }
}
