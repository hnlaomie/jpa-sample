package org.laomie.shop.test.dao;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import org.laomie.shop.dao.repository.UserDao;
import org.laomie.shop.entity.User;
import org.springframework.test.annotation.Rollback;

/**
  * @author laomie
  */
@ContextConfiguration("/spring/applicationContextTest-dao.xml")
//@DirtiesContext

public class UserDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private UserDao userDao;

    @Test
    public void getUsers() {
		assertNotNull(userDao);
		List<User> users = userDao.getUsers();
		assertNotNull(users);
		assertTrue(users.size() > 0);
    }

	@Test
    public void getUser() {
		String userName = "admin";
		User user = userDao.get(1);
		assertNotNull(user);
		assertEquals("the first user is admin.", user.getUserName(), userName);
	}

	@Test
    //@Rollback(false)
    public void updateUser() {
		String userName = "admin-test";
		User user = userDao.get(1);
		user.setUserName(userName);
		userDao.update(user);
		int newId = user.getUserId();
		User newUser = userDao.get(newId);
		assertEquals("update user from admin to admin-test.", newUser.getUserName(), userName);
	}

}
