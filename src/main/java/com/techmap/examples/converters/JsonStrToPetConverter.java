package com.techmap.examples.converters;


import org.springframework.core.convert.converter.Converter;

import com.alibaba.fastjson.JSON;
import com.techmap.examples.entities.Pet;

public class JsonStrToPetConverter implements Converter<String, Pet>
{

    @Override
    public Pet convert(String json)
    {
        return JSON.parseObject(json,Pet.class);
    }
    
}
