package edu.hillel.newsapiproxyrestclient.controller;

import edu.hillel.newsapiproxyrestclient.services.NewsApiProxyClient;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NewsApiProxyController.class)
public class NewsApiProxyControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private NewsApiProxyClient newsApiProxyClient;

    @Test
    public void testGetTopNews() throws Exception {
        Mockito.when(newsApiProxyClient.getTopNews("test_keyword", "test_lang")).thenReturn(getTestNews().subList(0, 2));
        mvc.perform(get("/news/getTopNews?keyWord=test_keyword&lang=test_lang"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void testGetAllNews() throws Exception {
        Mockito.when(newsApiProxyClient.getAllNews("test_keyword", "test_lang")).thenReturn(getTestNews());
        mvc.perform(get("/news/getAllNews?keyWord=test_keyword&lang=test_lang"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(5));
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
