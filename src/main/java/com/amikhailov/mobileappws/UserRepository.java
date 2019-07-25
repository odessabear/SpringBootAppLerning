package com.amikhailov.mobileappws;

import com.amikhailov.mobileappws.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <UserEntity, Long >{
}
