package main;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SeekMouse extends Application{
	private Canvas can;
	private GraphicsContext gc;
	
	private double mouseX = 0, mouseY = 0;
	Kreis rect;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void init() throws Exception {
		Timeline tl_draw = new Timeline(new KeyFrame(Duration.millis(16.67), e -> {
			draw();
		}));
		tl_draw.setCycleCount(Timeline.INDEFINITE);
		tl_draw.play();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Pane root = new Pane();
		Scene scene = new Scene(root, 700, 400);
		
		can = new Canvas(scene.getWidth(), scene.getHeight());
		gc = can.getGraphicsContext2D();
		
		scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		
		root.getChildren().add(can);
//		root.setStyle("-fx-background-color: #000000");
		
		scene.widthProperty().addListener((obsv, oldVal, newVal) -> {
		   can.setWidth(newVal.doubleValue());
		});
		
		scene.heightProperty().addListener((obsv, oldVal, newVal) -> {
			can.setHeight(newVal.doubleValue());
		});
		
		stage.setScene(scene);
		stage.show();
		
		//setup
		gc.setFill(Color.rgb(255, 255, 0));
		rect = new Kreis(gc, can.getWidth() / 2, can.getHeight() / 2);
	}
	
	private void draw() {
		gc.clearRect(0, 0, can.getWidth(), can.getHeight());
		rect.update(mouseX, mouseY);
		rect.show();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}