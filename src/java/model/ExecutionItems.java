/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author thais
 */
public class ExecutionItems {
    private int executionItemID, arrayItem, executionID;

    public ExecutionItems() {
    }

    public ExecutionItems(int executionItemID, int arrayItem, int executionID) {
        this.executionItemID = executionItemID;
        this.arrayItem = arrayItem;
        this.executionID = executionID;
    }

    public int getExecutionItemID() {
        return executionItemID;
    }

    public void setExecutionItemID(int executionItemID) {
        this.executionItemID = executionItemID;
    }

    public int getArrayItem() {
        return arrayItem;
    }

    public void setArrayItem(int arrayItem) {
        this.arrayItem = arrayItem;
    }

    public int getExecutionID() {
        return executionID;
    }

    public void setExecutionID(int executionID) {
        this.executionID = executionID;
    }

    @Override
    public String toString() {
        return "ExecutionItems{" + "executionItemID=" + executionItemID + ", arrayItem=" + arrayItem + ", executionID=" + executionID + '}';
    }
    
    
}
