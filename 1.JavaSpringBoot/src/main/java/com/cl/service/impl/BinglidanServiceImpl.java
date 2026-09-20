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


import com.cl.dao.BinglidanDao;
import com.cl.entity.BinglidanEntity;
import com.cl.service.BinglidanService;
import com.cl.entity.view.BinglidanView;

@Service("binglidanService")
public class BinglidanServiceImpl extends ServiceImpl<BinglidanDao, BinglidanEntity> implements BinglidanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BinglidanEntity> page = this.selectPage(
                new Query<BinglidanEntity>(params).getPage(),
                new EntityWrapper<BinglidanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BinglidanEntity> wrapper) {
		  Page<BinglidanView> page =new Query<BinglidanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<BinglidanView> selectListView(Wrapper<BinglidanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BinglidanView selectView(Wrapper<BinglidanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
