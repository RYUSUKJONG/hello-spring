package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "Spring!!");
        return "hello";
    }


    @GetMapping("hello-mvc")   //MVC 파라미터 이용하여 name 전달
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }


    @GetMapping("hello-string")
    @ResponseBody         //html 태그 없이 문자가 그대로 화면에 출력됨
    public String helloString(@RequestParam("name") String name){
        return "hello "+name;   //name=spring -->> "hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody
    public  Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello(); //Hello 객체 생성
        hello.setName(name);
        
        return hello; //객체를 반환
    }


    static class Hello{

        //getter and setter 
        private String name;

        public String getName() {  //꺼낼 때
            return name;
        }

        public void setName(String name) { //넣을 때
            this.name = name;
        }
    }

}



















