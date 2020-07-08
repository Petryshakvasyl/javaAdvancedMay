package ua.lviv.lgs.pv.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"ua.lviv.lgs.pv.springcore.service", "ua.lviv.lgs.pv.springcore.repository"})
public class SpringCoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringCoreApplication.class, args);
	}

}
