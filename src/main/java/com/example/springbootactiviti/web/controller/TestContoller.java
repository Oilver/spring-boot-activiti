package com.example.springbootactiviti.web.controller;

import com.example.springbootactiviti.dto.TaskRepresentation;
import com.example.springbootactiviti.web.service.ActivitiService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestContoller {

    @Autowired
    private ActivitiService activitiService;

    //开启流程实例
    @RequestMapping(value = "/process/{personId}/{compId}", method = RequestMethod.GET)
    public void startProcessInstance(@PathVariable Integer personId, @PathVariable Integer compId) {
        activitiService.startProcess(personId, compId);
    }

    //获取当前人的任务
    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<TaskRepresentation> getTasks(@RequestParam String assignee) {
        List<Task> tasks = activitiService.getTask(assignee);
        List<TaskRepresentation> dtos = new ArrayList<>();
        for (Task task : tasks) {
            dtos.add(new TaskRepresentation(task.getId(), task.getName()));
        }
        return dtos;
    }

    //完成任务
    @RequestMapping(value = "/complete/{joinApproved}/{taskId}", method = RequestMethod.GET)
    public String complete(@PathVariable Boolean joinApproved, @PathVariable String taskId) {
        activitiService.completeTask(joinApproved, taskId);
        return "ok";
    }

}
