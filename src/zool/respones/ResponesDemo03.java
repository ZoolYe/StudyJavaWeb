package zool.respones;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class ResponesDemo03 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = this.getServletContext().getRealPath("download/桌面.jpg");
        String fileName = path.substring(path.lastIndexOf("\\")+1);

        resp.setHeader("content-disposition","attachment;filename="+fileName);

        InputStream in = null;
        OutputStream os = null;
        in = new FileInputStream(path);
        int len = 0;
        byte buffer[] = new byte[1024];
        os = resp.getOutputStream();
        while((len = in.read(buffer))>0){
            os.write(buffer,0,len);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
