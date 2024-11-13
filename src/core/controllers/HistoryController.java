/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.History;
import core.models.Operation;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;

/**
 *
 * @author Allison Ruiz
 */
public class HistoryController {
    
    public static Response update(){
        try {
            History history = History.getInstance();
            ArrayList<Operation> operations = history.getOperations();
            
            if (operations == null || operations.isEmpty()) {
                return new Response("The list is empty.", Status.NO_CONTENT);
            }
            
            Collections.reverse(operations);
            DefaultListModel model = new DefaultListModel();
            
            for (Operation operation : operations) {
                model.addElement(operation);
            }
            
            if(model.isEmpty()){
                return new Response("The list is empty1.", Status.NO_CONTENT);
            }
            
            return new Response("List updated succesfully.", Status.OK, model);
            
        } catch (Exception e) {
            return new Response("Error.",Status.NOT_FOUND);
        }
    }
}
