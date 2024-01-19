package org.example.ridesharingapplication.repositories;

import org.example.ridesharingapplication.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private Map<String, User> userMap = new HashMap<>();

    public void addUser(User user){
        if(!userMap.containsKey(user.getName())){
            userMap.put(user.getName(), user);
        }

    }

    public User getUser(String userName){
        return userMap.get(userName);
    }

    public List<User> getAllUsers(){
        return new ArrayList<>(userMap.values());
    }
}
