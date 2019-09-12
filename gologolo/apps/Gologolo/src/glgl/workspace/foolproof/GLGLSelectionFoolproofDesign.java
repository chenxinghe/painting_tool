package glgl.workspace.foolproof;

import djf.modules.AppGUIModule;
import djf.ui.foolproof.FoolproofDesign;
import javafx.scene.control.TextField;
import tdlm.GLGLApp;
import static tdlm.GLGLPropertyType.TDLM_EDIT_ITEM_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_MOVE_DOWN_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_MOVE_UP_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_REMOVE_ITEM_BUTTON;
import glgl.data.GLGLData;
import glgl.data.GLGLSetFunction;

import javafx.scene.Node;
import static tdlm.GLGLPropertyType.TDLM_BOLD_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_BORDER_COLOR_COLOR_PICKER;
import static tdlm.GLGLPropertyType.TDLM_BORDER_RADIUS_Slider;
import static tdlm.GLGLPropertyType.TDLM_BORDER_THICKNESS_Slider;
import static tdlm.GLGLPropertyType.TDLM_CANTER_X_Slider;
import static tdlm.GLGLPropertyType.TDLM_CANTER_Y_Slider;
import static tdlm.GLGLPropertyType.TDLM_CYCLE_METHOD_COMBO_BOX;
import static tdlm.GLGLPropertyType.TDLM_DELETE_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_DOUBLE_SIZE_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_FONT_COMBO_BOX;
import static tdlm.GLGLPropertyType.TDLM_FONT_SIZE_COMBO_BOX;
import static tdlm.GLGLPropertyType.TDLM_FOUCS_ANGLE_Slider;
import static tdlm.GLGLPropertyType.TDLM_FOUCS_DISTANCE_Slider;
import static tdlm.GLGLPropertyType.TDLM_HALF_SIZE_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_ITALIC_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_RADIUS_Slider;
import static tdlm.GLGLPropertyType.TDLM_STEP_0_COLOR_COLOR_PICKER;
import static tdlm.GLGLPropertyType.TDLM_STEP_1_COLOR_COLOR_PICKER;
import static tdlm.GLGLPropertyType.TDLM_FONT_COLOR_PICKER;

