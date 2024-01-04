package org.example.config.init;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Order;
import org.example.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import java.io.File;

@Configuration
public class InitConfig {

    @Value("classpath:test_data.json")
    private Resource dbTestDataFile;

    @Value("${need.init}")
    private boolean needInit;

    @Bean
    public CommandLineRunner dbInit(ObjectMapper objectMapper, OrdersRepository ordersRepository) {
        return (commandLineArgs) -> {
            if (needInit) {
                final File file = dbTestDataFile.getFile();
                final Order[] orders = objectMapper.readValue(file, Order[].class);
                for (Order order : orders) {
                    ordersRepository.save(order).subscribe((o) -> {
                        System.out.println("Succesfully saved " + o);
                        System.out.println("Thread: " + Thread.currentThread());
                    });
                }
            }
        };
    }
}
