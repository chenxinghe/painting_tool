package GLGL.workspace;

import static djf.AppPropertyType.CYCLE_METHOD_OPTIONS;
import static djf.AppPropertyType.DEFAULT_CYCLE_METHOD_SIZE;
import static djf.AppPropertyType.DEFAULT_FONT;
import static djf.AppPropertyType.DEFAULT_FONT_SIZE;
import static djf.AppPropertyType.FONT_OPTIONS;
import static djf.AppPropertyType.FONT_SIZE_OPTIONS;
import djf.components.AppWorkspaceComponent;
import djf.modules.AppFoolproofModule;
import djf.modules.AppGUIModule;
import static djf.modules.AppGUIModule.DISABLED;
import static djf.modules.AppGUIModule.ENABLED;
import static djf.modules.AppGUIModule.FOCUS_TRAVERSABLE;
import static djf.modules.AppGUIModule.HAS_KEY_HANDLER;
import static djf.modules.AppGUIModule.NO_KEY_HANDLER;
import djf.ui.AppNodesBuilder;
import static djf.ui.style.DJFStyle.CLASS_DJF_TOOLBAR_PANE;
import java.awt.Rectangle;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import properties_manager.PropertiesManager;
import tdlm.GLGLApp;
import static tdlm.GLGLPropertyType.HAS_HOME;
import static tdlm.GLGLPropertyType.HAS_RESIZE;
import static tdlm.GLGLPropertyType.HAS_SNAP;
import static tdlm.GLGLPropertyType.HAS_ZOOM_IN;
import static tdlm.GLGLPropertyType.HAS_ZOOM_OUT;
import static tdlm.GLGLPropertyType.HOME_BUTTON;
import static tdlm.GLGLPropertyType.RESIZE_BUTTON;
import static tdlm.GLGLPropertyType.SNAP_BUTTON;
import static tdlm.GLGLPropertyType.SNAP_LABEL;
import static tdlm.GLGLPropertyType.TDLM_ADD_CIRCLE_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_ADD_IMAGE_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_FOOLPROOF_SETTINGS;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_BIG_HEADER;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_BUTTON;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_SHORT_COLUMN;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_LONG_COLUMN;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_PROMPT;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_TABLE;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_TEXT_FIELD;
import static tdlm.GLGLPropertyType.TDLM_PANE;
import static tdlm.GLGLPropertyType.TDLM_TO_DO_LIST_LABEL;

import static tdlm.GLGLPropertyType.TDLM_ITEMS_PANE;
import static tdlm.GLGLPropertyType.TDLM_ITEM_BUTTONS_PANE;
import static tdlm.GLGLPropertyType.TDLM_ADD_ITEM_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_ADD_RECTANGLE_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_ORDER_COLUMN;
import static tdlm.GLGLPropertyType.TDLM_NAME_COLUMN;
import static tdlm.GLGLPropertyType.TDLM_TYPE_COLUMN;
import static tdlm.GLGLPropertyType.TDLM_REMOVE_ITEM_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_EDIT_ITEM_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_MOVE_UP_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_MOVE_DOWN_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_ITEMS_TABLE_VIEW;
import glgl.workspace.controllers.ItemsController;
import glgl.workspace.controllers.ItemsTableController;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_BOX;
import glgl.data.GLGLData;
import glgl.data.GLGLRectanglePrototype;
import glgl.data.GLGLSetFunction;

import glgl.workspace.foolproof.GLGLSelectionFoolproofDesign;
import glgl.transactions.SortItems_Transaction;
import glgl.workspace.dialogs.ToDoListItemDialog;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.Node;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.text.Font;

