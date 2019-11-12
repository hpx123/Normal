package com.hc.servlet;

import com.hc.pojo.User;
import com.hc.service.UserService;
import com.hc.service.impl.UserServiceImpl;
import org.w3c.dom.ls.LSOutput;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet("/users")

public class UserServlet extends HttpServlet {
    //调用service层的接口
    UserService us = new UserServiceImpl();
    //user对象
    User user = null;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取方法名称
        String mName = req.getParameter("method");

        try {
            //获取方法对象
            Method method = this.getClass().getMethod(mName, HttpServletRequest.class, HttpServletResponse.class);

            //执行该方法并接受该方法的返回值
            String path = (String) method.invoke(this, req, resp);

            //判断该返回值是否为空
            if(path != null){
                req.getRequestDispatcher(path).forward(req, resp);
            }

        } catch (NoSuchMethodException  | InvocationTargetException  | IllegalAccessException e) {
            throw new RuntimeException("您要调用的方法：" + mName + "它不存在！", e);
        }

    }

    //注册头像
    private void updatePhoto(HttpServletRequest request, HttpServletResponse response) {
//        DiskFileItemFactory factory=new DiskFileItemFactory();
//        ServletFileUpload upload=new ServletFileUpload(factory);
//        String user = null;
//        String path = null;
//        //设置缓冲区大小与临时文件目录
//        factory.setSizeThreshold(1024*1024*10);
//        File uploadTemp=new File("e:\\uploadTemp");
//        uploadTemp.mkdirs();
          //指定临时目录
//        factory.setRepository(uploadTemp);
//        //设置单个文件大小限制
//        upload.setFileSizeMax(1024*1024*10);
//        //设置所有文件总和大小限制
//        upload.setSizeMax(1024*1024*30);
//            try {
//                List<FileItem> list=upload.parseRequest(request);
//                System.out.println(list);
//                for (FileItem fileItem:list){
//                    if (!fileItem.isFormField()&&fileItem.getName()!=null&&!"".equals(fileItem.getName())){
//                        String filName=fileItem.getName();
//                        //利用UUID生成伪随机字符串，作为文件名避免重复
//                        String uuid= UUID.randomUUID().toString();
//                        //获取文件后缀名
//                        String suffix=filName.substring(filName.lastIndexOf("."));
//                        //获取文件上传目录路径，在项目部署路径下的upload目录里。若想让浏览器不能直接访问到图片，可以放在WEB-INF下
//                        String uploadPath=request.getSession().getServletContext().getRealPath("/web/userimage");
//                        File file=new File(uploadPath);
//                        file.mkdirs();
//                        //写入文件到磁盘，该行执行完毕后，若有该临时文件，将会自动删除
//                        fileItem.write(new File(uploadPath,uuid+suffix));
//                        path = "http://localhost:8080"+request.getContextPath()+"/web/userimage/"+uuid+suffix;
//                        System.out.println(path);
//                        request.getServletContext().setAttribute("path",path);
//                    }
//                }
//
//            }  catch (Exception e) {
//                e.printStackTrace();
//            }
    }

    //注册
    private void submitUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        user = new User();
        String uname = req.getParameter("subnam");
        String pwd = req.getParameter("subpwd");
        String telenum = req.getParameter("subtel");
        String sex = req.getParameter("subsex");
        String birth = req.getParameter("subbir");
        us.submitUserService(uname, pwd, telenum, sex, birth);
        resp.sendRedirect("login.jsp");

    }

    //登陆
    public void loginUser(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        user = new User();
        us = new UserServiceImpl();
        String name = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        user = us.checkLoginService(name, pwd);
        if(user != null){
            String userName = user.getUname();
            HttpSession hs = req.getSession();
            hs.setAttribute("userName", userName);
            resp.sendRedirect("main.jsp");
        }else {
            req.setAttribute("flag", "1");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

}
