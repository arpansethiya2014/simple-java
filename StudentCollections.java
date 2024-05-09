
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StudentCollections {

	// https://medium.com/illumination/java-8-stream-api-commonly-asked-interview-questions-2a57081044ef

	private static List<Student> data() {

		return Arrays.asList(new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
				new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
				new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
				new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
				new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
				new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
				new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
				new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
				new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
				new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));

	}

	private static List<Student> findByCharecterName() {

		List<Student> list = data();
		List<Student> listName = list.stream().filter(dt -> dt.getFirstName().startsWith("S"))
				.collect(Collectors.toList());
		return listName;

	}

	private static Map<String, List<Student>> groupBy() {

		List<Student> list = data();
		Map<String, List<Student>> groupBy = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName));
		return groupBy;

	}

	private static long count() {
		List<Student> list = data();
		long count = list.stream().count();
		return count;
	}

	private static OptionalInt maxAge() {
		List<Student> list = data();
		// OptionalInt count = list.stream().mapToInt(dt->dt.getAge()).min();
		OptionalInt count = list.stream().mapToInt(dt -> dt.getAge()).max();
		return count;
	}

	private static List<String> findAllName() {

		List<Student> list = data();
		List<String> listName = list.stream().map(dt -> dt.getFirstName() + " " + dt.getLastName()).distinct()
				.collect(Collectors.toList());
		return listName;

	}

	private static Map<String, Long> countEveryDepartment() {

		List<Student> list = data();
		Map<String, Long> listName = list.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
		return listName;

	}

	private static List<Student> findByAgeLessThen() {

		List<Student> list = data();
		List<Student> listName = list.stream().filter(dt -> dt.getAge() < 30).collect(Collectors.toList());
		return listName;

	}

	private static List<Student> studentRankBetween() {
		List<Student> list = data();
		List<Student> listName = list.stream().filter(dt -> dt.getRank() > 60 && dt.getRank() < 100)
				.collect(Collectors.toList());
		return listName;
	}

	private static Map<String, Double> averageAge() {
		List<Student> list = data();
		Map<String, Double> listName = list.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
		return listName;
	}

	private static Entry<String, Long> departmentMaxNumberStudent() {
		List<Student> list = data();
		Entry<String, Long> entry = list.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting())).entrySet().stream()
				.max(Map.Entry.comparingByValue()).get();
		return entry;
	}

	private static List<Student> findBySortNameAndCity() {
		List<Student> list = data();
		List<Student> listName = list.stream().filter(dt -> dt.getCity().equals("Delhi"))
				.sorted(Comparator.comparing(Student::getFirstName)).collect(Collectors.toList());
		return listName;
	}

	private static Map<String, Double> averageRankDepartment() {
		List<Student> list = data();
		Map<String, Double> collect = list.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank)));
		return collect;
	}

	private static Map<String, Optional<Student>> highestRankDepartment() {
		List<Student> list = data();
		Map<String, Optional<Student>> studentData = list.stream().collect(Collectors
				.groupingBy(Student::getDepartmantName, Collectors.minBy(Comparator.comparing(Student::getRank))));
		return studentData;
	}

	private static List<Student> studentSortByRank() {
		List<Student> list = data();
		List<Student> stuRankSorted = list.stream().sorted(Comparator.comparing(Student::getRank))
				.collect(Collectors.toList());
		return stuRankSorted;
	}

	private static Student studentSecondRank() {
		List<Student> list = data();
		Student student = list.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().get();
		return student;
	}

	public static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        
        return new int[]{-1, -1}; // No solution found
    }
	
	public static void main(String[] args) {
		// System.out.println(findByCharecterName());
		// System.out.println(groupBy());
		// System.out.println(count());
		// System.out.println(maxAge());
		// System.out.println(findAllDepartment());
		// System.out.println(countEveryDepartment());
		// System.out.println(findByAgeLessThen());
		// System.out.println(studentRankBetween());
		// System.out.println(averageAge());
		System.out.println(departmentMaxNumberStudent());
		System.out.println(findBySortNameAndCity());
		System.out.println(averageRankDepartment());
		System.out.println(highestRankDepartment());
		System.out.println(studentSortByRank());
		System.out.println(studentSecondRank());
		
		
		 int[] nums = {2, 6, 3, 1, 4, 7};
	        int target = 15;
	        
	        int[] result = findTwoSum(nums, target);
	        
	        if (result[0] != -1) {
	            System.out.println("Output: [" + result[0] + "," + result[1] + "]");
	        } else {
	            System.out.println("No solution found.");
	        }
	}

}
