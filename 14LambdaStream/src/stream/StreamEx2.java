package stream;

import java.io.File;
import java.util.stream.Stream;

public class StreamEx2 {
	public static void main(String[] args) {
		File[] fileArr = { new File("Ex1.java"), new File("Ex1.bak"), new File("Ex2.java"), new File("Ex1"),
				new File("Ex1.txt") };
		
		Stream<File> fileStream = Stream.of(fileArr);
		
		//map()으로 Stream<File>을 Stream<String>으로 변환 
		Stream<String>fileNameStream = fileStream.map(File::getName);
		fileNameStream.forEach(System.out::println);
		
		//스트림 재생성 
		fileStream = Stream.of(fileArr);
		
		fileStream.map(File::getName)
				//확장자가 없는 것 제외 
			.filter(s -> s.indexOf('.')!=-1)
			//확장자만 추
			.map(s->s.substring(s.indexOf('.')+1))
			//모두 대문자 
			.map(String::toUpperCase)
			//중복 제거 
			.distinct()
			.forEach(System.out::println);
		
		
	}
}