/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class GLGLSelectionFoolproofDesign implements FoolproofDesign {
    GLGLApp app;
    
    public GLGLSelectionFoolproofDesign(GLGLApp initApp) {
        app = initApp;
    }

    @Override
    public void updateControls() {
        AppGUIModule gui = app.getGUIModule
        ();
       
        // CHECK AND SEE IF A TABLE ITEM IS SELECTED
        GLGLData data = (GLGLData)app.getDataComponent();
        boolean itemIsSelected = data.isItemSelected();
        gui.getGUINode(TDLM_EDIT_ITEM_BUTTON).setDisable(!itemIsSelected);
        gui.getGUINode(TDLM_DELETE_BUTTON).setDisable(!(itemIsSelected));
        gui.getGUINode(TDLM_FONT_COMBO_BOX).setDisable(!(itemIsSelected)||!((GLGLSetFunction)(data.getSelectedItem())).getType().equals("TEXT"));
        gui.getGUINode(TDLM_FONT_SIZE_COMBO_BOX).setDisable(!(itemIsSelected)||!((GLGLSetFunction)(data.getSelectedItem())).getType().equals("TEXT"));
        gui.getGUINode(TDLM_BOLD_BUTTON).setDisable(!(itemIsSelected)||!((GLGLSetFunction)(data.getSelectedItem())).getType().equals("TEXT"));
        gui.getGUINode(TDLM_ITALIC_BUTTON).setDisable(!(itemIsSelected)||!((GLGLSetFunction)(data.getSelectedItem())).getType().equals("TEXT"));
        gui.getGUINode(TDLM_DOUBLE_SIZE_BUTTON).setDisable(!(itemIsSelected)||!((GLGLSetFunction)(data.getSelectedItem())).getType().equals("TEXT"));
        gui.getGUINode(TDLM_HALF_SIZE_BUTTON).setDisable(!(itemIsSelected)||!((GLGLSetFunction)(data.getSelectedItem())).getType().equals("TEXT"));
        gui.getGUINode(TDLM_FONT_COLOR_PICKER).setDisable(!(itemIsSelected)||!((GLGLSetFunction)(data.getSelectedItem())).getType().equals("TEXT"));
        

        //for shapes
        gui.getGUINode(TDLM_BORDER_THICKNESS_Slider).setDisable(!(itemIsSelected)||((GLGLSetFunction)(data.getSelectedItem())).getType().equals("TEXT"));
        gui.getGUINode(TDLM_BORDER_COLOR_COLOR_PICKER).setDisable(!(itemIsSelected)||((GLGLSetFunction)(data.getSelectedItem())).getType().equals("TEXT"));
        gui.getGUINode(TDLM_BORDER_RADIUS_Slider).setDisable(!(itemIsSelected)||((GLGLSetFunction)(data.getSelectedItem())).getType().equals("TEXT")||((GLGLSetFunction)(data.getSelectedItem())).getType().equals("CIRCLE"));
        
        //for color grident
        gui.getGUINode(TDLM_FOUCS_ANGLE_Slider).setDisable(!(itemIsSelected)||((GLGLSetFunction)(data.getSelectedItem())).getType().equals("TEXT"));
        gui.getGUINode(TDLM_FOUCS_DISTANCE_Slider).setDisable(!(itemIsSelected)||((GLGLSetFunction)(data.getSelectedItem())).getType().equals("TEXT"));
        gui.getGUINode(TDLM_CANTER_X_Slider).setDisable(!(itemIsSelected)||((GLGLSetFunction)(data.getSelectedItem())).getType().equals("TEXT"));
        gui.getGUINode(TDLM_CANTER_Y_Slider).setDisable(!(itemIsSelected)||((GLGLSetFunction)(data.getSelectedItem())).getType().equals("TEXT"));
        gui.getGUINode(TDLM_RADIUS_Slider).setDisable(!(itemIsSelected)||((GLGLSetFunction)(data.getSelectedItem())).getType().equals("TEXT"));
        gui.getGUINode(TDLM_CYCLE_METHOD_COMBO_BOX).setDisable(!(itemIsSelected)||((GLGLSetFunction)(data.getSelectedItem())).getType().equals("TEXT"));
        gui.getGUINode(TDLM_STEP_0_COLOR_COLOR_PICKER).setDisable(!(itemIsSelected)||((GLGLSetFunction)(data.getSelectedItem())).getType().equals("TEXT"));
        gui.getGUINode(TDLM_STEP_1_COLOR_COLOR_PICKER).setDisable(!(itemIsSelected)||((GLGLSetFunction)(data.getSelectedItem())).getType().equals("TEXT"));
       // gui.getGUINode(TDLM_BORDER_RADIUS_Slider).setDisable(!(itemIsSelected)||((GLGLSetFunction)(data.getSelectedItem())).getNodeType().equals("TEXT"));
        
        
        
        
        if (itemIsSelected) {
            Node selectedItem = data.getSelectedItem();
            int index = data.getItemIndex(selectedItem);
            gui.getGUINode(TDLM_MOVE_UP_BUTTON).setDisable(index == 0);
            int numItems = data.getNumItems();
//            System.out.println("numItems: " + numItems);
//            System.out.println("index: " + index);
//            System.out.println("index == (data.getNumItems() - 1): " + (index == (data.getNumItems()-1)));
            gui.getGUINode(TDLM_MOVE_DOWN_BUTTON).setDisable(index == (numItems-1));
            gui.getGUINode(TDLM_BOLD_BUTTON).setDisable(!((GLGLSetFunction)(data.getSelectedItem())).getType().equals("TEXT"));
            
        }
        else {
            gui.getGUINode(TDLM_MOVE_UP_BUTTON).setDisable(!itemIsSelected);
            gui.getGUINode(TDLM_MOVE_DOWN_BUTTON).setDisable(!itemIsSelected);            
        }
    }
}