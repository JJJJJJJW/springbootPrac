package com.ace.springbootPrac;

import com.ace.springbootPrac.domain.Author;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;
import static org.junit.jupiter.api.Assertions.*;

public class jacksonTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testObjectToJSON(){
        Author author = new Author(1L,"Ace",18);
        objectMapper.writeValueAsString(author);
        objectMapper.readValue("", Author.class);
    }
}
