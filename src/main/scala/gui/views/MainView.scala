package gui.views

import scalafx.geometry.{Insets, Pos}
import scalafx.scene.{Scene, paint}
import scalafx.scene.control.{Label, ScrollPane}
import scalafx.scene.image.ImageView
import scalafx.scene.layout._
import scalafx.scene.paint.Color
import scalafx.scene.layout.BorderStrokeStyle._
import gui.utils.FontLoader

class MainView(title: String, story: Label, image: ImageView, opts: VBox) {

  private val titleLbl = new Label(title) {
    alignment = Pos.Center
    font = FontLoader.getFont(40)
    style = """
      -fx-text-fill: #ffc943;
      -fx-padding: 0 0 0 0;
    """
  }

  val storyScroll = new ScrollPane {
    content = story
    prefWidth = 460
    prefHeight = 200
    maxHeight = 200
    fitToWidth = true
    hbarPolicy = ScrollPane.ScrollBarPolicy.Never
    vbarPolicy = ScrollPane.ScrollBarPolicy.AsNeeded
    style = """
      -fx-background-color: transparent;
      -fx-background: transparent;
      -fx-background-insets: 0;
      -fx-padding: 0 5;
    """
  }

  val storyBox = new VBox {
    padding = Insets(20)
    style = "-fx-background-color: #2a261b;"
    border = new Border(
      new BorderStroke(
        Color.web("#757575"),
        Solid,
        new CornerRadii(5),
        new BorderWidths(3)
      )
    )
    prefWidth = 480
    prefHeight = 200
    maxWidth = 480
    maxHeight = 200
    alignment = Pos.TopLeft
    children = Seq(storyScroll)
  }

  private val imgBox = new VBox {
    padding = Insets(5)
    alignment = Pos.Center
    prefWidth = 480
    prefHeight = 250
    children = Seq(image)
  }

  val optsScroll = new ScrollPane {
    content = opts
    prefWidth = 460
    prefHeight = 200
    fitToWidth = true
    hbarPolicy = ScrollPane.ScrollBarPolicy.Never
    vbarPolicy = ScrollPane.ScrollBarPolicy.AsNeeded
    style = """
      -fx-background-color: transparent;
      -fx-background: transparent;
      -fx-background-insets: 0;
    """
  }

  val root = new VBox {
    spacing = 20
    padding = Insets(25)
    alignment = Pos.Center
    children = Seq(titleLbl, imgBox, storyBox, optsScroll)
    style = "-fx-background-color:#1E1E1E"

    border = new Border(
      new BorderStroke(
        Color.web("#ffc943"),
        Solid,
        new CornerRadii(0),
        new BorderWidths(4)
      )
    )
  }

  val scene = new Scene {
    this.root = MainView.this.root
    fill = Color.web("#1E1E1E")
  }
}
