package com.amikhailov.mobileappws.service.impl;

import com.amikhailov.mobileappws.UserRepository;
import com.amikhailov.mobileappws.io.entity.UserEntity;
import com.amikhailov.mobileappws.service.UserService;
import com.amikhailov.mobileappws.shared.dto.UserDto;
import com.amikhailov.mobileappws.shared.dto.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Override
    public UserDto createUser(UserDto user) {



        if ( userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exists");
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        String publicUserId = utils.generateUserId(30);
        userEntity.setEncryptedPassword(publicUserId);
        userEntity.setUserId("testUserId");


        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails,returnValue);

        return returnValue;
    }
}
