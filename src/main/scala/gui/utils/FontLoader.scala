package gui.utils

import scalafx.scene.text.Font

object FontLoader {
  private val baseSize = 20

  val baseFont: Option[Font] = Option(
    Font.loadFont(
      getClass.getResourceAsStream("/fonts/Bookish-Book.ttf"),
      baseSize
    )
  ).orElse {
    println(
      "[WARN] No se encontró la fuente personalizada, se usará la del sistema."
    )
    None
  }

  def getFont(size: Double): Font = {
    baseFont match {
      case Some(_) =>
        Font.loadFont(
          getClass.getResourceAsStream("/fonts/Bookish-Book.ttf"),
          size
        )
      case None =>
        Font("System", size)
    }
  }
}
