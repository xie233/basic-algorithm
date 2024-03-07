package org.jim.creational.prototype;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class CourseEntity {
    private String name;
    private List<String> codes;
    private Map<String, Student> students = new HashMap<>();
    private String desc;

    //  standard getters/setters
}
