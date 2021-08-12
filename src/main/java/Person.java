import java.math.BigDecimal;

abstract public class Person<T> {
    private static int id;
    private final int curId;
    private String name;
    private BigDecimal salary;
    private static int index;

    static {
        id = 00;
        index=0;
    }

    protected Person(String name, BigDecimal salary) {
        curId=++id;
        this.name = name;
        this.salary = salary;
    }

    protected String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    protected BigDecimal getSalary() {
        return salary;
    }

    protected void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    protected int getCurId() {
        return curId;
    }
}
