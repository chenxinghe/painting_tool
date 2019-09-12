package glgl.transactions;

import jtps.jTPS_Transaction;
import glgl.data.GLGLData;

import glgl.data.GLGLSetFunction;
import javafx.scene.Node;

/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class MoveItem_Transaction implements jTPS_Transaction {
    GLGLData data;
    GLGLSetFunction itemToMove;
    double oldX;
    double oldY;
    double newX;
    double newY;
    public MoveItem_Transaction(GLGLData initData, 
                                GLGLSetFunction goloItem,
                                double initoldX,
                                double initoldY,
                                double initnewX,
                                double initnewY) {
        data = initData;
        itemToMove=goloItem;
        oldX = initoldX;
        oldY = initoldY;
        newX=  initnewX;
        newY= initnewY;
        
    }
    
    @Override
    public void doTransaction() {
        data.moveItem((Node)itemToMove,newX,newY);
    }

    @Override
    public void undoTransaction() {
        data.moveItem((Node)itemToMove, oldX,oldY);
    }   
}