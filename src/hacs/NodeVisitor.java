package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public abstract class NodeVisitor {

    public NodeVisitor() {
    }

    public NodeVisitor(Object visitee) {
    }

    public abstract void visitFacade(Facade facade);

    public abstract void visitCourse(Course course);

    public abstract void visitAssignment(Assignment assignment);

}
