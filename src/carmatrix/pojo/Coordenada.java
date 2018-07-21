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
public class Coordenada {

    Integer nFila;
    Integer nColumna;

    public Coordenada() {
    }

    public Coordenada(Integer nFila, Integer nColumna) {
        this.nFila = nFila;
        this.nColumna = nColumna;
    }

    public Integer getnFila() {
        return nFila;
    }

    public void setnFila(Integer nFila) {
        this.nFila = nFila;
    }

    public Integer getnColumna() {
        return nColumna;
    }

    public void setnColumna(Integer nColumna) {
        this.nColumna = nColumna;
    }

    @Override
    public String toString() {
        return this.getnFila() +","+ this.getnColumna();
    }
    
    
}
