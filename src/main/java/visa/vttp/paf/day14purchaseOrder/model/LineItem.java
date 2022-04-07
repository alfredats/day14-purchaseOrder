package visa.vttp.paf.day14purchaseOrder.model;

public class LineItem {
    private String orderID;
    private Integer SKU;
    private Integer QTY;

    public LineItem() {};
    public LineItem(String orderID) {this.orderID = orderID;}

    @Override
    public String toString() {
        return "LineItem [QTY=" + QTY + ", SKU=" + SKU + ", orderID=" + orderID + "]";
    }

    public boolean isEmpty() {
        return this.SKU == null || this.QTY == null;
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
     * @return Integer return the QTY
     */
    public Integer getQTY() {
        return QTY;
    }

    /**
     * @param QTY the QTY to set
     */
    public void setQTY(Integer QTY) {
        this.QTY = QTY;
    }


    /**
     * @return Integer return the SKU
     */
    public Integer getSKU() {
        return SKU;
    }

    /**
     * @param SKU the SKU to set
     */
    public void setSKU(Integer SKU) {
        this.SKU = SKU;
    }

}
