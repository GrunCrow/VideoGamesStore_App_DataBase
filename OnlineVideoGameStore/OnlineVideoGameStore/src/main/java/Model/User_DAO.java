/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.MessageView;
import java.sql.SQLException;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author albam
 */
public class User_DAO{
    
    private Session s = null;
    private MessageView vMessage = null;
    
    /**
     * Constructor of the class
     *
     * @param s
     */
    public User_DAO(Session s) {
        this.s = s;
        vMessage = new MessageView();
    }
    
    /**
     * Adds a member to the database.
     *
     * @param us
     * @return
     */
    public boolean insertUser(User us) {
        boolean insertOK = false;
        Transaction transaction = s.beginTransaction();
        try {
            s.save(us);
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
     * @param UserID
     * @param user
     * @return
     */
    public boolean UpdateMember(String UserID, User user) {
        boolean updateOK = false;
        Transaction transaction = s.beginTransaction();
        try {
            User u = s.get(User.class, UserID);

            u.setUser_name(user.getUser_name());
            u.setUser_email(user.getUser_name());

            s.update(u);
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
     * @param UserID
     * @return
     */
    public boolean DeleteUser(String UserID) {
        boolean deleteOK = false;
        Transaction transaction = s.beginTransaction();
        try {

            UserID = UserID.trim();
            User m = s.get(User.class, UserID);

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
    public boolean CleanUsers() throws SQLException {
        boolean deleteOK = false;
        Transaction transaction = s.beginTransaction();
        try {
            s.createNativeQuery("DELETE FROM CONTACT").executeUpdate();
            
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
    public ArrayList<User> listAllMembers() throws SQLException {
        Transaction transaction = s.beginTransaction();
        ArrayList<User> M = new ArrayList();
        try {
            M = (ArrayList<User>) s.createNativeQuery("SELECT * FROM MEMBER", User.class).list();
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
    public User getUserbyName(String name) {
        return s.get(User.class, (String) s.createNativeQuery("SELECT ContactID FROM Contact WHERE FirstName = \'" + name + "\'").list().get(0));
    }
    
    /**
     * Gets a member by its email.
     *
     * @param email
     * @return
     */
    public User getUserbyEmail(String email) {
        return s.get(User.class, (String) s.createNativeQuery("SELECT ContactID FROM Contact WHERE emailAdress = \'" + email + "\'").list().get(0));
    }
    
    /*public User idetificate(User user) throws Exception{
        User us = null;
        Connect con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT contact.ContactID, contact.FirstName, contact.EmailAdress "
                + "FROM contact "
                + "WHERE contact.FirstName = '" + user.getUser_email() + "' and contact.password = '" + user.getUser_password() + "';";
        con = new Connect();
        try{
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next() == true){
                us = new User();
                us.setUser_id(rs.getInt("ContactID"));
                us.setUser_name(user.getUser_name());
                us.setUser_email(user.getUser_name());
            }
        }catch(SQLException e){
            System.out.println("Error" + e.getMessage());
        }finally{
            //close all connections
            if(rs !=null && rs.isClosed() == false){
                rs.close();
            }
            rs = null;
            if(st!= null && st.isClosed() == false){
                st.close();
            }
            st = null;
            if(cn!= null && cn.isClosed() == false){
                cn.close();
            }
            cn = null;
        }
        
        return us;
    }*/
}
