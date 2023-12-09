import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;

public class Accessory implements Serializable {
	int aX, aY;
	int aWidth = 50, aHeight = 50;
	int speed = 1;
	int typeint;
	int life = 50;
	int Xoffset = 0;
	int intervel;
	int count = 0;
	int aimage;
	static Image aimage1, aimage2, aimage3, aimage4, aimage5, aimage6;
	//��ʼ�������ꡢ��С���������
	public Accessory() {
		aX = getRandomIntNum(50, 950);
		aY = 30;
		typeint = getRandomIntNum(0, 6);
		if (typeint == 1)
			aimage = 1;
		if (typeint == 2)
			aimage = 2;
		if (typeint == 3)
			aimage = 3;
		if (typeint == 4)
			aimage = 4;
		if (typeint == 5)
			aimage = 5;
		if (typeint == 6)
			aimage = 6;
	}

	public boolean hit(Airplane p) {
		if ((aX < p.pX + p.pWidth) && (p.pX < aX + aWidth) && (aY < p.pY + p.pHeight) && (p.pY < aY + aHeight)) {
			life -= 30;
			p.life -= 30;
			return true;
		} else
			return false;

	}

	public int getRandomIntNum(int a, int b) {
		Random random = new Random();
		int c = random.nextInt();
//	�����õ���Random���nextInt()����������������������һ�� int �͵�����
		if (c < 0) {
			c = -c;
		}
		int d = ((c % (b - a)) + a + 1);
//	�������ñ���d���a��b֮�е����� % ��ȡ�����㣬������Ķ����Լ���һ�£�
		return d;

	}
}
