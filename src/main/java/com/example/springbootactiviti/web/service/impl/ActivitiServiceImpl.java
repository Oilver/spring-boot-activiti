package com.example.springbootactiviti.web.service.impl;

import com.example.springbootactiviti.web.service.ActivitiService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ActivitiServiceImpl implements ActivitiService{
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;


    @Override
    public void startProcess(Integer personId, Integer compId) {
        Map<String,Object> variables = new HashMap<>();
        variables.put("personId",personId);
        variables.put("compId",compId);
        runtimeService.startProcessInstanceByKey("joinProcess",variables);
    }

    @Override
    public List<Task> getTask(String assignee) {
        return taskService.createTaskQuery().taskCandidateUser(assignee).list();
    }

    @Override
    public void completeTask(Boolean bool, String taskId) {
        Map<String, Object> taskVariables = new HashMap<>();
        taskVariables.put("joinApproved", bool);
        taskService.complete(taskId, taskVariables);
    }
}
