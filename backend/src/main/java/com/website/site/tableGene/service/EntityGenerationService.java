package com.website.site.tableGene.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.site.tableGene.Entity.EntityClassGenerator;

import java.io.IOException;
import java.sql.SQLException;

@Service
public class EntityGenerationService {

    @Autowired
    private EntityClassGenerator entityClassGenerator;

    public void generateEntityForTable(String tableName) {
        try {
            entityClassGenerator.generateEntityClass(tableName);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
