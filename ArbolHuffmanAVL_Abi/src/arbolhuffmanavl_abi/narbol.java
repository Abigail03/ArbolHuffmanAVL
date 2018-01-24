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

public class narbol{
    
    narbol nodoizquierdo;
    int datos;
    narbol nododerecho;
     
    
    public narbol(int datosNodo)
    {
        datos = datosNodo;
        nodoizquierdo = nododerecho = null; 
    }
     
   
    public void insertar(int valorInsertar)
    {
        
        if(valorInsertar < datos)
        {
           
            if(nodoizquierdo == null)
                nodoizquierdo = new narbol(valorInsertar);
            else    
                nodoizquierdo.insertar(valorInsertar);
        }
         
        
        else if(valorInsertar > datos)
        {
            
            if(nododerecho == null)
                nododerecho = new narbol(valorInsertar);
            else
                nododerecho.insertar(valorInsertar);
        }
    } 
}
class Arbol {
   private narbol raiz;
      
    public Arbol()
    {
        raiz = null;
    }
     
    public void insertarNodo(int valorInsertar)
    {
        if(raiz == null)
            raiz = new narbol(valorInsertar); 
        else
            raiz.insertar(valorInsertar);         
    }
     
    public String imprimirPreorden()
    {
        return ayudantePreorden(raiz);
    }
       
    private String ayudantePreorden(narbol nodo)
    {
        String values = "";
        if(nodo == null)
            return values;
         
        values+=(nodo.datos + "  ");     
        values+=ayudantePreorden(nodo.nodoizquierdo);   
        values+=ayudantePreorden(nodo.nododerecho);     
        return values;
    }
     
    
    public String imprimirInorden()
    {
        return ayudanteInorden(raiz);
    }
     
    
    private String ayudanteInorden( narbol nodo)
    {
        String values = "";
        if(nodo == null)
            return values;
         
        values+=ayudanteInorden(nodo.nodoizquierdo);
        values+=(nodo.datos + "  ");
        values+=ayudanteInorden(nodo.nododerecho);
       
        return values;
    }
     
   
    public String imprimirPostorden()
    {
        return ayudantePosorden(raiz);        
    }
     
 
    private String ayudantePosorden(narbol nodo)
    {
        String values = "";
        if( nodo == null )
            return values;
         
        values+=ayudantePosorden(nodo.nodoizquierdo);
        values+=ayudantePosorden(nodo.nododerecho);
        values+=(nodo.datos + "  ");
        return values;
    } 
}

