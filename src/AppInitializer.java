import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.Timer;
import java.util.TimerTask;

public class AppInitializer extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("view/StartUpForm.fxml"))));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setResizable(true);
        primaryStage.show();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Stage window = (Stage) primaryStage.getScene().getWindow();
                        try {
                            window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("view/MainForm.fxml"))));
                            primaryStage.centerOnScreen();
                        } catch (Exception e) {
                        }
                    }
                });
            }
        }, 1500);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
