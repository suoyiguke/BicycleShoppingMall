package com.yinkai.interceptor;

import com.yinkai.utils.FastJsonUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 全局文件类型拦截器
 */
public class FileTypeInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;
        //是jsp的请求，返回逻辑视图

        // 判断是否为文件上传请求
        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Map<String, MultipartFile> files = multipartRequest.getFileMap();
            Iterator<String> iterator = files.keySet().iterator();
            //对多部件请求资源进行遍历
            while (iterator.hasNext()) {
                String formKey = (String) iterator.next();
                MultipartFile multipartFile = multipartRequest.getFile(formKey);
                String filename = multipartFile.getOriginalFilename();
                //判断是否为限制文件类型
                if (!checkFile(filename)) {
                    if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
                         //判断是谁发出的请求，如果是jsp则返回错误页面
                        request.setAttribute("message", "文件上传失败：不支持的文件类型！");
                        request.getRequestDispatcher("/WEB-INF/page/error/exception.jsp").forward(request, response);
                        flag = false;
                    } else {
                        //是微信小程序，则放回json的错误消息
                        Map messgae = new HashMap<String, String>();
                        messgae.put("state", "0");
                        messgae.put("message", "添加新用户失败！");
                        response.setContentType("application/json;charset=UTF-8");
                        response.getWriter().println(FastJsonUtils.toJSONString(messgae));

                        flag = false;
                    }
                }
            }
        }

        return flag;
    }

    /**
     * 判断是否为允许的上传文件类型,true表示允许
     */
    private boolean checkFile(String fileName) {
        //设置允许上传文件类型
        String suffixList = "jpg,gif,png,ico,bmp,jpeg";
        // 获取文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        if (suffixList.contains(suffix.trim().toLowerCase())) {
            return true;
        }
        return false;
    }
}