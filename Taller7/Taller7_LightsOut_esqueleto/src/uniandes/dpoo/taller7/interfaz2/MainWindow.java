package uniandes.dpoo.taller7.interfaz2;


import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

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

        // Agrega los paneles a la ventana
        add(new TopPanel(), BorderLayout.NORTH);
        add(new RightPanel(), BorderLayout.EAST);
        add(new BottomPanel(), BorderLayout.SOUTH);

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

