package tableGenerator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableMetadataExtractor {

    public static List<ColumnMeta> getTableColumns(String tableName, Connection connection) throws SQLException {
        List<ColumnMeta> columns = new ArrayList<>();
        DatabaseMetaData metaData = connection.getMetaData();
        
        // Retrieve the table columns
        ResultSet resultSet = metaData.getColumns(null, null, tableName, null);
        
        while (resultSet.next()) {
            String columnName = resultSet.getString("COLUMN_NAME");
            String columnType = resultSet.getString("TYPE_NAME");
            boolean isNullable = resultSet.getInt("NULLABLE") == DatabaseMetaData.columnNullable;
            boolean isAutoIncrement = "YES".equals(resultSet.getString("IS_AUTOINCREMENT"));
            
            columns.add(new ColumnMeta(columnName, columnType, isNullable, isAutoIncrement));
        }
        
        return columns;
    }
    
    // Column metadata model class
    public static class ColumnMeta {
        public String columnName;
        public String columnType;
        public boolean isNullable;
        public boolean isAutoIncrement;

        public ColumnMeta(String columnName, String columnType, boolean isNullable, boolean isAutoIncrement) {
            this.columnName = columnName;
            this.columnType = columnType;
            this.isNullable = isNullable;
            this.isAutoIncrement = isAutoIncrement;
        }
    }
}
