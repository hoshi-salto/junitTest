package jp.co.test.controller;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import jp.co.test.service.LoginService;
import lombok.val;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
public class LoginControllerTest {

    @MockBean
    private LoginService loginService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getLoginTest() throws Exception {
        val ret = mockMvc.perform(get("/auth/login")).andReturn();
        assertThat(ret.getResponse().getStatus(), is(200));
    }

    @Test
    public void postLoginSuccessTest() throws Exception {

        when(loginService.login(any())).thenReturn(true);

        val params = new HashMap<String, String>();
        params.put("userId", "a");
        params.put("password", "a");

        val urlParams = params.entrySet().stream()
                .map(p -> new BasicNameValuePair(p.getKey(), p.getValue()))
                .collect(Collectors.toList());

        val ret = mockMvc.perform(post("/auth/login?" + URLEncodedUtils.format(urlParams, StandardCharsets.UTF_8))).andReturn();

        assertThat(ret.getResponse().getStatus(), is(200));
    }

    @Test
    public void postLoginNgTest() throws Exception {

        when(loginService.login(any())).thenReturn(false);

        val params = new HashMap<String, String>();
        params.put("userId", "a");
        params.put("password", "a");

        val urlParams = params.entrySet().stream()
                .map(p -> new BasicNameValuePair(p.getKey(), p.getValue()))
                .collect(Collectors.toList());

        val ret = mockMvc.perform(post("/auth/login?" + URLEncodedUtils.format(urlParams, StandardCharsets.UTF_8))).andReturn();

        assertThat(ret.getResponse().getStatus(), is(200));
    }
}
