package br.com.paintbrush.dimensions;

import javafx.scene.paint.Color;

public abstract class Dimension1D implements IDimension {

    private float xInitial;
    private float yInitial;
    private Color color = Color.BLACK;
    private Color fillColor = Color.TRANSPARENT;
    private float lineWidth = 1;

    @Override
    public void setXInitial(float xInitial) {
        this.xInitial = xInitial;
    }

    @Override
    public void setYInitial(float yInitial) {
        this.yInitial = yInitial;
    }

    @Override
    public float getXInitial() {
        return this.xInitial;
    }

    @Override
    public float getYInitial() {
        return this.yInitial;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public Color getFillColor() {
        return this.fillColor;
    }

    @Override
    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    @Override
    public float getLineWidth() {
        return this.lineWidth;
    }
}
