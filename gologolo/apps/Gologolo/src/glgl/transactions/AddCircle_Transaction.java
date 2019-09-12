package glgl.transactions;

import glgl.data.GLGLCirclePrototype;
import jtps.jTPS_Transaction;
import glgl.data.GLGLData;
import glgl.data.GLGLRectanglePrototype;



/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class AddCircle_Transaction implements jTPS_Transaction {
    GLGLData data;
    GLGLCirclePrototype itemToAdd;
    
    public AddCircle_Transaction(GLGLData initData, GLGLCirclePrototype initNewItem) {
        data = initData;
        itemToAdd = initNewItem;
    }

    @Override
    public void doTransaction() {
        data.addCircle(itemToAdd);    
       
    }

    @Override
    public void undoTransaction() {
        data.removeCircle(itemToAdd);
    }
}
