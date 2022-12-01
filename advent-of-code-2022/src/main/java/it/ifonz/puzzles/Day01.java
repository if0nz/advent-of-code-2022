package it.ifonz.puzzles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import it.ifonz.common.AbstractDay;
import it.ifonz.common.FileReader;

public class Day01 extends AbstractDay {

	public List<String> rows;
	
	public static void main(String[] args) throws IOException {
		
		(new Day01()).run();
		
	}
	
	public void init() throws IOException {
		rows = FileReader.readLines("src/main/resources/day01.txt");
		rows.add(""); // I add an empty line to prevent an extra add after the loop
	}
	
	public void part1()  {
		var calories = new ArrayList<Integer>();
		var temp = 0;
		for (var r : rows) {
			if (StringUtils.isNotBlank(r)) {
				temp += Integer.parseInt(r);
			} else {
				calories.add(temp);
				temp = 0;
			}
		}
		System.out.println(calories.stream().mapToInt(n -> n).max().getAsInt());
	}
	
	public void part2()  {
		var calories = new ArrayList<Integer>();
		var temp = 0;
		for (var r : rows) {
			if (StringUtils.isNotBlank(r)) {
				temp += Integer.parseInt(r);
			} else {
				calories.add(temp);
				temp = 0;
			}
		}
		var top3 = 0;
		for (int i = 0; i < 3; i++) {
			var max = calories.stream().mapToInt(n -> n).max().getAsInt();
			top3 += max;
			calories.remove(Integer.valueOf(max));
		}
		System.out.println(top3);
	}
	
}
