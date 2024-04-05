package model;

import model.Member1;
import model.Activity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import view.MessageView;

/**
 * Implements actions which are done by activities.
 *
 * @author Alberto Fernández Merchán
 */
public class ActivityDAO {

    private MessageView vMessage = null;
    private Session s = null;

    /**
     * Constructor of the class.
     *
     * @param s
     */
    public ActivityDAO(Session s) {
        vMessage = new MessageView();
        this.s = s;
    }

    /**
     * Gets all the members who participate in an activity.
     *
     * @param actName
     * @return
     */
    public ArrayList<Member1> getMembers(String actName) {

        Activity a = s.get(Activity.class, (String) s.createNativeQuery("SELECT A_ID FROM ACTIVITY WHERE A_NAME = \'" + actName + "\'").list().get(0));
        ArrayList<Member1> lMembers = new ArrayList();
        try {
            for (Member1 m : a.getMember1Set()) {
                lMembers.add(m);
            }
        } catch (Exception e) {
            vMessage.Message("error", "Error: " + e.getMessage() + "\n" + actName + " is not in the database");
            System.out.println(actName + " is not in the database.");
        }
        return lMembers;
    }

    /**
     * Gets the activity List
     *
     * @return
     */
    public ArrayList<Activity> getActList() {
        Transaction tr = s.beginTransaction();
        ArrayList<Activity> T = new ArrayList();
        try {
            T = (ArrayList<Activity>) s.createNativeQuery("SELECT * FROM ACTIVITY", Activity.class).list();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            vMessage.Message("error", "Error: " + e.getMessage());
            System.out.println("LIST ROLLBACK!!");
        }

        return T;
    }

    /**
     * Gets the name of an activity by its id.
     *
     * @param idAc
     * @return
     */
    public String getActivityName(String idAc) {
        return s.get(Activity.class, idAc).getAName();
    }

    /**
     * Gets an Activity by its name.
     *
     * @param AcName
     * @return
     */
    public Activity getActivityByName(String AcName) {
        return s.get(Activity.class, (String) s.createNativeQuery("SELECT A_ID FROM ACTIVITY WHERE A_NAME='" + AcName + "'").list().get(0));
    }

    /**
     * Add an activity list to a existing member
     *
     * @param member
     * @param listActName
     */
    public void addMember(Member1 member, List<String> listActName) {
        Transaction tr = s.beginTransaction();
        List<Activity> A = new ArrayList(); //Activities where member is participating
        Set<Activity> set;
        try {

            for (int i = 0; i < listActName.size(); i++) {
                A.add(s.get(Activity.class, (String) s.createNativeQuery("SELECT A_ID FROM ACTIVITY WHERE A_NAME='" + listActName.get(i) + "'").list().get(0)));
                if (!A.get(i).getMember1Set().contains(member)) {
                    A.get(i).addMember(member);
                }
            }
            set = new HashSet<>(A); //Set with the activities where member is participating
            member.setActivitySet(set); //change the activityset of the member

            tr.commit();

        } catch (Exception e) {
            tr.rollback();
            vMessage.Message("error", "addMember ROLLBACK!!: " + e.getMessage());
        }
    }

    /**
     * Delete the activities where a member is participating.
     *
     * @param member
     * @param listActName
     */
    public void clearPerforms(Member1 member, JList<String> listActName) {
        Transaction tr = s.beginTransaction();
        List<Activity> A = new ArrayList(); //activity set empty
        Set<Activity> set;
        try {
            //s.createNativeQuery("DELETE FROM PERFORMS WHERE P_NUM='"+member.getMNum()+"'").executeUpdate();
            set = new HashSet<>(A); //Set with the activities where member is participating
            member.setActivitySet(set); //change the activityset of the member
            for (int i = 0; i < listActName.getModel().getSize(); i++) {
                if (getActivityByName(listActName.getModel().getElementAt(i)).getMember1Set().contains(member)) {
                    System.out.println("Elimino el miembro");
                    getActivityByName(listActName.getModel().getElementAt(i)).getMember1Set().remove(member);
                }

            }
            tr.commit();

        } catch (Exception e) {
            tr.rollback();
            vMessage.Message("error", "clearPerforms ROLLBACK!!: " + e.getMessage());
        }
    }
}
