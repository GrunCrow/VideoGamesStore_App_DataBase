package view;

import javax.swing.JOptionPane;

public class MessageView {

    public void Message(String type, String text) {
        switch (type) {
            case "info":
                JOptionPane.showMessageDialog(null, text, null, JOptionPane.INFORMATION_MESSAGE);
                break;
            case "error":
                JOptionPane.showMessageDialog(null, text, null, JOptionPane.ERROR_MESSAGE);
                break;
            default:

        }
    }

}
