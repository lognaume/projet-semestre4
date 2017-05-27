package ch.heigvd.gemms;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override 
    public void start(Stage stage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GEMMSStage.fxml"));
        Parent root = (Parent)loader.load();
        GEMMSStageFXMLController controller = (GEMMSStageFXMLController)loader.getController();
        
        
        Scene scene = new Scene(root);

        controller.setStage(stage);
        scene.getStylesheets().add("/styles/Styles.css");
        scene.getStylesheets().add("/styles/Workspace.css");
        scene.getStylesheets().add("/styles/CSSIcons.css");
        scene.getStylesheets().add("/styles/ColorSet.css");
        
        stage.setTitle("GEMMS 2017");
        stage.getIcons().add(new Image("/img/main-logo.png"));
        stage.setScene(scene);
        
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
