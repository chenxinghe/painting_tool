package glgl.transactions;

import glgl.data.GLGLCirclePrototype;
import jtps.jTPS_Transaction;
import glgl.data.GLGLData;
import javafx.scene.Node;




/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class MoveDown_Transaction implements jTPS_Transaction {
    GLGLData data;
    Node itemToMoveUp;
    int index;
    public MoveDown_Transaction(GLGLData initData, Node initNewItem) {
        data = initData;
        itemToMoveUp = initNewItem;
        index=data.getItemIndex(data.getSelectedNode());
    }

    @Override
    public void doTransaction() {
        data.removeItem(itemToMoveUp);
        data.addItemAt(itemToMoveUp, index+1);    
       
    }

    @Override
    public void undoTransaction() {
        data.removeItem(itemToMoveUp);
        data.addItemAt(itemToMoveUp, index);
    }
}
