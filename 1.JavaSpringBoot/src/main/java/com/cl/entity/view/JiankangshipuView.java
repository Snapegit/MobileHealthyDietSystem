package com.cl.entity.view;

import com.cl.entity.JiankangshipuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 健康食谱
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-02-20 00:40:03
 */
@TableName("jiankangshipu")
public class JiankangshipuView  extends JiankangshipuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiankangshipuView(){
	}
 
 	public JiankangshipuView(JiankangshipuEntity jiankangshipuEntity){
 	try {
			BeanUtils.copyProperties(this, jiankangshipuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
