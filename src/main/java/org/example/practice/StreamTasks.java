package org.example.practice;

import org.example.practice.domain.Developer;
import org.example.practice.domain.Grades;
import org.example.practice.domain.Project;
import org.example.practice.domain.Skills;
import org.example.practice.domain.Team;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;
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
        return projects.stream()
                .min(Comparator.comparingInt(p -> Math.toIntExact(p.getTeams().stream()
                        .filter(Objects::nonNull)
                        .map(Team::getDevelopers)
                        .count()))
                ).map(Project::getProjectName).orElse(null);
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
                .max(Comparator.comparing((Project p) -> p.getTeams().stream()
                                .map(Team::getDevelopers)
                                .flatMap(Collection::stream)
                                .distinct()
                                .mapToDouble(developer -> developer.getSalary().floatValue() * p.getDurationInMonth())
                                .sum())
                        .thenComparing(Project::getId)
                ).map(Project::getProjectName).orElse(null);
    }

    /**
     * №4
     * Найти проект, над которым работает максимум TEAM_LEAD разработчиков
     *
     * @param projects - список проектов
     * @return - название проекта, удовлетворяющего условиям
     */
    public static String findProjectWithMaxTeamLeadDevelopersCount(List<Project> projects) {
        return projects.stream()
                .max(Comparator.comparing(p -> p.getTeams().stream()
                        .filter(Objects::nonNull)
                        .flatMap(team -> team.getDevelopers().stream())
                        .filter(developer -> developer.getGrade().equals(Grades.TEAM_LEAD))
                        .count())
                )
                .map(Project::getProjectName)
                .orElse(null);
    }

    /**
     * №5
     * Найти проект, над которым работают самые старые разработчики (по суммарному возрасту участников команды)
     *
     * @param projects - список проектов
     * @return - название проекта, удовлетворяющего условиям
     */
    public static String findProjectWithTheOldestDevelopersSum(List<Project> projects) {
        return projects.stream()
                .max(Comparator.comparing(p -> p.getTeams().stream()
                        .filter(Objects::nonNull)
                        .map(Team::getDevelopers)
                        .flatMap(Collection::stream)
                        .distinct()
                        .filter(Objects::nonNull)
                        .mapToInt(Developer::getAge)
                        .sum())
                ).map(Project::getProjectName).orElse(null);
    }

    /**
     * №6
     * Найти все проекты, длительность которых строго больше 2 месяцев
     *
     * @param projects - список проектов
     * @return - список с названиями проектов, удовлетворяющих условиям
     */
    public static List<String> findProjectsWithDurationMoreTwoMonths(List<Project> projects) {
        return projects.stream()
                .filter(Objects::nonNull)
                .filter(project -> project.getDurationInMonth() > 2)
                .map(Project::getProjectName)
                .collect(Collectors.toList());
    }

    /**
     * №7
     * Посчитать суммарную зарплату всех тимлидов на проектах, длительность которых строго больше 2 месяцев
     *
     * @param projects - список проектов
     * @return - суммарную зарплату
     */
    public static BigDecimal getSumTeamLeadSalaryWorkingOnProjectsLongerThanTwoMonths(List<Project> projects) {
        return projects.stream()
                .filter(Objects::nonNull)
                .filter(project -> project.getDurationInMonth() > 2)
                .flatMap(p -> p.getTeams().stream())
                .distinct()
                .filter(Objects::nonNull)
                .flatMap((Team team) -> team.getDevelopers().stream())
                .distinct()
                .filter(Objects::nonNull)
                .filter(d -> d.getGrade().equals(Grades.TEAM_LEAD))
                .map(Developer::getSalary)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
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
        return projects.stream()
                .filter(Objects::nonNull)
                .flatMap(p -> p.getTeams().stream())
                .filter(Objects::nonNull)
                .flatMap((Team team) -> team.getDevelopers().stream())
                .distinct()
                .filter(developer -> developer.getSkills().contains(Skills.JAVA_8)
                        || developer.getSkills().contains(Skills.JAVA_11))
                .sorted(Comparator.comparing(Developer::getSalary)
                        .thenComparing(Developer::getFirstName))
                .map(developer -> developer.getFirstName() +
                        " " +
                        developer.getLastName() +
                        ": " +
                        developer.getSalary())
                .collect(Collectors.toList());
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

        return projects.stream()
                .collect(Collectors.toMap(Project::getProjectName, (project -> project.getTeams().stream()
                        .sorted(Comparator.comparing(Team::getTeamName))
                        .map(Team::getTeamName).collect(Collectors.toList()))));
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
        return projects.stream()
                .flatMap(project -> project.getTeams().stream())
                .distinct()
                .collect(Collectors.toMap(Team::getTeamName, (team -> team.getDevelopers().stream()
                                .sorted(Comparator.comparing(Developer::getFullName))
                                .map(Developer::getFullName).collect(Collectors.toList()))));
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
        return projects.stream()
                .collect(Collectors.toMap(Project::getProjectName, (project -> project.getTeams().stream()
                        .filter(Objects::nonNull)
                        .flatMap(team -> team.getDevelopers().stream())
                        .distinct()
                        .sorted(Comparator.comparing(Developer::getFullName))
                        .map(Developer::getFullName)
                        .collect(Collectors.toList()))));
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
        return projects.stream().collect(Collectors.toMap((project -> project.getProjectName() +
                " (" +
                project.getTeams().stream()
                        .flatMap(team -> team.getDevelopers().stream())
                        .distinct()
                        .map(Developer::getSalary)
                        .reduce(BigDecimal.ZERO, BigDecimal::add) +
                ")"
        ), project -> (project.getTeams().stream()
                .distinct()
                .sorted(Comparator.comparing(Team::getTeamName))
                .map(Team::getTeamName)
                .collect(Collectors.toList()))));
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
        return projects.stream()
                .flatMap(project -> project.getTeams().stream())
                .distinct()
                .collect(Collectors.toMap(Team::getTeamName, (p -> p.getDevelopers().stream()
                        .distinct()
                        .sorted(Comparator.comparing(Developer::getAge))
                        .map(developer -> {
                            StringBuilder sb = new StringBuilder();
                            sb.append(developer.getFullName())
                                    .append(" (")
                                    .append(developer.getAge())
                                    .append(")");
                            return sb.toString();
                        })
                        .collect(Collectors.toList())
                ), (existing, replacement) -> existing));
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
        Comparator<String> comparator = (project1, project2) -> {
            int duration1 = Integer.parseInt(project1.substring
                    (project1.lastIndexOf("(") + 1, project1.lastIndexOf(")")).trim());
            int duration2 = Integer.parseInt(project2.substring
                    (project2.lastIndexOf("(") + 1, project2.lastIndexOf(")")).trim());
            return duration2 - duration1;
        };

        Map<String, List<String>> map = new TreeMap<>(comparator);
        map.putAll(projects.stream()
                .collect(Collectors.toMap((StreamTasks::collectProjectsGroupingByProjectsSortedByDuration),
                        (StreamTasks::collectDevelopersSortedByLastName))));
        return map;
    }

    private static String collectProjectsGroupingByProjectsSortedByDuration(Project project) {
        return project.getProjectName() +
                " (" +
                project.getDurationInMonth() +
                ")";
    }

    private static List<String> collectDevelopersSortedByLastName(Project project) {
        return project.getTeams().stream()
                .flatMap(team -> team.getDevelopers().stream())
                .distinct()
                .sorted(Comparator.comparing(Developer::getLastName))
                .map(Developer::getFullName)
                .collect(Collectors.toList());
    }

    /**
     * №15
     * Собрать мапу разработчиков, отсортированных по возрасту в обратном порядке
     * сгруппированных по грейду
     *
     * @param projects - список проектов
     * @return - мапу с грейдами и полными именами (имя + фамилия) разработчиков в указанном виде
     */
    public static Map<Grades, List<String>> getDevelopersSortedByAgeGroupingByGrade(List<Project> projects) {
        return projects.stream()
                .flatMap(project -> project.getTeams().stream())
                .distinct()
                .flatMap(team -> team.getDevelopers().stream())
                .distinct()
                .sorted(Comparator.comparing(Developer::getAge).reversed().thenComparing(Developer::getGrade))
                .collect(Collectors.groupingBy(Developer::getGrade,
                        Collectors.mapping(Developer::getFullName, Collectors.toList())));
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
    public static Map<Skills, List<String>> getDevelopersSortedByLastNameGroupingByGrade(List<Project> projects) {
        return projects.stream()
                .flatMap(project -> project.getTeams().stream()
                        .distinct()
                        .flatMap(team -> team.getDevelopers().stream()
                                .distinct()
                                .flatMap(developer -> developer.getSkills().stream()) //сбор всех скиллов
                                // со всех проектов
                                .sorted(Comparator.comparing(Skills::name))
                        )
                )
                .distinct() //оставляем только уникальные скиллы
                .collect(Collectors.toMap(skill -> skill, //собираем мапу, где ключ - уникальный скилл
                        skill -> //собираем девелоперов со всех проектов
                                projects.stream()
                                        .flatMap(project -> project.getTeams().stream()
                                                .flatMap(team -> team.getDevelopers().stream())
                                        )
                                        .distinct()
                                        .filter(developer -> developer.getSkills().contains(skill))
                                        .sorted(Comparator.comparing(Developer::getLastName).reversed())
                                        .map(Developer::getFullName)
                                        .collect(Collectors.toList())
                ));
    }

    /**
     * Стрим интов (последовательный или рандомный) разложить на n листов по остатку деления на n
     */
    public static Map<Integer, List<Integer>> separateIntStreamByMod(IntStream intStream, int partition) {
        List<Integer> integerList = intStream.boxed().collect(Collectors.toList());

        return IntStream
                .range(0, integerList.size())
                .boxed()
                .collect(Collectors.groupingBy(i -> i % partition, Collectors.mapping(integerList::get, Collectors.toList())));
    }
}
