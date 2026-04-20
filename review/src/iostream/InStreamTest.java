package iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class InStreamTest {

	public static void main(String[] args) throws Exception {
		
		//fileCopy();
		
		//키보드 -> 파일로 저장
		saveFile();
	}

	private static void saveFile() throws Exception {
		
		FileOutputStream target = new FileOutputStream(new File("d:/upload","in.txt"));
		int a;
		while((a=System.in.read())!=-1) {
			target.write(a);
		}
	}

	private static void fileCopy() throws Exception {
		FileInputStream origin = new FileInputStream(new File("d:/upload","qq.png"));
		FileOutputStream target = new FileOutputStream(new File("d:/upload","copy.png"));
		byte[] b = new byte[1024];
		int s;
		while( (s = origin.read(b)) != -1) {
			target.write(b,0,s);
		}
	}

}
