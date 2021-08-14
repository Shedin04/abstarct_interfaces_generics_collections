import java.math.BigDecimal;

public class Player<T> extends Person<T>{ //T чтобы number был любого типа (String/int/BigDecimal)
    private T number;

    protected Player(String name, T number, BigDecimal salary) {
        super(name, salary);
        this.number = number;
    }

    protected T getNumber() {
        return number;
    }

    private void setNumber(T number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Player: {" +
                "Id=" + getCurId() +
                ", name='" + getName() + '\'' +
                ", number=" + getNumber() +
                ", salary=" + getSalary() +
                '}';
    }
}
