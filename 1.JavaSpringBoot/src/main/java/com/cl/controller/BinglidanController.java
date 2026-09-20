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

import com.cl.entity.BinglidanEntity;
import com.cl.entity.view.BinglidanView;

import com.cl.service.BinglidanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 病例单
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-20 00:40:03
 */
@RestController
@RequestMapping("/binglidan")
public class BinglidanController {
    @Autowired
    private BinglidanService binglidanService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BinglidanEntity binglidan,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jiuzhenshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jiuzhenshijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			binglidan.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<BinglidanEntity> ew = new EntityWrapper<BinglidanEntity>();
                if(jiuzhenshijianstart!=null) ew.ge("jiuzhenshijian", jiuzhenshijianstart);
                if(jiuzhenshijianend!=null) ew.le("jiuzhenshijian", jiuzhenshijianend);

		PageUtils page = binglidanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, binglidan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BinglidanEntity binglidan, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jiuzhenshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jiuzhenshijianend,
		HttpServletRequest request){
        EntityWrapper<BinglidanEntity> ew = new EntityWrapper<BinglidanEntity>();
                if(jiuzhenshijianstart!=null) ew.ge("jiuzhenshijian", jiuzhenshijianstart);
                if(jiuzhenshijianend!=null) ew.le("jiuzhenshijian", jiuzhenshijianend);

		PageUtils page = binglidanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, binglidan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BinglidanEntity binglidan){
       	EntityWrapper<BinglidanEntity> ew = new EntityWrapper<BinglidanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( binglidan, "binglidan")); 
        return R.ok().put("data", binglidanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BinglidanEntity binglidan){
        EntityWrapper< BinglidanEntity> ew = new EntityWrapper< BinglidanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( binglidan, "binglidan")); 
		BinglidanView binglidanView =  binglidanService.selectView(ew);
		return R.ok("查询病例单成功").put("data", binglidanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BinglidanEntity binglidan = binglidanService.selectById(id);
		binglidan = binglidanService.selectView(new EntityWrapper<BinglidanEntity>().eq("id", id));
        return R.ok().put("data", binglidan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BinglidanEntity binglidan = binglidanService.selectById(id);
		binglidan = binglidanService.selectView(new EntityWrapper<BinglidanEntity>().eq("id", id));
        return R.ok().put("data", binglidan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BinglidanEntity binglidan, HttpServletRequest request){
    	binglidan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(binglidan);
        binglidanService.insert(binglidan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BinglidanEntity binglidan, HttpServletRequest request){
    	binglidan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(binglidan);
        binglidanService.insert(binglidan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BinglidanEntity binglidan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(binglidan);
        binglidanService.updateById(binglidan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        binglidanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
