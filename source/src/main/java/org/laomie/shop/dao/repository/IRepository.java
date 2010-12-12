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

package org.laomie.shop.dao.repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author laomie
 */
public interface IRepository<T> {
	/**
	 * Tries to get an instance of the object
	 * @param id the id to search for
	 * @return the requested instance, or <code>null</code> if not found
	 */
	public T get(Object key);

	/**
	 * Adds a new instance of the object
	 * @param instance the instance to save
	 */
	public void add(T entity);

	/**
	 * Deletes the object
	 * @param instance the object to delete
	 */
	public void remove(T entity);

	/**
	 * Updates the information of an existing object
	 * @param instance the instance to update
	 */
	public void update(T entity);

	public List<T> query(String queryName, Map<String, Object> parameter);

	public List<Object[]> search(String queryName, Map<String, Object> parameter);
}
