/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeproject;

/**
 *
 * @author brand
 */
public class DisplayTaskReport {

    // Assuming a maximum number of tasks
    private static final int MAX_TASKS = 100;
    private static String[] taskNames = new String[MAX_TASKS];
    private static String[] taskIDs = new String[MAX_TASKS];
    private static String[] devNames = new String[MAX_TASKS];
    private static double[] taskDurations = new double[MAX_TASKS];
    private static String[] taskStats = new String[MAX_TASKS];
    private static int taskCount = 0;
    private static int taskAmount = 0;
    private static String returnReport;

    // Method to add a task
    public static void addTasks(String taskName, String devName, double taskDuration, String taskStat) {
        if (taskCount < MAX_TASKS) {
            TaskClass Tasks = new TaskClass();

            taskNames[taskCount] = taskName;
            taskIDs[taskCount] = Tasks.getTaskID();
            devNames[taskCount] = devName;
            taskDurations[taskCount] = taskDuration;
            taskStats[taskCount] = taskStat;
            taskCount++;
        } else {
            System.out.println("Maximum number of tasks reached");
        }
    }

    public static void setTaskAmount(int taskAmount) {
        DisplayTaskReport.taskAmount = taskAmount;
    }

    public static String printDoneTasksReport() {
        StringBuilder reportBuilder = new StringBuilder();

        for (int i = 0; i < taskCount; i++) {
            if ((taskStats[i].equalsIgnoreCase("2"))) {
                if (reportBuilder.length() > 0) {
                    reportBuilder.append("\n");
                }
                reportBuilder.append("Developer: ").append(devNames[i])
                        .append("\nTask Name: ").append(taskNames[i])
                        .append("\nTask Duration: ").append(taskDurations[i]);
            }
        }

        return reportBuilder.toString();
    }

    public static String displayLongestDuration() {
        double largestDuration = taskDurations[0];
        String LongestDuration = "";

        for (int i = 0; i < taskDurations.length; i++) {
            if (taskDurations[i] > largestDuration) {
                largestDuration = taskDurations[i];

                LongestDuration = "Developer:" + devNames[i] + "\n Hours: " + largestDuration;
            }
        }
        return LongestDuration;

    }

    public static String displayTaskName(String taskName) {

        String finalDisplay = "";

        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i] == taskName) {

                finalDisplay = "Task Name: " + taskNames[i] + "\n Developer: " + devNames[i] + "\n Task Status: " + taskStats[i];
            }

        }
        return finalDisplay;

    }

    public static String displayTasksAssigned(String devName) {

        StringBuilder reportBuilder = new StringBuilder();

        for (int i = 0; i < devNames.length; i++) {
            if ((devNames[i].equalsIgnoreCase(devName))) {
                if (reportBuilder.length() > 0) {
                    reportBuilder.append("\n");
                }
                reportBuilder
                        .append("\nTask Name: ").append(taskNames[i])
                        .append("\nTask Status: ").append(taskStats[i]);
            }
        }

        return reportBuilder.toString();
    }

    public static String deleteTasks(String taskName) {

        for (int i = 0; i < taskNames.length; i++) {

            if ((taskNames[i].equalsIgnoreCase(taskName))) {
                taskNames[i] = "";
                taskIDs[i] = "";
                devNames[i] = "";
                taskDurations[i] = 0;
                taskStats[i] = "";

            }

        }
        return "Task has been deleted";
    }

    public static String displayAllTasks() {
        StringBuilder reportBuilder = new StringBuilder();

        for (int i = 0; i < taskCount; i++) {
            if (taskNames[i] != null && !taskNames[i].isEmpty()) {
                if (reportBuilder.length() > 0) {
                    reportBuilder.append("\n\n");
                }
                reportBuilder.append("Task ID: ").append(taskIDs[i])
                        .append("\nTask Name: ").append(taskNames[i])
                        .append("\nDeveloper: ").append(devNames[i])
                        .append("\nTask Duration: ").append(taskDurations[i])
                        .append("\nTask Status: ").append(taskStats[i]);
            }
        }

        return reportBuilder.toString();
    }
}
