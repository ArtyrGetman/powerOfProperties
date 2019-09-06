package com.properties.examples.examples.convertors_example;

import com.properties.examples.examples.convertors_example.client.VehicleDtoList;
import com.properties.examples.examples.convertors_example.server.VehicleDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class RestTemplateService {

    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;
    private static final String url = "http://localhost:8080/system_a/get";


    public String postForObjectRestTemplateRequest(String url, String strBodyForSend) {
        HttpEntity<String> requestHttpEntity = null;
        try {
            requestHttpEntity = new HttpEntity<>(strBodyForSend, httpHeaders);
            return restTemplate
                    .postForObject(url, requestHttpEntity, String.class);
        } catch (RestClientException e) {
            log.error(" Возникли проблемы при запросе по адресу {}  с телом {} . \n {}", url, requestHttpEntity, e);
        }
        return null;
    }


    public VehicleDtoList getData() {
        VehicleDto[] vehicleDto
                = restTemplate.getForObject(url, VehicleDto[].class);
        List<VehicleDto> dtoList = new ArrayList<>(Arrays.asList(vehicleDto));
        return new VehicleDtoList(dtoList);

    }
}
