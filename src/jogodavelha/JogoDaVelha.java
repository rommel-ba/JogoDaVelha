
package jogodavelha;

import java.util.ArrayList;
import java.util.List;
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

    private Quadrado[][] quadro = new Quadrado[3][3];        
    private Combo combo;
    private List<Combo> combos = new ArrayList<>();
    
    private Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(600,600);
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                Quadrado quadrado = new Quadrado();
                quadrado.setTranslateX(j * 200);
                quadrado.setTranslateY(i * 200);
                
                root.getChildren().add(quadrado);
                
                quadro[j][i] = quadrado;
            }
        }
        //Horizontal
        for (int y = 0; y < 3; y++){
            combos.add(new Combo(quadro[0][y], quadro[1][y], quadro[2][y]));
        }


        //Vertical
        for (int x = 0; x < 3; x++){
            combos.add(new Combo(quadro[x][0], quadro[x][1], quadro[x][2]));
        }
        
        //Diagonais
            combos.add(new Combo(quadro[0][0], quadro[1][1], quadro[2][2]));
            combos.add(new Combo(quadro[2][0], quadro[1][1], quadro[0][2]));

        
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
