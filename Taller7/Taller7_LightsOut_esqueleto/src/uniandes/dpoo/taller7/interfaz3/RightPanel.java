package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {

    public RightPanel() {
        // Configura el layout del panel
        setLayout(new GridLayout(4, 1, 5, 5));

        // Agrega botones al panel
        add(new JButton("NUEVO"));
        add(new JButton("REINICIAR"));
        add(new JButton("TOP-10"));
        add(new JButton("CAMBIAR JUGADOR"));
    }
}
