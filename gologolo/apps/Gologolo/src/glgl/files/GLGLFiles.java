package glgl.files;

import static djf.AppPropertyType.APP_EXPORT_PAGE;
import static djf.AppPropertyType.APP_PATH_EXPORT;
import static djf.AppPropertyType.SAVE_WORK_TITLE;
import djf.AppTemplate;
import djf.components.AppClipboardComponent;
import djf.components.AppDataComponent;
import djf.components.AppFileComponent;
import djf.components.AppWorkspaceComponent;
import djf.ui.dialogs.AppDialogsFacade;
import glgl.data.GLGLCirclePrototype;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javafx.collections.ObservableList;
import javafx.scene.web.WebEngine;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;
import javax.swing.text.html.HTML;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javafx.scene.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import properties_manager.PropertiesManager;
import static tdlm.GLGLPropertyType.TDLM_EXPORT_TEMPLATE_FILE_NAME;
import glgl.data.GLGLData;
import glgl.data.GLGLImagePrototype;

import glgl.data.GLGLRectanglePrototype;
import glgl.data.GLGLSetFunction;
import glgl.data.GLGLTextPrototype;
import java.math.BigDecimal;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.paint.RadialGradient;
import javax.imageio.ImageIO;
import tdlm.GLGLApp;
import static tdlm.GLGLPropertyType.TDLM_SMALL_WORK_SPACE_PANE;

/**
 *
 * @author McKillaGorilla
 * @co-author Chenxing He
 */
public class GLGLFiles implements AppFileComponent {
    
    // FOR JSON SAVING AND LOADING
    static final String JSON_ORDER = "order";
    static final String JSON_NAME = "name";
    static final String JSON_TYPE = "type";
    static final String JSON_ITEMS = "items";
    static final String JSON_CANTERX="canterX";
    static final String JSON_CANTERY="canterY";   
    static final String JSON_WIDTH="width";
    static final String JSON_HEIGHT  ="height";  
    static final String JSON_FILL  ="fill"; 
    static final String JSON_STROKE  ="stroke";
    static final String JSON_CONTENT  ="content";
    static final String JSON_RADIUS ="radius";
    static final String JSON_BORDERWIDTH="borderWidth";
    static final String JSON_STROKECOLOR="strokeColor";
    static final String JSON_BORDERRADIUS="borderRadius";
    static final String JSON_COLORGRADIENT="colorGradient";
    static final String JSON_FONT="font";
    static final String JSON_FONTSIZE="fontSize";
    static final String JSON_STYLE="style";
    static final String JSON_FILEPATH="filepath";
    // FOR EXPORTING TO HTML
    static final String TITLE_TAG = "title";
    static final String TABLE_DATA_TAG = "to_do_list_table_data";
    
