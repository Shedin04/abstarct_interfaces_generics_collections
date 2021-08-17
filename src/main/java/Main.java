import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Main {
    private static Logger logger;

    static {
        logger = Logger.getLogger("Teams");
        try {
            FileHandler fh = new FileHandler("Teams.log");
            logger.addHandler(fh);
        } catch (IOException e) {
            System.err.println("Can't create log file");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List <Team> teams = new ArrayList<>();

        // in menu AddTeams
        System.out.println("*Add new teams*");
        System.out.print("Input count of teams: ");
        int countOfteams = inputMoreThanOne(scanner);
        for (int i = 0; i < countOfteams; i++) {
            scanner.nextLine(); // очистка буфера
            System.out.print("Team [" + i + "] type [football/basketball]: ");
            String temptype = inputTypeOfTeam(scanner);
            System.out.print("Team [" + i + "] name: ");
            String tempname = scanner.nextLine();
            System.out.print("Team [" + i + "] rate: ");
            int temprate = checkRate(scanner);
            if (temptype.charAt(0) == 'f') teams.add(new Football_team(tempname,temprate));
            else teams.add(new Basketball_team(tempname,temprate));
        }

        // in menu ShowTeams
        System.out.println("\n*Your teams*");
        for (Team t:
             teams) {
            System.out.println(t);
        }

        // in menu AddPlayers
        System.out.println("\n*Add players*");
        while (true) {
            System.out.print("Input team id: ");
            countOfteams = inputInt(scanner);
            if (countOfteams < teams.size() && countOfteams>=0) break;
            logger.severe("[inputted id>=" + teams.size() + "]: " + countOfteams);
        }
        System.out.print("How many players you want to add?: ");
        int countofplayersadd = inputMoreThanOne(scanner);
        for (int i = 0; i < countofplayersadd; i++) {
            scanner.nextLine();
            System.out.print("[" + teams.get(countOfteams).getName() + "] new player [" + i + "] name: ");
            String tepmplayername = scanner.nextLine();
            System.out.print("[" + teams.get(countOfteams).getName() + "] new player [" + i + "] number: ");
            int tempplayernumber = inputMoreThanOne(scanner);
            System.out.print("[" + teams.get(countOfteams).getName() + "] new player [" + i + "] salary: ");
            int tempplayersalary = inputMoreThanOne(scanner);
            teams.get(countOfteams).addPlayers(new Player<>(tepmplayername, tempplayernumber, BigDecimal.valueOf(tempplayersalary)));
        }

        // in menu ShowTeams
        System.out.println("\n*Your teams*");
        for (Team t:
             teams) {
            t.getInfo();
        }

        System.out.println("\n*Before*");
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

    private static int checkRate(Scanner scanner) {
        int temprate = 0;
        while (true)
        try {
             temprate = inputInt(scanner);
            if (temprate <= 0 || temprate > 100) throw new IllegalArgumentException();
            return temprate;
        }catch (IllegalArgumentException e) {
            logger.severe("[inputted rate <1 or >100]: " + temprate);
            logger.info("[ERROR] - Input correct number:");
        }
    }

    private static String inputTypeOfTeam(Scanner scanner) {
        String temptype = null;
        while (true)
        try {
            temptype = scanner.nextLine();
            if (!temptype.equals("football") && !temptype.equals("foot") && !temptype.equals("f") && !temptype.equals("basketball") && !temptype.equals("basket") && !temptype.equals("b")) throw new Exception("Error"); // false&&true = false
            return temptype;
        }
        catch (Exception e) {
            logger.severe("[incorrect type]: " + temptype);
            logger.info("[ERROR] - Input correct type:");
        }
    }

    private static int inputMoreThanOne(Scanner scanner) {
        int countOfteams = 0;
        while (true)
        try {
            countOfteams = inputInt(scanner);
            if (countOfteams < 1) {
                throw new IllegalArgumentException("inputted number is <1");
            }
            return countOfteams;
        } catch (Exception e) {
            logger.severe(e.getMessage() + "]: " + countOfteams);
            logger.info("[ERROR] - Input correct number: ");
        }
    }

    private static int inputInt(Scanner scanner) {
        while (true)
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                logger.severe("[not int]"); // сюда не пишем логику
                logger.info("[ERROR] - Input correct number: ");
                scanner.nextLine(); // очистка буфера
            }
        }
    }