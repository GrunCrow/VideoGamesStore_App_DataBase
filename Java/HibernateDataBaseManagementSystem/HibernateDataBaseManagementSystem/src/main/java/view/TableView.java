package view;

import model.Activity;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Member1;
import model.Trainer;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Alberto Fernández Merchán
 */
public class TableView {

    MessageView vMessage = new MessageView();

    /**
     * Constructor of the class
     */
    public TableView() {

    }

    /**
     * Create the model of the member's table.
     */
    public DefaultTableModel modelTableMember = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Creates the model of the trainer's table.
     */
    public DefaultTableModel modelTableTrainer = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Creates the model of the activity's table.
     */
    public DefaultTableModel modelTableActivity = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Build the member's table.
     *
     * @param vMember
     */
    public void setupTableMember(ViewMember vMember) {
        vMember.MemberTable.setModel(modelTableMember);
        String[] columNames = {"Num", "Name", "Id", "Phone Number", "Birth Date", "Email", "Start Date", "Cat"};
        modelTableMember.setColumnIdentifiers(columNames);

        vMember.MemberTable.getTableHeader().setResizingAllowed(false);
        vMember.MemberTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        vMember.MemberTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        vMember.MemberTable.getColumnModel().getColumn(1).setPreferredWidth(240);
        vMember.MemberTable.getColumnModel().getColumn(2).setPreferredWidth(70);
        vMember.MemberTable.getColumnModel().getColumn(3).setPreferredWidth(70);
        vMember.MemberTable.getColumnModel().getColumn(4).setPreferredWidth(70);
        vMember.MemberTable.getColumnModel().getColumn(5).setPreferredWidth(240);
        vMember.MemberTable.getColumnModel().getColumn(6).setPreferredWidth(1);
    }

    /**
     * Builds the trainer's table.
     *
     * @param vTrainer
     */
    public void setupTableTrainer(ViewTrainer vTrainer) {
        vTrainer.TrainerTable.setModel(modelTableTrainer);
        String[] columNames = {"Cod", "Name", "Surname 1", "Surname 2", "ID", "Phone", "Email", "Date", "Nick"};
        modelTableTrainer.setColumnIdentifiers(columNames);

        vTrainer.TrainerTable.getTableHeader().setResizingAllowed(true);
        vTrainer.TrainerTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        vTrainer.TrainerTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        vTrainer.TrainerTable.getColumnModel().getColumn(1).setPreferredWidth(70);
        vTrainer.TrainerTable.getColumnModel().getColumn(2).setPreferredWidth(70);
        vTrainer.TrainerTable.getColumnModel().getColumn(3).setPreferredWidth(70);
        vTrainer.TrainerTable.getColumnModel().getColumn(4).setPreferredWidth(70);
        vTrainer.TrainerTable.getColumnModel().getColumn(5).setPreferredWidth(70);
        vTrainer.TrainerTable.getColumnModel().getColumn(6).setPreferredWidth(70);
        vTrainer.TrainerTable.getColumnModel().getColumn(7).setPreferredWidth(240);
        vTrainer.TrainerTable.getColumnModel().getColumn(8).setPreferredWidth(20);
    }

