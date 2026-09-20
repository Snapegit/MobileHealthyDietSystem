package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.JiankangzhishiEntity;
import com.cl.entity.view.JiankangzhishiView;

import com.cl.service.JiankangzhishiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 健康知识
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-20 00:40:03
 */
@RestController
@RequestMapping("/jiankangzhishi")
public class JiankangzhishiController {
    @Autowired
    private JiankangzhishiService jiankangzhishiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiankangzhishiEntity jiankangzhishi,
		HttpServletRequest request){
        EntityWrapper<JiankangzhishiEntity> ew = new EntityWrapper<JiankangzhishiEntity>();

		PageUtils page = jiankangzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangzhishi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiankangzhishiEntity jiankangzhishi, 
		HttpServletRequest request){
        EntityWrapper<JiankangzhishiEntity> ew = new EntityWrapper<JiankangzhishiEntity>();

		PageUtils page = jiankangzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangzhishi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiankangzhishiEntity jiankangzhishi){
       	EntityWrapper<JiankangzhishiEntity> ew = new EntityWrapper<JiankangzhishiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiankangzhishi, "jiankangzhishi")); 
        return R.ok().put("data", jiankangzhishiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiankangzhishiEntity jiankangzhishi){
        EntityWrapper< JiankangzhishiEntity> ew = new EntityWrapper< JiankangzhishiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiankangzhishi, "jiankangzhishi")); 
		JiankangzhishiView jiankangzhishiView =  jiankangzhishiService.selectView(ew);
		return R.ok("查询健康知识成功").put("data", jiankangzhishiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiankangzhishiEntity jiankangzhishi = jiankangzhishiService.selectById(id);
		jiankangzhishi = jiankangzhishiService.selectView(new EntityWrapper<JiankangzhishiEntity>().eq("id", id));
        return R.ok().put("data", jiankangzhishi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiankangzhishiEntity jiankangzhishi = jiankangzhishiService.selectById(id);
		jiankangzhishi = jiankangzhishiService.selectView(new EntityWrapper<JiankangzhishiEntity>().eq("id", id));
        return R.ok().put("data", jiankangzhishi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiankangzhishiEntity jiankangzhishi, HttpServletRequest request){
    	jiankangzhishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiankangzhishi);
        jiankangzhishiService.insert(jiankangzhishi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiankangzhishiEntity jiankangzhishi, HttpServletRequest request){
    	jiankangzhishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiankangzhishi);
        jiankangzhishiService.insert(jiankangzhishi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiankangzhishiEntity jiankangzhishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangzhishi);
        jiankangzhishiService.updateById(jiankangzhishi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiankangzhishiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
