package gui.views.components

import scalafx.scene.control.Button

object StyledButton {
  def apply(text: String, bg: String)(action: => Unit): Button = {
    val baseStyle = s"-fx-font-size:13pt;-fx-text-fill:white;-fx-background-color:$bg;-fx-background-radius:25px;-fx-min-width:380px;-fx-min-height:45px;"
    val hoverStyle = s"-fx-font-size:13pt;-fx-text-fill:white;-fx-background-color:derive($bg,15%);-fx-background-radius:25px;-fx-min-width:380px;-fx-min-height:45px;"
    
    val btn = new Button(text) {
      onAction = _ => action
      style = baseStyle
    }
    btn.onMouseEntered = _ => btn.style = hoverStyle
    btn.onMouseExited  = _ => btn.style = baseStyle
    btn
  }
}