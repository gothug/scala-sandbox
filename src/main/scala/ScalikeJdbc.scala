import scalikejdbc._

object ScalikeJdbc extends App {

  case class FooTable(id: Int, value: String)

  object FooTable extends SQLSyntaxSupport[FooTable] {
    override val tableName = "public.foo"

    def apply(rs: WrappedResultSet) = new FooTable(
      id = rs.int("id"),
      value = rs.string("value")
    )
  }

  ConnectionPool.singleton(
    url      = "jdbc:postgresql:sk_target?stringtype=unspecified",
    user     = "postgres",
    password = "",
    settings = ConnectionPoolSettings(maxSize = 20, connectionTimeoutMillis = 10000L)
  )

  GlobalSettings.loggingSQLAndTime =
    LoggingSQLAndTimeSettings(enabled = true, singleLineMode = true, printUnprocessedStackTrace = false, stackTraceDepth = 0)

  implicit val session = AutoSession

  val values = Seq(Seq("one"), Seq("two"))

//  val ids: Seq[Long] =
//    withSQL {
//      QueryDSL.insert.into(FooTable).
//        columns(
//          FooTable.column.value).values("?")
//    }.batchAndReturnGeneratedKey(values: _*).apply()

  val id = withSQL {
    insert.into(FooTable).columns(FooTable.column.value).values("val1")
  }.updateAndReturnGeneratedKey.apply()

//  val id = withSQL {
//    insert.into(FooTable).namedValues(
//      column.value    → "val1")
//  }.updateAndReturnGeneratedKey.apply()

  println(id)

  println("Hello, world!")
}
