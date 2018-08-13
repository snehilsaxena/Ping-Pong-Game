import java.awt.*;
//import java.awt.Graphics;

public class Striker {//implements Paddle{

	double x, xVel, GRAV = 0.94 ;
	boolean ryt,lft;
	int player,y;

	public Striker(){

		ryt = false; lft = false;
		y = 420 ; xVel = 0; x = 380 ;
	}


	public void draw(Graphics g){

		g.setColor(Color.red);
		//g.drawRect((int)x,y,180,25);
		g.fillRect((int)x,y,180,25);

	}

	public void setRyt(boolean in){
		ryt = in ;
	}

	public void setLft(boolean in){
		lft = in ;
	}

	public void move(){

		if(ryt){
			xVel += 1 ;
		}
		else if(lft){
			xVel -= 1 ;
		}
		else if(!lft && !ryt){
			xVel *= GRAV ;
		}

		if(xVel >= 8)
			xVel = 8;
		else if(xVel <= -8)
			xVel = -8;

		x += xVel ;

		if(x<=0)
			x = 0;
		else if(x>=810)
			x = 810;
	}

	public int getX(){
		return (int)x;
	}

}