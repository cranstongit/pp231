package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.model.User;
import web.repositories.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

   private final UserRepository userRepository;

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
      User existingUser = userRepository.findById(id)
              .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

      existingUser.setFirstName(user.getFirstName());
      existingUser.setLastName(user.getLastName());
      existingUser.setEmail(user.getEmail());

      userRepository.save(existingUser);
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
