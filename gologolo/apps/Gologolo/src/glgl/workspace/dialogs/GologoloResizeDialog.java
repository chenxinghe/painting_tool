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
import javafx.scene.layout.VBox;
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
import static tdlm.GLGLPropertyType.TDLM_ITEM_RESIZE_DIALOG_HEADER;
import static tdlm.GLGLPropertyType.TDLM_ITEM_RESIZE_DIALOG_HEIGHT_PROMPT;
import static tdlm.GLGLPropertyType.TDLM_ITEM_RESIZE_DIALOG_TITLE;
import static tdlm.GLGLPropertyType.TDLM_ITEM_RESIZE_DIALOG_WIDTH_PROMPT;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_DIALOG_BUTTON;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_DIALOG_CHECK_BOX;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_DIALOG_DATE_PICKER;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_DIALOG_GRID;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_DIALOG_HEADER;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_DIALOG_PANE;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_DIALOG_PROMPT;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_DIALOG_TEXT_FIELD;
import glgl.data.GLGLData;
import static tdlm.GLGLPropertyType.TDLM_SMALL_WORK_SPACE_PANE;

import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_DIALOG_LABEL;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_LONG_COLUMN;
import static tdlm.workspace.style.TDLStyle.CLASS_TDLM_RESIZE_DIALOG;

/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class GologoloResizeDialog extends Stage {
    GLGLApp app;
    GridPane gridPane;
    VBox   headerLine;
    HBox   innerBox;
    Label resizeHeaderLabel = new Label();    
    Label heightLabel = new Label();
    TextField heightTextField = new TextField();
    Label widthLabel = new Label();
    TextField widthTextField = new TextField();
    HBox okCancelPane = new HBox();
    Button okButton = new Button();
    Button cancelButton = new Button();

    double newwidth;
    double newheight;
    double oldwidth;
    double oldheight;
    EventHandler cancelHandler;
    EventHandler addItemOkHandler;
    EventHandler editItemOkHandler;
    
    public GologoloResizeDialog(GLGLApp initApp) {
        // KEEP THIS FOR WHEN THE WORK IS ENTERED
        app = initApp;

        // EVERYTHING GOES IN HERE
       gridPane = new GridPane();
       headerLine=new VBox();
       innerBox=new HBox();
       oldheight=app.getGUIModule().getGUINode(TDLM_SMALL_WORK_SPACE_PANE).getLayoutBounds().getHeight();
       oldwidth=app.getGUIModule().getGUINode(TDLM_SMALL_WORK_SPACE_PANE).getLayoutBounds().getWidth();
        resizeHeaderLabel.getStyleClass().add(CLASS_TDLM_DIALOG_LABEL);
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
        PropertiesManager props = PropertiesManager.getPropertiesManager();
        String headerText = props.getProperty(TDLM_ITEM_RESIZE_DIALOG_TITLE);
        setTitle(headerText);
        //resizeHeaderLabel.setStyle(CLASS_TDLM_LONG_COLUMN);
        initGridNode(resizeHeaderLabel,           TDLM_ITEM_RESIZE_DIALOG_HEADER,                CLASS_TDLM_DIALOG_HEADER,       0, 0, 3, 1, true);
        initGridNode(heightLabel,         TDLM_ITEM_RESIZE_DIALOG_HEIGHT_PROMPT,       CLASS_TDLM_DIALOG_PROMPT,       0, 1, 1, 1, true);
        initGridNode(heightTextField,     null,                                   CLASS_TDLM_DIALOG_TEXT_FIELD,   1, 1, 1, 1, false);
        initGridNode(widthLabel,      TDLM_ITEM_RESIZE_DIALOG_WIDTH_PROMPT,    CLASS_TDLM_DIALOG_PROMPT,       0, 2, 1, 1, true);
        initGridNode(widthTextField,  null,                                   CLASS_TDLM_DIALOG_TEXT_FIELD,   1, 2, 1, 1, false);
        initGridNode(okCancelPane,          null,                                   CLASS_TDLM_DIALOG_PANE,         0, 3, 3, 1, false);

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
      
        widthTextField.setOnAction(e->{
            processCompleteWork();
        });
        heightTextField.setOnAction(e->{
            processCompleteWork();
        });
      
        okButton.setOnAction(e->{
            processCompleteWork();
            this.hide();
        });
        cancelButton.setOnAction(e->{
            newheight = oldheight;
            newwidth = oldwidth;
            this.hide();
        });   
    }
    public double getNewHeight(){
        return newheight;
    }
   public double getNewWidth(){
        return newwidth;
    }
    private void processCompleteWork() {
        // GET THE SETTINGS
         newwidth = Double.valueOf(widthTextField.getText());
         newheight =Double.valueOf( heightTextField.getText());
        
    }
   
    public void showResizeDialog() {        
        // USE THE TEXT IN THE HEADER FOR ADD
        PropertiesManager props = PropertiesManager.getPropertiesManager();

        // USE THE TEXT IN THE HEADER FOR ADD
        heightTextField.setText(String.valueOf(oldheight));
        widthTextField.setText(String.valueOf(oldwidth));

       
        
        // AND OPEN THE DIALOG
        showAndWait();
    }

}