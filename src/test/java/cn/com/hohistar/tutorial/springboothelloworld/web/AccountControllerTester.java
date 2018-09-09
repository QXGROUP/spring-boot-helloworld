package cn.com.hohistar.tutorial.springboothelloworld.web;


import cn.com.hohistar.tutorial.springboothelloworld.SpringBootHelloworldApplication;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootHelloworldApplication.class)
@WebAppConfiguration
public class AccountControllerTester {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));


    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Autowired
    private AccountController accountController;


    @Before
    public void setup() throws Exception {

        this.mockMvc = webAppContextSetup(webApplicationContext).build();

    }

    @Test
    public void testLogin() throws Exception {

        JSONObject account = new JSONObject();
        account.put("username", "tom");
        account.put("password", "123");

        mockMvc.perform(post("/account/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(account.toString()))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.succ", is(true)))
                .andExpect(jsonPath("$.data.token", notNullValue())
                );
    }


    @Test
    public void testLoginWithInvalidUsername() throws Exception {

        JSONObject account = new JSONObject();
        account.put("username", "tom1");
        account.put("password", "123");

        mockMvc.perform(post("/account/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(account.toString()))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.succ", is(false)))
                .andExpect(jsonPath("$.code", is("ACC-001"))
                );
    }

    @Test
    public void testLoginWithInvalidPassword() throws Exception {

        JSONObject account = new JSONObject();
        account.put("username", "tom");
        account.put("password", "123x");

        mockMvc.perform(post("/account/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(account.toString()))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.succ", is(false)))
                .andExpect(jsonPath("$.code", is("ACC-001"))
                );
    }


}
