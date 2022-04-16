import java.util.*;

public class Nodo {
   
    private int coordenadaY;
    private int coordenadaX;
    private int id;
    private int G;
    private float F;
    private float H; //Valor de la Eurísitica
    private Nodo padre;
    private List<Nodo> vecinos;   

    public Nodo(){
        this.vecinos = new ArrayList<Nodo>();        
    }

    //El nodo inicial no tiene nodo padre
    public Nodo (int id, int x, int y, int g, float h, float f, List<Nodo>vecinos){
        this.id = id;
        this.coordenadaX = x;
        this.coordenadaY = y;
        this.G = g;
        this.H = h;
        this.F = f;
        this.vecinos = vecinos;
    }
    
    public Nodo (int id, int x, int y, int g, float h, float f, Nodo padre, List<Nodo>vecinos){
        this.id = id;
        this.coordenadaX = x;
        this.coordenadaY = y;
        this.G = g;
        this.H = h;
        this.F = f;
        this.padre = padre;
        this.vecinos = vecinos;
    }

    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;        
    } 

    public int getCoordenadaX(){
        return this.coordenadaX;
    }
    
    public void setCordenadaX(int x){
        this.coordenadaX = x;        
    } 

    public int getCoordenadaY(){
        return this.coordenadaY;
    }
    
    public void setCoordenadaX(int y){
        this.coordenadaY = y;        
    } 


    public int getG(){
        return this.G;
    }

    public void setG(int costoSalto){
        this.G = costoSalto;        
    }

    public void setF(float Fn){
        this.F = Fn;
    }

    public float getF(){
        return this.F;
    }

    public void setH(float h){
        this.H = h;
    }
    
    public float getH(){
        return this.H;
    }

    public void setPadre(Nodo padre){
        this.padre = padre;
    }

    public Nodo getPadre(){
        return this.padre;
    }

    public List<Nodo> getVecinos(){
        return this.vecinos;
    }

    public void setVecinos(List<Nodo> vecinos){
        this.vecinos = vecinos;
    }

}
