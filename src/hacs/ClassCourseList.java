package hacs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @author mjfindler
 * @version 2.0 update to Java 8
 */

public class ClassCourseList extends ArrayList<Course> {

    public ClassCourseList() {
    }

    void initializeFromFile(String theFileName) {
        try {
            BufferedReader file;
            String strCourseName = null;
            file = new BufferedReader(
                    new FileReader("./src/resources/CourseInfo.txt"));
            while ((strCourseName = file.readLine()) != null) {
                Course theCourse;
                theCourse = new Course(strCourseName, 0);
                add(theCourse);
            }
        } catch (IOException ee) {
            return;
        }
    }
}
