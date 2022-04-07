package visa.vttp.paf.day14purchaseOrder.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import visa.vttp.paf.day14purchaseOrder.model.LineItem;
import visa.vttp.paf.day14purchaseOrder.model.PurchaseOrder;

import static visa.vttp.paf.day14purchaseOrder.repo.KwikmartQueries.SQL_GET_SKU_BY_ID;
import static visa.vttp.paf.day14purchaseOrder.repo.KwikmartQueries.SQL_INSERT_LINE_ITEM;
import static visa.vttp.paf.day14purchaseOrder.repo.KwikmartQueries.SQL_INSERT_PURCHASE_ORDER;

@Repository
public class KwikmartRepo {

    @Autowired
    private JdbcTemplate jt;

    public boolean hasSKU(Integer SKU) {
        final SqlRowSet rs = jt.queryForRowSet(SQL_GET_SKU_BY_ID, SKU);
        return rs.next();
    }
    

    public boolean insertLineItem(LineItem item) throws DataAccessException{
        final int rows = jt.update(
            SQL_INSERT_LINE_ITEM, 
            item.getQTY(), 
            item.getOrderID(), 
            item.getSKU());
        return rows == 1;
    }

    public boolean insertPurchaseOrder(PurchaseOrder po) {
        final int rows = jt.update(
            SQL_INSERT_PURCHASE_ORDER,
            po.getOrderID(),
            po.getName(),
            po.getDate()
        );
        return rows == 1;
    }
   
}