    /**
     * This method is for saving user work.
     * 
     * @param data The data management component for this application.
     * 
     * @param filePath Path (including file name/extension) to where
     * to save the data to.
     * 
     * @throws IOException Thrown should there be an error writing 
     * out data to the file.
     */
    @Override
    public void saveData(AppDataComponent data, String filePath) throws IOException {
	// GET THE DATA
	GLGLData toDoData = (GLGLData)data;
	

        
	// NOW BUILD THE JSON ARRAY FOR THE LIST
	JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        Iterator<Node> itemsIt = toDoData.itemsIterator();
	while (itemsIt.hasNext()) {	
            Node item = itemsIt.next();
            GLGLSetFunction info=(GLGLSetFunction)item;
            String order=info.getOrder();
            String name=info.getName();
            String type=info.getType();
            String content=info.getContent();
            double x=info.getX();
            double y=info.getY();
            double width =info.getWidth();
            double height=info.getHeight();
            double radius =info.getRadius();
            String fill =(info.getFillColor()).toString();
            double borderWidth=info.getStrokeWidth();
            String borderColor=((info.getStrokeColor())).toString();
            double borderRadius=info.getArcHeight();
            String colorGradient =(info.getColorGradient()).toString();
            
            String font=(info.getFont().getName()).toString();
            double fontSize=info.getFont().getSize();
            String style=info.getStyle();
            
            
            String imagePath=info.getImagePath();
            //String stroke=(info.getStroke()).toString();

	    JsonObject itemJson = Json.createObjectBuilder()
		    .add(JSON_ORDER, order)
		    .add(JSON_NAME, name)
                    .add(JSON_TYPE, type)
                    .add(JSON_CONTENT, content)
                    .add(JSON_CANTERX, x)
                    .add(JSON_CANTERY, y)
                    .add(JSON_WIDTH, width)
                    .add(JSON_HEIGHT, height)
                    .add(JSON_RADIUS, radius)
                    .add(JSON_FILL, fill)
                    .add(JSON_BORDERWIDTH, borderWidth)
                    .add(JSON_STROKECOLOR, borderColor)
                    .add(JSON_BORDERRADIUS, borderRadius)
                    .add(JSON_COLORGRADIENT, colorGradient)
                    .add(JSON_FONT, font)
                    .add(JSON_FONTSIZE, fontSize)
                    .add(JSON_STYLE, style)
                    .add(JSON_FILEPATH, imagePath)
                    .build();
	    arrayBuilder.add(itemJson);
	}
	JsonArray itemsArray = arrayBuilder.build();
	
	// THEN PUT IT ALL TOGETHER IN A JsonObject
	JsonObject toDoDataJSO = Json.createObjectBuilder()
		.add(JSON_ITEMS, itemsArray)
		.build();
	
	// AND NOW OUTPUT IT TO A JSON FILE WITH PRETTY PRINTING
	Map<String, Object> properties = new HashMap<>(1);
	properties.put(JsonGenerator.PRETTY_PRINTING, true);
	JsonWriterFactory writerFactory = Json.createWriterFactory(properties);
	StringWriter sw = new StringWriter();
	JsonWriter jsonWriter = writerFactory.createWriter(sw);
	jsonWriter.writeObject(toDoDataJSO);
	jsonWriter.close();

	// INIT THE WRITER
	OutputStream os = new FileOutputStream(filePath);
	JsonWriter jsonFileWriter = Json.createWriter(os);
	jsonFileWriter.writeObject(toDoDataJSO);
	String prettyPrinted = sw.toString();
	PrintWriter pw = new PrintWriter(filePath);
	pw.write(prettyPrinted);
	pw.close();
    }
    
    /**
     * This method loads data from a JSON formatted file into the data 
     * management component and then forces the updating of the workspace
     * such that the user may edit the data.
     * 
     * @param data Data management component where we'll load the file into.
     * 
     * @param filePath Path (including file name/extension) to where
     * to load the data from.
     * 
     * @throws IOException Thrown should there be an error
     * reading
     * in data from the file.
     */
    @Override
    public void loadData(AppDataComponent data, String filePath) throws IOException {
	// CLEAR THE OLD DATA OUT
        GLGLApp app=new GLGLApp();
	GLGLData toDoData = (GLGLData)data;
	toDoData.reset();
	//Pane workspace =(Pane)app.getGUIModule().getGUINode(TDLM_SMALL_WORK_SPACE_PANE);
        
	// LOAD THE JSON FILE WITH ALL THE DATA
	JsonObject json = loadJSONFile(filePath);
	
	// AND NOW LOAD ALL THE ITEMS
	JsonArray jsonItemArray = json.getJsonArray(JSON_ITEMS);
	for (int i = 0; i < jsonItemArray.size(); i++) {
	    JsonObject jsonItem = jsonItemArray.getJsonObject(i);
	    Node item = loadItem(jsonItem);
	    toDoData.addItem(item);
            //workspace.getChildren().add(item);
	}
    }
    
    
    
    
    
    public double getDataAsDouble(JsonObject json, String dataName) {
	JsonValue value = json.get(dataName);
	JsonNumber number = (JsonNumber)value;
	return number.bigDecimalValue().doubleValue();	
    }
    
