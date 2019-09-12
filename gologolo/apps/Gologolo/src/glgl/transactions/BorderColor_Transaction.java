package glgl.transactions;

import glgl.data.GLGLData;
import glgl.data.GLGLSetFunction;
import java.time.LocalDate;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import jtps.jTPS_Transaction;
import tdlm.GLGLApp;
import static tdlm.GLGLPropertyType.TDLM_TEXT_DIALOG_CONTENT_LABEL;
import static tdlm.GLGLPropertyType.TDLM_TEXT_DIALOG_TITLE;


/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class BorderColor_Transaction implements jTPS_Transaction {
    Node item;
    GLGLData  data;
    Color color;
    Color oldColor;
    public BorderColor_Transaction(     
                                    GLGLData  initData,
                                    Node initItemToEdit,
                                    Color initColor) {
        item = initItemToEdit;
        data=initData;
        color=initColor;
        oldColor=(Color)(((GLGLSetFunction)item).getStroke());
    }

    @Override
    public void doTransaction() {
       ((GLGLSetFunction)item).setStroke((Paint)color);
//       app.getGUIModule().g
       
       
    }

    @Override
    public void undoTransaction() {
      ((GLGLSetFunction)item).setStroke((Paint)oldColor);
       //itemToEdit.setName(oldName);
    }
}