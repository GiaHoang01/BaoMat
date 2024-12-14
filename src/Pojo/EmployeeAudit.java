/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojo;

import java.sql.Timestamp;

/**
 *
 * @author HUU KHANH
 */
public class EmployeeAudit {
    private String actionType;
    private Timestamp actionTime;
    private String userName;

    public EmployeeAudit(String actionType, Timestamp actionTime, String userName) {
        this.actionType = actionType;
        this.actionTime = actionTime;
        this.userName = userName;
    }

    public EmployeeAudit() {
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public Timestamp getActionTime() {
        return actionTime;
    }

    public void setActionTime(Timestamp actionTime) {
        this.actionTime = actionTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "EmployeeAudit{" +
                "actionType='" + actionType + '\'' +
                ", actionTime=" + actionTime +
                ", userName='" + userName + '\'' +
                '}';
    }
}
