import java.math.BigDecimal;

public class Items {
    private static int id;
    private final int curId;
    private String name;
    private String type;
    private BigDecimal price;

    static {
        id = 00;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    protected Items(String type, String name, BigDecimal price) {
        curId=++id;
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item[" + curId +
                "]:{name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
