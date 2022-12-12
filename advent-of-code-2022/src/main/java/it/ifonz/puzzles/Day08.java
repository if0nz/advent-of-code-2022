package it.ifonz.puzzles;

import java.io.IOException;
import java.util.List;

import it.ifonz.common.AbstractDay;
import it.ifonz.common.FileReader;

public class Day08 extends AbstractDay {

	public List<String> rows;

	public static void main(String[] args) throws IOException {

		(new Day08()).run();

	}

	public void init() throws IOException {
		rows = FileReader.readLines("src/main/resources/day08.txt");
	}

	public void part1() {
		var size = rows.size();
		var cnt = 0;
		var k = 0;
		var temp = false;
		var tree = 0;
		for (var i = 0; i < size; i++) {
			for (var j = 0; j < size; j++) {
				// base case
				if (i == 0 || j == 0 || i == size - 1 || j == size - 1) {
					cnt++; 
					continue;
				}
				// everything else
				tree = rows.get(i).charAt(j);
				for (k = j-1; k >= 0 && rows.get(i).charAt(k) < tree; k--) {} // to left
				temp = k == -1;	 
				if (temp) {
					cnt++;
					continue;
				}
				for (k = j+1; k < size && rows.get(i).charAt(k) < tree; k++) {} // to right
				temp = k == size;	 
				if (temp) {
					cnt++;
					continue;
				}
				for (k = i-1; k >= 0 && rows.get(k).charAt(j) < tree; k--) {} // to top
				temp = k == -1;	 
				if (temp) {
					cnt++;
					continue;
				}
				for (k = i+1; k < size && rows.get(k).charAt(j) < tree; k++) {} // to bottom
				temp = k == size;	 
				cnt += temp ? 1 : 0; // lol
			}
		}
		System.out.println(cnt);
	}

	public void part2() {
		var size = rows.size();
		var maxResult = 0;
		var mul = 1;
		var k = 0;
		var tree = 0;
		for (var i = 0; i < size; i++) {
			for (var j = 0; j < size; j++) {
				mul = 1;
				// base case: viewing distance = 0, scenic score = 0
				if (i == 0 || j == 0 || i == size - 1 || j == size - 1) continue;
				// everything else
				tree = rows.get(i).charAt(j);
				for (k = j-1; k >= 0 && rows.get(i).charAt(k) < tree; k--) {} // to left
				mul*= k < 0 ? (j-k-1) : j-k;
				for (k = j+1; k < size && rows.get(i).charAt(k) < tree; k++) {} // to right
				mul*= k == size ? (k-j-1) : k-j;
				for (k = i-1; k >= 0 && rows.get(k).charAt(j) < tree; k--) {} // to top
				mul*= k < 0 ? (i-k-1) : i-k;
				for (k = i+1; k < size && rows.get(k).charAt(j) < tree; k++) {} // to bottom
				mul*= k == size ? (k-i-1) : k-i;
				if (mul > maxResult) maxResult = mul;
			}
		}
		System.out.println(maxResult);
	}
	
	
}
