package tdlm;

import djf.AppTemplate;
import djf.components.AppClipboardComponent;
import djf.components.AppDataComponent;
import djf.components.AppFileComponent;
import djf.components.AppWorkspaceComponent;
import java.util.Locale;
import glgl.data.GLGLData;
import glgl.files.GLGLFiles;
import glgl.clipboard.GLGLClipboard;
import GLGL.workspace.GLGLWorkspace;
import static javafx.application.Application.launch;

public class GLGLApp extends AppTemplate {   
    /**
     * This is where program execution begins. Since this is a JavaFX app it
     * will simply call launch, which gets JavaFX rolling, resulting in sending
     * the properly initialized Stage (i.e. window) to the start method inherited
     * from AppTemplate, defined in the Desktop Java Framework.
     * 
     * @param args Command-line arguments, there are no such settings used
     * by this application.
     */
    public static void main(String[] args) {
	Locale.setDefault(Locale.US);
	launch(args);
    }

    @Override
    public AppClipboardComponent buildClipboardComponent(AppTemplate app) {
        return new GLGLClipboard(this);
    }

    @Override
    public AppDataComponent buildDataComponent(AppTemplate app) {
        return new GLGLData(this);
    }

    @Override
    public AppFileComponent buildFileComponent() {
        return new GLGLFiles();
    }

    @Override
    public AppWorkspaceComponent buildWorkspaceComponent(AppTemplate app) {
        return new GLGLWorkspace(this);        
    }
}