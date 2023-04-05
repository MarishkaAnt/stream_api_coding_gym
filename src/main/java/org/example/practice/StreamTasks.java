package org.example.practice;

import org.example.practice.domain.Grades;
import org.example.practice.domain.Project;
import org.example.practice.domain.Skills;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class StreamTasks {

    // Easy level tasks:

    /**
     * №1
     * Найти проект, над которым работает максимальное количество команд
     *
     * @param projects - список проектов
     * @return - название проекта, удовлетворяющего условиям
     */
    public static String findProjectWithMaxTeamCount(List<Project> projects) {
        return projects.stream()
                .max(Comparator.comparingInt(p -> p.getTeams().size()))
                .map(Project::getProjectName)
                .orElse(null);
    }

    /**
     * №2
     * Найти проект, над которым работает минимум разработчиков
     *
     * @param projects - список проектов
     * @return - название проекта, удовлетворяющего условиям
     */
    public static String findProjectWithMinDeveloperCount(List<Project> projects) {
        return null;
    }

    /**
     * №3
     * Найти самый дорогой проект (по сумме зартплат разработчиков * длительность проекта)
     *
     * @param projects - список проектов
     * @return - название проекта, удовлетворяющего условиям
     */
    public static String findTheMostExpensiveProject(List<Project> projects) {
        return projects.stream()
                .max(Comparator.comparing(project -> project.getTeams().stream()
                        .flatMap(team -> team.getDevelopers().stream())
                        .distinct()
                        .map(developer -> developer.getSalary()
                                .multiply(BigDecimal.valueOf(project.getDurationInMonth())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                ))
                .map(Project::getProjectName).orElse(null);
    }

    /**
     * №4
     * Найти проект, над которым работает максимум TEAM_LEAD разработчиков
     *
     * @param projects - список проектов
     * @return - название проекта, удовлетворяющего условиям
     */
    public static String findProjectWithMaxTeamLeadDevelopersCount(List<Project> projects) {
        return null;
    }

    /**
     * №5
     * Найти проект, над которым работают самые старые разработчики (по суммарному возрасту участников команды)
     *
     * @param projects - список проектов
     * @return - название проекта, удовлетворяющего условиям
     */
    public static String findProjectWithTheOldestDevelopersSum(List<Project> projects) {
        return null;
    }

    /**
     * №6
     * Найти все проекты, длительность которых строго больше 2 месяцев
     *
     * @param projects - список проектов
     * @return - список с названиями проектов, удовлетворяющих условиям
     */
    public static List<String> findProjectsWithDurationMoreTwoMonths(List<Project> projects) {
        return null;
    }

    /**
     * №7
     * Посчитать суммарную зарплату всех тимлидов на проектах, длительность которых строго больше 2 месяцев
     *
     * @param projects - список проектов
     * @return - суммарную зарплату
     */
    public static BigDecimal getSumTeamLeadSalaryWorkingOnProjectsLongerThanTwoMonths(List<Project> projects) {
        return null;
    }

    /**
     * №8
     * Найти всех бэкенд-джавистов, отсортировать их по зарплате и вывести списком вида:
     * [имя1 Фамилия1: зарплата1, имя2 Фамилия2: зарплата2 ...]
     *
     * @param projects - список проектов
     * @return - список разработчиков, удовлетворяющих условиям фильтра, в указанном виде
     */
    public static List<String> getAllJavaDevelopersSortedBySalary(List<Project> projects) {
        return null;
    }

    // Medium level tasks:

    /**
     * №9
     * Собрать мапу команд, сгруппированных по проектам в виде:
     * {название проекта1=[название команды1, название команды2 ...], ...}
     *
     * @param projects - список проектов
     * @return - мапу с названиями проектов и их команд в указанном виде
     */
    public static Map<String, List<String>> getTeamsGroupingByProject(List<Project> projects) {
        return null;
    }

    /**
     * №10
     * Собрать мапу разработчиков, сгруппированных по командам в виде:
     * {название команды1=[полное имя разраба1, полное имя разраба2 ...], ...}
     *
     * @param projects - список проектов
     * @return - мапу с названиями команд и полными именами (имя + фамилия) разработчиков в указанном виде
     */
    public static Map<String, List<String>> getDevelopersGroupingByTeams(List<Project> projects) {
        return null;
    }

    /**
     * №11
     * Собрать мапу разработчиков, сгруппированных по проектам в виде:
     * {название проекта1=[полное имя разраба1, полное имя разраба2 ...], ...}
     *
     * @param projects - список проектов
     * @return - мапу с названиями проектов и полными именами (имя + фамилия) разработчиков в указанном виде
     */
    public static Map<String, List<String>> getDevelopersGroupingByProjects(List<Project> projects) {
        return null;
    }

    /**
     * №12
     * Собрать мапу команд, отсортированных по суммарной зарплате разрабов,
     * сгруппированных по проектам в виде:
     * {название проекта1 (суммарная зп)=[название команды1, название команды2 ...], ...}
     *
     * @param projects - список проектов
     * @return - мапу с названиями проектов и их команд в указанном виде
     */
    public static Map<String, List<String>> getTeamsGroupingByProjectSortedBySalarySum(List<Project> projects) {
        return null;
    }

    /**
     * №13
     * Собрать мапу разработчиков, отсортированных по возрасту,
     * сгруппированных по командам в виде:
     * {название команды1=[полное имя разраба1 (возраст), полное имя разраба2 (возраст)...], ...}
     *
     * @param projects - список проектов
     * @return - мапу с названиями команд и полными именами (имя + фамилия) разработчиков в указанном виде
     */
    public static Map<String, List<String>> getDevelopersGroupingByTeamsSortedByAge(List<Project> projects) {
        return null;
    }

    /**
     * №14
     * Собрать мапу разработчиков, отсортированных по фамилии
     * сгруппированных по проектам, отсортированным по длительности в обратном порядке, в виде:
     * {название проекта1 (длительность)=[полное имя разраба1, полное имя разраба2 ...], ...}
     *
     * @param projects - список проектов
     * @return - мапу с названиями проектов и полными именами (имя + фамилия) разработчиков в указанном виде
     */
    public static Map<String, List<String>> getDevelopersSortedByLastNameGroupingByProjectsSortedByDuration(List<Project> projects) {
        return null;
    }

    /**
     * №15
     * Собрать мапу разработчиков, отсортированных по возрасту в обратном порядке,
     * сгруппированных по грейду, в виде:
     * {Грейд1 =[полное имя разраба1, полное имя разраба2 ...], ...}
     *
     * @param projects - список проектов
     * @return - мапу с грейдами и полными именами (имя + фамилия) разработчиков в указанном виде
     */
    public static Map<Grades, List<String>> getDeveloperFullNamesSortedByAgeGroupingByGrade(List<Project> projects) {
        return null;
    }

    /**
     * №16
     * Собрать мапу разработчиков, отсортированных по фамилии в обратном порядке
     * сгруппированных по скиллам в виде:
     * {Скилл1 =[полное имя разраба1, полное имя разраба2 ...], ...}
     *
     * @param projects - список проектов
     * @return - мапу с названиями скиллов и полными именами (имя + фамилия) разработчиков в указанном виде
     */
    public static Map<Skills, List<String>> getDeveloperFullNamesSortedByLastNameGroupingBySkills(List<Project> projects) {
        return null;
    }

    /**
     * Стрим интов (последовательный или рандомный) разложить на n листов по остатку деления на n
     */
    public static Map<Integer, List<Integer>> separateIntStreamByMod(IntStream intStream) {
        return null;
    }


}
