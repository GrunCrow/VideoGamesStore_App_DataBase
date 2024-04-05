    package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrainerDAO {

    private ConnectionDB connectionDB = null;
    private PreparedStatement ps = null;

    public TrainerDAO(ConnectionDB c) {
        connectionDB = c;
    }

    /**
     *
     * @param t
     * @return
     * @throws java.sql.SQLException
     */
    public boolean insertTrainer(Trainer t) throws SQLException {
        boolean insertOK = false;

        ps = connectionDB.getConnection().prepareStatement("INSERT INTO TRAINER VALUES (?,?,?,?,?,?,?,?)");
        ps.setString(1, t.getT_cod());
        ps.setString(2, t.getT_name());
        ps.setString(3, t.getT_surname1());
        ps.setString(4, t.getT_surname2());
        ps.setString(5, t.getT_idnumber());
        ps.setString(6, t.getT_phonenumber());
        ps.setString(7, t.getT_email());
        ps.setString(8, t.getT_date());
        ps.setString(9, t.getT_nick());

        ps.executeUpdate();
        insertOK = true;
        ps.close();

        return insertOK;

    }

    public boolean UpdateTrainer(Trainer t) throws SQLException {
        boolean updateOK = false;

        ps = connectionDB.getConnection().prepareStatement("UPDATE TRAINER SET "
                                                        + "T_COD=?,"
                                                        + "T_NAME=?,"
                                                        + "T_SURNAME1=?,"
                                                        + "T_SURNAME2=?,"
                                                        + "T_IDNUMBER=?,"
                                                        + "T_PHONENUMBER=?,"
                                                        + "T_EMAIL=?,"
                                                        + "T_DATE=?,"
                                                        + "T_NICK=?"
                                                        + "WHERE T_COD=?");
        ps.setString(1, t.getT_cod());
        ps.setString(2, t.getT_name());
        ps.setString(3, t.getT_surname1());
        ps.setString(4, t.getT_surname2());
        ps.setString(5, t.getT_idnumber());
        ps.setString(6, t.getT_phonenumber());
        ps.setString(7, t.getT_email());
        ps.setString(8, t.getT_date());
        ps.setString(9, t.getT_nick());
        

        ps.executeUpdate();
        updateOK = true;
        ps.close();

        return updateOK;

    }

    public boolean DeleteTrainer(Trainer t) throws SQLException {
        boolean deleteOK = false;

        ps = connectionDB.getConnection().prepareStatement("DELETE FROM TRAINER WHERE T_COD = ?");
        ps.setString(1, t.getT_cod());
        ps.executeUpdate();
        deleteOK = true;
        ps.close();

        return deleteOK;

    }
    
    public boolean CleanTrainers() throws SQLException{
        boolean deleteOK = false;
        ps = connectionDB.getConnection().prepareStatement("DELETE FROM TRAINER");
        
        ps.executeUpdate();
        
        return deleteOK;
    }
    
    public ArrayList<Trainer> listAllTrainers() throws SQLException{
        ArrayList<Trainer> T = new ArrayList();
        ps = connectionDB.getConnection().prepareStatement("SELECT * FROM TRAINER");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Trainer trainer = new Trainer(rs.getString(1), rs.getString(2), rs.getString(3),
                                        rs.getString(4),rs.getString(5),rs.getString(6),
                                        rs.getString(7),rs.getString(8),rs.getString(9));
            T.add(trainer);
        }
        return T;    
    }

}
