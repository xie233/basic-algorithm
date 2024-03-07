package org.jim.creational.prototype;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class PropertyAccess {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Course course = new Course();
        String name = "Computer Science";
        List<String> codes = Arrays.asList("CS", "CS01");

        //SimpleProperty
        PropertyUtils.setSimpleProperty(course, "name", name);
        PropertyUtils.setSimpleProperty(course, "codes", codes);

        System.out.println(course);


        //IndexedProperty
        PropertyUtils.setIndexedProperty(course, "codes[1]", "CS02");

        System.out.println(course);

        Student student = new Student();
        String studentName = "Joe";
        student.setName(studentName);

        //MappedProperty
        PropertyUtils.setMappedProperty(course, "enrolledStudent(ST-1)", student);

        System.out.println(course);

//        String keyName = course.getEnrolledStudent().get("ST-1").getName();
//
//        Student student2 = new Student();
//        String studentName2 = "Joe";
//        student.setName(studentName);
//
//        String nameValue
//                = (String) PropertyUtils.getNestedProperty(
//                course, "enrolledStudent(ST-1).name");
//        System.out.println(nameValue);
        PropertyUtils.setNestedProperty(course, "enrolledStudent(ST-1).name","Gim");
        System.out.println(course);


//        Course course = new Course();
//        course.setName("Computer Science");
//        course.setCodes(Arrays.asList("CS"));
//        course.setEnrolledStudent("ST-1", new Student());

        //this will copy the properties with the same name only.
        CourseEntity courseEntity = new CourseEntity();
        BeanUtils.copyProperties(courseEntity, course);
        System.out.println(courseEntity);
    }
}
