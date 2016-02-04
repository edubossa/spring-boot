package br.com.ews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Execute profile 
 * <p>
 * mvn clean package -Dspring.profiles.active=dev spring-boot:run
 * <p>
 * java -jar -Dspring.profiles.active=prod spring-boot-profile-specific-properties-0.0.1-SNAPSHOT.jar 
 * 
 * @author Eduardo Wallace
 */
@SpringBootApplication
public class SpringBootDemoWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoWebappApplication.class, args);
	}
}
