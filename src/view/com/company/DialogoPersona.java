package view.com.company;

import javax.swing.*;
import java.awt.event.*;

public class DialogoPersona extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField3;
    private JTextField textField1;

    public JTextField getTextField8() {
        return textField8;
    }

    public void setTextField8(JTextField textField8) {
        this.textField8 = textField8;
    }

    public JTextField getTextField9() {
        return textField9;
    }

    public void setTextField9(JTextField textField9) {
        this.textField9 = textField9;
    }

    public JTextField getTextField10() {
        return textField10;
    }

    public void setTextField10(JTextField textField10) {
        this.textField10 = textField10;
    }

    private JTextField textField2;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;

    public DialogoPersona() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);
        setVisible(true);
        pack();

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public JButton getButtonOK() {
        return buttonOK;
    }

    public void setButtonOK(JButton buttonOK) {
        this.buttonOK = buttonOK;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public void setButtonCancel(JButton buttonCancel) {
        this.buttonCancel = buttonCancel;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public void setTextField2(JTextField textField2) {
        this.textField2 = textField2;
    }

    public JTextField getTextField4() {
        return textField4;
    }

    public void setTextField4(JTextField textField4) {
        this.textField4 = textField4;
    }

    public JTextField getTextField5() {
        return textField5;
    }

    public void setTextField5(JTextField textField5) {
        this.textField5 = textField5;
    }

    public JTextField getTextField6() {
        return textField6;
    }

    public void setTextField6(JTextField textField6) {
        this.textField6 = textField6;
    }

    public JTextField getTextField7() {
        return textField7;
    }

    public void setTextField7(JTextField textField7) {
        this.textField7 = textField7;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public void setTextField3(JTextField textField3) {
        this.textField3 = textField3;
    }


    public void rellenaCamposDialogo (String [] array) {
        getTextField1().setText(array[0]);
        getTextField2().setText(array[1]);
        getTextField3().setText(array[2]);
        getTextField4().setText(array[3]);
        getTextField5().setText(array[4]);
        getTextField6().setText(array[5]);
        getTextField7().setText(array[6]);
        getTextField8().setText(array[7]);
        getTextField9().setText(array[8]);
        getTextField10().setText(array[9]);
    }

    public String [] rellenaCamposOk() {
        String [] data = new String[10];
        data[0] = getTextField1().getText();
        data[1] = getTextField2().getText();
        data[2] = getTextField3().getText();
        data[3] = getTextField4().getText();
        data[4] = getTextField5().getText();
        data[5] = getTextField6().getText();
        data[6] = getTextField7().getText();
        data[7] = getTextField8().getText();
        data[8] = getTextField9().getText();
        data[9] = getTextField10().getText();

        return data;
    }

    public boolean compruebaNulos (String [] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("")) {
                return false;
            }
        }

        return true;
    }
}
