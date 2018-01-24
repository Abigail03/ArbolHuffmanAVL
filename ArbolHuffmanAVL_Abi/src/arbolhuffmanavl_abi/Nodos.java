/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolhuffmanavl_abi;

/**
 *
 * @author Abigail
 */
public class Nodos {
    public Comparable dato;      	 // el dato del nodo
    public Nodos izquierdo;            // hijo izquierdo
    public Nodos derecho;              // hijo derecho
    public int height;                   // altura

    // Constructors
    public Nodos( Comparable dato ){
        this( dato, null, null );
    }

    public Nodos( Comparable dato, Nodos izq, Nodos der ){
        this.dato = dato;
        this.izquierdo = izq;
        this.derecho = der;
        height   = 0;               // altura predeterminada
    }
}