    public Node loadItem(JsonObject jsonItem) {
	// GET THE DATA
	String order = jsonItem.getString(JSON_ORDER);
	String name = jsonItem.getString(JSON_NAME);
        String type = jsonItem.getString(JSON_TYPE);
        String content=jsonItem.getString(JSON_CONTENT);
        double x=getDataAsDouble(jsonItem,JSON_CANTERX);
        double y=getDataAsDouble(jsonItem,JSON_CANTERY);
        double width = getDataAsDouble(jsonItem,JSON_WIDTH);
        double height=getDataAsDouble(jsonItem,JSON_HEIGHT);
        double radius= getDataAsDouble(jsonItem, JSON_RADIUS);
        Color  fill  =(Color)Paint.valueOf(jsonItem.getString(JSON_FILL));
        double strokeWidth=getDataAsDouble(jsonItem, JSON_BORDERWIDTH);
        Color strokeColor=(Color)Paint.valueOf(jsonItem.getString(JSON_STROKECOLOR));
        double strokeRadius=getDataAsDouble(jsonItem, JSON_BORDERRADIUS);
        RadialGradient colorgradient=RadialGradient.valueOf(jsonItem.getString(JSON_COLORGRADIENT));
        String font=jsonItem.getString(JSON_FONT);
        double fontSize=getDataAsDouble(jsonItem, JSON_FONTSIZE);
        String style=jsonItem.getString(JSON_STYLE);
        String imagePath=jsonItem.getString(JSON_FILEPATH);
        
        
        //Color  stroke  =(Color)Paint.valueOf(jsonItem.getString(JSON_STROKE));
        if(type.toUpperCase().equals("RECTANGLE")){
            GLGLRectanglePrototype rectangle=new GLGLRectanglePrototype(order,name,x,y,width,height,strokeWidth,strokeColor,strokeRadius,colorgradient);
            return rectangle;
        }else if(type.toUpperCase().equals("TEXT")){//(type=="rectangle")
            GLGLTextPrototype text=new GLGLTextPrototype(order,name,content,x,y,fill,font,fontSize, style);
            return text;
        }else if(type.toUpperCase().equals("CIRCLE")){
            GLGLCirclePrototype circle =new GLGLCirclePrototype(order, name,x, y, radius,strokeWidth,strokeColor,colorgradient);
            return circle;
        }else {
            GLGLImagePrototype image =new GLGLImagePrototype(order, name,x, y,imagePath);
            return image;
        }

    }
    
    

    // HELPER METHOD FOR LOADING DATA FROM A JSON FORMAT
    private JsonObject loadJSONFile(String jsonFilePath) throws IOException {
	InputStream is = new FileInputStream(jsonFilePath);
	JsonReader jsonReader = Json.createReader(is);
	JsonObject json = jsonReader.readObject();
	jsonReader.close();
	is.close();
	return json;
    }
    
