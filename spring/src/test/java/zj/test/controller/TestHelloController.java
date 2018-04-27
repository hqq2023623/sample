package zj.test.controller;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import zj.test.base.SpringMVCTestBase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author lzj
 * @date 2018/4/27
 */
public class TestHelloController extends SpringMVCTestBase {

    @Test
    public void testHello() throws Exception {
        mockMvc.perform(get("/zj/hello").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        mockMvc.perform(post("/zj/hello").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andDo(new MyHandler()).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }


    class MyHandler implements ResultHandler {
        @Override
        public void handle(MvcResult result) throws Exception {
            assertEquals("hello",result.getResponse().getContentAsString());
        }
    }

}
