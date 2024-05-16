/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeproject;

/**
 *
 * @author brand
 */
public class TaskClass {

    private int numTasks; //Number of tasks the user wants to enter
    private String taskName;
    private String taskDescription;
    private String devName;
    private String devLastName;
    private int taskDuration;

    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public void setDevLastName(String devLastName) {
        this.devLastName = devLastName;
    }

    public void setTaskDuration(int taskDuration) {
        this.taskDuration = taskDuration;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setNumberOfTasks(Integer numTasks) {
        this.numTasks = numTasks;
    }

}
