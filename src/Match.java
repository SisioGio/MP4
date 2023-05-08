public class Match extends ObjectPlus4{
    private Team opponent1;
    private Team opponent2;

    public Match(Team team1,Team team2){
        this.opponent1=team1;
        this.opponent2=team2;

    }

    @Override
    public String toString() {
        return "Match{" +
                "opponent1=" + opponent1 +
                ", opponent2=" + opponent2 +
                '}';
    }
}
