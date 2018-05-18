package zj.extend;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 自定义spring view
 */
@Component
public class CustomSpringView extends AbstractView {

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type","application/json;charset=UTF-8");
        response.getOutputStream().write("custom spring view".getBytes("utf-8"));
    }


}