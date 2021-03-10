package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import tn.esprit.spring.entities.ImageStorageProperties;


@SpringBootApplication
@EnableAspectJAutoProxy
@EnableConfigurationProperties({
    ImageStorageProperties.class
})
public class KindergartenApplication {

	public static void main(String[] args) {
		SpringApplication.run(KindergartenApplication.class, args);
	}

}
