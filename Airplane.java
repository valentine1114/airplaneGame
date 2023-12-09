import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;

public class Airplane implements Serializable {
	int pX, pY;
	int pWidth = 80, pHeight = 60;
	int speed = 1;
	int oil = 100, life = 100;
	int Xoffset = 0;
	int intervel;
	int count = 0;
	int bulletnum = 100;
	int fireLevel = 1;
	int eplane;
	static Image eplane1;
	static Image eplane2;
	//��ʼ���ɻ����ꡢ��С
	public Airplane(int x, int y) {
		super();
		pX = x;
		pY = y;
	}

	public Airplane() {
		super();
		pX = getRandomIntNum(50, 950);
		pY = 50;
		pWidth = 80;
		pHeight = 60;
		intervel = getRandomIntNum(0, 6);
		eplane = 1;
	}
	//�ӵ�ײ������������
	public boolean hit(Bullet b) {
		if ((pX < b.bX + b.bWidth) && (b.bX < pX + pWidth) && (pY < b.bY + b.bHeight) && (b.bY < pY + pHeight)) {
			life -= 20;
			return true;
		} else
			return false;

	}
	//�ɻ�ײ������������
	public boolean hit(Airplane p) {
		if ((pX < p.pX + p.pWidth) && (p.pX < pX + pWidth) && (pY < p.pY + p.pHeight) && (p.pY < pY + pHeight)) {
			life -= 20;
			p.life -= 20;
			return true;
		} else
			return false;

	}
	//����ײ��������
	public boolean hit(Accessory a) {
		if ((pX < a.aX + a.aWidth) && (a.aX < pX + pWidth) && (pY < a.aY + a.aHeight) && (a.aY < pY + pHeight)) {
			//��Ѫ
			if (a.typeint == 1)
				life += 100;
			//�ӵ�
			if (a.typeint == 2)
				bulletnum += 100;
			//����
			if (a.typeint == 3)
				oil += 100;
			//��С
			if (a.typeint == 4) {
				pWidth *= 0.9;
				pHeight *= 0.9;
			}
			//����
			if (a.typeint == 5) {
				fireLevel += 2;
			}
			//rock��ʧ
			if (a.typeint == 6) {
				for (Rock rock : Battlefield.rockList) {
					if (rock.y > 0) {// ����rock��ʧ
						Battlefield.rockList.remove(rock);
					}
				}
			}
			return true;
		}else
			return false;
	}

	public boolean hit(Rock rock) {
		if ((pX < rock.x + rock.width) && (rock.x < pX + pWidth) && (pY < rock.y + rock.height) && (rock.y < pY + pHeight)) {
			life = -1;
			return true;
		} else
			return false;
	}

	public void fly() {
		count++;
		if (pY % 200 == 0) {
			Xoffset = (getRandomIntNum(0, 3) - 2);
		}
		if (pX < 50)
			Xoffset = 1;
		if (pX > 950)
			Xoffset = -1;
		pX += Xoffset;
		if (count >= intervel) {
			if (pY > 500)
				eplane = 2;
			if (pY < 50)
				eplane = 1;
			if ((pY > 500) || (pY < 50))
				speed = -speed;
			pY += speed;
			count = 0;
		}
	}

	public void moveToTop() {

	}

	public void moveToBottom() {

	}

	public void moveToleft() {

	}

	public void moveToRihgt() {

	}

	public int getRandomIntNum(int a, int b) {
		Random random = new Random();

		int c = random.nextInt();
//�����õ���Random���nextInt()����������������������һ�� int �͵�����
		if (c < 0) {
			c = -c;
		}

		int d = ((c % (b - a)) + a + 1);

//�������ñ���d���a��b֮�е����� % ��ȡ�����㣬������Ķ����Լ���һ�£�

		return d;

	}

}
