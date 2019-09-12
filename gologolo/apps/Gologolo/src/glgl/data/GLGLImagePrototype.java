/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glgl.data;

import static glgl.data.GLGLSetFunction.DEFAULT_ORDER;
import static glgl.data.GLGLSetFunction.DEFAULT_RECTANGLE_NAME;
import static glgl.data.GLGLSetFunction.RECTANGLE_TYPE;
import java.io.File;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

/**
 *
 * @author chenxing he
 */
public  class GLGLImagePrototype extends ImageView implements GLGLSetFunction{
    final StringProperty order=new SimpleStringProperty(DEFAULT_ORDER);;
    final StringProperty name=new SimpleStringProperty(DEFAULT_IMAGE_NAME);
    final StringProperty type=new SimpleStringProperty(IMAGE_TYPE);
    
    double x=10.00;
    double y=10.00;
    Image image;
    String imagePath;
    
     RadialGradient colortype= new RadialGradient(  1,
                                        1,
                                        1,
                                        1,
                                        1,
                                        false,
                                        CycleMethod.NO_CYCLE,
                                        new Stop(0, Color.YELLOW),
                                        new Stop(1, Color.GREEN));
    
    public GLGLImagePrototype(){
        setLocation(x, y);
    
       
        
        
        
    }
    public GLGLImagePrototype(String initorder,String initname,double initcanterX,double initcanterY,String initimagePath){
        order.set(initorder);
        name.set(initname);
        setLocation(initcanterX, initcanterY);
        setImagePath(initimagePath);
        setImage(new Image(initimagePath));
    }

   
    public GLGLImagePrototype Clone() {
        GLGLImagePrototype image=new GLGLImagePrototype(); 
        image.setX(10.00);
        image.setY(10.00);
        image.setImage(getImage());
        image.setImagePath(getImagePath());
  
        return image;
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
//
//    public void setImage(Image initImage){
//        image=initImage;
//    }
//    public Image getImage(){
//        return image;
//    }
    public String getImagePath(){
        return imagePath;
    }
    public void setImagePath(String path){
        imagePath=path;
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

    public void setType(String value) {
        type.set(value);
    }


    @Override
    public void drag(double initx, double inity) {
        setLocation(initx, inity);
        x=initx;
        y=inity;
    }

    @Override
    public Paint getFillColor() {
        return (Paint)Color.BLUE;
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
    public double getWidth() {
       return 0.00;
    }

    @Override
    public double getHeight() {
        return 0.00;
    }

    @Override
    public Paint getStroke() {
        return null;
    }

    @Override
    public void setStroke(Paint value) {

    }

    @Override
    public void setStrokeWidth(double value) {
       
    }

    @Override
    public double getStrokeWidth() {
        return 0.00;
    }

    @Override
    public RadialGradient getColorGradient() {
        return colortype;
    }

    @Override
    public void setColorGradient(RadialGradient value) {
       
    }

    @Override
    public double getArcHeight() {
        return 0.00;
    }

    @Override
    public Color getStrokeColor() {
       return Color.TRANSPARENT;
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
