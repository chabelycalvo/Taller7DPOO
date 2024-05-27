package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RightPanel extends JPanel implements ActionListener {

    private JButton newButton;
    private JButton resetButton;
    private JButton top10Button;
    private JButton changePlayerButton;
    private MainWindow mainWindow;

    public RightPanel(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        // Configura el layout del panel
        setLayout(new GridLayout(4, 1, 5, 5));

        // Cambia el fondo y la fuente
        setBackground(Color.DARK_GRAY);

        // Agrega botones al panel
        newButton = new JButton("NUEVO");
        resetButton = new JButton("REINICIAR");
        top10Button = new JButton("TOP-10");
        changePlayerButton = new JButton("CAMBIAR JUGADOR");

        // Cambia la apariencia de los botones
        newButton.setBackground(Color.WHITE);
        resetButton.setBackground(Color.WHITE);
        top10Button.setBackground(Color.WHITE);
        changePlayerButton.setBackground(Color.WHITE);

        newButton.setFont(new Font("Arial", Font.PLAIN, 14));
        resetButton.setFont(new Font("Arial", Font.PLAIN, 14));
        top10Button.setFont(new Font("Arial", Font.PLAIN, 14));
        changePlayerButton.setFont(new Font("Arial", Font.PLAIN, 14));

        // Agrega ActionListener a los botones
        newButton.addActionListener(this);
        resetButton.addActionListener(this);
        top10Button.addActionListener(this);
        changePlayerButton.addActionListener(this);

        add(newButton);
        add(resetButton);
        add(top10Button);
        add(changePlayerButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newButton) {
            mainWindow.createNewBoard();
        } else if (e.getSource() == resetButton) {
            mainWindow.resetBoard();
        } else if (e.getSource() == top10Button) {
            mainWindow.showTop10();
        } else if (e.getSource() == changePlayerButton) {
            mainWindow.changePlayer();
        }
    }
}
