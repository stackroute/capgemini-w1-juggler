//package com.stackroute.juggler.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//
//import com.stackroute.juggler.model.InputUser;
//import com.stackroute.juggler.model.User;
//import com.stackroute.juggler.repository.UserDao;
//import com.stackroute.juggler.service.KafkaService;
//
//public class KafkaServiceImpl implements KafkaService{
//	
//	@Autowired
//	private UserDao userDao;
//
//	public User save(User user) {
//		return userDao.save(user);
//	}
//
//	@Override
//    @KafkaListener(topics = "userProfile", groupId = "user")
//    public void consumeKafka(User User) {
//        User findUser = null;       
//        if (userDao.findByEmail(User.getEmail()) != null) {
//            findUser.setEmail(User.getEmail());
//            System.out.println(User.getEmail());
//            findUser.setPassword(User.getPassword());
//            userDao.save(findUser);
//        }
//        }
//
//
//
//
//	}