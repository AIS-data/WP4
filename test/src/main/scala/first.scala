import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object AIStest
{
  def main(args: Array[String])
  {
    val tfiles = "hdfs://ip-10-0-1-92.eu-west-1.compute.internal:8020/" + args(0)

    val conf = new SparkConf()
    conf.setAppName("AIS-test")
    conf.setMaster("yarn-client")
    val sc = new SparkContext(conf)

    val data = sc.textFile(tfiles);
    val data1 = data.map(_.split(","));
    val data2 = data1.filter(x => x(0)!="mmsi");
    println ("Lines in dataset: %d".format(data2.count()));
    sc.stop()
  }
}