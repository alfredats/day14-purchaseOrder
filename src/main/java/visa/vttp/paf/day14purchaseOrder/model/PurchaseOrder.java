package visa.vttp.paf.day14purchaseOrder.model;

public class PurchaseOrder {
    private String orderID;
    private String name;
    private String date;
    
    public PurchaseOrder() {}
    public PurchaseOrder(String orderID) {this.orderID = orderID; }

    @Override
    public String toString() {
        return "PurchaseOrder [date=" + date + ", name=" + name + ", orderID=" + orderID + "]";
    }
    /**
     * @return String return the orderID
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

}
