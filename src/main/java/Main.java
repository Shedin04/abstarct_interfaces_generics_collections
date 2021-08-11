import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList <Team> teams = new ArrayList<>();
        teams.add(new Football_team("Vorskla",50, new Player[]{new Player("Shedin", 10, BigDecimal.valueOf(45000)),new Player("Rest",4,BigDecimal.valueOf(35000))}));
        teams.add(new Football_team("Shakhtar",75));
        teams.add(new Basketball_team("Miami Heat", 69));


        teams.get(0).addPlayers(new Player[]{new Player("Tom", 14,BigDecimal.valueOf(40000)), new Player("Bob",3,BigDecimal.valueOf(25000))});
        teams.get(0).getInfo();
        teams.get(0).addRate(10);
        teams.get(0).addSallary("2", BigDecimal.valueOf(5000));



        /*System.out.println(teams.toString());
        String type = "Football_team";
        System.out.print("All " + type + "s: ");
        for (int i = 0; i < teams.size(); i++) {
            teams.get(i).getInfo(type);
        }*/


    }
}