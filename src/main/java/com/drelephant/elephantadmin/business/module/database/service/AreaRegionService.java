package com.drelephant.elephantadmin.business.module.database.service;

import com.drelephant.framework.base.common.R;

public interface AreaRegionService {
	R deleteAreaRegion(String code);
	R isUsed(String code);
}
