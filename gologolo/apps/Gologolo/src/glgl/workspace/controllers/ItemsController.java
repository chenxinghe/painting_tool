package glgl.workspace.controllers;

import djf.AppPropertyType;
import static djf.AppPropertyType.TDLM_OPEN_DIALOG_TITLE;
import djf.ui.dialogs.AppDialogsFacade;
import glgl.data.GLGLCirclePrototype;
import java.util.ArrayList;
import tdlm.GLGLApp;
import glgl.data.GLGLData;
import glgl.data.GLGLImagePrototype;

import glgl.data.GLGLRectanglePrototype;
import glgl.data.GLGLSetFunction;
import glgl.data.GLGLTextPrototype;
import glgl.transactions.AddCircle_Transaction;
import glgl.transactions.AddImage_Transaction;
import glgl.workspace.dialogs.ToDoListItemDialog;
import glgl.transactions.AddItem_Transaction;
import glgl.transactions.AddRectangle_Transaction;
import glgl.transactions.AddText_Transaction;
import glgl.transactions.BorderColor_Transaction;
import glgl.transactions.BorderRadius_Transaction;
import glgl.transactions.BorderThickness_Transaction;
import glgl.transactions.EditItem_Transaction;
import glgl.transactions.Font_Transaction;
import glgl.transactions.MoveDown_Transaction;
import glgl.transactions.MoveItem_Transaction;
import glgl.transactions.MoveUp_Transaction;
import glgl.transactions.RemoveItems_Transaction;
import glgl.transactions.ResizeCircle_Transaction;
import glgl.transactions.ResizeRectangle_Transaction;
import glgl.workspace.dialogs.GologoloResizeDialog;
import java.io.File;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Paint;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import static tdlm.GLGLPropertyType.TDLM_BORDER_COLOR_COLOR_PICKER;
import static tdlm.GLGLPropertyType.TDLM_BORDER_RADIUS_Slider;
import static tdlm.GLGLPropertyType.TDLM_BORDER_THICKNESS_Slider;
import static tdlm.GLGLPropertyType.TDLM_CANTER_X_Slider;
import static tdlm.GLGLPropertyType.TDLM_CANTER_Y_Slider;
import static tdlm.GLGLPropertyType.TDLM_CYCLE_METHOD_COMBO_BOX;
import static tdlm.GLGLPropertyType.TDLM_FIRST_FONT_PANE;
import static tdlm.GLGLPropertyType.TDLM_FONT_COLOR_PICKER;
import static tdlm.GLGLPropertyType.TDLM_FONT_COMBO_BOX;
import static tdlm.GLGLPropertyType.TDLM_FONT_PANE;
import static tdlm.GLGLPropertyType.TDLM_FONT_SIZE_COMBO_BOX;
import static tdlm.GLGLPropertyType.TDLM_FOUCS_ANGLE_Slider;
import static tdlm.GLGLPropertyType.TDLM_FOUCS_DISTANCE_Slider;
import static tdlm.GLGLPropertyType.TDLM_RADIUS_Slider;
import static tdlm.GLGLPropertyType.TDLM_SMALL_WORK_SPACE_PANE;
import static tdlm.GLGLPropertyType.TDLM_STEP_0_COLOR_COLOR_PICKER;
import static tdlm.GLGLPropertyType.TDLM_STEP_1_COLOR_COLOR_PICKER;
import static tdlm.GLGLPropertyType.TDLM_TEXT_DIALOG_CONTENT_LABEL;
import static tdlm.GLGLPropertyType.TDLM_TEXT_DIALOG_TITLE;
import static tdlm.GLGLPropertyType.TDLM_WRONG_CONTENT_MESSAGE;

