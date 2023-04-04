package org.example;

import org.example.practice.StreamTasks;
import org.example.practice.domain.Grades;
import org.example.practice.domain.Project;
import org.example.practice.domain.Skills;
import org.example.practice.domain.TaskData;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class StreamTasksTest {

    private static final List<Project> projects = TaskData.getProjectList();

    @Test
    void getDevelopersGroupingByNumberOfSkills() {

        Comparator<BigDecimal> comparator = Comparator.reverseOrder();

        Map<BigDecimal, List<String>> expected = Map.of(BigDecimal.valueOf(7000),
                List.of("Raja Kachamali (TEAM_LEAD)"),

                BigDecimal.valueOf(5000), List.of("Rajesh Koothrappli (TEAM_LEAD)"),

                BigDecimal.valueOf(6000), List.of("Sharchan Kumar (TEAM_LEAD)"));

        Map<BigDecimal, List<String>> actual = StreamTasks.getTopThreeOfMostExpensiveDevelopers(projects);

        assertThat(actual).isEqualTo(expected);

    }

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
        Map<String, List<String>> expected = Map.of("Ranger", List.of("Balance", "Wild middle West"),
                "Warship", List.of("Balance", "Jedi Masters"),
                "Apollo", List.of("Balance", "Shiny Stars", "Wild middle West"),
                "Millennium Falcon", List.of("Jedi Masters", "Shiny Stars"),
                "Stellar", List.of("Noobies-boobies"));

        Map<String, List<String>> actual = StreamTasks.getTeamsGroupingByProject(projects);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getDevelopersGroupingByTeams() {
        Map<String, List<String>> expected = Map.of("Shiny Stars", List.of("Garry Garrison", "Math Mathewson", "Raja Kachamali"),
                "Wild middle West", List.of("Math Mathewson", "Math Mathewson", "Sharchan Kumar", "Tom Thompson"),
                "Noobies-boobies", List.of("Jack Jackson", "John Johnson", "Rajesh Koothrappli"),
                "Jedi Masters", List.of("Math Mathewson", "Raja Kachamali", "Rajesh Koothrappli", "Sharchan Kumar"),
                "Balance", List.of("Garry Garrison", "Jack Jackson", "Raja Kachamali", "Tom Thompson"));

        Map<String, List<String>> actual = StreamTasks.getDevelopersGroupingByTeams(projects);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getDevelopersGroupingByProjects() {
        Map<String, List<String>> expected = Map.of("Apollo", List.of("Garry Garrison", "Jack Jackson",
                        "Math Mathewson", "Math Mathewson", "Math Mathewson",
                        "Raja Kachamali", "Sharchan Kumar", "Tom Thompson"),

                "Stellar", List.of("Jack Jackson", "John Johnson", "Rajesh Koothrappli"),

                "Warship", List.of("Garry Garrison", "Jack Jackson", "Math Mathewson", "Raja Kachamali",
                        "Rajesh Koothrappli", "Sharchan Kumar", "Tom Thompson"),

                "Ranger", List.of("Garry Garrison", "Jack Jackson", "Math Mathewson", "Math Mathewson",
                        "Raja Kachamali", "Sharchan Kumar", "Tom Thompson"),

                "Millennium Falcon", List.of("Garry Garrison", "Math Mathewson", "Raja Kachamali",
                        "Rajesh Koothrappli", "Sharchan Kumar"));

        Map<String, List<String>> actual = StreamTasks.getDevelopersGroupingByProjects(projects);

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void getTeamsGroupingByProjectSortedBySalarySum() {
        Map<String, List<String>> expected = Map.of("Stellar (7000)", List.of("Noobies-boobies"),
                "Apollo (27000)", List.of("Balance", "Shiny Stars", "Wild middle West"),
                "Warship (28000)", List.of("Balance", "Jedi Masters"),
                "Ranger (23000)", List.of("Balance", "Wild middle West"),
                "Millennium Falcon (25000)", List.of("Jedi Masters", "Shiny Stars"));

        Map<String, List<String>> actual = StreamTasks.getTeamsGroupingByProjectSortedBySalarySum(projects);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getDevelopersGroupingByTeamsSortedByAge() {
        Map<String, List<String>> expected = Map.of("Shiny Stars", List.of("Garry Garrison (26)",
                        "Math Mathewson (27)", "Raja Kachamali (30)"),

                "Wild middle West", List.of("Tom Thompson (23)", "Math Mathewson (24)", "Math Mathewson (25)",
                        "Sharchan Kumar (29)"),

                "Noobies-boobies", List.of("John Johnson (21)", "Jack Jackson (22)", "Rajesh Koothrappli (28)"),

                "Jedi Masters", List.of("Math Mathewson (27)", "Rajesh Koothrappli (28)",
                        "Sharchan Kumar (29)", "Raja Kachamali (30)"),

                "Balance", List.of("Jack Jackson (22)", "Tom Thompson (23)", "Garry Garrison (26)",
                        "Raja Kachamali (30)"));


        Map<String, List<String>> actual = StreamTasks.getDevelopersGroupingByTeamsSortedByAge(projects);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getDevelopersSortedByLastNameGroupingByProjectsSortedByDuration() {
        Map<String, List<String>> expected = Map.of("Millennium Falcon (5)", List.of("Garry Garrison",
                        "Raja Kachamali", "Rajesh Koothrappli", "Sharchan Kumar", "Math Mathewson"),

                "Ranger (4)", List.of("Garry Garrison", "Jack Jackson", "Raja Kachamali", "Sharchan Kumar",
                        "Math Mathewson", "Math Mathewson", "Tom Thompson"),

                "Warship (3)", List.of("Garry Garrison", "Jack Jackson", "Raja Kachamali", "Rajesh Koothrappli",
                        "Sharchan Kumar", "Math Mathewson", "Tom Thompson"),

                "Apollo (2)", List.of("Garry Garrison", "Jack Jackson", "Raja Kachamali", "Sharchan Kumar",
                        "Math Mathewson", "Math Mathewson", "Math Mathewson", "Tom Thompson"),

                "Stellar (1)", List.of("Jack Jackson", "John Johnson", "Rajesh Koothrappli"));

        Map<String, List<String>> actual = StreamTasks.getDevelopersSortedByLastNameGroupingByProjectsSortedByDuration(projects);

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void getDevelopersSortedByAgeGroupingByGrade() {
        Map<Grades, List<String>> expected = Map.of(Grades.valueOf("SENIOR"),
                List.of("Math Mathewson", "Garry Garrison"),

                Grades.valueOf("MIDDLE"), List.of("Math Mathewson", "Math Mathewson", "Tom Thompson"),

                Grades.valueOf("JUNIOR"), List.of("Jack Jackson", "John Johnson"),

                Grades.valueOf("TEAM_LEAD"), List.of("Raja Kachamali", "Sharchan Kumar", "Rajesh Koothrappli"));

        Map<Grades, List<String>> actual = StreamTasks.getDevelopersSortedByAgeGroupingByGrade(projects);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getDevelopersSortedByLastNameGroupingByGrade() {

        Map<Skills, List<String>> expected = Map.ofEntries(
                new AbstractMap.SimpleEntry(Skills.MAVEN, List.of("Math Mathewson",
                        "John Johnson", "Jack Jackson", "Garry Garrison")),
                new AbstractMap.SimpleEntry(Skills.POSTGRESQL, List.of("Tom Thompson", "Math Mathewson",
                        "Sharchan Kumar", "Rajesh Koothrappli",
                        "Raja Kachamali", "John Johnson", "Jack Jackson", "Garry Garrison")),

                new AbstractMap.SimpleEntry(Skills.DOCKER, List.of("Tom Thompson", "Sharchan Kumar",
                        "Rajesh Koothrappli", "Raja Kachamali")),

                new AbstractMap.SimpleEntry(Skills.JAVA_8, List.of("John Johnson", "Jack Jackson")),

                new AbstractMap.SimpleEntry(Skills.JAVA_11, List.of("Tom Thompson", "Math Mathewson",
                        "Math Mathewson", "Sharchan Kumar",
                        "Rajesh Koothrappli", "Raja Kachamali", "Jack Jackson", "Garry Garrison")),

                new AbstractMap.SimpleEntry(Skills.JAVA_SCRIPT, List.of("Math Mathewson")),

                new AbstractMap.SimpleEntry(Skills.NODE_JS, List.of("Math Mathewson")),

                new AbstractMap.SimpleEntry(Skills.LINUX, List.of("Math Mathewson", "Math Mathewson", "Sharchan Kumar",
                        "Rajesh Koothrappli", "Raja Kachamali")),

                new AbstractMap.SimpleEntry(Skills.MSSQL_SERVER, List.of("Math Mathewson", "Garry Garrison")),

                new AbstractMap.SimpleEntry(Skills.GRADLE, List.of("Tom Thompson", "Math Mathewson")),

                new AbstractMap.SimpleEntry(Skills.REACT, List.of("Math Mathewson")),

                new AbstractMap.SimpleEntry(Skills.ARANGODB, List.of("Math Mathewson"))
        );

        Map<Skills, List<String>> actual = StreamTasks.getDevelopersSortedByLastNameGroupingByGrade(projects);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void separateIntStreamByMod() {

        IntStream intStream = IntStream.iterate(0, i -> i + 3).limit(14);
        System.out.println(StreamTasks.separateIntStreamByMod(intStream, 3));
    }
}