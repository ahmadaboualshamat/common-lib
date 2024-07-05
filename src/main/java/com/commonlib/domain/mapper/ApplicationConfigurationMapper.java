package com.commonlib.domain.mapper;

import com.commonlib.domain.entity.ApplicationConfiguration;
import com.commonlib.service.dto.ApplicationConfigurationDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ApplicationConfigurationMapper extends ModelMapper implements EntityMapper<ApplicationConfigurationDTO, ApplicationConfiguration> {

    @Override
    public ApplicationConfiguration toEntity(ApplicationConfigurationDTO userDTO) {
        return map(userDTO, ApplicationConfiguration.class);
    }

    @Override
    public ApplicationConfigurationDTO toDto(ApplicationConfiguration user) {
        return map(user, ApplicationConfigurationDTO.class);
    }
}
