package com.netEdu.freeDiscuss.group.service;


import com.netEdu.entity.Group;

import java.util.List;


public interface GroupService {

String newGroup(Group group);

void delGroup(Group group);

void editGroupMember(Group group);

List<Group> getGroupById(Group group);
}
