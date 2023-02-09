package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {

    /**
     *
     * @parmam paramMap
     * @parmam model
     * @return viewName
     */
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
