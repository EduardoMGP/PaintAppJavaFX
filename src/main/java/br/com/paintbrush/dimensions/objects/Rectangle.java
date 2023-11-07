package br.com.paintbrush.dimensions.objects;

import br.com.paintbrush.dimensions.Dimension2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class Rectangle extends Dimension2D {

    @Override
    public void draw(GraphicsContext graphicsContext, MouseEvent mouseEvent) {

        float xInitial = getXInitial();
        float yInitial = getYInitial();
        float xFinal = getXFinal();
        float yFinal = getYFinal();

        graphicsContext.setLineWidth(super.getLineWidth());
        graphicsContext.setStroke(super.getColor());
        graphicsContext.strokeRect(xInitial, yInitial, xFinal - xInitial, yFinal - yInitial);
    }

    @Override
    public void fill(GraphicsContext graphicsContext) {

        float offset = super.getLineWidth() / 2;

        graphicsContext.setLineWidth(super.getLineWidth());
        graphicsContext.setFill(super.getFillColor());
        graphicsContext.fillRect(
                super.getXInitial() + offset, super.getYInitial() + offset,
                super.width() - super.getLineWidth(), super.height() - super.getLineWidth()
        );
        graphicsContext.fill();

        this.area();
    }

    public void area() {
        System.out.println("Area do retângulo " + (super.height() * width()));
    }

}
