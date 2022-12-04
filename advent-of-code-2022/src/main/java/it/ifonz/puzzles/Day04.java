package it.ifonz.puzzles;

import java.io.IOException;
import java.util.List;

import it.ifonz.common.AbstractDay;
import it.ifonz.common.FileReader;

public class Day04 extends AbstractDay {

	public List<String> rows;

	public static void main(String[] args) throws IOException {

		(new Day04()).run();

	}

	public void init() throws IOException {
		rows = FileReader.readLines("src/main/resources/day04.txt");
	}

	public void part1() {
		System.out.println(rows.stream().filter(r -> {
			var p = r.split(",");
			var p1 = p[0].split("-");
			var p11 = Integer.valueOf(p1[0]);
			var p12 = Integer.valueOf(p1[1]);
			var p2 = p[1].split("-");
			var p21 = Integer.valueOf(p2[0]);
			var p22 = Integer.valueOf(p2[1]);
			return (p21 <= p11 && p22 >= p12) || (p11 <= p21 && p12 >= p22) ; // p1 contained in p2 or p2 contained in p1
		}).count());
	}

	public void part2() {
		System.out.println(rows.stream().filter(r -> {
			var p = r.split(",");
			var p1 = p[0].split("-");
			var p11 = Integer.valueOf(p1[0]);
			var p12 = Integer.valueOf(p1[1]);
			var p2 = p[1].split("-");
			var p21 = Integer.valueOf(p2[0]);
			var p22 = Integer.valueOf(p2[1]);
			return !(p12 < p21 || p22 < p11); // !(not overlap)
		}).count());
	}

}
