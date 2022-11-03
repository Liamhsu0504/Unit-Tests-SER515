package hacs;

import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.Iterator;


/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public abstract class CourseMenu extends JDialog {
    Course theCourse;
    boolean bLogout = true;

    JRadioButton assignmentRadiao = new JRadioButton();
    JComboBox assignmentCombox = new JComboBox();
    JButton viewButton = new JButton();
    JButton addButton = new JButton();
    JRadioButton optionRadio = new JRadioButton();
    JLabel assignmentContentLable = new JLabel();
    JComboBox optionCombo = new JComboBox();
    JButton optionViewButton = new JButton();
    JButton optionAddButton = new JButton();
    JButton buttonCh = new JButton();
    JButton buttonLogout = new JButton();

    public CourseMenu() {
        jbInit();
        setModal(true);
        setSize(503, 294);
    }

    private void jbInit() {
        buttonCh.setText("ChangeCourse");
        buttonCh.setBounds(new Rectangle(101, 211, 73, 37));
        buttonCh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonChangeCourseActionPerformed(e);
            }
        });
        this.getContentPane().setLayout(null);
        this.setTitle("");
        buttonLogout.setText("Logout");
        buttonLogout.setBounds(new Rectangle(267, 215, 73, 37));
        buttonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonLogoutActionPerformed(e);
            }
        });
        this.getContentPane().add(buttonCh, null);
        this.getContentPane().add(buttonLogout, null);
    }


    abstract void showAddButtons();

    abstract void showViewButtons();

    abstract void showRadios();

    abstract void showComboxes();

    void assignmentAddButtonActionPerformed(ActionEvent e) {
        Hacs.theFacade.addAssignment(theCourse);
        refresh();
    }

    void assignmentViewButtonActionPerformed(ActionEvent e) {
        Assignment theAss = (Assignment) assignmentCombox.getSelectedItem();
        Hacs.theFacade.viewAssignment(theAss);
    }

    void refresh() {
        assignmentCombox.removeAllItems();
        Iterator iter = theCourse.assignmentList.iterator();
        while (iter.hasNext()) {
            assignmentCombox.addItem(iter.next());
        }
    }

    void buttonChangeCourseActionPerformed(ActionEvent e) {
        bLogout = false;
        dispose();
    }

    void buttonLogoutActionPerformed(ActionEvent e) {
        bLogout = true;
        dispose();
    }

    boolean ifLogout() {
        return bLogout;
    }
}
