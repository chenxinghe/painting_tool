package glgl.transactions;

import glgl.data.GLGLData;
import glgl.data.GLGLRectanglePrototype;
import glgl.data.GLGLSetFunction;
import java.time.LocalDate;
import javafx.scene.Node;
import jtps.jTPS_Transaction;
import tdlm.GLGLApp;
import static tdlm.GLGLPropertyType.TDLM_TEXT_DIALOG_CONTENT_LABEL;
import static tdlm.GLGLPropertyType.TDLM_TEXT_DIALOG_TITLE;


/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class BorderRadius_Transaction implements jTPS_Transaction {
    Node item;
    GLGLData  data;
    double oldRadius;
    double newRadius;
    public BorderRadius_Transaction(     
                                    GLGLData  initData,
                                    Node       initItem,
                                    double initoldRadius,
                                    double initnewRadius) {
        item = initItem;
        data=initData;
        oldRadius=initoldRadius;
        newRadius=initnewRadius;
        
    }

    @Override
    public void doTransaction() {
      ((GLGLRectanglePrototype)item).setArcWidth(newRadius);
      ((GLGLRectanglePrototype)item).setArcHeight(newRadius);

       
       
    }

    @Override
    public void undoTransaction() {
        ((GLGLRectanglePrototype)item).setArcWidth(oldRadius);
       ((GLGLRectanglePrototype)item).setArcHeight(oldRadius);

    }
}