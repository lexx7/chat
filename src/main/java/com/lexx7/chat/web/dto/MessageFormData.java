package com.lexx7.chat.web.dto;

import java.util.Map;

public class MessageFormData {
	
	private Map<Long, String> users;

	public Map<Long, String> getUsers() {
		return users;
	}

	public void setUsers(Map<Long, String> users) {
		this.users = users;
	}
}
