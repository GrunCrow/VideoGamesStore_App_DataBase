package model;

import java.sql.SQLException;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import view.MessageView;

/**
 *
 * @author Alberto Fernández
 */
public class MemberDAO {

    private Session s = null;
    private MessageView vMessage = null;

    /**
     * Constructor of the class
     *
     * @param s
     */
    public MemberDAO(Session s) {
        this.s = s;
        vMessage = new MessageView();
    }

    /**
     * Adds a member to the database.
     *
     * @param m
     * @return
     */
    public boolean insertMember(Member1 m) {
        boolean insertOK = false;
        Transaction transaction = s.beginTransaction();
        try {
            s.save(m);
            transaction.commit();
            insertOK = true;
        } catch (Exception e) {
            transaction.rollback();
            vMessage.Message("error", "Insertion error: " + e.getMessage());
        }

        return insertOK;

    }

    /**
     * Updates a member from the database.
     *
     * @param codMember
     * @param mem
     * @return
     */
    public boolean UpdateMember(String codMember, Member1 mem) {
        boolean updateOK = false;
        Transaction transaction = s.beginTransaction();
        try {
            Member1 m = s.get(Member1.class, codMember);

            m.setMName(mem.getMName());
            m.setMNum(mem.getMNum());
            m.setMBirhtdate(mem.getMBirhtdate());
            m.setMCathegorymember(mem.getMCathegorymember());
            m.setMPhone(mem.getMPhone());
            m.setMStartingdatemember(mem.getMStartingdatemember());

            s.update(m);
            transaction.commit();
            updateOK = true;

        } catch (Exception e) {
            transaction.rollback();
            vMessage.Message("error", "Update error: " + e.getMessage());
        }

        return updateOK;

    }

    /**
     * Deletes a member from the database
     *
     * @param codMember
     * @return
     */
    public boolean DeleteMember(String codMember) {
        boolean deleteOK = false;
        Transaction transaction = s.beginTransaction();
        try {

            codMember = codMember.trim();
            Member1 m = s.get(Member1.class, codMember);

            for (Activity x : m.getActivitySet()) {
                x.getMember1Set().remove(m);
            }

            s.delete(m);
            transaction.commit();
            deleteOK = true;
        } catch (Exception e) {
            transaction.rollback();
            vMessage.Message("error", "Delete error: " + e.getMessage());
        }

        return deleteOK;

    }

    /**
     * Remove all the members from the database.
     *
     * @return
     * @throws SQLException
     */
    public boolean CleanMembers() throws SQLException {
        boolean deleteOK = false;
        Transaction transaction = s.beginTransaction();
        try {
            s.createNativeQuery("DELETE FROM MEMBER").executeUpdate();
            for (Member1 m : ((ArrayList<Member1>) s.createNativeQuery("SELECT * FROM MEMBER", Member1.class).list())) {
                for (Activity x : m.getActivitySet()) {
                    x.getMember1Set().remove(m);
                }
            }
            transaction.commit();
            deleteOK = true;
        } catch (Exception e) {
            transaction.rollback();
            vMessage.Message("error", "Error: " + e.getMessage());
        }

        return deleteOK;
    }

    /**
     * Gets a list of all the members from the database.
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<Member1> listAllMembers() throws SQLException {
        Transaction transaction = s.beginTransaction();
        ArrayList<Member1> M = new ArrayList();
        try {
            M = (ArrayList<Member1>) s.createNativeQuery("SELECT * FROM MEMBER", Member1.class).list();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            vMessage.Message("error", "Listing error: " + e.getMessage());
        }
        return M;
    }

    /**
     * Gets a member by its name.
     *
     * @param name
     * @return
     */
    public Member1 getMember(String name) {
        return s.get(Member1.class, (String) s.createNativeQuery("SELECT M_NUM FROM MEMBER WHERE M_NAME = \'" + name + "\'").list().get(0));

    }

}
