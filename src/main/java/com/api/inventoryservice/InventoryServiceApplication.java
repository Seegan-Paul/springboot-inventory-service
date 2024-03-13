package com.api.inventoryservice;

import com.api.inventoryservice.model.Inventory;
import com.api.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory = Inventory.builder()
					.skuCode("IPhone")
					.quantity(1)
					.build();
			inventoryRepository.save(inventory);
			Inventory inventory1 = Inventory.builder()
					.skuCode("IPhone3")
					.quantity(0)
					.build();
			inventoryRepository.save(inventory1);
		};
	}

}
