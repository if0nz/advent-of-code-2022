package it.ifonz.puzzles;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

import it.ifonz.common.AbstractDay;
import it.ifonz.common.FileReader;

public class Day03 extends AbstractDay {

	public List<String> rows;

	public static void main(String[] args) throws IOException {

		(new Day03()).run();

	}

	public void init() throws IOException {
		rows = FileReader.readLines("src/main/resources/day03.txt");
	}

	public void part1() {
		var s = rows.stream().mapToInt(r -> {
			var s1 = r.substring(0, r.length() / 2);
			var s2 = r.substring(r.length() / 2);
			var shared = s1.chars().filter(c -> s2.contains(Character.toString(c))).findAny().getAsInt();
			return shared >= 'a' ? shared - 'a' + 1 : shared - 'A' + 27;
		}).sum();
		System.out.println(s);
	}

	public void part2() {
		var s = IntStream.range(0, rows.size() / 3).map(i -> {
			var s1 = IntStream.rangeClosed('a', 'z')
					.filter(c -> rows.get(i * 3).contains(Character.toString(c))
							&& rows.get(i * 3 + 1).contains(Character.toString(c))
							&& rows.get(i * 3 + 2).contains(Character.toString(c)))
					.findFirst().orElse(0);
			var s2 = IntStream.rangeClosed('A', 'Z')
					.filter(c -> rows.get(i * 3).contains(Character.toString(c))
							&& rows.get(i * 3 + 1).contains(Character.toString(c))
							&& rows.get(i * 3 + 2).contains(Character.toString(c)))
					.findFirst().orElse(0);
			return s1 > 0 ? s1 - 'a' + 1 : s2 - 'A' + 27;
		}).sum();
		System.out.println(s);
	}

}
