import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class pintu{
	public static void main(String args[]){
		FWindow fwin = new FWindow();
        //定义一个实例fwin,入口~
	}
}

class FWindow extends JFrame implements ActionListener{
	JButton jbsimple,jbmiddle,jbhigh,jbabnormal;
    JButton music;	
    //定义简单，中级、困难、变态四个按钮选择难度
	FWindow(){
		setBounds(500,200,400,600);
		setLayout(null);
		setVisible(true);
		jbsimple = new JButton("简单");
		jbmiddle = new JButton("一般");
		jbhigh = new JButton("困难");
		jbabnormal = new JButton("变态");
        music = new JButton("音乐");
		//JButton定义按钮


		jbsimple.setBounds(150,100,100,50);
		jbmiddle.setBounds(150,200,100,50);
		jbhigh.setBounds(150,300,100,50);
		jbabnormal.setBounds(150,400,100,50);
        music.setBounds(100,500,200,50);
        //setBounds设置按钮的大小和位置

		jbsimple.addActionListener(this);
		jbmiddle.addActionListener(this);
		jbhigh.addActionListener(this);
		jbabnormal.addActionListener(this);
        music.addActionListener(this);	
		//就是给前面的实例（按钮等）添加事件监听接口，
        //this表示当前类的对象，在一个类里，你不需要new他的实例就直接可以用this调用它的方法和属性

		add(jbsimple);
		add(jbmiddle);
		add(jbhigh);
		add(jbabnormal);
		add(music);
		
		validate();     
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
    //使用传入的get方法来判断，创建实例，添加点击事件
	public void actionPerformed(ActionEvent e){
		if (e.getSource()==jbsimple){
			SimWindow simwin = new SimWindow();
			dispose();
		}else if(e.getSource()==jbmiddle){
			MidWindow midwin = new MidWindow();
			dispose();
		}else if(e.getSource()==jbhigh){
			HigWindow midwin = new HigWindow();
			dispose();
		}else if(e.getSource()==jbabnormal){
			AbnWindow midwin = new AbnWindow();
			dispose();
		}else{
            SoundsWindow midwin = new SoundsWindow();
            dispose();
        }
	}
}

class MyJButton extends JButton{
    //MyButton():构造函数，设置原始坐标xy；
	public int xy;
	public int nxy;
	public String picc;
	public ImageIcon iconn;
	
	MyJButton(int i){
		//定义构造函数,设置初始坐标xy
		xy=i;
	}
	
	public int getxy(){
        //返回初始坐标
		return xy;
	}
	public void pic(String iccon){
        //对按钮对象进行贴图
		iconn = new ImageIcon(iccon);
		setIcon(iconn);
		picc = iccon;
	}
	public void setnxy(int i){
        //- Setnxy():设置现在的坐标，该坐标 随按钮位置的变化而变化
		nxy=i;
		
	}
	public int getnxy(){
        //Getnxy():返回nxy
		return nxy;
	}
	
	public String reicon(){
        //-Reicon():返回该按钮上的贴图
		return picc;
	}
}


class SoundsWindow extends JFrame implements ActionListener{
    //定义音乐music
    JButton shenyin; 
    //定义声音的按钮
    MyJButton b[];
    //存放数组
    JLabel lab1;  //swing中的JLabel 
    int num=1;
    Timer time;   //定义时间组件进行记录时间
    JButton bstart,returns,zt;    //定义开始和返回 
    SoundsWindow(){
        //构造方法
        System.out.println("此时的音乐开始播放");
        System.out.println("这是您的第一首歌曲,亲爱的vip客户");
        setBounds(500,200,500,650);
       //分别对应的是Bounds的x,y,宽度和高度
       setVisible(true);
       
       time = new Timer(1000,this);
       //设定时间限制以秒为基本单位，可以设置为毫秒
       
       JPanel jpa = new JPanel();
       add(jpa);
       jpa.setBounds(0,0,500,45);
       jpa.setLayout(null);
       lab1 = new JLabel();
      
       lab1.setHorizontalAlignment(JLabel.CENTER);
       lab1.setFont(new Font("宋体",Font.BOLD,20));
       bstart = new JButton("开始");
       //这个vip的目的是为了给充值的人一些外挂，能够强行移动位置
       zt = new JButton("暂停播放");
       returns = new JButton("返回");
       bstart.setBounds(50,5,100,40);   //开始
       zt.setBounds(200,5,100,40);      //暂停音乐
       returns.setBounds(360,5,100,40);   //结束
       lab1.setText("您享受我们的VIP待遇:VIP无损音乐");
       jpa.add(bstart);
       jpa.add(lab1);
       jpa.add(returns);
       jpa.add(zt);

       begin();
       JPanel jpc = new JPanel();
       add(jpc);
       jpc.setBounds(0,350,500,200);
       jpc.setLayout(null);
       MyJButton beij = new MyJButton(33);
       beij.pic("sim\\22.gif");
       lab1.setText("刘亦菲好漂亮");
       //添加原图，作为参考
       jpc.add(beij);
       beij.setBounds(50,50,390,390);
       bstart.addActionListener(this);
       returns.addActionListener(this);
       //addActionListerner目的是添加监听端口
       validate();
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    //设置返回的点击事件

    private void begin() {
        System.out.println("text测试模式--begin");
    }

    public void zt(){
        //停止的事件
        System.out.println("此时会停止播放音乐,继续点击会继续播放音乐");
        System.out.println("请到网页中点击停止播放");
    }
    
    public void start() throws IOException{
        String url = "";
        //开始的事件
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+url);
        System.out.println("开始播放音乐");
        AudioClip sound = Applet.newAudioClip(new File("sounds//houlaidewomen.wav").toURL());
    }

