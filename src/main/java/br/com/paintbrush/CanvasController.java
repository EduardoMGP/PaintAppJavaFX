package br.com.paintbrush;

import br.com.paintbrush.dimensions.Dimension2D;
import br.com.paintbrush.dimensions.Dimension3D;
import br.com.paintbrush.dimensions.IDimension;
import br.com.paintbrush.dimensions.objects.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;

public class CanvasController {

    public Canvas canvas;

    public ColorPicker lineColor;
    public Slider lineWidth;
    public Slider dispersalSpray;
    public ColorPicker fillColor;
    public Button point;
    public Button spray;
    public Button rectangle;
    public Button circle;
    public Button cylinder;
    public Button pyramid;
    public Button eraser;


    private ObjectType objectType = ObjectType.POINT;
    private IDimension object;

    private boolean drawing = false;

    public void initialize() {
        canvas.setOnMousePressed(this::onMousePressed);
        canvas.setOnMouseReleased(this::onMouseReleased);
        canvas.setOnMouseClicked(this::onMouseClicked);
        canvas.setOnMouseDragged(this::onMouseDragged);

        fillColor.setValue(javafx.scene.paint.Color.TRANSPARENT);
        lineColor.setValue(javafx.scene.paint.Color.BLACK);
        lineWidth.setValue(2);
        lineWidth.maxHeight(50);
        lineWidth.minHeight(1);

        dispersalSpray.setValue(50);
        dispersalSpray.maxHeight(1000);
        dispersalSpray.minHeight(10);

        startPoint();
    }

    public void onMouseClicked(MouseEvent mouseEvent) {
        if (drawing && object != null)
            if (objectType == ObjectType.POINT || objectType == ObjectType.SPRAY)
                object.draw(canvas.getGraphicsContext2D(), mouseEvent);
    }

    public void onMouseDragged(MouseEvent mouseEvent) {
        if (drawing && object != null)
            if (objectType == ObjectType.POINT || objectType == ObjectType.SPRAY || objectType == ObjectType.ERASER)
                object.draw(canvas.getGraphicsContext2D(), mouseEvent);
    }

    public void onMousePressed(MouseEvent mouseEvent) {

        drawing = true;
        object.setYInitial((int) mouseEvent.getY());
        object.setXInitial((int) mouseEvent.getX());
        object.setColor(lineColor.getValue());
        object.setFillColor(fillColor.getValue());
        object.setLineWidth((float) lineWidth.getValue());
        if (object instanceof Spray) {
            ((Spray) object).setDispersal((int) dispersalSpray.getValue());
        }

        if (objectType == ObjectType.SPRAY || objectType == ObjectType.POINT || objectType == ObjectType.ERASER)
            object.draw(canvas.getGraphicsContext2D(), mouseEvent);

    }

    public void onMouseReleased(MouseEvent mouseEvent) {

        if (objectType == ObjectType.RECTANGLE || objectType == ObjectType.CIRCLE) {

            Dimension2D rectangle = (Dimension2D) object;

            rectangle.setXFinal((int) mouseEvent.getX());
            rectangle.setYFinal((int) mouseEvent.getY());

            rectangle.draw(canvas.getGraphicsContext2D(), mouseEvent);
            rectangle.fill(canvas.getGraphicsContext2D());

        }

        if (objectType == ObjectType.CYLINDER || objectType == ObjectType.PYRAMID) {

            Dimension3D dimension3D = (Dimension3D) object;

            dimension3D.setXFinal((int) mouseEvent.getX());
            dimension3D.setYFinal((int) mouseEvent.getY());

            dimension3D.draw(canvas.getGraphicsContext2D(), mouseEvent);

        }

        drawing = false;
    }

    public void startCircle() {
        objectType = ObjectType.CIRCLE;
        object = new Circle();

        updateButtons(this.circle);
    }

    public void startPoint() {
        objectType = ObjectType.POINT;
        object = new Point();

        updateButtons(this.point);
    }

    public void startSquare() {
        objectType = ObjectType.RECTANGLE;
        object = new Rectangle();

        updateButtons(this.rectangle);
    }

    public void startCylinder() {
        objectType = ObjectType.CYLINDER;
        object = new Cylinder();

        updateButtons(this.cylinder);
    }

    public void startPyramid() {
        objectType = ObjectType.PYRAMID;
        object = new Pyramid();

        updateButtons(this.pyramid);
    }

    public void startSpray() {
        Spray spray = new Spray();
        spray.setDispersal((int) dispersalSpray.getValue());
        objectType = ObjectType.SPRAY;
        object = spray;

        updateButtons(this.spray);
    }

    public void startEraser() {
        objectType = ObjectType.ERASER;
        object = new Eraser();
    }

    public void clearAll() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void updateButtons(Button currentButton) {

        point.setBorder(null);
        spray.setBorder(null);
        rectangle.setBorder(null);
        circle.setBorder(null);
        cylinder.setBorder(null);
        pyramid.setBorder(null);
        eraser.setBorder(null);

        currentButton.setBorder(new Border(
                new javafx.scene.layout.BorderStroke(
                        javafx.scene.paint.Color.BLACK,
                        javafx.scene.layout.BorderStrokeStyle.SOLID,
                        null,
                        new javafx.scene.layout.BorderWidths(2)
                )
        ));
    }
}
