package glgl.transactions;

import jtps.jTPS_Transaction;
import static djf.AppPropertyType.APP_CLIPBOARD_FOOLPROOF_SETTINGS;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import tdlm.GLGLApp;
import glgl.data.GLGLData;

import javafx.scene.Node;

/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class CutItems_Transaction implements jTPS_Transaction {
    GLGLApp app;
    Node itemsToCut;
    int location;
    
    public CutItems_Transaction(GLGLApp initApp, Node initItemsToCut) {
        app = initApp;
        itemsToCut = initItemsToCut;
    }

    @Override
    public void doTransaction() {
        GLGLData data = (GLGLData)app.getDataComponent();
        location=data.getItemIndex(itemsToCut);
        
        data.removeItem(itemsToCut);
        app.getFoolproofModule().updateControls(APP_CLIPBOARD_FOOLPROOF_SETTINGS);
    }

    @Override
    public void undoTransaction() {
        GLGLData data = (GLGLData)app.getDataComponent();
        data.addItemAt(itemsToCut, location);
        app.getFoolproofModule().updateControls(APP_CLIPBOARD_FOOLPROOF_SETTINGS);
    }   
}