/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glgl.data;

import djf.AppTemplate;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Paint;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import properties_manager.PropertiesManager;
import static tdlm.GLGLPropertyType.TDLM_CANTER_X_Slider;
import static tdlm.GLGLPropertyType.TDLM_CANTER_Y_Slider;

/**
 *
 * @author chenxing he
 */
public  class GLGLRectanglePrototype extends Rectangle implements GLGLSetFunction{
    final StringProperty order=new SimpleStringProperty(DEFAULT_ORDER);;
    final StringProperty name=new SimpleStringProperty(DEFAULT_RECTANGLE_NAME);
    final StringProperty type=new SimpleStringProperty(RECTANGLE_TYPE);
    AppTemplate app;
//    public String name =DEFAULT_RECTANGLE_NAME;
//    public String order =DEFAULT_ORDER;
//    public String type =RECTANGLE_TYPE;
    double x=10.00;
    double y=10.00;
    double width=100.00;
    double height=100.00;
    RadialGradient colortype;
    String imagePath="\"filepath\":\"file:/C:/";
    
    public GLGLRectanglePrototype(){
        setLocation(x, y);
        setWidth(width);
        setHeight(height);
        setStroke(Color.BLACK);
        //setFill(Color.RED);
//        setColorGradient(colortype);
         colortype= new RadialGradient(  1,
                                        0,
                                        x+0.5*getWidth(),
                                        y+0.5*getHeight(),
                                        50,
                                        false,
                                        CycleMethod.NO_CYCLE,
                                        new Stop(0, Color.YELLOW),
                                        new Stop(1, Color.YELLOW));
        setFill(colortype);
         String imagePath="agergwgag";
                                                                                                                                            
    }
    public GLGLRectanglePrototype(String initorder,String initname,double initcanterX,double initcanterY,double initwidth,double initheight,
                                                            double initStrokeWidth,Color initstrokeColor,double initstrokeRadius,RadialGradient initcolorGradient){
        order.set(initorder);
        name.set(initname);
        //setType(type);
        //setType(inittype);
        setLocation(initcanterX, initcanterY);
        setSize(initwidth, initheight);
        setStrokeWidth(initStrokeWidth);
        setStroke((Paint)initstrokeColor);
        setArcHeight(initstrokeRadius);
        setArcWidth(initstrokeRadius);
        setColorGradient(initcolorGradient);
    }

   public GLGLRectanglePrototype(double initcanterX,double initcanterY,double initwidth,double initheight){
        setLocation(initcanterX, initcanterY);
        setSize(initwidth, initheight);
   }
    
    public GLGLRectanglePrototype Clone() {
        GLGLRectanglePrototype rectangle=new GLGLRectanglePrototype();
        rectangle.setStroke(getStroke());
        rectangle.setFill(getFill());
        rectangle.setX(10.00);
        rectangle.setY(10.00);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        rectangle.setFill(getFill());
        rectangle.setStroke(getStroke());
        rectangle.setStrokeWidth(getStrokeWidth());
        rectangle.setArcHeight(getArcHeight());
        rectangle.setArcWidth(getArcWidth());
        rectangle.setColorGradient(getColorGradient());
        return rectangle;
    }

   
    public void drag(Double initx, Double inity) {
        setLocation(initx, inity);
       
    }


    
    public void setLocation(double initx,double inity) {
        setX(initx);
        setY(inity);
        x=initx;
        y=inity;
    }

    
    public void setSize(double initWidth,double initHeight) {
        setWidth(initWidth);
        setHeight(initHeight);
        widthProperty().set(initWidth);
        heightProperty().set(initHeight);
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
    public void drag(double initx, double inity) {
        setLocation(initx, inity);
        x=initx;
        y=inity;
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

    @Override
    public Paint getFillColor() {
        return Color.RED;
    }

    @Override
    public String getContent() {
        return " ";
    }

    @Override
    public double getRadius() {
        return 0.00;
    }

    @Override
    public RadialGradient getColorGradient() {
        return colortype;
    }
    @Override
    public void setColorGradient(RadialGradient value){
        colortype=value;
        setFill(value);
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