    public void actionPerformed(ActionEvent e){
        //事件响应器
        // 组件发生事件的时候，会将事件包装成一个actionevent对象，也就是这里的e
        // 从e里可以获得事件源对象。
		if(e.getSource()==zt){
            zt();

		}else if(e.getSource()==bstart){   //开始
            System.out.print("开始播放音乐");
            String url = "https://music.163.com/song?id=1950839974";
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+url);
            } catch (IOException e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }//使用默认浏览器打开url
			try {
                start();
            } catch (MalformedURLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
		}else if(e.getSource()==returns){   //结束
			new FWindow(); 
			dispose();
		}else{
			MyJButton JTemp = (MyJButton)e.getSource();
		}
	}
}

class SimWindow extends JFrame implements ActionListener{ 
    //ActionListener创建一个类继承JFrame实现监听接口，并且重写监听接口的唯一方法
   MyJButton b[];   //定义数组存放
   JButton bstart,returns;    //定义开始和返回
   Timer time;   //定义时间组件进行记录时间
   JLabel lab1;  //swing中的JLabel
//`JLabel`类可以显示文本或图像。通过在显示区域中设置垂直和水平对齐来对齐标签的内容。
//默认情况下，标签在显示区域中垂直居中。默认情况下，纯文本标签前沿对齐; 默认情况下，仅图像标签水平居中。   
   JButton vip;  //定义vip渠道
   int numt=1; 
   SimWindow(){    //无参构造
       setBounds(500,200,500,650);
       //分别对应的是Bounds的x,y,宽度和高度
       setVisible(true);
       
       time = new Timer(1000,this);
       //设定时间限制以秒为基本单位，可以设置为毫秒
       
       JPanel jpa = new JPanel();
       add(jpa);
       jpa.setBounds(0,0,500,45);
       jpa.setLayout(null);
       lab1 = new JLabel();
       lab1.setHorizontalAlignment(JLabel.CENTER);
       lab1.setFont(new Font("宋体",Font.BOLD,20));
       bstart = new JButton("开始");
       vip = new JButton("♥");
       //这个vip的目的是为了给充值的人一些外挂，能够强行移动位置
       returns = new JButton("返回");
       bstart.setBounds(50,5,100,40);   //开始
       vip.setBounds(160,5,60,40);     //拆
       returns.setBounds(360,5,100,40);   //结束
       lab1.setBounds(210,5,100,40);    //记录时间的变化
       jpa.add(bstart);
       jpa.add(lab1);
       jpa.add(returns);
       jpa.add(vip);
		
       //导入图片然后打乱，然后排序，然后使用数组拼接
		JPanel jpb = new JPanel();
		add(jpb);
		jpb.setBounds(100,45,300,350);
		jpb.setLayout(null);
		b = new MyJButton[9];
		int l=0,t=40;
		for(int i=1;i<=9;i++){
			b[i-1] = new MyJButton(i-1);
			jpb.add(b[i-1]);
			b[i-1].setnxy(i-1);
            //调用setnxy方法返回x
			b[i-1].pic("sim\\"+String.valueOf(""+i)+".gif");
			//路径
            b[i-1].setBounds(l,t,100,100);
            //设置图片大小
			b[i-1].addActionListener(this);
			l+=100;   //以100宽度为单位
			
			if(i%3==0){
				t+=100;
				l=0;  
                //每行三个图片（简单模式）
			}
		}
		begin();
		JPanel jpc = new JPanel();
		add(jpc);
		jpc.setBounds(0,350,500,200);
		jpc.setLayout(null);
		MyJButton yuantu = new MyJButton(33);
		yuantu.pic("sim\\22.gif");
        //添加原图，作为参考
		jpc.add(yuantu);
		yuantu.setBounds(155,395,190,190);
		bstart.addActionListener(this);
		returns.addActionListener(this);
        //addActionListerner目的是添加监听端口
		validate();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}



