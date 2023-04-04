package org.example.practice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Developer {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Grades grade;
    private Set<Skills> skills;
    private BigDecimal salary;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
