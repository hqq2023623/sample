package zj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import zj.extend.CustomSpringView;

/**
 * @author lzj
 * @date 2018/4/27
 */
@Controller
@RequestMapping("/zj/hello")
public class HelloController {

    @RequestMapping
    @ResponseBody
    public Object a() {
        return "hello";
    }

    @RequestMapping("/custom")
    public Object custom() {
        return new CustomSpringView();
    }


}
