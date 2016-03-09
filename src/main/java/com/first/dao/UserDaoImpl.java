package com.first.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.first.model.User;

public class UserDaoImpl implements UserDao{

	private SessionFactory sessionFactory;
	 
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> listUser=(List<User>)sessionFactory.getCurrentSession()
		.createCriteria(User.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
		.list();
		return listUser;
	}

	@Override
	@Transactional
	public void adduser(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
	}

}
