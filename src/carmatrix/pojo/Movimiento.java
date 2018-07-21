/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carmatrix.pojo;

import java.util.StringTokenizer;

/**
 *
 * @author GL62M 7RC
 */
public class Movimiento {

    private String direccion;
    private Integer desplazamiento;
    private Coordenada coordenadaActual = new Coordenada();

    public Movimiento() {
    }

    public Movimiento(String direccion, Integer desplazamiento) {
        this.direccion = direccion;
        this.desplazamiento = desplazamiento;
    }

    public Movimiento(String direccion, Integer desplazamiento, Coordenada coordenadaActual) {
        this.direccion = direccion;
        this.desplazamiento = desplazamiento;
        this.coordenadaActual = coordenadaActual;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getDesplazamiento() {
        return desplazamiento;
    }

    public void setDesplazamiento(Integer desplazamiento) {
        this.desplazamiento = desplazamiento;
    }

    public Coordenada getCoordenadaActual() {
        return coordenadaActual;
    }

    public void setCoordenadaActual(Coordenada coordenadaActual) {
        this.coordenadaActual = coordenadaActual;
    }
    
    @Override
    public String toString() {
        return this.getDesplazamiento() + "," + this.getDireccion() + " (n,m) " + this.getCoordenadaActual();
    }

}
