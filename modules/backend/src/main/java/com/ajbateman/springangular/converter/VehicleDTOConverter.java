package com.ajbateman.springangular.converter;

import com.ajbateman.springangular.dto.VehicleDTO;
import com.ajbateman.springangular.entity.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleDTOConverter extends AbstractDTOConverter<Vehicle, VehicleDTO> {

    @Override
    public VehicleDTO convert(final Vehicle entity) {
        final VehicleDTO dto = new VehicleDTO();
        super.convert(entity, dto);

        dto.setNumber(entity.getNumber());

        return dto;
    }
}
