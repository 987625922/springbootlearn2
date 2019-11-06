package com.wind.springbootlearn2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


/*
 *  mockmvc使用类
 *
 * */
@RunWith(SpringRunner.class)//底层调用SpringJUnit4ClassRunner
@SpringBootTest(classes = {Springbootlearn2Application.class})//启动整个springboot工程
@AutoConfigureMockMvc
public class MockMvcTestDemo {
    @Autowired
    private MockMvc mockMvc;

    /*
     *  使用MockMvc中MockMvcRequestBuilders对api进行测试
     *  并输出response状态码
     * */
    @Test
    public void testApi() {
        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/testjackson"))
                    .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
            System.out.println("mvcResult的请求返回的状态码：" + mvcResult.getResponse().getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
