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

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private int getRate() {
        return rate;
    }

    private void setRate(int rate) {
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
        if (players.size() == 0 && staff.size() == 0 ) System.out.println ("[ERROR]: " + getName() + " don't have a squad\n");
        System.out.println(getType() + " - " + getName() + ": ");
        for (int i = 0; i < players.size(); i++) System.out.println(players.get(i));
        for (int i = 0; i < staff.size(); i++) System.out.println(staff.get(i));
        System.out.println();
    }

    public void addRate(Integer add) {
        if (add+getRate() > 100 || add < 0) throw new IllegalArgumentException("Рейтинг должен быть <=100");
        setRate(getRate()+add);
    }

    public void addSallary(Object data, BigDecimal add){
        int notfound = 0;
        if (add.compareTo(BigDecimal.ZERO)<0 || add == null) throw new IllegalArgumentException();
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getNumber().equals(data) || players.get(i).getName().equals(data)){
            players.get(i).setSalary(players.get(i).getSalary().add(add));
            break;
            }
            else notfound++;
        }
        for (int i = 0; i < staff.size(); i++) {
            if (staff.get(i).getName().equals(data) || staff.get(i).getPosition().equals(data)){
                staff.get(i).setSalary(staff.get(i).getSalary().add(add));
                break;
            }
            else notfound++;
        }
        if (notfound == players.size()+staff.size()) System.out.println("ERROR: Person - not found");
    }
}
