package com.api.eshop.service.converters.stringsToObjects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.api.eshop.domain.Users;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsersConverter extends Users implements Converter<String, Users> {

    @Autowired
    private ObjectMapper objectMapper;


    @SneakyThrows
    @Override
    public Users convert(String source) {
        return objectMapper.readValue(source, Users.class);

    }
}
