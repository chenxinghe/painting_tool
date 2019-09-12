package glgl.transactions;

import jtps.jTPS_Transaction;
import glgl.data.GLGLData;
import glgl.data.GLGLRectanglePrototype;
import javafx.scene.Node;



/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class ResizeRectangle_Transaction implements jTPS_Transaction {
    GLGLData data;
    Node item;
    double oldx;
    double oldy;
    double oldwidth;
    double oldheight;
    double newx;
    double newy;
    double newwidth;
    double newheight;
    
    public ResizeRectangle_Transaction(Node inititem,double initoldx,double initoldy,double initoldwidth,double initoldheight,
                                        double initnewx,double initnewy,double initnewWidth,double initnewHeight){
        item=inititem;
        oldx=initoldx;
        oldy =initoldy;
        oldwidth =initoldwidth;
        oldheight =initoldheight;
        newx =initnewx;
        newy=initnewy;
        newwidth =initnewWidth;
        newheight =initnewHeight;
                
    }

    @Override
    public void doTransaction() {
            ((GLGLRectanglePrototype)item).setLocation(newx, newy);
            ((GLGLRectanglePrototype)item).setWidth(newwidth);    
            ((GLGLRectanglePrototype)item).setHeight(newheight);
    }

    @Override
    public void undoTransaction() {
        ((GLGLRectanglePrototype)item).setLocation(oldx, oldy);
            ((GLGLRectanglePrototype)item).setWidth(oldwidth);    
            ((GLGLRectanglePrototype)item).setHeight(oldheight);
    }
}
