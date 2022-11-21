package com.springbootapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private String empId;
    private String empEmail;
    private String empFirstName;
    private String empLastName;
    private String empGender;
    private String empPhoneNumber;

}
