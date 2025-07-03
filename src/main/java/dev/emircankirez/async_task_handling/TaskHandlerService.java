package dev.emircankirez.async_task_handling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;

@Service
public class TaskHandlerService {

    Logger logger = LoggerFactory.getLogger(TaskHandlerService.class);
    private final Executor executor;

    // it's not mandatory to use @Qualifier because there is only one executor bean defined
    public TaskHandlerService(@Qualifier("myTaskExecutor") Executor executor) {
        this.executor = executor;
    }

    @Async
    public void execute() {
        logger.info("Executing task...");
        delay();
        logger.info("Task execution completed.");
    }

    private void delay() {
        try {
            Thread.sleep(5000); // Simulate a delay of 5 seconds
        } catch (InterruptedException e) {
            logger.error("Task interrupted", e);
        }
    }

    public void logDefaultExecutorConfigurations() {
        ThreadPoolTaskExecutor poolTaskExecutor = (ThreadPoolTaskExecutor) executor;
        logger.info("Core Pool Size: {}", poolTaskExecutor.getCorePoolSize());
        logger.info("Max Pool Size: {}", poolTaskExecutor.getMaxPoolSize());
        logger.info("Queue Capacity: {}", poolTaskExecutor.getQueueCapacity());
    }
}
