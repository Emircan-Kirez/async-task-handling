package dev.emircankirez.async_task_handling;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolConfig {

    // it's not mandatory to give a name to the bean
    @Bean(name = "myTaskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // Minimum number of threads
        executor.setMaxPoolSize(10); // Maximum number of threads
        executor.setQueueCapacity(100); // Capacity of the queue for tasks
        executor.setThreadNamePrefix("AsyncTask-"); // Prefix for thread names
        return executor;
    }

}
