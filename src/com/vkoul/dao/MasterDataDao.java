package com.vkoul.dao;

import java.util.List;

import com.vkoul.model.RoleMaster;
import com.vkoul.model.WorkspaceMaster;

public interface MasterDataDao {
	
/**
 * @return List of RoleMaster roles
 */
List<RoleMaster> getRoleMasterData();

/**
 * @return List WorkspaceMaster dept
 */
List<WorkspaceMaster> getWorkspaceMasterData();

}
