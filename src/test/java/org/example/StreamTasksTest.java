package org.example;

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