package functionalInterface;

public class Main {
	public static void main(String... args) {
		StringAnalyzer analyzer = (source, strSearch) -> source.contains(strSearch);
		System.out.println(analyzer.analyze("Juan Camilo Gaviria Holguín", "Gaviria"));
	}
}
