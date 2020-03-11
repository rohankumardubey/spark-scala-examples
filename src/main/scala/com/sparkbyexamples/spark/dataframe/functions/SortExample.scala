package com.sparkbyexamples.spark.dataframe.functions

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
object SortExample extends App {

  val spark: SparkSession = SparkSession.builder()
    .master("local[1]")
    .appName("SparkByExamples.com")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  import spark.implicits._

  val simpleData = Seq(("James","Sales","NY",90000,34,10000),
    ("Michael","Sales","NY",86000,56,20000),
    ("Robert","Sales","CA",81000,30,23000),
    ("Maria","Finance","CA",90000,24,23000),
    ("Raman","Finance","CA",99000,40,24000),
    ("Scott","Finance","NY",83000,36,19000),
    ("Jen","Finance","NY",79000,53,15000),
    ("Jeff","Marketing","CA",80000,25,18000),
    ("Kumar","Marketing","NY",91000,50,21000)
  )
  val df = simpleData.toDF("employee_name","department","state","salary","age","bonus")
  df.printSchema()
  df.show()

  df.sort("department","state").show(false)
  df.sort(col("department"),col("state")).show(false)

  df.orderBy("department","state").show(false)
  df.orderBy(col("department"),col("state")).show(false)

  df.sort(col("department").asc,col("state").asc).show(false)
  df.orderBy(col("department").asc,col("state").asc).show(false)

  df.sort(col("department").asc,col("state").desc).show(false)
  df.orderBy(col("department").asc,col("state").desc).show(false)
}
