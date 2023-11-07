package br.com.paintbrush.dimensions.objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

interface IDimension {
    void draw(GraphicsContext graphicsContext, MouseEvent mouseEvent, Color color);
}
