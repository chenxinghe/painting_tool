package glgl.transactions;

import glgl.data.GLGLData;
import glgl.data.GLGLSetFunction;
import glgl.data.GLGLTextPrototype;
import java.time.LocalDate;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import jtps.jTPS_Transaction;
import tdlm.GLGLApp;
import static tdlm.GLGLPropertyType.TDLM_FONT_COLOR_PICKER;
import static tdlm.GLGLPropertyType.TDLM_FONT_COMBO_BOX;
import static tdlm.GLGLPropertyType.TDLM_FONT_SIZE_COMBO_BOX;
import static tdlm.GLGLPropertyType.TDLM_TEXT_DIALOG_CONTENT_LABEL;
import static tdlm.GLGLPropertyType.TDLM_TEXT_DIALOG_TITLE;


/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class Font_Transaction implements jTPS_Transaction {
    Node itemToEdit;
    GLGLData  data;
    String changeType;
    String changes;
    Color  color;
    Node oldItem;
    Paint oldcolor;
    Font oldfont;
    GLGLApp app=new GLGLApp();
    public Font_Transaction(        GLGLData  initData,
                                    Node initItemToEdit,
                                    String initChangeType,
                                    String initChange,
                                    Color initColor) {
        itemToEdit = initItemToEdit;
        data=initData;
        changeType=initChangeType;
        changes=initChange;
        color=initColor;
        oldfont=((GLGLTextPrototype)itemToEdit).getFont();
        oldcolor=((GLGLTextPrototype)itemToEdit).getFill();
        oldItem=initItemToEdit;
    }

    @Override
    public void doTransaction() {
       if(changeType.equals("font")){
          // ((GLGLTextPrototype)itemToEdit).setFont(Font.font(changes));
           ((GLGLTextPrototype)itemToEdit).setFont(Font.font(changes, ((GLGLTextPrototype)itemToEdit).getFontWeight(),((GLGLTextPrototype)itemToEdit).getItalic(), ((GLGLTextPrototype)itemToEdit).getFont().getSize()));
       }else if(changeType.equals("fontSize")){
           //((GLGLTextPrototype)itemToEdit).setFont(Font.font(Double.valueOf(changes)));
           ((GLGLTextPrototype)itemToEdit).setFont(Font.font(((GLGLTextPrototype)itemToEdit).getFont().toString(), ((GLGLTextPrototype)itemToEdit).getFontWeight(),((GLGLTextPrototype)itemToEdit).getItalic(), Double.valueOf(changes)));
       }else if(changeType.equals("bold")){
           ((GLGLTextPrototype)itemToEdit).setFont(Font.font(((GLGLTextPrototype)itemToEdit).getFont().toString(), FontWeight.findByName(changes),((GLGLTextPrototype)itemToEdit).getItalic(), ((GLGLTextPrototype)itemToEdit).getFont().getSize()));
       }else if(changeType.equals("italic")){
           ((GLGLTextPrototype)itemToEdit).setFont(Font.font(((GLGLTextPrototype)itemToEdit).getFont().toString(),((GLGLTextPrototype)itemToEdit).getFontWeight(), FontPosture.findByName(changes), ((GLGLTextPrototype)itemToEdit).getFont().getSize()));
       }else if (changeType.equals("color")){
          // System.out.println(color.toString());
           ((GLGLTextPrototype)itemToEdit).setFill(color);
       }else if(changeType.equals("addFontSize")){
           ((GLGLTextPrototype)itemToEdit).setFont(Font.font(Double.valueOf(changes)+2));
       }else if(changeType.equals("reduceFontSize")){
           ((GLGLTextPrototype)itemToEdit).setFont(Font.font(Double.valueOf(changes)-2));
       }
     
    }

    @Override
    public void undoTransaction() {
      ((GLGLTextPrototype)itemToEdit).setFont(oldfont);
      ((GLGLTextPrototype)itemToEdit).setFill(oldcolor);
      
      
      
      
    }
}