package cart;

import java.lang.Exception;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		context.close();
	}
}

@Component
class ItemCommandLineRunner implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;

	@Override
	public void run(String... args) throws Exception {
		ItemRepository itemRepository = context.getBean(ItemRepository.class);

		for (Item item : itemRepository.findAll()) {
			System.out.println(item.toString());
		}
	}
}

