package io.github.andresqz.services;


import github.io.andresqz.ws.AbilitiesMetadata;
import io.github.andresqz.api.rest.PokemonRestService;
import io.github.andresqz.utils.PokemonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PokemonService {

    @Autowired
    PokemonRestService pokemonRestService;

    public List<AbilitiesMetadata> getAbilities(String pokemonName) throws Exception {

        var pokemon = pokemonRestService.getPokemonByName(pokemonName);
        if(Objects.nonNull(pokemon) && Objects.nonNull(pokemon.getAbilities())) {
           return PokemonUtil.compositeGetAbilities(pokemon);
        } else  {
            return new ArrayList<AbilitiesMetadata>();
        }
    }

    public Long getBaseExperience(String pokemonName) throws Exception {

        var pokemon = pokemonRestService.getPokemonByName(pokemonName);
        if(Objects.nonNull(pokemon) && Objects.nonNull(pokemon.getBaseExperience())) {
            return pokemon.getBaseExperience();
        } else  {
            return new Long(0);
        }
    }



    public String getLocationArea(String pokemonName) throws Exception {
        var pokemon = pokemonRestService.getPokemonByName(pokemonName);
        if(Objects.nonNull(pokemon) && Objects.nonNull(pokemon.getLocationAreaEncounters())) {
            return pokemon.getLocationAreaEncounters();
        } else  {
            return "";
        }
    }

    public Long getId(String pokemonName) throws Exception {
        var pokemon = pokemonRestService.getPokemonByName(pokemonName);
        if(Objects.nonNull(pokemon) && Objects.nonNull(pokemon.getId())) {
            return pokemon.getId();
        } else  {
            return new Long(0);
        }
    }

    public String getName(String pokemonName) throws Exception {
        var pokemon = pokemonRestService.getPokemonByName(pokemonName);
        if(Objects.nonNull(pokemon) && Objects.nonNull(pokemon.getName())) {
            return pokemon.getName();
        } else  {
            return "";
        }
    }





}
