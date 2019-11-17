# springbootlearn2
## https://edu.51cto.com/course/13539.html 学习资料的项目笔记

<details>
<summary>代码结构</summary>
<pre><code>.
├── src
│    ├── main
│    │     ├── java 
│    │     │    ├── com.wind.springbootlearn2
│    │     │    │     ├── Springbootlearn2Application springboot启动类 
│    │     │    │     ├── controller  controller包 存放api接口
│    │     │    │     ├── domin  用户与数据库交互的核心中转站，控制用户数据收集，控制请求转向（json格式输出和自定义异常统一处理）
│    │     │    │     ├── entity 实体类
│    │     │    │     ├── filter 过滤器 
│    │     │    │     ├── intecpter 拦截器 
│    │     │    │     ├── listener 监听器
│    │     │    │     ├── servlet 存放servlet，springboot原生servlet开发笔记
│    │     ├── resources
│    │     │    ├── config 存放配置文件application.properties的文件夹
│    │     │    ├── file 存放我学习笔记的文件夹
│    │     │    ├── resources
│    │     │    ├── static
│    │     │    ├── templates
│    │     │    ├── application.properties springboot的配置文件
│    │     │    ├── resource.properties springboot的自定义属性配置文件,配置属性在代码中使用
│    │     │    ├── trigger.txt 热加载触发器，需要在application.properties中配置


</code></pre>
</details>