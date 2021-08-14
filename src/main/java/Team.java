import java.math.BigDecimal;
import java.util.*;

public abstract class Team {
    private static int id;
    private final int curId;
    private String name;
    private int rate;
    private static int index;
    private static int error;
    private final List<Player> players = new ArrayList<>();
    private final List<Staff> staff = new ArrayList<Staff>();
    private List <Items> itemsList = new ArrayList<Items>();

    static {
        id = -1;
        index=0;
        error=0;
    }

    public Team(String name, int rate) {
        checkRate(rate);
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
        checkRate(rate);
        this.rate = rate;
        curId=++id;
        this.name = name;
    }

    private void checkRate(int rate) {
        if (rate<=0 || rate >100) throw new IllegalArgumentException("Введите значение от 0 до 100");
    }


    public Team(String name, int rate, Player...newplayer) {
        index = 0;
        Arrays.asList(newplayer).toArray(new Player[newplayer.length]);
        while (index<newplayer.length){
            this.players.add(newplayer[index++]);
        }
        checkRate(rate);
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

    public void addItems(String personname, Items...newitems) {
        error = 0;
        itemsList = Arrays.asList(newitems);
        for (int i = 0; i < players.size(); i++) {
            if (personname == players.get(i).getName()) {
                this.players.get(i).addItem(itemsList);
                break;
            }
            else error++;
        }
        for (int i = 0; i < staff.size(); i++) {
            if (personname == staff.get(i).getName()) {
                this.staff.get(i).addItem(itemsList);
                break;
            }
            else error++;
        }
        checkPerson(error);
    }

    /* public void showItems(String personname){
         error = 0;
         for (int i = 0; i < players.size(); i++) {
             if (personname == players.get(i).getName()) {
                 players.get(i).showItems();
             }
             else error++;
         }
         for (int i = 0; i < staff.size(); i++) {
             if (personname == staff.get(i).getName()) {
                 staff.get(i).showItems();
             }
             else error++;
         }
         checkPerson(error);
     }*/

    private void checkPerson(int error) {
        if (error == (players.size() + staff.size())) System.out.println("[ERROR]: Person not found");
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

    private int getCurId() {
        return curId;
    }

    protected abstract String getType();

    @Override
    public String toString() {
        return  "[id:" + curId + "]" + getType() + "{" +
                "name='" + name + '\'' +
                ", rate=" + rate +'}';
    }

    public void getInfo(){
        if (players.size() == 0 && staff.size() == 0 ) System.out.println ("[ERROR]: " + getName() + " don't have a squad\n");
        System.out.println(getType() + "[" + curId + "] - " + getName() + ": ");
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
        if (notfound == players.size()+staff.size()) System.out.println("ERROR: Person - not found\n");
    }

    public void showItems(String personname){
        error = 0;
        for (int i = 0; i < players.size(); i++) {
            if (personname == players.get(i).getName()) {
                players.get(i).showItems();
            }
            else error++;
        }
        for (int i = 0; i < staff.size(); i++) {
            if (personname == staff.get(i).getName()) {
                staff.get(i).showItems();
            }
            else error++;
        }
        checkPerson(error);
    }

    protected List<Team> sortTeambyName(List<Team> teams){
        Collections.sort(teams, Team.sortteamsbyname);
        return teams;
    }

    protected List<Team> sortTeambyRate(List<Team> teams){
        Collections.sort(teams, Team.sortteamsbyrate);
        return teams;
    }

    public <T> List<Team> sortPersonsbyName(List<Team> teams, int whichteam){
        Collections.sort(teams.get(whichteam).players, Person.sortpersonbyname);
        Collections.sort(teams.get(whichteam).staff, Person.sortpersonbyname);
        return teams;
    }

    public <T> List<Team> sortPersonsbySalary(List<Team> teams, int whichteam){
        Collections.sort(teams.get(whichteam).players, Person.sortpersonbysalary);
        Collections.sort(teams.get(whichteam).staff, Person.sortpersonbysalary);
        return teams;
    }
    
    private static final Comparator<Team> sortteamsbyname = new Comparator<>() {
        @Override
        public int compare(Team o1, Team o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    private static final Comparator<Team> sortteamsbyrate = new Comparator<>() {
        @Override
        public int compare(Team o1, Team o2) {
            return o2.getRate() - o1.getRate();
        }
    };
}
