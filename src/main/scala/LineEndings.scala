import java.io._

object LineEndings extends App {
  val pw = new PrintWriter(new File("/tmp/hello.txt" ))
  val newline = "\r\n"
  pw.write("one" + newline)
  pw.write("two" + newline)
  pw.write("three" + newline)
  pw.close
}
