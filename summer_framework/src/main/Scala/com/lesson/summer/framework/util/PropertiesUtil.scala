package com.lesson.summer.framework.util

import java.util.{Properties, ResourceBundle}

/**
 * @author LiuJing
 * @create 2020-05-31 23:45
 */
object PropertiesUtil {
  // 绑定配置文件
  // ResourceBundle专门用于读取配置文件，所以读取时，不需要增加扩展名
  // 国际化 = I18N => Properties
  val summer: ResourceBundle = ResourceBundle.getBundle("summer")

  def getValue( key : String ): String = {
    summer.getString(key)
  }
}
