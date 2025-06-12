package controller

import model.Graph
import gui.views.components.StyledButton
import gui.utils.ImageLoader

import scalafx.scene.control.Label
import scalafx.scene.layout.VBox
import scalafx.scene.image.ImageView
import scalafx.geometry.Pos

class StoryController(story: Label, image: ImageView, opts: VBox) {
 
  private var current = Graph.findNode(1).get
  
  def update(): Unit = {
    story.text = current.event
    ImageLoader.fadeTo(image, current.imagePath)
    opts.children.clear()
    val e = Graph.findEdges(current.id)
    e.length match {
      case 0 =>
        val completedLabel = new Label("Historia completada") {
          style = """
            -fx-font-family: 'Segoe UI', sans-serif;
            -fx-font-size: 16pt;
            -fx-font-weight: 500;
            -fx-text-fill: #81C784;
            -fx-padding: 10 0 10 0;
          """
          alignment = Pos.Center
          maxWidth = Double.MaxValue
        }
        opts.children.addAll(
          completedLabel,
          StyledButton("Nueva Aventura", "#4CAF50") { current = Graph.findNode(1).get; update() }
        )
      case 1 =>
        opts.children.add(
          StyledButton("Continuar", "#2196F3") { current = Graph.findNode(e.head.finalNode).get; update() }
        )
      case _ => e.foreach { edge =>
        opts.children.add(
          StyledButton(edge.option, "#673AB7") { current = Graph.findNode(edge.finalNode).get; update() }
        )
      }
    }
  }
}