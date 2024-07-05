package com.commonlib.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Data
public abstract class AbstractDTO {

    @JsonProperty("createdDate")
    private LocalDateTime createdDate = LocalDateTime.now() ;

    @JsonProperty("createdBy")
    private String createdBy = "SYSTEM";

    @JsonProperty("modifiedDate")
    private LocalDateTime modifiedDate;

    @JsonProperty("modifiedBy")
    private String modifiedBy;

}
