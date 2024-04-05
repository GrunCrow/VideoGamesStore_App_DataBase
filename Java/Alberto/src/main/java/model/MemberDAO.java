    package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {

    private ConnectionDB connectionDB = null;
    private PreparedStatement ps = null;

    public MemberDAO(ConnectionDB c) {
        connectionDB = c;
    }

    /**
     *
     * @param m
     * @return
     * @throws java.sql.SQLException
     */
    public boolean insertMember(Member m) throws SQLException {
        boolean insertOK = false;

        ps = connectionDB.getConnection().prepareStatement("INSERT INTO MEMBER VALUES (?,?,?,?,?,?,?,?)");
        ps.setString(1, m.getM_num());
        ps.setString(2, m.getM_name());
        ps.setString(3, m.getM_id());
        ps.setString(4, m.getM_birthdate());
        ps.setString(5, m.getM_phone());
        ps.setString(6, m.getM_emailMember());
        ps.setString(7, m.getM_startingDateMember());
        ps.setString(8, m.getM_cathegoryMember());

        ps.executeUpdate();
        insertOK = true;
        ps.close();

        return insertOK;

    }

    public boolean UpdateMember(Member m) throws SQLException {
        boolean updateOK = false;

        ps = connectionDB.getConnection().prepareStatement("UPDATE MEMBER SET "
                                                        + "M_NUM=?,"
                                                        + "M_NAME=?,"
                                                        + "M_ID=?,"
                                                        + "M_BIRHTDATE=?,"
                                                        + "M_PHONE=?,"
                                                        + "M_EMAILMEMBER=?,"
                                                        + "M_STARTINGDATEMEMBER=?,"
                                                        + "M_CATHEGORYMEMBER=?"
                                                        + "WHERE M_NUM=?");
        ps.setString(1, m.getM_num());
        ps.setString(2, m.getM_name());
        ps.setString(3, m.getM_id());
        ps.setString(4, m.getM_birthdate());
        ps.setString(5, m.getM_phone());
        ps.setString(6, m.getM_emailMember());
        ps.setString(7, m.getM_startingDateMember());
        ps.setString(8, m.getM_cathegoryMember());
        ps.setString(9, m.getM_num());
        

        ps.executeUpdate();
        updateOK = true;
        ps.close();

        return updateOK;

    }

    public boolean DeleteMember(Member m) throws SQLException {
        boolean deleteOK = false;

        ps = connectionDB.getConnection().prepareStatement("DELETE FROM MEMBER WHERE M_NUM = ?");
        ps.setString(1, m.getM_num());
        ps.executeUpdate();
        deleteOK = true;
        ps.close();

        return deleteOK;

    }
    
    public boolean CleanMembers() throws SQLException{
        boolean deleteOK = false;
        ps = connectionDB.getConnection().prepareStatement("DELETE FROM MEMBER");
        
        ps.executeUpdate();
        
        return deleteOK;
    }
    
    public ArrayList<Member> listAllMembers() throws SQLException{
        ArrayList<Member> M = new ArrayList();
        ps = connectionDB.getConnection().prepareStatement("SELECT * FROM MEMBER");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Member member = new Member(rs.getString(1), rs.getString(2), rs.getString(3),
                                        rs.getString(4),rs.getString(5),rs.getString(6),
                                        rs.getString(7),rs.getString(8));
            M.add(member);
        }
        return M;    
    }

}
