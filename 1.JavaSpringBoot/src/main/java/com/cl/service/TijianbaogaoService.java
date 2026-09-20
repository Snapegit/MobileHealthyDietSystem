package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TijianbaogaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TijianbaogaoView;


/**
 * 体检报告
 *
 * @author 
 * @email 
 * @date 2024-02-20 00:40:03
 */
public interface TijianbaogaoService extends IService<TijianbaogaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TijianbaogaoView> selectListView(Wrapper<TijianbaogaoEntity> wrapper);
   	
   	TijianbaogaoView selectView(@Param("ew") Wrapper<TijianbaogaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TijianbaogaoEntity> wrapper);
   	

}

