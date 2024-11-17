package com.website.site.tableGene.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tableGenerator.TableMetadataExtractor;

import javax.sql.DataSource;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Component
public class EntityClassGenerator {

    @Autowired
    private DataSource dataSource;

    public void generateEntityClass(String tableName) throws IOException, SQLException {
        try (Connection connection = dataSource.getConnection()) {
            List<TableMetadataExtractor.ColumnMeta> columns = TableMetadataExtractor.getTableColumns(tableName, connection);
            generateEntityClass(tableName, columns);
        }
    }

    private void generateEntityClass(String tableName, List<TableMetadataExtractor.ColumnMeta> columns) throws IOException {
        String className = toClassName(tableName);

        StringBuilder classContent = new StringBuilder();
        classContent.append("import javax.persistence.*;\n\n");
        classContent.append("@Entity\n");
        classContent.append("@Table(name = \"" + tableName + "\")\n");
        classContent.append("public class ").append(className).append(" {\n\n");

        for (TableMetadataExtractor.ColumnMeta column : columns) {
            String fieldType = mapSqlTypeToJavaType(column.columnType);
            String fieldName = toFieldName(column.columnName);

            if (column.isAutoIncrement) {
                classContent.append("    @Id\n");
                classContent.append("    @GeneratedValue(strategy = GenerationType.IDENTITY)\n");
            }

            classContent.append("    @Column(name = \"").append(column.columnName).append("\"");
            if (!column.isNullable) {
                classContent.append(", nullable = false");
            }
            classContent.append(")\n");
            classContent.append("    private ").append(fieldType).append(" ").append(fieldName).append(";\n\n");
        }

        classContent.append("    // Getters and Setters\n");
        for (TableMetadataExtractor.ColumnMeta column : columns) {
            String fieldType = mapSqlTypeToJavaType(column.columnType);
            String fieldName = toFieldName(column.columnName);
            String methodName = toClassName(column.columnName);

            // Getter
            classContent.append("    public ").append(fieldType).append(" get").append(methodName).append("() {\n");
            classContent.append("        return ").append(fieldName).append(";\n");
            classContent.append("    }\n\n");

            // Setter
            classContent.append("    public void set").append(methodName).append("(").append(fieldType).append(" ").append(fieldName).append(") {\n");
            classContent.append("        this.").append(fieldName).append(" = ").append(fieldName).append(";\n");
            classContent.append("    }\n\n");
        }

        classContent.append("}\n");

        FileWriter writer = new FileWriter(className + ".java");
        writer.write(classContent.toString());
        writer.close();

        System.out.println("Entity class " + className + ".java generated successfully!");
    }

    // Other methods (toClassName, toFieldName, mapSqlTypeToJavaType) remain the same

    private static String toClassName(String tableName) {
        String[] parts = tableName.split("_");
        StringBuilder className = new StringBuilder();
        for (String part : parts) {
            className.append(part.substring(0, 1).toUpperCase()).append(part.substring(1).toLowerCase());
        }
        return className.toString();
    }

    private static String mapSqlTypeToJavaType(String sqlType) {
        switch (sqlType) {
            case "VARCHAR":
            case "CHAR":
            case "TEXT":
                return "String";
            case "INT":
            case "INTEGER":
            case "SMALLINT":
                return "Integer";
            case "BIGINT":
                return "Long";
            case "FLOAT":
                return "Float";
            case "DOUBLE":
                return "Double";
            case "DATE":
                return "java.sql.Date";
            case "TIMESTAMP":
                return "java.sql.Timestamp";
            case "BOOLEAN":
                return "Boolean";
            default:
                return "Object"; // Use Object for unknown SQL types
        }
    }

    private static String toFieldName(String columnName) {
        String[] parts = columnName.split("_");
        StringBuilder fieldName = new StringBuilder(parts[0].toLowerCase());
        for (int i = 1; i < parts.length; i++) {
            fieldName.append(parts[i].substring(0, 1).toUpperCase()).append(parts[i].substring(1).toLowerCase());
        }
        return fieldName.toString();
    }
    
    
    
}

