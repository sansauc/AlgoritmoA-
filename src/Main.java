import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Controlador controlador = new Controlador();
        List<Nodo>nodosAbiertos = new ArrayList<Nodo>();
        List<Nodo>nodosCerrados = new ArrayList<Nodo>();
    
        //Los nodos inicial y final ya bienen determinados por el usuario antes de ejecutar el algortimo por primera vez
        Nodo nodoInicial = new Nodo ();   //nodo origen tiene G=0 ya que es el punto de partida por el cual inicia el algoritmo, por lo que no tiene un costo de salto
        Nodo nodoFinal = new Nodo(); //nodo final tiene H=0 ya que es el distino al que todos los nodos deben llegar
      
        //Todos los nodos que van a formar parte de la ejecucion de este programa se colocan inicialmente en esta lista
        List<Nodo>nodosDelSistema = controlador.cargarTodosLosNodos();
        controlador.calcularCostoDeLosSaltos();
    
        //calculando la distancia euclidea de cada nodo respecto al nodo Final (El valor de H que va a tener cada nodo)
        for(Nodo nodo : nodosDelSistema){
            nodo.setH(controlador.calcularDistanciaEuclidea(nodo, nodoFinal));
        }
        
        boolean nodoFinalEncontrado = false;
        nodosAbiertos.add(nodoInicial);
        Nodo nodoActual = nodoInicial;
        //Inicio del algoritmo A *
       
        while (nodoFinalEncontrado == false){
            nodoActual = controlador.obtenerNodoConMenorF(nodosAbiertos);
            nodosAbiertos.remove(nodoActual);
            nodosCerrados.add(nodoActual);
            if (nodoActual == nodoFinal){
                nodoFinalEncontrado = true;
                break; //llegamos al nodo final, por ende, salimos del bucle
            }
            
            controlador.ponerNodosVecinosEnListaAbiertos(nodoActual, nodosAbiertos);
        
        }
    


    }
}
