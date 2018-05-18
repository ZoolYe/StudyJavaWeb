package zool.form;

import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class FormServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*产生随机数*/
        String token = TokenProcessor.getInstance().generateToken();

        req.getSession().setAttribute("token",token);

        req.getRequestDispatcher("/form.jsp").forward(req,resp);

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}

/*获取令牌*/
class TokenProcessor{
    private TokenProcessor() {}
    private static final TokenProcessor instance = new TokenProcessor();
    public static TokenProcessor getInstance(){
        return instance;
    }

    public String generateToken(){
        /*获取随机数*/
        String token = System.currentTimeMillis() + new Random().nextInt()+"";
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte md5[] = digest.digest(token.getBytes());
            /*base64编码*/
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}