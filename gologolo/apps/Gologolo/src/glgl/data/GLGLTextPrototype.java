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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javax.swing.text.Style;
import properties_manager.PropertiesManager;

/**
 *
 * @author chenxing he
 */
public class GLGLTextPrototype extends Text implements GLGLSetFunction{
   final StringProperty order=new SimpleStringProperty(DEFAULT_ORDER);;
    final StringProperty name=new SimpleStringProperty(DEFAULT_TEXT_NAME);
    final StringProperty type=new SimpleStringProperty(TEXT_TYPE);
    double canterX=20.00;
    double canterY=20.00;
    public String content=" ";
   RadialGradient colortype= new RadialGradient(  1,
                                        1,
                                        1,
                                        1,
                                        1,
                                        false,
                                        CycleMethod.NO_CYCLE,
                                        new Stop(0, Color.YELLOW),
                                        new Stop(1, Color.YELLOW));
    
    String imagePath="\"filepath\":\"file:/C:/";
    
    public GLGLTextPrototype(String initText){
        super(initText);
        setLocation(canterX, canterY);
        content=initText;
        setStroke((Paint)Color.BLACK);
       String imagePath="agergwgag";
        setFont(Font.font(24));
        
    }
    public GLGLTextPrototype(String initorder,String initname,String initContent,double initcanterX,double initcanterY,Paint fill,String initfont,double initfontSize,String initstyle){
        setOrder(initorder);
        setName(initname);
 //       setType(inittype);
        setContent(initContent);
        setLocation(initcanterX, initcanterY);
        setFill(fill);
        setStroke((Paint)Color.TRANSPARENT);
        setFont(Font.font(initfont, initfontSize));
        setStyle(initstyle);
        
    }   
   
    public GLGLTextPrototype Clone() {
        GLGLTextPrototype text =new GLGLTextPrototype(getText());
        text.setStroke(getStroke());
        text.setFill(getFill());
        text.setFont(getFont());
        text.setX(20.00);
        text.setY(20.00);
        text.setContent(getContent());
        return text;
    }
   
    public void drag(Double x, Double y) {
        
        xProperty().set(x);
        yProperty().set(y);
        canterX = x;
        canterY = y;
    }

    
 
    public double getCanterX() {
        return canterX;
    }

   
    public double getCanterY() {
        return canterY;
    }

  
    public double getWidth() {
        return 0.00;
    }


    public double getHeight() {
        return 0.00;
    }

    
    public void setLocation(double x,double y) {
        this.yProperty().set(y);
        this.xProperty().set(x);
        canterX=x;
        canterY=y;
    }

    
    public void setSize(double initWidth,double initHeight) {
        initWidth=initWidth;
        initHeight=initHeight;
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
//    
//    public void setType(String value) {
//        type=value;
//    }

    @Override
    public void drag(double x, double y) {
        setLocation(x, y);
        canterX=x;
        canterY=y;
    }

    @Override
    public Paint getFillColor() {
        return  getFill();
    }


    @Override
    public String getContent() {
        return content;
    }
    public void setContent(String value){
        setText(value);
        content=value;
    }
    @Override
    public double getRadius() {
        return 0.00;
    }
    public FontPosture getItalic(){
        if(this.getFont().getStyle().contains("Italic")){
            return FontPosture.ITALIC;
        }
        return FontPosture.REGULAR;
    }
    
    public FontPosture getAntiItalic(){
        if(this.getFont().getStyle().contains("Italic")){
            return FontPosture.REGULAR;
        }
        return FontPosture.ITALIC;
    }
    public  FontWeight getAntiFontWeight(){
        if(this.getFont().getStyle().contains("Bold")){
            return FontWeight.NORMAL;
        }
        return FontWeight.BOLD;
    }
    public  FontWeight getFontWeight(){
        if(this.getFont().getStyle().contains("Bold")){
            return FontWeight.BOLD;
        }
        return FontWeight.NORMAL;
    }

    @Override
    public RadialGradient getColorGradient() {
       return colortype;
    }
     @Override
    public void setColorGradient(RadialGradient value){
 
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
    public double getFontSize() {
        return getFont().getSize();
    }



    

   
    

    
    
}
