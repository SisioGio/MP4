public class Referee extends ObjectPlus4{
    private String name;
    private String lastName;
    public Referee(String name,String lastName){
        this.name=name;
        this.lastName=lastName;
    }

    @Override
    public String toString() {
        return "Referee{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
