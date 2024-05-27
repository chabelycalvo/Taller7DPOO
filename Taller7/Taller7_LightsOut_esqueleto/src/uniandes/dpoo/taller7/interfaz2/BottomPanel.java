package uniandes.dpoo.taller7.interfaz2;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {

    public BottomPanel() {
        // Configura el layout del panel
        setLayout(new GridLayout(1, 4));

        // Agrega componentes al panel
        add(new JLabel("Jugadas:"));
        JTextField movesField = new JTextField("0");
        movesField.setEditable(false);
        add(movesField);

        add(new JLabel("Jugador:"));
        JTextField playerField = new JTextField();
        add(playerField);
    }
}
