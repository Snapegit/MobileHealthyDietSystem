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


import com.cl.dao.JiankangzhishiDao;
import com.cl.entity.JiankangzhishiEntity;
import com.cl.service.JiankangzhishiService;
import com.cl.entity.view.JiankangzhishiView;

@Service("jiankangzhishiService")
public class JiankangzhishiServiceImpl extends ServiceImpl<JiankangzhishiDao, JiankangzhishiEntity> implements JiankangzhishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiankangzhishiEntity> page = this.selectPage(
                new Query<JiankangzhishiEntity>(params).getPage(),
                new EntityWrapper<JiankangzhishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiankangzhishiEntity> wrapper) {
		  Page<JiankangzhishiView> page =new Query<JiankangzhishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiankangzhishiView> selectListView(Wrapper<JiankangzhishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiankangzhishiView selectView(Wrapper<JiankangzhishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
