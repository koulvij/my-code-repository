package com.vkoul.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vkoul.model.RoleMaster;
import com.vkoul.model.WorkspaceMaster;

@Repository
@Transactional(readOnly = true)
public class MasterDataDaoImpl implements MasterDataDao {
	
	@PersistenceContext
	private EntityManager entityManager;


	
	@Override
	public List<RoleMaster> getRoleMasterData() {
		final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<RoleMaster> criteriaQuery = builder.createQuery(RoleMaster.class);
		Root<RoleMaster> root = criteriaQuery.from(RoleMaster.class);
		TypedQuery<RoleMaster> typedQuery = entityManager.createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}

	
	
	@Override
	public List<WorkspaceMaster> getWorkspaceMasterData() {
		final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<WorkspaceMaster> criteriaQuery = builder.createQuery(WorkspaceMaster.class);
		Root<WorkspaceMaster> root = criteriaQuery.from(WorkspaceMaster.class);
		TypedQuery<WorkspaceMaster> typedQuery = entityManager.createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}

}
