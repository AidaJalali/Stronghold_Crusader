package model;


import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class ScoreboardTable {
    private ImageView avatar = new ImageView();
    private int rank;
    private String username;
    private int score;
    private Circle state = new Circle();
    private String lastSeen;
    private Button friendShip = new Button("Friendship");


}
