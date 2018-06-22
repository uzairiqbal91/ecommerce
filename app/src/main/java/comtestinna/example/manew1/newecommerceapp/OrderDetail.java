package comtestinna.example.manew1.newecommerceapp;

public class OrderDetail {

    private String orderId;
    private String orderDate;
    private String orderAmount;
    private String orderQty;

    public OrderDetail(String orderId,String orderDate, String orderAmount, String orderQty) {
        this.orderId=orderId;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.orderQty = orderQty;
    }

    public  String getOrderId() {
        return orderId;
    }

    public  void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(String orderQty) {
        this.orderQty = orderQty;
    }
}
