package com.charles.sandbox.remote.api.store;

import java.util.Map;

import com.charles.sandbox.remote.api.dataobject.OrderablePartDTO;
import com.charles.sandbox.remote.api.exception.RemotingException;

public interface IPartStoreClient {
	
	public Map<String, OrderablePartDTO> getParts() throws RemotingException;

}
