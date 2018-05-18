package zool.respones;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ResponesDemo04 extends HttpServlet {

    public static final int WIDTH = 120;
    public static final int HEIGHT = 25;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*初始化一个图片，指定高宽和类型*/
        BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        /*得到一副图形*/
        Graphics graphics = image.getGraphics();

        /*设置背景色*/
        setBackGround(graphics);
        /*设置边框*/
        setBorder(graphics);
        /*画干扰线*/
        drawRandomLine(graphics);
        /*写随机数*/
        drawRandomNum(graphics);

        resp.setContentType("image/jpeg");

        /*图形写给浏览器*/
        ImageIO.write(image,"jpg",resp.getOutputStream());

    }

    private void drawRandomNum(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("微软雅黑",Font.BOLD,20));

        /*[\u4e00-\u9fa5]*/
        /*for(int i=0;i<4;i++){

        }*/

        graphics.drawString("你好Java",10,20);

    }

    private void drawRandomLine(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        for(int i=0;i<10;i++){
            int x1 = new Random().nextInt(WIDTH);
            int y1 = new Random().nextInt(HEIGHT);

            int x2 = new Random().nextInt(WIDTH);
            int y2 = new Random().nextInt(HEIGHT);

            graphics.drawLine(x1,y1,x2,y2);

        }
    }

    private void setBorder(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.drawRect(1,1,WIDTH-2,HEIGHT-2);
    }

    private void setBackGround(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(0,0,WIDTH,HEIGHT);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
