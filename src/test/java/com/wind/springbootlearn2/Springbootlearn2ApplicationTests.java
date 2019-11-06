package com.wind.springbootlearn2;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/*
* springboot单元测试
* */
@RunWith(SpringRunner.class)//底层调用SpringJUnit4ClassRunner
@SpringBootTest(classes = {Springbootlearn2Application.class})//启动整个springboot工程
public class Springbootlearn2ApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println("====>");
        TestCase.assertEquals(1,1);
    }

    @Before
    public void testBefore(){
        System.out.println("===>test before");
    }

    @After
    public void testAfter(){
        System.out.println("===>test after");
    }



}
