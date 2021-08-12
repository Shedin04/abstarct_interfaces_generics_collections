import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Team {
    private static int id;
    private final int curId;
    private String name;
    private int rate;
    private static int index;
    private List<Player> players = new ArrayList<Player>();
    private List<Staff> staff = new ArrayList<Staff>();

    static {
        id = 00;
        index=0;
    }

    public Team(String name, int rate) {
        if (rate<=0 || rate >100) throw new IllegalArgumentException("Введите значение от 0 до 100");
        this.rate = rate;
        curId=++id;
        this.name = name;
    }

    public Team(String name, int rate, Staff...newstaff) {
        index = 0;
        Arrays.asList(newstaff).toArray(new Staff[newstaff.length]);
        while (index<newstaff.length){
            this.staff.add(newstaff[index++]);
        }
        if (rate<=0 || rate >100) throw new IllegalArgumentException("Введите значение от 0 до 100");
        this.rate = rate;
        curId=++id;
        this.name = name;
    }

    public Team(String name, int rate, Player...newplayer) {
        index = 0;
        Arrays.asList(newplayer).toArray(new Player[newplayer.length]);
        while (index<newplayer.length){
            this.players.add(newplayer[index++]);
        }
        if (rate<=0 || rate >100) throw new IllegalArgumentException("Введите значение от 0 до 100");
        this.rate = rate;
        curId=++id;
        this.name = name;
    }

    public void addPlayers(Player...newplayers) {
        index = 0;
        Arrays.asList(newplayers).toArray(new Player[newplayers.length]);
        while (index<newplayers.length){
            for (int i = 0; i < players.size(); i++) {
                if (newplayers[index].getNumber() == players.get(i).getNumber()) {
                    throw new IllegalArgumentException("Номер занят");
                }
            }
                this.players.add(newplayers[index++]);
        }
    }

    protected String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected int getRate() {
        return rate;
    }

    protected void setRate(int rate) {
        this.rate = rate;
    }

    public int getCurId() {
        return curId;
    }

    protected abstract String getType();

    @Override
    public String toString() {
        return getType() + "{" +
                "name='" + name + '\'' +
                ", rate=" + rate +'}';
    }

    public void getInfo(){
        index = 0;
        System.out.println(getName() + " | Rate:" + getRate() + " | Squad: ");
        while (index<players.size())
        System.out.println(players.get(index++));
        while (index<staff.size())
            System.out.println(staff.get(index++));
        System.out.println();
    }

    public void addRate(Integer add) {
        if (add+getRate() > 100 || add < 0) throw new IllegalArgumentException("Рейтинг должен быть <=100");
        setRate(getRate()+add);
    }

    public void addSallary(Object data, BigDecimal add){
        if (add.compareTo(BigDecimal.ZERO)<0 || add == null) throw new IllegalArgumentException();
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getNumber().equals(data) || players.get(i).getName().equals(data)){
            players.get(i).setSalary(players.get(i).getSalary().add(add));
            break;
            }
            else if ((i+1) == players.size()) System.out.println("[ERROR]: \"" + data + "\" player - not found");
        }
    }
}
