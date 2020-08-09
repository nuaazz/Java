<center>JavaWeb</center>



# 1.基本概念

## 1.1 前沿

web开发：

+ web，网页的意思
+ 静态web
  + html，css
  + 提供给所有人看的数据始终不会发生变化
+ 动态web
  + 淘宝
  + 每个人不同时间不同地点看到的信息各不相同
  + 技术栈：Servlet/ISP ASP PHP

在Java中，动态web资源开发的技术统称为JavaWeb

## 1.2 web应用程序

web应用程序，可以提供浏览器访问的程序

+ a.html  b.html……多个web资源，这些web可以被外界访问，对外界提供服务
+ 能访问到的任意一个页面或者资源，都存在于某个计算机上
+ URL
+ 这个统一的web资源会被放在同一个文件夹下，web应用程序->Tomcat：服务器
+ 一个web应用由多部分组成（静态web，动态web）
  + html css js
  + jsp servlet
  + Java
  + jar包
  + 配置文件(Properties)

web应用程序编写完毕后，若想提供给外界访问，需要一个服务器统一管理

## 1.3 静态web

+ *.htm *.html都是网页的后缀，如果服务器上一直存在这些东西，就可以直接进行读取，通信

  ![image-20200809121556239](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200809121556239.png)

+ 静态web存在的缺点
  + Web页面无法动态更新，所有用户看到的都是同一个页面
    + 轮播图 点击特效：伪动态
    + JavaScript（实际开发最常用）
    + VBScript
  + 无法与数据库交互（数据无法持久化，用户无法交互）

## 1.4 动态web

页面会动态显示，Web的页面显示效果因人而异

![image-20200809122247493](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200809122247493.png)

缺点

+ 假如服务器的动态web资源出现了错误，需要重写后台程序，重新发布
  + 停机维护

优点

静态web存在的缺点

+ Web页面可以动态更新，所有用户看到的不是同一个页面
+ 可以与数据库交互

![image-20200809122508599](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200809122508599.png)

# 2 Web服务器

## 2.1 技术讲解

ASP

+ 微软：国内最早流行的就是ASP
+ 在HTML中嵌入了VB的脚本，ASP+COM；
+ 在ASP开发中，基本上每一个页面都有几千行的业务代码，页面及其混乱
+ 维护成本高

php

+ PHP开发速度很快，功能强大，跨平台，代码简单
+ 无法承载大访问量的情况（局限性）

JSP/Servlet

+ SUN公司主推的B/S架构
+ 基于Java语言
+ 可以承载三高问题带来的影响
+ 语法像ASP

## 2.2 Web服务器

服务器是一种被动的操作，用来处理用户的一些请求，给用户相应信息

IIS：微软，ASP Windows中自带的

Tomcat：Tomcat是Apache 软件基金会（Apache Software Foundation）的Jakarta 项目中的一个核心项目，最新的Servlet 和JSP 规范总是能在Tomcat 中得到体现。因为Tomcat 技术先进、性能稳定，而且免费，因而深受Java 爱好者的喜爱并得到了部分软件开发商的认可，成为目前比较流行的Web 应用服务器。

