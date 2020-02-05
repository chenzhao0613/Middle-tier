package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "beacons")
public class Beacon {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // TODO: Change int to UUID later on
    @Column(name = "beaconid", unique = true)
    private Integer beaconID;

    @Column(name = "location")
    private String location;

    public Beacon() {
    }

    public Beacon(Integer beaconID, String location) {
        super();
        this.beaconID = beaconID;
        this.location = location;
    }

    public Integer getBeaconID() {
        return beaconID;
    }

    public String getLocation() {
        return location;
    }

    public void setBeaconID(Integer beaconID) {
        this.beaconID = beaconID;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}