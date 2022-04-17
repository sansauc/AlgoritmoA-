import java.util.*;

public class Controlador {
    
    private List<CostoSalto> costoSaltos = new ArrayList<CostoSalto>() ;

    public List<Nodo> cargarTodosLosNodos(){
        /**Esto se haria con la logica de interacción de la interfaz, pero para provar podemos cargar 6, 7 
         * nodos a manopla por codigo cargar cuantos nodos se van a querer tener determinar nodo inicial y 
         * nodo final **/

         //harcodeando nodos
        //Los nodos inicial y final ya bienen determinados por el usuario antes de ejecutar el algortimo por primera vez
        Nodo nodoInicial = new Nodo(1, 4, 3);   //nodo origen tiene G=0 ya que es el punto de partida por el cual inicia el algoritmo, por lo que no tiene un costo de salto
        nodoInicial.setH(20);
        Nodo nodoFinal = new Nodo(7, 5, 5); //nodo final tiene H=0 ya que es el distino al que todos los nodos deben llegar
        nodoFinal.setH(0);
        Nodo nodo2 = new Nodo (2, 6, 7);
        nodo2.setH(18);
        Nodo nodo3 = new Nodo (3, 6, 5);
        nodo3.setH(16);
        Nodo nodo4 = new Nodo (4, 6, 3);
        nodo4.setH(14);
        Nodo nodo5 = new Nodo (5, 8, 7);
        nodo5.setH(10);
        Nodo nodo6 = new Nodo (6, 8, 4);
        nodo6.setH(7);
        
        CostoSalto costo1 = new CostoSalto(nodoInicial, nodo2, 6);
        CostoSalto costo2 = new CostoSalto(nodoInicial, nodo3, 3);
        CostoSalto costo3 = new CostoSalto(nodoInicial, nodo4, 8);
        CostoSalto costo4 = new CostoSalto(nodo2, nodo3, 2);
        CostoSalto costo5 = new CostoSalto(nodo2, nodo5, 2);
        CostoSalto costo6 = new CostoSalto(nodo3, nodo4, 2);
        CostoSalto costo7 = new CostoSalto(nodo3, nodo5, 7);
        CostoSalto costo8 = new CostoSalto(nodo4, nodo6, 5);
        CostoSalto costo9 =new CostoSalto(nodo4, nodoFinal, 1);
        CostoSalto costo10 = new CostoSalto(nodo5, nodo6, 3);
        CostoSalto costo11 = new CostoSalto(nodo6, nodoFinal, 5);

        this.costoSaltos.add(costo1);
        this.costoSaltos.add(costo2);
        this.costoSaltos.add(costo3);
        this.costoSaltos.add(costo4);
        this.costoSaltos.add(costo5);
        this.costoSaltos.add(costo6);
        this.costoSaltos.add(costo7);
        this.costoSaltos.add(costo8);
        this.costoSaltos.add(costo9);
        this.costoSaltos.add(costo10);
        this.costoSaltos.add(costo11);

        List<Nodo> nodosVecinos1 = new ArrayList<Nodo>();
        nodosVecinos1.add(nodo2);
        nodosVecinos1.add(nodo3);
        nodosVecinos1.add(nodo4);
        nodoInicial.setVecinos(nodosVecinos1);
        
      
        List<Nodo> nodosVecinos2 = new ArrayList<Nodo>();
        nodosVecinos2.add(nodoInicial);
        nodosVecinos2.add(nodo3);
        nodosVecinos2.add(nodo5);
        nodo2.setVecinos(nodosVecinos2);
        
      
        List<Nodo> nodosVecinos3 = new ArrayList<Nodo>();
        nodosVecinos3.add(nodoInicial);
        nodosVecinos3.add(nodo2);
        nodosVecinos3.add(nodo4);
        nodosVecinos3.add(nodo5);
        nodo3.setVecinos(nodosVecinos3);
      
        List<Nodo> nodosVecinos4 = new ArrayList<Nodo>();
        nodosVecinos4.add(nodoInicial);
        nodosVecinos4.add(nodo3);
        nodosVecinos4.add(nodo6);
        nodosVecinos4.add(nodoFinal);
        nodo4.setVecinos(nodosVecinos4);                        
        
        
        List<Nodo> nodosVecinos5 = new ArrayList<Nodo>();
        nodosVecinos5.add(nodo2);
        nodosVecinos5.add(nodo3);
        nodosVecinos5.add(nodo6);
        nodo5.setVecinos(nodosVecinos5);
        
      
        List<Nodo> nodosVecinos6 = new ArrayList<Nodo>();
        nodosVecinos6.add(nodo5);
        nodosVecinos6.add(nodo4);
        nodosVecinos6.add(nodoFinal);
        nodo6.setVecinos(nodosVecinos6);
        

        List<Nodo> nodosVecinos7 = new ArrayList<Nodo>();
        nodosVecinos7.add(nodo6);
        nodosVecinos7.add(nodo4);
        nodoFinal.setVecinos(nodosVecinos7);
        
        //cargamos todos los nodos en la lista del controlador

        List<Nodo> nodosVecinos8 = new ArrayList<Nodo>();
        nodosVecinos8.add(nodoInicial);
        nodosVecinos8.add(nodo2);
        nodosVecinos8.add(nodo3);
        nodosVecinos8.add(nodo4);
        nodosVecinos8.add(nodo5);
        nodosVecinos8.add(nodo6);
        nodosVecinos8.add(nodoFinal);
        return nodosVecinos8;

    }

