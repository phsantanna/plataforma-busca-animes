package com.platform.tracking.anime.service;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Service
public class AnimeService {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${kitsu.api.base-url}")
    private String apiBaseUrl;
    @Value("${kitsu.api.access-token}")
    private String accessToken;

    public JsonNode getAnimeDataById(String animeId) {
        String apiUrl = apiBaseUrl + animeId;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.api+json");
        headers.set("Content-Type", "application/vnd.api+json");
        headers.set("Authorization", "Bearer " + accessToken);

        System.out.println("Chamando a API Kitsu...");
        try {
            ResponseEntity<JsonNode> responseEntity = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.GET,
                    new HttpEntity<>(headers),
                    JsonNode.class
            );

            handleResponse(responseEntity);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                JsonNode jsonNode = responseEntity.getBody();

                System.out.println("Dados recebidos do JSON: " + jsonNode);

                return jsonNode;
            }
        } catch (HttpClientErrorException e) {
            handleHttpClientErrorException(e);
        }

        return null;
    }
    private void handleResponse(ResponseEntity<JsonNode> responseEntity) {
        System.out.println("Status da resposta: " + responseEntity.getStatusCode());

        HttpHeaders headers = responseEntity.getHeaders();
        System.out.println("Cabeçalhos da resposta: " + headers);

        JsonNode responseBody = responseEntity.getBody();
        System.out.println("Corpo da resposta: " + responseBody);
    }
    private void handleHttpClientErrorException(HttpClientErrorException e) {
        if (e.getStatusCode() == HttpStatus.NOT_ACCEPTABLE) {
            System.err.println("Erro 406 - Not Acceptable: " + e.getResponseBodyAsString());
        } else {
            System.err.println("Erro desconhecido: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
        }
    }

}
