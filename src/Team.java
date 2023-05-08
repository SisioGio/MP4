import java.util.List;

public class Team  extends ObjectPlus4{
    private String name;


    public Team(String name) throws Exception {
        super();
        this.name=name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                '}';
    }
}

