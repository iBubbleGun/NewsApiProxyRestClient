package edu.hillel.newsapiproxyrestclient.services;

import edu.hillel.newsapiproxyrestclient.configuration.Config;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NewsApiProxyClient {

    private final RestTemplate restTemplate;

    public NewsApiProxyClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<String> getTopNews(String keyWord, String lang) {
        final ParameterizedTypeReference<List<String>> responseType = new ParameterizedTypeReference<>() {
        };
        final RequestEntity<Void> requestEntity = RequestEntity
                .get(String.format(Config.NEWS_API_PROXY_SERVICE_HOST + "getTopNews?keyWord=%s&lang=%s", keyWord, lang))
                .accept(MediaType.APPLICATION_JSON).build();
        final ResponseEntity<List<String>> responseEntity = restTemplate.exchange(requestEntity, responseType);
        return responseEntity.getBody();
    }

    public List<String> getAllNews(String keyWord, String lang) {
        final ParameterizedTypeReference<List<String>> responseType = new ParameterizedTypeReference<>() {
        };
        final RequestEntity<Void> requestEntity = RequestEntity
                .get(String.format(Config.NEWS_API_PROXY_SERVICE_HOST + "getAllNews?keyWord=%s&lang=%s", keyWord, lang))
                .accept(MediaType.APPLICATION_JSON).build();
        final ResponseEntity<List<String>> responseEntity = restTemplate.exchange(requestEntity, responseType);
        return responseEntity.getBody();
    }
}
