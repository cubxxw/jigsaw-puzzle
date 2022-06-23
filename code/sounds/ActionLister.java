import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ActionLister {
    public static void main(String[] args) {
        //创建事件监听对象
        MyActionListener myActionListener = new MyActionListener();
        //创建一个窗口的基本操作
        Frame frame = new Frame();
        frame.setBounds(400,400,400,400);
        frame.setBackground(Color.red);
        frame.setVisible(true);

        //创建三个button对象
        Button button1=new Button("button1");
        Button button2=new Button("button2");
        Button button3=new Button("button3");
        //添加button对象
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        //把事件监听对象传入到button按钮当中，当按下button按钮，就会触发监听事件。
        button1.addActionListener(myActionListener);//两个按钮可以共用一个监听事件
        button1.setActionCommand("button一");
//        public void setActionCommand(String command) {
//            actionCommand = command;
//        }
        // public String getActionCommand() {
//        return (actionCommand == null? label : actionCommand);
//    }源码分析：如果没有定义setActionCommand中的command，那么getActionCommand会返回label也就是
//     button按钮label的值.如果有则返回定义的值。
        button2.addActionListener(myActionListener);
        //给窗口设置栅格布局
        frame.setLayout(new GridLayout(3,3));
        windowClose(frame);



    }
    //写一个关闭窗口的方法，直接调用即可关闭窗口
    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
 class MyActionListener implements ActionListener {
    //创建一个类实现监听接口，并且重写监听接口的唯一方法


     @Override
     public void actionPerformed(ActionEvent e) {
         System.out.println("按钮"+e.getActionCommand()+"被点击了");
     }
 }