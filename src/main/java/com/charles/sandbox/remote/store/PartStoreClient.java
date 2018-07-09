package com.charles.sandbox.remote.store;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.charles.sandbox.remote.api.dataobject.OrderablePartDTO;
import com.charles.sandbox.remote.api.exception.RemotingException;
import com.charles.sandbox.remote.api.store.IPartStoreClient;

@Component
public class PartStoreClient implements IPartStoreClient {

	@Override
	public Map<String, OrderablePartDTO> getParts() throws RemotingException {
		// TODO Auto-generated method stub
		return null;
	}

}
