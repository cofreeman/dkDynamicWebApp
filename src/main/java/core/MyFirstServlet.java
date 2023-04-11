package core;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Objects;

@WebServlet("/myfirst")
public class MyFirstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if(Objects.isNull(name))name = "GUEST";
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        LocalDate now = LocalDate.now();
        String korDay = now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN);
        out.printf("<h2> %s 님 반가워요.. 오늘은 %s입니다!!</h2>", name, korDay);
        out.close();
    }
}
