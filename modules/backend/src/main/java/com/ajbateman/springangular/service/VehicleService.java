package com.ajbateman.springangular.service;

import com.ajbateman.springangular.api.VehicleApi;
import com.ajbateman.springangular.converter.VehicleDTOConverter;
import com.ajbateman.springangular.dto.VehicleDTO;
import com.ajbateman.springangular.entity.Vehicle;
import com.ajbateman.springangular.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService extends AbstractCRUDLService<Vehicle, VehicleDTO> implements VehicleApi {

    @Autowired
    public VehicleService(final VehicleRepository repository,
                          final VehicleDTOConverter converter) {
        super(repository, converter);
    }

    @Override
    protected void updateEntity(Vehicle entity, VehicleDTO dto) {
        entity.setNumber(dto.getNumber());
    }

    @Override
    protected String getEntityTopic() {
        return "vehicle";
    }
}
