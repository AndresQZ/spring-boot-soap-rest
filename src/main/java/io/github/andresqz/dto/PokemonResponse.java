package io.github.andresqz.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
public class PokemonResponse {
    private Ability[] abilities;
    @JsonProperty("base_experience")
    private long baseExperience;
    private Cries cries;
    private Species[] forms;
    private GameIndex[] gameIndices;
    private long height;
    @JsonProperty("held_items")
    private HeldItem[] heldItems;
    private long id;
    private boolean isDefault;
    @JsonProperty("location_area_encounters")
    private String locationAreaEncounters;
    private Move[] moves;
    private String name;
    private long order;
    private Object[] pastAbilities;
    private Object[] pastTypes;
    private Species species;
    //private Sprites sprites;
    //private Stat[] stats;
    //private Type[] types;
    private long weight;


}
