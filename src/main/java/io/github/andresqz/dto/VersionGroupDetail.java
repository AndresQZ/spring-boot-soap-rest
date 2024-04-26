package io.github.andresqz.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class VersionGroupDetail {
    private long levelLearnedAt;
    private Species moveLearnMethod;
    private Species versionGroup;
}
