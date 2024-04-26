package io.github.andresqz.api.soap;

import github.io.andresqz.ws.*;
import io.github.andresqz.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static io.github.andresqz.constant.SpringWSConst.*;

@Endpoint
public class PokemonsEndpoint {

    @Autowired
    PokemonService pokemonService;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = LOCAL_PART_ABILITIES)
    @ResponsePayload
    public AbilitiesResponse abilities(@RequestPayload AbilitiesRequest request) throws Exception {

        AbilitiesResponse response = new AbilitiesResponse();
        response.getAbilities().addAll( pokemonService.getAbilities(request.getName()));
        return  response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = LOCAL_PART_BASE_EXPERIENCE)
    @ResponsePayload
    public BaseExperienceResponse base_experience(@RequestPayload BaseExperienceRequest request) throws Exception {

        BaseExperienceResponse response = new BaseExperienceResponse();
        response.setBaseExperience(pokemonService.getBaseExperience(request.getName()));
        return  response;
    }
//
///
////    @PayloadRoot(namespace = NAMESPACE_URI, localPart = LOCAL_PART_HELD_ITEMS)
////    @ResponsePayload
////    public GetAbilitiesResponse held_items(@RequestPayload  HeldItem request) throws Exception {
////
////        GetAbilitiesResponse response = new GetAbilitiesResponse();
////        response.getAbilities().addAll( pokemonService.getAbilities(request.getName()));
////        return  response;
////    }
////
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = LOCAL_PART_ID)
    @ResponsePayload
    public IdResponse id(@RequestPayload IdRequest request) throws Exception {

       IdResponse response = new IdResponse();
        response.setId(pokemonService.getId(request.getName()));
        return  response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = LOCAL_PART_NAME)
    @ResponsePayload
    public NameResponse name(@RequestPayload NameRequest request) throws Exception {

        NameResponse response = new NameResponse();
        response.setName(pokemonService.getName(request.getName()));
        return  response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = LOCAL_PART_LOCATION_AREA)
    @ResponsePayload
    public LocationAreaResponse location_area_encounters(@RequestPayload LocationAreaRequest request) throws Exception {

        LocationAreaResponse response = new LocationAreaResponse();
        response.setLocationArea(pokemonService.getLocationArea(request.getName()));
        return  response;
    }
}
