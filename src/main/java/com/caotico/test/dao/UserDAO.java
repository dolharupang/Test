package com.caotico.test.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserDAO extends SqlSessionDaoSupport {
	public int getResult() {
		return (Integer) getSqlSession().selectOne("userDao.getLoginResult");
	}
}
