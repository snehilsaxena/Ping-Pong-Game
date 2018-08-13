import java.awt.*;
import java.awt.event.*;

class Pong_new extends Canvas implements Runnable,KeyListener{

	static final int w = 1000 , h = 700 ;
	Thread thread;
	Striker p1;
	Ball b1;
	static Frame f;
	boolean start = false;

	public static void main(String s[])
	{
		f = new Frame("PING-PONG");
		f.setSize(w,h);
		f.setBackground(Color.black);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}
		});

		Pong_new p = new Pong_new();
		f.add(p);
		f.addKeyListener(p);
		p.init();
		f.setVisible(true);
		f.setResizable(false);
	}

	public void init(){

		//this.resize(w,h);
		//this.addKeyListener(this);
		p1 = new Striker();
		b1 = new Ball();
		thread = new Thread(this);
		thread.start();
	}

	public void paint(Graphics g){


		super.paint(g);
		if(b1.go){
			p1.draw(g);
			b1.Draw(g);
			g.setColor(Color.white);
			g.setFont(new Font("Arial",Font.BOLD,100));
			g.drawString("GAME OVER",200,250);
			g.setColor(Color.green);
			g.setFont(new Font("Arial",Font.BOLD,60));
			g.drawString("Your Score is: "+ b1.score,270,350);
		}

		if(!start){
			g.setColor(Color.yellow);
			g.setFont(new Font("Arial",Font.BOLD,50));
			g.drawString("Press Enter to Start Game",190,350);
			g.setColor(Color.red);
			g.setFont(new Font("Arial",1,40));
			g.drawString("Use A : Left and K : Right",230,610);
		}

		if(start){
			p1.draw(g);
			b1.Draw(g);
		}


	}

	public void update(Graphics g){
		paint(g);
	}

	public void run(){

		while(!b1.go)
		{
			if(start){
				p1.move();
				b1.check(p1);
				b1.move();
			}



			repaint();

			try
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e)
	      	{}

		}
	}

	public void keyPressed(KeyEvent evt) {

		if(evt.getKeyCode()==KeyEvent.VK_K)
		{
			p1.setRyt(true);
		}
		else if(evt.getKeyCode()==KeyEvent.VK_A)
		{
			p1.setLft(true);
		}
		else if(evt.getKeyCode()==KeyEvent.VK_ENTER)
		{
			start = true;
		}
	}

	public void keyReleased(KeyEvent evt) {

		if(evt.getKeyCode()==KeyEvent.VK_K)
		{
			p1.setRyt(false);
		}
		if(evt.getKeyCode()==KeyEvent.VK_A)
		{
			p1.setLft(false);
		}
		if(evt.getKeyCode()==KeyEvent.VK_ENTER)
		{
			start = true;
		}
	}

	public void keyTyped(KeyEvent ke){}

}