package com.commonlib.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"name"}, callSuper = true)
@Builder
public class UserDTO extends AbstractDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("content")
    private String name;

}
