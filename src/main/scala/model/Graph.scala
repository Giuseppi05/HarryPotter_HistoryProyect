package model

import play.api.libs.json._
import scala.io.Source
import java.io.InputStream

case class StoryData(nodes: Array[Node], edges: Array[Edge])

object Graph {
  
  implicit val nodeFormat: Format[Node] = Json.format[Node]
  implicit val edgeFormat: Format[Edge] = Json.format[Edge]
  implicit val storyDataFormat: Format[StoryData] = Json.format[StoryData]
  
  private lazy val storyData: StoryData = loadStoryData()
  
  lazy val nodes: Array[Node] = storyData.nodes
  lazy val edges: Array[Edge] = storyData.edges
  
  private def loadStoryData(): StoryData = {
    try {
      val inputStream: InputStream = getClass.getResourceAsStream("/data/data.json")
      if (inputStream == null) {
        throw new RuntimeException("No se pudo encontrar el archivo data.json")
      }
      
      val jsonString = Source.fromInputStream(inputStream).mkString
      inputStream.close()
      
      val json = Json.parse(jsonString)
      json.as[StoryData]
    } catch {
      case e: Exception =>
        println(s"Error cargando story.json: ${e.getMessage}")

        StoryData(
          Array(Node(1, "Error cargando historia", "/images/node_1.jpg")),
          Array(Edge("Reintentar", 1, 1))
        )
    }
  }

  def findNode(id: Int): Option[Node] = nodes.find(_.id == id)
  def findEdges(fromId: Int): Array[Edge] = edges.filter(_.initNode == fromId)
}