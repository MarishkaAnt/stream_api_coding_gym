package org.example;

import org.assertj.core.api.Assertions;
import org.example.practice.StreamTasks;
import org.example.practice.domain.Project;
import org.example.practice.domain.TaskData;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        String expected = "Millennium Falcon";
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
        String expected = "Millennium Falcon";
        String actual = StreamTasks.findProjectWithMaxTeamLeadDevelopersCount(projects);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void findProjectWithTheOldestDevelopersSum() {
    }

    @Test
    void findProjectsWithDurationMoreTwoMonths() {
    }

    @Test
    void getSumTeamLeadSalaryWorkingOnProjectsLongerThanTwoMonths() {
    }

    @Test
    void getAllJavaDevelopersSortedBySalary() {
        //given
        List<String> expected = List.of(
                "Jack Jackson: 1000", "John Johnson: 1000",
                "Math Mathewson: 2000", "Tom Thompson: 2000",
                "Garry Garrison: 3000", "Math Mathewson: 4000",
                "Rajesh Koothrappli: 5000", "Sharchan Kumar: 6000",
                "Raja Kachamali: 7000"
        );
        //when
        List<String> actual = StreamTasks.getAllJavaDevelopersSortedBySalary(projects);
        //then
        Assertions.assertThat(actual)
                .isEqualTo(expected)
                .usingRecursiveComparison();
    }

    @Test
    void getTeamsGroupingByProject() {
    }

    @Test
    void getDevelopersGroupingByTeams() {
    }

    @Test
    void getDevelopersGroupingByProjects() {
    }

    @Test
    void getTeamsGroupingByProjectSortedBySalarySum() {
    }

    @Test
    void getDevelopersGroupingByTeamsSortedByAge() {
    }

    @Test
    void getDevelopersSortedByLastNameGroupingByProjectsSortedByDuration() {
    }

    @Test
    void getDevelopersSortedByAgeGroupingByGrade() {
    }

    @Test
    void getDevelopersSortedByLastNameGroupingByGrade() {
    }

    @Test
    void separateIntStreamByMod() {
    }
}