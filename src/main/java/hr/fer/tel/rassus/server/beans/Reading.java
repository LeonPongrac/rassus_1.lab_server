package hr.fer.tel.rassus.server.beans;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Reading {
  //  TODO

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double temperature, pressure, humidity;
    private Double co, no2, so2;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    public Reading() {
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public Double getCo() {
        return co;
    }

    public void setCo(Double co) {
        this.co = co;
    }

    public Double getNo2() {
        return no2;
    }

    public void setNo2(Double no2) {
        this.no2 = no2;
    }

    public Double getSo2() {
        return so2;
    }

    public void setSo2(Double so2) {
        this.so2 = so2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }


}

