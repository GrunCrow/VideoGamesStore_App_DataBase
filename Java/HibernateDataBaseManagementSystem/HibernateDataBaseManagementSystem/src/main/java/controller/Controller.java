package controller;

import Application.HibernateUtil;
import model.Activity;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Member1;
import model.MemberDAO;
import model.Trainer;
import model.TrainerDAO;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import model.ActivityDAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import view.MainWindow;
import view.MessageView;
import view.RegisterView;
import view.TableView;
import view.ViewActivity;
import view.ViewMember;
import view.ViewTrainer;

/**
 * This class controls all the functionalities of the program.
 *
 * @author Alberto Fernández Merchán
 */
public class Controller implements ActionListener {

    private Session s = null;
    private MessageView vMessage = null;
    private MainWindow mainwindow = null;
    private ViewMember vMember = null;
    private TableView vTable = null;
    private ViewTrainer vTrainer = null;
    private ViewActivity vActivity = null;
    private RegisterView rv = null;

    /**
     * Constructor of the class.
     */
    public Controller() {
        try {
            s = HibernateUtil.getSessionFactory().openSession();
        } catch (HibernateException e) {
            vMessage.Message("error", e.getMessage());
        }

        vMessage = new MessageView();
        mainwindow = new MainWindow();
        mainwindow.getContentPane().setLayout(new CardLayout());

        vTrainer = new ViewTrainer();
        vActivity = new ViewActivity();
        vMember = new ViewMember();
        rv = new RegisterView();

        mainwindow.getContentPane().setVisible(false);
        vTable = new TableView();
        mainwindow.add(vTrainer);
        vTrainer.setVisible(false);
        mainwindow.add(vMember);
        vMember.setVisible(false);
        mainwindow.add(vActivity);
        vActivity.setVisible(false);
        mainwindow.setVisible(true);

        vMember.MemberTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                vMemberMemberTableMouseClicked();
            }

        });

        vTrainer.TrainerTable.addMouseListener(new MouseAdapter() {
            /**
             * When the mouse click in the table, this method launch the
             * vTrainerTrainerTableMouseClicked() method.
             *
             * @param evt
             */
            @Override
            public void mouseClicked(MouseEvent evt) {
                vTrainerTrainerTableMouseClicked();
            }

        });

        rv.MemberList.addItemListener(new ItemListener() {
            /**
             *
             * @param e
             */
            @Override
            public void itemStateChanged(ItemEvent e) {
                memberCheckBoxUpdate();
            }

        });

        addListener();
    }

    /**
     *
     */
    private void memberCheckBoxUpdate() {
        MemberDAO mdao = new MemberDAO(s);
        Member1 m = mdao.getMember(rv.MemberList.getSelectedItem().toString());
        rv.ActList.clearSelection();
        for (Activity a : m.getActivitySet()) {
            rv.ActList.setSelectedValue(a.getAName(), true);
        }
    }

    /**
     * When a row of the trainer's table is selected, the information will be
     * displayed in the text fields.
     */
    private void vTrainerTrainerTableMouseClicked() {
        int row = vTrainer.TrainerTable.getSelectedRow();
        String[] values = new String[9];
        for (int i = 0; i < values.length; i++) {
            if (vTrainer.TrainerTable.getValueAt(row, i) != null) {
                values[i] = vTrainer.TrainerTable.getValueAt(row, i).toString();
            } else {
                values[i] = " ";
            }

        }

        TrainerDAO tdao = new TrainerDAO(s);
        ActivityDAO adao = new ActivityDAO(s);
        Set<Activity> inCharge = tdao.getTrainerActivities(values[0]);
        vTrainer.ActList.clearSelection();
        for (int i = 0; i < vTrainer.ActList.getModel().getSize(); i++) {
            if (inCharge.contains(adao.getActivityByName(vTrainer.ActList.getModel().getElementAt(i)))) {
                if (!vTrainer.ActList.isSelectedIndex(i)) {
                    vTrainer.ActList.setSelectedIndex(i);
                }
            }
        }

        vTrainer.trainerCod.setText(values[0]);
        vTrainer.trainerName.setText(values[1]);
        vTrainer.trainerSurname1.setText(values[2]);
        vTrainer.trainerSurname2.setText(values[3]);
        vTrainer.trainerId.setText(values[4]);
        vTrainer.trainerPhone.setText(values[5]);
        vTrainer.trainerEmail.setText(values[6]);
        String date = "";
        if (!values[7].equals("null")) {
            String Sdate[] = values[7].split("/");
            date = Sdate[2] + "-" + Sdate[1] + "-" + Sdate[0];
            System.out.println(Date.valueOf(date));
            vTrainer.trainerDate.setDate(Date.valueOf(date));
        } else {

            vMessage.Message("info", "The date is null\nHas been setted to " + Date.from(Instant.EPOCH).toString());
            System.out.println(Date.from(Instant.EPOCH));
            vTrainer.trainerDate.setDate(Date.from(Instant.EPOCH));
        }

        vTrainer.trainerNick.setText(values[8]);
    }

    /**
     * When a row of the members' table is selected, the information will be
     * displayed in the text fields.
     */
    private void vMemberMemberTableMouseClicked() {
        int row = vMember.MemberTable.getSelectedRow();
        String[] values = new String[8];
        for (int i = 0; i < values.length; i++) {
            if (vMember.MemberTable.getValueAt(row, i) != null) {
                values[i] = vMember.MemberTable.getValueAt(row, i).toString();
            } else {
                values[i] = " ";
            }
        }
        vMember.MemberNumber.setText(values[0]);
        vMember.MemberName.setText(values[1]);
        vMember.MemberId.setText(values[2]);
        vMember.MemberPhone.setText(values[3]);
        vMember.memberEmail.setText(values[5]);
        String Sdate[] = values[6].split("/");
        String date = Sdate[2] + "-" + Sdate[1] + "-" + Sdate[0];
        vMember.memberStartDate1.setDate(Date.valueOf(date));
        vMember.memberCat1.setSelectedItem(values[7]);

        String Bdate[] = values[4].split("/");
        date = Bdate[2] + "-" + Bdate[1] + "-" + Bdate[0];
        vMember.memberBirthDate1.setDate(Date.valueOf(date));

    }

    /**
     * Adds all the listeners of the application.
     */
    private void addListener() {
        mainwindow.MembersManagementItem.addActionListener(this);
        vMember.memberInsert.addActionListener(this);
        vMember.memberDelete.addActionListener(this);
        vMember.memberUpdate.addActionListener(this);
        vMember.memberListAll.addActionListener(this);
        vMember.memberEmpty.addActionListener(this);

        mainwindow.TrainersManagementItem.addActionListener(this);
        vTrainer.trainerInsert.addActionListener(this);
        vTrainer.trainerDelete.addActionListener(this);
        vTrainer.trainerUpdate.addActionListener(this);
        vTrainer.trainerListAll.addActionListener(this);
        vTrainer.trainerEmpty.addActionListener(this);

        mainwindow.ActivityManagementItem.addActionListener(this);
        vActivity.actRun.addActionListener(this);
        vActivity.registerMember.addActionListener(this);

        rv.registerMember.addActionListener(this);
        rv.selectAll.addActionListener(this);
        rv.clearAll.addActionListener(this);

    }

    @Override
    /**
     * Describes what to do when a button is pressioned.
     */
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "CloseMainWindow":
                mainwindow.dispose();
                System.exit(0);
                break;
            case "Exit":
                System.exit(0);
                break;
            case "MembersManagement":
                if (vTrainer.isVisible() || vActivity.isVisible()) {
                    vTrainer.setVisible(false);
                    vActivity.setVisible(false);
                }
                vMember.setVisible(true);
                vTable.setupTableMember(vMember);
                try {
                    MemberDAO mdao = new MemberDAO(s);
                    vTable.fillTableMember(mdao.listAllMembers());
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    vMessage.Message("error", ex.getMessage());
                }
                mainwindow.getContentPane().setVisible(true);

                break;

            case "memberInsert":
                try {
                Member1 m = new Member1(vMember.MemberNumber.getText(),
                        vMember.MemberName.getText(),
                        vMember.MemberId.getText(),
                        ParseDate(vMember.memberBirthDate1.getDate().toString()),
                        vMember.MemberPhone.getText(),
                        vMember.memberEmail.getText(),
                        ParseDate(vMember.memberStartDate1.getDate().toString()),
                        vMember.memberCat1.getSelectedItem().toString());
                MemberDAO mdao = new MemberDAO(s);
                mdao.insertMember(m);
                vTable.fillTableMember(mdao.listAllMembers());

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                vMessage.Message("error", ex.getMessage());
            }
            break;

            case "memberDelete":
                try {
                MemberDAO mdao = new MemberDAO(s);
                mdao.DeleteMember(vMember.MemberNumber.getText());
                vTable.fillTableMember(mdao.listAllMembers());
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                vMessage.Message("error", ex.getMessage());
            }

            break;

            case "memberUpdate":
                try {
                MemberDAO mdao = new MemberDAO(s);
                Member1 m = new Member1(vMember.MemberNumber.getText(),
                        vMember.MemberName.getText(),
                        vMember.MemberId.getText(),
                        ParseDate(vMember.memberBirthDate1.getDate().toString()),
                        vMember.MemberPhone.getText(),
                        vMember.memberEmail.getText(),
                        ParseDate(vMember.memberStartDate1.getDate().toString()),
                        vMember.memberCat1.getSelectedItem().toString());
                mdao.UpdateMember(vMember.MemberNumber.getText(), m);
                vTable.fillTableMember(mdao.listAllMembers());
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                vMessage.Message("error", ex.getMessage());
            }

            break;

            case "memberListAll":

                try {
                MemberDAO mdao = new MemberDAO(s);
                vTable.fillTableMember(mdao.listAllMembers());
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                vMessage.Message("error", ex.getMessage());
            }

            break;

            case "memberEmpty":
                try {
                MemberDAO mdao = new MemberDAO(s);
                mdao.CleanMembers();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                vMessage.Message("error", ex.getMessage());
            }
            break;
            case "Trainers Management":
                if (vMember.isVisible() || vActivity.isVisible()) {
                    vMember.setVisible(false);
                    vActivity.setVisible(false);
                }

                try {

                    ActivityDAO adao = new ActivityDAO(s);
                    ArrayList<Activity> alist = adao.getActList();
                    String[] actNames = new String[alist.size()];
                    for (int i = 0; i < alist.size(); i++) {
                        actNames[i] = alist.get(i).getAName();
                    }
                    DefaultListModel lm = new DefaultListModel();
                    for (String actName : actNames) {
                        lm.addElement(actName);
                    }
                    vTrainer.ActList.setModel(lm);

                    vTrainer.setVisible(true);
                    vTable.setupTableTrainer(vTrainer);
                    TrainerDAO tdao = new TrainerDAO(s);
                    vTable.fillTableTrainer(tdao.listAllTrainers());
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    vMessage.Message("error", ex.getMessage());
                }
                mainwindow.getContentPane().setVisible(true);
                break;

            case "trainerInsert":
                try {
                ActivityDAO adao = new ActivityDAO(s);
                Trainer t = new Trainer(vTrainer.trainerCod.getText(),
                        vTrainer.trainerName.getText(),
                        vTrainer.trainerSurname1.getText(),
                        vTrainer.trainerSurname2.getText(),
                        vTrainer.trainerId.getText(),
                        vTrainer.trainerPhone.getText(),
                        vTrainer.trainerEmail.getText(), (java.util.Date) vTrainer.trainerDate.getDate(),
                        vTrainer.trainerNick.getText());

                List<Activity> activityList = new ArrayList();
                for (int i = 0; i < vTrainer.ActList.getModel().getSize(); i++) {
                    if (vTrainer.ActList.isSelectedIndex(i)) {
                        activityList.add(adao.getActivityByName(vTrainer.ActList.getModel().getElementAt(i)));
                    }
                }

                Set<Activity> activitySet = new HashSet<>(activityList);

                t.setActivitySet(activitySet);
                TrainerDAO tdao = new TrainerDAO(s);
                tdao.insertTrainer(t);
                vTable.fillTableTrainer(tdao.listAllTrainers());

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                vMessage.Message("error", ex.getMessage());
            }
            break;
            case "trainerDelete":
                try {
                TrainerDAO tdao = new TrainerDAO(s);
                tdao.DeleteTrainer(vTrainer.trainerCod.getText());
                vTable.fillTableTrainer(tdao.listAllTrainers());
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                vMessage.Message("error", ex.getMessage());
            }
            break;
            case "trainerUpdate":
                try {
                ActivityDAO adao = new ActivityDAO(s);
                TrainerDAO tdao = new TrainerDAO(s);
                Trainer t = new Trainer(vTrainer.trainerCod.getText(),
                        vTrainer.trainerName.getText(),
                        vTrainer.trainerSurname1.getText(),
                        vTrainer.trainerSurname2.getText(),
                        vTrainer.trainerId.getText(),
                        vTrainer.trainerPhone.getText(),
                        vTrainer.trainerEmail.getText(), (java.util.Date) vTrainer.trainerDate.getDate(),
                        vTrainer.trainerNick.getText());

                List<Activity> activityList = new ArrayList();
                for (int i = 0; i < vTrainer.ActList.getModel().getSize(); i++) {
                    if (vTrainer.ActList.isSelectedIndex(i)) {
                        //if the activity has the generic trainer as trainer in charge, must remove from it and add the activity to the trainer t.
                        if (adao.getActivityByName(vTrainer.ActList.getModel().getElementAt(i)).getATrainerincharge().equals(tdao.getTrainerById("M999"))) {
                            tdao.getTrainerById("M999").getActivitySet().remove(adao.getActivityByName(vTrainer.ActList.getModel().getElementAt(i)));
                            adao.getActivityByName(vTrainer.ActList.getModel().getElementAt(i)).setATrainerincharge(t);
                            activityList.add(adao.getActivityByName(vTrainer.ActList.getModel().getElementAt(i)));
                            //if the activity haven't got a trainer in charge, we must add it.
                        } else if (adao.getActivityByName(vTrainer.ActList.getModel().getElementAt(i)).getATrainerincharge() == null) {
                            activityList.add(adao.getActivityByName(vTrainer.ActList.getModel().getElementAt(i)));
                            adao.getActivityByName(vTrainer.ActList.getModel().getElementAt(i)).setATrainerincharge(t);

                        } else if (adao.getActivityByName(vTrainer.ActList.getModel().getElementAt(i)).getATrainerincharge().equals(t)) {
                            //vMessage.Message("error", "The activity already has this trainer in charge");
                        } else if (adao.getActivityByName(vTrainer.ActList.getModel().getElementAt(i)).getATrainerincharge() != null) {
                            vMessage.Message("error", "The activity already has a trainer in charge");
                            vTrainer.ActList.setSelectedIndex(i);
                        }

                    } else { //if is not selected
                        //if the trainer is not the generic trainer...
                        if (!t.equals(tdao.getTrainerById("M999"))) {
                            if (adao.getActivityByName(vTrainer.ActList.getModel().getElementAt(i)).getATrainerincharge().equals(t)) { //if the activity had the trainer t
                                //as the trainer in charge, it must be changed to the M999 generic trainer.
                                if (tdao.getTrainerById("M999") != null) {
                                    tdao.getTrainerById("M999").getActivitySet().add(adao.getActivityByName(vTrainer.ActList.getModel().getElementAt(i)));
                                    adao.getActivityByName(vTrainer.ActList.getModel().getElementAt(i)).setATrainerincharge(tdao.getTrainerById("M999"));
                                } else {
                                    Trainer genericTrainer = new Trainer("M999", "Generic", "Trainer", "00000000A");
                                    genericTrainer.getActivitySet().add(adao.getActivityByName(vTrainer.ActList.getModel().getElementAt(i)));
                                    tdao.insertTrainer(genericTrainer);
                                    tdao.getTrainerById("M999").getActivitySet().add(adao.getActivityByName(vTrainer.ActList.getModel().getElementAt(i)));
                                    adao.getActivityByName(vTrainer.ActList.getModel().getElementAt(i)).setATrainerincharge(tdao.getTrainerById("M999"));
                                }
                            }
                        } else { //if it is the generic trainer
                            if (adao.getActivityByName(vTrainer.ActList.getModel().getElementAt(i)).getATrainerincharge().equals("M999")) {
                                vTrainer.ActList.setSelectedIndex(i);
                            }

                        }

                    }

                }
                t.setActivitySet(new HashSet<>(activityList));
                for (Activity a : activityList) {
                    a.setATrainerincharge(t);
                }
                tdao.UpdateTrainer(vTrainer.trainerCod.getText(), t);

                vTable.fillTableTrainer(tdao.listAllTrainers());
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                vMessage.Message("error", ex.getMessage());
            }
            break;
            case "trainerEmpty":
                try {
                TrainerDAO tdao = new TrainerDAO(s);
                tdao.CleanTrainers();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                vMessage.Message("error", ex.getMessage());
            }
            break;
            case "trainerListAll":
                try {
                TrainerDAO tdao = new TrainerDAO(s);
                vTable.fillTableTrainer(tdao.listAllTrainers());
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                vMessage.Message("error", ex.getMessage());
            }
            break;
            case "Activities Management":
                if (vMember.isVisible() || vTrainer.isVisible()) {
                    vMember.setVisible(false);
                    vTrainer.setVisible(false);
                }
                try {
                    ActivityDAO adao = new ActivityDAO(s);
                    vActivity.setVisible(true);
                    vTable.setupTableActivity(vActivity, adao.getActList());
                    mainwindow.getContentPane().setVisible(true);
                } catch (Exception ex) {
                }
                break;
            case "actRun":
                try {
                ActivityDAO adao = new ActivityDAO(s);
                vTable.fillTableActivity(vActivity.actList.getSelectedItem().toString(), adao.getMembers(vActivity.actList.getSelectedItem().toString()));

            } catch (Exception ex) {
            }
            break;
            case "Register Member":
                if (rv.MemberList == null) {
                    System.out.println("A");
                }
                try {
                    ActivityDAO adao = new ActivityDAO(s);
                    MemberDAO mdao = new MemberDAO(s);

                    ArrayList<Activity> alist = adao.getActList();
                    String[] actNames = new String[alist.size()];
                    for (int i = 0; i < alist.size(); i++) {
                        actNames[i] = alist.get(i).getAName();
                    }
                    DefaultListModel lm = new DefaultListModel();
                    for (String actName : actNames) {
                        lm.addElement(actName);
                    }
                    rv.ActList.setModel(lm);
                    ArrayList<Member1> mlist;
                    try {
                        mlist = mdao.listAllMembers();
                        if (rv.MemberList.getModel().getSize() != mlist.size()) {
                            //Adding the members into de ComboBox
                            //rv.MemberList.removeAll();
                            rv.MemberList.setModel(new DefaultComboBoxModel<>(new String[]{}));
                            for (int i = 0; i < mlist.size(); i++) {
                                rv.MemberList.addItem(mlist.get(i).getMName());
                            }
                        }
                    } catch (SQLException ex) {
                        vMessage.Message("error", "There was an unexpected error. 1");
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    Member1 m = mdao.getMember(rv.MemberList.getSelectedItem().toString());
                    rv.ActList.clearSelection();
                    for (Activity a : m.getActivitySet()) {
                        rv.ActList.setSelectedValue(a.getAName(), true);
                    }

                    rv.setVisible(true);

                    rv.setState(java.awt.Frame.NORMAL);
                    rv.toFront();
                } catch (Exception ex) {
                    vMessage.Message("error", "There was an unexpected error. \n " + ex.getMessage());
                }
                break;
            case "Update":
                try {
                ActivityDAO adao = new ActivityDAO(s);
                MemberDAO mdao = new MemberDAO(s);
                adao.clearPerforms(mdao.getMember(rv.MemberList.getSelectedItem().toString()), rv.ActList);

                adao.addMember(mdao.getMember(rv.MemberList.getSelectedItem().toString()), rv.ActList.getSelectedValuesList());

            } catch (Exception ex) {
            }

            break;
            case "Select All":
                for (int i = 0; i < rv.ActList.getModel().getSize(); i++) {
                    if (!rv.ActList.isSelectedIndex(i)) {
                        rv.ActList.setSelectedIndex(i);
                    }
                }

                break;
            case "Clear All":
                for (int i = 0; i < rv.ActList.getModel().getSize(); i++) {
                    if (rv.ActList.isSelectedIndex(i)) {
                        rv.ActList.setSelectedIndex(i);
                    }
                }
                break;
            default:
                throw new AssertionError();
        }
    }

    /**
     * Converts the date of the parameter with format: Fri Jul 05 00:00:00 CEST
     * 1996 into the correct format for the application: Jul 05 1996
     *
     * @param date
     * @return
     */
    private String ParseDate(String date) { //Fri Jul 05 00:00:00 CEST 1996

        HashMap<String, String> months = new HashMap<>();
        //String[] ESmonths = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};
        String[] ENmonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] Nmonths = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        int i = 0;
        for (String month : ENmonths) {
            months.put(month, Nmonths[i++]);
        }

        String d[] = date.split(" "); //Jul ; 05 ; 1996
        String result = d[2] + "/" + months.get(d[1]) + "/" + d[5];

        return result;

    }
}
