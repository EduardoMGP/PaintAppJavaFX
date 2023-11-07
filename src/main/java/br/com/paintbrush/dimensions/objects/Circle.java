package br.com.paintbrush.dimensions.objects;

import br.com.paintbrush.dimensions.Dimension2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class Circle extends Dimension2D {

    @Override
    public void draw(GraphicsContext graphicsContext, MouseEvent mouseEvent) {

        float xInitial = getXInitial();
        float yInitial = getYInitial();
        float xFinal = getXFinal();
        float yFinal = getYFinal();

        graphicsContext.setStroke(super.getColor());
        graphicsContext.setLineWidth(super.getLineWidth());
        graphicsContext.strokeOval(xInitial, yInitial, xFinal - xInitial, yFinal - yInitial);
    }

    @Override
    public void fill(GraphicsContext graphicsContext) {
        graphicsContext.setFill(super.getFillColor());
        graphicsContext.fillOval(
                super.getXInitial() + 1, super.getYInitial() + 1,
                super.width() - 2, super.height() - 2
        );
        graphicsContext.fill();

        this.area();
    }

    public void area() {
        System.out.println("Area do círculo " + (Math.PI * Math.pow(super.height(), 2)));
    }
}
