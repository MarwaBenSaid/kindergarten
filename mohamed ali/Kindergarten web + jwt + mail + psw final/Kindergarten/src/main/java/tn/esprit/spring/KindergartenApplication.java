package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;



@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan("tn.esprit")
public class KindergartenApplication  {

	public static void main(String[] args) {
		SpringApplication.run(KindergartenApplication.class, args);
	}

}
