package com.cl.dao;

import com.cl.entity.JiankangzhishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiankangzhishiView;


/**
 * 健康知识
 * 
 * @author 
 * @email 
 * @date 2024-02-20 00:40:03
 */
public interface JiankangzhishiDao extends BaseMapper<JiankangzhishiEntity> {
	
	List<JiankangzhishiView> selectListView(@Param("ew") Wrapper<JiankangzhishiEntity> wrapper);

	List<JiankangzhishiView> selectListView(Pagination page,@Param("ew") Wrapper<JiankangzhishiEntity> wrapper);
	
	JiankangzhishiView selectView(@Param("ew") Wrapper<JiankangzhishiEntity> wrapper);
	

}
