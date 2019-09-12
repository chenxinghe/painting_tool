package glgl.transactions;

import java.util.ArrayList;
import java.util.Comparator;
import javafx.scene.control.TableColumn.SortType;
import jtps.jTPS_Transaction;
import properties_manager.PropertiesManager;
import static tdlm.GLGLPropertyType.TDLM_TYPE_COLUMN;
import static tdlm.GLGLPropertyType.TDLM_ORDER_COLUMN;
import static tdlm.GLGLPropertyType.TDLM_NAME_COLUMN;
import glgl.data.GLGLData;
import glgl.data.GLGLSetFunction;

import javafx.scene.Node;

/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class SortItems_Transaction implements jTPS_Transaction {
    GLGLData data;
    ArrayList<GLGLSetFunction> oldListOrder;
    ArrayList<GLGLSetFunction> newListOrder;
    String sortingCriteria;
    SortType sortType;
    Comparator sortComparator;

    public SortItems_Transaction(   GLGLData initData, 
                                    ArrayList<GLGLSetFunction> initOldListOrder, 
                                    String initSortingCriteria,
                                    SortType initSortType) {
        data = initData;
        oldListOrder = initOldListOrder;
        sortingCriteria = initSortingCriteria;
        sortType = initSortType;
        sortComparator = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                GLGLSetFunction tD1 = (GLGLSetFunction)o1;
                GLGLSetFunction tD2 = (GLGLSetFunction)o2;
                Comparable c1, c2;
                PropertiesManager props = PropertiesManager.getPropertiesManager();
                if (sortingCriteria.equals(props.getProperty(TDLM_NAME_COLUMN + "_TEXT"))) {
                    c1 = tD1.getOrder();
                    c2 = tD2.getOrder();
                }
                else if (sortingCriteria.equals(props.getProperty(TDLM_ORDER_COLUMN + "_TEXT"))) {
                    c1 = tD1.getName();
                    c2 = tD2.getName();
                }
                else {
                    c1 = tD1.getType();
                    c2 = tD2.getType();
                }
               
                if (sortType == SortType.ASCENDING) {
                    return c1.compareTo(c2);
                }
                else {
                    return c2.compareTo(c1);
                }
            }
        };
    }

    @Override
    public void doTransaction() {
        data.sortItems(sortComparator);
        newListOrder = data.getCurrentItemsOrder();
    }

    @Override
    public void undoTransaction() {
        data.rearrangeItems(oldListOrder);
    }    
}