	int Upp(int i){
		if(i-3<0) return i;
		else{
			int temp;
			temp = b[i-3].getnxy();
			b[i-3].setnxy(b[i].getnxy());
			b[i].setnxy(temp);
			String itemp;
			itemp = b[i-3].reicon();
			b[i-3].pic(b[i].reicon());
			b[i].pic(itemp);
			return i-3;
			}
	}
	
	int Doo(int i){
		if(i+3>8) return i;
		else{
			int temp;
			temp = b[i+3].getnxy();
			b[i+3].setnxy(b[i].getnxy());
			b[i].setnxy(temp);
			String itemp;
			itemp = b[i+3].reicon();
			b[i+3].pic(b[i].reicon());
			b[i].pic(itemp);
			return i+3;
			}
	}
	
	int Lee(int i){
		if((i-1)/3 != i/3) return i;
		else{
			int temp;
			temp = b[i-1].getnxy();
			b[i-1].setnxy(b[i].getnxy());
			b[i].setnxy(temp);
			String itemp;
			itemp = b[i-1].reicon();
			b[i-1].pic(b[i].reicon());
			b[i].pic(itemp);
			return i-1;
		}
	}
	
	int Rii(int i){
		if((i+1)/3 != i/3) return i;
		else{
			int temp;
			temp = b[i+1].getnxy();
			b[i+1].setnxy(b[i].getnxy());
			b[i].setnxy(temp);
			String itemp;
			itemp = b[i+1].reicon();
			b[i+1].pic(b[i].reicon());
			b[i].pic(itemp);
			return i+1;
		}
	}
	
	void begin(){
		for(int i=66;i>=0;i--){
			int ri = i%4;
			int rz = (int)(Math.random()*9);
			switch(ri){
				case 0:
					rz=Upp(rz);
				case 1:
					rz=Doo(rz);
				case 2:
					if(rz-1>=0)
						rz=Lee(rz);
				case 3:
					if(rz+1<=8)
						rz=Rii(rz);
			}
		}
	}
	
	boolean isOK(){
		for(int i=0;i<=8;i++){
			if(b[i].getnxy()!=b[i].getxy())
				return false;
		}
		return true;
	}
	
	void End(boolean bl){
		if (bl==true){
			time.stop();  //成功了就停止记时间并且打印
			lab1.setText("成功了!");
		}
	}
	
    int vip(){
        // System.out.println("我想要删除一个箱子，开挂");
        // if(((i+1)/3 != i/3) && ((i+1)/3 != i/3)) return i; 
        // else{
		// 	int temp;
		// 	temp = b[i+1].getnxy();
		// 	b[i+1].setnxy(b[i].getnxy());
		// 	b[i].setnxy(temp);
		// 	String itemp;
		// 	itemp = b[i+1].reicon();
		// 	b[i+1].pic(b[i].reicon());
		// 	b[i].pic(itemp);
		// 	return i+1;          
        // }
        
      //  return i;
    }

	public void actionPerformed(ActionEvent e){
        //事件响应器
        // 组件发生事件的时候，会将事件包装成一个actionevent对象，也就是这里的e
        // 从e里可以获得事件源对象。
		if(e.getSource()==time){
			lab1.setText(""+numt);
			numt=numt+1;
            //记时装备
            if(numt >= 100){
                lab1.setText("超时了!");
                numt = 999;
            }
		}else if(e.getSource()==bstart){   //开始
			time.start();
		}else if(e.getSource()==returns){   //结束
			new FWindow(); 
			dispose();
        }else if(e.getSource()==vip){   //点击vip
			//vip(JTemp.getxy());
    		}else{
			MyJButton JTemp = (MyJButton)e.getSource();
			if(JTemp.getxy()-1>=0){
				if(b[JTemp.getxy()-1].getnxy()==8){
					Rii(JTemp.getxy()-1);
                    //左右移动
					End(isOK());
					return ;
				}
			}
			if(JTemp.getxy()-3>=0){
				if(b[JTemp.getxy()-3].getnxy() == 8){
					Doo(JTemp.getxy()-3);
					End(isOK());
					return ;
				}
			}
			if(JTemp.getxy()+3<=8){
				if(b[JTemp.getxy()+3].getnxy() == 8){
					Upp(JTemp.getxy()+3);
					End(isOK());
					return ;
				}
			}
			if(JTemp.getxy()+1<=8){
				if(b[JTemp.getxy()+1].getnxy() == 8){
					Lee(JTemp.getxy()+1);
					End(isOK());
					return ;
				}
			}
		}
	}
}



class MidWindow extends JFrame implements ActionListener{ 
}



class HigWindow extends JFrame implements ActionListener{ 
}


class AbnWindow extends JFrame implements ActionListener{ 
}