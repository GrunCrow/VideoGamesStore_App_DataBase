/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Member;
import model.MemberDAO;
import view.MainWindow;
import view.MessageView;
import view.TableView;
import view.ViewMember;
import view.ViewTrainer;

/**
 *
 * @author usuario
 */
public class Controller implements ActionListener {

    private LoginController lController = null;
    private MessageView vMessage = null;
    private MainWindow mainwindow = null;
    private ViewMember vMember = null;
    private TableView vTable = null;
    private ViewTrainer vTrainer = null;

    public Controller() {
        lController = new LoginController();
        vMessage = new MessageView();
        mainwindow = lController.getMainWindow();
        mainwindow.getContentPane().setLayout(new CardLayout());

        vTrainer = new ViewTrainer();

        vMember = new ViewMember();
        
        mainwindow.getContentPane().setVisible(false);
        vTable = new TableView();

        vMember.MemberTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                vMemberMemberTableMouseClicked(evt);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                vMemberMemberTableMouseEntered(evt);
            }

        });

        addListener();
    }

    private void vMemberMemberTableMouseClicked(MouseEvent evt) {
        System.out.println("a");
        //vMember.MemberTable.isRowSelected(0);
        //vMember.MemberTable.getValueAt(evt., 0);
    }

    private void vMemberMemberTableMouseEntered(MouseEvent evt) {
        //System.out.println("b");
    }

    private void addListener() {
        mainwindow.MembersManagementItem.addActionListener(this);
        vMember.memberInsert.addActionListener(this);
        vMember.memberDelete.addActionListener(this);
        vMember.memberUpdate.addActionListener(this);
        vMember.memberListAll.addActionListener(this);
        vMember.memberEmpty.addActionListener(this);
        
        mainwindow.TrainersManagementItem.addActionListener(this);
    }

    @Override
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
                
                mainwindow.getContentPane().add(vMember);
                vTable.setupTableMember(vMember);
                try {
                    MemberDAO mdao = new MemberDAO(lController.getConnection());
                    vTable.fillTableMember(mdao.listAllMembers());
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    vMessage.Message("error", ex.getMessage());
                }
                mainwindow.getContentPane().setVisible(true);

                break;
            case "memberInsert":
                try {
                Member m = new Member(vMember.MemberNumber.getText(),
                        vMember.MemberName.getText(),
                        vMember.MemberId.getText(),
                        vMember.memberBirthDate.getText(),
                        vMember.MemberPhone.getText(),
                        vMember.memberEmail.getText(),
                        vMember.memberStartDate.getText(),
                        vMember.memberCat.getText());

                MemberDAO mdao = new MemberDAO(lController.getConnection());
                mdao.insertMember(m);
                vTable.fillTableMember(mdao.listAllMembers());

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                vMessage.Message("error", ex.getMessage());
            }
            break;

            case "memberDelete":


                try {
                Member m = new Member(vMember.MemberNumber.getText(),
                        vMember.MemberName.getText(),
                        vMember.MemberId.getText());
                MemberDAO mdao = new MemberDAO(lController.getConnection());
                mdao.DeleteMember(m);
                vTable.fillTableMember(mdao.listAllMembers());
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                vMessage.Message("error", ex.getMessage());
            }

            break;

            case "memberUpdate": {
                try {
                    Member m = new Member(vMember.MemberNumber.getText(),
                            vMember.MemberName.getText(),
                            vMember.MemberId.getText(),
                            vMember.memberBirthDate.getText(),
                            vMember.MemberPhone.getText(),
                            vMember.memberEmail.getText(),
                            vMember.memberStartDate.getText(),
                            vMember.memberCat.getText());
                    MemberDAO mdao = new MemberDAO(lController.getConnection());
                    mdao.UpdateMember(m);
                    vTable.fillTableMember(mdao.listAllMembers());
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    vMessage.Message("error", ex.getMessage());
                }
            }

            break;

            case "memberListAll":

                try {
                MemberDAO mdao = new MemberDAO(lController.getConnection());
                vTable.fillTableMember(mdao.listAllMembers());
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                vMessage.Message("error", ex.getMessage());
            }

            break;

            case "memberEmpty":
                try {
                MemberDAO mdao = new MemberDAO(lController.getConnection());
                mdao.CleanMembers();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                vMessage.Message("error", ex.getMessage());
            }
            break;
            case "Trainers Management":
                mainwindow.getContentPane().add(vTrainer);
                mainwindow.getContentPane().setVisible(true);
                break;
            default:
                throw new AssertionError();
        }

    }

}
