package org.example.ratelimiter.repositories;

import org.example.ratelimiter.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository(){
        createUsers();
    }

    public void createUsers(){
        User user1 = new User();
        user1.setId(1);
        user1.setName("John Doe");
        user1.setTierId(1); // FREE tier

        User user2 = new User();
        user2.setId(2);
        user2.setName("Jane Smith");
        user2.setTierId(2); // GO tier

        User user3 = new User();
        user3.setId(3);
        user3.setName("Bob Johnson");
        user3.setTierId(3); // PLUS tier

        User user4 = new User();
        user4.setId(4);
        user4.setName("Alice Williams");
        user4.setTierId(4); // PRO tier

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    }

    public User getUserById(int id){
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public User getUserByName(String name){
        return users.stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<User> getAllUsers(){
        return new ArrayList<>(users);
    }

    public List<User> getUsersByTierId(int tierId){
        return users.stream()
                .filter(user -> user.getTierId() == tierId)
                .toList();
    }
}
