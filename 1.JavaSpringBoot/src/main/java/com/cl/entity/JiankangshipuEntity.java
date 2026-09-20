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
 * 健康食谱
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-02-20 00:40:03
 */
@TableName("jiankangshipu")
public class JiankangshipuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiankangshipuEntity() {
		
	}
	
	public JiankangshipuEntity(T t) {
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
	 * 食谱名称
	 */
					
	private String shipumingcheng;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 适合人群
	 */
					
	private String shiherenqun;
	
	/**
	 * 材料
	 */
					
	private String cailiao;
	
	/**
	 * 食谱功效
	 */
					
	private String shipugongxiao;
	
	/**
	 * 制作方法
	 */
					
	private String zhizuofangfa;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	/**
	 * 点击次数
	 */
					
	private Integer clicknum;
	
	
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
	 * 设置：食谱名称
	 */
	public void setShipumingcheng(String shipumingcheng) {
		this.shipumingcheng = shipumingcheng;
	}
	/**
	 * 获取：食谱名称
	 */
	public String getShipumingcheng() {
		return shipumingcheng;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：适合人群
	 */
	public void setShiherenqun(String shiherenqun) {
		this.shiherenqun = shiherenqun;
	}
	/**
	 * 获取：适合人群
	 */
	public String getShiherenqun() {
		return shiherenqun;
	}
	/**
	 * 设置：材料
	 */
	public void setCailiao(String cailiao) {
		this.cailiao = cailiao;
	}
	/**
	 * 获取：材料
	 */
	public String getCailiao() {
		return cailiao;
	}
	/**
	 * 设置：食谱功效
	 */
	public void setShipugongxiao(String shipugongxiao) {
		this.shipugongxiao = shipugongxiao;
	}
	/**
	 * 获取：食谱功效
	 */
	public String getShipugongxiao() {
		return shipugongxiao;
	}
	/**
	 * 设置：制作方法
	 */
	public void setZhizuofangfa(String zhizuofangfa) {
		this.zhizuofangfa = zhizuofangfa;
	}
	/**
	 * 获取：制作方法
	 */
	public String getZhizuofangfa() {
		return zhizuofangfa;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
	/**
	 * 设置：点击次数
	 */
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}

}
