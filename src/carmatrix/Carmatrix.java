/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carmatrix;


import carmatrix.logic.MovimientoFacade;
import carmatrix.pojo.Matriz;
import carmatrix.pojo.Movimiento;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author GL62M 7RC
 */
public class Carmatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
       
        BufferedReader plano = new BufferedReader (new InputStreamReader(System.in));
        
        try {
            // Leer y validar que los datos ingresados son de tipo Entero
            System.out.println("Por favor ingrese el maximo valor en X");
            String valorX = plano.readLine();
            int ValorIntX = Integer.parseInt(valorX)+1;
            System.out.println("Por favor ingrese el maximo valor en Y");
            String valorY = plano.readLine();
            int ValorIntY = Integer.parseInt(valorY)+1;
            
            //Armar el plano X-Y por donde se va a mover el vehiculo
            Matriz planoXY = new Matriz (ValorIntX,ValorIntY);
            System.out.println("Usted ingreso valor en Filas: "+valorX+" y valor en Columnas: "+valorY);
            MovimientoFacade facade = new MovimientoFacade();
            facade.setMatriz(planoXY);
            //Capturar Movimientos
            System.out.println("Por favor ingrese movimientos que se deben realizar separados por ; ");
            String valorMov = plano.readLine();
            StringTokenizer mov = new StringTokenizer (valorMov,";");
            //Validar y mostrar movimientos que se ingresaron
            System.out.println ("movimientos ingresados "+mov.countTokens()+ " :");
            String[] movAuto = new String[2];
            while (mov.hasMoreElements())          
            {
                String movimiento = mov.nextToken();
                System.out.println(movimiento);
                movAuto = facade.AsignarDatos(movimiento);                
                Movimiento movAutoMov = new Movimiento(movAuto[1],Integer.parseInt(movAuto[0]));
                facade.addMovimiento (movAutoMov);
            }
            facade.excuteMovimientos();
            
        }
        catch (Exception e){
            System.out.println("Ingreso un valor invalido Entero");
        }
       

    }

}
