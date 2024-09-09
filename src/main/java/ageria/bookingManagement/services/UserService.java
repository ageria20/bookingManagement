package ageria.bookingManagement.services;


import ageria.bookingManagement.entities.User;
import ageria.bookingManagement.exceptions.NotFoundExceptionId;
import ageria.bookingManagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findUserById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundExceptionId(id));
    }

    public void deleteUserById(UUID id){
        if(!userRepository.existsById(id)){
            throw new NotFoundExceptionId(id);
        }else{
        userRepository.deleteById(id);
        System.out.println("User con id: " + id + " cancellato");
        }
    }

    public void findUserByIdAndUpdate(UUID id, String name){
       User found = userRepository.findById(id).orElseThrow(() -> new NotFoundExceptionId(id));

       found.setFullName(name);
       userRepository.save(found);
    }

    public void findByIdAndUpdateName(UUID id, String name){
        User found = userRepository.findById(id).orElseThrow(() -> new NotFoundExceptionId(id));

        found.setFullName(name);

        userRepository.save(found);
    }
    public void findByIdAndUpdateUsername(UUID id, String username){
        User found = userRepository.findById(id).orElseThrow(() -> new NotFoundExceptionId(id));

        found.setUsername(username);

        userRepository.save(found);
    }
    public void findByIdAndUpdateEmail(UUID id, String email){
        User found = userRepository.findById(id).orElseThrow(() -> new NotFoundExceptionId(id));

        found.setEmail(email);

        userRepository.save(found);
    }

    public void findByIdAndUpdateEmail(UUID id,String fullName, String username, String email){
        User found = userRepository.findById(id).orElseThrow(() -> new NotFoundExceptionId(id));

        found.setFullName(fullName);
        found.setUsername(username);
        found.setEmail(email);

        userRepository.save(found);
    }

    public List<User> findByNameStartingWithIgnoreCase(String letterName){
        return userRepository.findByFullNameStartingWith(letterName);
    }
}
