import java.math.BigDecimal;

public class Player<T>{ //T чтобы number был любого типа (String/int/BigDecimal)
    private static int id;
    private final int curId;
    private String name;
    private T number;
    private BigDecimal salary;

    static {
        id = 00;
    }

    protected Player(String name, T number, BigDecimal salary) { // protected - только этот класс и наследники
        curId=++id;
        this.name = name;
        this.number = number;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Player{" +
                "curId=" + curId +
                ", name='" + getName() + '\'' +
                ", number=" + getNumber() +
                ", salary=" + getSalary() +
                '}';
    }

    protected String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    protected T getNumber() {
        return number;
    }

    private void setNumber(T number) {
        this.number = number;
    }

    protected BigDecimal getSalary() {
        return salary;
    }

    protected void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
