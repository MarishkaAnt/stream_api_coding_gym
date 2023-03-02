package org.example;

import org.example.practice.StreamTasks;
import org.example.practice.domain.Project;
import org.example.practice.domain.TaskData;
import org.example.theory.StreamCreation;
import org.example.theory.Theory;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Theory.terminalOperationExample();

        //Theory.intermediateOperation();

        //StreamCreation.createStreams();

        List<Project> projects = TaskData.getProjectList();
        System.out.println(StreamTasks.findTheMostExpensiveProject(projects));
    }
}
