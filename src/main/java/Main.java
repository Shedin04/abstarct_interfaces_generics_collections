import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Team> teams = new ArrayList<>();

        // in menu AddTeams
        System.out.println("*Add new teams*");
        System.out.print("Input count of teams: ");
        int countOfteams = ProgramExceptions.inputMoreThanOne(scanner);
        for (int i = 0; i < countOfteams; i++) {
            scanner.nextLine(); // очистка буфера
            System.out.print("Team [" + i + "] type [football/basketball]: ");
            String temptype = ProgramExceptions.inputTypeOfTeam(scanner);
            System.out.print("Team [" + i + "] name: ");
            String tempname = scanner.nextLine();
            System.out.print("Team [" + i + "] rate: ");
            int temprate = ProgramExceptions.checkRate(scanner);
            if (temptype.charAt(0) == 'f') teams.add(new Football_team(tempname, temprate));
            else teams.add(new Basketball_team(tempname, temprate));
        }

        // in menu ShowTeams
        System.out.println("\n*Your teams*");
        for (Team t :
                teams) {
            System.out.println(t);
        }

        // in menu AddPlayers
        System.out.println("\n*Add players*");
        System.out.print("Input team id: ");
            int teamId = ProgramExceptions.teamIdCheck(scanner, teams);
        System.out.print("[" + teams.get(teamId).getName() + "] How many players you want to add?: ");
        int countofplayersadd = ProgramExceptions.inputMoreThanOne(scanner);
        for (int i = 0; i < countofplayersadd; i++) {
            scanner.nextLine();
            System.out.print("[" + teams.get(teamId).getName() + "] new player [" + i + "] name: ");
            String tepmplayername = scanner.nextLine();
            System.out.print("[" + teams.get(teamId).getName() + "] new player [" + i + "] number: ");
            int tempplayernumber = ProgramExceptions.inputMoreThanOne(scanner);
            System.out.print("[" + teams.get(teamId).getName() + "] new player [" + i + "] salary: ");
            int tempplayersalary = ProgramExceptions.inputMoreThanOne(scanner);
            teams.get(teamId).addPlayers(new Player<>(tepmplayername, tempplayernumber, BigDecimal.valueOf(tempplayersalary)));
        }

        // in menu ShowTeams
        System.out.println("\n*Your teams*");
        for (Team t :
                teams) {
            t.getInfo();
        }

        System.out.println("\n*Before*");
        teams.get(1).getInfo();
        System.out.println("*Add new players*");
        teams.get(1).addPlayers(new Player<>("Marlos", 12, BigDecimal.valueOf(300000)), new Player<>("Dodo", 3, BigDecimal.valueOf(250000)));
        teams.get(1).getInfo();
        System.out.println("*Add sallary$ to Marlos&Thomson*");
        teams.get(1).addSallary("Marlos", BigDecimal.valueOf(5000));
        teams.get(1).addSallary("Thomson", BigDecimal.valueOf(1000));
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
        teams.get(1).addItems("Dodo", new Items("ball", "Puma", BigDecimal.valueOf(1000)), new Items("boots", "Adidas", BigDecimal.valueOf(3000)));
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
        System.out.println("\n*Add rate to " + teams.get(1).getName() + "*");
        teams.get(1).addRate(18);
        System.out.println(teams);
        System.out.println("\n*SortTeamsByRate*");
        teams.get(0).sortTeambyRate(teams);
        System.out.println(teams);
    }
}