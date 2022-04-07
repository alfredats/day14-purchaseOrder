package visa.vttp.paf.day14purchaseOrder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderFormWrapper {
    private String id;
    private PurchaseOrder po;
    private List<LineItem> lineItems;

    public OrderFormWrapper() {
        final String hashStr = UUID.randomUUID().toString(); 
        this.id = hashStr.substring(0,8);
        this.po = new PurchaseOrder(this.id);
        this.lineItems = new ArrayList<>(4);

        this.lineItems.add(new LineItem(this.id));
        this.lineItems.add(new LineItem(this.id));
        this.lineItems.add(new LineItem(this.id));
        this.lineItems.add(new LineItem(this.id));
    }


    @Override
    public String toString() {
        return "OrderFormWrapper [id=" + id + ", lineItems=" + lineItems + ", po=" + po + "]";
    }

    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return PurchaseOrder return the po
     */
    public PurchaseOrder getPo() {
        return po;
    }

    /**
     * @param po the po to set
     */
    public void setPo(PurchaseOrder po) {
        this.po = po;
    }

    /**
     * @return List<LineItem> return the lineItems
     */
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    /**
     * @param lineItems the lineItems to set
     */
    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

}
