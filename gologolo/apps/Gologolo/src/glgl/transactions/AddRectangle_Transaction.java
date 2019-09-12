package glgl.transactions;

import jtps.jTPS_Transaction;
import glgl.data.GLGLData;
import glgl.data.GLGLRectanglePrototype;



/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class AddRectangle_Transaction implements jTPS_Transaction {
    GLGLData data;
    GLGLRectanglePrototype itemToAdd;
    
    public AddRectangle_Transaction(GLGLData initData, GLGLRectanglePrototype initNewItem) {
        data = initData;
        itemToAdd = initNewItem;
    }

    @Override
    public void doTransaction() {
        data.addRectangle(itemToAdd);    
       
    }

    @Override
    public void undoTransaction() {
        data.removeRectangle(itemToAdd);
    }
}
