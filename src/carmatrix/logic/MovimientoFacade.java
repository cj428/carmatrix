/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carmatrix.logic;

import carmatrix.pojo.Coordenada;
import carmatrix.pojo.Matriz;
import carmatrix.pojo.Movimiento;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author GL62M 7RC
 */
public class MovimientoFacade {

    Matriz matriz = new Matriz();
    private List<Movimiento> lstMv = new ArrayList<>();
    private List<Coordenada> lstCordValidas = new ArrayList<>();
    private Coordenada coordenadaFinal = new Coordenada();

    public void setMatriz(Matriz matriz) {
        this.matriz = matriz;
    }

    public Coordenada getCoordenadaFinal() {
        return coordenadaFinal;
    }

    public void calculaPosicionesValidas() {
        for (int m = 0; m < matriz.getnColumnas(); m++) {//Columnas
            for (int n = 0; n < matriz.getnFilas(); n++) {//Filas
                Coordenada c = new Coordenada(n, m);
                lstCordValidas.add(c);
            }

        }

        /*System.out.println("Coordendas validas: ");
        for (Coordenada coord : lstCordValidas) {
            System.out.println(coord);
        }*/
    }
    public String[] AsignarDatos (String movimiento)            
    {
        
        StringTokenizer mov = new StringTokenizer (movimiento,",");
        String [] movAuto = new String[2];     
        String desplazamiento= mov.nextToken();
        String direccion = mov.nextToken();
                
        movAuto[0]= desplazamiento;
        movAuto[1]= direccion;    
              
        return movAuto;       
              
    }
    

    public void addMovimiento(Movimiento m) {
        lstMv.add(m);
    }

    public void addMovimientos(Movimiento... movs) {
        for (Movimiento mov : movs) {
            lstMv.add(mov);
        }
    }

    public List<Movimiento> listAllMovimientos() {
        return lstMv;
    }

    public void excuteMovimientos() {

        Coordenada cActual = null;

        //Calculando posicion actual del movil si hay movimeintos en la lista
        if (!lstMv.isEmpty()) {

            StringBuilder error = new StringBuilder();

            //Calculando posiciones validas
            calculaPosicionesValidas();

            Movimiento movActual = lstMv.get(0);

            calculaCoordenadaByMovimiento(movActual, error);

        }

    }

