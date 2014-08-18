package br.com.basico.spring4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.basico.spring4.service.MessageService;

@Configuration
@ComponentScan
public class Application {

	private static ApplicationContext context;

	@Bean
	MessageService mockMessageService() {
		return new MessageService() {
			@Override
			public String getMessage() {
				return "Hello World!";
			}
		};
	}

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(Application.class);
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		printer.printMessage();
	}
}
