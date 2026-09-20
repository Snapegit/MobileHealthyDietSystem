package com.cl.dao;

import com.cl.entity.BinglidanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BinglidanView;


/**
 * 病例单
 * 
 * @author 
 * @email 
 * @date 2024-02-20 00:40:03
 */
public interface BinglidanDao extends BaseMapper<BinglidanEntity> {
	
	List<BinglidanView> selectListView(@Param("ew") Wrapper<BinglidanEntity> wrapper);

	List<BinglidanView> selectListView(Pagination page,@Param("ew") Wrapper<BinglidanEntity> wrapper);
	
	BinglidanView selectView(@Param("ew") Wrapper<BinglidanEntity> wrapper);
	

}
