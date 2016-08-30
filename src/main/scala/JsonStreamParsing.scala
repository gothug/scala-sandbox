import com.fasterxml.jackson.core.{JsonParser, JsonToken}
import com.fasterxml.jackson.databind.MappingJsonFactory
import org.json4s._
import org.json4s.jackson.JsonMethods._

object JsonStreamParsing extends App {
//  val jsonStr = """["one", "two", "three", "four", "six", "seven"]"""

  def freeze() = {
    println("Sleeping..")
    Thread.sleep(10000000)
  }

  def genJson(n: Int): String = {
    var jsonStrSb = new StringBuilder("[")

    for (i ← 1 until n) {
      jsonStrSb = jsonStrSb.append(""""""" + "String-" + i + """"""" + ",")
    }

    jsonStrSb.append(n + "]")

    jsonStrSb.toString
  }

  def parseJsonStringArray(jsonStr: String): Iterator[String] = {
    val f = new MappingJsonFactory()
    val jp = f.createParser(jsonStr)

    if (jp.nextToken() != JsonToken.START_ARRAY) {
      throw new Exception("Input json is not array")
    }

    def loop(jp: JsonParser): Stream[String] = {
      if (jp.nextToken() == JsonToken.END_ARRAY) {
        Stream.empty[String]
      } else {
        jp.getText #:: loop(jp)
      }
    }

    loop(jp).toIterator
  }

  val jsonStr = genJson(3000000)
  println(jsonStr.length)

  def parsedVals = parseJsonStringArray(jsonStr)

//  var counter = 0

  val ints =
    parsedVals.grouped(2) map {
      _ ⇒
        1
//        if (counter > 299999) {
//          freeze()
//        }
    } toList

  println("Ints length: " + ints.length)

  freeze()

//  println(parsedVals.toList)
}
