package glgl.workspace.dialogs;

import djf.modules.AppLanguageModule;
import java.time.LocalDate;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;
import tdlm.GLGLApp;
import static tdlm.GLGLPropertyType.TDLM_ITEM_DIALOG_ADD_HEADER_TEXT;
import static tdlm.GLGLPropertyType.TDLM_ITEM_DIALOG_ASSIGNED_TO_PROMPT;
import static tdlm.GLGLPropertyType.TDLM_ITEM_DIALOG_ASSIGNED_TO_TEXT_FIELD;
import static tdlm.GLGLPropertyType.TDLM_ITEM_DIALOG_CANCEL_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_ITEM_DIALOG_CATEGORY_PROMPT;
import static tdlm.GLGLPropertyType.TDLM_ITEM_DIALOG_COMPLETED_CHECK_BOX;
import static tdlm.GLGLPropertyType.TDLM_ITEM_DIALOG_COMPLETED_PROMPT;
import static tdlm.GLGLPropertyType.TDLM_ITEM_DIALOG_DESCRIPTION_PROMPT;
import static tdlm.GLGLPropertyType.TDLM_ITEM_DIALOG_EDIT_HEADER_TEXT;
import static tdlm.GLGLPropertyType.TDLM_ITEM_DIALOG_END_DATE_PROMPT;
import static tdlm.GLGLPropertyType.TDLM_ITEM_DIALOG_HEADER;
import static tdlm.GLGLPropertyType.TDLM_ITEM_DIALOG_OK_BUTTON;
import static tdlm.GLGLPropertyType.TDLM_ITEM_DIALOG_START_DATE_PROMPT;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_DIALOG_BUTTON;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_DIALOG_CHECK_BOX;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_DIALOG_DATE_PICKER;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_DIALOG_GRID;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_DIALOG_HEADER;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_DIALOG_PANE;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_DIALOG_PROMPT;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_DIALOG_TEXT_FIELD;
import glgl.data.GLGLData;

import glgl.data.GLGLSetFunction;

