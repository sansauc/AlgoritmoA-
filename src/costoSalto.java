public class CostoSalto {
    
    private Nodo origen;
    private Nodo destino;
    private float costo;

    public CostoSalto(){
        
    }

     public CostoSalto(Nodo origen, Nodo destino, float costo){
         this.origen = origen;
         this.destino = destino;
         this.costo = costo;        
    }

    public Nodo getOrigen(){
        return this.origen;
    }
    
    public void setOrigen(Nodo ori){
        this.origen = ori;        
    } 

    public Nodo getDestino(){
        return this.destino;
    }
    
    public void setDestino(Nodo dest){
        this.destino = dest;        
    } 

    public float getCosto(){
        return this.costo;
    }

    public void setCosto(float cost){
        this.costo = cost;        
    } 


}
