package com.properties.examples.examples.convertors_example.client;

import com.google.gson.Gson;
import com.properties.examples.examples.convertors_example.RestTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleClient {

    private final RestTemplateService restTemplateService;
    private final Gson gson;

    private String getData() {
        String dataPost = "";
        return restTemplateService.postForObjectRestTemplateRequest("", dataPost);
    }

    private VehicleDtoList getTypedResponse() {
        return gson.fromJson(getData(), VehicleDtoList.class);
    }
}
