package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {

    private JComboBox<String> sizeComboBox;

    public TopPanel() {
        // Configura el layout del panel
        setLayout(new FlowLayout());

        // Agrega componentes al panel
        add(new JLabel("Tamaño"));
        sizeComboBox = new JComboBox<>(new String[]{"5x5", "6x6", "7x7"});
        add(sizeComboBox);

        add(new JLabel("Dificultad"));
        JRadioButton easyButton = new JRadioButton("Fácil");
        JRadioButton mediumButton = new JRadioButton("Medio");
        JRadioButton hardButton = new JRadioButton("Difícil");

        // Agrupa los botones de radio
        ButtonGroup difficultyGroup = new ButtonGroup();
        difficultyGroup.add(easyButton);
        difficultyGroup.add(mediumButton);
        difficultyGroup.add(hardButton);

        add(easyButton);
        add(mediumButton);
        add(hardButton);
    }

    public JComboBox<String> getSizeComboBox() {
        return sizeComboBox;
    }
}
