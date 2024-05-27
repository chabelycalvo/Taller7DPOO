package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class GameBoardPanel extends JPanel implements MouseListener {

    private int gridSize = 5; // Tamaño por defecto del tablero
    private boolean[][] boardState; // Estado del tablero
    private MainWindow mainWindow; // Referencia a la ventana principal

    public GameBoardPanel(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setPreferredSize(new Dimension(500, 500)); // Tamaño preferido del panel
        setBackground(Color.BLACK); // Cambia el fondo del panel
        addMouseListener(this); // Agrega el MouseListener al panel
        initializeBoard(gridSize); // Inicializa el tablero
    }

    public void setGridSize(int size) {
        this.gridSize = size;
        initializeBoard(size); // Re-inicializa el tablero con el nuevo tamaño
        repaint(); // Redibuja el tablero
    }

    private void initializeBoard(int size) {
        boardState = new boolean[size][size]; // Crea la matriz booleana para almacenar el estado del tablero
        Random random = new Random();
        // Inicializa el tablero con algunas celdas aleatoriamente encendidas
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                boardState[row][col] = random.nextBoolean();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        int cellWidth = width / gridSize;
        int cellHeight = height / gridSize;

        // Dibuja el tablero de juego
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                // Determina el color de la celda basada en su estado (encendida/apagada)
                if (boardState[row][col]) {
                    g2d.setColor(Color.YELLOW); // Color de las celdas encendidas
                } else {
                    g2d.setColor(Color.GRAY); // Color de las celdas apagadas
                }
                g2d.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
                g2d.setColor(Color.BLACK); // Color de las líneas
                g2d.drawRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int width = getWidth();
        int height = getHeight();
        int cellWidth = width / gridSize;
        int cellHeight = height / gridSize;

        int col = e.getX() / cellWidth;
        int row = e.getY() / cellHeight;

        // Cambia el estado de la celda clicada y sus celdas adyacentes
        toggleCell(row, col);
        mainWindow.incrementMoveCount(); // Incrementa el contador de jugadas
        mainWindow.checkGameOver(); // Verifica si el juego ha terminado
        repaint(); // Redibuja el tablero para reflejar los cambios
    }

    private void toggleCell(int row, int col) {
        if (row >= 0 && row < gridSize && col >= 0 && col < gridSize) {
            boardState[row][col] = !boardState[row][col]; // Cambia el estado de la celda clicada
            // Cambia el estado de las celdas adyacentes
            if (row > 0) boardState[row - 1][col] = !boardState[row - 1][col];
            if (row < gridSize - 1) boardState[row + 1][col] = !boardState[row + 1][col];
            if (col > 0) boardState[row][col - 1] = !boardState[row][col - 1];
            if (col < gridSize - 1) boardState[row][col + 1] = !boardState[row][col + 1];
        }
    }

    public boolean isBoardClear() {
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (boardState[row][col]) {
                    return false; // Si alguna celda está encendida, el tablero no está limpio
                }
            }
        }
        return true; // Todas las celdas están apagadas
    }

    public void resetBoard() {
        initializeBoard(gridSize); // Re-inicializa el tablero
        repaint(); // Redibuja el tablero
    }

    // Métodos vacíos para los otros eventos del MouseListener
    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
