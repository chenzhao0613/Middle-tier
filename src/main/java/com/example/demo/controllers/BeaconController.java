package com.example.demo.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.models.Beacon;
import com.example.demo.services.BeaconService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeaconController {
    @Autowired
    private BeaconService beaconService;

    @GetMapping("/")
    public void home(HttpServletResponse response) throws IOException {
        response.sendRedirect("/beacons");
    }

    @GetMapping("/beacons")
    public List<Beacon> getAllBeacons() {
        return beaconService.getAllBeacons();
    }

    @GetMapping("/beacons/{beaconID}")
    public Beacon getBeacon(@PathVariable("beaconID") Integer beaconID) {
        return beaconService.getBeacon(beaconID);
    }

    @PostMapping("/beacons")
    public void addBeacon(@RequestBody Beacon beacon) {
        beaconService.addBeacon(beacon);
    }

    @PutMapping("/beacons/{beaconID}")
    public void updateBeacon(@RequestBody Beacon beacon, @PathVariable("beaconID") Integer beaconID) {
        beaconService.updateBeacon(beacon, beaconID);
    }

    @DeleteMapping("/beacons/{beaconID}")
    public void deleteBeacon(@PathVariable("beaconID") Integer beaconID) {
        beaconService.deleteBeacon(beaconID);
    }
}