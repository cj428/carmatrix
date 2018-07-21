/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carmatrix.controller;

import carmatrix.frame.MatrizDialog;
import carmatrix.logic.MovimientoFacade;
import carmatrix.pojo.Matriz;
import javax.swing.JOptionPane;

/**
 *
 * @author GL62M 7RC
 */
public class CarMatrixControl {
    
    MovimientoFacade facade = new MovimientoFacade();
    
    public CarMatrixControl() {
    }
    
    public void cargarDatosMatriz(String filas, String columnas, MatrizDialog dlg) {

        /*if(filas == null || columnas == null){
            JOptionPane.showMessageDialog(null, "Los datos estan incompletos", "ERROR!", JOptionPane.ERROR);
        }*/
        try {
            
            Integer f = Integer.parseInt(filas);
            Integer c = Integer.parseInt(columnas);
            facade.setMatriz(new Matriz(f, c));
            
            JOptionPane.showMessageDialog(null, "Datos de matriz ingresados", "MATRIZ CARGADA !", JOptionPane.INFORMATION_MESSAGE);
            dlg.dispose();
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Los datos ingresados no son numericos", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
}
