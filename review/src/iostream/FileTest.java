package iostream;

import java.io.File;	//nio 따로있다
import java.util.Calendar;

public class FileTest {
	public static void main(String[] args) {
		//printDirList(); //파일 목록 조회
		//deleteFile();  //파일 삭제
		printFileAttr(); //파일 속성 출력
		Calendar cal = Calendar.getInstance();
		cal.set(1997, 9, 25);
		long today = System.currentTimeMillis() - cal.getTimeInMillis();
		System.out.println(today/1000/60/60/24 + "일" ); //1970년 기준
		
	}
	
	//파일 속성 출력
	private static void printFileAttr() {
		//파일 크기
		File file = new File("d:/upload","qq.png");
		System.out.println("파일크기 : " + file.length() );
		System.out.println("파일수정일자 : " + file.lastModified());
		
	}

	//파일 삭제
	private static void deleteFile() {
		File file = new File("d:/upload","qq.png");
		file.delete();
		System.out.println("파일 삭제됨");
	}

	//파일 목록 조회
	private static void printDirList() {
		File dir = new File("d:/upload");
		if(dir.isDirectory()) {
			File[] list = dir.listFiles();
			for(File a : list) {
				System.out.println(a.getName());
			}
		}
		
	}
}
