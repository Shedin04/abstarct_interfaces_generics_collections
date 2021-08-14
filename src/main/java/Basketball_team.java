import java.math.BigDecimal;
import java.util.ArrayList;

public class Basketball_team extends Team{
    private int index = 0;
    static String type;

    static {
        type = "Basketball_team";
    }

    public Basketball_team(String name, int rate, Player... newplayer) {
        super(name, rate, newplayer);
    }

    public Basketball_team(String name, int rate, Staff... newstaff) {
        super(name, rate, newstaff);
    }

    public Basketball_team(String name, int rate) {
        super(name, rate);
    }

    protected String getType() {
        return "Basketball team";
    }
}
