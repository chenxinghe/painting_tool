/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glgl.data;

import static glgl.data.GLGLSetFunction.DEFAULT_ORDER;
import static glgl.data.GLGLSetFunction.DEFAULT_RECTANGLE_NAME;
import static glgl.data.GLGLSetFunction.RECTANGLE_TYPE;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Paint;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import properties_manager.PropertiesManager;

/**
 *
 * @author chenxing he
 */
public  class GLGLCirclePrototype extends Circle implements GLGLSetFunction{
    final StringProperty order=new SimpleStringProperty(DEFAULT_ORDER);;
    final StringProperty name=new SimpleStringProperty(DEFAULT_CIRCLE_NAME);
    final StringProperty type=new SimpleStringProperty(CIRCLE_TYPE);
    double centerX=50.00;
    double centerY=50.00;
    double radius=40.00;
    RadialGradient colortype;
   String imagePath="\"filepath\":\"file:/C:/";
    public GLGLCirclePrototype(){
        setLocation(centerX, centerY);
        setRadius(radius);
        setStroke(Color.BLACK);
        
         colortype= new RadialGradient(             1,
                                                                        0,
                                                                        centerX,
                                                                        centerY,
                                                                        50,
                                                                        false,
                                                                        CycleMethod.NO_CYCLE,
                                                                        new Stop(0, Color.RED),
                                                                        new Stop(1, Color.RED));
        setFill(colortype);
    
                                                                                                                                                               
    }
    public GLGLCirclePrototype(String initorder,String initname,double initcenterX,double initcenterY,double initRadius,
                                                    double initStrokeWidth,Color initstrokeColor,RadialGradient initcolorGradient){
        setOrder(initorder);
        setName(initname);
        //setType(type);
        //setType(inittype);
        setLocation(initcenterX, initcenterY);
        setRadius(initRadius);
        setStrokeWidth(initStrokeWidth);
        setStroke((Color)initstrokeColor);
        setColorGradient(initcolorGradient);
    }

   
    public GLGLCirclePrototype Clone() {
        GLGLCirclePrototype circle =new GLGLCirclePrototype();
        circle.setStroke(getStroke());
        circle.setFill(getFill());
        circle.setCenterX(50.00);
        circle.setCenterY(50.00);
        circle.setFill(getFill());
        circle.setStroke(getStroke());
        circle.setStrokeWidth(getStrokeWidth());
        circle.setColorGradient(getColorGradient());
        return circle;
    }


   
    public void drag(Double x, Double y) {
        setLocation(x, y);
         colortype=new RadialGradient(getColorGradient().getFocusAngle(),
                                            getColorGradient().getFocusDistance(),
                                             getColorGradient().getCenterX(),
                                             getColorGradient().getCenterY(),
                                            getColorGradient().getRadius(),
                                             false,
                                            getColorGradient().getCycleMethod(),
                                            new Stop(0,getColorGradient().getStops().get(0).getColor()) ,
                                            new Stop(1,getColorGradient().getStops().get(1).getColor()));
            setColorGradient(colortype);
    }

    
 
    public double getX() {
        return centerX;
    }

   
    public double getY() {
        return centerY;
    }

    
    public void setLocation(double x,double y) {
        centerXProperty().set(x);
        centerYProperty().set(y);
        centerX=x;
        centerY=y;
    }

    
    public void setSize(double initWidth,double initHeight) {
        
    }

    
    public String getType() {
       return type.get();
    }


    public String getOrder() {
        return order.get();
    }

    public void setOrder(String value) {
        order.set(value);
    }


    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }
        public StringProperty nameProperty() {
        return name;
    }

   
    
    
//    public String getType() {
//        return type;
//    }
    
    public void setType(String value) {
        type.set(value);
    }


    @Override
    public void drag(double x, double y) {
        setLocation(x, y);
        centerX=x;
        centerY=y;
    }

    @Override
    public Paint getFillColor() {
         return Color.RED;
    }

    @Override
    public String getContent() {
        return " ";
    }

    @Override
    public double getWidth() {
        return 0.00;
    }

    @Override
    public double getHeight() {
        return 0.00;
    }

    @Override
    public RadialGradient getColorGradient() {
        return colortype;
    }
    public void setColorGradient(RadialGradient value){
        colortype=value;
        setFill(value);
    }

    @Override
    public double getArcHeight() {
        return 0.00;
    }

    @Override
    public Color getStrokeColor() {
        return (Color)getStroke();
    }

    @Override
    public String getImagePath() {
       return imagePath;
    }

    @Override
    public Font getFont() {
        return Font.font(" ");
    }

    @Override
    public double getFontSize() {
       return 0.00;
    }

}
