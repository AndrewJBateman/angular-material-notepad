package com.ajbateman.springangular.controller;

import com.ajbateman.springangular.api.AbstractCRUDLApi;
import com.ajbateman.springangular.dto.BaseDTO;
import com.ajbateman.springangular.entity.DistributedEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AbstractCRUDLController<ENTITY extends DistributedEntity, DTO extends BaseDTO> {
    private final AbstractCRUDLApi<ENTITY, DTO> api;

    public AbstractCRUDLController(final AbstractCRUDLApi<ENTITY, DTO> api) {
        this.api = api;
    }

    @PostMapping
    public DTO save(@RequestBody DTO dto) {
        return api.save(dto);
    }

    @GetMapping("/{id}")
    public DTO getById(@PathVariable Integer id) {
        return api.getById(id);
    }

    @GetMapping("/list")
    public List<DTO> list() {
        return api.list();
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return api.delete(id);
    }
}
