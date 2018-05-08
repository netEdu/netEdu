package com.netEdu.freeDiscuss.group.service;


import com.netEdu.entity.Group;
import com.netEdu.entity.VO.GroupVO;

import java.util.List;


public interface GroupService {

String newGroup(Group group);

void delGroup(Group group);

void editGroupMember(Group group);

List<Group> getGroupById(Group group);

GroupVO getPersonInfo(String personIds);
}
