package glgl.transactions;

import jtps.jTPS_Transaction;
import glgl.data.GLGLData;
import glgl.data.GLGLImagePrototype;
import glgl.data.GLGLRectanglePrototype;



/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class AddImage_Transaction implements jTPS_Transaction {
    GLGLData data;
    GLGLImagePrototype itemToAdd;
    
    public AddImage_Transaction(GLGLData initData, GLGLImagePrototype initNewItem) {
        data = initData;
        itemToAdd = initNewItem;
    }

    @Override
    public void doTransaction() {
        data.addImage(itemToAdd);    
       
    }

    @Override
    public void undoTransaction() {
        //data.removeImage(itemToAdd);
    }
}