    private void calculaCoordenadaByMovimiento(Movimiento mov, StringBuilder error) {

        //System.out.println("lstMv: " + lstMv.size());
        inicializaCoordenadasMovimiento(mov);
        Coordenada nCoordenada = new Coordenada();

        System.out.println("- " + mov);

        if (mov.getDireccion().equals("N")) {//Arriba

            Integer destinoFila = mov.getDesplazamiento();
            Integer nDestinoFila = mov.getCoordenadaActual().getnFila() + destinoFila;

            nCoordenada.setnFila(nDestinoFila);
            nCoordenada.setnColumna(mov.getCoordenadaActual().getnColumna());

            if (!isCoordenadaValida(nCoordenada)) {
                System.out.println("Se ha detenido el avance por salir de los límites");
                error.append("Se ha detenido el avance por salir de los límites");
                return;
            } else {

                //Retira el movimiento de la lista de movimientos
                lstMv.remove(mov);

                //Si hay mas movimientos se le pasa la nueva coordenada al siguiente movimiento
                if (!lstMv.isEmpty()) {
                    Movimiento mSig = lstMv.get(0);
                    mSig.setCoordenadaActual(nCoordenada);
                    //Se repite operación
                    calculaCoordenadaByMovimiento(mSig, error);
                } else {
                    coordenadaFinal = nCoordenada;
                    System.out.println("Posición Final: " + coordenadaFinal);
                }
            }
        }

        if (mov.getDireccion().equals("S")) {//Abajo

            Integer destinoFila = mov.getDesplazamiento();
            Integer nDestinoFila = mov.getCoordenadaActual().getnFila() - destinoFila;

            nCoordenada.setnFila(nDestinoFila);
            nCoordenada.setnColumna(mov.getCoordenadaActual().getnColumna());

            if (!isCoordenadaValida(nCoordenada)) {
                System.out.println("Se ha detenido el avance por salir de los límites");
                error.append("Se ha detenido el avance por salir de los límites");
                return;
            } else {

                //Retira el movimiento de la lista de movimientos
                lstMv.remove(mov);

                //Si hay mas movimientos se le pasa la nueva coordenada al siguiente movimiento
                if (!lstMv.isEmpty()) {
                    Movimiento mSig = lstMv.get(0);
                    mSig.setCoordenadaActual(nCoordenada);
                    //Se repite operación
                    calculaCoordenadaByMovimiento(mSig, error);
                } else {
                    coordenadaFinal = nCoordenada;
                    System.out.println("Posición Final: " + coordenadaFinal);
                }
            }

        }

        if (mov.getDireccion().equals("E")) {//Izquierda

            Integer destinoColumna = mov.getDesplazamiento();
            Integer nDestinoColumna = mov.getCoordenadaActual().getnColumna() - destinoColumna;

            nCoordenada.setnColumna(nDestinoColumna);
            nCoordenada.setnFila(mov.getCoordenadaActual().getnFila());

            if (!isCoordenadaValida(nCoordenada)) {
                System.out.println("Se ha detenido el avance por salir de los límites");
                error.append("Se ha detenido el avance por salir de los límites");
                return;
            } else {

                //Retira el movimiento de la lista de movimientos
                lstMv.remove(mov);

                //Si hay mas movimientos se le pasa la nueva coordenada al siguiente movimiento
                if (!lstMv.isEmpty()) {
                    Movimiento mSig = lstMv.get(0);
                    mSig.setCoordenadaActual(nCoordenada);
                    //Se repite operación
                    calculaCoordenadaByMovimiento(mSig, error);
                } else {
                    coordenadaFinal = nCoordenada;
                    System.out.println("Posición Final: " + coordenadaFinal);
                }
            }
        }

        if (mov.getDireccion().equals("O")) {//Derecha

            Integer destinoColumna = mov.getDesplazamiento();
            Integer nDestinoColumna = mov.getCoordenadaActual().getnColumna() + destinoColumna;

            nCoordenada.setnColumna(nDestinoColumna);
            nCoordenada.setnFila(mov.getCoordenadaActual().getnFila());

            if (!isCoordenadaValida(nCoordenada)) {
                System.out.println("Se ha detenido el avance por salir de los límites");
                error.append("Se ha detenido el avance por salir de los límites");
                return;
            } else {

                //Retira el movimiento de la lista de movimientos
                lstMv.remove(mov);

                //Si hay mas movimientos se le pasa la nueva coordenada al siguiente movimiento
                if (!lstMv.isEmpty()) {
                    Movimiento mSig = lstMv.get(0);
                    mSig.setCoordenadaActual(nCoordenada);
                    //Se repite operación
                    calculaCoordenadaByMovimiento(mSig, error);
                } else {
                    coordenadaFinal = nCoordenada;
                    System.out.println("Posición Final: " + coordenadaFinal);
                }
            }
        }
    }

    private void inicializaCoordenadasMovimiento(Movimiento mov) {
        Coordenada nCoordenda = mov.getCoordenadaActual();
        if (nCoordenda.getnFila() == null) {
            nCoordenda.setnFila(0);
        }
        if (nCoordenda.getnColumna() == null) {
            nCoordenda.setnColumna(0);
        }
    }

    private boolean isCoordenadaValida(Coordenada c) {
        for (Coordenada coordenada : lstCordValidas) {
            if (coordenada.getnFila().equals(c.getnFila()) && coordenada.getnColumna().equals(c.getnColumna())) {
                return true;
            }
        }
        return false;
    }

}
