package hacs;

import javax.swing.JDialog;


/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public abstract class AssignmentMenu extends JDialog {
    abstract void showMenu(Assignment ass, Person per);

    public AssignmentMenu() {
        setModal(true);
        setSize(575, 330);
    }
}
