package com.gdsc.cookieparking.cookieparking.controller;

import com.gdsc.cookieparking.cookieparking.domain.Cookie;
import com.gdsc.cookieparking.cookieparking.domain.Directory;
import com.gdsc.cookieparking.cookieparking.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DirectoryController {

    @Autowired
    private DirectoryService directoryService;

    @GetMapping("users/{userId}/directories")
    public List<Directory> list(@PathVariable("userId") String userId) {
        return directoryService.getDirectoryList(userId);
    }

    @PostMapping("{userId}/directories")
    public Directory create(@PathVariable("userId") String userId, String name) {
        return directoryService.addDirectory(userId, name);
    }

    //TODO 디렉토리 업데이트 매핑 추가할 것
    //TODO 디렉토리 삭제 매핑 추가할 것

}
