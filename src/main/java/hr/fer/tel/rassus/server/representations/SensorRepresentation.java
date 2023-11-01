package hr.fer.tel.rassus.server.representations;

public class SensorRepresentation {

    private double latitude, longitude;
    private String ip;
    private int port;

    public SensorRepresentation() {
    }

    public SensorRepresentation(double latitude, double longitude, String ip, int port) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.ip = ip;
        this.port = port;
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

    @Override
    public String toString() {
        return "SensorRepresentation{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }
}
