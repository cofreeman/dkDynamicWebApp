package core;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String content = req.getParameter("content");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();

        writer.printf("<h2> %s 님이 %d 년 %d 월 %d일에 남긴 글입니다.</h2><hr>", name, year, month, day);
        writer.printf(content);
        writer.printf("<hr>");
        writer.print("<a href='"+req.getHeader("referer")+"'>입력화면으로 가기</a>");
        writer.close();

    }
}
