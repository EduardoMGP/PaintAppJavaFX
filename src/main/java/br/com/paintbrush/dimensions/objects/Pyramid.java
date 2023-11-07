package br.com.paintbrush.dimensions.objects;

import br.com.paintbrush.dimensions.Dimension3D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class Pyramid extends Dimension3D {

    @Override
    public void draw(GraphicsContext graphicsContext, MouseEvent mouseEvent) {

        float weight = super.width();
        float height = super.height();
        float xInitial = super.getXInitial();
        float yInitial = super.getYInitial();

        graphicsContext.setStroke(super.getColor());
        graphicsContext.setLineWidth(super.getLineWidth());

        graphicsContext.strokeLine(xInitial, yInitial, xInitial + weight / 2, yInitial - height);
        graphicsContext.strokeLine(xInitial, getYFinal(), xInitial + weight / 2, yInitial - height);

        graphicsContext.strokeLine(xInitial + weight, yInitial, xInitial + weight / 2, yInitial - height);
        graphicsContext.strokeLine(xInitial + weight, getYFinal(), xInitial + weight / 2, yInitial - height);

        graphicsContext.strokeRect(xInitial, yInitial, weight, height);

        volume();
    }

    public void volume() {
        float areaB = super.height() * super.width();
        System.out.println("Volume da piramide: " + ((areaB * height()) / 3) + " m3");
    }
}
