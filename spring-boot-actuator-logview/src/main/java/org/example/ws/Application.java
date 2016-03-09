package org.example.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * https://github.com/lukashinsch/spring-boot-actuator-logview
 *
 * <p></p>
 *
 * <p></p>
 * http://localhost:8080/actuators/log
 * <p></p>
 * http://localhost:8080/actuators/log/search?term=9223372036854775807
 * <p></p>
 * http://localhost:8080/actuators/log/search?term=2016-03-09+15%3A45%3A00
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@EnableScheduling
@EnableAsync
public class Application {

    /**
     * Entry point for the application.
     * 
     * @param args Command line arguments.
     * @throws Exception Thrown when an unexpected Exception is thrown from the
     *         application.
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Create a CacheManager implementation class to be used by Spring where
     * <code>@Cacheable</code> annotations are applied.
     * 
     * @return A CacheManager instance.
     */
    @Bean
    public CacheManager cacheManager() {

        GuavaCacheManager cacheManager = new GuavaCacheManager("greetings");

        return cacheManager;
    }

}
