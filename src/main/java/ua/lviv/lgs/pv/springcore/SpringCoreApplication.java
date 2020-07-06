package ua.lviv.lgs.pv.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ua.lviv.lgs.pv.springcore.repository.BasketRepository;
import ua.lviv.lgs.pv.springcore.repository.UserRepository;
import ua.lviv.lgs.pv.springcore.service.UserService;


@SpringBootApplication
@ComponentScan({"ua.lviv.lgs.pv.springcore.service", "ua.lviv.lgs.pv.springcore.repository"})
public class SpringCoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringCoreApplication.class, args);
		run(context);

	}

	private static void run(ApplicationContext context) {
		UserService userService = context.getBean(UserService.class);
		userService.findAll();
		BasketRepository basketRepository = context.getBean(BasketRepository.class);
		UserRepository userRepository = context.getBean(UserRepository.class);
		System.out.println("============================");
//		basketRepository.findAll();
//		userRepository.findAll();
	}

}
