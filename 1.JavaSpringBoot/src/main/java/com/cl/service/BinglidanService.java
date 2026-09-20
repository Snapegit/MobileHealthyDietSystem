package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BinglidanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BinglidanView;


/**
 * 病例单
 *
 * @author 
 * @email 
 * @date 2024-02-20 00:40:03
 */
public interface BinglidanService extends IService<BinglidanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BinglidanView> selectListView(Wrapper<BinglidanEntity> wrapper);
   	
   	BinglidanView selectView(@Param("ew") Wrapper<BinglidanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BinglidanEntity> wrapper);
   	

}

