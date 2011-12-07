package com.autochartist.web.aclite.client.model;

import java.io.Serializable;

public class Group implements Serializable {

	private int groupId;
	private String groupName;
	
	public Group() {
		super();
	}

	public Group(int groupid, String groupname) {
		groupId = groupid;
		groupName = groupname;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public boolean equals(Object obj) {
		return groupId == ((Group) obj).groupId;
	}

	@Override
	public int hashCode() {
		return groupId;
	}	
}


