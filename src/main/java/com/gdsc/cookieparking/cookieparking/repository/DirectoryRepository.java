package com.gdsc.cookieparking.cookieparking.repository;

import com.gdsc.cookieparking.cookieparking.domain.Directory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DirectoryRepository extends JpaRepository<Directory, Long> {

    List<Directory> findAllByUserId(String userId);

}
