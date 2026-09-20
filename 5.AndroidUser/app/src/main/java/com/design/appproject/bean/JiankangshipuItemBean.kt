package com.design.appproject.bean

/**
 * 健康食谱实体类
 */
data class JiankangshipuItemBean(
    var id:Long=0L,
    var shipumingcheng:String="",
    var fengmian:String="",
    var shiherenqun:String="",
    var cailiao:String="",
    var shipugongxiao:String="",
    var zhizuofangfa:String="",
    var storeupnum:Int=0,
    var clicktime:String="",
    var clicknum:Int=0,
    var addtime:String?=null,
)