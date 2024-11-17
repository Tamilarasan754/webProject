package com.website.site.tableGene.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.website.site.tableGene.service.EntityGenerationService;

@RestController
public class EntityGenerationController {

    @Autowired
    private EntityGenerationService entityGenerationService;

    @GetMapping("/hi")
    public String hello()
    {
        return "Hi Toko";
    }                               

    @GetMapping("/generate-entity")
    public String generateEntity(@RequestParam String tableName) {
        entityGenerationService.generateEntityForTable(tableName);
        return "Entity class generated for table: " + tableName;
    }
}

