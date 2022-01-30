package com.SonMinSang.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ObjectMapperApplicationTests {

    @Test
    void contestLoads() throws JsonProcessingException {
        System.out.println("============");

        // Text JSON -> Object
        // Object -> Text JSON

        // controller req json(text) -> object
        // response object -> json(text)

        var objectMapper = new ObjectMapper();

        // object -> text
        // getter
        var user = new User("steve", 10, "010-1111-1111");
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // text -> object
        // default constructor
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);
    }
}
