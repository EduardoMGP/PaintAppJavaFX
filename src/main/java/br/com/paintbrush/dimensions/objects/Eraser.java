package br.com.paintbrush.dimensions.objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Eraser extends Point {

    @Override
    public void draw(GraphicsContext graphicsContext, MouseEvent mouseEvent) {
        super.setColor(Color.WHITE);
        super.draw(graphicsContext, mouseEvent);
    }

}