/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class ItemsController {
    GLGLApp app;
    ToDoListItemDialog itemDialog;
    GologoloResizeDialog resizeDialog;
     AppDialogsFacade textDialog;
     double oldX;
     double oldY;
     double diffX;
     double diffY;
     double newX;
     double newY;
     //cursor direction
     boolean wResizing=false;
     boolean eResizing=false;
     boolean nResizing=false;
     boolean sResizing=false;
     boolean enResizing=false;
     boolean wnResizing=false;
     boolean esResizing=false;
     boolean wsResizing=false;
     
     
     
     
     
     boolean upResizing=false;
     boolean downresizing=false;
     double oldResizeX;
     double oldResizeY;
     double newResizeX;
     double newResizeY;
     double oldBorderThickness;
     double oldBorderRadius;
     double newBorderThickness;
     double newBorderRadius;
     Cursor cursor;
     String cursorOn=null;
     double oldresizex;
     double oldresizey;
     double newresizex;
     double newresizey;
     double oldresizewidth;
     double oldresizeheight;
     double newresizeheight;
     double newrisizewidth;
     double oldCircleRadius;
     double newCircleRadius;

    public ItemsController(GLGLApp initApp) {
        app = initApp;
        
        itemDialog = new ToDoListItemDialog(app);
        resizeDialog = new GologoloResizeDialog(app);
        textDialog=new AppDialogsFacade();
    }
    
    public void processAddItem() {
//        itemDialog.showAddDialog();
//        Node newItem = itemDialog.getNewItem();        
//        if (newItem != null) {
//            // IF IT HAS A UNIQUE NAME AND COLOR
//            // THEN CREATE A TRANSACTION FOR IT
//            // AND ADD IT
//            GLGLData data = (GLGLData)app.getDataComponent();
//            AddItem_Transaction transaction = new AddItem_Transaction(data, newItem);
//            app.processTransaction(transaction);
//        }    
//        // OTHERWISE TELL THE USER WHAT THEY
//        // HAVE DONE WRONG
//        else {
//            djf.ui.dialogs.AppDialogsFacade.showMessageDialog(app.getGUIModule().getWindow(), "Invalid Line", "Invalid data for a new line");
//        }
    }
    
    public void processAddRectangleItem(){
        //GLGLRectanglePrototype newRectangle=new GLGLRectanglePrototype("0","no name","Rectangle",100.00,100.00,100.00,100.00,Color.WHITE,Color.BLACK);
        GLGLRectanglePrototype newRectangle= new GLGLRectanglePrototype();
        
        //newRectangle.setFill(colortype);
       // newRectangle.setStroke(Color.BLACK);
        GLGLData data = (GLGLData)app.getDataComponent();
        AddRectangle_Transaction transaction = new AddRectangle_Transaction(data, newRectangle);
        app.processTransaction(transaction);
        
    }
    
    public void processAddCircle(){
        GLGLCirclePrototype newCircle = new GLGLCirclePrototype();
       // newCircle.setFill(colortype);
       // newCircle.setStroke(Color.BLACK);
        GLGLData data = (GLGLData)app.getDataComponent();
        AddCircle_Transaction transaction=new AddCircle_Transaction(data, newCircle);
        app.processTransaction(transaction);
//        ((GLGLCirclePrototype)newCircle).setOnScrollFinished(e ->{
//            processResizeCircle();
//        });
    }
    
//    public void processResizeCircle(){
//            GLGLData data = (GLGLData)app.getDataComponent();
//            Node item= data.getSelectedItem();
//            GLGL
//    }
    
    
    
    public void processAddTextItem(){
        String content=textDialog.showTextInputDialog(app.getGUIModule().getWindow(), TDLM_TEXT_DIALOG_TITLE, TDLM_TEXT_DIALOG_CONTENT_LABEL);
        if(!content.isEmpty()){
            GLGLTextPrototype newText= new GLGLTextPrototype(content);
       // newText.setLocation(100.00, 100.00);
          //newText.setStroke(Color.TRANSPARENT);
        GLGLData data = (GLGLData)app.getDataComponent();
        AddText_Transaction transaction = new AddText_Transaction(data, newText);
        app.processTransaction(transaction);
        }else{
            textDialog.showMessageDialog(app.getGUIModule().getWindow(), TDLM_TEXT_DIALOG_TITLE, TDLM_WRONG_CONTENT_MESSAGE);
        } 
    }
    
    public void processAddImage(){
        File file=textDialog.showOpenDialog(app.getGUIModule().getWindow(), TDLM_OPEN_DIALOG_TITLE);
        if(file.exists()){
            GLGLImagePrototype newImage=new GLGLImagePrototype();
           Image image = new Image(file.toURI().toString()); 
           newImage.setImage(image);
           newImage.setImagePath(file.toURI().toString());
           GLGLData data = (GLGLData)app.getDataComponent();
        AddImage_Transaction transaction = new AddImage_Transaction(data, newImage);
        app.processTransaction(transaction);
        }
        
        
    }
    
    public void processDeleteItem(){
        GLGLData data = (GLGLData)app.getDataComponent();
        //if (data.isItemSelected() || data.areItemsSelected()) {
           // ArrayList<GLGLPrototype> itemsToRemove = new ArrayList(data.getSelectedItems());
            Node itemToRemove=data.getSelectedNode();
            RemoveItems_Transaction transaction = new RemoveItems_Transaction(app, itemToRemove);
            app.processTransaction(transaction);
            data.resetOrder();
    
    }
    
    
    public void processMousePress(double x, double y){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item= data.getTopNode(x,y);
       //selected and drag
        if(item!=null){
            data.selectNode(item);
            
        diffX=x-((GLGLSetFunction)item).getX();
        diffY=y-((GLGLSetFunction)item).getY();
        oldX=((GLGLSetFunction)item).getX();
        oldY=((GLGLSetFunction)item).getY();
        if(((GLGLSetFunction)item).getType().equals("RECTANGLE")){
            oldresizex=((GLGLRectanglePrototype)item).getX();
            oldresizey=((GLGLRectanglePrototype)item).getY();
            oldresizewidth=((GLGLRectanglePrototype)item).getWidth();
            oldresizeheight=((GLGLRectanglePrototype)item).getHeight();
        }else if(((GLGLSetFunction)item).getType().equals("CIRCLE")){
            oldCircleRadius=((GLGLCirclePrototype)item).getRadius();
        }
        
            //System.out.println("click"+x+" "+y+   "oldx "+oldX+" oldy "+oldY+" diffX"+diffX+" diffy"+diffY);
        app.getFoolproofModule().updateAll();
        }else{
            data.unselectSelectedNode();
        app.getFoolproofModule().updateAll();   
        }  
        
        if(item!=null&&((GLGLSetFunction)item).getType().equals("TEXT")){
            ((ComboBox)app.getGUIModule().getGUINode(TDLM_FONT_COMBO_BOX)).setValue(((GLGLTextPrototype)item).getFont().getFamily());
            ((ComboBox)app.getGUIModule().getGUINode(TDLM_FONT_SIZE_COMBO_BOX)).setValue((int)(((GLGLTextPrototype)item).getFont().getSize()));
            ((ColorPicker)app.getGUIModule().getGUINode(TDLM_FONT_COLOR_PICKER)).setValue((Color)((GLGLTextPrototype)item).getFill());
           // ((ComboBox)app.getGUIModule().getGUINode(TDLM_FONT_SIZE_COMBO_BOX))
        }else if(item!=null&&(((GLGLSetFunction)item).getType().equals("RECTANGLE")||((GLGLSetFunction)item).getType().equals("CIRCLE"))){
                    if(((GLGLSetFunction)item).getType().equals("RECTANGLE")){
                           ((Slider)app.getGUIModule().getGUINode(TDLM_CANTER_X_Slider)).setMin((((GLGLSetFunction)item).getX()));
                           ((Slider)app.getGUIModule().getGUINode(TDLM_CANTER_X_Slider)).setMax((((GLGLSetFunction)item).getX())+(((GLGLSetFunction)item).getWidth()));
                           ((Slider)app.getGUIModule().getGUINode(TDLM_CANTER_Y_Slider)).setMin((((GLGLSetFunction)item).getY()));
                           ((Slider)app.getGUIModule().getGUINode(TDLM_CANTER_Y_Slider)).setMax((((GLGLSetFunction)item).getY())+(((GLGLSetFunction)item).getHeight()));  
                             ((Slider)app.getGUIModule().getGUINode(TDLM_BORDER_RADIUS_Slider)).setValue((((GLGLSetFunction)item).getArcHeight()));
                            
                            
                            
                            
                            
                        }else if(((GLGLSetFunction)item).getType().equals("CIRCLE")){
                            ((Slider)app.getGUIModule().getGUINode(TDLM_CANTER_X_Slider)).setMin((((GLGLSetFunction)item).getX())-(((GLGLSetFunction)item).getRadius()));
                        ((Slider)app.getGUIModule().getGUINode(TDLM_CANTER_X_Slider)).setMax((((GLGLSetFunction)item).getX())+(((GLGLSetFunction)item).getRadius()));
                           ((Slider)app.getGUIModule().getGUINode(TDLM_CANTER_Y_Slider)).setMin((((GLGLSetFunction)item).getY())-(((GLGLSetFunction)item).getRadius()));
                            ((Slider)app.getGUIModule().getGUINode(TDLM_CANTER_Y_Slider)).setMax((((GLGLSetFunction)item).getY())+(((GLGLSetFunction)item).getRadius()));  
                            
        }
                  ((Slider)app.getGUIModule().getGUINode(TDLM_BORDER_THICKNESS_Slider)).setValue((((GLGLSetFunction)item).getStrokeWidth()));
                  ((ColorPicker)app.getGUIModule().getGUINode(TDLM_BORDER_COLOR_COLOR_PICKER)).setValue((Color)(((GLGLSetFunction)item).getStroke()));
                    

            ((Slider)app.getGUIModule().getGUINode(TDLM_FOUCS_ANGLE_Slider)).setValue((((GLGLSetFunction)item).getColorGradient()).getFocusAngle());
            ((Slider)app.getGUIModule().getGUINode(TDLM_FOUCS_DISTANCE_Slider)).setValue((((GLGLSetFunction)item).getColorGradient()).getFocusDistance());
            ((Slider)app.getGUIModule().getGUINode(TDLM_CANTER_X_Slider)).setValue((((GLGLSetFunction)item).getColorGradient()).getCenterX());
            ((Slider)app.getGUIModule().getGUINode(TDLM_CANTER_Y_Slider)).setValue((((GLGLSetFunction)item).getColorGradient()).getCenterY());
            ((Slider)app.getGUIModule().getGUINode(TDLM_RADIUS_Slider)).setValue((((GLGLSetFunction)item).getColorGradient()).getRadius());
            ((ComboBox)app.getGUIModule().getGUINode(TDLM_CYCLE_METHOD_COMBO_BOX)).setValue((((GLGLSetFunction)item).getColorGradient()).getCycleMethod());
            ((ColorPicker)app.getGUIModule().getGUINode(TDLM_STEP_0_COLOR_COLOR_PICKER)).setValue((((GLGLSetFunction)item).getColorGradient()).getStops().get(0).getColor());
            ((ColorPicker)app.getGUIModule().getGUINode(TDLM_STEP_1_COLOR_COLOR_PICKER)).setValue((((GLGLSetFunction)item).getColorGradient()).getStops().get(1).getColor());
            
            
 
    }
    
    }
    
    private Cursor getCursorstate(){
        if(enResizing==true){
            return Cursor.NE_RESIZE;
        }else if(esResizing==true){
            return Cursor.SE_RESIZE;
        }else if(wnResizing==true){
            return Cursor.NW_RESIZE;
        }else if(wsResizing==true){
            return Cursor.SW_RESIZE;
        }else if(wResizing==true){
            return Cursor.W_RESIZE;
        }else if(eResizing==true){
            return Cursor.E_RESIZE;
        }else if(nResizing==true){
            return Cursor.N_RESIZE;
        }else if(sResizing==true){
            return Cursor.S_RESIZE;
        }else {
            return Cursor.DEFAULT;
        }
        
        
        
    }
    public void processTableMousePress(double x, double y){
        GLGLData data = (GLGLData)app.getDataComponent();
        data.selectTableItem(data);
        
        
    }
        
        
    public void processMoveItemToFront() {
        GLGLData data = (GLGLData)app.getDataComponent();
        Node itemToMoveUp=data.getSelectedItem();
        MoveUp_Transaction transaction = new MoveUp_Transaction(data, itemToMoveUp);
        app.processTransaction(transaction);
    }
    public void processMoveItemToBack() {
        GLGLData data = (GLGLData)app.getDataComponent();
        Node itemToMoveDown=data.getSelectedItem();
        MoveDown_Transaction transaction = new MoveDown_Transaction(data, itemToMoveDown);
        app.processTransaction(transaction);
    }
    
    public void processMouseDragged(double x,double y){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
        if(cursorOn==null){
           if(data.isSelectedNode(item)&&item!=null){
            GLGLSetFunction goloItem=(GLGLSetFunction)item;
            goloItem.drag(x-diffX, y-diffY);
            

            
            //System.out.println("click"+x+" "+y+   "oldx "+oldX+" oldy "+oldY+" diffX"+diffX+" diffy"+diffY);
            if(((GLGLSetFunction)item).getType().equals("CIRCLE")||((GLGLSetFunction)item).getType().equals("RECTANGLE")){
                        //reset centerx slider and centery slider
                        if(((GLGLSetFunction)item).getType().equals("RECTANGLE")){
                        ((Slider)app.getGUIModule().getGUINode(TDLM_CANTER_X_Slider)).setMin((((GLGLSetFunction)item).getX()));
                        ((Slider)app.getGUIModule().getGUINode(TDLM_CANTER_X_Slider)).setMax((((GLGLSetFunction)item).getX())+(((GLGLSetFunction)item).getWidth()));
                           ((Slider)app.getGUIModule().getGUINode(TDLM_CANTER_Y_Slider)).setMin((((GLGLSetFunction)item).getY()));
                            ((Slider)app.getGUIModule().getGUINode(TDLM_CANTER_Y_Slider)).setMax((((GLGLSetFunction)item).getY())+(((GLGLSetFunction)item).getHeight()));  
                        }else if((((GLGLSetFunction)item).getType().equals("CIRCLE"))){
                            ((Slider)app.getGUIModule().getGUINode(TDLM_CANTER_X_Slider)).setMin((((GLGLSetFunction)item).getX())-(((GLGLSetFunction)item).getRadius()));
                        ((Slider)app.getGUIModule().getGUINode(TDLM_CANTER_X_Slider)).setMax((((GLGLSetFunction)item).getX())+(((GLGLSetFunction)item).getRadius()));
                           ((Slider)app.getGUIModule().getGUINode(TDLM_CANTER_Y_Slider)).setMin((((GLGLSetFunction)item).getY())-(((GLGLSetFunction)item).getRadius()));
                            ((Slider)app.getGUIModule().getGUINode(TDLM_CANTER_Y_Slider)).setMax((((GLGLSetFunction)item).getY())+(((GLGLSetFunction)item).getRadius()));  
                                     }  
            }
            
            


        } 
        }else if(cursorOn!=null){
            
            if(data.isSelectedNode(item)&&item!=null&&((GLGLSetFunction)item).getType().equals("CIRCLE")){
                if(enResizing==true||esResizing==true||wnResizing==true||wsResizing==true){
                    ((GLGLCirclePrototype)item).setRadius(Math.sqrt((x-((GLGLCirclePrototype)item).getX())*(x-((GLGLCirclePrototype)item).getX())
                            +(y-((GLGLCirclePrototype)item).getY())*(y-((GLGLCirclePrototype)item).getY())));
                }
            }
            
            
          if(data.isSelectedNode(item)&&item!=null&&((GLGLSetFunction)item).getType().equals("RECTANGLE")){
                
              if(wResizing==true&&data.isSelectedNode(item)&&item!=null){
                    ((GLGLRectanglePrototype)item).setLocation(x, oldresizey);
                    ((GLGLRectanglePrototype)item).setWidth(oldresizewidth-(x-oldresizex));
                
              }else if(eResizing==true&&data.isSelectedNode(item)&&item!=null){
                    ((GLGLRectanglePrototype)item).setWidth(x-oldresizex);
                
              }else if(nResizing==true&&data.isSelectedNode(item)&&item!=null){
                    ((GLGLRectanglePrototype)item).setLocation(oldresizex, y);
                    ((GLGLRectanglePrototype)item).setHeight(oldresizeheight-(y-oldresizey));
                
              }else if(sResizing==true&&data.isSelectedNode(item)&&item!=null){
                    ((GLGLRectanglePrototype)item).setHeight(y-oldresizey);
                
              }else if(wnResizing==true&&data.isSelectedNode(item)&&item!=null){
                    ((GLGLRectanglePrototype)item).setLocation(x, y);
                    ((GLGLRectanglePrototype)item).setHeight(oldresizeheight-(y-oldresizey));
                    ((GLGLRectanglePrototype)item).setWidth(oldresizewidth-(x-oldresizex)); 
                
              }else if(enResizing==true&&data.isSelectedNode(item)&&item!=null){
                    ((GLGLRectanglePrototype)item).setLocation(oldresizex, y);
                    ((GLGLRectanglePrototype)item).setHeight(oldresizeheight+oldresizey-y);
                    ((GLGLRectanglePrototype)item).setWidth(x-oldresizex); 
              }else if(esResizing==true&&data.isSelectedNode(item)&&item!=null){
                    ((GLGLRectanglePrototype)item).setLocation(oldresizex, oldresizey);
                    ((GLGLRectanglePrototype)item).setHeight(y-oldresizey);
                    ((GLGLRectanglePrototype)item).setWidth(x-oldresizex); 
              }else if(wsResizing==true&&data.isSelectedNode(item)&&item!=null){
                    ((GLGLRectanglePrototype)item).setLocation(x, oldresizey);
                    ((GLGLRectanglePrototype)item).setHeight(y-oldresizey);
                    ((GLGLRectanglePrototype)item).setWidth(oldresizex+oldresizewidth-x); 
              }    
        }
        
          if(data.isSelectedNode(item)&&item!=null&&((GLGLSetFunction)item).getType().equals("CIRCLE")){
              
          }
        
    }
    }
    public void processMouseReleased(double x,double y){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
        newX=x-diffX;
        newY=y-diffY;
        
        if(cursorOn==null){
          if(data.isSelectedNode(item)&&item!=null){
           if(item.contains(x, y)){
           GLGLSetFunction goloItem=(GLGLSetFunction)item;
           //goloItem.setLocation(x, y); 
          // System.out.println("click"+x+" "+y+   "oldx "+oldX+" oldy "+oldY+" diffX"+diffX+" diffy"+diffY);
           MoveItem_Transaction transaction = new MoveItem_Transaction(data, goloItem,oldX,oldY,newX,newY);
            app.processTransaction(transaction);
            } 
        }  
        }else if(cursorOn!=null){
                
            if(data.isSelectedNode(item)&&item!=null&&((GLGLSetFunction)item).getType().equals("CIRCLE")){
                newCircleRadius=(Math.sqrt((x-((GLGLCirclePrototype)item).getX())*(x-((GLGLCirclePrototype)item).getX())
                            +(y-((GLGLCirclePrototype)item).getY())*(y-((GLGLCirclePrototype)item).getY())));
                ResizeCircle_Transaction transaction = new ResizeCircle_Transaction(item,oldCircleRadius,newCircleRadius);
                app.processTransaction(transaction);
                
            }
            
            
            
            if(data.isSelectedNode(item)&&item!=null&&((GLGLSetFunction)item).getType().equals("RECTANGLE")){
//                oldresizex=((GLGLRectanglePrototype)item).getX();
//                oldresizey=((GLGLRectanglePrototype)item).getY();
//                oldresizewidth=((GLGLRectanglePrototype)item).getWidth();
//                oldresizeheight=((GLGLRectanglePrototype)item).getHeight();
              if(wResizing==true&&data.isSelectedNode(item)&&item!=null){
//                    ((GLGLRectanglePrototype)item).setLocation(x, oldresizey);
//                    ((GLGLRectanglePrototype)item).setWidth(oldresizewidth-(x-oldresizex));
                
                ResizeRectangle_Transaction transaction = new ResizeRectangle_Transaction(item,
                                                    oldresizex,oldresizey,oldresizewidth,oldresizeheight,
                                                    x,oldresizey,oldresizewidth-(x-oldresizex),oldresizeheight);
                app.processTransaction(transaction);



              }else if(eResizing==true&&data.isSelectedNode(item)&&item!=null){
//                    ((GLGLRectanglePrototype)item).setWidth(x-oldresizex);
                    ResizeRectangle_Transaction transaction = new ResizeRectangle_Transaction(item,
                                                    oldresizex,oldresizey,oldresizewidth,oldresizeheight,
                                                    oldresizex,oldresizey,x-oldresizex,oldresizeheight);
                    app.processTransaction(transaction);
              }else if(nResizing==true&&data.isSelectedNode(item)&&item!=null){
//                    ((GLGLRectanglePrototype)item).setLocation(oldresizex, y);
//                    ((GLGLRectanglePrototype)item).setHeight(oldresizeheight-(y-oldresizey));
                        ResizeRectangle_Transaction transaction = new ResizeRectangle_Transaction(item,
                                                    oldresizex,oldresizey,oldresizewidth,oldresizeheight,
                                                    oldresizex,y,oldresizewidth,oldresizeheight-(y-oldresizey));
                        app.processTransaction(transaction);
              }else if(sResizing==true&&data.isSelectedNode(item)&&item!=null){
                    //((GLGLRectanglePrototype)item).setHeight(y-oldresizey);
                        ResizeRectangle_Transaction transaction = new ResizeRectangle_Transaction(item,
                                                    oldresizex,oldresizey,oldresizewidth,oldresizeheight,
                                                    oldresizex,oldresizey,oldresizewidth,y-oldresizey);
                        app.processTransaction(transaction);
              }else if(wnResizing==true&&data.isSelectedNode(item)&&item!=null){
//                    ((GLGLRectanglePrototype)item).setLocation(x, y);
//                    ((GLGLRectanglePrototype)item).setHeight(oldresizeheight-(y-oldresizey));
//                    ((GLGLRectanglePrototype)item).setWidth(oldresizewidth-(x-oldresizex)); 
                        ResizeRectangle_Transaction transaction = new ResizeRectangle_Transaction(item,
                                                    oldresizex,oldresizey,oldresizewidth,oldresizeheight,
                                                    x,y,oldresizewidth-(x-oldresizex),oldresizeheight-(y-oldresizey));
                        app.processTransaction(transaction);
                
              }else if(enResizing==true&&data.isSelectedNode(item)&&item!=null){
//                    ((GLGLRectanglePrototype)item).setLocation(oldresizex, y);
//                    ((GLGLRectanglePrototype)item).setHeight(oldresizeheight+oldresizey-y);
//                    ((GLGLRectanglePrototype)item).setWidth(x-oldresizex); 
                        ResizeRectangle_Transaction transaction = new ResizeRectangle_Transaction(item,
                                                    oldresizex,oldresizey,oldresizewidth,oldresizeheight,
                                                    oldresizex,y,x-oldresizex,oldresizeheight+oldresizey-y);
                        app.processTransaction(transaction);
              }else if(esResizing==true&&data.isSelectedNode(item)&&item!=null){
//                    ((GLGLRectanglePrototype)item).setLocation(oldresizex, oldresizey);
//                    ((GLGLRectanglePrototype)item).setHeight(y-oldresizey);
//                    ((GLGLRectanglePrototype)item).setWidth(x-oldresizex); 
                         ResizeRectangle_Transaction transaction = new ResizeRectangle_Transaction(item,
                                                    oldresizex,oldresizey,oldresizewidth,oldresizeheight,
                                                    oldresizex,oldresizey,x-oldresizex,y-oldresizey);
                        app.processTransaction(transaction);
              }else if(wsResizing==true&&data.isSelectedNode(item)&&item!=null){
//                    ((GLGLRectanglePrototype)item).setLocation(x, oldresizey);
//                    ((GLGLRectanglePrototype)item).setHeight(y-oldresizey);
//                    ((GLGLRectanglePrototype)item).setWidth(oldresizex+oldresizewidth-x); 
                        ResizeRectangle_Transaction transaction = new ResizeRectangle_Transaction(item,
                                                    oldresizex,oldresizey,oldresizewidth,oldresizeheight,
                                                    x,oldresizey,oldresizex+oldresizewidth-x,y-oldresizey);
                        app.processTransaction(transaction);
              }
        }
        
        
        
        
        
        
        
        
  
    }
    }
    
    public void processDetectForResize(double x,double y){
        GLGLData data = (GLGLData)app.getDataComponent();
        if(data.isItemSelected()){
            Node item=data.getSelectedNode();
            
            if(((GLGLSetFunction)item).getType() .equals("CIRCLE")&&data.getSelectedNode()!=null){
                
                if(Math.sqrt((x-((GLGLCirclePrototype)item).getX())*(x-((GLGLCirclePrototype)item).getX())+(y-((GLGLCirclePrototype)item).getY())*(y-((GLGLCirclePrototype)item).getY()))<=((GLGLSetFunction)item).getRadius()
                   &&Math.sqrt((x-((GLGLCirclePrototype)item).getX())*(x-((GLGLCirclePrototype)item).getX())+(y-((GLGLCirclePrototype)item).getY())*(y-((GLGLCirclePrototype)item).getY()))>=((GLGLSetFunction)item).getRadius()-5
                    &&((GLGLCirclePrototype)item).getX()<x&&((GLGLCirclePrototype)item).getY()<y){
                                //data.setUnHighlight(item);
                                wnResizing=false;
                                wsResizing=false;
                                enResizing=false;
                                esResizing=true;
                                cursor=getCursorstate();
                                item.setCursor(cursor);
                                cursorOn="CIRCLE";
                }else if(Math.sqrt((x-((GLGLCirclePrototype)item).getX())*(x-((GLGLCirclePrototype)item).getX())+(y-((GLGLCirclePrototype)item).getY())*(y-((GLGLCirclePrototype)item).getY()))<=((GLGLSetFunction)item).getRadius()
                   &&Math.sqrt((x-((GLGLCirclePrototype)item).getX())*(x-((GLGLCirclePrototype)item).getX())+(y-((GLGLCirclePrototype)item).getY())*(y-((GLGLCirclePrototype)item).getY()))>=((GLGLSetFunction)item).getRadius()-5
                    &&((GLGLCirclePrototype)item).getX()>x&&((GLGLCirclePrototype)item).getY()>y){
                                wnResizing=true;
                                wsResizing=false;
                                enResizing=false;
                                esResizing=false;
                                cursor=getCursorstate();
                                item.setCursor(cursor);
                                cursorOn="CIRCLE";
                }else if(Math.sqrt((x-((GLGLCirclePrototype)item).getX())*(x-((GLGLCirclePrototype)item).getX())+(y-((GLGLCirclePrototype)item).getY())*(y-((GLGLCirclePrototype)item).getY()))<=((GLGLSetFunction)item).getRadius()
                   &&Math.sqrt((x-((GLGLCirclePrototype)item).getX())*(x-((GLGLCirclePrototype)item).getX())+(y-((GLGLCirclePrototype)item).getY())*(y-((GLGLCirclePrototype)item).getY()))>=((GLGLSetFunction)item).getRadius()-5
                    &&((GLGLCirclePrototype)item).getX()<x&&((GLGLCirclePrototype)item).getY()>y){
                                wnResizing=false;
                                wsResizing=false;
                                enResizing=true;
                                esResizing=false;
                                cursor=getCursorstate();
                                item.setCursor(cursor);
                                cursorOn="CIRCLE";
                }else if(Math.sqrt((x-((GLGLCirclePrototype)item).getX())*(x-((GLGLCirclePrototype)item).getX())+(y-((GLGLCirclePrototype)item).getY())*(y-((GLGLCirclePrototype)item).getY()))<=((GLGLSetFunction)item).getRadius()
                   &&Math.sqrt((x-((GLGLCirclePrototype)item).getX())*(x-((GLGLCirclePrototype)item).getX())+(y-((GLGLCirclePrototype)item).getY())*(y-((GLGLCirclePrototype)item).getY()))>=((GLGLSetFunction)item).getRadius()-5
                    &&((GLGLCirclePrototype)item).getX()>x&&((GLGLCirclePrototype)item).getY()<y){
                                wnResizing=false;
                                wsResizing=true;
                                enResizing=false;
                                esResizing=false;
                                cursor=getCursorstate();
                                item.setCursor(cursor);
                                cursorOn="CIRCLE";
                }else{
                                wnResizing=false;
                                wsResizing=false;
                                enResizing=false;
                                esResizing=false;
                                cursor=getCursorstate();
                                item.setCursor(cursor);
                                cursorOn=null;
                        }
            }
            
            
            if(((GLGLSetFunction)item).getType() .equals("RECTANGLE")){
                if((((GLGLSetFunction)item).getX())<=x
                        &&(((GLGLSetFunction)item).getX()+7)>=x
                        &&(((GLGLSetFunction)item).getY())<=y
                        &&(((GLGLSetFunction)item).getY()+7)>=y){
                    wnResizing=true;
                    wResizing=false;
                    eResizing=false;
                    nResizing=false;
                    sResizing=false;
                    enResizing=false;
                    esResizing=false;
                    wsResizing=false;
                    cursor=getCursorstate();
                    item.setCursor(cursor);
                    cursorOn="RECTANGLE";
                    //data.setUnHighlight(item);
                }else if(((((GLGLSetFunction)item).getX())+(((GLGLSetFunction)item).getWidth())-7)<=x
                        &&((((GLGLSetFunction)item).getX())+(((GLGLSetFunction)item).getWidth()))>=x
                        &&(((GLGLSetFunction)item).getY())<=y
                        &&(((GLGLSetFunction)item).getY()+7)>=y){
                    enResizing=true;
                    wResizing=false;
                    eResizing=false;
                    nResizing=false;
                    sResizing=false;
                    esResizing=false;
                    wnResizing=false;
                    wsResizing=false;
                    cursor=getCursorstate();
                    item.setCursor(cursor);
                    cursorOn="RECTANGLE";
                    //data.setUnHighlight(item);
                }else if((((GLGLSetFunction)item).getX()+(((GLGLSetFunction)item).getWidth())-7)<=x
                        &&(((GLGLSetFunction)item).getX()+(((GLGLSetFunction)item).getWidth()))>=x
                        &&(((GLGLSetFunction)item).getY()+((GLGLSetFunction)item).getHeight()-7)<=y
                        &&(((GLGLSetFunction)item).getY()+((GLGLSetFunction)item).getHeight())>=y){
                    esResizing=true;
                    wResizing=false;
                    eResizing=false;
                    nResizing=false;
                    sResizing=false;
                    enResizing=false;
                    wnResizing=false;
                    wsResizing=false;
                    cursor=getCursorstate();
                    item.setCursor(cursor);
                    cursorOn="RECTANGLE";
                    //data.setUnHighlight(item);
                }else if(((((GLGLSetFunction)item).getX())<=x)
                        &&((((((GLGLSetFunction)item).getX())+7)>=x))
                        &&(((GLGLSetFunction)item).getY()+((GLGLSetFunction)item).getHeight()-7)<=y
                        &&(((GLGLSetFunction)item).getY()+((GLGLSetFunction)item).getHeight())>=y){
                    wsResizing=true;
                    wResizing=false;
                    eResizing=false;
                    nResizing=false;
                    sResizing=false;
                    enResizing=false;
                    esResizing=false;
                    wnResizing=false;
                    cursor=getCursorstate();
                    item.setCursor(cursor);
                    cursorOn="RECTANGLE";
                    //data.setUnHighlight(item);
                }else if(((((GLGLSetFunction)item).getX()))<=x
                        &&((((GLGLSetFunction)item).getX())+7)>=x
                        &&(((((GLGLSetFunction)item).getY())+7)<=y
                        &&((((GLGLSetFunction)item).getY())+(((GLGLSetFunction)item).getHeight())-7)>=y)){
                    //(((((GLGLSetFunction)item).getX())-0.1)<x||((((GLGLSetFunction)item).getX())+0.1)>x)
                    wResizing=true;
                    eResizing=false;
                    nResizing=false;
                    sResizing=false;
                    enResizing=false;
                    esResizing=false;
                    wnResizing=false;
                    wsResizing=false;
                    cursor=getCursorstate();
                    item.setCursor(cursor);
                    cursorOn="RECTANGLE";
                    
                }else if(((((GLGLSetFunction)item).getX())+(((GLGLSetFunction)item).getWidth()))>=x
                        &&((((GLGLSetFunction)item).getX())+(((GLGLSetFunction)item).getWidth())-5)<=x
                        &&((((GLGLSetFunction)item).getY()+5)<y
                        &&((((GLGLSetFunction)item).getY())+(((GLGLSetFunction)item).getHeight())-5)>y)){
                    eResizing=true;
                    wResizing=false;
                    nResizing=false;
                    sResizing=false;
                    enResizing=false;
                    esResizing=false;
                    wnResizing=false;
                    wsResizing=false;
                    cursor=getCursorstate();
                    item.setCursor(cursor);
                    cursorOn="RECTANGLE";
                    //data.setUnHighlight(item);
                }else if((((GLGLSetFunction)item).getY())<=y
                        &&(((GLGLSetFunction)item).getY()+5)>=y
                        &&((((GLGLSetFunction)item).getX()+5)<=x
                        &&((((GLGLSetFunction)item).getX())+(((GLGLSetFunction)item).getWidth())-5)>=x)){
                    nResizing=true;
                    wResizing=false;
                    eResizing=false;
                    sResizing=false;
                    enResizing=false;
                    esResizing=false;
                    wnResizing=false;
                    wsResizing=false;
                    cursor=getCursorstate();
                    item.setCursor(cursor);
                    cursorOn="RECTANGLE";
                    
                }else if(((((GLGLSetFunction)item).getY())+(((GLGLSetFunction)item).getHeight()))>=y
                        &&((((GLGLSetFunction)item).getY())+(((GLGLSetFunction)item).getHeight())-5)<=y
                        &&((((GLGLSetFunction)item).getX()+5)<x
                        &&((((GLGLSetFunction)item).getX())+(((GLGLSetFunction)item).getWidth())-5)>x)){
                    sResizing=true;
                    wResizing=false;
                    eResizing=false;
                    nResizing=false;
                    enResizing=false;
                    esResizing=false;
                    wnResizing=false;
                    wsResizing=false;
                    cursor=getCursorstate();
                    item.setCursor(cursor);
                    cursorOn="RECTANGLE";
                    //data.setUnHighlight(item);

                }else{
                    cursor=null;
                    wResizing=false;
                    eResizing=false;
                    nResizing=false;
                    sResizing=false;
                    enResizing=false;
                    esResizing=false;
                    wnResizing=false;
                    wsResizing=false;
                    cursorOn=null;
                    
                    item.setCursor(getCursorstate());
                }
                  //if(((GLGLRectanglePrototype)item).c)
            }
        }
        
    }
    
    public void processCheckDoubleClicked(double x,double y){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
        if(data.isSelectedNode(item)&&item!=null&&((GLGLSetFunction)item).getType().equals("TEXT")){
            String content=textDialog.showTextInputDialog(app.getGUIModule().getWindow(), TDLM_TEXT_DIALOG_TITLE, TDLM_TEXT_DIALOG_CONTENT_LABEL);
            if(!content.isEmpty()){
              ((GLGLTextPrototype)item).setText(content); 
            }
            
        }
    }

    public void processChangeFont(ComboBox fontComboBox){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
        Font_Transaction transaction = new Font_Transaction(data, item,"font",fontComboBox.getValue().toString(),null);
        app.processTransaction(transaction);
 
    }
    public void processChangeFontSize(ComboBox fontSizeComboBox){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
        Font_Transaction transaction = new Font_Transaction(data, item,"fontSize",fontSizeComboBox.getValue().toString(),null);
        app.processTransaction(transaction);
    }
    public void processDoubleFontSize(){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
        
        Font_Transaction transaction = new Font_Transaction(data, item,"addFontSize",String.valueOf(((GLGLTextPrototype)item).getFont().getSize()),null);
        app.processTransaction(transaction);  
          ((ComboBox)app.getGUIModule().getGUINode(TDLM_FONT_SIZE_COMBO_BOX)).setValue((int)(((GLGLTextPrototype)item).getFont().getSize()));
    }
    public void processHalfFontSize(){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
        
        Font_Transaction transaction = new Font_Transaction(data, item,"reduceFontSize",String.valueOf(((GLGLTextPrototype)item).getFont().getSize()),null);
        app.processTransaction(transaction);  
         ((ComboBox)app.getGUIModule().getGUINode(TDLM_FONT_SIZE_COMBO_BOX)).setValue((int)(((GLGLTextPrototype)item).getFont().getSize()));
    }
    public void processChangeBold(){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
        if(!((GLGLTextPrototype)item).getFont().getStyle().contains("Bold")){
            Font_Transaction transaction = new Font_Transaction(data, item,"bold","BOLD",null);
            app.processTransaction(transaction);
        }else if(((GLGLTextPrototype)item).getFont().getStyle().contains("Bold")){
            Font_Transaction transaction = new Font_Transaction(data, item,"bold","LIGHT",null);
            app.processTransaction(transaction);
        }
    }
    
    public void processChangeItalic(){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();

        if(!((GLGLTextPrototype)item).getFont().getStyle().contains("Italic")){
            Font_Transaction transaction = new Font_Transaction(data, item,"italic","ITALIC",null);
            app.processTransaction(transaction);
        }else if(((GLGLTextPrototype)item).getFont().getStyle().contains("Italic")){
            Font_Transaction transaction = new Font_Transaction(data, item,"italic","REGULAR",null);
            app.processTransaction(transaction);
        }
    }
    
    public void processChangeFontColor(ColorPicker fontColorPicker){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
       // ((GLGLTextPrototype)item).setFill(fontColorPicker.getValue());
        Font_Transaction transaction = new Font_Transaction(data, item,"color"," ",fontColorPicker.getValue());
        app.processTransaction(transaction);

    }
    public void processChangeThicknessPressed(Slider thickness){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
        oldBorderThickness=((GLGLSetFunction)item).getStrokeWidth();
        ((GLGLSetFunction)item).setStrokeWidth(thickness.getValue()); 
    }
    public void processChangeThicknessDragged(Slider thickness){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
        ((GLGLSetFunction)item).setStrokeWidth(thickness.getValue()); 
    }
    public void processChangeThicknessReleased(Slider thickness){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
        newBorderThickness=thickness.getValue();
        //((GLGLSetFunction)item).setStrokeWidth(thickness.getValue()); 
        BorderThickness_Transaction transaction = new BorderThickness_Transaction(data,item,oldBorderThickness,newBorderThickness);
        app.processTransaction(transaction);
        //app.getFoolproofModule().updateAll();
    }
    public void processChangeBorderColor(ColorPicker picker){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
        BorderColor_Transaction transaction = new BorderColor_Transaction(data,item,picker.getValue());
        app.processTransaction(transaction);
        //((GLGLSetFunction)item).setStroke((Paint)(picker.getValue()));
    }
    public void processChangeBorderRadiusPressed(Slider slider){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();  
        
        if(((GLGLSetFunction)item).getType().equals("RECTANGLE"))
         oldBorderRadius=((GLGLRectanglePrototype)item).getArcHeight();
        ((GLGLRectanglePrototype)item).setArcWidth(slider.getValue());
        ((GLGLRectanglePrototype)item).setArcHeight(slider.getValue());
    }
    public void processChangeBorderRadiusDragged(Slider slider){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();  
        //((GLGLSetFunction)item);
        if(((GLGLSetFunction)item).getType().equals("RECTANGLE"))
        ((GLGLRectanglePrototype)item).setArcWidth(slider.getValue());
        ((GLGLRectanglePrototype)item).setArcHeight(slider.getValue());
    }
    public void processChangeBorderRadiusReleased(Slider slider){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();  
        if(((GLGLSetFunction)item).getType().equals("RECTANGLE")){
            newBorderRadius=slider.getValue();
            BorderRadius_Transaction transaction = new BorderRadius_Transaction(data,item,oldBorderRadius,newBorderRadius);
            app.processTransaction(transaction);
        }
//        ((GLGLRectanglePrototype)item).setArcWidth(slider.getValue());
//        ((GLGLRectanglePrototype)item).setArcHeight(slider.getValue());
            
    }
    
    
    public void processChangeFocusAngle(double oldValue, double newValue){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
        if(item!=null){
            RadialGradient colortype=new RadialGradient(newValue, 
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
    public void processChangeFocusDistance(double oldValue, double newValue){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
        if(item!=null){
            RadialGradient colortype=new RadialGradient(((GLGLSetFunction)item).getColorGradient().getFocusAngle(), 
                                            newValue,
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
    
    public void processChangeCanterX(double oldValue,double newValue){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
        if(item!=null){
            RadialGradient colortype=new RadialGradient(((GLGLSetFunction)item).getColorGradient().getFocusAngle(), 
                                            ((GLGLSetFunction)item).getColorGradient().getFocusDistance(),
                                            newValue,
                                            ((GLGLSetFunction)item).getColorGradient().getCenterY(), 
                                            ((GLGLSetFunction)item).getColorGradient().getRadius(),
                                             false,
                                            ((GLGLSetFunction)item).getColorGradient().getCycleMethod(),
                                            new Stop(0,((GLGLSetFunction)item).getColorGradient().getStops().get(0).getColor()) ,
                                           new Stop(1,((GLGLSetFunction)item).getColorGradient().getStops().get(1).getColor()));
            ((GLGLSetFunction)item).setColorGradient(colortype);
        }
    }
    public void processChangeCanterY(double oldValue,double newValue){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
        if(item!=null){
            RadialGradient colortype=new RadialGradient(((GLGLSetFunction)item).getColorGradient().getFocusAngle(), 
                                            ((GLGLSetFunction)item).getColorGradient().getFocusDistance(),
                                            ((GLGLSetFunction)item).getColorGradient().getCenterX(),
                                            newValue, 
                                            ((GLGLSetFunction)item).getColorGradient().getRadius(),
                                             false,
                                            ((GLGLSetFunction)item).getColorGradient().getCycleMethod(),
                                           new Stop(0,((GLGLSetFunction)item).getColorGradient().getStops().get(0).getColor()) ,
                                            new Stop(1,((GLGLSetFunction)item).getColorGradient().getStops().get(1).getColor()));
            ((GLGLSetFunction)item).setColorGradient(colortype);
        }
    }
    public void processChangeRadius(double oldValue,double newValue){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
        if(item!=null){
            RadialGradient colortype=new RadialGradient(((GLGLSetFunction)item).getColorGradient().getFocusAngle(), 
                                            ((GLGLSetFunction)item).getColorGradient().getFocusDistance(),
                                            ((GLGLSetFunction)item).getColorGradient().getCenterX(),
                                           ((GLGLSetFunction)item).getColorGradient().getCenterY(), 
                                            newValue,
                                             false,
                                            ((GLGLSetFunction)item).getColorGradient().getCycleMethod(),
                                           new Stop(0,((GLGLSetFunction)item).getColorGradient().getStops().get(0).getColor()) ,
                                          new Stop(1,((GLGLSetFunction)item).getColorGradient().getStops().get(1).getColor()));
            ((GLGLSetFunction)item).setColorGradient(colortype);
        }
    }
    public void processChangeCycleMethod(CycleMethod oldValue,CycleMethod newValue){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
        if(item!=null){
            RadialGradient colortype=new RadialGradient(((GLGLSetFunction)item).getColorGradient().getFocusAngle(), 
                                            ((GLGLSetFunction)item).getColorGradient().getFocusDistance(),
                                            ((GLGLSetFunction)item).getColorGradient().getCenterX(),
                                           ((GLGLSetFunction)item).getColorGradient().getCenterY(), 
                                            ((GLGLSetFunction)item).getColorGradient().getRadius(),
                                             false,
                                            newValue,
                                             new Stop(0,((GLGLSetFunction)item).getColorGradient().getStops().get(0).getColor()) ,
                                            new Stop(1,((GLGLSetFunction)item).getColorGradient().getStops().get(1).getColor()));
            ((GLGLSetFunction)item).setColorGradient(colortype);
        }
    }
    public void processChangeStep0(Color oldValue,Color newValue){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
        if(item!=null){
            RadialGradient colortype=new RadialGradient(((GLGLSetFunction)item).getColorGradient().getFocusAngle(), 
                                            ((GLGLSetFunction)item).getColorGradient().getFocusDistance(),
                                            ((GLGLSetFunction)item).getColorGradient().getCenterX(),
                                           ((GLGLSetFunction)item).getColorGradient().getCenterY(), 
                                            ((GLGLSetFunction)item).getColorGradient().getRadius(),
                                             false,
                                            ((GLGLSetFunction)item).getColorGradient().getCycleMethod(),
                                           new Stop(0,newValue) ,
                                             new Stop(1,((GLGLSetFunction)item).getColorGradient().getStops().get(1).getColor()));
            ((GLGLSetFunction)item).setColorGradient(colortype);
        }
    }
    
    public void processChangeStep1(Color oldValue,Color newValue){
        GLGLData data = (GLGLData)app.getDataComponent();
        Node item=data.getSelectedNode();
        if(item!=null){
            RadialGradient colortype=new RadialGradient(((GLGLSetFunction)item).getColorGradient().getFocusAngle(), 
                                            ((GLGLSetFunction)item).getColorGradient().getFocusDistance(),
                                            ((GLGLSetFunction)item).getColorGradient().getCenterX(),
                                           ((GLGLSetFunction)item).getColorGradient().getCenterY(), 
                                            ((GLGLSetFunction)item).getColorGradient().getRadius(),
                                             false,
                                            ((GLGLSetFunction)item).getColorGradient().getCycleMethod(),
                                           new Stop(0,((GLGLSetFunction)item).getColorGradient().getStops().get(0).getColor()) ,
                                            new Stop(1,newValue));
            ((GLGLSetFunction)item).setColorGradient(colortype);
        }
    }
    
    
    
    
    
    
    public void processResizeWorkspace() {
        
        GologoloResizeDialog resizeDialog=new GologoloResizeDialog(app);
        resizeDialog.showResizeDialog();
       
            double newheight=resizeDialog.getNewHeight();
             double newwidth=resizeDialog.getNewWidth();
             System.out.println("height"+newheight+"        width    "+newwidth);
            app.getGUIModule().getGUINode(TDLM_SMALL_WORK_SPACE_PANE).setClip(new Rectangle(0, 0, newwidth, newheight));

        
    }

    public void processZoomIn(){
        double  oldheight=app.getGUIModule().getGUINode(TDLM_SMALL_WORK_SPACE_PANE).getLayoutBounds().getHeight();
       double  oldwidth=app.getGUIModule().getGUINode(TDLM_SMALL_WORK_SPACE_PANE).getLayoutBounds().getWidth();
        
        app.getGUIModule().getGUINode(TDLM_SMALL_WORK_SPACE_PANE).setScaleX(oldwidth);
        app.getGUIModule().getGUINode(TDLM_SMALL_WORK_SPACE_PANE).setScaleY(oldheight);
    }
    
    
    
    
    
    
    public void processRemoveItems() {
//        GLGLData data = (GLGLData)app.getDataComponent();
//        if (data.isItemSelected() || data.areItemsSelected()) {
//            ArrayList<GLGLPrototype> itemsToRemove = new ArrayList(data.getSelectedItems());
//            RemoveItems_Transaction transaction = new RemoveItems_Transaction(app, itemsToRemove);
//            app.processTransaction(transaction);
//        }
    }

    public void processEditItem() {
        GLGLData data = (GLGLData)app.getDataComponent();
        Node itemToEdit = data.getSelectedItem();
        String content=textDialog.showTextInputDialog(app.getGUIModule().getWindow(), TDLM_TEXT_DIALOG_TITLE, TDLM_TEXT_DIALOG_CONTENT_LABEL);
        EditItem_Transaction transaction = new EditItem_Transaction(data, itemToEdit,content);
        app.processTransaction(transaction);
            
        
    }
    
    public void processMoveItemUp() {
//        GLGLData data = (GLGLData)app.getDataComponent();
//        if (data.isItemSelected()) {
//            Node itemToMove = data.getSelectedItem();
//            int oldIndex = data.getItemIndex(itemToMove);
//            if (oldIndex > 0) {
//                MoveItem_Transaction transaction = new MoveItem_Transaction(data, oldIndex, oldIndex-1);
//                app.processTransaction(transaction);
//                
//                // DESELECT THE OLD INDEX
//                data.clearSelected();
//                
//                // AND SELECT THE MOVED ONE
//                data.selectItem(itemToMove);
//                
//                // UPDATE BUTTONS
//                app.getFoolproofModule().updateAll();
//            }
//        }
    }
    


}
    


