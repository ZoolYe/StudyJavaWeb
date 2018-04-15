package zool.servlet;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo04 extends HttpServlet implements SingleThreadModel {

    int i = 0;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            i++;
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        response.getOutputStream().write((i+"").getBytes());

    }
}
