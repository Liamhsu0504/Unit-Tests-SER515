package hacs;


import hacs.UserInfoItem.USERTYPE;

import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @author mjfindler
 * @version 2.0
 * <p>
 * Update to Java 8
 */

public class Login extends JDialog {

    boolean isExit = false;
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JButton loginButton = new JButton();
    JButton buttonExit = new JButton();
    JTextField userNameText = new JTextField();
    JPasswordField passwordText = new JPasswordField();
    JRadioButton studentRadio = new JRadioButton();
    JRadioButton instructorRadio = new JRadioButton();
    ButtonGroup buttonGroup1 = new ButtonGroup();
    private String userBox = null;
    private USERTYPE userType = USERTYPE.Student;

    public Login() {
        jbInit();
        setSize(300, 300);
    }

    private void jbInit() {
        this.getContentPane().setLayout(null);
        jLabel1.setText("UserName");
        jLabel1.setBounds(new Rectangle(26, 52, 80, 18));
        jLabel2.setText("Password");
        jLabel2.setBounds(new Rectangle(23, 119, 80, 18));
        loginButton.setText("Login");
        loginButton.setBounds(new Rectangle(31, 212, 85, 28));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    loginButtonActionPerformed(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        buttonExit.setText("Exit");
        buttonExit.setBounds(new Rectangle(180, 211, 97, 28));
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonExitActionPerformed(e);
            }
        });
        userNameText.setBounds(new Rectangle(119, 52, 144, 22));
        passwordText.setBounds(new Rectangle(118, 119, 147, 22));
        studentRadio.setSelected(true);
        studentRadio.setText("Student");
        studentRadio.setBounds(new Rectangle(37, 164, 103, 26));
        instructorRadio.setText("Instructor");
        instructorRadio.setBounds(new Rectangle(177, 162, 103, 26));
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(loginButton, null);
        this.getContentPane().add(buttonExit, null);
        this.getContentPane().add(userNameText, null);
        this.getContentPane().add(passwordText, null);
        this.getContentPane().add(studentRadio, null);
        this.getContentPane().add(instructorRadio, null);
        buttonGroup1.add(studentRadio);
        buttonGroup1.add(instructorRadio);
    }

    void loginButtonActionPerformed(ActionEvent e) throws IOException {
        BufferedReader file;
        isExit = false;
        if (studentRadio.isSelected()) {
            userType = USERTYPE.Student;
            file = new BufferedReader(
                    new FileReader("./src/resources/StuInfo.txt"));
        } else {
            userType = USERTYPE.Instructor;
            file = new BufferedReader(
                    new FileReader("./src/resources/InsInfor.txt"));
        }
        userBox = userNameText.getText();
        String passwordBox = new String(passwordText.getPassword());
        String loginName = null;
        String aline = null, userName = null, password = null;
        while ((aline = file.readLine()) != null) {
            userName = getUserName(aline);
            password = getPassword(aline);
            if (userName.compareTo(userBox) == 0
                    && password.compareTo(passwordBox) == 0) {
                loginName = userName;
            }
        }
        if (loginName != null) {
            this.dispose();
        }

    }

    /*
     * get the user name from aline UserName:Password
     */
    private String getUserName(String aline) {
        int sep = aline.lastIndexOf(':');
        return aline.substring(0, sep);
    }

    /*
     * get the password from aline UserName:Password
     */
    private String getPassword(String aline) {
        int sep = aline.lastIndexOf(':');
        return aline.substring(sep + 1, aline.length());
    }

    /* after login get the UserName of the login interface */
    public String getUserName() {
        return userBox;
    }

    /* after login get the userType of the login interface */
    public USERTYPE getUserType() {
        return userType;
    }

    public boolean isExit() {
        return isExit;
    }

    void buttonExitActionPerformed(ActionEvent e) {
        isExit = true;
        dispose();
    }
}
