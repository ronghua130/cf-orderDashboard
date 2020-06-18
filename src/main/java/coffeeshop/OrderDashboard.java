package coffeeshop;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="OrderDashboard_table")
public class OrderDashboard {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long orderId;
        private Long coffeeId;
        private Integer qty;
        private Float price;
        private String coffeeName;
        private String orderStatus;
        private String paymentStatus;
        private String makeStatus;
        private Float totalAmount;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getOrderId() {
            return orderId;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }
        public Long getCoffeeId() {
            return coffeeId;
        }

        public void setCoffeeId(Long coffeeId) {
            this.coffeeId = coffeeId;
        }
        public Integer getQty() {
            return qty;
        }

        public void setQty(Integer qty) {
            this.qty = qty;
        }
        public Float getPrice() {
            return price;
        }

        public void setPrice(Float price) {
            this.price = price;
        }
        public String getCoffeeName() {
            return coffeeName;
        }

        public void setCoffeeName(String coffeeName) {
            this.coffeeName = coffeeName;
        }
        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }
        public String getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
        }
        public String getMakeStatus() {
            return makeStatus;
        }

        public void setMakeStatus(String makeStatus) {
            this.makeStatus = makeStatus;
        }
        public Float getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(Float totalAmount) {
            this.totalAmount = totalAmount;
        }

}
