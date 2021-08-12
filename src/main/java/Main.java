import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List <Team> teams = new ArrayList();
        teams.add(new Football_team("Vorskla",50, new Player[]{new Player("Shedin", 10, BigDecimal.valueOf(45000)),new Player("Rest",4,BigDecimal.valueOf(35000))}));
        teams.add(new Football_team("Shakhtar",75));
        teams.add(new Basketball_team("Miami Heat", 69));


        teams.get(0).getInfo();
        teams.get(0).addPlayers(new Player[]{new Player("Tom", 11,BigDecimal.valueOf(40000)), new Player("Bob",12,BigDecimal.valueOf(25000))});
        teams.get(0).getInfo();
  /*      teams.get(0).addRate(10);
        teams.get(0).addSallary("2", BigDecimal.valueOf(5000));*/
    }
}