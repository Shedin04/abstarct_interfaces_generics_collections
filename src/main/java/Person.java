import java.math.BigDecimal;
import java.util.*;

abstract public class Person<T> implements Iterable<Items>{
    private static int id;
    private final int curId;
    private String name;
    private BigDecimal salary;
    private static int index;
    private List<Items> items = new ArrayList<Items>();

    static {
        id = -1;
        index = 0;
    }

    protected Person(String name, BigDecimal salary) {
        curId = ++id;
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

    public void addItem(List<Items> newitems) {
        this.items = newitems;
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

    public void showItems(){
        index = 0;
        System.out.println(getName() + " items: ");
        while (iterator().hasNext()) System.out.println(iterator().next());
    }

    @Override
    public Iterator<Items> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return index < items.size() && items.get(index) != null;
            }

            @Override
            public Items next() {
                System.out.print("* ");
                if (index >= items.size()) throw new NoSuchElementException();
                else return items.get(index++);
            }
        };
    }
}