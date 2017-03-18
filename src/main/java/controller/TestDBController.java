/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author lenovo
 */
public class TestDBController {
    DatabaseConnector dc;
    
    public TestDBController(){
        dc = new DatabaseConnector();
        
    }
    
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TestDBController tc = new TestDBController();
                
         }
        });

          //testing only
         //MainController mc = new MainController();  
                
    }
}
