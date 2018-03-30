package com.netEdu.discuss.user.group.service;


import com.netEdu.discuss.user.group.entity.Group;


public interface GroupService {

String newGroup(Group group);

void delGroup(Group group);

void editGroupMember(Group group);
}
