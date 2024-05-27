package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class MainWindow extends JFrame {

    private GameBoardPanel gameBoardPanel;
    private TopPanel topPanel;

    public MainWindow() {
        // Configura el título de la ventana
        setTitle("Juego de LightsOut");

        // Configura el tamaño de la ventana
        setSize(800, 600);

        // Configura el comportamiento al cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establece la ubicación de la ventana en el centro de la pantalla
        setLocationRelativeTo(null);

        // Configura el layout de la ventana
        setLayout(new BorderLayout());

        // Crea los paneles
        topPanel = new TopPanel();
        RightPanel rightPanel = new RightPanel();
        BottomPanel bottomPanel = new BottomPanel();
        gameBoardPanel = new GameBoardPanel();

        // Agrega los paneles a la ventana
        add(topPanel, BorderLayout.NORTH);
        add(rightPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);
        add(gameBoardPanel, BorderLayout.CENTER);

        // Añadir un listener para cambiar el tamaño del tablero según el JComboBox
        topPanel.getSizeComboBox().addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedSize = (String) e.getItem();
                int newSize = Integer.parseInt(selectedSize.substring(0, 1));
                gameBoardPanel.setGridSize(newSize);
            }
        });

        // Haz visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        // Ejecuta la creación de la ventana en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            new MainWindow();
        });
    }
}
