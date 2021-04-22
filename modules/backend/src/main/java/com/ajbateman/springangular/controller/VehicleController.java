package com.ajbateman.springangular.controller;

import com.ajbateman.springangular.api.VehicleApi;
import com.ajbateman.springangular.dto.VehicleDTO;
import com.ajbateman.springangular.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController extends AbstractCRUDLController<Vehicle, VehicleDTO> {

    @Autowired
    public VehicleController(final VehicleApi api) {
        super(api);
    }
}
