package top.yeonon.sunreaver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.yeonon.sunreaver.entity.CloudFile;

/**
 * @Author yeonon
 * @date 2019/10/10 0010 23:01
 **/
@Repository
public interface CloudFileRepository extends JpaRepository<CloudFile, Long> {
}
