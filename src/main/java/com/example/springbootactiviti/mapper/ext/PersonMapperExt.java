package com.example.springbootactiviti.mapper.ext;

import com.example.springbootactiviti.entity.Person;
import com.example.springbootactiviti.mapper.PersonMapper;

public interface PersonMapperExt extends PersonMapper{

    Person findByPersonName(String personName);
}