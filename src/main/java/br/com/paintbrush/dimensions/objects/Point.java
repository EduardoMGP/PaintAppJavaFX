package br.com.paintbrush.dimensions.objects;

import br.com.paintbrush.dimensions.Dimension1D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;

public class Point extends Dimension1D {
    public void draw(GraphicsContext graphicsContext, MouseEvent mouseEvent){

        graphicsContext.beginPath();
        graphicsContext.setLineWidth(super.getLineWidth());
        graphicsContext.setStroke(super.getColor());
        graphicsContext.moveTo(super.getXInitial(), super.getYInitial());
        graphicsContext.lineTo(mouseEvent.getX(), mouseEvent.getY());
        graphicsContext.setLineJoin(StrokeLineJoin.ROUND);
        graphicsContext.setLineCap(StrokeLineCap.ROUND);
        graphicsContext.stroke();

        super.setXInitial((int) mouseEvent.getX());
        super.setYInitial((int) mouseEvent.getY());

    }

}
