package br.com.teti.kitha.dao;

import br.com.teti.kitha.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findById(int id);

    List<User> findByUserName(String userName);

    @Query("select u from User u where u.userName = :#{#user.userName} and u.password = :#{#user.password}")
    List<User> findByLogin(@Param("user") User user);
}
