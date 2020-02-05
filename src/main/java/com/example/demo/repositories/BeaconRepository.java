package com.example.demo.repositories;

import com.example.demo.models.Beacon;

import org.springframework.data.repository.CrudRepository;

public interface BeaconRepository extends CrudRepository<Beacon, Integer> {
    Beacon findByBeaconID(Integer beaconID);
}