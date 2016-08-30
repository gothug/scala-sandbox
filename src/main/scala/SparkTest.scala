//import org.apache.spark.sql.{SQLContext, Row}
//import org.apache.spark.{SparkConf, SparkContext}

object SparkTest {

//  def getVkProfile(sc: SparkContext, sql: SQLContext) = {
//    val df = sql.read
//      .format("org.elasticsearch.spark.sql")
//      .option("es.read.field.as.array.include",
//        "relations,relations.membership,relations.membership.groups,relations.membership.groups.items,relations.membership.groupsLeft,relations.membership.groupsLeft.items")
//      .load("vk-profile/profile")
//    df.printSchema()
//
//    val df2 =
//    //      df.filter(df("id").gt(0).and(df("id").lt(100000000)).and(df("membersCount").gt(0))).select("id", "members") flatMap {
//      df.filter(df("id").gt(0).and(df("membersCount").gt(0))).select("id", "members") flatMap {
//        case Row(id: Long, members: Seq[Long]) ⇒
//          members.map((id, _))
//      }
//  }
//
//  def main(args: Array[String]): Unit = {
//    val conf = new SparkConf().setAppName("test")
//
//    val esNodes = Seq("10.14.1.39", "10.11.138.119", "10.126.39.176", "10.122.31.99", "10.73.35.224", "10.106.7.203",
//    "10.12.47.237", "10.92.17.168")
//
//    conf.set("es.nodes", esNodes.mkString(","))
//
//    conf.set("es.port", "9200")
////    conf.set("es.resource", "vk-profile/profile")
//    conf.set("es.resource", "vk-group-membership/profile")
//    conf.set("pushdown", "true")
//    val sc = new SparkContext(conf)
//
//    val sql = new org.apache.spark.sql.SQLContext(sc)
//    val df = sql.read
//      .format("org.elasticsearch.spark.sql")
//      .option("es.read.field.as.array.include", "members")
//      .load("vk-group-membership/profile")
//    df.printSchema()
//
//    val df2 =
////      df.filter(df("id").gt(0).and(df("id").lt(50000000)).and(df("membersCount").gt(0))).select("id", "members") flatMap {
//      df.filter(df("id").gt(0).and(df("membersCount").gt(0))).select("id", "members") flatMap {
//        case Row(id: Long, members: Seq[Long]) ⇒
//          members.map(memberId ⇒ (id.toInt, memberId.toInt))
//      }
//
//    val df3 =
//      df2 groupBy {
//        case t => t._2
//      } mapValues { vs => vs.map(_._1) }
//
////    println("Total users: " + df3.count())
//    df3.take(10).foreach(println)
//  }
}

