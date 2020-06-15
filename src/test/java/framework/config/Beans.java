package framework.config;

import framework.entity.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Beans {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setIgnoreResourceNotFound(true);
        configurer.setIgnoreUnresolvablePlaceholders(true);

        List<Resource> resources = new ArrayList<>();
        resources.add(new ClassPathResource("config.properties"));

        configurer.setLocations(resources.toArray(new Resource[]{}));

        return configurer;
    }

    @Bean
    @Lazy
    public static Config config(@Value("${url}") String url,
                                @Value("${timeout}") int timeout,
                                @Value("${browser}") String browser) {
        return new Config(url, browser, timeout);
    }
}
