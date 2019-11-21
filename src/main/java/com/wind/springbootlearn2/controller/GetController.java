package com.wind.springbootlearn2.controller;

import com.wind.springbootlearn2.entity.SetResourceValueBean;
import com.wind.springbootlearn2.entity.UserControllerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
* 1、@RequestMapping和@GetMapping区别
        @RequestMapping可以指定GET、POST请求方式
        @GetMapping等价于@RequestMapping的GET请求方式
* */

//GET请求的学习
@RestController
public class GetController {

    private Map<String, Object> params = new HashMap<>();

    /*
     * 测试restful协议，从路径中获取字段
     * @param cityId
     * @param userId
     *测试路径：localhost:8080/100/1
     * */
    @RequestMapping(path = "/v1/{city_id}/{user_id}", method = RequestMethod.GET)
    public Object findUser(@PathVariable("city_id") String cityId,
                           @PathVariable("user_id") String userId) {
        params.clear();
        params.put("cityId", cityId);
        params.put("userId", userId);
        return params;
    }

    /*
     * 测试GetMapping
     * @param from
     * @param size
     *
     * localhost:8080/v1/page_user1?from=11&size=11
     * */
    @GetMapping(value = "/v1/page_user1")
    public Object pageUser(int from, int size) {
        params.clear();
        params.put("from", from);
        params.put("size", size);
        return params;
    }

    /*
     * 默认值，是否为必须参数，别名
     * @param from
     * @param size
     *
     * localhost:8080/v1/page_user2?page=11&size=11
     * */
    @GetMapping(value = "/v1/page_user2")
    public Object pageUserV2(@RequestParam(defaultValue = "0", name = "page") int from, int size) {
        params.put("page", from);
        params.put("size", size);
        return params;
    }

    /*
    * bean对象传参
    * 注意：1.注意需要指定http头为content-type为applicaiton/json
    *       2.使用body传递数据
    *       3.post请求，不然会报找不到RequestBody
    * @param userControllerBean
    *
    *localhost:8080/v1/save_user
    *postman的body选raw
    {
	"age":12
      }
    * */
    @RequestMapping("/v1/save_user")
    public Object saveUser(@RequestBody UserControllerBean userControllerBean) {
        params.clear();
        params.put("user", userControllerBean);
        return params;
    }

    /*
     * 获取http头信息
     * @param accessToken
     * @param id
     *
     * localhost:8080/v1/get_header?id=1
     *在postman的header中填写access_token的key和value
     * */
    @GetMapping("/v1/get_header")
    public Object getHeader(@RequestHeader("access_token") String accessToken, String id) {
        params.clear();
        params.put("access_token", accessToken);
        params.put("id", id);
        return params;
    }

    /*
     * jackson的使用
     *    @JsonIgnore 对字段进行注解，不对前端返回该字段
     *    @JsonFormat(pattern = "yyy-mm-dd hh:mm:ss",locale = "zh",timezone = "GMT+8") 对Date的类进行格式转换
     *    @JsonProperty("uPhone") 格式化之后对前端暴露的字段名
     *    @JsonInclude(Include.NON_NULL) 为空就不返回前端
     *
     * localhost:8080/testjackson
     * */
    @RequestMapping("/testjackson")
    public Object testjackson() {
        return new UserControllerBean(111, "111", "11", new Date());
    }

    @Autowired
    SetResourceValueBean setResourceValueBean;

    @GetMapping("/test/getresource")
    public SetResourceValueBean getResource() {
        return setResourceValueBean;
    }
}
