package it.ifonz.puzzles;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.math.NumberUtils;

import it.ifonz.common.AbstractDay;
import it.ifonz.common.FileReader;

public class Day07 extends AbstractDay {

	public List<String> rows;

	public static void main(String[] args) throws IOException {

		(new Day07()).run();

	}

	public void init() throws IOException {
		rows = FileReader.readLines("src/main/resources/day07.txt");
	}

	public void part1() {
		var root = new Directory("/", null, new AtomicInteger(0), new ArrayList<>());
		var current = root;
		for (var r : rows) {
			String[] tokens = r.split(" ");
			if ("$ cd".equals(r.substring(0, 4))) {
				var child = tokens[2];
				if (!"/".equals(child)) { // cd / is a special case handled at the beginning
					if ("..".equals(child)) { // cd ..
						current = current.parent;
					} else { // cd x
						current = current.childs.stream().filter(d -> d.name.equals(child)).findFirst().get();
					}
				}
			} else {
				var token = tokens[0];
				if ("dir".equals(token)) { // listing a folder
					String e = tokens[1];
					current.childs.add(new Directory(e, current, new AtomicInteger(0), new ArrayList<>()));
				} else if (NumberUtils.isCreatable(token)) { // file size
					Integer fileSize = Integer.valueOf(token);
					current.size.addAndGet(fileSize); // update this folder size
					// update parents' sizes
					var p = current.parent;
					while (p != null) {
						p.size.addAndGet(fileSize);
						p = p.parent;
					}
				}
			}
		}
		// here we go, visiting the tree
		var queue = new ArrayDeque<>(root.childs);
		var s = 0;
		while (!queue.isEmpty()) {
			var d = queue.pop();
			s+=d.size.get() <= 100_000 ? d.size.get() : 0;
			queue.addAll(d.childs);
		}
		System.out.println(s);
	}

	public void part2() {
		var root = new Directory("/", null, new AtomicInteger(0), new ArrayList<>());
		var current = root;
		for (var r : rows) {
			String[] tokens = r.split(" ");
			if ("$ cd".equals(r.substring(0, 4))) {
				var child = tokens[2];
				if (!"/".equals(child)) { // cd / is a special case handled at the beginning
					if ("..".equals(child)) { // cd ..
						current = current.parent;
					} else { // cd x
						current = current.childs.stream().filter(d -> d.name.equals(child)).findFirst().get();
					}
				}
			} else {
				var token = tokens[0];
				if ("dir".equals(token)) { // listing a folder
					String e = tokens[1];
					current.childs.add(new Directory(e, current, new AtomicInteger(0), new ArrayList<>()));
				} else if (NumberUtils.isCreatable(token)) { // file size
					Integer fileSize = Integer.valueOf(token);
					current.size.addAndGet(fileSize); // update this folder size
					// update parents' sizes
					var p = current.parent;
					while (p != null) {
						p.size.addAndGet(fileSize);
						p = p.parent;
					}
				}
			}
		}
		// here we go, visiting the tree
		var queue = new ArrayDeque<Directory>();
		var list = new ArrayList<Directory>();
		queue.add(root);
		list.add(root);
		while (!queue.isEmpty()) {
			var d = queue.pop();
			queue.addAll(d.childs);
			list.addAll(d.childs);
		}
		var m = list.stream().filter(d -> d.size.get() >= 30000000-70000000+root.size.get()).min((d1,d2) -> d1.size.get() - d2.size.get()).get();
		System.out.println(m.size.get());
	}
	
	public record Directory (String name, Directory parent, AtomicInteger size, List<Directory> childs) {}
	
}
