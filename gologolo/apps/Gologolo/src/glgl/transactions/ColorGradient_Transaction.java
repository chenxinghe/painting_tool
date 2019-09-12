package glgl.transactions;

import glgl.data.GLGLData;
import glgl.data.GLGLSetFunction;
import java.time.LocalDate;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import jtps.jTPS_Transaction;
import tdlm.GLGLApp;
import static tdlm.GLGLPropertyType.TDLM_TEXT_DIALOG_CONTENT_LABEL;
import static tdlm.GLGLPropertyType.TDLM_TEXT_DIALOG_TITLE;


/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class ColorGradient_Transaction implements jTPS_Transaction {
    Node item;
    GLGLData  data;
    double focusangle;
    double focusdistance;
    double canterx;
    double cantery;
    double  radius;
    CycleMethod cyclemethod;
    Color step0color;
   Color step1color;
   RadialGradient colortype;
    
    public ColorGradient_Transaction(     
                                                                            GLGLData  initData,
                                                                            Node       initItem,
                                                                            RadialGradient initcolortype
//                                                                            double  initfocusangle,
//                                                                            double  initfocusdistance,
//                                                                            double  initcanterx,
//                                                                            double  initcantery,
//                                                                            double   initradius,
//                                                                            CycleMethod  initcyclemethod,
//                                                                            Color  initstep0color,
//                                                                           Color  initstep1color
                                                                            ) {
        item = initItem;
        data=initData;
        colortype=initcolortype;
//        focusangle=initfocusangle;
//        focusdistance=initfocusdistance;
//        canterx=initcanterx;
//        cantery=initcantery;
//        radius=initradius;
//        cyclemethod=initcyclemethod;
//        step0color=initstep0color;
//        step1color=initstep1color;
    }

    @Override
    public void doTransaction() {
//                          RadialGradient colortype=new RadialGradient(
//                                                                                                   focusangle,
//                                                                                                 focusdistance,
//                                                                                                 canterx,
//                                                                                                 cantery,
//                                                                                                 radius   ,
//                                                                                                 false,
//                                                                                                 cyclemethod  , 
//                                                                                                 new Stop(0,step0color),
//                                                                                                 new Stop(1,step1color)
//                                                                                                                );
                     ((GLGLSetFunction)item).setColorGradient(colortype);
       
       
    }

    @Override
    public void undoTransaction() {
         RadialGradient colortype=new RadialGradient(
                                            ((GLGLSetFunction)item).getColorGradient().getFocusAngle(),
                                            ((GLGLSetFunction)item).getColorGradient().getFocusDistance(),
                                            ((GLGLSetFunction)item).getColorGradient().getCenterX(),
                                            ((GLGLSetFunction)item).getColorGradient().getCenterY(), 
                                            ((GLGLSetFunction)item).getColorGradient().getRadius(),
                                             false,
                                            ((GLGLSetFunction)item).getColorGradient().getCycleMethod(),
                                            new Stop(0,((GLGLSetFunction)item).getColorGradient().getStops().get(0).getColor()) ,
                                            new Stop(1,((GLGLSetFunction)item).getColorGradient().getStops().get(1).getColor()));
         ((GLGLSetFunction)item).setColorGradient(colortype);
    }
}