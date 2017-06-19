/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 *
 * @author jeiso
 */
public class Quadrado extends StackPane {
    private Text texto = new Text();
    
    public Quadrado(){
        
       Rectangle borda = new Rectangle(200, 200);
       borda.setFill(null);
       borda.setStroke(Color.BLACK);
       
       setAlignment(Pos.CENTER);
       getChildren().addAll(borda);
       
       setOnMouseClicked(event ->{
           if (event.getButton() == MouseButton.PRIMARY){
               EscreveX();
           }
       });
    }
    
    private void EscreveX(){
        texto.setText("X");
    }
    
    private void EscreveY(){
        texto.setText("O");
    }
 
}
