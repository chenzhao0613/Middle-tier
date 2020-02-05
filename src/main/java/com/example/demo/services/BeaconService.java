package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.Beacon;
import com.example.demo.repositories.BeaconRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeaconService {
    @Autowired
    private BeaconRepository beaconRepository;

    public List<Beacon> getAllBeacons() {
        List<Beacon> beacons = new ArrayList<>();
        beaconRepository.findAll().forEach(beacons::add);
        return beacons;
    }

    public Beacon getBeacon(Integer beaconID) {

        return beaconRepository.findByBeaconID(beaconID);
    }

    public void addBeacon(Beacon beacon) {
        beaconRepository.save(beacon);
    }

    public void updateBeacon(Beacon beacon, Integer beaconID) {
        Beacon currentBeacon = beaconRepository.findByBeaconID(beaconID);
        currentBeacon.setBeaconID(beacon.getBeaconID());
        currentBeacon.setLocation(beacon.getLocation());
        beaconRepository.save(currentBeacon);
    }

    public void deleteBeacon(Integer beaconID) {
        Beacon beacon = beaconRepository.findByBeaconID(beaconID);
        beaconRepository.delete(beacon);
    }
}