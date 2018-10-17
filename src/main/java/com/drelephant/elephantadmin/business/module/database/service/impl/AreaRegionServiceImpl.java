package com.drelephant.elephantadmin.business.module.database.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drelephant.elephantadmin.business.module.client.database.BdAreaRegionClient;
import com.drelephant.elephantadmin.business.module.database.service.AreaRegionService;
import com.drelephant.framework.base.common.R;

import club.zhcs.common.Result;

@Service
public class AreaRegionServiceImpl implements AreaRegionService {
	private static final Log logger = Logs.get();

	@Autowired
	BdAreaRegionClient bdAreaRegionClient;
	
	@Override
	public R deleteAreaRegion(String code) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", code);
		if (logger.isDebugEnabled()) {
			logger.debug(map);
		}
		Result r = bdAreaRegionClient.deleteBdAreaRegion(map);
		if (logger.isDebugEnabled()) {
			logger.debug(r);
		}
		if (r.isSuccess()) {
			return R.ok();
		} else {
			return R.error(1, "不允许删除地区区域");
		}
	}

	@Override
	public R isUsed(String code) {
		// TODO 以后要去查找各个子系统的使用情况
		
		return R.ok("没有被使用");
	}

}
