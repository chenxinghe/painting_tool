package glgl.clipboard;

import djf.components.AppClipboardComponent;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import tdlm.GLGLApp;
import glgl.data.GLGLData;

import glgl.data.GLGLSetFunction;
import glgl.transactions.CutItems_Transaction;
import glgl.transactions.PasteItems_Transaction;
import javafx.scene.Node;

/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class GLGLClipboard implements AppClipboardComponent {
    GLGLApp app;
    Node clipboardCutItems;
    Node clipboardCopiedItems;
    
    public GLGLClipboard(GLGLApp initApp) {
        app = initApp;
        clipboardCutItems = null;
        clipboardCopiedItems = null;
    }
    
    @Override
    public void cut() {
        GLGLData data = (GLGLData)app.getDataComponent();
        if (data.isItemSelected()) {
            clipboardCutItems = data.getSelectedItems();
            CutItems_Transaction transaction = new CutItems_Transaction((GLGLApp)app, clipboardCutItems);
            app.processTransaction(transaction);
            System.out.println(clipboardCutItems.toString());
            data.resetOrder();
        }
    }

    @Override
    public void copy() {
        GLGLData data = (GLGLData)app.getDataComponent();
        if (data.isItemSelected()) {
            Node tempItems = (Node)(((GLGLSetFunction)data.getSelectedItems()).Clone());
            copyToCopiedClipboard(tempItems);
        }
    }
    
    private void copyToCutClipboard(Node itemsToCopy) {
        clipboardCutItems = itemsToCopy;
        clipboardCopiedItems = null;        
        app.getFoolproofModule().updateAll();        
    }
    
    private void copyToCopiedClipboard(Node itemsToCopy) {
        clipboardCutItems = null;
        clipboardCopiedItems = itemsToCopy;
        app.getFoolproofModule().updateAll();        
    }
    

    @Override
    public void paste() {
        GLGLData data = (GLGLData)app.getDataComponent();
            if ((clipboardCutItems != null)) 
            {
                PasteItems_Transaction transaction = new PasteItems_Transaction((GLGLApp)app, (Node)(((GLGLSetFunction)clipboardCutItems).Clone()));
                app.processTransaction(transaction);
                
                // NOW WE HAVE TO RE-COPY THE CUT ITEMS TO MAKE
                // SURE IF WE PASTE THEM AGAIN THEY ARE BRAND NEW OBJECTS
                //clipboardCopiedItems=(Node)(((GLGLSetFunction)clipboardCopiedItems).Clone());
                copyToCutClipboard(clipboardCutItems);
                data.resetOrder();
            }
            else if (clipboardCopiedItems != null)
                 {
                PasteItems_Transaction transaction = new PasteItems_Transaction((GLGLApp)app, (Node)(((GLGLSetFunction)clipboardCopiedItems).Clone()));
                app.processTransaction(transaction);
            
                // NOW WE HAVE TO RE-COPY THE COPIED ITEMS TO MAKE
                // SURE IF WE PASTE THEM AGAIN THEY ARE BRAND NEW OBJECTS
                copyToCopiedClipboard(clipboardCopiedItems);
                data.resetOrder();
            }
        
    }    


    @Override
    public boolean hasSomethingToCut() {
        return ((GLGLData)app.getDataComponent()).isItemSelected();
    }

    @Override
    public boolean hasSomethingToCopy() {
        return ((GLGLData)app.getDataComponent()).isItemSelected();
    }

    @Override
    public boolean hasSomethingToPaste() {
        if ((clipboardCutItems != null))
            return true;
        else if (clipboardCopiedItems != null)
            return true;
        else
            return false;
    }
}