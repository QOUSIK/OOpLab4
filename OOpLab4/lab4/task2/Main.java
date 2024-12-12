import java.util.Date;
import java.util.List;

public class Order {
    private final int id;
    private final List<String> items;
    private final double totalPrice;
    private final String deliveryAddress;
    private final boolean giftWrap;
    private final String note;
    private final Date deliveryDate;
    private final String couponCode;

    private Order(OrderBuilder builder) {
        this.id = builder.id;
        this.items = builder.items;
        this.totalPrice = builder.totalPrice;
        this.deliveryAddress = builder.deliveryAddress;
        this.giftWrap = builder.giftWrap;
        this.note = builder.note;
        this.deliveryDate = builder.deliveryDate;
        this.couponCode = builder.couponCode;
    }

    public static class OrderBuilder {
        private final int id;
        private final List<String> items;
        private final double totalPrice;

        private String deliveryAddress;
        private boolean giftWrap;
        private String note;
        private Date deliveryDate;
        private String couponCode;

        public OrderBuilder(int id, List<String> items, double totalPrice) {
            this.id = id;
            this.items = items;
            this.totalPrice = totalPrice;
        }

        public OrderBuilder withDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public OrderBuilder withGiftWrap(boolean giftWrap) {
            this.giftWrap = giftWrap;
            return this;
        }

        public OrderBuilder withNote(String note) {
            this.note = note;
            return this;
        }

        public OrderBuilder withDeliveryDate(Date deliveryDate) {
            this.deliveryDate = deliveryDate;
            return this;
        }

        public OrderBuilder withCouponCode(String couponCode) {
            this.couponCode = couponCode;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}

class Main {
    public static void main(String[] args) {
        List<String> itemsList = List.of("Laptop", "Mouse", "Keyboard");
        double totalPrice = 1500.0;

        Order order = new Order.OrderBuilder(1, itemsList, totalPrice)
                .withDeliveryAddress("Київ, вул. Хрещатик, 1")
                .withGiftWrap(true)
                .withNote("Будь ласка, зателефонуйте за годину до доставки")
                .withDeliveryDate(new Date())
                .withCouponCode("DISCOUNT10")
                .build();

        System.out.println("Order created successfully!");
    }
}
