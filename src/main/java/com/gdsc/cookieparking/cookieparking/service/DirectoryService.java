package com.gdsc.cookieparking.cookieparking.service;

import com.gdsc.cookieparking.cookieparking.domain.Directory;
import com.gdsc.cookieparking.cookieparking.domain.User;
import com.gdsc.cookieparking.cookieparking.repository.DirectoryRepository;
import com.gdsc.cookieparking.cookieparking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectoryService {

    @Autowired
    private DirectoryRepository directoryRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Directory> getDirectoryList(String userId) {
        return directoryRepository.findAllByUserId(userId);
    }


    public Directory addDirectory(String userId, String name) {
        User owner = userRepository.findById(userId).orElse(null);
        Directory directory = new Directory();
        directory.setName(name);

        directory.setUser(owner);
        owner.addDirectory(directory);


        return directoryRepository.save(directory);
    }

    public void delete(Long directoryId) {
        directoryRepository.deleteById(directoryId);
    }

}
