package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.List;

public class MainWindow extends JFrame {

    private GameBoardPanel gameBoardPanel;
    private TopPanel topPanel;
    private BottomPanel bottomPanel;
    private int moveCount = 0;
    private ScoreManager scoreManager;

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
        RightPanel rightPanel = new RightPanel(this);
        bottomPanel = new BottomPanel();
        gameBoardPanel = new GameBoardPanel(this);

        scoreManager = new ScoreManager();

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

    public void createNewBoard() {
        int size = Integer.parseInt((String) topPanel.getSizeComboBox().getSelectedItem());
        // Puedes usar la dificultad aquí si tienes lógica para manejar la dificultad
        gameBoardPanel.setGridSize(size);
        bottomPanel.resetMoves();
        moveCount = 0;
    }

    public void resetBoard() {
        gameBoardPanel.resetBoard();
        bottomPanel.resetMoves();
        moveCount = 0;
    }

    public void showTop10() {
        JDialog top10Dialog = new JDialog(this, "Top 10 Puntajes", true);
        top10Dialog.setSize(300, 200);
        top10Dialog.setLocationRelativeTo(this);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        StringBuilder topScores = new StringBuilder("Top 10 Puntajes:\n");
        List<ScoreManager.Score> scores = scoreManager.getTopScores();
        for (ScoreManager.Score score : scores) {
            topScores.append(score.toString()).append("\n");
        }

        textArea.setText(topScores.toString());

        top10Dialog.add(new JScrollPane(textArea));
        top10Dialog.setVisible(true);
    }

    public void changePlayer() {
        String playerName = JOptionPane.showInputDialog(this, "Ingrese el nombre del jugador:");
        if (playerName != null && !playerName.trim().isEmpty()) {
            bottomPanel.setPlayerName(playerName);
        }
    }

    public void incrementMoveCount() {
        moveCount++;
        bottomPanel.updateMoveCount(moveCount);
    }

    public void checkGameOver() {
        if (gameBoardPanel.isBoardClear()) {
            String playerName = bottomPanel.getPlayerName();
            scoreManager.addScore(playerName, moveCount);
            JOptionPane.showMessageDialog(this, "¡Felicidades " + playerName + "! Has apagado todas las luces en " + moveCount + " jugadas.");
        }
    }

    public static void main(String[] args) {
        // Ejecuta la creación de la ventana en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            new MainWindow();
        });
    }
}
