package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.JiankangshipuDao;
import com.cl.entity.JiankangshipuEntity;
import com.cl.service.JiankangshipuService;
import com.cl.entity.view.JiankangshipuView;

@Service("jiankangshipuService")
public class JiankangshipuServiceImpl extends ServiceImpl<JiankangshipuDao, JiankangshipuEntity> implements JiankangshipuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiankangshipuEntity> page = this.selectPage(
                new Query<JiankangshipuEntity>(params).getPage(),
                new EntityWrapper<JiankangshipuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiankangshipuEntity> wrapper) {
		  Page<JiankangshipuView> page =new Query<JiankangshipuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiankangshipuView> selectListView(Wrapper<JiankangshipuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiankangshipuView selectView(Wrapper<JiankangshipuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
