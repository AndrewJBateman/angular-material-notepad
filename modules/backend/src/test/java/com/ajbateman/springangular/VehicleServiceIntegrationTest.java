package com.ajbateman.springangular;

import com.ajbateman.springangular.dto.VehicleDTO;
import com.ajbateman.springangular.service.VehicleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VehicleServiceIntegrationTest {

    @Autowired
    public VehicleService service;

    @Test
    void testVehicleCRUDL() {
        final VehicleDTO dto = new VehicleDTO();
        dto.setNumber("Vehicle test number");

        final VehicleDTO savedVehicle = service.save(dto);
        assertThat(savedVehicle).isNotNull();
        assertThat(savedVehicle.getId()).isNotNull();
        assertThat(savedVehicle.getCreated()).isNotNull();
        assertThat(savedVehicle.getModified()).isNotNull();
        assertThat(savedVehicle.getNumber()).isEqualTo(dto.getNumber());

        final VehicleDTO vehicleByID = service.getById(savedVehicle.getId());
        assertThat(vehicleByID).isNotNull();
        assertThat(vehicleByID)
                .extracting(
                        VehicleDTO::getId,
                        VehicleDTO::getNumber
                )
                .contains(
                        savedVehicle.getId(),
                        savedVehicle.getNumber()
                );

        final List<VehicleDTO> vehicles = service.list();
        assertThat(vehicles).isNotNull();
        assertThat(vehicles).hasSize(1);

        savedVehicle.setNumber("new vehicle number");
        final VehicleDTO updatedVehicle = service.save(savedVehicle);
        assertThat(updatedVehicle).isNotNull();
        assertThat(updatedVehicle.getNumber()).isEqualTo(savedVehicle.getNumber());
        assertThat(updatedVehicle.getModified()).isAfter(savedVehicle.getModified());

        final Boolean deleted = service.delete(savedVehicle.getId());
        assertThat(deleted).isTrue();
        assertThat(service.getById(savedVehicle.getId())).isNull();

        assertThat(service.delete(677774354)).isFalse();
    }
}
