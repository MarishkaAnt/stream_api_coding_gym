package org.example.practice.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class TaskData {

    private static final Developer DEVELOPER_1 = Developer.builder()
            .id(1).firstName("John").lastName("Johnson").age(21).grade(Grades.JUNIOR)
            .skills(Set.of(Skills.JAVA_8, Skills.MAVEN, Skills.POSTGRESQL))
            .salary(BigDecimal.valueOf(1000))
            .build();
    private static final Developer DEVELOPER_2 = Developer.builder()
            .id(2).firstName("Jack").lastName("Jackson").age(22).grade(Grades.JUNIOR)
            .skills(Set.of(Skills.JAVA_8, Skills.JAVA_11, Skills.MAVEN, Skills.POSTGRESQL))
            .salary(BigDecimal.valueOf(1000))
            .build();
    private static final Developer DEVELOPER_3 = Developer.builder()
            .id(3).firstName("Tom").lastName("Thompson").age(23).grade(Grades.MIDDLE)
            .skills(Set.of(Skills.DOCKER, Skills.JAVA_11, Skills.GRADLE, Skills.POSTGRESQL))
            .salary(BigDecimal.valueOf(2000))
            .build();
    private static final Developer DEVELOPER_4 = Developer.builder()
            .id(4).firstName("Math").lastName("Mathewson").age(24).grade(Grades.MIDDLE)
            .skills(Set.of(Skills.JAVA_SCRIPT, Skills.REACT, Skills.NODE_JS, Skills.LINUX))
            .salary(BigDecimal.valueOf(2000))
            .build();
    private static final Developer DEVELOPER_5 = Developer.builder()
            .id(5).firstName("Math").lastName("Mathewson").age(25).grade(Grades.MIDDLE)
            .skills(Set.of(Skills.LINUX, Skills.JAVA_11, Skills.GRADLE, Skills.ARANGODB))
            .salary(BigDecimal.valueOf(2000))
            .build();
    private static final Developer DEVELOPER_6 = Developer.builder()
            .id(6).firstName("Garry").lastName("Garrison").age(26).grade(Grades.SENIOR)
            .skills(Set.of(Skills.JAVA_11, Skills.MAVEN, Skills.POSTGRESQL, Skills.MSSQL_SERVER))
            .salary(BigDecimal.valueOf(3000))
            .build();
    private static final Developer DEVELOPER_7 = Developer.builder()
            .id(7).firstName("Math").lastName("Mathewson").age(27).grade(Grades.SENIOR)
            .skills(Set.of(Skills.JAVA_11, Skills.MAVEN, Skills.POSTGRESQL, Skills.MSSQL_SERVER))
            .salary(BigDecimal.valueOf(4000))
            .build();
    private static final Developer DEVELOPER_8 = Developer.builder()
            .id(8).firstName("Rajesh").lastName("Koothrappli").age(28).grade(Grades.TEAM_LEAD)
            .skills(Set.of(Skills.JAVA_11, Skills.LINUX, Skills.DOCKER, Skills.POSTGRESQL))
            .salary(BigDecimal.valueOf(5000))
            .build();
    private static final Developer DEVELOPER_9 = Developer.builder()
            .id(9).firstName("Sharchan").lastName("Kumar").age(29).grade(Grades.TEAM_LEAD)
            .skills(Set.of(Skills.JAVA_11, Skills.LINUX, Skills.DOCKER, Skills.POSTGRESQL))
            .salary(BigDecimal.valueOf(6000))
            .build();
    private static final Developer DEVELOPER_10 = Developer.builder()
            .id(10).firstName("Raja").lastName("Kachamali").age(30).grade(Grades.TEAM_LEAD)
            .skills(Set.of(Skills.JAVA_11, Skills.LINUX, Skills.DOCKER, Skills.POSTGRESQL))
            .salary(BigDecimal.valueOf(7000))
            .build();

    private static final Team TEAM_1 = Team.builder()
            .id(1).teamName("Noobies-boobies")
            .developers(Set.of(DEVELOPER_1, DEVELOPER_2, DEVELOPER_8))
            .build();
    private static final Team TEAM_2 = Team.builder()
            .id(2).teamName("Wild middle West")
            .developers(Set.of(DEVELOPER_3, DEVELOPER_4, DEVELOPER_5, DEVELOPER_9))
            .build();
    private static final Team TEAM_3 = Team.builder()
            .id(3).teamName("Shiny Stars")
            .developers(Set.of(DEVELOPER_6, DEVELOPER_7, DEVELOPER_10))
            .build();
    private static final Team TEAM_4 = Team.builder()
            .id(4).teamName("Balance")
            .developers(Set.of(DEVELOPER_2, DEVELOPER_3, DEVELOPER_6, DEVELOPER_10))
            .build();
    private static final Team TEAM_5 = Team.builder()
            .id(5).teamName("Jedi Masters")
            .developers(Set.of(DEVELOPER_7, DEVELOPER_8, DEVELOPER_9, DEVELOPER_10))
            .build();


    public static List<Project> getProjectList() {
        return List.of(
                Project.builder().id(1).projectName("Stellar").durationInMonth(1)
                        .teams(Set.of(TEAM_1)).build(),
                Project.builder().id(2).projectName("Apollo").durationInMonth(2)
                        .teams(Set.of(TEAM_2, TEAM_3, TEAM_4)).build(),
                Project.builder().id(3).projectName("Warship").durationInMonth(3)
                        .teams(Set.of(TEAM_4, TEAM_5)).build(),
                Project.builder().id(4).projectName("Ranger").durationInMonth(4)
                        .teams(Set.of(TEAM_2,TEAM_4)).build(),
                Project.builder().id(5).projectName("Millennium Falcon").durationInMonth(5)
                        .teams(Set.of(TEAM_3, TEAM_5)).build()
        );
    }
}
