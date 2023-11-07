package br.com.paintbrush.dimensions.objects;

import br.com.paintbrush.dimensions.Dimension1D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

import java.util.Random;

public class Spray extends Dimension1D {

    private int dispersal = 5;

    @Override
    public void draw(GraphicsContext graphicsContext, MouseEvent mouseEvent) {
        Random random = new Random();

        int radius = (int)(5 * this.getLineWidth());
        int maxX = (int) getXInitial() + radius;
        int minX = (int) getXInitial() - radius;
        int maxY = (int) getYInitial() + radius;
        int minY = (int) getYInitial() - radius;

        graphicsContext.setFill(super.getColor());
        graphicsContext.setLineWidth(super.getLineWidth());

        for (int i = 0; i < dispersal; i++) {
            int valX = random.nextInt((maxX - minX)) + minX;
            int valY = random.nextInt((maxY - minY)) + minY;
            double distance = Math.sqrt(Math.pow(super.getXInitial() - valX, 2) + Math.pow(super.getYInitial() - valY, 2));
            if (distance <= radius)
                graphicsContext.fillOval(valX, valY, random.nextInt(3), random.nextInt(3));
        }

        setXInitial((float) mouseEvent.getX());
        setYInitial((float) mouseEvent.getY());
    }

    public void setDispersal(int dispersal) {
        this.dispersal = dispersal;
    }
}
