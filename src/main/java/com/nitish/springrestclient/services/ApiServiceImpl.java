package com.nitish.springrestclient.services;

import com.nitish.api.domain.User;
import com.nitish.api.domain.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private RestTemplate restTemplate;
    private String api_url;

    public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
    }

    @Override
    public List<User> getUsers(Integer limit) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(api_url).queryParam("limit", limit);

        UserData userData = restTemplate.getForObject(uriBuilder.toString(), UserData.class);
        return userData.getData();
    }
}
