package com.api.inventoryservice.service;

import com.api.inventoryservice.model.Inventory;
import com.api.inventoryservice.model.InventoryResponse;
import com.api.inventoryservice.repository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode){
        log.info("searching the database");
        List<Inventory> inventories = inventoryRepository.findBySkuCodeIn(skuCode).stream().toList();
        List<InventoryResponse> inventoryResponses = inventories.stream().map(this::map).toList();
        log.info("data retrieved {}", inventoryResponses);
        return inventoryResponses;
    }

    private InventoryResponse map(Inventory inventory) {
        return InventoryResponse.builder()
                .skuCode(inventory.getSkuCode())
                .isInStock(inventory.getQuantity() > 0)
                .build();
    }
}
