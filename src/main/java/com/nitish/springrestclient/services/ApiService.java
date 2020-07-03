package com.nitish.springrestclient.services;

import com.nitish.api.domain.User;

import java.util.List;

public interface ApiService {
    List<User> getUsers(Integer limit);
}
