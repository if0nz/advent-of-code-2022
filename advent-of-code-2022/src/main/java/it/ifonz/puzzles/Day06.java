package it.ifonz.puzzles;

import java.io.IOException;
import java.util.HashSet;

import it.ifonz.common.AbstractDay;
import it.ifonz.common.FileReader;

public class Day06 extends AbstractDay {

	public String row;

	public static void main(String[] args) throws IOException {

		(new Day06()).run();

	}

	public void init() throws IOException {
		row = FileReader.readLine("src/main/resources/day06.txt");
	}

	public void part1() {
		var i = 0;
		HashSet<Character> s;
		do {
			s = new HashSet<>();
			for (var j = 0; j < 4; j++) s.add(row.charAt(i+j));
			i++;
		} while (s.size() != 4);
		System.out.println(i+3);
		
	}

	public void part2() {
		var i = 0;
		HashSet<Character> s;
		do {
			s = new HashSet<>();
			for (var j = 0; j < 14; j++) s.add(row.charAt(i+j));
			i++;
		} while (s.size() != 14);
		System.out.println(i+13);
	}

}
