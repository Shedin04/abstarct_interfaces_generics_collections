import java.util.ArrayList;

public class Football_team extends Team{
    static String type;

    static {
        type = "Football_team";
    }

    public Football_team(String name, int rate, Player... newplayer) {
        super(name, rate, newplayer);
    }

    public Football_team(String name, int rate) {
        super(name, rate);
    }

    public String getType() {
       return "[This is football team]: ";
    }
}
