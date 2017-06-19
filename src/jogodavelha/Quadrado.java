package jogodavelha;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author jeiso
 */
public class Quadrado extends StackPane {
    
    public boolean jogavel = true;
    public boolean jogaX = true;
    private Combo combo;
    private List<Combo> combos = new ArrayList<>();
    private Text texto = new Text();     
    
    public Quadrado(){
        
       Rectangle borda = new Rectangle(200, 200);
       borda.setFill(null);
       borda.setStroke(Color.BLACK);

       
       texto.setFont(Font.font(72));
       
       setAlignment(Pos.CENTER);
       getChildren().addAll(borda, texto);
       
       setOnMouseClicked(event -> {
           if(!jogavel)
                return;
           
           if (event.getButton() == MouseButton.PRIMARY){
               if(!jogaX)
                   return;
               
               EscreveX();
               jogaX = false;
               checarEstado();
           } 
           else if(event.getButton() == MouseButton.SECONDARY){ 
               if(!jogaX) 
                   return;
   
               EscreveO();
               checarEstado();
           }
       });
    }
    
    private void EscreveX(){
        texto.setText("X");
    }
    
    private void EscreveO(){
        texto.setText("O");
    }
 
    private void checarEstado(){
        for (Combo combo: combos){
            if(combo.estaCompleto()){
                jogavel = false;
                //animacaoVitoria(combo);
                
                break;
            }
        }
    }
    
    public String getValue(){
        return texto.getText();
    }

   /* private void animacaoVitoria(Combo combo1) {
        Line line = new Line();
        line.setStartX(combo.quadrados.get);
    }*/
    
    
}
