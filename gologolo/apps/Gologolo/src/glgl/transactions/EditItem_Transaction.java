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
public class EditItem_Transaction implements jTPS_Transaction {
    Node itemToEdit;
    GLGLData  data;
    String content;
    String oldContent;
    GLGLApp app;
    public EditItem_Transaction(     
                                    GLGLData  initData,
                                    Node initItemToEdit,
                                    String initContent) {
        itemToEdit = initItemToEdit;
        data=initData;
        content=initContent;
        oldContent=((GLGLSetFunction)(itemToEdit)).getName();
    }

    @Override
    public void doTransaction() {
       ((GLGLSetFunction)(itemToEdit)).setName(content);
//       app.getGUIModule().g
       
       
    }

    @Override
    public void undoTransaction() {
        ((GLGLSetFunction)(itemToEdit)).setName(oldContent);
       //itemToEdit.setName(oldName);
    }
}