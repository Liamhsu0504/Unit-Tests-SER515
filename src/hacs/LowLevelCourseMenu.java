package hacs;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

import java.awt.Rectangle;

public class LowLevelCourseMenu extends CourseMenu {

    public LowLevelCourseMenu() {
    }


    void showAddButtons() {
        addButton.addActionListener(this::assignmentAddButtonActionPerformed);
        addButton.setText("Add");
        addButton.setBounds(new Rectangle(389, 54, 79, 29));
        optionAddButton.setText("Add");
        optionAddButton.setBounds(new Rectangle(390, 125, 79, 29));
        this.getContentPane().add(addButton, null);
        this.getContentPane().add(optionAddButton, null);
    }

    void showRadios() {
        assignmentRadiao.setText("Assignment");
        assignmentRadiao.setBounds(new Rectangle(21, 55, 103, 26));
        this.getContentPane().add(assignmentRadiao, null);
        optionRadio.setText("LowLevelExperiment");
        optionRadio.setBounds(new Rectangle(21, 128, 103, 26));
        this.getContentPane().add(optionRadio, null);
    }

    void showComboxes() {
        assignmentCombox.setBounds(new Rectangle(140, 57, 126, 22));
        optionCombo.setBounds(new Rectangle(137, 127, 126, 22));
        this.getContentPane().add(assignmentCombox, null);
        this.getContentPane().add(optionCombo, null);
        refresh();
    }

    void showViewButtons() {
        viewButton.setText("View");
        viewButton.setBounds(new Rectangle(290, 54, 79, 29));
        viewButton.addActionListener(this::assignmentViewButtonActionPerformed);
        optionViewButton.setText("View");
        optionViewButton.setBounds(new Rectangle(290, 124, 79, 29));
        this.getContentPane().add(viewButton, null);
        this.getContentPane().add(optionViewButton, null);
    }

    void showLabel() {
        assignmentContentLable.setText("AssigmentContent");
        assignmentContentLable.setBounds(new Rectangle(23, 186, 432, 99));
        this.getContentPane().add(assignmentContentLable, null);
    }
}
