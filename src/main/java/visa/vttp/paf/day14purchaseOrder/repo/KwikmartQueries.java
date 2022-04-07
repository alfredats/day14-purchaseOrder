package visa.vttp.paf.day14purchaseOrder.repo;

public interface KwikmartQueries {
    final String SQL_GET_SKU_BY_ID = "SELECT * FROM sku WHERE prod_id = ?;";
    final String SQL_INSERT_PURCHASE_ORDER = """
        INSERT purchase_order(
            order_id,
            name,
            order_date
        ) VALUES 
            (?,?,?);
            """;
    final String SQL_INSERT_LINE_ITEM = """
        INSERT line_item(
            quantity,
            order_id,
            prod_id    
        ) VALUES 
            (?, ?, ?);
            """;
    
}
