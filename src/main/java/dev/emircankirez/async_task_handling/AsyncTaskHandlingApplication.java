package dev.emircankirez.async_task_handling;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AsyncTaskHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncTaskHandlingApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(TaskHandlerService taskHandlerService) {
		return args -> {
			taskHandlerService.execute();
			taskHandlerService.logDefaultExecutorConfigurations();
		};
	}
}
