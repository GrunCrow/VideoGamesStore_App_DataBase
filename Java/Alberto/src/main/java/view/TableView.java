package view;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Member;

/**
 *
 * @author usuario
 */
public class TableView {


    public TableView() {

    }

    public DefaultTableModel modelTableMember = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    

    public void setupTableMember(ViewMember vMember) {
        vMember.MemberTable.setModel(modelTableMember);
        String[] columNames = {"Num","Name","Id","Birth Date","Phone Number", "Email", "Start Date", "Cat"};
        modelTableMember.setColumnIdentifiers(columNames);
        
        vMember.MemberTable.getTableHeader().setResizingAllowed(false);
        vMember.MemberTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        vMember.MemberTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        vMember.MemberTable.getColumnModel().getColumn(1).setPreferredWidth(240);
        vMember.MemberTable.getColumnModel().getColumn(2).setPreferredWidth(70);
        vMember.MemberTable.getColumnModel().getColumn(3).setPreferredWidth(70);
        vMember.MemberTable.getColumnModel().getColumn(4).setPreferredWidth(70);
        vMember.MemberTable.getColumnModel().getColumn(5).setPreferredWidth(240);
        vMember.MemberTable.getColumnModel().getColumn(6).setPreferredWidth(1);
    }
    
    public void fillTableMember(ArrayList<Member> lmember){
        Object[] row = new Object[8];
        int numRows = lmember.size();
        
        cleanTableMember();
        
        for (int i = 0; i < numRows; i++) {
            row[0] = lmember.get(i).getM_num();
            row[1] = lmember.get(i).getM_name();
            row[2] = lmember.get(i).getM_id();
            row[3] = lmember.get(i).getM_phone();
            row[4] = lmember.get(i).getM_birthdate();
            row[5] = lmember.get(i).getM_emailMember();
            row[6] = lmember.get(i).getM_startingDateMember();
            row[7] = lmember.get(i).getM_cathegoryMember();
            modelTableMember.addRow(row);
        }
    }
    
    public void cleanTableMember(){
    
        for (int i = modelTableMember.getRowCount() - 1; i >= 0 ; i--) {
            modelTableMember.removeRow(i);
        }
    }

}
