import java.awt.*;

public class Ball{

	double xVel, yVel, x, y;

	int life = 3,score=0;

	boolean u=true,d=false,l=false,r=true,gameOver=false,rR=true,lR=false,go=false;

	public Ball(){

		int z = 3;
		x = 445;
		y = 370;
		xVel = -5;
		yVel = 5;

	}

	public void Draw(Graphics g){

		g.setColor(Color.green);
		g.drawOval((int)x,(int)y,50,50);
		g.fillOval((int)x,(int)y,50,50);

		g.setColor(Color.blue);
		g.setFont(new Font("Arial",Font.BOLD,30));
		g.drawString("LIFE: "+life+"                               SCORE: "+score,250,630);
	}

	public void move(){

		if(u==true&&r==true)
		{
			x += xVel;
			y -= yVel;
			if((int)y<10)
			{
				u=false;
				d=true;
			}
			if((int)x>940)
			{
				r=false;
				l=true;
			}
		}

		if(d==true&&r==true)
		{
			x += xVel;
			y += yVel;
			if((int)x>940)
			{
				r=false;
				l=true;
			}

			if((int)y>620)
			{
				d=false;
				u=true;
				life--;

			}


		}

		if(d==true&&l==true)
		{
			x -= xVel;
			y += yVel;
			if((int)y>620)
			{
				d=false;
				u=true;
				life--;
			}
			if((int)x==0)
			{
				l=false;
				r=true;
			}
		}


		if(u==true&&l==true)
		{
			x -= xVel;
			y -= yVel;
			if((int)x==0)
			{
				r=true;
				l=false;
			}
			if((int)y==0)
			{
				d=true;
				u=false;
			}
		}


		if(y < 0)
			yVel = -yVel;
		if(y > 630)
			yVel = -yVel;
		if(x < 0)
			xVel = -xVel;
		if(x > 940)
			xVel = -xVel;

		if(life==0){
			go=true;
		}

	}

	public void check(Striker p){


			if((int)y > 365 && (int)y < 390 && x < p.getX()+170 && x > p.getX()-30	&& d==true&&r==true)
			{
				//xVel = -xVel;
				//yVel = -yVel;
				u = true;
				d = false;
				score++;
			}
			if((int)y > 365 && (int)y < 390 && x < p.getX()+170 && x > p.getX()-30	&& d==true&&l==true)
			{
				//xVel = -xVel;
				//yVel = -yVel;
				u = true;
				d = false;
				score++;
			}







	}

	public int getX(){
			return (int)x;
	}

	public int getY(){
			return (int)y;
	}

}