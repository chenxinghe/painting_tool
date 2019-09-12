package glgl.transactions;

import jtps.jTPS_Transaction;
import glgl.data.GLGLData;
import glgl.data.GLGLTextPrototype;


/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class AddText_Transaction implements jTPS_Transaction {
    GLGLData data;
    GLGLTextPrototype itemToAdd;
    
    public AddText_Transaction(GLGLData initData, GLGLTextPrototype initNewItem) {
        data = initData;
        itemToAdd = initNewItem;
    }

    @Override
    public void doTransaction() {
       // itemToAdd.
        data.addText(itemToAdd);     
        
    }

    @Override
    public void undoTransaction() {
       data.removeText(itemToAdd);
    }
}
