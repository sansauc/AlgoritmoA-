import java.util.*;

public class Controlador {
    
    private List<costoSalto> costoSaltos;


    public List<Nodo> cargarTodosLosNodos(){
        /**Esto se haria con la logica de interacción de la interfaz, pero para provar podemos cargar 6, 7 
         * nodos a manopla por codigo cargar cuantos nodos se van a querer tener determinar nodo inicial y 
         * nodo final **/
    }

    public List<costoSalto> calcularCostoDeLosSaltos(){

    }

    public float calcularDistanciaEuclidea (Nodo nodoOrigen, Nodo nodoDestino) {
        //Calculando la pendiente de la recta
        float pendiente = (nodoDestino.getCoordenadaY() - nodoOrigen.getCoordenadaY()) / (nodoDestino.getCoordenadaX() - nodoOrigen.getCoordenadaX());
        float imagenOrigen = pendiente * nodoOrigen.getCoordenadaX() + nodoOrigen.getCoordenadaY();
        float imagenDestino = pendiente * nodoDestino.getCoordenadaX() + nodoDestino.getCoordenadaY();
        //retornamos el valor absoluto de las diferencias de las imagenes de cada nodo evaluado en la recta que los comunica
        return Math.abs(imagenDestino - imagenOrigen)
    }

    public Nodo obtenerNodoConMenorF (List <Nodo> nodosAbiertos){
        if (nodosAbiertos.size()==1){
            
            //Significa que un solo nodo existe en la lista, por lo que no hace falta iterar la lista. 
            //Ejemplo: cuando solo esté cargado el nodo inicial en la primer iteración del algoritmo
            
            return nodosAbiertos.get(0);

        }else{

            Nodo nodoConMenorF = null;
            float fAux = 1000000; //se coloca un valor arbitrariamente alto para que se sobrescriba con el valor de la F del primer nodo de la lista
            for (Nodo nodo : nodosAbiertos){
                if (nodo.getF() < fAux){
                    nodoConMenorF = nodo;
                    fAux = nodo.getF();
                }
            }
            return nodoConMenorF;
        }
    }

    public void ponerNodosVecinosEnListaAbiertos(Nodo nodoActual, List<Nodo> nodosAbiertos){
        List<Nodo> nodosVecinos = nodoActual.getVecinos();
        for (Nodo nodo : nodosVecinos){
            if (!nodosAbiertos.contains(nodo)){               
                //significa que el nodo vecino no está en la lista de nodos abiertos, por ende, lo agregamos
                nodosAbiertos.add(nodo);
            }
            this.calcularCostoDePasoAlNodo(nodoActual, nodo); 
        }

    }

    public void calcularCostoDePasoAlNodo (Nodo nodoActual, Nodo nodoVecino){
       float gAux = this.getCostoSaltos(nodoActual, nodoVecino); // obtiene el valor del salto
        if (nodoVecino.getF() > (gAux+nodoActual.getG()+nodoVecino.getH())){ //el nuevo valor de g se calcula como el costo de salto al nodo vecino, mas el valor de G del nodo actual, mas el valor de la heuritica del nodo vecino
            
            //Actualizamos los valores para el nodo vecinos
            //significa que el nuevo F es mejor, por lo tanto actualizamos F y G en el nodo Vecino
            nodoVecino.setG(gAux+nodoActual.getG());
            nodoVecino.setF(gAux+nodoActual.getG()+nodoVecino.getH())
            //Actualizamos el padre del nodoVecino para indicar cual es su nuevo padre con un camino mas optimo
            nodoVecino.setPadre(nodoActual);
        }
    }


}
