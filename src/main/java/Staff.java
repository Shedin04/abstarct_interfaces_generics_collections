import java.math.BigDecimal;

public class Staff extends Person{
    private String position;

    protected Staff(String name, String position, BigDecimal salary) {
        super(name, salary);
        this.position = position;
    }

    protected String getPosition() {
        return position;
    }

    private void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee: {" +
                "Id=" + getCurId() +
                ", name='" + getName() + '\'' +
                ", position=" + getPosition() +
                ", salary=" + getSalary() +
                '}';
    }
}
