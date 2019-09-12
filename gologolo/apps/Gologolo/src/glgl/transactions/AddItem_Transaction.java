package glgl.transactions;

import jtps.jTPS_Transaction;
import glgl.data.GLGLData;

import javafx.scene.Node;

/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class AddItem_Transaction implements jTPS_Transaction {
    GLGLData data;
    Node itemToAdd;
    
    public AddItem_Transaction(GLGLData initData, Node initNewItem) {
        data = initData;
        itemToAdd = initNewItem;
    }

    @Override
    public void doTransaction() {
        data.addItem(itemToAdd);        
    }

    @Override
    public void undoTransaction() {
       // data.removeItem(itemToAdd);
    }
}
