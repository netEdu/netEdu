package com.netEdu.freeDiscuss.group.controller;


import com.netEdu.entity.Group;
import com.netEdu.freeDiscuss.group.service.impl.GroupImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GroupController {

    @Autowired
    private GroupImpl groupImpl;

    //这里需要person_id和group_name
    @PostMapping("/addGroup")
    public String addGroup(@RequestBody Group group){
        return groupImpl.newGroup(group);
    }

    //这里需要group_id
    @PostMapping("/delGroup")
    public void delGroup(@RequestBody Group group){
        groupImpl.delGroup(group);
    }

    //这里需要group_id person_id
    @PostMapping("/editGroupMember")
    public void editGroupMember(@RequestBody Group group){
        groupImpl.editGroupMember(group);
    }

}
