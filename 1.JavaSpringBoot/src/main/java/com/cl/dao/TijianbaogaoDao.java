package com.cl.dao;

import com.cl.entity.TijianbaogaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TijianbaogaoView;


/**
 * 体检报告
 * 
 * @author 
 * @email 
 * @date 2024-02-20 00:40:03
 */
public interface TijianbaogaoDao extends BaseMapper<TijianbaogaoEntity> {
	
	List<TijianbaogaoView> selectListView(@Param("ew") Wrapper<TijianbaogaoEntity> wrapper);

	List<TijianbaogaoView> selectListView(Pagination page,@Param("ew") Wrapper<TijianbaogaoEntity> wrapper);
	
	TijianbaogaoView selectView(@Param("ew") Wrapper<TijianbaogaoEntity> wrapper);
	

}
