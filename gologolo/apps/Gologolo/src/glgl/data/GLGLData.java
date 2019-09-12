package glgl.data;

import djf.components.AppDataComponent;
import djf.modules.AppGUIModule;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import tdlm.GLGLApp;
import static tdlm.GLGLPropertyType.TDLM_ITEMS_TABLE_VIEW;
import static tdlm.GLGLPropertyType.TDLM_SMALL_WORK_SPACE_PANE;


/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class GLGLData implements AppDataComponent {
    GLGLApp app;
    ObservableList<Node> items;
    Node selectedNode=null;
    TableViewSelectionModel itemsSelectionModel;
    DropShadow highlightEffect = new DropShadow();
    DropShadow unHighlightEffect = new DropShadow();
    public static int count=0;
	


    
    public GLGLData(GLGLApp initApp) {
        app = initApp;
        
        // GET ALL THE THINGS WE'LL NEED TO MANIUPLATE THE TABLE
        TableView tableView = (TableView) app.getGUIModule().getGUINode(TDLM_ITEMS_TABLE_VIEW);
        items = tableView.getItems();
        itemsSelectionModel = tableView.getSelectionModel();
        itemsSelectionModel.setSelectionMode(SelectionMode.MULTIPLE);
 
    }
    
  
    public Iterator<Node> itemsIterator() {
        return this.items.iterator();
    }
    

    
    
    public void addText(GLGLTextPrototype newText){
        count++;
       newText.setOrder(String.valueOf(count));
       addItem(newText);
        
    }
    public void removeText(GLGLTextPrototype newText){
        count--;
        newText.setOrder(String.valueOf(count));
       Pane workspace =(Pane)app.getGUIModule().getGUINode(TDLM_SMALL_WORK_SPACE_PANE);
       workspace.getChildren().remove(newText);
       items.remove(newText);
       selectedNode=null;
        
    }
    public void addRectangle(GLGLRectanglePrototype newRectangle){
        count++;
        newRectangle.setOrder(String.valueOf(count));
        addItem(newRectangle); 
        
    }
    public void removeRectangle(GLGLRectanglePrototype newRectangle){
        count--;
        Pane workspace =(Pane)app.getGUIModule().getGUINode(TDLM_SMALL_WORK_SPACE_PANE);
        workspace.getChildren().remove(newRectangle);
        items.remove(newRectangle); 
        selectedNode=null;
    }
    
    public void addImage(GLGLImagePrototype newImage){
        count++;
        newImage.setOrder(String.valueOf(count));
        addItem(newImage); 
    }
    
    public void addCircle(GLGLCirclePrototype newCircle){
        count++;
        newCircle.setOrder(String.valueOf(count));
        addItem(newCircle); 
    }
    
    public void removeCircle(GLGLCirclePrototype newCircle){
        count--;
        Pane workspace =(Pane)app.getGUIModule().getGUINode(TDLM_SMALL_WORK_SPACE_PANE);
        workspace.getChildren().remove(newCircle);
        items.remove(newCircle); 
        selectedNode=null;
    }
    public void delete(Node item){
       count--;
       Pane workspace =(Pane)app.getGUIModule().getGUINode(TDLM_SMALL_WORK_SPACE_PANE);
       workspace.getChildren().remove(item);
       items.remove(item);
       selectedNode=null;
       
    }
    public void resetOrder(){
        for(int i=0;i<items.size();i++){
            ((GLGLSetFunction)(items.get(i))).setOrder(String.valueOf(i+1));
        }
    }
    
    public Node getTopNode(double x,double y){
        for(int i=0;i<items.size();i++){
           if(items.get(i).contains(x, y)) {
               return items.get(i);
            }
        }
        return null;
    }
    
    public void selectNode(Node item){
        if(item==null){
        }else if(item!=null&&selectedNode!=null){
            setUnHighlight(selectedNode);
            selectedNode=item;
            setHighlight(selectedNode);
        }else{
            selectedNode=item;
            setHighlight(selectedNode);
        }
        
        itemsSelectionModel.clearAndSelect(items.indexOf(selectedNode));
        app.getFoolproofModule().updateAll();
        
        
    }
    public void selectTableItem(GLGLData data){
        for(int i=0;i<items.size();i++){
            if(itemsSelectionModel.isSelected(i)){
                selectNode(items.get(i));//selectedNode(items.get(i));
            }
        }
        
    }
    
    public void unselectSelectedNode(){
        if(selectedNode==null){
            selectedNode=null;
        }else{
            setUnHighlight(selectedNode);
            selectedNode=null;
        }
    }
    public boolean isSelectedNode(Node item){
        if(item==selectedNode){
            return true;
        }else{
            return false;
        }
    }
    public void setHighlight(Node item){
        highlightEffect.setColor(Color.BLUE);
        item.setEffect(highlightEffect);
    }
    
    public void setUnHighlight(Node item){
        unHighlightEffect.setColor(Color.TRANSPARENT);
        item.setEffect(unHighlightEffect);
    }
    
    public Node getSelectedNode(){
        return selectedNode;
    }
    
    
    
    
    
    
    
    @Override
    public void reset() {
        AppGUIModule gui = app.getGUIModule();
        
        // CLEAR OUT THE TEXT FIELDS
        
        // CLEAR OUT THE ITEMS FROM THE TABLE
        TableView tableView = (TableView)gui.getGUINode(TDLM_ITEMS_TABLE_VIEW);
        items = tableView.getItems();
        items.clear();
    }

    public boolean isItemSelected() {
        if(selectedNode!=null)
            return true;
        else
            return false;
//        Node selectedItems = this.getSelectedItems();
//        return (selectedItems != null);
    }
    
    

    public boolean isValidToDoItemEdit(GLGLSetFunction itemToEdit, String category, String description) {
        return isValidNewToDoItem(category, description);
    }

    public boolean isValidNewToDoItem(String category, String description) {
        if (category.trim().length() == 0)
            return false;
        if (description.trim().length() == 0)
            return false;
        return true;
    }

    public void addItem(Node itemToAdd) {
        items.add(0,itemToAdd);
        Pane workspace =(Pane)app.getGUIModule().getGUINode(TDLM_SMALL_WORK_SPACE_PANE);
        workspace.getChildren().add(itemToAdd);
        resetOrder();
        
    }

    
    
    public void removeItem(Node itemToRemove) {
        items.remove(itemToRemove);
        Pane workspace =(Pane)app.getGUIModule().getGUINode(TDLM_SMALL_WORK_SPACE_PANE);
        workspace.getChildren().remove(itemToRemove);
        selectedNode=null;
        resetOrder();
    }

    public Node getSelectedItem() {
        if (!isItemSelected()) {
            return null;
        }
        return getSelectedItems();
    }
    
    public Node getSelectedItems() {
        return (Node)this.itemsSelectionModel.getSelectedItem();
    }

    public int getItemIndex(Node item) {
        return items.indexOf(item);
    }

    public void addItemAt(Node item, int itemIndex) {
        items.add(itemIndex, item);
        Pane workspace =(Pane)app.getGUIModule().getGUINode(TDLM_SMALL_WORK_SPACE_PANE);
        workspace.getChildren().add((workspace.getChildren().size())-itemIndex,item);
        resetOrder();
        selectNode(item);
        
    }

    public void moveItem(Node item,double x,double y) {
        ((GLGLSetFunction)(item)).setLocation(x, y);
        
    }

    public int getNumItems() {
        return items.size();
    }

    public void selectItem(Node itemToSelect) {
        this.itemsSelectionModel.select(itemToSelect);
    }

    public ArrayList<Integer> removeAll(ArrayList<Node> itemsToRemove) {
        ArrayList<Integer> itemIndices = new ArrayList();
        for (Node item: itemsToRemove) {
            itemIndices.add(items.indexOf(item));
        }
        for (Node item: itemsToRemove) {
            items.remove(item);
        }
        return itemIndices;
    }

    public void addAll(ArrayList<Node> itemsToAdd, ArrayList<Integer> addItemLocations) {
        for (int i = 0; i < itemsToAdd.size(); i++) {
            Node itemToAdd = itemsToAdd.get(i);
            Integer location = addItemLocations.get(i);
            items.add(location, itemToAdd);
        }
    }

    public ArrayList<GLGLSetFunction> getCurrentItemsOrder() {
        ArrayList<GLGLSetFunction> orderedItems = new ArrayList();
        for (Node item : items) {
            orderedItems.add((GLGLSetFunction)item);
        }
        return orderedItems;
    }

    public void clearSelected() {
        this.itemsSelectionModel.clearSelection();
    }

    public void sortItems(Comparator sortComparator) {
        Collections.sort(items, sortComparator);
    }

    public void rearrangeItems(ArrayList<GLGLSetFunction> oldListOrder) {
        items.clear();
        for (GLGLSetFunction item : oldListOrder) {
            items.add((Node)item);
        }
    }
}