package com.lexx7.chat.business.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;

import com.lexx7.chat.web.dto.UserForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lexx7.chat.model.entity.User;
import com.lexx7.chat.model.entity.User_;
import com.lexx7.chat.model.security.SimpleUserDetails;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class); 
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Long createUser(User user) {
		user.setCreateTime(new Date());
		em.persist(user);
		LOGGER.debug("User saved: " + user.getId() +", " + user.getPassword());
		return user.getId();
	}
	
	@Override
	public void updateUser(User user) {
		user.setEditTime(new Date());
		em.merge(user);
		LOGGER.debug("User edit: " + user.getId() +", " + user.getPassword());
	}

	@Override
	public User getUser(Long id) {
		User user = em.find(User.class, id);
		if (user == null) {
			throw new IllegalStateException("User not found: " + id);
		}
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		LOGGER.debug("loadUserByUsername: login: " + login);
		User user = getUserByLogin(login);
		
		SimpleUserDetails userDetails = new SimpleUserDetails();
		userDetails.setEnabled(user.isActive());
		userDetails.setUsername(user.getLogin());
		userDetails.setPassword(user.getPassword());
		LOGGER.debug("loadUserByUsername: " + user.getId() + ", " + userDetails.getUsername());
		return userDetails;
	}

	@Override
	public User getUserByLogin(String login) {
		LOGGER.debug("getUserByLogin: login: " + login);
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
		
		Root<User> root = criteria.from(User.class);
		Predicate loginPredicate = criteriaBuilder.equal(root.get(User_.login), login);
		
		return em.createQuery(criteria.where(loginPredicate)).getSingleResult();
	}

	@Override
	public User save(UserForm userForm) {
		User user = new User();
		user.setCreateTime(new Date());
		user.setLogin(userForm.getLogin());
		user.setColor(userForm.getColor());
		user.setPassword(userForm.getPassword());

		createUser(user);

		return user;
	}

	@Override
	public List<User> getAllUsers() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
		Root root = criteria.from(User.class);

		criteria.where(criteriaBuilder.equal(root.get(User_.active), true));

		List<Order> ord = new ArrayList<>();
		ord.add(criteriaBuilder.desc(root.get(User_.login)));
		criteria.orderBy(ord);

		return em.createQuery(criteria).getResultList();
	}
}
