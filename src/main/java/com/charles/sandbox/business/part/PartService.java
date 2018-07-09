package com.charles.sandbox.business.part;

import javax.annotation.Resource;

import com.charles.sandbox.remote.api.store.IPartStoreClient;

public abstract class PartService {
	
	@Resource
	IPartStoreClient partStoreClient;
	
}