    /**
     * This method would be used to export data to another format,
     * which we're not doing in this assignment.
     */
      @Override
    public void exportData(AppDataComponent data, String savedFileName) throws IOException {
//            SnapshotParameters parameters = new SnapshotParameters();
//            GLGLApp app= new GLGLApp();
//             File saveFile = AppDialogsFacade.showSaveDialog(app.getGUIModule().getWindow(), SAVE_WORK_TITLE);
//		
//            Pane workspace =((Pane)app.getGUIModule().getGUINode(TDLM_SMALL_WORK_SPACE_PANE)).g;
//            parameters.setFill(Color.TRANSPARENT);
//            WritableImage image = workspace.snapshot(parameters, null);
//
// 
//            ImageView imageView = new ImageView(image);
//            imageView.setFitWidth(((Pane)workspace).getWidth());
//            imageView.setFitHeight(((Pane)workspace).getHeight());
//            WritableImage exportImage = imageView.snapshot(parameters, null);
//                                        if (saveFile != null) {
//                           ImageIO.write(SwingFXUtils.fromFXImage(exportImage, null), "png", saveFile);
//                                                        }

  
    
    
        
        
//        String logoName =  savedFileName.substring(0, savedFileName.indexOf("."));
//        String fileToExport = logoName+ ".png";
//        try {
//            // GET THE ACTUAL DATA
//            GLGLData toDoData = (GLGLData)data;
//            PropertiesManager props = PropertiesManager.getPropertiesManager();
//            String exportDirPath = props.getProperty(APP_PATH_EXPORT) + logoName + "/"+fileToExport;
//            File exportDir = new File(exportDirPath);
//            if (!exportDir.exists()) {
//                exportDir.mkdir();
//                exportDir.createNewFile();
//            }
//
//            // NOW LOAD THE TEMPLATE DOCUMENT
//            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//            String htmlTemplatePath = props.getPropertiesDataPath() + props.getProperty(TDLM_EXPORT_TEMPLATE_FILE_NAME);
//            File file = new File(htmlTemplatePath);
//            System.out.println(file.getPath() + " exists? " + file.exists());
//            URL templateURL = file.toURI().toURL();
//            Document exportDoc = docBuilder.parse(templateURL.getPath());
//
//            // SET THE WEB PAGE TITLE
////            org.w3c.dom.Node titleNode = exportDoc.getElementsByTagName(TITLE_TAG).item(0);
////            titleNode.setTextContent(toDoData.getName());
////
////            // SET THE NAME
////            org.w3c.dom.Node nameNode = getNodeWithId(exportDoc, HTML.Tag.TD.toString(), NAME_TAG);
////            nameNode.setTextContent(toDoData.getName());
////
////            // SET THE OWNER
////            org.w3c.dom.Node ownerNode = getNodeWithId(exportDoc, HTML.Tag.TD.toString(), OWNER_TAG);
////            ownerNode.setTextContent(toDoData.getOwner());
//            
//            // ADD ALL THE ITEMS
//            org.w3c.dom.Node tDataNode = getNodeWithId(exportDoc, "tdata", TABLE_DATA_TAG);
//            Iterator<Node> itemsIt = toDoData.itemsIterator();
//            while (itemsIt.hasNext()) {
//                Node item = itemsIt.next();
//                Element trElement = exportDoc.createElement(HTML.Tag.TR.toString());
//                tDataNode.appendChild(trElement);
//                addCellToRow(exportDoc, trElement, ((GLGLSetFunction)item).getName());
//                addCellToRow(exportDoc, trElement, ((GLGLSetFunction)item).getOrder());
//                addCellToRow(exportDoc, trElement, ((GLGLSetFunction)item).getType());
//            }
//            
//            // CORRECT THE APP EXPORT PAGE
//            props.addProperty(APP_EXPORT_PAGE, exportDirPath + fileToExport);
//
//            // EXPORT THE WEB PAGE
//            saveDocument(exportDoc, props.getProperty(APP_EXPORT_PAGE));
//        }
//        catch(SAXException | ParserConfigurationException
//                | TransformerException exc) {
//            throw new IOException("Error loading " + fileToExport);
//        }
//    }
//    private void addCellToRow(Document doc, org.w3c.dom.Node rowNode, String text) {
//        Element tdElement = doc.createElement(HTML.Tag.TD.toString());
//        tdElement.setTextContent(text);
//        rowNode.appendChild(tdElement);
//    }
//    private org.w3c.dom.Node getNodeWithId(Document doc, String tagType, String searchID) {
//        NodeList testNodes = doc.getElementsByTagName(tagType);
//        for (int i = 0; i < testNodes.getLength(); i++) {
//            org.w3c.dom.Node testNode = testNodes.item(i);
//            org.w3c.dom.Node testAttr = testNode.getAttributes().getNamedItem(HTML.Attribute.ID.toString());
//            if ((testAttr != null) && testAttr.getNodeValue().equals(searchID)) {
//                return testNode;
//            }
//        }
//        return null;
    }
    private void saveDocument(Document doc, String outputFilePath)
            throws TransformerException, TransformerConfigurationException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        Result result = new StreamResult(new File(outputFilePath));
        Source source = new DOMSource(doc);
        transformer.transform(source, result);
    }

    /**
     * This method is provided to satisfy the compiler, but it
     * is not used by this application.
     */
    @Override
    public void importData(AppDataComponent data, String filePath) throws IOException {
        
    }
}
