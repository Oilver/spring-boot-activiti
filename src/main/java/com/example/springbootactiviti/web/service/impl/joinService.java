package com.example.springbootactiviti.web.service.impl;

import com.example.springbootactiviti.entity.Comp;
import com.example.springbootactiviti.entity.Person;
import com.example.springbootactiviti.mapper.ext.CompMapperExt;
import com.example.springbootactiviti.mapper.ext.PersonMapperExt;
import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class joinService{

    @Autowired
    private CompMapperExt compMapperExt;
    @Autowired
    private PersonMapperExt personMapperExt;

    public void joinGroup(DelegateExecution execution) {
        Boolean bool = (Boolean) execution.getVariable("joinApproved");
        if(bool){
            Integer personId = (Integer) execution.getVariable("personId");
            Integer compId = (Integer) execution.getVariable("compId");
            Comp comp = compMapperExt.selectByPrimaryKey(compId);
            System.out.println(compId);
            Person person = personMapperExt.selectByPrimaryKey(personId);
            person.setCompId(compId);
            personMapperExt.updateByPrimaryKeySelective(person);
            System.out.println("加入公司成功");
        }
        else {
            System.out.println("加入公司失败");
        }

    }

    public List<String> findUsers(DelegateExecution execution) {
        return Arrays.asList("admin1","admin2");
    }
}
