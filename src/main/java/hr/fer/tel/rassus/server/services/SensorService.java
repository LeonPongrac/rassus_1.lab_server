package hr.fer.tel.rassus.server.services;

import hr.fer.tel.rassus.server.beans.Sensor;
import hr.fer.tel.rassus.server.representations.SensorIdPostRepresentation;
import hr.fer.tel.rassus.server.representations.SensorPostRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public SensorIdPostRepresentation newSensor(Sensor sensor) {
        sensorRepository.save(sensor);
        return new SensorIdPostRepresentation(sensorRepository.getSensorByLatitudeAndLongitude(sensor.getLatitude(), sensor.getLongitude()));
    }

    public List<Sensor> getSensors() {
        return sensorRepository.findAll();
    }

    public SensorPostRepresentation getClosestNeighbor(double longitude, double latitude) {
        List<Sensor> sensorList = sensorRepository.findAll();
        double R = 6371;
        double minDistance = -1;
        Sensor closestNeighbor = new Sensor();

        for (Sensor sensor: sensorList) {
            if(sensor.getLatitude() == latitude && sensor.getLongitude() == longitude) continue;
            double dlon = sensor.getLongitude() - longitude;
            double dlat = sensor.getLatitude() - latitude;
            double a = Math.pow(Math.sin(dlat/2), 2) + Math.cos(latitude) * Math.cos(sensor.getLatitude()) * Math.pow(Math.sin(dlon/2), 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double d = R * c;

            if(minDistance == -1 || minDistance > d) {
                minDistance = d;
                closestNeighbor = sensor;
            }
        }

        SensorPostRepresentation sensorPostRepresentation = new SensorPostRepresentation(closestNeighbor);
        return sensorPostRepresentation;
    }


}
