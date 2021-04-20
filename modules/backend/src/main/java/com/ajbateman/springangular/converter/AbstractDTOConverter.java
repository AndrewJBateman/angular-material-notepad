package com.ajbateman.springangular.converter;

import com.ajbateman.springangular.dto.BaseDTO;
import com.ajbateman.springangular.entity.DistributedEntity;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Abstract converter used to convert from ENTITY to DTO.
 *
 * @param <ENTITY> Entity to convert.
 * @param <DTO> DTO in which we are converting.
 */
public abstract class AbstractDTOConverter<ENTITY extends DistributedEntity, DTO extends BaseDTO> {

    /**
     * Converts forwarded entity into DTO.
     *
     * @param entity Entity to convert.
     * @return Converted entity as DTO.
     */
    public abstract DTO convert(final ENTITY entity);

    /**
     * Converts forwarded entity into DTO.
     *
     * @param entity Entity to convert.
     * @param dto DTO in which we are converting.
     */
    public void convert(final ENTITY entity, final DTO dto) {
        dto.setId(entity.getId());
        dto.setCreated(entity.getCreated());
        dto.setModified(entity.getModified());
    }

    /**
     * Convert forwarded entities to list of DTOs.
     *
     * @param entities Entities to convert.
     * @return List of converted DTOs.
     */
    public List<DTO> convertList(final List<ENTITY> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return Collections.emptyList();
        }

        return entities.stream().sequential().map(this::convert).collect(Collectors.toList());
    }
}
