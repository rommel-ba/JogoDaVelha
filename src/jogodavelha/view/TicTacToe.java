package jogodavelha.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class TicTacToe extends Application {
    
    private char currentPlayer = 'X';
    private Cell[][] cell = new Cell[3][3];
    private Label statusMsg = new Label("X must play");
    
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        for (int i = 0; i < 3; i++){
            for (int j = 0; j< 3; j++){
                cell[i][j] = new Cell();
                grid.add(cell[i][j], i, j);
            }
        }
        
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(grid);
        borderPane.setBottom(statusMsg);
        Scene scene = new Scene(borderPane, 450, 300);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public boolean isBoarderFull(){
        for (int i = 0; i < 3; i++ ){
            for (int j = 0; j < 3; j++){
                if (cell[i][j].getPlayer() == ' '){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean hasWon(char player){
        for (int i = 0; i < 3; i++){
            if(cell[i][0].getPlayer() == player && cell[i][1].getPlayer() == player && cell[i][2].getPlayer() == player){
                return true;
            }
            if(cell[0][i].getPlayer() == player && cell[1][i].getPlayer() == player && cell[2][i].getPlayer() == player){
                return true;
            }
        }
        if(cell[0][0].getPlayer() == player && cell[1][1].getPlayer() == player && cell[2][2].getPlayer() == player){
                return true;
        }
        if(cell[0][2].getPlayer() == player && cell[1][1].getPlayer() == player && cell[2][0].getPlayer() == player){
                return true;
        }
        return false;
    }
    /**
     * @param args the command line1 arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    private class Cell extends Pane{
        private char player = ' ';
        
        public Cell(){
            setStyle("-fx-border-color:black");
            this.setPrefSize(300, 300);
            this.setOnMouseClicked(e -> handleClick());
        }
        
        private void handleClick(){
            if (player == ' ' && currentPlayer != ' '){
                setPlayer(currentPlayer);
                if (hasWon(currentPlayer)){
                    statusMsg.setText("O jogador "+ currentPlayer+ " venceu!");
                    currentPlayer = ' ';
                }else if (isBoarderFull()){
                    statusMsg.setText("Fim de jogo");
                    currentPlayer = ' ';
                }else {
                    currentPlayer = (currentPlayer == 'X') ? 'O':'X';
                    statusMsg.setText(currentPlayer+ " must Play");
                }
            }
        }
        public char getPlayer(){
            return player;
        }
        public void setPlayer(char c){
            player = c;
            
            if (player == 'X'){
                Line line1 = new Line(10, 10, this.getWidth() -10, this.getHeight() - 10);
                line1.endXProperty().bind(this.widthProperty().subtract(10));
                line1.endYProperty().bind(this.heightProperty().subtract(10));
                
                Line line2 = new Line(10, this.getHeight() - 10, this.getWidth() -10, 10);
                line2.endXProperty().bind(this.widthProperty().subtract(10));
                line2.startYProperty().bind(this.heightProperty().subtract(10));
                
                getChildren().addAll(line1, line2);
                
            }else{
                Ellipse ellipse = new Ellipse(this.getWidth(), this.getHeight(),
                        this.getWidth() / 2 - 10, this.getHeight() / 2 - 10);
                ellipse.centerXProperty().bind(this.widthProperty().divide(2));
                ellipse.centerYProperty().bind(this.heightProperty().divide(2));
                ellipse.radiusXProperty().bind(this.widthProperty().subtract(80));
                ellipse.radiusYProperty().bind(this.heightProperty().subtract(50));
                ellipse.setStroke(javafx.scene.paint.Paint.valueOf("black"));
                //ellipse.setFill(javafx.scene.paint.Paint.valueOf("blue"));
                getChildren().add(ellipse);
            }
        }
    }
}
