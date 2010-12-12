/**
 * Copyright (c) 2010 laomie <laomie@msn.com>
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * # Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *
 * # Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 */

package org.laomie.shop.dao.common;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.laomie.shop.dao.repository.IRepository;

/**
 * @author laomie
 */
public class HibernateGenericDao<T> implements IRepository<T> {
	protected Class<T> persistClass;
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public HibernateGenericDao() {
		this.persistClass = (Class<T>)((ParameterizedType)this.getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 *
	 * @see sample.repository.Repository#remove(java.lang.Object)
	 */
	public void remove(T entity) {
		em.remove(entity);
	}

	/**
	 * @see sample.repository.Repository#get(int)
	 */
	@SuppressWarnings("unchecked")
	public T get(Object key) {
		return (T) em.find(this.persistClass, key);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> query(String querySql, Map<String, Object> parameter) {
        Query query = em.createQuery(querySql);
        if (parameter != null) {
            for (String key : parameter.keySet()) {
                query.setParameter(key, parameter.get(key));
            }
        }
		List<T> result = query.getResultList();
        return result;
	}

    @SuppressWarnings("unchecked")
	public List<Object[]> search(String querySql, Map<String, Object> parameter) {
		Query query = em.createQuery(querySql);
		if (parameter != null) {
            for (String key : parameter.keySet()) {
                query.setParameter(key, parameter.get(key));
            }
        }
		List<Object[]> result = query.getResultList();
        return result;
	}	

	/**
	 * @see sample.repository.Repository#add(java.lang.Object)
	 */
	public void add(T entity) {
		em.persist(entity);
	}

	/**
	 * @see sample.repository.Repository#update(java.lang.Object)
	 */
	public void update(T entity) {
        em.merge(entity);
	}
	
}
