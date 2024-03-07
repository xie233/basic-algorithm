package org.jim.creational.prototype;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class Course {
    private String name;
    private List<String> codes;
    private Map<String, Student> enrolledStudent = new HashMap<>();

    //  standard getters/setters
}

