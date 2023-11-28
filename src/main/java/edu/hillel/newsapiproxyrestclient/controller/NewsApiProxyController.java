package edu.hillel.newsapiproxyrestclient.controller;

import edu.hillel.newsapiproxyrestclient.services.NewsApiProxyClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsApiProxyController {

    private final NewsApiProxyClient newsApiProxyClient;

    public NewsApiProxyController(NewsApiProxyClient newsApiProxyClient) {
        this.newsApiProxyClient = newsApiProxyClient;
    }

    @GetMapping("/getTopNews")
    public List<String> getTopNews(@RequestParam String keyWord, @RequestParam String lang) {
        return newsApiProxyClient.getTopNews(keyWord, lang);
    }

    @GetMapping("/getAllNews")
    public List<String> getAllNews(@RequestParam String keyWord, @RequestParam String lang) {
        return newsApiProxyClient.getAllNews(keyWord, lang);
    }
}
