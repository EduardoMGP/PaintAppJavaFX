package br.com.paintbrush.dimensions;

import javafx.scene.canvas.GraphicsContext;

public abstract class Dimension2D extends Dimension1D {

    private float xFinal;
    private float yFinal;

    abstract public void fill(GraphicsContext graphicsContext);


    public void setXFinal(float xFinal) {
        this.xFinal = xFinal;
    }

    public void setYFinal(float yFinal) {
        this.yFinal = yFinal;
    }

    public float getXFinal() {
        float xFinal = this.xFinal;
        float xInitial = super.getXInitial();
        return Math.max(xFinal, xInitial);
    }

    public float getYFinal() {
        float yFinal = this.yFinal;
        float yInitial = super.getYInitial();
        return Math.max(yFinal, yInitial);
    }

    @Override
    public float getXInitial() {
        float xFinal = this.xFinal;
        float xInitial = super.getXInitial();
        return Math.min(xFinal, xInitial);
    }

    @Override
    public float getYInitial() {
        float yFinal = this.yFinal;
        float yInitial = super.getYInitial();
        return Math.min(yFinal, yInitial);
    }

    public float height() {
        float height = this.yFinal - super.getYInitial();
        return height < 0 ? height * -1 : height;
    }

    public float width() {
        float width = this.xFinal - super.getXInitial();
        return width < 0 ? width * -1 : width;
    }
}
