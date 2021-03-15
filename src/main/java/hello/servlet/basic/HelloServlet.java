package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // request, response 객체가 생성된다.
        // WAS 서버들이 서블릿 표준 스펙을 구현한다.

        String username = request.getParameter("username");
        System.out.println("username = " + username);
        // 쿼리파라미터 출력 가능

        String pwd = request.getParameter("pwd");
        System.out.println("pwd = " + pwd);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8"); // 두 줄은 contentType 에 들어간다.
        response.getWriter().write("hello " + username);

        // 우리가 http 스펙을 직접 개발해서 쓰려면 엄청 복작하다.
        // 하지만 서블릿을 이용해서 자주쓰는 기능들을 쉽게 쓸 수 있다.
    }
}
