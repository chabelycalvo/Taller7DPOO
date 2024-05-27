package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {

    private JTextField movesField;
    private JTextField playerField;

    public BottomPanel() {
        // Configura el layout del panel
        setLayout(new GridLayout(1, 4));

        // Cambia el fondo y la fuente
        setBackground(Color.LIGHT_GRAY);

        // Agrega componentes al panel
        JLabel movesLabel = new JLabel("Jugadas:");
        movesField = new JTextField("0");
        movesField.setEditable(false);

        JLabel playerLabel = new JLabel("Jugador:");
        playerField = new JTextField();

        // Cambia la apariencia de los campos de texto
        movesField.setFont(new Font("Arial", Font.PLAIN, 14));
        playerField.setFont(new Font("Arial", Font.PLAIN, 14));

        add(movesLabel);
        add(movesField);
        add(playerLabel);
        add(playerField);
    }

    public void resetMoves() {
        movesField.setText("0");
    }

    public void setPlayerName(String playerName) {
        playerField.setText(playerName);
    }

    public String getPlayerName() {
        return playerField.getText();
    }

    public void updateMoveCount(int moveCount) {
        movesField.setText(String.valueOf(moveCount));
    }
}
