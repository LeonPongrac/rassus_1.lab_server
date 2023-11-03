package hr.fer.tel.rassus.server.representations;

import hr.fer.tel.rassus.server.beans.Sensor;

public class SensorIdPostRepresentation {

    long id;
    private double latitude;
    private double longitude;
    private String ip;
    private int port;

    public SensorIdPostRepresentation(Sensor sensor) {
        this.id = sensor.getId();
        this.latitude = sensor.getLatitude();
        this.longitude = sensor.getLongitude();
        this.ip = sensor.getIp();
        this.port = sensor.getPort();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
