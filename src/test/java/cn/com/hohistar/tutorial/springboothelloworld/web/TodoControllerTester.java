package cn.com.hohistar.tutorial.springboothelloworld.web;

import cn.com.hohistar.tutorial.springboothelloworld.SpringBootHelloworldApplication;
import cn.com.hohistar.tutorial.springboothelloworld.repos.TodoRepos;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootHelloworldApplication.class)
@WebAppConfiguration
public class TodoControllerTester {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));


    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Autowired
    private TodoController todoController;


    @Before
    public void setup() throws Exception {

        this.mockMvc = webAppContextSetup(webApplicationContext).build();

    }


    @Test
    public void testFindAll() throws Exception {

        mockMvc.perform(get("/todo"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.succ", is(true))
                );

    }

    @Test
    public void testCreate() throws Exception {

        JSONObject todo = new JSONObject();
        todo.put("title", "test1");
        todo.put("desc", "desc of test1");

        mockMvc.perform(post("/todo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(todo.toString()))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.succ", is(true)))
                .andExpect(jsonPath("$.data.id", is(10003)))
                .andExpect(jsonPath("$.data.title", is("test1")))
                .andExpect(jsonPath("$.data.desc", is("desc of test1"))
                );
    }


    @Test
    public void testUpdate() throws Exception {

        JSONObject todo = new JSONObject();
        todo.put("id", 10001);
        todo.put("title", "test1");
        todo.put("desc", "desc of test1");

        mockMvc.perform(put("/todo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(todo.toString()))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.succ", is(true)))
                .andExpect(jsonPath("$.data.id", is(10001)))
                .andExpect(jsonPath("$.data.title", is("test1")))
                .andExpect(jsonPath("$.data.desc", is("desc of test1"))
                );
    }


    @Test
    public void testDelete() throws Exception {

        JSONObject todo = new JSONObject();
        todo.put("id", 10001);

        mockMvc.perform(delete("/todo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(todo.toString()))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.succ", is(true))
                );
    }



}
