package top.yeonon.yclouddisk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import top.yeonon.yclouddisk.entity.User;

/**
 * @Author yeonon
 * @date 2019/10/10 0010 22:50
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(@Param("username") String username);
}
