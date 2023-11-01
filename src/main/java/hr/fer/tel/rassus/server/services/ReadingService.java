package hr.fer.tel.rassus.server.services;

import hr.fer.tel.rassus.server.beans.Reading;
import hr.fer.tel.rassus.server.beans.Sensor;
import hr.fer.tel.rassus.server.representations.ReadingPostRepresentation;
import hr.fer.tel.rassus.server.representations.ReadingRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReadingService {

    private final ReadingRepository readingRepository;
    private final SensorRepository sensorRepository;

    @Autowired
    public ReadingService(ReadingRepository readingRepository, SensorRepository sensorRepository) {
        this.readingRepository = readingRepository;
        this.sensorRepository = sensorRepository;
    }

    public ReadingPostRepresentation saveReading(long sensorId, ReadingRepresentation readingRepresentation) {
        Reading reading = new Reading();
        Optional<Sensor> optionalSensor = sensorRepository.findById(sensorId);
        Sensor sensor = optionalSensor.get();
        reading.setTemperature(readingRepresentation.getTemperature());
        reading.setPressure(readingRepresentation.getPressure());
        reading.setHumidity(readingRepresentation.getHumidity());
        reading.setCo(readingRepresentation.getCo());
        reading.setNo2(readingRepresentation.getNo2());
        reading.setSo2(readingRepresentation.getSo2());
        reading.setSensor(sensor);
        readingRepository.save(reading);

        ReadingPostRepresentation readingPostRepresentation = new ReadingPostRepresentation(reading);
        return readingPostRepresentation;
    }

    public List<Reading> getReadings(long sensorId) {
        return readingRepository.findBySensorId(sensorId);
    }


}
