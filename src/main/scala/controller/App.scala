package gui.controller

import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.control.Label
import scalafx.scene.layout.VBox
import scalafx.scene.image.ImageView
import scalafx.geometry.Insets
import gui.views.MainView
import controller.StoryController

object App extends JFXApp3 {
  
  override def start(): Unit = {
    // Crear los componentes con estilos aplicados
    val storyLbl = new Label { 
      wrapText = true
      style = """
        -fx-font-family: 'Segoe UI', sans-serif;
        -fx-font-size: 15pt;
        -fx-text-fill: #CCCCCC;
        -fx-padding: 20px;
        -fx-background-color: #2D2D2D;
        -fx-background-radius: 15px;
        -fx-line-spacing: 3px;
      """
      prefWidth = 450
      maxWidth = 450
    }
    
    val imgView = new ImageView { 
      fitWidth = 400
      fitHeight = 250
      preserveRatio = true
      smooth = true
    }
    
    val optsBox = new VBox { 
      spacing = 12
      padding = Insets(20)
      style = "-fx-background-color: #2D2D2D; -fx-background-radius: 15px;"
      prefWidth = 450
      minHeight = 100
    }
    
    val ctrl = new StoryController(storyLbl, imgView, optsBox)
    
    stage = new PrimaryStage {
      title = "La Aventura de Juan"
      width = 520
      height = 750
      resizable = false
      scene = new MainView("La Aventura de Juan", storyLbl, imgView, optsBox).scene
    }
    
    ctrl.update()
  }
}