Tomcat 服务器是一个免费的开放源代码的Web 应用服务器，属于轻量级应用[服务器](https://baike.baidu.com/item/服务器)，在中小型系统和并发访问用户不是很多的场合下被普遍使用，是开发和调试JSP 程序的首选。对于一个初学JavaWeb的人来说，它是最佳选择

Tomcat 实际上运行JSP 页面和Servlet。目前Tomcat最新版本为9.0.37。

下载tomcat：

1. 安装/解压
2. 了解配置文件及目录结构
3. 了解作用 

# 3 Tomcat

## 3.1 安装Tomcat

https://tomcat.apache.org/

## 3.2 启动和配置

文件夹：

![image-20200809124449786](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200809124449786.png)

启动，关闭Tomcat

bin>startup.bat  / shutdown.bat

访问测试： http://localhost:8080/

## 3.3 配置

![image-20200809124850256](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200809124850256.png)

可以配置启动的端口号

+ Tomcat的默认端口号：8080
+ MySQL：3306
+ http：80
+ https：443

```xml
   <Connector port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />

```

可以配置主机的名称

+ 默认的主机名：localhost ->127.0.0.1
+ 默认的网站应用存放的位置：webapps

```xml
  <Host name="localhost"  appBase="webapps"
        unpackWARs="true" autoDeploy="true">
```
**面试题**

访问网页流程：

1. 输入域名
2. 检查本机的hosts配置文件下有没有这个域名映射
   1. 有，直接放回对应的ip地址，在这个地址中，有需要访问的web程序，可以直接访问
   2. 没有：去DNS解析![image-20200809130140793](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200809130140793.png)

## 3.4 发布web网站

+ 将自己写的网站放到服务器（Tomcat）中指定的web应用文件夹（webapps）下

网站应有的结构

```java
-- webapps :Tomcat服务器的web目录
	-ROOT
	-zz:网站的目录名
		- WEB—INF
			-classes:Java程序
			-lib web应用所依赖的jar包
			-web.xml
		-index.html 默认首页
		- static
			-css
				-style.css
			-js 
			-img
		-...
```

# 4.Http

## 4.1什么是http

http（超文本传输协议）是一个简单的请求-响应协议，它通常运行在TCP之上。

+ 文本：html，字符串，……
+ 超文本：图片，音乐，视频，地图，定位……
+ 端口 80

https：s---安全的

+ 443

## 4.2 两个时代

+ Http1.0

  + HTTP/1.0:客户端可以与web服务器连接后，只能获得一个web资源
+ Http2.0
+ HTTP/1.1：客户端可以与web服务器连接后，可以获得多个web资源

## 4.3  Http请求

+ 客户端--发请求--服务器

百度

```java
Request URL:https://www.baidu.com/   请求地址
Request Method:GET    get方法/post方法
Status Code:200 OK    状态码：200
Remote（远程） Address:14.215.177.39:443
    
Accept:text/html  
Accept-Encoding:gzip, deflate, br
Accept-Language:zh-CN,zh;q=0.9    语言
Cache-Control:max-age=0
Connection:keep-alive
```

1. 请求行

- 请求行中的请求方式：GET
- 请求方式：**Get,Post**,HEAD,DELETE,PUT,TRACT.…
  - get：请求能够携带的参数比较少，大小有限制，会在浏览器的URL地址栏显示数据内容，不安全，但高效
  - post:请求能够携带的参数没有限制，大小没有限制，不会在浏览器的URL地址栏显示数据内容，安全，但不高效。

2. 消息头

```java
Accept：告诉浏览器，它所支持的数据类型
Accept-Encoding：支持哪种编码格式  GBK   UTF-8   GB2312  ISO8859-1
Accept-Language：告诉浏览器，它的语言环境
Cache-Control：缓存控制
Connection：告诉浏览器，请求完成是断开还是保持连接
HOST：主机..../.
```



## 4.4  Http响应

+ 服务器--响应--客户端

百度

```java
Cache-Control:private    缓存控制
Connection:Keep-Alive    连接
Content-Encoding:gzip    编码
Content-Type:text/html   类型  
```

1. 响应体

```java
Accept：告诉浏览器，它所支持的数据类型
Accept-Encoding：支持哪种编码格式  GBK   UTF-8   GB2312  ISO8859-1
Accept-Language：告诉浏览器，它的语言环境
Cache-Control：缓存控制
Connection：告诉浏览器，请求完成是断开还是保持连接
HOST：主机..../.
Refresh:告诉客户端多久刷新一次
Location：让网页重新定位
```

2. 响应状态码

200：请求响应成功200

3xx:请求重定向
+ 重定向：你重新到我给你新位置去；

4xx:找不到资源404

+ 资源不存在；

5xx:服务器代码错误 500  502:网关错误

常见面试题：

当浏览器中地址栏输入地址并回车到页面展示，经历了什么？

# 5 Maven

为什么学习Maven？

1. 在JavaWeb开发中，需要使用大量的的jar包，需要手动导入
2. 如何自动导入和配置jar包？Maven

## 5.1 Maven项目架构管理工具

目的：方便导入jar包

Maven核心思想：**约定大于配置**

+ 有约束，不要去违反

Maven会规定要如何去编写Java代码，必需按规范来。

## 5.2 下载安装Maven

官网：https://maven.apache.org/

## 5.3配置环境变量

- M2_HOME maven目录下的bin目录
- MAVEN_HOME maven的目录
- 在系统的path中配置%MAVEN_HOME%\bin

## 5.4 阿里云镜像

- 镜像：mirrors
- 作用：加速我们的下载
- 国内建议使用阿里云的镜像

```xml
<mirror>
    <id>nexus-aliyun</id>  
    <mirrorOf>*,!jeecg,!jeecg-snapshots</mirrorOf>  
    <name>Nexus aliyun</name>  
    <url>http://maven.aliyun.com/nexus/content/groups/public</url> 
</mirror>
```

## 5.5 本地仓库

在本地的仓库，远程仓库； 建立一个本地仓库：localRepository

```xml
<localRepository>D:\apache-maven-3.6.1\maven-repo</localRepository>
```

## 5.6 在IDEA中使用Maven

1. 启动IDEA
2. 创建Maven项目

![image-20200809153034942](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200809153034942.png)

![image-20200809153118301](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200809153118301.png)

![image-20200809153128090](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200809153128090.png)

3. 自动导入包

![image-20200809153339551](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200809153339551.png)

4. 观察Maven仓库多了什么东西？
5. IDEA中的Maven设置![image-20200809153652721](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200809153652721.png)

注意：项目创建完成后，IDEA有时候会选择默认的Maven，要切换成本地的

6. 到这里，Maven在IDEA中的配置和使用就OK了。

## 5.7 创建空的Maven项目

## 5.8 标记文件夹功能

![image-20200809154810436](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200809154810436.png)

![image-20200809154954627](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200809154954627.png)

## 5.9 在IDEA中配置Tomcat

![image-20200809155432217](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200809155432217.png)

![image-20200809155504072](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200809155504072.png)


![image-20200809155955019](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200809155955019.png)

![image-20200809160017505](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200809160017505.png)

点击启动

![image-20200809160246508](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200809160246508.png)


## 5.10 pom文件
pom.xml是Maven的核心配置文件
![image-20200809160632461](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200809160632461.png)



maven由于约定大于配置，之后可能遇到写的配置文件无法被导出或者生效的问题，

```xml
    <build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <excludes>
                    <exclude>**/*.properties</exclude>
                    <exclude>**/*.xml</exclude>
                </excludes>
                <filtering>false</filtering>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
        </resources>
    </build>
```

# 6 Servlet

6.1 Servlet简介

+ Servlet就是sun公司开发动态web的一门技术
+ Sun在这些API中提供了一个接口叫Servlet，如果想开发Servlet，只需要
  + 编写类，实现Servlet接口
  + 把开发好的java类部署到web服务器中

**把实现了Servlet接口的Java程序叫做Servlet**

## 6.2 HelloServlet

Servlet接口有两个默认的实现类，HttpServlet，GenericServlet

1. 创建普通Maven项目，删除src，在里面建立Module

2. 关于Maven父子工程的理解：

   1. 父项目中会有

      ```xml
          <modules>
              <module>servlet-01</module>
          </modules>
      ```

   2. 子项目里会有

      ```xml
          <parent>
              <artifactId>javaweb-02-servlet</artifactId>
              <groupId>com.zz</groupId>
              <version>1.0-SNAPSHOT</version>
          </parent>
      ```

3. Maven环境优化

   1. 修改web.xml为最新的

      ```xml
      <?xml version="1.0" encoding="UTF-8"?>
      <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
               xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
      http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
               version="4.0"
               metadata-complete="true">
      </web-app>
      ```

      

   2. 将Maven的结构搭建完整

4. 编写一个Servlet程序

   1. 编写一个普通类
   2. 实现Servlet接口，继承HttpServlet


```java
public class HelloServlet extends HttpServlet {

    //由于get和post只是请求实现的不同方式，可以相互调用
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //ServletOutputStream outputStream = resp.getOutputStream();
        PrintWriter writer = resp.getWriter();//响应流
        writer.println("hello world");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
```
5. 编写Servlet映射

   为什么需要映射？写的是Java程序，但是要通过浏览器访问，浏览器需要连接web服务器，所以需要在web服务器中注册Servlet，还需给它一个浏览器能够访问的路径

   ```xml
       <!--注册servlet-->
       <servlet>
           <servlet-name>hello</servlet-name>
           <servlet-class>com.zz.servlet.HelloServlet</servlet-class>
       </servlet>
       <!--请求路径-->
       <servlet-mapping>
           <servlet-name>hello</servlet-name>
           <url-pattern>/hello</url-pattern>
       </servlet-mapping>
   ```

6. 配置Tomcat

7. 启动测试

## 6.3 Servlet原理

Servlet是由Web服务器调用，web服务器在收到浏览器请求之后，会：

![image-20200809211518115](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200809211518115.png)

## 6.4 Mapping

1. 一个Servlet可以指定一个映射路径

   ```xml
         <servlet-mapping>
             <servlet-name>hello</servlet-name>
             <url-pattern>/hello</url-pattern>
         </servlet-mapping>
   ```

   

2. 一个Servlet可以指定多个映射路径

   ```xml
         <servlet-mapping>
             <servlet-name>hello</servlet-name>
             <url-pattern>/hello</url-pattern>
         </servlet-mapping>
         <servlet-mapping>
             <servlet-name>hello</servlet-name>
             <url-pattern>/hello2</url-pattern>
         </servlet-mapping>
         <servlet-mapping>
             <servlet-name>hello</servlet-name>
             <url-pattern>/hello3</url-pattern>
         </servlet-mapping>
         <servlet-mapping>
             <servlet-name>hello</servlet-name>
             <url-pattern>/hello4</url-pattern>
         </servlet-mapping>
         <servlet-mapping>
             <servlet-name>hello</servlet-name>
             <url-pattern>/hello5</url-pattern>
         </servlet-mapping>
   ```

3. 一个Servlet可以指定通用映射路径

   ```xml
         <servlet-mapping>
             <servlet-name>hello</servlet-name>
             <url-pattern>/hello/*</url-pattern>
         </servlet-mapping>
   ```

4. 默认请求

   ```xml
          <!--默认请求路径-->
          <servlet-mapping>
              <servlet-name>hello</servlet-name>
              <url-pattern>/*</url-pattern>
          </servlet-mapping>
   ```

   

5. 指定一些后缀或者前缀

   ```xml
     <!--可以自定义后缀实现请求映射
         注意点，*前面不能加项目映射的路径
         hello/sajdlkajda.qinjiang
         -->
     <servlet-mapping>
         <servlet-name>hello</servlet-name>
         <url-pattern>*.qinjiang</url-pattern>
     </servlet-mapping>
   ```

6. 优先级问题：

   指定了固有的映射路径优先级最高，如果找不到就会走默认的处理请求

   ```xml
       <!--注册servlet-->
       <servlet>
           <servlet-name>error</servlet-name>
           <servlet-class>com.zz.servlet.ErrorServlet</servlet-class>
       </servlet>
       <!--请求路径-->
       <servlet-mapping>
           <servlet-name>error</servlet-name>
           <url-pattern>/*</url-pattern>
       </servlet-mapping>
   
   ```

   

## 6.5 ServletContext

web容器在启动的时候，它会为每个web程序都创建一个对应的ServletContext对象，它代表了当前的web应用；

+ 共享数据

  我再这个Servlet中保存的数据，可以在另一个servlet中拿到

  放数据：

  ```java
  public class HelloServlet extends HttpServlet {
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
          //this.getInitParameter();
          //this.getServletConfig();
          ServletContext servletContext = this.getServletContext();
          String name = "zz";
          servletContext.setAttribute("username",name);//将数据保存在context中，名字为username，值为“zz”
          System.out.println("hello");
      }
  
  
  }
  
  ```

  读数据

  ```java
  public class GetServlet extends HttpServlet {
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          ServletContext servletContext = this.getServletContext();
          String username = (String)servletContext.getAttribute("username");
          resp.setContentType("text/html");
          resp.setCharacterEncoding("utf-8");
          PrintWriter writer = resp.getWriter();
          writer.println("姓名："+ username);
      }
  
      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          doGet(req, resp);
      }
  }
  ```

  