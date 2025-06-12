package gui.utils

import scalafx.scene.image.{Image, ImageView}
import scalafx.animation.FadeTransition
import scalafx.util.Duration
import scalafx.Includes._
import java.io.File

object ImageLoader {
  def load(imageView: ImageView, path: String): Unit = {
    try {
      val resource = getClass.getResourceAsStream(path)
      if (resource != null) imageView.image = new Image(resource)
      else {
        val f = new File(path)
        if (f.exists()) imageView.image = new Image(f.toURI.toString)
        else createPlaceholder(imageView)
      }
    } catch {
      case _: Exception => createPlaceholder(imageView)
    }
  }
  def fadeTo(imageView: ImageView, path: String): Unit = {
    val fadeOut = new FadeTransition(Duration(200), imageView) {
      fromValue = 1.0; toValue = 0.0
      onFinished = _ => {
        load(imageView, path)
        new FadeTransition(Duration(300), imageView) {
          fromValue = 0.0; toValue = 1.0
        }.play()
      }
    }
    fadeOut.play()
  }
  private def createPlaceholder(iv: ImageView): Unit = {
    // placeholder logic
  }
}