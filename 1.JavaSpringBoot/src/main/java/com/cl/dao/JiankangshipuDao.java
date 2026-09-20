package com.cl.dao;

import com.cl.entity.JiankangshipuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiankangshipuView;


/**
 * 健康食谱
 * 
 * @author 
 * @email 
 * @date 2024-02-20 00:40:03
 */
public interface JiankangshipuDao extends BaseMapper<JiankangshipuEntity> {
	
	List<JiankangshipuView> selectListView(@Param("ew") Wrapper<JiankangshipuEntity> wrapper);

	List<JiankangshipuView> selectListView(Pagination page,@Param("ew") Wrapper<JiankangshipuEntity> wrapper);
	
	JiankangshipuView selectView(@Param("ew") Wrapper<JiankangshipuEntity> wrapper);
	

}
