/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

/**
 *
 * @author jeiso
 */
public class Combo {
    Quadrado[] quadrados;


    public Combo(Quadrado...quadrados){
        this.quadrados = quadrados;
    }
    
    public boolean estaCompleto(){
        if (quadrados[0].getValue().isEmpty())
            return false;
        
            return quadrados[0].getValue().equals(quadrados[1].getValue())
                    && quadrados[0].getValue().equals(quadrados[2].getValue());
            
    }
    
    /*public double getCenterX(){
        return getTranslateX() + 100;
    }
    
    public double getCenterY(){
        return getTranslateY() + 100;
    }*/
    
    
    
}
 