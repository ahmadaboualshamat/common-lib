package com.commonlib.service;

import com.commonlib.domain.entity.ApplicationConfiguration;
import com.commonlib.domain.mapper.ApplicationConfigurationMapper;
import com.commonlib.domain.repository.ApplicationConfigurationRepository;
import com.commonlib.service.dto.ApplicationConfigurationDTO;
import com.commonlib.service.dto.UserDTO;
import com.commonlib.util.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@Transactional
//@EntityLogger(loggerClass = UserActionLogger.class,
//        createMethods = {"create"},
//        updateMethods = {"update"},
//        deleteMethods = {"remove"})
public class ApplicationConfigurationService {

//    @Autowired
//    private ApplicationConfigurationRepository applicationConfigurationRepository;
//
//    @Autowired
//    private ApplicationConfigurationMapper applicationConfigurationMapper;
//
//    @Cacheable(value = "applicationConfigurations", key = "#name")
//    public ApplicationConfigurationDTO findByName(String name) {
//        Optional<ApplicationConfiguration> applicationConfiguration = applicationConfigurationRepository.findByName(name);
//        if (applicationConfiguration.isEmpty()) {
//            throw new BadRequestException("applicationConfiguration not found");
//        }
//        return applicationConfigurationMapper.toDto(applicationConfiguration.get());
//    }

}
