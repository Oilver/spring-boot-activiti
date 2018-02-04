package com.example.springbootactiviti.web.service;

import org.activiti.engine.delegate.DelegateExecution;

import java.util.List;

public interface JoinService {

    void joinGroup(DelegateExecution execution);

    List<String> findUsers(DelegateExecution execution);
}
