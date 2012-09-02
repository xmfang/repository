package com.nafu.dsm.application.impl;

import com.dayatang.domain.AbstractEntity;
import com.nafu.dsm.application.DsmApplication;

public class DsmApplicationImpl implements DsmApplication {

	@Override
	public void saveEntity(AbstractEntity entity) {
		entity.save();
	}

	@Override
	public void removeEntity(AbstractEntity entity) {
		entity.remove();
	}

}
