/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import java.util.ArrayList;

/**
 *
 * @author edangulo
 */
public class History {
    
    private ArrayList<Operation> operations;
    private static History instance;
    
    public static History getInstance() {
        if (instance == null) {
            instance = new History();
        }
        return instance;
    }

    public History() {
        this.operations = new ArrayList<>();
    }
    
    public void addOperation(Operation operation) {
        this.operations.add(operation);
    }

    public ArrayList<Operation> getOperations() {
        return operations;
    }
    
}
