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

    // Creating a instance of the TaskClass class
    TaskClass Tasks = new TaskClass();

    private String[] developers;
    private String[] taskNames;
    private String[] taskIDs;
    private String[] taskDurations;
    private String[] taskStatus;

    int numTasks = Tasks.getNumTasks();

    int currentPosition = 0;

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void populateArrays() {

        developers[currentPosition] = Tasks.getDevName();

    }
}
