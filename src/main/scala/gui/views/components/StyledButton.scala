package gui.views.components

import scalafx.geometry.{Insets, Pos}
import scalafx.scene.control.{Button, Label}
import scalafx.scene.layout.Region

object StyledButton {
  def apply(text: String, bg: String)(action: => Unit): Button = {
    val innerLabel = new Label(text) {
      wrapText = true
      alignment = Pos.Center
      maxWidth = 400
      style = "-fx-text-fill: white; -fx-font-size: 13pt; -fx-text-alignment: center;"
      padding = Insets(5, 10, 5, 10)
    }

    val baseStyle =
      s"""
         |-fx-background-color: $bg;
         |-fx-background-radius: 5px;
         |-fx-pref-width: 440px;
         |-fx-padding: 5;
       """.stripMargin

    val hoverStyle =
      s"""
         |-fx-background-color: derive($bg, 15%);
         |-fx-background-radius: 5px;
         |-fx-pref-width: 440px;
         |-fx-padding: 5;
         |-fx-cursor: hand;
       """.stripMargin

    val btn = new Button {
      graphic = innerLabel
      onAction = _ => action
      wrapText = true
      alignment = Pos.Center
      maxWidth = 440
      minHeight = Region.USE_PREF_SIZE
      prefHeight = Region.USE_COMPUTED_SIZE
      maxHeight = Double.MaxValue
      style = baseStyle
    }

    btn.onMouseEntered = _ => btn.style = hoverStyle
    btn.onMouseExited = _ => btn.style = baseStyle

    btn
  }
}