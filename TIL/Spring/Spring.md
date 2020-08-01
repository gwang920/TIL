



```
Model 1
 
 Container : JSP(Controller + View)


Model 2

 Container : Servlet(Controller) + JSP(VIEW) + JavaBeans(Model)
 
Spring MVC
  
  Container : DispatcherServlet + HandlerMapping + Controoler + ViewResolver + View + 				  ModelAndView

```





filter 필요한 언어타입을 처리할 수 있다



spring add  / maven convert

pom.xml 수정

lib 추가 (ojdbc6_g.jar)

web.xml  (Spring Dispatcher/ Encoding Filter 추가 )

spring.xml 추가 (annotation ,,etc)



모든 jsp는 view 에서 관리하자





jsp 와 controller만 개발하면된다



```
welcome.txt = Welcome {0} {1}
register.txt = Register OK {0}
item.list=Item List

```



