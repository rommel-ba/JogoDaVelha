
package jogodavelha;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JogoDaVelha extends Application {
    
    private Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(600,600);
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                Quadrado quadrado = new Quadrado();
                quadrado.setTranslateX(j * 200);
                quadrado.setTranslateY(i * 200);
                
                root.getChildren().add(quadrado);
            }
        }
        
        return root;
    }
    
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
