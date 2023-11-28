package edu.hillel.newsapiproxyrestclient.services;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class NewsApiProxyClientTest {

    @InjectMocks
    private NewsApiProxyClient newsApiProxyClient;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetTopNews() {
        final List<String> expectedTopNews = getTestNews().subList(0, 2);

        Mockito.when(restTemplate.exchange(any(RequestEntity.class), any(ParameterizedTypeReference.class)))
                .thenReturn(new ResponseEntity<>(expectedTopNews, HttpStatus.OK));

        final List<String> actualTopNews = newsApiProxyClient.getTopNews("test_keyword", "test_lang");
        assertEquals(expectedTopNews, actualTopNews);
    }

    @Test
    public void testGetAllNews() {
        final List<String> expectedAllNews = getTestNews();

        Mockito.when(restTemplate.exchange(any(RequestEntity.class), any(ParameterizedTypeReference.class)))
                .thenReturn(new ResponseEntity<>(expectedAllNews, HttpStatus.OK));

        final List<String> actualAllNews = newsApiProxyClient.getAllNews("test_keyword", "test_lang");
        assertEquals(expectedAllNews, actualAllNews);
    }

    @Contract(pure = true)
    private @NotNull @Unmodifiable List<String> getTestNews() {
        String news1 = "Test 1.";
        String news2 = "Test 2";
        String news3 = "Test 3";
        String news4 = "Test 4";
        String news5 = "Test 5";
        return List.of(news1, news2, news3, news4, news5);
    }
}
