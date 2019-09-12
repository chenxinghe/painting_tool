package glgl.transactions;

import static djf.AppPropertyType.APP_CLIPBOARD_FOOLPROOF_SETTINGS;
import java.util.ArrayList;
import jtps.jTPS_Transaction;
import tdlm.GLGLApp;
import glgl.data.GLGLData;

import javafx.scene.Node;

/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class RemoveItems_Transaction implements jTPS_Transaction {
    GLGLApp app;
    Node itemsToRemove;
    int location;
    
    public RemoveItems_Transaction(GLGLApp initApp, Node initItems) {
        app = initApp;
        itemsToRemove = initItems;
    }

    @Override
    public void doTransaction() {
        GLGLData data = (GLGLData)app.getDataComponent();
        location=data.getItemIndex(itemsToRemove);
         data.delete(itemsToRemove);
    }

    @Override
    public void undoTransaction() {
        GLGLData data = (GLGLData)app.getDataComponent();
        data.addItemAt(itemsToRemove, location);
    }
}