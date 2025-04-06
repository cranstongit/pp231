package web.service;

import org.springframework.beans.factory.annotation.Autowired;

import web.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.repositories.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

   private final UserRepository userRepository;

   @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   @Transactional
   @Override
   public void save(User user) {
      userRepository.save(user);
   }

   @Transactional
   @Override
   public void update(long id, User user) {
      user.setId(id);
      userRepository.save(user);
   }

   @Transactional
   @Override
   public void delete(long id) {
      userRepository.deleteById(id);
   }

   @Override
   public List<User> findAll() {
      return userRepository.findAll();
   }
}
