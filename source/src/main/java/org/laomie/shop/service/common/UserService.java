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

package org.laomie.shop.service.common;

import java.util.List;
import org.laomie.shop.entity.User;

/**
 *
 * @author laomie
 */
public interface UserService {
	/**
	 * Retrieve all <code>User</code>s from the data store.
	 * @return a <code>List</code> of <code>User</code>s
	 */
	List<User> getUsers();
}
