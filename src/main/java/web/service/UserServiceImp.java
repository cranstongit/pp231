package web.service;

import web.dao.UserDao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDaoUser;

   @Transactional
   @Override
   public void deleteUserTable() {
      userDaoUser.deleteUserTable();
   }

   @Transactional
   @Override
   public void add(User user) {
      userDaoUser.add(user);
   }

   @Override
   public List<User> listUsers() {
      return userDaoUser.listUsers();
   }
}
