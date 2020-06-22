package com.lesson.practice.day09

/**
 * @author LiuJing
 * @create 2020-05-30 7:18
 */
object Practice_Method6 {
  def main(args: Array[String]): Unit = {
    //不同省份(当中)商品点击排行
    //省份 => (商品,count)
    //Map(河南 -> List((鞋,6), (衣服,3), (电脑,2), (帽子,1)),
    // 河北 -> List((衣服,6), (鞋,4), (帽子,3), (电脑,1)))
    val dataList = List(
      ("zhangsan", "河北", "鞋"),
      ("lisi", "河北", "衣服"),
      ("wangwu", "河北", "鞋"),
      ("zhangsan", "河南", "鞋"),
      ("lisi", "河南", "衣服"),
      ("wangwu", "河南", "鞋"),
      ("zhangsan", "河南", "鞋"),
      ("lisi", "河北", "衣服"),
      ("wangwu", "河北", "鞋"),
      ("zhangsan", "河北", "鞋"),
      ("lisi", "河北", "衣服"),
      ("wangwu", "河北", "帽子"),
      ("zhangsan", "河南", "鞋"),
      ("lisi", "河南", "衣服"),
      ("wangwu", "河南", "帽子"),
      ("zhangsan", "河南", "鞋"),
      ("lisi", "河北", "衣服"),
      ("wangwu", "河北", "帽子"),
      ("lisi", "河北", "衣服"),
      ("wangwu", "河北", "电脑"),
      ("zhangsan", "河南", "鞋"),
      ("lisi", "河南", "衣服"),
      ("wangwu", "河南", "电脑"),
      ("zhangsan", "河南", "电脑"),
      ("lisi", "河北", "衣服"),
      ("wangwu", "河北", "帽子")
    )

    //1.清洗数据
    val list1: List[(String, String)] = dataList.map(
      data => {
        (data._2, data._3)
      }
    )
    //2.分组,以省份进行分组
    val groupListToMap: Map[String, List[(String, String)]]
        = list1.groupBy(data => data._1)
    //(省份->((省份,商品),(省份,商品)...),..) => (省份->((商品,count),(商品,count)...),..)
    //对相同商品进行求和
    val countList: Map[String, List[(String, Int)]] = groupListToMap.map(
      kv => {
        //取出value
        val v = kv._2

        //value:List((省份,商品),(省份,商品)...) => List((商品,count),(商品,count)...)

        //按照商品分组
        val map: Map[String, List[(String, String)]] = v.groupBy(data => data._2)
        //根据分组求出count
        val stringToInt: Map[String, Int] = map.map(e => (e._1, e._2.size))
        //返回所需类型
        (kv._1, stringToInt.toList)
      }
    )

    //排序
    //Map(省份->List((商品,count),(商品,count)...),...)
    val result: Map[String, List[(String, Int)]] = countList.mapValues(
      v => {
        v.sortWith(
          (left, right) => {
            left._2 > right._2
          }
        )
      }
    )
    println(result)

  }
}
