import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws Exception {

        // Attribute constraint

        // A player cannot have more than 3 skills.

        // Player object initialization
        Player player1 = new Player("Giorgio","Chiellini","AC-143234");
        // Skill list initialization
        List<String> pl1Skills = new ArrayList<>();
        pl1Skills.add("Head-shot");
        pl1Skills.add("Tackliing");
        pl1Skills.add("Defensive");

        // Update player1 skills with 3 skills --->Success ( the list has only 3 skills )
        player1.setSkills(pl1Skills);

        // Add another skill ---> Fail ( A player cannot have more than 3  skills )
        try{
            player1.addSkill("Feints");
        } catch (Exception e){
            e.printStackTrace();
        }

        // Add another skill to the skill list and then update the skills attribute using the player setter 'setSkills'
        // -----> Fail ( the setter checks the size of the passed list )
        pl1Skills.add("Feints");
        try{
            player1.setSkills(pl1Skills);
        } catch (Exception e){
            e.printStackTrace();
        }


        // Unique constraint

        // The document number is a unique value and the same number cannot be assigned to more than one player.

        // Successful implementation
        Player player2 = new Player("Robert","Lewandowski","DH-353932");

        // Invalid implementation, the document number is not unique!
        try{
            Player player3 = new Player("Krzysztof","Piatek","AC-143234");
        } catch (Exception e){
            // Print error
            e.printStackTrace();

        }
        // Create correct object with unique documetNo
        Player player3 = new Player("Krzysztof","Piatek","AD-343234");


        // Subset constraint
        // A team is composed by players and one one the players leads the team being the captain
        // We cannot add as captain a player which in not in the team

        String roleBelongsTo = "player";
        String roleConsistsOf = "team";
        String leads = "leads";
        String leadedBy = "leaded by";

        // Creating Player objects
        Player player4 = new Player("Roberto","Baggio","DI-125689");
        Player player5 = new Player("Andrea","Pirlo","SD-142648");
        Player player6 = new Player("Leonardo","Bonucci","CM-918273");
        Player player7 = new Player("Alessandro","Del Piero","DO-234153");


        // Create Team object with player list and captain  ---> player7 is within the team members so the initialization will succeed
        Team teamA = new Team("Juventus");
        Team teamB = new Team("Roma");
        // Add players to teamA
        player1.addLink(roleBelongsTo,roleConsistsOf,teamA);
        player2.addLink(roleBelongsTo,roleConsistsOf,teamA);
        player3.addLink(roleBelongsTo,roleConsistsOf,teamA);

        // Define the captain by creating a link leads & leaded by between players1 and teamA ----> Success ( player1 belongs to teamA )
        player1.addLink_subset(leads,leadedBy,roleBelongsTo,teamA);
        // Display links
        player1.showLinks(roleBelongsTo,System.out);
        player1.showLinks(leads,System.out);


        try{
            player4.addLink(roleBelongsTo,roleConsistsOf,teamB);

            // Define the captain of team2 with a player not  belonging to the team ----> Error ( player5 doesn't belong to teamB )
            player5.addLink_subset(leads,leadedBy,roleBelongsTo,teamB);
        }  catch (Exception e){
            e.printStackTrace();
        }

        // Ordered constraint

        // Since ObjectPlus uses a vector for the extent, by extending the ObjectPlusPlus class, the instances are already ordered:
        // Displaying extent sorted by creation time:
        Player.showExtent(Player.class);

        // Bag
        // XOR constraint
        // A referee can conduct a match or lead a referee association, he cannot lead an association and conduct a game.
        // Initializing referee, RefereesAssociations and Match objects
        Referee referee = new Referee("Pierluigi","Collina");
        RefereesAssociation refAssociation = new RefereesAssociation("Italian Referees' Association");
        Match match = new Match(teamA,teamB);


        //Adding XOR roles to Referee objects ----> I made the attribute rolesXOR so that it can be applied to all ObjectPlus4 instances otherwise the roleXOR would be applied to the instance only
        referee.addXorRole("conducts");
        referee.addXorRole("leads");

        // I had to implement the method anyLink because it was not created in the ObjectPlusPlus ( I did not find within the lectures )
        // the function anyLink ( called within addLinkXor) returns false because no link has been created yet, and it allows to create a link between them.

        referee.addLinkXor("conducts","conducted by",match);

        // Trying to add a link between existing referee and refAssociation ----> Error!
        // As soon as we try to create a link between Referee and RefAssociation the method anyLink returns True because it found a key with one of the given XOR roles
        // After defined the XOR roles we  create a link between Referee and Match ( conducts ),

        try{
            referee.addLinkXor("leads","leaded by",refAssociation);
        } catch (Exception e){
            e.printStackTrace();
        }





    }
}
