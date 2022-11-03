package hacs;

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
 * Update to Jave 8
 */

public class Facade {
    int userType;
    private Course theSelecteCourse = null;
    private int nCourseLevel = 0;
    ClassCourseList theCourseList;
    Person thePerson;

    public Facade() {
    }

    public static boolean login(UserInfoItem userinfoItem) {
        Login login = new Login();
        login.setModal(true);
        login.show();
        userinfoItem.strUserName = login.getUserName();
        userinfoItem.userType = login.getUserType();
        return login.isExit();
    }

    void addAssignment(Course theCourse) {
        AssignmentMenu theAssignmentMenu;
        if (thePerson.type == 0) {
            theAssignmentMenu = new StudentAssignmentMenu();
        } else {
            theAssignmentMenu = new InstructorAssignmentMenu();
        }
        Assignment theAssignment = new Assignment();
        theAssignmentMenu.showMenu(theAssignment, thePerson);
        theCourse.addAssignment(theAssignment);
    }

    void viewAssignment(Assignment theAssignment) {
        AssignmentMenu theAssignmentMenu;
        if (thePerson.type == 0) {
            theAssignmentMenu = new StudentAssignmentMenu();
        } else {
            theAssignmentMenu = new InstructorAssignmentMenu();
        }

        theAssignmentMenu.showMenu(theAssignment, thePerson);
    }


    void remind() {
        Reminder theReminder = new Reminder();
        theReminder.showReminder();
    }

    void createUser(UserInfoItem userinfoitem) {
        if (userinfoitem.userType == UserInfoItem.USERTYPE.Student) {
            thePerson = new Student();
        } else {
            thePerson = new Instructor();
        }
        thePerson.userName = userinfoitem.strUserName;
    }

    /*
     * create a course list and intitialize it with the file CourseInfo.txt
     */
    void createCourseList() {
        theCourseList = new ClassCourseList();
        theCourseList.initializeFromFile("./src/resources/CourseInfo.txt");
    }

    void attachCourseToUser() {
        BufferedReader file;
        try {
            file = new BufferedReader(
                    new FileReader("./src/resources/UserCourse.txt"));
            String aline, strUserName, strCourseName;
            while ((aline = file.readLine()) != null) {
                strUserName = getUserName(aline);
                strCourseName = getCourseName(aline);
                if (strUserName.compareTo(thePerson.userName) == 0) {
                    theSelecteCourse = findCourseByCourseName(strCourseName);
                    if (theSelecteCourse != null) {
                        thePerson.addCourse(theSelecteCourse);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * get the user name from aline UserName:CourseName
     */
    private String getUserName(String aline) {
        int sep = aline.lastIndexOf(':');
        return aline.substring(0, sep);
    }

    /*
     * get the CourseName from aline UserName:CourseName
     */
    private String getCourseName(String aline) {
        int sep = aline.lastIndexOf(':');
        return aline.substring(sep + 1, aline.length());
    }

    /*
     * show the course selection dlg, show the course attatched to theperson and
     * return the selected course and assign the course to the class member
     * theSelecteCourse, the Course Level to CourseLevel CourseLeve=0 High,
     * CourseLeve=1 Low
     */
    public boolean selectCourse() {
        CourseSelectDlg theDlg = new CourseSelectDlg();
        theSelecteCourse = theDlg.showDlg(thePerson.courseList);
        thePerson.currentCourse = theSelecteCourse;
        nCourseLevel = theDlg.nCourseLevel;
        return theDlg.isLogout();
    }


    public boolean courseOperation() {
        thePerson.createCourseMenu(theSelecteCourse, nCourseLevel);
        return thePerson.showMenu();
    }

    private Course findCourseByCourseName(String strCourseName) {
        CourseIterator iterator = new CourseIterator(theCourseList);
        return (Course) iterator.next(strCourseName);
    }

}
