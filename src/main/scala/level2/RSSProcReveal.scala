package level2.reveal

import scala.xml.XML
import java.nio.file.{Files, Paths}
import scala.io.Source

// A Unary Function: logic to fetch data
def fetchData(url: String): String =
  val source = Source.fromURL(url)
  val xmlContent =
    try
      source.mkString
    finally
      source.close()
  xmlContent

// A Unary Function: logic to parse XML into a List of Strings
def parseRSS(xmlContent: String): List[(String, String)] =
  val xml = XML.loadString(xmlContent)
  val items: List[(String, String)] = (xml \\ "item").toList.map: node =>
    val title = (node \ "title").text.trim
    val link = (node \ "link").text.trim
    (title, link)
  items

def formatter(items: List[(String, String)]): String =
  items
    .map((title, link) => s"Title: $title\nLink: $link\n---")
    .mkString("\n")

def saveToFile(path: String, content: String): Unit =
  Files.write(Paths.get(path), content.getBytes)
  println(s"✅ Saved to $path")

// Given instances (the “implicit” implementations)
// given (String => String) = fetchData
// given (String => List[(String, String)]) = parseRSS
// given (List[(String, String)] => String) = formatter

// An Extension Method adding Level 2 power to the feeds list
def processFeed(
    fetch: String => String, // Higher-Order Parameter
    parse: String => List[(String, String)], // Higher-Order P,arameter
    formatter: List[(String, String)] => String // Higher-Order Parameter
)(url: String): String =
  val fetched: String = fetch(url)
  val parsed: List[(String, String)] = parse(fetched)
  val formatted: String = formatter(parsed)
  formatted

@main def runLevel2(): Unit =
  val bbcFeeds = List(
    "https://feeds.bbci.co.uk/news/world/rss.xml" -> "world_news.txt",
    "https://feeds.bbci.co.uk/news/technology/rss.xml" -> "tech_news.txt",
    "https://feeds.bbci.co.uk/news/business/rss.xml" -> "business_news.txt"
  )

  val rssProcessed = processFeed(fetchData, parseRSS, formatter)

  bbcFeeds.foreach: (url, path) =>
    val content: String = rssProcessed(url)
    saveToFile(path, content)