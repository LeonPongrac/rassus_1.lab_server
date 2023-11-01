package hr.fer.tel.rassus.server.controllers;

import hr.fer.tel.rassus.server.beans.Reading;
import hr.fer.tel.rassus.server.representations.ReadingPostRepresentation;
import hr.fer.tel.rassus.server.representations.ReadingRepresentation;
import hr.fer.tel.rassus.server.representations.SensorPostRepresentation;
import hr.fer.tel.rassus.server.services.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reading")
public class ReadingController {

    ReadingService readingService;

    @Autowired
    public ReadingController(ReadingService readingService) {
        this.readingService = readingService;
    }

    @PostMapping
    public ResponseEntity<ReadingPostRepresentation> saveReading(@RequestParam long sensorId, @RequestBody ReadingRepresentation readingRepresentation) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("").toUriString());
        return ResponseEntity.created(uri).body(readingService.saveReading(sensorId, readingRepresentation));
    }

    @GetMapping
    public List<ReadingPostRepresentation> getReadings(@RequestParam long sensorId) {
        return readingService.getReadings(sensorId).stream()
                .map(p -> new ReadingPostRepresentation(p))
                .collect(Collectors.toList());
    }

}