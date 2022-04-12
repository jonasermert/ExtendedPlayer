
import java.awt.Button;
import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage meineStage) {
		BorderPane rootNode = new BorderPane();
		
		File datei = new File("");
		
		Media medium = new Media(datei.toURI().toString());
		MediaPlayer mediaplayer = new MediaPlayer(medium);
		MediaView mediaview = new MediaView(mediaplayer);
		rootNode.setCenter(mediaview);
		
		Button start = new Button("Wiedergabe");
		start.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				mediaplayer.play();
			}
		});
		
		Button pause = new Button("Pause");
		pause.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				mediaplayer.pause();
			}
		});
		
		
		Button stop = new Button("Stop");
		stop.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				mediaplayer.stop();
			}
		});
		
		HBox meineHBox = new HBox();
		rootNode.setBottom(meineHBox);
		
		Scene meineSzene = new Scene(rootNode, 660, 550);
		meineStage.setTitle("Erweiterter Mediaplayer von Jonas");
		meineStage.setScene(meineSzene);
		meineStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
