package com.nafu.dsm.application;

import com.dayatang.annotations.Transactional;
import com.dayatang.domain.AbstractEntity;

/**
 * 应用层
 * @author xmfang
 *
 */
public interface DsmApplication {

	@Transactional
	public void saveEntity(AbstractEntity entity);
	
	@Transactional
	public void removeEntity(AbstractEntity entity);
	
}
