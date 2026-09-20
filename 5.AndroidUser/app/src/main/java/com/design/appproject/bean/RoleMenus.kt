package com.design.appproject.bean

import com.blankj.utilcode.util.GsonUtils
import com.google.gson.reflect.TypeToken

var roleMenusList =
    GsonUtils.fromJson<List<RoleMenusItem>>("[{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-present\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"轮播图\",\"menuJump\":\"列表\",\"tableName\":\"config\"}],\"fontClass\":\"icon-common47\",\"menu\":\"轮播图管理\",\"unicode\":\"&#xef63;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-goods\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"用户\",\"menuJump\":\"列表\",\"tableName\":\"yonghu\"},{\"appFrontIcon\":\"cuIcon-vip\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"管理员\",\"menuJump\":\"列表\",\"tableName\":\"users\"}],\"fontClass\":\"icon-common8\",\"menu\":\"系统用户管理\",\"unicode\":\"&#xedb6;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-send\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"回复\"],\"menu\":\"留言板\",\"menuJump\":\"列表\",\"tableName\":\"messages\"}],\"fontClass\":\"icon-common44\",\"menu\":\"留言板管理\",\"unicode\":\"&#xef28;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-cardboard\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"健康知识\",\"menuJump\":\"列表\",\"tableName\":\"jiankangzhishi\"}],\"fontClass\":\"icon-common47\",\"menu\":\"健康知识管理\",\"unicode\":\"&#xef63;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-vip\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"健康食谱\",\"menuJump\":\"列表\",\"tableName\":\"jiankangshipu\"}],\"fontClass\":\"icon-common50\",\"menu\":\"健康食谱管理\",\"unicode\":\"&#xef96;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-paint\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"健康数据\",\"menuJump\":\"列表\",\"tableName\":\"jiankangshuju\"}],\"fontClass\":\"icon-common16\",\"menu\":\"健康数据管理\",\"unicode\":\"&#xedfd;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-rank\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"饮食建议\"],\"menu\":\"体检报告\",\"menuJump\":\"列表\",\"tableName\":\"tijianbaogao\"}],\"fontClass\":\"icon-common12\",\"menu\":\"体检报告管理\",\"unicode\":\"&#xedf4;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-brand\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"病例单\",\"menuJump\":\"列表\",\"tableName\":\"binglidan\"}],\"fontClass\":\"icon-common29\",\"menu\":\"病例单管理\",\"unicode\":\"&#xee2e;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-cardboard\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"健康计划\",\"menuJump\":\"列表\",\"tableName\":\"jiankangjihua\"}],\"fontClass\":\"icon-common47\",\"menu\":\"健康计划管理\",\"unicode\":\"&#xef63;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-qrcode\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"我的收藏\",\"menuJump\":\"1\",\"tableName\":\"storeup\"}],\"fontClass\":\"icon-common48\",\"menu\":\"我的收藏管理\",\"unicode\":\"&#xef65;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-keyboard\",\"buttons\":[\"新增\",\"查看\"],\"menu\":\"留言板\",\"menuJump\":\"列表\",\"tableName\":\"messages\"}],\"menu\":\"留言板管理\"}],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"管理员\",\"tableName\":\"users\"},{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-send\",\"buttons\":[\"查看\"],\"menu\":\"留言板\",\"menuJump\":\"列表\",\"tableName\":\"messages\"}],\"fontClass\":\"icon-common44\",\"menu\":\"留言板管理\",\"unicode\":\"&#xef28;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-paint\",\"buttons\":[\"新增\",\"查看\"],\"menu\":\"健康数据\",\"menuJump\":\"列表\",\"tableName\":\"jiankangshuju\"}],\"fontClass\":\"icon-common16\",\"menu\":\"健康数据管理\",\"unicode\":\"&#xedfd;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-rank\",\"buttons\":[\"新增\",\"查看\"],\"menu\":\"体检报告\",\"menuJump\":\"列表\",\"tableName\":\"tijianbaogao\"}],\"fontClass\":\"icon-common12\",\"menu\":\"体检报告管理\",\"unicode\":\"&#xedf4;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-brand\",\"buttons\":[\"新增\",\"查看\"],\"menu\":\"病例单\",\"menuJump\":\"列表\",\"tableName\":\"binglidan\"}],\"fontClass\":\"icon-common29\",\"menu\":\"病例单管理\",\"unicode\":\"&#xee2e;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-flashlightopen\",\"buttons\":[\"查看\"],\"menu\":\"饮食建议\",\"menuJump\":\"列表\",\"tableName\":\"yinshijianyi\"}],\"fontClass\":\"icon-common21\",\"menu\":\"饮食建议管理\",\"unicode\":\"&#xee03;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-cardboard\",\"buttons\":[\"新增\",\"查看\"],\"menu\":\"健康计划\",\"menuJump\":\"列表\",\"tableName\":\"jiankangjihua\"}],\"fontClass\":\"icon-common47\",\"menu\":\"健康计划管理\",\"unicode\":\"&#xef63;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-qrcode\",\"buttons\":[\"查看\"],\"menu\":\"我的收藏\",\"menuJump\":\"1\",\"tableName\":\"storeup\"}],\"fontClass\":\"icon-common48\",\"menu\":\"我的收藏管理\",\"unicode\":\"&#xef65;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-keyboard\",\"buttons\":[\"新增\",\"查看\"],\"menu\":\"留言板\",\"menuJump\":\"列表\",\"tableName\":\"messages\"}],\"menu\":\"留言板管理\"}],\"hasBackLogin\":\"否\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"是\",\"hasFrontRegister\":\"是\",\"roleName\":\"用户\",\"tableName\":\"yonghu\"}]", object : TypeToken<List<RoleMenusItem>>() {}.type)

data class RoleMenusItem(
    val backMenu: List<MenuBean>,
    val frontMenu: List<MenuBean>,
    val hasBackLogin: String,
    val hasBackRegister: String,
    val hasFrontLogin: String,
    val hasFrontRegister: String,
    val roleName: String,
    val tableName: String
)

data class MenuBean(
    val child: List<Child>,
    val menu: String,
    val fontClass: String,
    val unicode: String=""
)

data class Child(
    val appFrontIcon: String,
    val buttons: List<String>,
    val menu: String,
    val menuJump: String,
    val tableName: String
)