    /** Para la Interfaz Gráfica 
    public List<CostoSalto> calcularCostoDeLosSaltos(){
            //determina el costo de paso de cada nodo hacia cada uno de sus respectivos vecinos
            //Se carga la lista de costoSaltos
    }
    **/

    public float getCostoSaltos(Nodo nodoOrigen, Nodo nodoDestino){
        float costo = 0;
        for (CostoSalto salto : this.costoSaltos){
            if ((salto.getOrigen() == nodoOrigen && salto.getDestino() == nodoDestino) || (salto.getOrigen() == nodoDestino && salto.getDestino() == nodoOrigen)){
                costo =  salto.getCosto()+nodoOrigen.getG();
                break;
            }
        }
        return costo;
    }

    public float calcularDistanciaEuclidea (Nodo nodoOrigen, Nodo nodoDestino) { //cambiar a float
        //Calculando la pendiente de la recta        
        //retornamos el valor absoluto de las diferencias de las imagenes de cada nodo evaluado en la recta que los comunica
        //x1, y1 = x
        //x2, y2 = y
        //return math.sqrt((x1-x2)**2 + (y1-y2)**2) //
        return (float) Math.sqrt((nodoDestino.getCoordenadaX() - nodoOrigen.getCoordenadaX())^2 + (nodoDestino.getCoordenadaY()-nodoOrigen.getCoordenadaY())^2 );
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

    public void ponerNodosVecinosEnListaAbiertos(Nodo nodoActual, List<Nodo> nodosAbiertos, List<Nodo> nodosCerrados){
        List<Nodo> nodosVecinos = nodoActual.getVecinos();
        for (Nodo nodo : nodosVecinos){
            
            // CONSULTAR AL PROFE SI ESTA BIEN ESTE FILTRO DE SI YA SE ENCUENTRA EN LA LISTA DE NODOS CERRADOS          
            if (!nodosAbiertos.contains(nodo) && !nodosCerrados.contains(nodo) ){               
                //significa que el nodo vecino no está en la lista de nodos abiertos, por ende, lo agregamos
                nodosAbiertos.add(nodo);
            }
            this.calcularCostoDePasoAlNodo(nodoActual, nodo); 
        }

    }

    public void calcularCostoDePasoAlNodo (Nodo nodoActual, Nodo nodoVecino){
       float gAux = this.getCostoSaltos(nodoActual, nodoVecino); // obtiene el valor del salto
       nodoVecino.setG(this.getCostoSaltos(nodoActual, nodoVecino));  
       nodoVecino.setF(nodoVecino.getH()+nodoVecino.getG());
       if (nodoVecino.getF() > (gAux+nodoVecino.getH())){ //el nuevo valor de g se calcula como el costo de salto al nodo vecino, mas el valor de G del nodo actual, mas el valor de la heuritica del nodo vecino
            
            //Actualizamos los valores para el nodo vecinos
            //significa que el nuevo F es mejor, por lo tanto actualizamos F y G en el nodo Vecino
            nodoVecino.setG(gAux);
            nodoVecino.setF(gAux+nodoVecino.getH());
            //Actualizamos el padre del nodoVecino para indicar cual es su nuevo padre con un camino mas optimo
            nodoVecino.setPadre(nodoActual);
        }
    }


    public List<Nodo> obtenerCamino(Nodo nodo, List<Nodo>camino){
    
        if (nodo.getPadre() != null){
            this.obtenerCamino(nodo.getPadre(), camino);
        }
        camino.add(nodo);
        return camino;
    }
}
