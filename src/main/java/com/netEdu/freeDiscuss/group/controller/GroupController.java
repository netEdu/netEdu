package com.netEdu.freeDiscuss.group.controller;


import com.netEdu.entity.Group;
import com.netEdu.entity.Student;
import com.netEdu.entity.VO.GroupVO;
import com.netEdu.freeDiscuss.group.service.impl.GroupImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Struct;
import java.util.List;

@RestController
@RequestMapping("/group")
@Api(description = "|在线课堂|分组管理")
public class GroupController {

    @Autowired
    private GroupImpl groupImpl;

    //这里需要person_id和group_name
    @ApiOperation(value = "|freeDiscuss|添加分组",notes =
            "group_name:讨论组名</br>" +
            "person_id:讨论组组员id，用逗号分割，最后一个人后面不带逗号！！！</br>"+
            "返回：组id")
    @PostMapping("/addGroup")
    public String addGroup(@RequestBody Group group){
        return groupImpl.newGroup(group);
    }

    //这里需要group_id
    @ApiOperation(value = "|freeDiscuss|删除分组",notes =
                    "group_id:讨论组id</br>" )
    @DeleteMapping("/delGroup")
    public void delGroup(@RequestBody Group group){
        groupImpl.delGroup(group);
    }


    //这里需要group_id person_id
    @ApiOperation(value = "|freeDiscuss|修改分组内人员",notes =
            "group_id:要修改的讨论组id</br>" +
                    "person_id:要添加/删除的讨论组组员id，用逗号分割，最后一个人后面不带逗号！！！</br>" )
    @PutMapping("/editGroupMember")
    public void editGroupMember(@RequestBody Group group){
        groupImpl.editGroupMember(group);
    }

    @ApiOperation(value = "|freeDiscuss|按id查询分组",notes ="下面两个变量任选其一"+
            "group_id:要查询讨论组id</br>" +
                    "person_id:查询者id，返回一个List，加入的讨论组</br>" )
    @PostMapping("/getGroupById")
    public List<Group> getGroupById(@RequestBody Group group){return groupImpl.getGroupById(group);}

    @ApiOperation(value = "|freeDiscuss|按id查询人员信息",notes ="直接传原封不动的ids"+
            "ids:想查询的id组</br>" )
    @PostMapping("/selectPersonWithId")
    public GroupVO selectPersonWithId(String ids){ return groupImpl.getPersonInfo(ids); }

    @ApiOperation(value = "|freeDiscuss|按Class_num查询人员信息",notes ="按班号class_num查学生")
    @PostMapping("/selectAllClassStudent")
    public List<Student> selectAllClassStudent(String id){
        return groupImpl.findStudents(id);
    }


}