import static tdlm.GLGLPropertyType.TDLM_MAIN_BORDER_PANE;
import static tdlm.GLGLPropertyType.TDLM_SHAPE_PANE;
import static tdlm.GLGLPropertyType.TDLM_ADD_TEXT_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_ADD_TRIANGLE_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_BOLD_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_BORDER_BOX;
import static tdlm.GLGLPropertyType.TDLM_BORDER_COLOR_COLOR_PICKER;
import static tdlm.GLGLPropertyType.TDLM_BORDER_COLOR_LABEL;
import static tdlm.GLGLPropertyType.TDLM_BORDER_RADIUS_LABEL;
import static tdlm.GLGLPropertyType.TDLM_BORDER_RADIUS_Slider;
import static tdlm.GLGLPropertyType.TDLM_BORDER_THICKNESS_LABEL;
import static tdlm.GLGLPropertyType.TDLM_BORDER_THICKNESS_Slider;
import static tdlm.GLGLPropertyType.TDLM_CANTER_X_LABEL;
import static tdlm.GLGLPropertyType.TDLM_CANTER_X_Slider;
import static tdlm.GLGLPropertyType.TDLM_CANTER_Y_LABEL;
import static tdlm.GLGLPropertyType.TDLM_CANTER_Y_Slider;
import static tdlm.GLGLPropertyType.TDLM_COLOR_GRADIENT;
import static tdlm.GLGLPropertyType.TDLM_COLOR_GRADIENT_LABEL;
import static tdlm.GLGLPropertyType.TDLM_CYCLE_METHOD_COMBO_BOX;
import static tdlm.GLGLPropertyType.TDLM_CYCLE_METHOD_LABEL;
import static tdlm.GLGLPropertyType.TDLM_DELETE_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_DOUBLE_SIZE_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_FIRST_FONT_PANE;
import static tdlm.GLGLPropertyType.TDLM_FOCUS_ANGLE_LABEL;
import static tdlm.GLGLPropertyType.TDLM_FOCUS_DISTANCE_LABEL;
import static tdlm.GLGLPropertyType.TDLM_FONT_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_FONT_COMBO_BOX;
import static tdlm.GLGLPropertyType.TDLM_FONT_PANE;
import static tdlm.GLGLPropertyType.TDLM_FONT_SIZE_COMBO_BOX;
import static tdlm.GLGLPropertyType.TDLM_FOUCS_ANGLE_Slider;
import static tdlm.GLGLPropertyType.TDLM_FOUCS_DISTANCE_Slider;
import static tdlm.GLGLPropertyType.TDLM_HALF_SIZE_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_ITALIC_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_RADIUS_LABEL;
import static tdlm.GLGLPropertyType.TDLM_RADIUS_Slider;
import static tdlm.GLGLPropertyType.TDLM_SMALL_WORK_SPACE_PANE;
import static tdlm.GLGLPropertyType.TDLM_STEP_0_COLOR_COLOR_PICKER;
import static tdlm.GLGLPropertyType.TDLM_STEP_0_COLOR_LABEL;
import static tdlm.GLGLPropertyType.TDLM_STEP_1_COLOR_COLOR_PICKER;
import static tdlm.GLGLPropertyType.TDLM_STEP_1_COLOR_LABEL;
import static tdlm.GLGLPropertyType.TDLM_TOOL_PANE;
import static tdlm.GLGLPropertyType.TDLM_WORK_SPACE_PANE;
import static tdlm.GLGLPropertyType.ZOOM_IN_BUTTON;
import static tdlm.GLGLPropertyType.ZOOM_OUT_BUTTON;
import static tdlm.workspace.style.TDLStyle.CLASS_DJF_ICON_BUTTON;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_BORDER_PANE;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_HOME_TOOLBAR;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_SMALL_PANE;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_TOOL_INNER_PANE;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_TOOL_OUTER_PANE;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_TOOL_PANE;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_WORK_SPACE_PANE;
import static tdlm.GLGLPropertyType.TDLM_FONT_COLOR_PICKER;
import static tdlm.GLGLPropertyType.TDLM_SMALL_WORK_SPACE_PANE;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_FONT_COLOR_PICKER;



/**
 *
 * @author McKillaGorilla
 * * @co-author Chenxing He
 *  *@version 1.1
 */
public class GLGLWorkspace extends AppWorkspaceComponent {

    public GLGLWorkspace(GLGLApp app) {
        super(app);

        // LAYOUT THE APP
        initLayout();
        
        // 
        initFoolproofDesign();
    }
        
