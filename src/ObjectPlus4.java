import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public abstract class ObjectPlus4 extends ObjectPlusPlus implements Serializable {
    public static List<String> rolesXOR = new LinkedList<>();

    public ObjectPlus4() {
        super();

    }

    public void addLink_subset(String roleName, String reverseRoleName, String superRoleName, ObjectPlusPlus targetObject) throws Exception {
        if(isLink(superRoleName, targetObject)) {
            // There is a (super) link to the added object in the super role
            // Create the link
            addLink(roleName, reverseRoleName, targetObject);
        }
        else {
            // No super link ==> exception
            throw new Exception("No link to the '" + targetObject + "' object in the '" + superRoleName + "' super role!");
        }
    }

    public static void addXorRole(String xorRoleName) {
        rolesXOR.add(xorRoleName);
    }

    public void addLinkXor(String roleName, String reverseRoleName, ObjectPlusPlus targetObject) throws Exception {
        if(rolesXOR.contains(roleName)) {
            // The currently adding role is XOR'ed

            // Check if there is a link for XOR'ed roles
            for(String role: rolesXOR){
                if(this.anyLink(role)){
                    throw new Exception("There is a link for a XOR roles!");
                }
            }

            // There is no link ==> add a link using an already existing method from a super class
        }

        // Add the link
        super.addLink(roleName, reverseRoleName, targetObject);
    }








}
