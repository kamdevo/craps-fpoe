package com.example.crapsgame262.controllers;

import com.example.crapsgame262.models.AlertBox;
import com.example.crapsgame262.models.Dice;
import com.example.crapsgame262.models.Game;
import com.example.crapsgame262.models.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GameController {

    private Player currentPlayer;

    private Game game = new Game();

    @FXML
    private ImageView dice1ImageView;

    @FXML
    private ImageView dice2ImageView;

    @FXML
    private Label nicknameLabel;

    @FXML
    private Label rollTextField;

    @FXML
    private Label pointsTextField;

    @FXML
    private Label wonTextField;

    @FXML
    private Label lostTextField;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        nicknameLabel.setText(this.currentPlayer.getNickname());
    }

    @FXML
    void onMouseClickedDropButton(MouseEvent event) {
        Dice dice1 = new Dice();
        int dice1Value = dice1.roll();

        dice1ImageView.setImage(
                new Image(
                        getClass().getResourceAsStream(
                                dice1.getImagePath()
                        )
                )
        );

        Dice dice2 = new Dice();
        int dice2Value = dice2.roll();

        dice2ImageView.setImage(
                new Image(
                        getClass().getResourceAsStream(
                                dice2.getImagePath()
                        )
                )
        );

        game.play(dice1Value, dice2Value);

        showGameData();
    }

    @FXML
    void onMouseClickedHelpButton(MouseEvent event) {
        AlertBox alertBox = new AlertBox();
        alertBox.showAlertBox(
                "Craps Game - Instrucciones",
                "¿Cómo se juega?",
                "En el primer lanzamiento, si sacas 7 u 11 ganas; si sacas 2, 3 o 12 pierdes. "
                        + "Cualquier otro número se vuelve tu Punto: sigue lanzando y ganas si sacas "
                        + "el Punto antes que un 7; si sale 7 primero, pierdes.");
    }

    private void showGameData() {
        rollTextField.setText(String.valueOf(game.getRoll()));
        pointsTextField.setText(String.valueOf(game.getPoint()));
        wonTextField.setText(String.valueOf(game.getGamesWon()));
        lostTextField.setText(String.valueOf(game.getGamesLost()));
    }
}
