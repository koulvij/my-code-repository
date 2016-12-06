package com.vkoul.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vkoul.dao.MasterDataDao;
import com.vkoul.model.RoleMaster;
import com.vkoul.model.WorkspaceMaster;

@Service
public class MasterDataServiceImpl implements MasterDataService {

	@Autowired
	private MasterDataDao dataDao;

	/* (non-Javadoc)
	 * @see com.cov.nagarro.service.MasterDataService#getRoleMasterData()
	 */
	@Override
	public Set<String> getRoleMasterData() {
		return dataDao.getRoleMasterData().stream().map(RoleMaster::getName).collect(Collectors.toSet());
	}

	/* (non-Javadoc)
	 * @see com.cov.nagarro.service.MasterDataService#getWorkspaceMasterData()
	 */
	@Override
	public Set<String> getWorkspaceMasterData() {
		return dataDao.getWorkspaceMasterData().stream().map(WorkspaceMaster::getName).collect(Collectors.toSet());
	}

}
