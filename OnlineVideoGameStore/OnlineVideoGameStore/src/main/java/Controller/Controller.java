
package Controller;

import Application.HibernateUtil;
import Model.Connect;
import Model.Game;
import Model.User;
import java.awt.event.ActionListener;

//import Model.*;
import View.*;
import java.awt.event.ActionEvent;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Controller implements ActionListener{
    
    private Session s = null;
    
    User user;
    //Game game;
    
    private MessageView vMessage = null;
    //private Login vLogin = null; -> not login from main
    private MainView mainwindow = null;
    //private RegisterView rv = null; -> not implemented
    
    private SeeOffersView vSeeOffers = null;
    private SeeFilteredView vSeeFiltered = null;
    private PersonalInformationView vPersonalInformation = null;
    private GameInformationView vGameInformation = null;

    //not implemented views:
    /*private AddPaymentMethodView vAddpaymeth= null;
    private AddReviewView vAddReviewView = null;
    private ContBuying_PayView vContBuying = null;
    private PaymentInformationView vPaymentInformation = null;
    private ReadReviewsView vReadReviews = null;*/
    
    
    private Connect connect = null;
    
     public Controller() {
        //System.out.print("test"); 
        try {
            s = HibernateUtil.getSessionFactory().openSession();
        } catch (HibernateException e) {
            vMessage.Message("error", e.getMessage());
        }

        vMessage = new MessageView();
        mainwindow = new MainView();
        //mainwindow.getContentPane().setLayout(new CardLayout());
        //vLogin = new Login();
        
        vPersonalInformation = new PersonalInformationView();
        
        vSeeOffers = new SeeOffersView();
        vSeeFiltered = new SeeFilteredView();
        vGameInformation = new GameInformationView();

        //Not implemented views:
        /*vAddpaymeth= new AddPaymentMethodView();
        vAddReviewView = new AddReviewView();
        vContBuying = new ContBuying_PayView();
        vPaymentInformation = new PaymentInformationView();
        vReadReviews = new ReadReviewsView();*/
        
        //rv = new RegisterView(); -> not implemented
        
        
        //mainwindow.add(vPersonalInformation);
        vPersonalInformation.setVisible(false);
        //mainwindow.add(vFilteredOffers);
        vSeeFiltered.setVisible(false);
        //mainwindow.add(vGameInformation);
        vGameInformation.setVisible(false);
        vSeeOffers.setVisible(false);
        
        mainwindow.setLocationRelativeTo(null);
        mainwindow.setVisible(true);
        
        
        addListeners();
     }
     
     
     
     public Controller(Session session,User us) {
        user = us;
        try {
            s = session;
        } catch (HibernateException e) {
            vMessage.Message("error", e.getMessage());
        }

        vMessage = new MessageView();
        mainwindow = new MainView();
        //mainwindow.getContentPane().setLayout(new CardLayout());
        //vLogin = new Login();
        vSeeFiltered = new SeeFilteredView();
        vPersonalInformation = new PersonalInformationView();
        vGameInformation = new GameInformationView();

        //Not implemented views:
        /*vAddpaymeth= new AddPaymentMethodView();
        vAddReviewView = new AddReviewView();
        vContBuying = new ContBuying_PayView();
        vPaymentInformation = new PaymentInformationView();
        vReadReviews = new ReadReviewsView();*/
        
        //rv = new RegisterView(); -> not implemented
        
        mainwindow.jLabelEmail.setText(user.getUser_email());
        mainwindow.jLabelUsernameMain.setText(user.getUser_name());
        mainwindow.setLocationRelativeTo(null);
        mainwindow.setVisible(true);
        
        
        addListeners();
     }
     
    private void addListeners(){
        /*vLogin.jButtonExit.addActionListener(this);
        vLogin.jButtonConnect.addActionListener(this);
        vLogin.jButtonRegister.addActionListener(this);*/
        mainwindow.jButtonExit.addActionListener(this);
        mainwindow.jButtonSearch.addActionListener(this);
        mainwindow.jButtonSeeOffers.addActionListener(this);
        mainwindow.jButtonEditPersonalInformation.addActionListener(this);
    }
    
    @Override
    /**
     * Describes what to do when a button is pressioned.
     */
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            /*case "CloseMainWindow":
                mainwindow.dispose();
                System.exit(0);
                break;*/
            case "Exit":
                System.exit(0);
                break;
            case "See Offers":
                //JOptionPane.showMessageDialog(null, "This view has not been implemented");
                SeeOffersController SeeOffercontroller = new SeeOffersController(s,user);
                mainwindow.dispose();
                break;
            case "See Personal Information":
                PersonalInformationController PersonalInformationcontroller = new PersonalInformationController(s,user);
                mainwindow.dispose();
                 break;
            case "Search":
                String GameName = mainwindow.jTextGameName.getText();
                Game game = new Game(GameName);
                mainwindow.dispose();
                GameInformationController GIcontroller = new GameInformationController(s,user,game);
                //JOptionPane.showMessageDialog(null, "This view has not been implemented");
                break;
            default:
                throw new AssertionError();
        }
    }
}