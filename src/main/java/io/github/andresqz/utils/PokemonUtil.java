package io.github.andresqz.utils;

import github.io.andresqz.ws.AbilitiesMetadata;
import github.io.andresqz.ws.Ability;
import io.github.andresqz.dto.PokemonResponse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PokemonUtil {

    public static List<AbilitiesMetadata> compositeGetAbilities(PokemonResponse pokemon) {

       var abilities = Arrays.stream(pokemon.getAbilities()).map(ability -> {
            Ability abilityPo = new Ability();
            abilityPo.setName(ability.getAbility().getName());
            abilityPo.setUrl(ability.getAbility().getUrl());

            AbilitiesMetadata abilitiesMetadata = new AbilitiesMetadata();
           abilitiesMetadata.setSlot(ability.getSlot());
           abilitiesMetadata.setIsHidden(ability.isHidden());
           abilitiesMetadata.setAbility(abilityPo);
            return  abilitiesMetadata;
        }).collect(Collectors.toList());
      return abilities;

    }
}
