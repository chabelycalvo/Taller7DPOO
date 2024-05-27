package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;

public class GameBoardPanel extends JPanel {

    private int gridSize = 5; // Tamaño por defecto del tablero

    public GameBoardPanel() {
        setPreferredSize(new Dimension(500, 500)); // Tamaño preferido del panel
    }

    public void setGridSize(int size) {
        this.gridSize = size;
        repaint();
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
                g2d.setColor(Color.YELLOW); // Color de las celdas
                g2d.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
                g2d.setColor(Color.BLACK); // Color de las líneas
                g2d.drawRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
            }
        }
    }
}
