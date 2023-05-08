import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player extends ObjectPlus4{

    private String name;
    private String lastName;
    private String cardID;  // Unique attribute
    private static HashMap<String,Player> documents = new HashMap<String,Player>();

    private List<String> skills;

    private final static int MAX_SKILLS = 3;
    // Method for adding skills and checking the number of skills added for the attribute constraint.
    public void addSkill(String newSkill) throws Exception {
        // If the maximum number of skills is reached, throw an exception
        if(skills.size()==3){
            throw new Exception(String.format("Maximum number (%s) of skills reached, consider to remove one of the skills",MAX_SKILLS));
        }
        this.skills.add(newSkill);
    }

    // Attribute constraint, similar to addSkill we check the size of passes List of skills before upading the attribute skills.
    public void setSkills(List<String> newSkills) throws Exception {
        if(newSkills.size()>3){
            throw new Exception("A player cannot have more than 3 skills!");
        }
        this.skills = newSkills;
    }
    public void removeSkill(String skillToDelete) throws Exception {
        if(!this.skills.contains(skillToDelete)){
            throw new Exception(String.format("%s doesn't have the skill %s",this.lastName,skillToDelete));
        }
        this.skills.remove(skillToDelete);
    }
    public Player(String name,String lastName,String cardID) throws Exception {
        super();
        // Check if entered cardID is unique
        if(documents.containsKey(cardID)){
            throw new Exception("The entered document number is already assigned to another player!");
        }

        this.name=name;
        this.lastName=lastName;
        this.cardID=cardID;
        // Add cardID to documents list
        documents.put(cardID,this);



    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cardID='" + cardID + '\'' +
                ", skills=" + skills +
                '}';
    }
}
