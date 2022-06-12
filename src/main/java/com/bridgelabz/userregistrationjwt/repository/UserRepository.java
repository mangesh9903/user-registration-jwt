package com.bridgelabz.userregistrationjwt.repository;

import com.bridgelabz.userregistrationjwt.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/***********************************************************************************************************************
 * interface : User Repository Interface.
 * @author : Mangesh
 * @since : 12-06-2022
 *
 **********************************************************************************************************************/
@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {

}
