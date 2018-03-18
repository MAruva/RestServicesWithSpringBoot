package com.mallikaaruva.springbootusers;

import com.mallikaaruva.springbootusers.controller.UsersController;
import com.mallikaaruva.springbootusers.model.Users;
import com.mallikaaruva.springbootusers.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@WebMvcTest(value = UsersController.class, secure = false)
public class SpringBootUsersApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    public List<Users> setUsers() {
        List<Users> usersList = new ArrayList<>();
        Users mallika = new Users("Mallika", "admin");
        usersList.add(mallika);
        return usersList;

    }

    @Test
    public void getAllUsers() throws Exception {

        Mockito.when(
                userRepository.findAll()).thenReturn(setUsers());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/all").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{name:Mallika,role:admin}";


        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

}
