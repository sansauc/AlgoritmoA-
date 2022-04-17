import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Controlador controlador = new Controlador();
        List<Nodo>nodosAbiertos = new ArrayList<Nodo>();
        List<Nodo>nodosCerrados = new ArrayList<Nodo>();
    
        //Todos los nodos que van a formar parte de la ejecucion de este programa se colocan inicialmente en esta lista
        List<Nodo>nodosDelSistema = controlador.cargarTodosLosNodos();
       
        //controlador.calcularCostoDeLosSaltos();
        
        Nodo nodoInicial = nodosDelSistema.get(0);   //nodo origen tiene G=0 ya que es el punto de partida por el cual inicia el algoritmo, por lo que no tiene un costo de salto
        Nodo nodoFinal = nodosDelSistema.get(nodosDelSistema.size()-1); //nodo final tiene H=0 ya que es el distino al que todos los nodos deben llegar
        Nodo nodoViejo = null;
    
        //calculando la distancia euclidea de cada nodo respecto al nodo Final (El valor de H que va a tener cada nodo)
        /** 
        for(Nodo nodo : nodosDelSistema){
            nodo.setH(controlador.calcularDistanciaEuclidea(nodo, nodoFinal));
        }
        */
        
        boolean nodoFinalEncontrado = false;
        nodosAbiertos.add(nodoInicial);
        Nodo nodoActual = nodoInicial;
        //Inicio del algoritmo A *
        List<Nodo>camino = new ArrayList<Nodo>();

        while (nodoFinalEncontrado == false){
            nodoActual = controlador.obtenerNodoConMenorF(nodosAbiertos);
            camino.add(nodoActual);
            nodosAbiertos.remove(nodoActual);
            nodosCerrados.add(nodoActual);
            if (nodoActual == nodoFinal){
                nodoFinal.setPadre(nodoViejo);
                nodoFinalEncontrado = true;
                break; //llegamos al nodo final, por ende, salimos del bucle
            }
            nodoViejo=nodoActual;
            controlador.ponerNodosVecinosEnListaAbiertos(nodoActual, nodosAbiertos, nodosCerrados);        
        }
        
        //camino = controlador.obtenerCamino(nodoFinal,camino);

        System.out.println("El camino recorrido es: ");
        
        for(Nodo nodo : camino){
            System.out.println(nodo.getId());    
        }

        System.out.println("Lista Abierta es: ");
        for(Nodo nodo : nodosAbiertos){
            System.out.println(nodo.getId());    
        }
        
        System.out.println("Lista Cerrada es: ");
        for(Nodo nodo : nodosCerrados){
            System.out.println(nodo.getId());    
        }
    }
}
