package com.example.springbootactiviti.web.service;

import org.activiti.engine.task.Task;

import java.util.List;

public interface ActivitiService {

    void startProcess(Integer personId,Integer compId);

    /**
     * 获取某个人的任务列表
     * @param assignee
     * @return
     */
    List<Task> getTask(String assignee);

    /**
     * 完成任务
     * @param bool
     * @param taskId
     */
    void completeTask(Boolean bool,String taskId);
}