    // THIS HELPER METHOD INITIALIZES ALL THE CONTROLS IN THE WORKSPACE
    private void initLayout() {
        // FIRST LOAD THE FONT FAMILIES FOR THE COMBO BOX
        PropertiesManager props = PropertiesManager.getPropertiesManager();
        
        // THIS WILL BUILD ALL OF OUR JavaFX COMPONENTS FOR US
        AppNodesBuilder tdlBuilder = app.getGUIModule().getNodesBuilder();
       // GologoloNodeBuilder goloNodeBuilder=app.getGUIModule().getNodesBuilder();
    // TOP TOOLBAR --HOME TOOLBAR----------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
        FlowPane   topToolBar=app.getGUIModule().getTopToolbarPane();
        ToolBar homeToolbar=new ToolBar();
        topToolBar.getChildren().add(3,homeToolbar);
       
        AppNodesBuilder nodesBuilder=new AppNodesBuilder(app.getGUIModule(), app.getLanguageModule());
        Button homeButton = nodesBuilder.buildIconButton(HOME_BUTTON, null, homeToolbar, CLASS_DJF_ICON_BUTTON, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        Button zoomInButton = nodesBuilder.buildIconButton(ZOOM_IN_BUTTON, null, homeToolbar, CLASS_DJF_ICON_BUTTON, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        Button zoomOutButton = nodesBuilder.buildIconButton(ZOOM_OUT_BUTTON, null, homeToolbar, CLASS_DJF_ICON_BUTTON, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        Button resizeButton = nodesBuilder.buildIconButton(RESIZE_BUTTON, null, homeToolbar, CLASS_DJF_ICON_BUTTON, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        CheckBox snapButton = nodesBuilder.buildCheckBox(SNAP_BUTTON, null, homeToolbar, null, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        Label    snapLabel =nodesBuilder.buildLabel(SNAP_LABEL, null, homeToolbar, CLASS_TDLM_BUTTON,HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
         ObservableList<String> styleClasses = homeToolbar.getStyleClass();
         styleClasses.add(CLASS_DJF_TOOLBAR_PANE);
        
        
        
        
        // left region---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        VBox itemsPane              = tdlBuilder.buildVBox(TDLM_ITEMS_PANE,   null,     null,   CLASS_TDLM_BOX, HAS_KEY_HANDLER,     FOCUS_TRAVERSABLE,  ENABLED);
        
        
        TableView<GLGLSetFunction> itemsTable  = tdlBuilder.buildTableView(TDLM_ITEMS_TABLE_VIEW,   itemsPane,   null,   CLASS_TDLM_TABLE, HAS_KEY_HANDLER,    FOCUS_TRAVERSABLE,  true);
        TableColumn orderColumn  = tdlBuilder.buildTableColumn(  TDLM_ORDER_COLUMN,    itemsTable,         CLASS_TDLM_SHORT_COLUMN);
        TableColumn nameColumn   = tdlBuilder.buildTableColumn(  TDLM_NAME_COLUMN, itemsTable,         CLASS_TDLM_SHORT_COLUMN);
        TableColumn typeColumn   = tdlBuilder.buildTableColumn(  TDLM_TYPE_COLUMN,    itemsTable,         CLASS_TDLM_SHORT_COLUMN);
        

        
        HBox itemButtonsPane        = tdlBuilder.buildHBox(TDLM_ITEM_BUTTONS_PANE,          itemsPane,          null,   CLASS_TDLM_TOOL_OUTER_PANE, HAS_KEY_HANDLER,     FOCUS_TRAVERSABLE,  ENABLED);
       // Button removeItemButton     = tdlBuilder.buildIconButton(TDLM_REMOVE_ITEM_BUTTON,   itemButtonsPane,    null,   CLASS_TDLM_BUTTON, HAS_KEY_HANDLER,   FOCUS_TRAVERSABLE,  DISABLED);
        Button editItemButton       = tdlBuilder.buildIconButton(TDLM_EDIT_ITEM_BUTTON,   itemButtonsPane,    null,   CLASS_TDLM_BUTTON, HAS_KEY_HANDLER,   FOCUS_TRAVERSABLE,  DISABLED);
        Button moveUpButton       = tdlBuilder.buildIconButton(TDLM_MOVE_UP_BUTTON,   itemButtonsPane,    null,   CLASS_TDLM_BUTTON, HAS_KEY_HANDLER,   FOCUS_TRAVERSABLE,  DISABLED);
        Button moveDownButton       = tdlBuilder.buildIconButton(TDLM_MOVE_DOWN_BUTTON,   itemButtonsPane,    null,   CLASS_TDLM_BUTTON, HAS_KEY_HANDLER,   FOCUS_TRAVERSABLE,  DISABLED);
        // SPECIFY THE TYPES FOR THE COLUMNS
        orderColumn.setCellValueFactory( new PropertyValueFactory<String,    String>("order"));
        nameColumn.setCellValueFactory(  new PropertyValueFactory<String,    String>("name"));
        typeColumn.setCellValueFactory(  new PropertyValueFactory<String,    String>("type"));
        
        //middle region-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        GridPane workspacePane     =    tdlBuilder.buildGridPane(TDLM_WORK_SPACE_PANE, null, null, CLASS_TDLM_WORK_SPACE_PANE,HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        Pane  smallWorkSpacePane =   tdlBuilder.buildPane(TDLM_SMALL_WORK_SPACE_PANE, workspacePane, null, CLASS_TDLM_SMALL_PANE, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
//        Pane smallWorkSpacePane=new Pane();
//        workspacePane.getChildren().add(smallWorkSpacePane);
//        app.getGUIModule().addGUINode(TDLM_SMALL_WORK_SPACE_PANE, workspacePane);
        
        
        

        //right region-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        VBox toolPane =      tdlBuilder.buildVBox(TDLM_TOOL_PANE, null,  null,CLASS_TDLM_TOOL_OUTER_PANE, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        HBox     shapePane         =    tdlBuilder.buildHBox(TDLM_SHAPE_PANE,         toolPane,     null,   CLASS_TDLM_TOOL_PANE, HAS_KEY_HANDLER,     FOCUS_TRAVERSABLE,  ENABLED);
        Button addTextButton     = tdlBuilder.buildIconButton(TDLM_ADD_TEXT_BUTTON,   shapePane,    null,   CLASS_TDLM_BUTTON, HAS_KEY_HANDLER,   FOCUS_TRAVERSABLE,  ENABLED);
        Button addImageButton     = tdlBuilder.buildIconButton(TDLM_ADD_IMAGE_BUTTON,   shapePane,    null,   CLASS_TDLM_BUTTON, HAS_KEY_HANDLER,   FOCUS_TRAVERSABLE,  ENABLED);
        Button addRectangleButton     = tdlBuilder.buildIconButton(TDLM_ADD_RECTANGLE_BUTTON,   shapePane,    null,   CLASS_TDLM_BUTTON, HAS_KEY_HANDLER,   FOCUS_TRAVERSABLE,  ENABLED);
        Button addCircleButton     = tdlBuilder.buildIconButton(TDLM_ADD_CIRCLE_BUTTON,   shapePane,    null,   CLASS_TDLM_BUTTON, HAS_KEY_HANDLER,   FOCUS_TRAVERSABLE,  ENABLED);
        Button addTriangleButton     = tdlBuilder.buildIconButton(TDLM_ADD_TRIANGLE_BUTTON,   shapePane,    null,   CLASS_TDLM_BUTTON, HAS_KEY_HANDLER,   FOCUS_TRAVERSABLE,  ENABLED);
        Button deleteButton          =  tdlBuilder.buildIconButton(TDLM_DELETE_BUTTON,   shapePane,    null,   CLASS_TDLM_BUTTON, HAS_KEY_HANDLER,   FOCUS_TRAVERSABLE,  ENABLED);
	
        
        VBox fontPane               =tdlBuilder.buildVBox(TDLM_FONT_PANE, toolPane,null, CLASS_TDLM_TOOL_PANE, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
	HBox firstFontPane          =tdlBuilder.buildHBox(TDLM_FIRST_FONT_PANE, fontPane, null, CLASS_TDLM_TOOL_INNER_PANE, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        //ToggleButton font           =tdlBuilder.buildIconToggleButton(TDLM_FONT_BUTTON, firstFontPane, null, CLASS_TDLM_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        ComboBox  fontComboBox          =tdlBuilder.buildComboBox(TDLM_FONT_COMBO_BOX, FONT_OPTIONS, DEFAULT_FONT, firstFontPane, null, CLASS_TDLM_SHORT_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        ComboBox  fontSizeComboBox          =tdlBuilder.buildComboBox(TDLM_FONT_SIZE_COMBO_BOX, FONT_SIZE_OPTIONS, DEFAULT_FONT_SIZE, firstFontPane, null, CLASS_TDLM_SHORT_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        fontComboBox.getItems().addAll(Font.getFamilies());
        //fontSizeComboBox.getItems().addAll(Font.getFontSize());
        
        HBox secondFontPane          =tdlBuilder.buildHBox(TDLM_FIRST_FONT_PANE, fontPane, null, CLASS_TDLM_TOOL_INNER_PANE, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        Button boldButton     = tdlBuilder.buildIconButton(TDLM_BOLD_BUTTON,   secondFontPane,    null,   CLASS_TDLM_BUTTON, HAS_KEY_HANDLER,   FOCUS_TRAVERSABLE,  ENABLED);
        Button italicButton     = tdlBuilder.buildIconButton(TDLM_ITALIC_BUTTON,   secondFontPane,    null,   CLASS_TDLM_BUTTON, HAS_KEY_HANDLER,   FOCUS_TRAVERSABLE,  ENABLED);
        Button doubleSizeButton  = tdlBuilder.buildIconButton(TDLM_DOUBLE_SIZE_BUTTON,   secondFontPane,    null,   CLASS_TDLM_BUTTON, HAS_KEY_HANDLER,   FOCUS_TRAVERSABLE,  ENABLED);
        Button halfSizeButton     = tdlBuilder.buildIconButton(TDLM_HALF_SIZE_BUTTON,   secondFontPane,    null,   CLASS_TDLM_BUTTON, HAS_KEY_HANDLER,   FOCUS_TRAVERSABLE,  ENABLED);
        ColorPicker fontColorPicker= tdlBuilder.buildColorPicker(TDLM_FONT_COLOR_PICKER, secondFontPane, null, CLASS_TDLM_FONT_COLOR_PICKER, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        //Button underlineButton   =  tdlBuilder.buildIconButton(TDLM_FONT_COLOR_PICKER,   secondFontPane,    null,   CLASS_TDLM_BUTTON, HAS_KEY_HANDLER,   FOCUS_TRAVERSABLE,  ENABLED);        
        
        VBox borderBox           =tdlBuilder.buildVBox(TDLM_BORDER_BOX, toolPane,null, CLASS_TDLM_TOOL_PANE, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        Label  borderThickness       =tdlBuilder.buildLabel(TDLM_BORDER_THICKNESS_LABEL, borderBox, null, CLASS_TDLM_LONG_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        Slider borderThicknessSlider =tdlBuilder.buildSlider(TDLM_BORDER_THICKNESS_Slider,  borderBox, null, CLASS_TDLM_LONG_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED ,0, 100);
        Label  borderColor       =tdlBuilder.buildLabel(TDLM_BORDER_COLOR_LABEL, borderBox, null, CLASS_TDLM_SHORT_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        ColorPicker  borderColorColorPicker   =tdlBuilder.buildColorPicker(TDLM_BORDER_COLOR_COLOR_PICKER, borderBox, null, CLASS_TDLM_LONG_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        
        //ComboBox  borderColorComboBox      =tdlBuilder.buildComboBox(TDLM_BORDER_COLOR_COMBO_BOX, FONT_SIZE_OPTIONS, DEFAULT_FONT_SIZE, borderBox, null, CLASS_TDLM_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        Label  borderRadius       =tdlBuilder.buildLabel(TDLM_BORDER_RADIUS_LABEL, borderBox, null, CLASS_TDLM_SHORT_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        Slider borderRadiusSlider =tdlBuilder.buildSlider(TDLM_BORDER_RADIUS_Slider, borderBox, null, CLASS_TDLM_LONG_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED ,0, 100);
        
        
        
        
        VBox colorGridient               =tdlBuilder.buildVBox(TDLM_COLOR_GRADIENT, toolPane,null, CLASS_TDLM_TOOL_PANE, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        Label  colorGridientLabel        =tdlBuilder.buildLabel(TDLM_COLOR_GRADIENT_LABEL, colorGridient, null, CLASS_TDLM_SHORT_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        Label  focusAngleLabel        =tdlBuilder.buildLabel(TDLM_FOCUS_ANGLE_LABEL, colorGridient, null, CLASS_TDLM_SHORT_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        Slider focusAngleSlider             =tdlBuilder.buildSlider(TDLM_FOUCS_ANGLE_Slider, colorGridient, null, CLASS_TDLM_LONG_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED ,0, 100);
        Label  focusDistanceLabel        =tdlBuilder.buildLabel(TDLM_FOCUS_DISTANCE_LABEL, colorGridient, null, CLASS_TDLM_SHORT_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        Slider focusDistanceSlider             =tdlBuilder.buildSlider(TDLM_FOUCS_DISTANCE_Slider, colorGridient, null, CLASS_TDLM_LONG_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED ,0, 100);
        Label  canterXLabel        =tdlBuilder.buildLabel(TDLM_CANTER_X_LABEL, colorGridient, null, CLASS_TDLM_SHORT_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        Slider canterXSlider             =tdlBuilder.buildSlider(TDLM_CANTER_X_Slider,colorGridient, null, CLASS_TDLM_LONG_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED ,0, 100);
        Label  canterYLabel        =tdlBuilder.buildLabel(TDLM_CANTER_Y_LABEL, colorGridient, null, CLASS_TDLM_SHORT_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        Slider canterYSlider             =tdlBuilder.buildSlider(TDLM_CANTER_Y_Slider,colorGridient, null, CLASS_TDLM_LONG_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED ,0, 100);
        Label  RadiusLabel        =tdlBuilder.buildLabel(TDLM_RADIUS_LABEL, colorGridient, null, CLASS_TDLM_SHORT_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        Slider radiusSlider             =tdlBuilder.buildSlider(TDLM_RADIUS_Slider,colorGridient, null, CLASS_TDLM_LONG_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED ,0, 100);
        Label  cycleMethodLabel        =tdlBuilder.buildLabel(TDLM_CYCLE_METHOD_LABEL, colorGridient, null, CLASS_TDLM_SHORT_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        ComboBox  cycleMethodComboBox      =tdlBuilder.buildComboBox(TDLM_CYCLE_METHOD_COMBO_BOX, CYCLE_METHOD_OPTIONS, DEFAULT_CYCLE_METHOD_SIZE, colorGridient, null, CLASS_TDLM_LONG_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        Label  step0ColorLabel        =tdlBuilder.buildLabel(TDLM_STEP_0_COLOR_LABEL, colorGridient, null, CLASS_TDLM_SHORT_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        ColorPicker  step0ColorColorPicker   =tdlBuilder.buildColorPicker(TDLM_STEP_0_COLOR_COLOR_PICKER, colorGridient, null, CLASS_TDLM_LONG_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        Label  step1ColorLabel        =tdlBuilder.buildLabel(TDLM_STEP_1_COLOR_LABEL, colorGridient, null, CLASS_TDLM_SHORT_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);
        ColorPicker  step1ColorColorPicker   =tdlBuilder.buildColorPicker(TDLM_STEP_1_COLOR_COLOR_PICKER, colorGridient, null, CLASS_TDLM_LONG_COLUMN, HAS_KEY_HANDLER, FOCUS_TRAVERSABLE, ENABLED);

        
        
        
        
        
        
        
        //slider.valueProperty.getValue().......
        
        
        
        
        
        
        
        
        
        workspace = new BorderPane();
	((BorderPane)workspace).setCenter(workspacePane);
        ((BorderPane)workspace).setLeft(itemsPane);
        ((BorderPane)workspace).setRight(toolPane);

        // AND NOW SETUP ALL THE EVENT HANDLING CONTROLLERS
        
        ItemsController itemsController = new ItemsController((GLGLApp)app);
        resizeButton.setOnAction(e->{
            itemsController.processResizeWorkspace();
       });
        addTextButton.setOnAction(e ->{
            itemsController.processAddTextItem();
        });
        addRectangleButton.setOnAction(e ->{
            itemsController.processAddRectangleItem();
        });
        addCircleButton.setOnAction(e ->{
            itemsController.processAddCircle();
        });
        
        addImageButton.setOnAction(e ->{
            itemsController.processAddImage();
        });
        
        deleteButton.setOnAction(e ->{
            itemsController.processDeleteItem();
        });
        moveUpButton.setOnAction(e ->{
            itemsController.processMoveItemToFront();
        });
        moveDownButton.setOnAction(e ->{
            itemsController.processMoveItemToBack();
        });
        editItemButton.setOnAction(e ->{
            itemsController.processEditItem();
        });
        fontComboBox.setOnAction(e ->{
            itemsController.processChangeFont(fontComboBox);
        });
        fontSizeComboBox.setOnAction(e ->{
            itemsController.processChangeFontSize(fontSizeComboBox);
        });
        boldButton.setOnAction(e ->{
            itemsController.processChangeBold();
        });
        italicButton.setOnAction(e ->{
            itemsController.processChangeItalic();
        });
        fontColorPicker.setOnAction(e ->{
            itemsController.processChangeFontColor(fontColorPicker);
        });
        doubleSizeButton.setOnAction(e ->{
            itemsController.processDoubleFontSize();
        });
        //underlineButton
        halfSizeButton.setOnAction(e ->{
            itemsController.processHalfFontSize();
        });
        
//        zoomInButton.setOn
        
        borderThicknessSlider.setOnMousePressed(e ->{
            itemsController.processChangeThicknessPressed(borderThicknessSlider);
        });
        borderThicknessSlider.setOnMouseDragged(e ->{
            itemsController.processChangeThicknessDragged(borderThicknessSlider);
        });
        borderThicknessSlider.setOnMouseReleased(e ->{
            itemsController.processChangeThicknessReleased(borderThicknessSlider);
        });
        borderColorColorPicker.setOnAction(e ->{
            itemsController.processChangeBorderColor(borderColorColorPicker);
        });
        borderRadiusSlider.setOnMousePressed(e ->{
            itemsController.processChangeBorderRadiusPressed(borderRadiusSlider);
        });
        borderRadiusSlider.setOnMouseDragged(e ->{
            itemsController.processChangeBorderRadiusDragged(borderRadiusSlider);
        });
        borderRadiusSlider.setOnMouseReleased(e ->{
            itemsController.processChangeBorderRadiusReleased(borderRadiusSlider);
        });
        
        focusAngleSlider.valueProperty().addListener((v,oldValue,newValue)->{
            itemsController.processChangeFocusAngle((double)(oldValue),(double)newValue);
        });
        
        focusDistanceSlider.valueProperty().addListener((v,oldValue,newValue)->{
            itemsController.processChangeFocusDistance((double)(oldValue),(double)newValue);
        });
        canterXSlider.valueProperty().addListener((v,oldValue,newValue)->{
            itemsController.processChangeCanterX((double)(oldValue),(double)newValue);
        });
        canterYSlider.valueProperty().addListener((v,oldValue,newValue)->{
            itemsController.processChangeCanterY((double)(oldValue),(double)newValue);
        });
        radiusSlider.valueProperty().addListener((v,oldValue,newValue)->{
            itemsController.processChangeRadius((double)(oldValue),(double)newValue);
        });
        cycleMethodComboBox.valueProperty().addListener((v,oldValue,newValue)->{
            itemsController.processChangeCycleMethod(CycleMethod.valueOf(oldValue.toString()),CycleMethod.valueOf(newValue.toString()));
        });
        step0ColorColorPicker.valueProperty().addListener((v,oldValue,newValue)->{
            itemsController.processChangeStep0((Color)(oldValue),(Color)newValue);
        });
        step1ColorColorPicker.valueProperty().addListener((v,oldValue,newValue)->{
            itemsController.processChangeStep1((Color)(oldValue),(Color)newValue);
        });
       
        
        
        
        
        
        
        smallWorkSpacePane.setOnMousePressed(e -> {
            itemsController.processMousePress((double) e.getX(), (double) e.getY());
            //System.out.println(e.getX()+"..."+e.getY());
        });
        smallWorkSpacePane.setOnMouseDragged(e -> {
            itemsController.processMouseDragged((double) e.getX(), (double) e.getY());
        });
        smallWorkSpacePane.setOnMouseReleased(e -> {
            itemsController.processMouseReleased((double) e.getX(), (double) e.getY());
        });
         smallWorkSpacePane.setOnMouseClicked(e -> {
             if(e.getClickCount()==2)
              itemsController.processCheckDoubleClicked((double) e.getX(), (double) e.getY());   
        });
         smallWorkSpacePane.setOnMouseMoved(e ->{
             itemsController.processDetectForResize((double) e.getX(), (double) e.getY());
         });
         

         
         itemsTable.setOnMouseClicked(e ->{
            itemsController.processTableMousePress((double) e.getX(), (double) e.getY());
        });
        
         zoomInButton.setOnAction(e ->{
                 smallWorkSpacePane.setScaleX(smallWorkSpacePane.getScaleX() * 2);
                smallWorkSpacePane.setScaleY(smallWorkSpacePane.getScaleY() * 2);
               
                
         });
         zoomOutButton.setOnAction(e ->{
                smallWorkSpacePane.setScaleX(smallWorkSpacePane.getScaleX() *0.5);
                smallWorkSpacePane.setScaleY(smallWorkSpacePane.getScaleY() * 0.5);
           
         });
        homeButton.setOnAction(e ->{
            
                smallWorkSpacePane.setScaleX(smallWorkSpacePane.getScaleX() );
                smallWorkSpacePane.setScaleY(smallWorkSpacePane.getScaleX() );
               
         });
         
        
          smallWorkSpacePane.setOnScroll(
            new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                double zoomFactor = 1.05;
                double deltaY = event.getDeltaY();

                if (deltaY < 0){
                    zoomFactor = 0.95;
                }
                smallWorkSpacePane.setScaleX(smallWorkSpacePane.getScaleX() * zoomFactor);
                smallWorkSpacePane.setScaleY(smallWorkSpacePane.getScaleY() * zoomFactor);
                event.consume();
            }
        });
         
     
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         

        ItemsTableController iTC = new ItemsTableController(app);
        itemsTable.widthProperty().addListener(e->{
            iTC.processChangeTableSize();
        });
        itemsTable.setOnSort(new EventHandler<SortEvent<TableView<GLGLSetFunction>>>(){
            @Override
            public void handle(SortEvent<TableView<GLGLSetFunction>> event) {
                GLGLData data = (GLGLData)app.getDataComponent();
                ArrayList<GLGLSetFunction> oldListOrder =data.getCurrentItemsOrder();
                TableView view = event.getSource();
                ObservableList sortOrder = view.getSortOrder();
                if ((sortOrder != null) && (sortOrder.size() == 1)) {
                    TableColumn sortColumn = event.getSource().getSortOrder().get(0);
                    String columnText = sortColumn.getText();
                    SortType sortType = sortColumn.getSortType();
                    System.out.println("Sort by " + columnText);
                    event.consume();
                    SortItems_Transaction transaction = new SortItems_Transaction(data, oldListOrder, columnText, sortType);
                    app.processTransaction(transaction);
                    app.getFoolproofModule().updateAll();
                }
            }            
        });
    }
    
    public void initFoolproofDesign() {
        AppGUIModule gui = app.getGUIModule();
        AppFoolproofModule foolproofSettings = app.getFoolproofModule();
        foolproofSettings.registerModeSettings(TDLM_FOOLPROOF_SETTINGS, 
                new GLGLSelectionFoolproofDesign((GLGLApp)app));
    }

    @Override
    public void processWorkspaceKeyEvent(KeyEvent ke) {
       // System.out.println("WORKSPACE REPONSE TO " + ke.getCharacter());
    }
    
        @Override
    public void showNewDialog() {
        // WE AREN'T USING THIS FOR THIS APPLICATION
    }
}