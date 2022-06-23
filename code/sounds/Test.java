import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Test{
public Test(){
try {
InputStream in = new FileInputStream("houlaidewomen.wav");//找到这个音乐文件
AudioStream as = new AudioStream(in);
AudioPlayer.player.start(as);// 开始播放
//AudioPlayer.player.stop(as);
}catch(FileNotFoundException e){
}
catch(IOException e){
}
}
public static void main(String[] args){
new Test();
}
}
