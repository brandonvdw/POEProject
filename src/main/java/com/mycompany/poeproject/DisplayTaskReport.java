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
    // Method to add a task
    public static void addTasks(String taskName, String devName, double taskDuration, String taskStat) {
        if (taskCount < MAX_TASKS) {
            TaskClass task = new TaskClass();
            task.setTaskName(taskName);
            task.setDevName(devName);
            task.setTaskDuration(taskDuration);
            task.setTaskStat(taskStat);
            task.setNumTasks(taskCount + 1); // Assuming task count starts at 1 for ID generation

            // Generate task ID
            String taskID = task.createTaskID();

            // Store task details
            taskNames[taskCount] = taskName;
            taskIDs[taskCount] = taskID;
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
        double largestDuration = 0;
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

        for (int i = 0; i < taskCount; i++) {
            if (taskNames[i].equals(taskName)) {
                return "Task Name: " + taskNames[i]
                        + "\nDeveloper: " + devNames[i]
                        + "\nTask Duration: " + taskDurations[i]
                        + "\nTask Status: " + taskStats[i];
            }
        }
        return "Task not found.";
    }

    public static String displayTasksAssigned(String devName) {
        StringBuilder reportBuilder = new StringBuilder("Tasks assigned to " + devName + ":\n");
        devName = devName.trim().toLowerCase();

        for (int i = 0; i < taskCount; i++) {
            if (devNames[i].trim().equalsIgnoreCase(devName)) {
                reportBuilder.append("Task: ").append(taskNames[i])
                        .append("\nTask Status: ").append(taskStats[i])
                        .append("\nTask Duration: ").append(taskDurations[i]).append("\n\n");
            }
        }

        return reportBuilder.length() > 0 ? reportBuilder.toString() : "No tasks found for the developer.";
    }

    public static String deleteTasks(String taskName) {

        for (int i = 0; i < taskCount; i++) {
            if (taskNames[i] != null && taskNames[i].equalsIgnoreCase(taskName)) {
                taskNames[i] = null;
                taskIDs[i] = null;
                devNames[i] = null;
                taskDurations[i] = 0;
                taskStats[i] = null;
                taskCount--;

                return "Task '" + taskName + "' deleted successfully.";
            }
        }
        return "Task not found.";
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
