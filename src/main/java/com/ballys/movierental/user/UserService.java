package com.ballys.movierental.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    public Collection<User> findUsers() {
        return userMapper.selectAll();
    }


    public void saveUser(User user) {
        userMapper.insert(user);
    }

}
