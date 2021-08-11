import java.math.BigDecimal;

public interface Update<T> { // T чтобы в методе можно передавать int/BigDecimal
    public void addRate(T add);
}