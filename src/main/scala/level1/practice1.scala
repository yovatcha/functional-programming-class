package level1

import scala.io.Source
import java.nio.file.{Files, Paths}

/** LEVEL 1: Word count as one big program.
  *   - Read file, normalize, split into words, count, top N, format report —
  *     all in run().
  *   - Practice refactoring this into small functions (e.g. in level2).
  */
final class WordCount(val filePath: String):

  def run(): Unit =
    println("🚀 Word count (Level 1 — one big run)...")

    // read file and get the raw text
    val source = Source.fromFile(filePath)
    val rawText =
      try source.mkString
      finally source.close()

    // normalize the text 
    val normalized = rawText.toLowerCase
    val sb = new StringBuilder
    var i = 0
    while i < normalized.length do
      val c = normalized(i)
      if c.isLetter then sb.append(c)
      else sb.append(' ')
      i += 1
    val text = sb.toString

    val wordList = text.split("\\s+").filter(_.nonEmpty).toList

    val totalWords = wordList.size
    val uniqueCount = wordList.distinct.size

    val countMap = scala.collection.mutable.Map.empty[String, Int]
    var idx = 0
    while idx < wordList.size do
      val w = wordList(idx)
      countMap(w) = countMap.getOrElse(w, 0) + 1
      idx += 1
    val top5 = countMap.toList.sortBy(-_._2).take(5)

    val report = new StringBuilder
    report.append(s"File: $filePath\n")
    report.append(s"Total words: $totalWords\n")
    report.append(s"Unique words: $uniqueCount\n")
    report.append("Top 5:\n")
    for (word, n) <- top5 do report.append(s"  $word: $n\n")
    println(report.toString)
    println("✅ Done.")

object WordCount:
  val defaultPath: String = "tech_news.txt"

  @main def runWordCount(): Unit =
    val path = defaultPath
    if Files.exists(Paths.get(path)) then new WordCount(path).run()
    else
      println(
        s"File not found: $path (run RSS processor first or set another path)"
      )
      // all print function is impure effect because it send message to the operating system 