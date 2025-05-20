/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author thais
 */
public class Executions {
    private int executionID, result;
    List<ExecutionItems>  executionItems;
    
    public Executions() {
    }

    public Executions(int executionID, int result, List<ExecutionItems> executionItems) {
        this.executionID = executionID;
        this.result = result;
        this.executionItems = executionItems;
    }

    public int getExecutionID() {
        return executionID;
    }

    public void setExecutionID(int executionID) {
        this.executionID = executionID;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<ExecutionItems> getExecutionItems() {
        return executionItems;
    }

    public void setExecutionItems(List<ExecutionItems> executionItems) {
        this.executionItems = executionItems;
    }

    @Override
    public String toString() {
        return "Executions{" + "executionID=" + executionID + ", result=" + result + ", executionItems=" + executionItems + '}';
    }  
}
