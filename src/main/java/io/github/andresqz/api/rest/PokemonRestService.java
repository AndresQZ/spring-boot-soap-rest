package io.github.andresqz.api.rest;

import io.github.andresqz.dto.PokemonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Slf4j
@Service
public class PokemonRestService {

    @Value("${api.rest.pokemon.uri}")
    String apiRestPokemonUri;


    @Autowired
    RestTemplate restTemplate;

    public PokemonResponse getPokemonByName(String name) throws Exception {
        PokemonResponse pokemon = null;
        String resourceUri = new StringBuilder().append(apiRestPokemonUri).append(name).toString();
        try {

            ResponseEntity<PokemonResponse> pokemonResponse = restTemplate.getForEntity(resourceUri, PokemonResponse.class);
            if (pokemonResponse.getStatusCode().equals(HttpStatus.OK)) {
                System.out.println(String.format("resourceUri: %s , response: %s", resourceUri, pokemonResponse.getBody().toString()));
                pokemon = Objects.requireNonNull(pokemonResponse.getBody());
            } else {
                System.out.println(String.format("resourceUri: %s , status: %s", resourceUri, pokemonResponse.getStatusCode()));
            }
        }
        catch (RestClientResponseException e) {
            System.out.println(String.format("failed endpoint %s , error:", resourceUri,e.getResponseBodyAsString()));
            throw new Exception("Invalid data");
        }
        return pokemon;
    }

}
