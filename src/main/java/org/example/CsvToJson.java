package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvToJson {

    public static List<Employee> readFileToEmployees(File file) {
        List<Employee> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                result.add(new Employee(Long.parseLong(data[0]), data[1], data[2], data[3], Integer.parseInt(data[4])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void saveToJson(List<Employee> employees) {
        File file = new File("employee.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writeValue(file, employees);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
