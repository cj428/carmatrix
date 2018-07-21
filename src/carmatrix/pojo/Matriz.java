/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carmatrix.pojo;

/**
 *
 * @author GL62M 7RC
 */
public class Matriz {

    private Integer nFilas;
    private Integer nColumnas;

    public Matriz() {
    }

    public Matriz(Integer nFilas, Integer nColumnas) {
        this.nFilas = nFilas;
        this.nColumnas = nColumnas;
    }

    public Integer getnFilas() {
        return nFilas;
    }

    public void setnFilas(Integer nFilas) {
        this.nFilas = nFilas;
    }

    public Integer getnColumnas() {
        return nColumnas;
    }

    public void setnColumnas(Integer nColumnas) {
        this.nColumnas = nColumnas;
    }

}
