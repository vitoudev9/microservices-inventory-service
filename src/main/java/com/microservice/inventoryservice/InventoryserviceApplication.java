package com.microservice.inventoryservice;

import com.microservice.inventoryservice.model.Inventory;
import com.microservice.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryserviceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadInventoryData(InventoryRepository inventoryRepository) {
		return args -> {
			final Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("samsung_s24");
			inventory1.setQuantity(5);

			final Inventory inventory2 = new Inventory();
			inventory2.setSkuCode("iphone_16");
			inventory2.setQuantity(0);

			if (!inventoryRepository.findBySkuCode(inventory1.getSkuCode()).isPresent()) {
				inventoryRepository.save(inventory1);
			} else if (!inventoryRepository.findBySkuCode(inventory2.getSkuCode()).isPresent()) {
				inventoryRepository.save(inventory2);
			}

		};
	}

}
