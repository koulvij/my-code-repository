package com.vkoul.service;

import java.util.Set;

public interface MasterDataService {
	
	/**
	 * @return List of RoleMaster roles
	 */
	Set<String> getRoleMasterData();
	
	
	/**
	 * @return List of WorkspaceMaster departments
	 */
	Set<String> getWorkspaceMasterData();

}
