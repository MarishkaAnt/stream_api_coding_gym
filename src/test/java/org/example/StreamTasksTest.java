package org.example;

import org.example.practice.StreamTasks;
import org.example.practice.domain.Grades;
import org.example.practice.domain.Project;
import org.example.practice.domain.Skills;
import org.example.practice.domain.TaskData;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class StreamTasksTest {

    private static final List<Project> projects = TaskData.getProjectList();

    @Test
    void findProjectWithMaxTeamCount() {
        String expected = "Apollo";
        String actual = StreamTasks.findProjectWithMaxTeamCount(projects);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void findProjectWithMinDeveloperCount() {
        String expected = "Stellar";
        String actual = StreamTasks.findProjectWithMinDeveloperCount(projects);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void findTheMostExpensiveProject() {
        String expected = "Millennium Falcon";
        String actual = StreamTasks.findTheMostExpensiveProject(projects);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void findProjectWithMaxTeamLeadDevelopersCount() {
        String expected = "Warship";
        String actual = StreamTasks.findProjectWithMaxTeamLeadDevelopersCount(projects);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void findProjectWithTheOldestDevelopersSum() {
        String expected = "Apollo";
        String actual = StreamTasks.findProjectWithTheOldestDevelopersSum(projects);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void findProjectsWithDurationMoreTwoMonths() {
        List<String> expected = Arrays.asList("Warship", "Ranger", "Millennium Falcon");
        List<String> actual = StreamTasks.findProjectsWithDurationMoreTwoMonths(projects);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getSumTeamLeadSalaryWorkingOnProjectsLongerThanTwoMonths() {
        BigDecimal expected = BigDecimal.valueOf(18000);
        BigDecimal actual = StreamTasks.getSumTeamLeadSalaryWorkingOnProjectsLongerThanTwoMonths(projects);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getAllJavaDevelopersSortedBySalary() {
        String dev1 = "John Johnson: 1000";
        String dev2 = "Jack Jackson: 1000";
        String dev3 = "Tom Thompson: 2000";
        String dev5 = "Math Mathewson: 2000";
        String dev6 = "Garry Garrison: 3000";
        String dev7 = "Math Mathewson: 4000";
        String dev8 = "Rajesh Koothrappli: 5000";
        String dev9 = "Sharchan Kumar: 6000";
        String dev10 = "Raja Kachamali: 7000";

        List<String> expected = List.of(dev2, dev1, dev5, dev3, dev6, dev7, dev8, dev9, dev10);
        List<String> actual = StreamTasks.getAllJavaDevelopersSortedBySalary(projects);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getTeamsGroupingByProject() {
        Map<String, List<String>> expected = new HashMap<>();

        List<String> l1 = new ArrayList<>(List.of("Balance", "Wild middle West"));
        l1.sort(Comparator.comparing((String s) -> s));
        expected.put("Ranger", l1);

        List<String> l2 = new ArrayList<>(List.of("Jedi Masters", "Balance"));
        l2.sort(Comparator.comparing((String s) -> s));
        expected.put("Warship", l2);

        List<String> l3 = new ArrayList<>(List.of("Balance", "Wild middle West", "Shiny Stars"));
        l3.sort(Comparator.comparing((String s) -> s));
        expected.put("Apollo", l3);

        List<String> l4 = new ArrayList<>(List.of("Jedi Masters", "Shiny Stars"));
        l4.sort(Comparator.comparing((String s) -> s));
        expected.put("Millennium Falcon", l4);

        List<String> l5 = new ArrayList<>(List.of("Noobies-boobies"));
        l5.sort(Comparator.comparing((String s) -> s));
        expected.put("Stellar", l5);

        Map<String, List<String>> actual = StreamTasks.getTeamsGroupingByProject(projects);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getDevelopersGroupingByTeams() {
        Map<String, List<String>> expected = new HashMap<>();

        List<String> l1 = List.of("Garry Garrison", "Math Mathewson", "Raja Kachamali");
        expected.put("Shiny Stars", l1);

        List<String> l2 = List.of("Math Mathewson", "Math Mathewson", "Sharchan Kumar", "Tom Thompson");
        expected.put("Wild middle West", l2);

        List<String> l3 = List.of("Jack Jackson", "John Johnson", "Rajesh Koothrappli");
        expected.put("Noobies-boobies", l3);

        List<String> l4 = List.of("Math Mathewson", "Raja Kachamali", "Rajesh Koothrappli", "Sharchan Kumar");
        expected.put("Jedi Masters", l4);

        List<String> l5 = List.of("Garry Garrison", "Jack Jackson", "Raja Kachamali", "Tom Thompson");
        expected.put("Balance", l5);

        Map<String, List<String>> actual = StreamTasks.getDevelopersGroupingByTeams(projects);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getDevelopersGroupingByProjects() {
        Map<String, List<String>> expected = new TreeMap<>();


        List<String> l1 = new ArrayList<>(List.of("Tom Thompson", "Math Mathewson", "Math Mathewson", "Sharchan Kumar",
                "Garry Garrison", "Math Mathewson", "Raja Kachamali",
                "Jack Jackson"));
        Collections.sort(l1);
        expected.put("Apollo", l1);

        List<String> l2 = new ArrayList<>(List.of("John Johnson", "Jack Jackson", "Rajesh Koothrappli"));
        Collections.sort(l2);
        expected.put("Stellar", l2);

        List<String> l3 = new ArrayList<>(List.of("Jack Jackson", "Tom Thompson", "Garry Garrison",  "Raja Kachamali",
                "Math Mathewson", "Rajesh Koothrappli", "Sharchan Kumar"));
        Collections.sort(l3);
        expected.put("Warship", l3);

        List<String> l4 = new ArrayList<>(List.of("Tom Thompson", "Math Mathewson", "Math Mathewson", "Sharchan Kumar",
                "Jack Jackson", "Garry Garrison", "Raja Kachamali"));
        Collections.sort(l4);
        expected.put("Ranger", l4);

        List<String> l5 = new ArrayList<>(List.of("Garry Garrison", "Math Mathewson", "Raja Kachamali",
                "Rajesh Koothrappli", "Sharchan Kumar"));
        Collections.sort(l5);
        expected.put("Millennium Falcon", l5);

        Map<String, List<String>> actual = StreamTasks.getDevelopersGroupingByProjects(projects);

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void getTeamsGroupingByProjectSortedBySalarySum() {
        Map<String, List<String>> expected = new HashMap<>();

        List<String> l1 = new  ArrayList<>(List.of("Noobies-boobies"));
        Collections.sort(l1);
        expected.put("Stellar (7000)", l1);

        List<String> l2 = new ArrayList<>(List.of("Wild middle West", "Shiny Stars", "Balance"));
        Collections.sort(l2);
        expected.put("Apollo (27000)", l2);

        List<String> l3 = new ArrayList<>(List.of("Balance", "Jedi Masters"));
        Collections.sort(l3);
        expected.put("Warship (28000)", l3);

        List<String> l4 = new ArrayList<>(List.of("Wild middle West", "Balance"));
        Collections.sort(l4);
        expected.put("Ranger (23000)", l4);

        List<String> l5 = new ArrayList<>(List.of("Shiny Stars", "Jedi Masters"));
        Collections.sort(l5);
        expected.put("Millennium Falcon (25000)", l5);

        Map<String, List<String>> actual = StreamTasks.getTeamsGroupingByProjectSortedBySalarySum(projects);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getDevelopersGroupingByTeamsSortedByAge() {
        Map<String, List<String>> expected = new LinkedHashMap<>();

        List<String> l1 = new ArrayList<>(List.of("Garry Garrison (26)", "Math Mathewson (27)", "Raja Kachamali (30)"));
        expected.put("Shiny Stars", l1);

        List<String> l2 = new ArrayList<>(List.of("Tom Thompson (23)", "Math Mathewson (24)", "Math Mathewson (25)",
                "Sharchan Kumar (29)"));
        expected.put("Wild middle West", l2);

        List<String> l3 = new ArrayList<>(List.of("John Johnson (21)", "Jack Jackson (22)", "Rajesh Koothrappli (28)"));
        expected.put("Noobies-boobies", l3);

        List<String> l4 = new ArrayList<>(List.of("Math Mathewson (27)", "Rajesh Koothrappli (28)",
                "Sharchan Kumar (29)", "Raja Kachamali (30)"));
        expected.put("Jedi Masters", l4);

        List<String> l5 = new ArrayList<>(List.of("Jack Jackson (22)", "Tom Thompson (23)", "Garry Garrison (26)",
                "Raja Kachamali (30)"));
        expected.put("Balance", l5);

        Map<String, List<String>> actual = StreamTasks.getDevelopersGroupingByTeamsSortedByAge(projects);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getDevelopersSortedByLastNameGroupingByProjectsSortedByDuration() {
        Map<String, List<String>> expected = new LinkedHashMap<>();

        List<String> l1 = List.of("Garry Garrison", "Raja Kachamali",
                "Rajesh Koothrappli", "Sharchan Kumar", "Math Mathewson");
        expected.put("Millennium Falcon (5)",l1);

        List<String> l2 = List.of("Garry Garrison", "Jack Jackson", "Raja Kachamali", "Sharchan Kumar",
                "Math Mathewson", "Math Mathewson", "Tom Thompson");
        expected.put("Ranger (4)", l2);

        List<String> l3 = List.of("Garry Garrison", "Jack Jackson", "Raja Kachamali", "Rajesh Koothrappli",
                "Sharchan Kumar", "Math Mathewson", "Tom Thompson");
        expected.put("Warship (3)", l3);

        List<String> l4 = List.of("Garry Garrison", "Jack Jackson", "Raja Kachamali", "Sharchan Kumar",
                "Math Mathewson", "Math Mathewson", "Math Mathewson", "Tom Thompson");
        expected.put("Apollo (2)", l4);

        List<String> l5 = List.of("Jack Jackson", "John Johnson", "Rajesh Koothrappli");
        expected.put("Stellar (1)", l5);

        Map<String, List<String>> actual = StreamTasks.getDevelopersSortedByLastNameGroupingByProjectsSortedByDuration(projects);

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void getDevelopersSortedByAgeGroupingByGrade() {
        Map<Grades, List<String>> expected = new LinkedHashMap<>();

        List<String> l1 = List.of("Math Mathewson", "Garry Garrison");
        expected.put(Grades.valueOf("SENIOR"), l1);

        List<String> l2 = List.of("Math Mathewson", "Math Mathewson", "Tom Thompson");
        expected.put(Grades.valueOf("MIDDLE"), l2);

        List<String> l3 = List.of("Jack Jackson", "John Johnson");
        expected.put(Grades.valueOf("JUNIOR"), l3);

        List<String> l4 = List.of("Raja Kachamali", "Sharchan Kumar", "Rajesh Koothrappli");
        expected.put(Grades.valueOf("TEAM_LEAD"), l4);

        Map<Grades, List<String>> actual = StreamTasks.getDevelopersSortedByAgeGroupingByGrade(projects);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getDevelopersSortedByLastNameGroupingByGrade() {
        Map<Skills, List<String>> expected = new LinkedHashMap<>();

        List<String> l1 = List.of("Math Mathewson", "John Johnson", "Jack Jackson", "Garry Garrison");
        expected.put(Skills.MAVEN, l1);

        List<String> l2 = List.of("Tom Thompson", "Math Mathewson", "Sharchan Kumar", "Rajesh Koothrappli",
                "Raja Kachamali", "John Johnson", "Jack Jackson", "Garry Garrison");
        expected.put(Skills.POSTGRESQL, l2);

        List<String> l3 = List.of("Tom Thompson", "Sharchan Kumar", "Rajesh Koothrappli", "Raja Kachamali");
        expected.put(Skills.DOCKER, l3);

        List<String> l4 = List.of("John Johnson", "Jack Jackson");
        expected.put(Skills.JAVA_8, l4);

        List<String> l5 = List.of("Tom Thompson", "Math Mathewson","Math Mathewson", "Sharchan Kumar",
                "Rajesh Koothrappli", "Raja Kachamali", "Jack Jackson", "Garry Garrison");
        expected.put(Skills.JAVA_11, l5);

        List<String> l6 = List.of("Math Mathewson");
        expected.put(Skills.JAVA_SCRIPT, l6);

        List<String> l7 = List.of("Math Mathewson");
        expected.put(Skills.NODE_JS, l7);

        List<String> l8 = List.of("Math Mathewson", "Math Mathewson", "Sharchan Kumar",
                "Rajesh Koothrappli", "Raja Kachamali");
        expected.put(Skills.LINUX, l8);

        List<String> l9 = List.of("Math Mathewson", "Garry Garrison");
        expected.put(Skills.MSSQL_SERVER, l9);

        List<String> l10 = List.of("Tom Thompson", "Math Mathewson");
        expected.put(Skills.GRADLE, l10);

        List<String> l11 = List.of("Math Mathewson");
        expected.put(Skills.REACT, l11);

        List<String> l12 = List.of("Math Mathewson");
        expected.put(Skills.ARANGODB, l12);

        Map<Skills, List<String>> actual = StreamTasks.getDevelopersSortedByLastNameGroupingByGrade(projects);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void separateIntStreamByMod() {

        IntStream intStream = IntStream.iterate(0, i -> i + 3).limit(14);
        System.out.println(StreamTasks.separateIntStreamByMod(intStream, 3));
    }
}