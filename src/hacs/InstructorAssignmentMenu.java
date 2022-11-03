package hacs;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class InstructorAssignmentMenu extends AssignmentMenu {
    private Solution theSolution;
    private Assignment theAssignment;
    JComboBox combSolutionList = new JComboBox();


    JTextField tbAssignmentName = new JTextField();
    JTextField tbDueDate = new JTextField();
    JTextField suggestSolution = new JTextField();

    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JButton buttonGrade = new JButton();
    JButton buttonReport = new JButton();
    JButton buttonClose = new JButton();

    SolutionIterator iter;
    SolutionIterator solIter;
    public InstructorAssignmentMenu() {
        jbInit();
    }

    private void jbInit() {
        jLabel1.setText("Assignment Name");
        jLabel1.setBounds(new Rectangle(25, 31, 118, 18));
        this.getContentPane().setLayout(null);
        tbAssignmentName.setText("jTextField1");
        tbAssignmentName.setBounds(new Rectangle(192, 31, 341, 22));
        jLabel2.setText("Due Date");
        jLabel2.setBounds(new Rectangle(28, 90, 113, 18));
        tbDueDate.setText("tbDueDate");
        tbDueDate.setBounds(new Rectangle(195, 87, 337, 22));
        jLabel3.setText("Suggested Solution");
        jLabel3.setBounds(new Rectangle(28, 151, 118, 18));
        suggestSolution.setText("jTextField2");
        suggestSolution.setBounds(new Rectangle(197, 149, 339, 22));
        buttonGrade.setText("Grade");
        buttonGrade.setBounds(new Rectangle(458, 199, 79, 29));
        buttonGrade.addActionListener(this::buttonGradeActionPerformed);
        buttonReport.setText("Report");
        buttonReport.setBounds(new Rectangle(365, 249, 79, 29));
        buttonReport.addActionListener(this::buttonReportActionPerformed);
        buttonClose.setText("Close");
        buttonClose.setBounds(new Rectangle(86, 253, 79, 29));
        buttonClose.addActionListener(this::buttonCloseActionPerformed);
        combSolutionList.setBounds(new Rectangle(32, 204, 413, 22));
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(tbAssignmentName, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(tbDueDate, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(suggestSolution, null);
        this.getContentPane().add(buttonClose, null);
        this.getContentPane().add(combSolutionList, null);
        this.getContentPane().add(buttonGrade, null);
        this.getContentPane().add(buttonReport, null);
    }

    public void showMenu(Assignment assignment, Person person) {
        theAssignment = assignment;
        tbAssignmentName.setText(theAssignment.assName);

        DateFormat theDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        tbDueDate.setText(theDateFormat.format(theAssignment.dueDate));
        suggestSolution.setText(theAssignment.suggestSolution.solutionFileName);
        refreshSolutionList();
        setVisible(true);
    }

    void buttonCloseActionPerformed(ActionEvent e) {
        theAssignment.assName = tbAssignmentName.getText();
        DateFormat temp = DateFormat.getDateInstance(DateFormat.SHORT);
        try {
            theAssignment.dueDate = temp.parse(tbDueDate.getText());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        theAssignment.suggestSolution.solutionFileName
                = suggestSolution.getText();
        dispose();
    }

    void buttonGradeActionPerformed(ActionEvent e) {
        Solution solution = (Solution) combSolutionList.getSelectedItem();
        if (solution == null) {
            return;
        }
        SolutionGradingDlg dlg = new SolutionGradingDlg();
        dlg.show(solution);
        refreshSolutionList();
    }

    void buttonReportActionPerformed(ActionEvent e) {
        iter = new SolutionIterator(theAssignment.theSolutionList);
        while (iter.hasNext()) {
            Solution asolution = (Solution) iter.next();
            asolution.setReported(true);
        }
        refreshSolutionList();
    }

    private void refreshSolutionList() {
        combSolutionList.removeAllItems();
        solIter = new SolutionIterator(theAssignment.theSolutionList);
        while (solIter.hasNext()) {
            theSolution = (Solution) solIter.next();
            combSolutionList.addItem(theSolution);
        }
    }
}

