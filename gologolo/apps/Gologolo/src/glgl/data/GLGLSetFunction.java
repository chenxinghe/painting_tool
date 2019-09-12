/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glgl.data;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.paint.RadialGradient;
import javafx.scene.text.Font;

/**
 *
 * @author chenxing he
 */
public interface GLGLSetFunction {
    public static final String RECTANGLE_TYPE="RECTANGLE";
    public static final String TEXT_TYPE="TEXT";
    public static final String CIRCLE_TYPE="CIRCLE";
    public static final String IMAGE_TYPE="IMAGE";
    public static final String DEFAULT_ORDER="0";
    public static final String DEFAULT_TEXT_NAME="TEXT NAME";
    public static final String DEFAULT_RECTANGLE_NAME="RECTANGLE NAME";
    public static final String DEFAULT_CIRCLE_NAME="CIRCLE NAME";
    public static final String DEFAULT_IMAGE_NAME="IMAGE";
    
    public GLGLSetFunction Clone();
    public void drag(double x,double y);
    public double getX();
    public double getY();
    public double getWidth();
    public double getHeight();
    public void setLocation(double x,double y);
    public void setSize(double initWidth, double initHeight);
    public String getType();
    public String getOrder();
    public String getName();
    public Paint getFillColor();
    public Paint getStroke();
//    public double getStrokeThickness();
    public Color  getStrokeColor();
//    public double getStrokeRadius();
    public double getArcHeight();
    public void  setStroke(Paint value);
    public String getContent();
    public void setOrder(String value);
    public void setName(String value);
    public double getRadius();
    public void setStrokeWidth(double value);
    public double getStrokeWidth();
    public RadialGradient getColorGradient();
    public void setColorGradient(RadialGradient value);
    public String getImagePath();
    public Font getFont();
    public double getFontSize();
    public String getStyle();
    
    
    
    

        
    
    
    
    
    
    
}
