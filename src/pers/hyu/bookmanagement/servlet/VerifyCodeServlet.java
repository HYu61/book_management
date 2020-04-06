package pers.hyu.bookmanagement.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证码Servlet
 * 
 * @author hyu
 *
 */

public class VerifyCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 初始化属性值
	private int width;
	private int height;
	private int charNum;
	private int charSpace;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VerifyCodeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 获取字符集的字符串
	 * 
	 * @param begin 开始的字符
	 * @param end   结束的字符
	 * @param sb    字符集名称
	 * @return 从begin到end之间字符组成的字符串
	 */
	private StringBuilder getWords(char begin, char end, StringBuilder sb) {
		for (int i = begin; i <= end; i++) {
			sb.append((char) i);
		}
		return sb;
	}

	/**
	 * 从servlet init param 中 获取weiht 和 height 和 要显示的字符数量
	 */
	public void init(ServletConfig config) throws ServletException {
		this.width = Integer.parseInt(config.getInitParameter("width"));
		this.height = Integer.parseInt(config.getInitParameter("height"));
		this.charNum = Integer.parseInt(config.getInitParameter("charNum"));
		this.charSpace = Integer.parseInt(config.getInitParameter("charSpace"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 绘制验证码框体
		BufferedImage bufferedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphic = bufferedImg.getGraphics();
		graphic.setColor(Color.MAGENTA);
		graphic.fillRect(0, 0, width, height);

		// 设置验证码
		// 获取a-z，A-Z，0-9组成的字符串
		StringBuilder sb = new StringBuilder();
		sb = this.getWords('a', 'z', sb);
		sb = this.getWords('A', 'Z', sb);
		sb = this.getWords('0', '9', sb);
		
		String words = sb.toString();

		// 用于存放验证码
		StringBuilder code = new StringBuilder();
		Graphics2D g2d = (Graphics2D) graphic;
		// 根据xml里的charNum设置出现的随机字符
		int space = 10;
		Random random = new Random();
		for (int i = 1; i <= this.charNum; i++) {
			// 随机字符
			char showChar = words.charAt(random.nextInt(words.length()));
			double theta = (random.nextInt(61) - 30) * Math.PI / 180;
			g2d.setColor(Color.BLACK);
			g2d.setFont(new Font("宋体", Font.BOLD, 22));
			g2d.rotate(theta, space, 25);
			g2d.drawString(String.valueOf(showChar), space, 25);
			g2d.rotate(-theta, space, 25);
			// 根据xml初始设置调整字符间距
			space += this.charSpace;

			code.append(showChar);
		}

		// 验证码存入session
		request.getSession().setAttribute("verifyCode", code.toString());
		// 绘制干扰线
		g2d.setColor(Color.BLUE);
		int x1;
		int x2;
		int y1;
		int y2;
		for (int i = 0; i < 20; i++) {
			x1 = random.nextInt(this.width);
			x2 = random.nextInt(22);
			y1 = random.nextInt(this.height);
			y2 = random.nextInt(22);
			g2d.drawLine(x1, y1, x1 + x2, y1 + y2);
		}

		// 显示验证码
		ImageIO.write(bufferedImg, "jpg", response.getOutputStream());
	}

}