    /**
     * Builds the activity' table for the activity in parameters.
     *
     * @param vActivity
     * @param a
     */
    public void setupTableActivity(ViewActivity vActivity, ArrayList<Activity> a) {
        String[] acID = new String[a.size()];
        String[] aName = new String[a.size()];
        for (int i = 0; i < a.size(); i++) {
            acID[i] = a.get(i).getAId();
            aName[i] = a.get(i).getAName();
        }
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(aName);
        vActivity.actList.setModel(model);
        vActivity.ActivityTable.setModel(modelTableActivity);
        String[] columNames = {"Activity's Name", "Member's Name", "Member's E-mail"};
        modelTableActivity.setColumnIdentifiers(columNames);

        vActivity.ActivityTable.getTableHeader().setResizingAllowed(true);
        vActivity.ActivityTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        vActivity.ActivityTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        vActivity.ActivityTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        vActivity.ActivityTable.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    /**
     * Fills the member's table with all the information of the members.
     *
     * @param lmember
     */
    public void fillTableMember(ArrayList<Member1> lmember) {
        Object[] row = new Object[8];
        int numRows = lmember.size();
        cleanTableMember();

        for (int i = 0; i < numRows; i++) {
            row[0] = lmember.get(i).getMNum();
            row[1] = lmember.get(i).getMName();
            row[2] = lmember.get(i).getMId();
            row[3] = lmember.get(i).getMPhone();
            row[4] = lmember.get(i).getMBirhtdate();
            row[5] = lmember.get(i).getMEmailmember();
            row[6] = lmember.get(i).getMStartingdatemember();
            row[7] = lmember.get(i).getMCathegorymember();
            modelTableMember.addRow(row);
        }
    }

    /**
     * Fills the tariner's table with all the information of the trainers.
     *
     * @param ltrainer
     */
    public void fillTableTrainer(ArrayList<Trainer> ltrainer) {
        Object[] row = new Object[9];
        int numRows = ltrainer.size();

        cleanTableTrainer();

        for (int i = 0; i < numRows; i++) {
            row[0] = ltrainer.get(i).getTCod();
            row[1] = ltrainer.get(i).getTName();
            row[2] = ltrainer.get(i).getTSurname1();
            row[3] = ltrainer.get(i).getTSurname2();
            row[4] = ltrainer.get(i).getTIdnumber();
            row[5] = ltrainer.get(i).getTPhonenumber();
            row[6] = ltrainer.get(i).getTEmail();
            if (ltrainer.get(i).getTDate() != null) {
                //System.out.println(ParseDate(ltrainer.get(i).getTDate().toString()));
                row[7] = ParseDate(ltrainer.get(i).getTDate().toString());
            } else {
                row[7] = "null";
            }
            row[8] = ltrainer.get(i).getTNick();
            modelTableTrainer.addRow(row);
        }
    }

    /**
     * Transforms the date in format "2010-08-25 00:00:00.0" to the format
     * "25/08/2010" for an easy way to display the date in the tables
     *
     * @param date
     * @return
     */
    private String ParseDate(String date) { //2010-08-25 00:00:00.0
        if (date != null && date.split(" ").length == 2) {
            String[] d = date.split(" ")[0].split("-");
            String result = d[2] + "/" + d[1] + "/" + d[0];
            return result; //25/08/2010
        } else if (date == null) {
            return "null";
        } else if (date.split(" ").length > 2) {
            return ParseDateBigFormat(date);
        } else {
            vMessage.Message("error", "Date is not recognized.");
            return null;
        }
    }

    /**
     * Converts the date of the parameter with format: Fri Jul 05 00:00:00 CEST
     * 1996 into the correct format for the application: Jul 05 1996
     *
     * @param date
     * @return
     */
    private String ParseDateBigFormat(String date) { //Fri Jul 05 00:00:00 CEST 1996

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

    /**
     * Fills the activity's table with the activity in parameters and all the
     * members whom are enrolled in that activity.
     *
     * @param ActName Name of the activity you want look for the members.
     * @param lMember Members that are enrolled in the activity.
     */
    public void fillTableActivity(String ActName, ArrayList<Member1> lMember) {
        Object[] row = new Object[3];
        int numRows = lMember.size();

        cleanTableActivity();

        for (int i = 0; i < numRows; i++) {
            row[0] = ActName;
            row[1] = lMember.get(i).getMName();
            row[2] = lMember.get(i).getMEmailmember();
            modelTableActivity.addRow(row);
        }
    }

    /**
     * Erase all the information of the member's table.
     */
    public void cleanTableMember() {

        for (int i = modelTableMember.getRowCount() - 1; i >= 0; i--) {
            modelTableMember.removeRow(i);
        }
    }

    /**
     * Erase all the information of the trainer's table.
     */
    public void cleanTableTrainer() {

        for (int i = modelTableTrainer.getRowCount() - 1; i >= 0; i--) {
            modelTableTrainer.removeRow(i);
        }
    }

    /**
     * Erase all the information of the activity's table.
     */
    public void cleanTableActivity() {
        for (int i = modelTableActivity.getRowCount() - 1; i >= 0; i--) {
            modelTableActivity.removeRow(i);
        }
    }

}
