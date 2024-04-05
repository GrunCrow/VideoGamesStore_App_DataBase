package controller;

import Application.HibernateUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import view.LoginView;
import view.MainWindow;
import view.MessageView;

/**
 * This class is not used because the connection is stablished in
 * Controller.java class.
 *
 * @author usuario
 */
public class LoginController implements ActionListener {

    private Session s = null;
    private LoginView vLogin;
    private MessageView vMessage = null;
    private MainWindow mainW = null;
    private boolean connectionOK = false;

    /**
     *
     */
    public LoginController() {
        vLogin = new LoginView();
        vMessage = new MessageView();
        addListener();

        vLogin.setLocationRelativeTo(null);
        vLogin.setVisible(true);
    }

    private void addListener() {
        vLogin.Connect.addActionListener(this);
        vLogin.Exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Connect":
                connectionOK = Connect();
                if (connectionOK) {
                    vLogin.dispose();
                    //Controller controller = new Controller(s);
                    //mainW.setLocationRelativeTo(null);
                    //mainW.setVisible(true);

                }
                break;
            case "Exit":
                vLogin.dispose();
                break;
            default:
                vMessage.Message("error", "Unknown button (You shouldn't see that)");
        }

    }

    private boolean connect() {

        boolean result = false;
        try {
            s = HibernateUtil.getSessionFactory().openSession();
            result = true;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

}
