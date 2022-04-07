package visa.vttp.paf.day14purchaseOrder.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import visa.vttp.paf.day14purchaseOrder.exception.PurchaseOrderException;
import visa.vttp.paf.day14purchaseOrder.model.LineItem;
import visa.vttp.paf.day14purchaseOrder.model.OrderFormWrapper;
import visa.vttp.paf.day14purchaseOrder.model.PurchaseOrder;
import visa.vttp.paf.day14purchaseOrder.repo.KwikmartRepo;

@Service
public class PurchaseOrderService {
    private Logger logger = LoggerFactory.getLogger(PurchaseOrderService.class);
    
    @Autowired
    private KwikmartRepo kRepo;

    public void submitPurchaseOrder(OrderFormWrapper ofw) {
        PurchaseOrder po = ofw.getPo();
        List<LineItem> items = ofw.getLineItems();

        for (LineItem itm : items) {
            Integer sku = itm.getSKU();
            if (sku == null) {
                break;
            } else if (!kRepo.hasSKU(sku)) {
                throw new PurchaseOrderException("SKU not found: " + sku);
            }
        }

        kRepo.insertPurchaseOrder(po);
        items.stream()
            .filter(v -> !v.isEmpty() )
            .forEach((LineItem v) -> {
                kRepo.insertLineItem(v);
            });
    }

}
