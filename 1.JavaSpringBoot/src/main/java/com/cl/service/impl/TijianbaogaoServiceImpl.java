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


import com.cl.dao.TijianbaogaoDao;
import com.cl.entity.TijianbaogaoEntity;
import com.cl.service.TijianbaogaoService;
import com.cl.entity.view.TijianbaogaoView;

@Service("tijianbaogaoService")
public class TijianbaogaoServiceImpl extends ServiceImpl<TijianbaogaoDao, TijianbaogaoEntity> implements TijianbaogaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TijianbaogaoEntity> page = this.selectPage(
                new Query<TijianbaogaoEntity>(params).getPage(),
                new EntityWrapper<TijianbaogaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TijianbaogaoEntity> wrapper) {
		  Page<TijianbaogaoView> page =new Query<TijianbaogaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<TijianbaogaoView> selectListView(Wrapper<TijianbaogaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TijianbaogaoView selectView(Wrapper<TijianbaogaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
