package glgl.transactions;

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
public class PasteItems_Transaction implements jTPS_Transaction {
    GLGLApp app;
    Node itemsToPaste;
    int pasteIndex;
    
    public PasteItems_Transaction(  GLGLApp initApp, 
                                    Node initItemsToPaste) {
        app = initApp;
        itemsToPaste = initItemsToPaste;
    }

    @Override
    public void doTransaction() {
        GLGLData data = (GLGLData)app.getDataComponent();
 
        data.addItem(itemsToPaste);
        
          
        
    }

    @Override
    public void undoTransaction() {
        GLGLData data = (GLGLData)app.getDataComponent();
        
            data.removeItem(itemsToPaste);
        
    }   
}