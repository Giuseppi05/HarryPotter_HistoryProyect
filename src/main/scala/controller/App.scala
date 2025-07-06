package gui.controller

import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.control.Label
import scalafx.scene.layout._
import scalafx.scene.image.ImageView
import scalafx.geometry.{Insets, Pos}
import gui.views.MainView
import controller.StoryController
import gui.utils.FontLoader
import scalafx.scene.layout.BorderStrokeStyle._
import scalafx.scene.paint.Color

object App extends JFXApp3 {

  override def start(): Unit = {

    val storyLbl = new Label {
      wrapText = true
      font = FontLoader.getFont(18)
      style = """
        -fx-text-fill: #9b968c;
        -fx-line-spacing: 3px;
      """
      prefWidth = 440
      maxWidth = 440
    }

    val imgView = new ImageView {
      fitWidth = 480
      fitHeight = 250
      preserveRatio = true
      smooth = true
    }

    val optsBox = new VBox {
      spacing = 12
      padding = Insets(5)
      alignment = Pos.Center
      prefWidth = 450
      minHeight = 100
    }

    val ctrl = new StoryController(storyLbl, imgView, optsBox)

    stage = new PrimaryStage {
      title = "El Misterio de Hogwarts"
      width = 520
      height = 800
      resizable = false
      scene = new MainView(
        "El Misterio de Hogwarts",
        storyLbl,
        imgView,
        optsBox
      ).scene
    }

    ctrl.update()
  }
}
