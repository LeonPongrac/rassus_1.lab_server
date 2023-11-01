package hr.fer.tel.rassus.server.representations;

import hr.fer.tel.rassus.server.beans.Reading;

public class ReadingPostRepresentation {

    private double temperature, pressure, humidity, co, no2, so2;
    private Long id;

    public ReadingPostRepresentation() {
    }

    public ReadingPostRepresentation(Reading reading) {
        this.temperature = reading.getTemperature();
        this.pressure = reading.getPressure();
        this.humidity = reading.getHumidity();
        this.co = reading.getCo();
        this.no2 = reading.getNo2();
        this.so2 = reading.getSo2();
        this.id = reading.getId();

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

    public double getCo() {
        return co;
    }

    public void setCo(double co) {
        this.co = co;
    }

    public double getNo2() {
        return no2;
    }

    public void setNo2(double no2) {
        this.no2 = no2;
    }

    public double getSo2() {
        return so2;
    }

    public void setSo2(double so2) {
        this.so2 = so2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
