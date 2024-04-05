package Application;

//STEP 1. Import required packages
import java.sql.*;
import model.ConnectionDB;
import model.Member;
import model.MemberDAO;

public class Query {
// JDBC driver name and database URL

    static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String DB_URL = "jdbc:oracle:thin:@172.17.20.75:1521:rabida";

    //  Database credentials
    static String USER = "ISDD_003";
    static String PASS = "alberto";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Connection conn = null;
        ConnectionDB connDB = new ConnectionDB(DB_URL,USER,PASS);
        //Statement stmt = null;

        try {

            //System.out.println("starting");
            // STEP 2. Register the JDBC driver
            Class.forName("oracle.jdbc.OracleDriver");
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            //conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String member_id = "m400";
            String member_name = "Chuck";
            String member_id2 = "ID_3";
            String member_date1 = "25/05/21";
            String member_number = "555555555";
            String member_mail = "example@mail.com";
            String member_joindate = "29/10/21";
            String member_group = "A";
//            String trainer_id = "m400";
//            String trainer_name = "Chuck";
//            String trainer_surname = "J.";
//            String trainer_surname2 = "Norris";
//            String trainer_idnumber = "66";
//            String trainer_phonenumber = "65898752";
//            String trainer_email = "emial";
//            String trainer_date = "28/08/22";
//            String trainer_nick = "Chucki";

            //connDB.getConnection().setAutoCommit(false);
             
            MemberDAO memberdao = new MemberDAO(connDB);
            
            Member member = new Member(member_id,member_name,member_id2);
            
//            memberdao.insertMember(member);
//            connDB.getConnection().commit();
//            System.out.println("Member Inserted sucecsfully!");
            
            connDB.getConnection().setAutoCommit(false);

            member.setM_cathegoryMember("C");
            member.setM_emailMember("emailtest");

            //Why is telling that PK is violated when i'm not changing that??
            memberdao.UpdateMember(member);
            
            connDB.getConnection().commit();
            System.out.println("Member Updated Succesfully");

//            connDB.getConnection().setAutoCommit(false);
//            memberdao.DeleteMember(member);   
//            connDB.getConnection().commit();
//            System.out.println("Member Deleted Succesfully");
            
            
    }
        catch(SQLException sqlex){
            connDB.getConnection().rollback();
            System.out.println(sqlex.getMessage());
        }
    }
}
