package org.example;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("file.csv");
        List<Employee> employees = CsvToJson.readFileToEmployees(file);
        CsvToJson.saveToJson(employees);
    }
}