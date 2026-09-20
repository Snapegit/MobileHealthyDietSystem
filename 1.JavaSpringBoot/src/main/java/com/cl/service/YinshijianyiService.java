package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YinshijianyiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinshijianyiView;


/**
 * 饮食建议
 *
 * @author 
 * @email 
 * @date 2024-02-20 00:40:03
 */
public interface YinshijianyiService extends IService<YinshijianyiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinshijianyiView> selectListView(Wrapper<YinshijianyiEntity> wrapper);
   	
   	YinshijianyiView selectView(@Param("ew") Wrapper<YinshijianyiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinshijianyiEntity> wrapper);
   	

}

