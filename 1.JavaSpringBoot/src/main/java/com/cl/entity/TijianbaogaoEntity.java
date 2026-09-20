package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 体检报告
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-02-20 00:40:03
 */
@TableName("tijianbaogao")
public class TijianbaogaoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TijianbaogaoEntity() {
		
	}
	
	public TijianbaogaoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 体检日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date tijianriqi;
	
	/**
	 * 主要病史
	 */
					
	private String zhuyaobingshi;
	
	/**
	 * 身高/cm
	 */
					
	private String shengao;
	
	/**
	 * 体重/kg
	 */
					
	private String tizhong;
	
	/**
	 * 检查项目
	 */
					
	private String jianchaxiangmu;
	
	/**
	 * 检查结果
	 */
					
	private String jianchajieguo;
	
	/**
	 * 检查意见
	 */
					
	private String jianchayijian;
	
	/**
	 * 备注
	 */
					
	private String beizhu;
	
	/**
	 * 附件
	 */
					
	private String fujian;
	
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 回复内容
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：体检日期
	 */
	public void setTijianriqi(Date tijianriqi) {
		this.tijianriqi = tijianriqi;
	}
	/**
	 * 获取：体检日期
	 */
	public Date getTijianriqi() {
		return tijianriqi;
	}
	/**
	 * 设置：主要病史
	 */
	public void setZhuyaobingshi(String zhuyaobingshi) {
		this.zhuyaobingshi = zhuyaobingshi;
	}
	/**
	 * 获取：主要病史
	 */
	public String getZhuyaobingshi() {
		return zhuyaobingshi;
	}
	/**
	 * 设置：身高/cm
	 */
	public void setShengao(String shengao) {
		this.shengao = shengao;
	}
	/**
	 * 获取：身高/cm
	 */
	public String getShengao() {
		return shengao;
	}
	/**
	 * 设置：体重/kg
	 */
	public void setTizhong(String tizhong) {
		this.tizhong = tizhong;
	}
	/**
	 * 获取：体重/kg
	 */
	public String getTizhong() {
		return tizhong;
	}
	/**
	 * 设置：检查项目
	 */
	public void setJianchaxiangmu(String jianchaxiangmu) {
		this.jianchaxiangmu = jianchaxiangmu;
	}
	/**
	 * 获取：检查项目
	 */
	public String getJianchaxiangmu() {
		return jianchaxiangmu;
	}
	/**
	 * 设置：检查结果
	 */
	public void setJianchajieguo(String jianchajieguo) {
		this.jianchajieguo = jianchajieguo;
	}
	/**
	 * 获取：检查结果
	 */
	public String getJianchajieguo() {
		return jianchajieguo;
	}
	/**
	 * 设置：检查意见
	 */
	public void setJianchayijian(String jianchayijian) {
		this.jianchayijian = jianchayijian;
	}
	/**
	 * 获取：检查意见
	 */
	public String getJianchayijian() {
		return jianchayijian;
	}
	/**
	 * 设置：备注
	 */
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
	/**
	 * 设置：附件
	 */
	public void setFujian(String fujian) {
		this.fujian = fujian;
	}
	/**
	 * 获取：附件
	 */
	public String getFujian() {
		return fujian;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：回复内容
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}

}
