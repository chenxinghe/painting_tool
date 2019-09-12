package glgl.transactions;

import glgl.data.GLGLCirclePrototype;
import jtps.jTPS_Transaction;
import glgl.data.GLGLData;
import glgl.data.GLGLRectanglePrototype;
import javafx.scene.Node;



/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class ResizeCircle_Transaction implements jTPS_Transaction {
    GLGLData data;
    Node item;
    double oldradius;
    double newradius;

    
    public ResizeCircle_Transaction(Node inititem,double initoldradius,double initnewradius){
        item=inititem;
        oldradius=initoldradius;
        newradius=initnewradius;
                
    }

    @Override
    public void doTransaction() {
            ((GLGLCirclePrototype)item).setRadius(newradius);

    }

    @Override
    public void undoTransaction() {
            ((GLGLCirclePrototype)item).setRadius(oldradius);  
    }
}
