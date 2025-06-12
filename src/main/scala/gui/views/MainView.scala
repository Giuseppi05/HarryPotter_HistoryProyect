package gui.views

import scalafx.scene.control.Label
import scalafx.scene.image.ImageView
import scalafx.scene.paint.Color
import scalafx.scene.Scene
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.layout.VBox

class MainView(title: String, story: Label, image: ImageView, opts: VBox) {
  private val titleLbl = new Label(title) { 
    alignment = Pos.Center
    style = """
      -fx-font-family: 'Segoe UI', sans-serif;
      -fx-font-size: 24pt;
      -fx-font-weight: 600;
      -fx-text-fill: #E0E0E0;
      -fx-padding: 0 0 20 0;
    """
  }
  
  private val imgBox = new VBox {
    padding = Insets(15)
    alignment = Pos.Center
    style = "-fx-background-color: #2D2D2D; -fx-background-radius: 15px;"
    prefWidth = 430
    prefHeight = 280
    children = Seq(image)
  }
  
  val root = new VBox {
    spacing = 20
    padding = Insets(25)
    alignment = Pos.Center
    children = Seq(titleLbl, story, imgBox, opts)
    style = "-fx-background-color:#1A1A1A"
  }
  
  val scene = new Scene {
    this.root = MainView.this.root  
    fill = Color.web("#1A1A1A")
  }
}