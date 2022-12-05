package it.ifonz.puzzles;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import it.ifonz.common.AbstractDay;
import it.ifonz.common.FileReader;

public class Day05 extends AbstractDay {

	public List<String> rows;

	public static void main(String[] args) throws IOException {

		(new Day05()).run();

	}

	public void init() throws IOException {
		rows = FileReader.readLines("src/main/resources/day05.txt");
	}

	public void part1() {
		var stacks = new ArrayList<ArrayDeque<Character>>();
		int numOfStacks = rows.get(0).length()/4+1;
		for (var i = 0; i < numOfStacks; i++) stacks.add(new ArrayDeque<>()); // init the stacks
		var i = 0;
		var r = "";
		// populate the stacks
		while (StringUtils.isNotBlank(r = rows.get(i))) { // ;-D
			for (var s = 0; s < numOfStacks; s++) {
				var c = r.charAt(1+s*4);
				if (c != ' ') stacks.get(s).add(c);
			}
			i++;
		}
		i++; // init on 1st move
		for(;i<rows.size();i++) {
			var t = rows.get(i).split(" ");
			var q = Integer.valueOf(t[1]);
			var from = Integer.valueOf(t[3])-1;
			var to = Integer.valueOf(t[5])-1;
			for (var j = 0; j<q; j++) {
				stacks.get(to).push(stacks.get(from).pop());
			}
		}
		stacks.stream().map(s -> s.getFirst()).forEach(System.out::print);
		System.out.println();
		
	}

	public void part2() {
		var stacks = new ArrayList<ArrayDeque<Character>>();
		int numOfStacks = rows.get(0).length()/4+1;
		for (var i = 0; i < numOfStacks; i++) stacks.add(new ArrayDeque<>()); // init the stacks
		var i = 0;
		var r = "";
		// populate the stacks
		while (StringUtils.isNotBlank(r = rows.get(i))) { // ;-D
			for (var s = 0; s < numOfStacks; s++) {
				var c = r.charAt(1+s*4);
				if (c != ' ') stacks.get(s).add(c);
			}
			i++;
		}
		i++; // init on 1st move
		for(;i<rows.size();i++) {
			var t = rows.get(i).split(" ");
			var q = Integer.valueOf(t[1]);
			var from = Integer.valueOf(t[3])-1;
			var to = Integer.valueOf(t[5])-1;
			var tmp = new ArrayDeque<Character>();
			for (var j = 0; j<q; j++) {
				tmp.push(stacks.get(from).pop());
			}
			tmp.forEach(c -> stacks.get(to).push(c));
		}
		stacks.stream().map(s -> s.getFirst()).forEach(System.out::print);
	}

}
