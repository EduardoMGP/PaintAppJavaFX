package br.com.paintbrush.dimensions.objects;

import br.com.paintbrush.dimensions.Dimension3D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class Cylinder extends Dimension3D {

    @Override
    public void draw(GraphicsContext graphicsContext, MouseEvent mouseEvent) {

        float weight = super.width();
        float height = super.height();
        float radius = weight / 2;

        float xInitial = super.getXInitial();
        float yInitial = super.getYInitial();
        float xFinal = super.getXFinal();
        float yFinal = super.getYFinal();

        graphicsContext.setStroke(super.getColor());
        graphicsContext.setLineWidth(super.getLineWidth());

        graphicsContext.strokeOval(xInitial, yInitial, weight, radius);
        graphicsContext.strokeOval(xInitial, yInitial + height, (radius * 2), radius);

        graphicsContext.strokeLine(xInitial, yInitial + (radius / 2), xInitial, yInitial + height + radius / 2);
        graphicsContext.strokeLine(xFinal, yInitial + (radius / 2), xFinal, yInitial + height + radius / 2);

        volume(radius);

    }

    public void volume(float radius) {
        float a = super.height();
        System.out.println("Volume do cilindro: " + (radius * radius * a * 3.14) + " m3");
    }

}
