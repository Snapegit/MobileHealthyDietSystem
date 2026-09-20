package com.design.appproject.bean

/**
 * 病例单实体类
 */
data class BinglidanItemBean(
    var id:Long=0L,
    var jiuzhenshijian:String="",
    var zhusu:String="",
    var bingshi:String="",
    var zhenduan:String="",
    var fujian:String="",
    var yonghuzhanghao:String="",
    var yonghuxingming:String="",
    var addtime:String?=null,
)