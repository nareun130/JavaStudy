package stream;

public class Student implements Comparable<Student>{


	String name;
	int ban;
	int totalScore;

	public Student(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}

	@Override
	public String toString() {
		return String.format("[%s, %d, %d]", name, ban, totalScore);
	}

	public String getName() {
		return name;
	}

	public int getBan() {
		return ban;
	}

	public int getTotalScore() {
		return totalScore;
	}

	//총점 내림 차순 -> 기본 정렬 ~> Comparator.naturalOrder() 역할?  
	@Override
	public int compareTo(Student s) {

		return s.totalScore - this.totalScore;
		
//		return this.totalScore - s.totalScore;
	}


}
