package com.commonlib.domain.entity;

import com.commonlib.util.converter.LocalDateTimeConverter;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;


@Data
@Entity
@Table(name = "sys_application_configuration")
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@JsonInclude(value = NON_EMPTY)
public class ApplicationConfiguration /*extends AbstractEntity*/ {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apcoSeqGen")
    @SequenceGenerator(name = "apcoSeqGen", sequenceName = "apco_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String value;

    @Column(name = "created_date")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_date")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime modifiedDate;

    @Column(name = "modified_by")
    private String modifiedBy;
}
