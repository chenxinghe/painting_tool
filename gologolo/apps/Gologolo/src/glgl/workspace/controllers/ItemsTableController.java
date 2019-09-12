package glgl.workspace.controllers;

import djf.AppTemplate;
import djf.modules.AppGUIModule;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tdlm.GLGLApp;
import static tdlm.GLGLPropertyType.TDLM_ITEMS_TABLE_VIEW;

import javafx.scene.Node;

/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class ItemsTableController {
    GLGLApp app;

    public ItemsTableController(AppTemplate initApp) {
        app = (GLGLApp)initApp;
    }

    public void processChangeTableSize() {
        AppGUIModule gui = app.getGUIModule();
        TableView<Node> itemsTable = (TableView)gui.getGUINode(TDLM_ITEMS_TABLE_VIEW);
        ObservableList columns = itemsTable.getColumns();
        for (int i = 0; i < columns.size(); i++) {
            TableColumn column = (TableColumn)columns.get(i);
            column.setMinWidth(itemsTable.widthProperty().getValue()/columns.size());
            column.setMaxWidth(itemsTable.widthProperty().getValue()/columns.size());
        }
    }    
}
