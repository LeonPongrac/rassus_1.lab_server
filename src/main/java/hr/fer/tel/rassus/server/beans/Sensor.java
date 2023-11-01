package hr.fer.tel.rassus.server.beans;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;


@Entity
public class Sensor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "ip")
    private String ip;

    @Column(name = "port")
    private int port;

    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL)
    private List<Reading> readingIds = new LinkedList<>();

    public List<Reading> getReadingIds() {
        return readingIds;
    }

    public void setReadingIds(List<Reading> readingIds) {
        this.readingIds = readingIds;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
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

    public void setPort(Integer port) {
        this.port = port;
    }

    public Sensor() {
    }
}
