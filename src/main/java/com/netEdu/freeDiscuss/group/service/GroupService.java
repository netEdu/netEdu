package com.netEdu.freeDiscuss.group.service;


import com.netEdu.entity.Group;


public interface GroupService {

String newGroup(Group group);

void delGroup(Group group);

void editGroupMember(Group group);
}
