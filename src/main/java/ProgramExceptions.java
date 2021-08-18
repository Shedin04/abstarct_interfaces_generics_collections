import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ProgramExceptions extends Exception{
    private static final Logger logger;

    static {
        logger = Logger.getLogger("Teams");
        logger.setLevel(Level.SEVERE); // фильтр
        try {
            FileHandler fh = new FileHandler("Teams.log",true);
            fh.setFormatter(new SimpleFormatter()); //чтобы записывалось как на консоли
            logger.addHandler(fh);
        } catch (IOException e) {
            System.err.println("Can't create log file" + Arrays.toString(e.getStackTrace()));
        }
    }

    public ProgramExceptions(String message) {
        super(message);
    }

    public static int checkRate(Scanner scanner) {
        int temprate = 0;
        while (true)
            try {
                temprate = inputInt(scanner);
                if (temprate <= 0 || temprate > 100) throw new ProgramExceptions("[inputted rate <1 or >100]");
                return temprate;
            }catch (ProgramExceptions e) {
                logger.severe(e.getMessage() + ": '" + temprate + "' - " + Arrays.toString(e.getStackTrace()));
                System.err.print("[ERROR] - Input correct number: ");
            }
    }

    public static void checkAddRate(Integer rate, Integer add) {
        while (true)
            try {
            if (add +rate > 100 || add < 0) throw new ProgramExceptions("[rate must be <=100]");
        }
        catch (ProgramExceptions e){
            logger.severe(e.getMessage() + ": '" + add + "' - " + Arrays.toString(e.getStackTrace()));
            System.err.println("[ERROR: Rate > 100] - input new: ");
        }
    }


    public static String inputTypeOfTeam(Scanner scanner) {
        String temptype = null;
        while (true)
            try {
                temptype = scanner.nextLine();
                if (!temptype.equals("football") && !temptype.equals("foot") && !temptype.equals("f") && !temptype.equals("basketball") &&
                        !temptype.equals("basket") && !temptype.equals("b")) throw new ProgramExceptions("[incorrect type]"); // false&&true = false
                return temptype;
            }
            catch (ProgramExceptions e) {
                logger.severe(e.getMessage() + ": '" + temptype + "' - " + Arrays.toString(e.getStackTrace()));
                System.err.print("[ERROR] - Input correct type: ");
            }
    }

    public static int inputMoreThanOne(Scanner scanner) {
        int countOfteams = 0;
        while (true)
            try {
                countOfteams = inputInt(scanner);
                if (countOfteams < 1) {
                    throw new ProgramExceptions("[inputted number is less than 1]");
                }
                return countOfteams;
            } catch (ProgramExceptions e) {
                logger.severe(e.getMessage() + ": '" + countOfteams + "' - " + Arrays.toString(e.getStackTrace()));
                System.err.print("[ERROR] - Input correct number: ");
            }
    }

    public static int inputInt(Scanner scanner) {
        while (true)
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                logger.severe("[not int] - " + Arrays.toString(e.getStackTrace())); // сюда не пишем логику
                System.err.print("[ERROR] - Input correct number: ");
                scanner.nextLine(); // очистка буфера
            }
    }

    public static int teamIdCheck(Scanner scanner, List<Team> teams) {
        int teamId = 0;
        while (true)
            try {
                teamId = inputInt(scanner);
                if (teamId < teams.size() && teamId >= 0) return teamId;
                else throw new ProgramExceptions("[incorrect id of team]");
            } catch (ProgramExceptions e) {
                logger.severe("[inputted id>=" + teams.size() + "]: '" + teamId + "' - " + Arrays.toString(e.getStackTrace()));
            }
    }
}
