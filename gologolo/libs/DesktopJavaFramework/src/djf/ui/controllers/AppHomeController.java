package djf.ui.controllers;

import djf.ui.dialogs.AppDialogsFacade;
import djf.AppTemplate;
import djf.modules.AppLanguageModule;
import djf.modules.AppLanguageModule.LanguageException;

public class AppHomeController {
    private AppTemplate app;
    
    public AppHomeController(AppTemplate initApp) {
        app = initApp;
    }  
   /*  
    public void processResizeRequest() {
        //AppDialogsFacade.showResizeDialog(app);
    }
   
   public void processLanguageRequest() {
        try {
            AppLanguageModule languageSettings = app.getLanguageModule();
            AppDialogsFacade.showLanguageDialog(languageSettings);
        }
        catch(LanguageException le) {
            System.out.println("Error Loading Language into UI");
        }
    }  
    
    public void processAboutRequest() {
        AppDialogsFacade.showAboutDialog(app);
    }    */
}
