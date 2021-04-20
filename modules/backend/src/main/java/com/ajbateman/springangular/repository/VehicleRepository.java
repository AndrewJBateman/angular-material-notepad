package com.ajbateman.springangular.repository;

import com.ajbateman.springangular.entity.Vehicle;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends DistributedRepository<Vehicle> {
}
