package com.api.inventoryservice.controller;

import com.api.inventoryservice.model.InventoryResponse;
import com.api.inventoryservice.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inventory")
@Slf4j
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        log.info("starting isInStock service");
        List<InventoryResponse> result = inventoryService.isInStock(skuCode);
        log.info("finished isInStock service");
        return result;
    }
}
