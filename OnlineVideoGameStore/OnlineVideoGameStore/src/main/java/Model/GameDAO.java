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
public class GameDAO{
    
    private Game game = null;
    private Session session = null;
    private MessageView vMessage = null;
    
    /**
     * Constructor of the class
     *
     * @param s
     */
    public GameDAO(Session s) {
        session = s;
        vMessage = new MessageView();
    }

    public GameDAO(Session s, Game g) {
        game = g;
        session = s;
        vMessage = new MessageView();
    }
    
    /**
     * Gets a list of all the games from the database.
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<Game> listAllGames() throws SQLException {
        Transaction transaction = session.beginTransaction();
        ArrayList<Game> GamesArray = new ArrayList();
        try {
            GamesArray = (ArrayList<Game>) session.createNativeQuery("SELECT * FROM Game", Game.class).list();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            vMessage.Message("error", "Listing error: " + e.getMessage());
        }
        return GamesArray;
    }
    
    /**
     * Gets a game by its name.
     *
     * @param name
     * @return
     */
    public Game getGamebyName(String name) {
        return session.get(Game.class, (String) session.createNativeQuery("SELECT GameID FROM Game WHERE Name = \'" + name + "\'").list().get(0));
    }
    
    /**
     * Gets a member by its email.
     *
     * @param id
     * @return
     */
    public Game getGamebyID(String id) {
        return session.get(Game.class, (String) session.createNativeQuery("SELECT GameName FROM Game WHERE GameID = \'" + id + "\'").list().get(0));
    }
    
}
