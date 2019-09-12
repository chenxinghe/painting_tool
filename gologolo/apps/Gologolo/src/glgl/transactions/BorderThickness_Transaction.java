package glgl.transactions;

import glgl.data.GLGLData;
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
public class BorderThickness_Transaction implements jTPS_Transaction {
    Node item;
    GLGLData  data;
    double oldThickness;
    double newThickness;
    double oldRadius;
    double newRadius;
    public BorderThickness_Transaction(     
                                    GLGLData  initData,
                                    Node       initItem,
                                    double initoldThickness,
                                    double initnewThikcness) {
        item = initItem;
        data=initData;
        oldThickness=initoldThickness;
        newThickness=initnewThikcness;
        
    }

    @Override
    public void doTransaction() {
       ((GLGLSetFunction)item).setStrokeWidth(newThickness);
//       app.getGUIModule().g
       
       
    }

    @Override
    public void undoTransaction() {
        ((GLGLSetFunction)item).setStrokeWidth(oldThickness);
       //itemToEdit.setName(oldName);
    }
}