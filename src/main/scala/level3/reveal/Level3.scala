package level3.reveal.option

import scala.xml.XML
import java.nio.file.{Files, Paths}
import scala.io.Source

// A Unary Function: logic to fetch data (None on failure)
def fetchData(url: String): Option[String] =
  try
    val source = Source.fromURL(url)
    try
      Some(source.mkString)
    finally
      source.close()
  catch
    case e: Exception =>
      println(s"[Error] Failed to fetch $url: ${e.getMessage}")
      None

// A Unary Function: logic to parse XML (None on parse failure)
def parseRSS(xmlContent: String): Option[List[(String, String)]] =
  try
    val xml = XML.loadString(xmlContent)
    val items: List[(String, String)] = (xml \\ "item").toList.map: node =>
      val title = (node \ "title").text.trim
      val link = (node \ "link").text.trim
      (title, link)
    Some(items)
  catch
    case e: Exception =>
      println(s"[Error] Failed to parse XML: ${e.getMessage}")
      None

def formatter(items: List[(String, String)]): String =
  items
    .map((title, link) => s"Title: $title\nLink: $link\n---")
    .mkString("\n")

def saveToFile(path: String, content: String): Option[Unit] =
  try
    Files.write(Paths.get(path), content.getBytes)
    println(s"✅ Saved to $path")
    Some(())
  catch
    case e: Exception =>
      println(s"[Error] Failed to save to $path: ${e.getMessage}")
      None

// An Extension Method adding Level 2 power to the feeds list
def processFeed(
    fetch: String => Option[String],
    parse: String => Option[List[(String, String)]],
    formatter: List[(String, String)] => String
)(url: String): Option[String] =
  for
    fetched <- fetch(url)
    parsed <- parse(fetched)
    formatted = formatter(parsed)
  yield formatted

@main def runLevel2(): Unit =
  val bbcFeeds = List(
    "https://feeds.bbci.co.uk/news/world/rss.xml" -> "world_news.txt",
    "https://feeds.bbci.co.uk/news/technology/rss.xml" -> "tech_news.txt",
    "https://feeds.bbci.co.uk/news/business/rss.xml" -> "business_news.txt"
  )

  val rssProcessed = processFeed(fetchData, parseRSS, formatter)

  bbcFeeds.foreach: (url, path) =>
    rssProcessed(url) match
      case Some(content) =>
        saveToFile(path, content) // None => already logged inside saveToFile
      case None =>
        () // fetch/parse already logged; skip this feed
