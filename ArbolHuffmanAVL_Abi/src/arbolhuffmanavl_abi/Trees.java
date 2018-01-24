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
public class Trees {
    private Nodos root;

    public void insert( Comparable x ){
        root = insert( x, root );
    }

    private Nodos insert( Comparable x, Nodos t ){
        if( t == null )
            t = new Nodos( x, null, null );
        else if( x.compareTo( t.dato ) < 0 ) {
            t.izquierdo = insert( x, t.izquierdo );
            if( height( t.izquierdo ) - height( t.derecho ) == 2 )
                if( x.compareTo( t.izquierdo.dato ) < 0 )
                    t = rotateWithLeftChild( t ); 
                 
        }
        else if( x.compareTo( t.dato ) > 0 ) {
            t.derecho = insert( x, t.derecho );
            if( height( t.derecho ) - height( t.izquierdo ) == 2 )
                if( x.compareTo( t.derecho.dato ) > 0 )
                    t = rotateWithRightChild( t ); 
        }
        else
            ; 
        t.height = max( height( t.izquierdo ), height( t.derecho ) ) + 1;
        return t;
    }


    private static int max( int lhs, int rhs ){
        return lhs > rhs ? lhs : rhs;
    }


    private static Nodos rotateWithLeftChild( Nodos k2 ){
        Nodos k1 = k2.izquierdo;
        k2.izquierdo = k1.derecho;
        k1.derecho = k2;
        k2.height = max( height(k2.izquierdo), height(k2.derecho)) + 1;
        k1.height = max( height( k1.izquierdo ), k2.height ) + 1;
        return k1;
    }


    private static Nodos rotateWithRightChild( Nodos k1 ){
        Nodos k2 = k1.derecho;
        k1.derecho = k2.izquierdo;
        k2.izquierdo = k1;
        k1.height = max( height(k1.izquierdo), height(k1.derecho) ) + 1;
        k2.height = max( height( k2.derecho ), k1.height ) + 1;
        return k2;
    }


    private static Nodos doubleWithLeftChild( Nodos k3 ){
        k3.izquierdo = rotateWithRightChild( k3.izquierdo );
        return rotateWithLeftChild( k3 );
    }


    private static Nodos doubleWithRightChild( Nodos k1 ){
        k1.derecho = rotateWithLeftChild( k1.derecho );
        return rotateWithRightChild( k1 );
    }


    private static int height( Nodos t ){
        return t == null ? -1 : t.height;
    }

    
     public String imprimirPreorden()
    {
        return ayudantePreorden(root);
    }
    
     
    private String ayudantePreorden(Nodos nodo)
    {
        String values = "";
        if(nodo == null)
            return values;
         
        values+=(nodo.dato + "  ");     
        values+=ayudantePreorden(nodo.izquierdo); 
        values+=ayudantePreorden(nodo.derecho);    
        
        return values;
    }
    
     public String imprimirInorden()
    {
        return ayudanteInorden(root);
    }
  
     
    private String ayudanteInorden(Nodos nodo)
    {
        String values = "";
        if(nodo == null)
            return values;
        values+=ayudanteInorden(nodo.izquierdo);    
        values+=(nodo.dato + "  ");   
        values+=ayudanteInorden(nodo.derecho);     
        
        return values;
    }
    
     public String imprimirPosorden()
    {
        return ayudantePosorden(root);
    }
  
     
    private String ayudantePosorden(Nodos nodo)
    {
        String values = "";
        if(nodo == null)
            return values;
        values+=ayudantePosorden(nodo.izquierdo);   
        values+=ayudantePosorden(nodo.derecho);     
        values+=(nodo.dato + "  ");
        return values;
    }
    public void imprimir(){
        imprimir(root);
    }

    private void imprimir(Nodos nodo){
        if ( nodo != null ){
            imprimir(nodo.derecho);
            System.out.println("["+ nodo.dato + "]");
            imprimir(nodo.izquierdo);
        }
    }

    public void imprimirXaltura(){
        imprimirXaltura ( root );
    }

    
    private void imprimirXaltura(Nodos nodo){
        if ( nodo != null ){
            imprimirXaltura(nodo.derecho);
            System.out.println( replicate(" ",height(root) - height(nodo)) +"["+ nodo.dato + "]");
            imprimirXaltura(nodo.izquierdo);
        }
    }

    
    private static String replicate (String a, int cnt){
        String x = new String("");

        for ( int i = 0; i < cnt; i++ )
            x = x + a;
        return x;
    }

    
    public int calcularAltura(){
        return calcularAltura(root);
    }

    private int calcularAltura(Nodos actual ){
       if (actual == null)
            return -1;
       else
            return 1 + Math.max(calcularAltura(actual.izquierdo), calcularAltura(actual.derecho));
    }

    public String imprimirPorNiveles(){
        return AimprimirPorNiveles(root);
    }

    private String AimprimirPorNiveles(Nodos nodo){
        
        String values = "";
        
        int max = 0;
        int nivel = calcularAltura();

        for ( ; nivel >= 0; nivel--)
            max += Math.pow(2, nivel);
        max++;      

        Nodos cola[] = new Nodos[ max ];
        String direccion [] = new String [max];
        
        cola[1] = nodo;
        int x = 1;

        
        for (int i = 2; i < max; i += 2, x++){
            if (cola[x] == null){
                cola[i] = null;
                cola[i + 1] = null;
            }
            else{
                cola[i]   = cola[x].izquierdo;
                direccion [i] = "Izquierdo"; 
                cola[i + 1] = cola[x].derecho;
                direccion [i+1] = "Derecho"; 
            }
        }
        nivel = 0;
        int cont = 0;                       
        int cantidad = 1;                   
        int ultimaPosicion = 1;             

        
        for (int i = 1; i < max; i++){
            if(i == Math.pow(2, nivel)){
            	
            	values+=("\n Nivel " + (nivel) + ": ");
                nivel++;
            }
            if( cola[i] != null ){
               values+=("[" + cola[i].dato + "]: "+direccion[i]+",");
                cont++;
            }
            if(ultimaPosicion == i  && cantidad == Math.pow(2, --nivel)){
                if(cantidad == 1)
                   values+= "(raiz)";
                cont = 0;
                cantidad *= 2;
                ultimaPosicion += (int)Math.pow(2, ++nivel);
            }
        }
        return values;
    }
}
