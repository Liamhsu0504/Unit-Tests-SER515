package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Li Che Hsu
 * ASUrite: lhsu16
 * ASU ID: 1225397459
 */
class TestFacade {

    @Test
    void createUser() {
        Facade test = new Facade();
        UserInfoItem user = new UserInfoItem();
        user.userType = UserInfoItem.USERTYPE.Student;
        user.strUserName = "liam";
        test.createUser(user);
        assertEquals("liam", test.thePerson.userName);
    }

    @Test
    void createCourseList() {
        Facade test = new Facade();
        test.createCourseList();
        assertNotNull(test.theCourseList);
    }

    @Test
    void attachCourseToUser() {
        Facade test = new Facade();
        test.thePerson = new Student();
        test.createCourseList();
        test.thePerson.userName = "liam";
        test.attachCourseToUser();
        assertEquals(2, test.thePerson.courseList.size());
    }

}

