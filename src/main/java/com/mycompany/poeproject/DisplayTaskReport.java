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
    private static String[] taskDescriptions = new String[MAX_TASKS];
    private static String[] devNames = new String[MAX_TASKS];
    private static double[] taskDurations = new double[MAX_TASKS];
    private static String[] taskStats = new String[MAX_TASKS];
    private static int taskCount = 0;
    private static int taskAmount = 0;

    public static int getMAX_TASKS() {
        return MAX_TASKS;
    }

    // Method to add a task
    public static void addTasks(String taskName, String taskDescription, String devName, double taskDuration, String taskStat) {
        if (taskCount < MAX_TASKS) {
            taskNames[taskCount] = taskName;
            taskDescriptions[taskCount] = taskDescription;
            devNames[taskCount] = devName;
            taskDurations[taskCount] = taskDuration;
            taskStats[taskCount] = taskStat;
            taskCount++;
        } else {
            System.out.println("Maximum number of tasks reached.");
        }
    }

    public static void setTaskAmount(int taskAmount) {
        DisplayTaskReport.taskAmount = taskAmount;
    }

}
