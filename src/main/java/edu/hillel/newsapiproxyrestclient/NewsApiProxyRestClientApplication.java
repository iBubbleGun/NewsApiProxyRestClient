package edu.hillel.newsapiproxyrestclient;

import edu.hillel.newsapiproxyrestclient.services.NewsApiProxyClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NewsApiProxyRestClientApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(NewsApiProxyRestClientApplication.class, args);
        final NewsApiProxyClient client = applicationContext.getBean(NewsApiProxyClient.class);
        client.getTopNews("Ukraine", "").stream().map(topNews -> topNews + "\n").forEach(System.out::println);
        client.getAllNews("Ukraine", "").stream().map(allNews -> allNews + "\n").forEach(System.out::println);
    }
}
