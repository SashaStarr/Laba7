package ua.lviv.iot.string.firstRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan({ "ua.lviv.iot.string.controller", "ua.lviv.iot.string.firstRest",
"ua.lviv.iot.string.model" })
@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

}
