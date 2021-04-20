package com.ajbateman.springangular.api;

import com.ajbateman.springangular.dto.BaseDTO;
import com.ajbateman.springangular.entity.DistributedEntity;

import java.util.List;

/**
 * Abstract crudl api containing base methods for handling of crudl operations.
 *
 * @param <ENTITY> Entity class.
 * @param <DTO> DTO class.
 */
public interface AbstractCRUDLApi<ENTITY extends DistributedEntity, DTO extends BaseDTO> {

    /**
     * Saves forwarded DTO.
     *
     * @param dto DTO to save.
     * @return Returns saved entity as a DTO.
     */
    DTO save(DTO dto);

    /**
     * Finds DTO by forwarded ID.
     *
     * @param id ID used for searching.
     * @return Returns found DTO otherwise null.
     */
    DTO getById(Integer id);

    /**
     * Lists all found DTOs.
     *
     * @return Returns a list of DTOs.
     */
    List<DTO> list();

    /**
     * Deletes the entity by forwarded ID.
     *
     * @param id ID of the entity to delete.
     * @return Returns true if entity is deleted.
     */
    Boolean delete(Integer id);
}
