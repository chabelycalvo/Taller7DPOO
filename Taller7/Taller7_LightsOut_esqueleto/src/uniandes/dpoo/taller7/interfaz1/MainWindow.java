package uniandes.dpoo.taller7.interfaz1;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



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

