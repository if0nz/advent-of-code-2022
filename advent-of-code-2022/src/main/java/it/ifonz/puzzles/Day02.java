package it.ifonz.puzzles;

import java.io.IOException;
import java.util.List;

import it.ifonz.common.AbstractDay;
import it.ifonz.common.FileReader;

public class Day02 extends AbstractDay {

	public List<String> rows;

	public static void main(String[] args) throws IOException {

		(new Day02()).run();

	}

	public void init() throws IOException {
		rows = FileReader.readLines("src/main/resources/day02.txt");
	}

	public void part1() {
		System.out.println(rows.stream().mapToInt(r -> {
			return switch (r.charAt(0)) {
			case 'A' -> switch (r.charAt(2)) {
				case 'X' -> 4;
				case 'Y' -> 8;
				case 'Z' -> 3;
				default -> 0;
				};
			case 'B' -> switch (r.charAt(2)) {
				case 'X' -> 1;
				case 'Y' -> 5;
				case 'Z' -> 9;
				default -> 0;
				};
			case 'C' -> switch (r.charAt(2)) {
				case 'X' -> 7;
				case 'Y' -> 2;
				case 'Z' -> 6;
				default -> 0;
				};
			default -> 0;
			};
		}).sum());
	}

	public void part2() { // X = lose Y = draw Z = win
		System.out.println(rows.stream().mapToInt(r -> {
			return switch (r.charAt(0)) {
			case 'A' -> switch (r.charAt(2)) {
				case 'X' -> 3;
				case 'Y' -> 4;
				case 'Z' -> 8;
				default -> 0;
				};
			case 'B' -> switch (r.charAt(2)) {
				case 'X' -> 1;
				case 'Y' -> 5;
				case 'Z' -> 9;
				default -> 0;
				};
			case 'C' -> switch (r.charAt(2)) {
				case 'X' -> 2;
				case 'Y' -> 6;
				case 'Z' -> 7;
				default -> 0;
				};
			default -> 0;
			};
		}).sum());
	}

}
