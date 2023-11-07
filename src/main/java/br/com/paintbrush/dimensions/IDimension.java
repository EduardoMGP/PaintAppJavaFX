package br.com.paintbrush.dimensions;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public interface IDimension {
    void draw(GraphicsContext graphicsContext, MouseEvent mouseEvent);

    void setXInitial(float xInitial);
    void setYInitial(float yInitial);
    void setColor(Color color);
    void setFillColor(Color fillColor);
    void setLineWidth(float lineWidth);
    float getXInitial();
    float getYInitial();
    Color getColor();
    Color getFillColor();
    float getLineWidth();

}
