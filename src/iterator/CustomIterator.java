import java.util.Iterator;

class Student {
  public double GPA;
  public int age;
  public String name;
  public String school;

  public Student( double GPA, String name, int age, String school) {
    this.GPA = GPA;
    this.name = name;
    this.age = age;
    this.school = school;
  }

  @Override
  public String toString() {
    return name + "," + GPA + "," + age + "," + school;
  }
  
	public String getSchool() {
		return school;
	}
  

  public static Student [] createTestArray() {
    Student s0 = new Student( 3.8d, "Adnan Aziz", 21, "UT Austin");
    Student s1 = new Student( 3.6d, "Imran Aziz", 20, "MIT");
    Student s2 = new Student( 3.5d, "Aardvark Smith", 18, "Berkeley");
    Student s3 = new Student( 2.9d, "Thomas Jefferson", 17, "UT Austin");
    Student s4 = new Student( 3.3d, "Matt Biondi", 22, "Berkeley");
    Student [] testarray = {s0, s1, s2, s3, s4};
    return testarray;
  }

}

public class CustomIterator {

  public static class StudentIteratorBySchool implements Iterator<Student> {
	  
	private Student[] students;
	private int currentIndex;
	private String school;
	
	public StudentIteratorBySchool(Student[] students, String school) {
		this.students = students;
		this.school = school;
	}

	@Override
	public boolean hasNext() {
		for (int i = currentIndex; i < students.length; i++) {
			if (students[i].getSchool().equals(school)) {
				return true;
			} else {
				currentIndex++;
			}
		}
		return false;
	}

	@Override
	public Student next() {
		int i = currentIndex;
		Student nextStudent = null;
		for (; i < students.length; i++) {
			if (students[i].getSchool().equals(school)) {
				nextStudent = students[i];
				break;
			} 
		}
		currentIndex  = ++i;
		return nextStudent;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
    //TODO(DP): implement this iterator as per the lab specification
    // the remove method should  throw an UnsupportedOperationException

  }

  interface StudentPredicate {
    boolean check( Student s );
  }


  public static class StudentIteratorPredicated implements Iterator<Student> {

	private int currentIndex;
	private Student[] students;
	private StudentPredicate predicate;

	public StudentIteratorPredicated(StudentPredicate studentPredicate,	Student[] students) {
		this.students = students;
		this.predicate = studentPredicate;
	}

	@Override
	public boolean hasNext() {
		for (int i = currentIndex; i < students.length; i++) {
			if (predicate.check(students[i])) {
				return true;
			} else {
				currentIndex++;
			}
		}
		return false;
	}

	@Override
	public Student next() {
		int i = currentIndex;
		Student nextStudent = null;
		for (; i < students.length; i++) {
			if (predicate.check(students[i])) {
				nextStudent = students[i];
				break;
			} 
		}
		currentIndex  = ++i;
		return nextStudent;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
    //TODO(DP): implement this iterator as per the lab specification
    // the remove method should  throw an UnsupportedOperationException
  }

}
