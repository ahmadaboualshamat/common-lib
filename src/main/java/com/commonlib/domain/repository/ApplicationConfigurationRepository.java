package com.commonlib.domain.repository;

import com.commonlib.domain.entity.ApplicationConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationConfigurationRepository extends JpaRepository<ApplicationConfiguration, Long> {
    public Optional<ApplicationConfiguration> findByName(String name);
}