/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class ToDoListItemDialog extends Stage {
    GLGLApp app;
    GridPane gridPane;
    
    Label headerLabel = new Label();    
    Label orderLabel = new Label();
    TextField orderTextField = new TextField();
    Label nameLabel = new Label();
    TextField nameTextField = new TextField();
    Label typeLabel = new Label();
    TextField typeTextField = new TextField();
    HBox okCancelPane = new HBox();
    Button okButton = new Button();
    Button cancelButton = new Button();

    GLGLSetFunction itemToEdit;
    GLGLSetFunction newItem;
    GLGLSetFunction editItem;
    boolean editing;

    EventHandler cancelHandler;
    EventHandler addItemOkHandler;
    EventHandler editItemOkHandler;
    
    public ToDoListItemDialog(GLGLApp initApp) {
        // KEEP THIS FOR WHEN THE WORK IS ENTERED
        app = initApp;

        // EVERYTHING GOES IN HERE
        gridPane = new GridPane();
        gridPane.getStyleClass().add(CLASS_TDLM_DIALOG_GRID);
        initDialog();

        // NOW PUT THE GRID IN THE SCENE AND THE SCENE IN THE DIALOG
        Scene scene = new Scene(gridPane);
        this.setScene(scene);
        
        // SETUP THE STYLESHEET
        app.getGUIModule().initStylesheet(this);
        scene.getStylesheets().add(CLASS_TDLM_DIALOG_GRID);                             
        
        // MAKE IT MODAL
        this.initOwner(app.getGUIModule().getWindow());
        this.initModality(Modality.APPLICATION_MODAL);
    }
       
    protected void initGridNode(Node node, Object nodeId, String styleClass, int col, int row, int colSpan, int rowSpan, boolean isLanguageDependent) {
        // GET THE LANGUAGE SETTINGS
        AppLanguageModule languageSettings = app.getLanguageModule();
        
        // TAKE CARE OF THE TEXT
        if (isLanguageDependent) {
            languageSettings.addLabeledControlProperty(nodeId + "_TEXT", ((Labeled)node).textProperty());
            ((Labeled)node).setTooltip(new Tooltip(""));
            languageSettings.addLabeledControlProperty(nodeId + "_TOOLTIP", ((Labeled)node).tooltipProperty().get().textProperty());
        }
        
        // PUT IT IN THE UI
        if (col >= 0)
            gridPane.add(node, col, row, colSpan, rowSpan);

        // SETUP IT'S STYLE SHEET
        node.getStyleClass().add(styleClass);
    }

    private void initDialog() {
        // THE NODES ABOVE GO DIRECTLY INSIDE THE GRID
        initGridNode(headerLabel,           TDLM_ITEM_DIALOG_HEADER,                CLASS_TDLM_DIALOG_HEADER,       0, 0, 3, 1, true);
        initGridNode(orderLabel,         TDLM_ITEM_DIALOG_CATEGORY_PROMPT,       CLASS_TDLM_DIALOG_PROMPT,       0, 1, 1, 1, true);
        initGridNode(orderTextField,     null,                                   CLASS_TDLM_DIALOG_TEXT_FIELD,   1, 1, 1, 1, false);
        initGridNode(nameLabel,      TDLM_ITEM_DIALOG_DESCRIPTION_PROMPT,    CLASS_TDLM_DIALOG_PROMPT,       0, 2, 1, 1, true);
        initGridNode(nameTextField,  null,                                   CLASS_TDLM_DIALOG_TEXT_FIELD,   1, 2, 1, 1, false);
        initGridNode(typeLabel,       TDLM_ITEM_DIALOG_ASSIGNED_TO_PROMPT,    CLASS_TDLM_DIALOG_PROMPT,       0, 5, 1, 1, true);
        initGridNode(typeTextField,   TDLM_ITEM_DIALOG_ASSIGNED_TO_TEXT_FIELD,CLASS_TDLM_DIALOG_TEXT_FIELD,   1, 5, 1, 1, false);
        initGridNode(okCancelPane,          null,                                   CLASS_TDLM_DIALOG_PANE,         0, 7, 3, 1, false);

        okButton = new Button();
        cancelButton = new Button();
        app.getGUIModule().addGUINode(TDLM_ITEM_DIALOG_OK_BUTTON, okButton);
        app.getGUIModule().addGUINode(TDLM_ITEM_DIALOG_CANCEL_BUTTON, cancelButton);
        okButton.getStyleClass().add(CLASS_TDLM_DIALOG_BUTTON);
        cancelButton.getStyleClass().add(CLASS_TDLM_DIALOG_BUTTON);
        okCancelPane.getChildren().add(okButton);
        okCancelPane.getChildren().add(cancelButton);
        okCancelPane.setAlignment(Pos.CENTER);

        AppLanguageModule languageSettings = app.getLanguageModule();
        languageSettings.addLabeledControlProperty(TDLM_ITEM_DIALOG_OK_BUTTON + "_TEXT",    okButton.textProperty());
        languageSettings.addLabeledControlProperty(TDLM_ITEM_DIALOG_CANCEL_BUTTON + "_TEXT",    cancelButton.textProperty());
       
        // AND SETUP THE EVENT HANDLERS
        orderTextField.setOnAction(e->{
            processCompleteWork();
        });
        nameTextField.setOnAction(e->{
            processCompleteWork();
        });
        okButton.setOnAction(e->{
            processCompleteWork();
        });
        cancelButton.setOnAction(e->{
            newItem = null;
            editItem = null;
            this.hide();
        });   
    }
    
    private void makeNewItem() {
        String category = orderTextField.getText();
        String description = nameTextField.getText();
        String assignedTo = typeTextField.getText();
       // newItem = new GLGLSetFunction(category, description, assignedTo);
        this.hide();
    }
    
    private void processCompleteWork() {
        // GET THE SETTINGS
        String order = orderTextField.getText();
        String name = nameTextField.getText();
        String type = typeTextField.getText();
        
        // IF WE ARE EDITING
        GLGLData data = (GLGLData)app.getDataComponent();
        if (editing) {
            if (data.isValidToDoItemEdit(itemToEdit, order, name)) {
                itemToEdit.setOrder(order);
//                itemToEdit.setName(name);
//                itemToEdit.setType(type);
            }
            else {
                // OPEN MESSAGE DIALOG EXPLAINING WHAT WENT WRONG
                // @todo
            }
        }
        // IF WE ARE ADDING
        else {
            if (data.isValidNewToDoItem(order, name)) {
                this.makeNewItem();
            }
            else {
                // OPEN MESSAGE DIALOG EXPLAINING WHAT WENT WRONG
                // @todo
            }
        }
        
        // CLOSE THE DIALOG
        this.hide();
    }

    public void showAddDialog() {        
        // USE THE TEXT IN THE HEADER FOR ADD
        PropertiesManager props = PropertiesManager.getPropertiesManager();
        String headerText = props.getProperty(TDLM_ITEM_DIALOG_ADD_HEADER_TEXT);
        headerLabel.setText(headerText);
        setTitle(headerText);

        // USE THE TEXT IN THE HEADER FOR ADD
        orderTextField.setText("");
        nameTextField.setText("");
        typeTextField.setText("");
        
        // WE ARE ADDING A NEW ONE, NOT EDITING
        editing = false;
        editItem = null;
        
        // AND OPEN THE DIALOG
        showAndWait();
    }

    public void showEditDialog(GLGLSetFunction initItemToEdit) {
        // WE'LL NEED THIS FOR VALIDATION
        itemToEdit = initItemToEdit;
        
        // USE THE TEXT IN THE HEADER FOR EDIT
        PropertiesManager props = PropertiesManager.getPropertiesManager();
        String headerText = props.getProperty(TDLM_ITEM_DIALOG_EDIT_HEADER_TEXT);
        headerLabel.setText(headerText);
        setTitle(headerText);
        
        // WE'LL ONLY PROCEED IF THERE IS A LINE TO EDIT
        editing = true;
        editItem = null;
        
        // USE THE TEXT IN THE HEADER FOR EDIT
        orderTextField.setText(itemToEdit.getOrder());
        nameTextField.setText(itemToEdit.getName());
        //typeTextField.setText(itemToEdit.getType());
               
        // AND OPEN THE DIALOG
        showAndWait();
    }
    
    public GLGLSetFunction getNewItem() {
        return newItem;
    }
    
    public GLGLSetFunction getEditItem() {
        return editItem;
    }
}