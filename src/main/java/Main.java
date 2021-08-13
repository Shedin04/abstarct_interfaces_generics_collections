import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List <Team> teams = new ArrayList();
        teams.add(new Football_team("Vorskla",50, new Player[]{new Player("Shedin", 10, BigDecimal.valueOf(45000)),new Player("Rest",4,BigDecimal.valueOf(35000))}));
        teams.add(new Football_team("Shakhtar",75,new Staff[]{new Staff("Shedin","manager",BigDecimal.valueOf(3500)), new Staff("Gagasg","hdshah",BigDecimal.valueOf(4500))}));
        teams.add(new Basketball_team("Miami Heat", 69));


        teams.get(1).getInfo();
        teams.get(1).addPlayers(new Player[]{new Player("Tom", 11,BigDecimal.valueOf(40000)), new Player("Bob",12,BigDecimal.valueOf(25000))});
        teams.get(1).getInfo();
        teams.get(1).addSallary("Gagasg",BigDecimal.valueOf(4000));
        teams.get(1).getInfo();
        teams.get(1).sortPersonsbyName(teams, 1);
        teams.get(1).getInfo();
        teams.get(1).sortPersonsbySalary(teams, 1);
        teams.get(1).getInfo();
    }
}