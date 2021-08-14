import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List <Team> teams = new ArrayList<>();
        teams.add(new Football_team("Vorskla",50, new Player<>("Shedin", 10, BigDecimal.valueOf(45000)),new Player<>("Rest",4,BigDecimal.valueOf(35000))));
        teams.add(new Football_team("Shakhtar",75, new Staff("Thomson","manager",BigDecimal.valueOf(18000)), new Staff("Peterson","cook",BigDecimal.valueOf(12000))));
        teams.add(new Basketball_team("Miami Heat", 69));

        System.out.println("*Before*");
        teams.get(1).getInfo();
        System.out.println("*Add new players*");
        teams.get(1).addPlayers(new Player<>("Marlos",12,BigDecimal.valueOf(300000)),new Player<>("Dodo", 3,BigDecimal.valueOf(250000)));
        teams.get(1).getInfo();
        System.out.println("*Add sallary$ to Marlos&Thomson*");
        teams.get(1).addSallary("Marlos",BigDecimal.valueOf(5000));
        teams.get(1).addSallary("Thomson",BigDecimal.valueOf(1000));
        teams.get(1).getInfo();
        System.out.println("*SortPersonsbyName*");
        teams.get(1).sortPersonsbyName(teams, 1);
        teams.get(1).getInfo();
        System.out.println("*SortPersonsbySalary*");
        teams.get(1).sortPersonsbySalary(teams, 1);
        teams.get(1).getInfo();

        System.out.println("*Total to Pay*");
        System.out.println("Players: " + teams.get(1).totalToPay(Type.Player));
        System.out.println("Staff: " + teams.get(1).totalToPay(Type.Staff));
        System.out.println("All: " + teams.get(1).totalToPay(Type.All) + "\n");

        System.out.println("*Add items to Dodo&Thomson*");
        teams.get(1).addItems("Dodo", new Items("ball","Puma", BigDecimal.valueOf(1000)), new Items("boots", "Adidas",BigDecimal.valueOf(3000)));
        teams.get(1).addItems("Thomson", new Items("suit", "PumaSuit", BigDecimal.valueOf(1500)));
        teams.get(1).showPersonItems("Dodo");
        teams.get(1).showPersonItems("Thomson");
        System.out.println("\n*All items*");
        teams.get(1).showAllItems();
        System.out.println("\n*All teams*");
        System.out.println(teams);
        System.out.println("\n*SortTeamsByName*");
        teams.get(0).sortTeambyName(teams);
        System.out.println(teams);
        System.out.println("\n*Add rate to Vorskla*");
        teams.get(2).addRate(18);
        System.out.println(teams);
        System.out.println("\n*SortTeamsByRate*");
        teams.get(0).sortTeambyRate(teams);
        System.out.println(teams);
    }
}