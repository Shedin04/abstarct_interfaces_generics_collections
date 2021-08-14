import java.math.BigDecimal;
import java.util.*;

abstract public class Person<T>{
    private static int id;
    private final int curId;
    private String name;
    private BigDecimal salary;
    private List<Items> items = new ArrayList<Items>();

    static {
        id = 00;
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

    public void addItem(List<Items> newitems){
        this.items = newitems;
    }

    public void showItems(){
        System.out.println(getName()+ " items: " + items);
    }

    protected static final Comparator<Person> sortpersonbyname = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    protected static final Comparator<Person> sortpersonbysalary = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return (o2.getSalary().subtract(o1.getSalary())).intValue();
        }
    };
}
