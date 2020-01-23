package sorting.sorting;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ForIntegers {

	public ForIntegers(List<String> list, boolean asc, File output) {
		ArrayList<Integer> arr[] = new ArrayList[list.size()];

		for (int i = 0; i < list.size(); i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < list.size(); i++) {
			Scanner sc = null;
			File file = new File(list.get(i));

			try {

				sc = new Scanner(file);
			} catch (FileNotFoundException e) {
				System.out.println("Файл не найден");
				System.exit(0);
			}

			ArrayList<String> nums = new ArrayList<String>();

			while (sc.hasNextLine()) {
				String line = sc.nextLine().trim();
				nums.add(line);
			}
			Integer num = null;
			for (int j = 0; j < nums.size(); j++) {
				num = Integer.valueOf(nums.get(j));
				arr[i].add(num);
			}

			try {
				sc.close();
			} catch (Exception e) {
				System.out.println("Ошибка закрытия сканнера");
				System.exit(0);
			}

		}

		ArrayList<Integer> out = new ArrayList<Integer>();// итоговый массив

		out = arr[0];
		for (int i = 0; i < list.size() - 1; i++) {

			out = sort(out, arr[i + 1], asc);
		}

		
		BufferedWriter bufferedWriter = null;
		try {
			
			bufferedWriter = new BufferedWriter(new FileWriter(output));

			String str;
			for (int i = 0; i < out.size(); i++) {
				str = out.get(i).toString() + '\n';

				bufferedWriter.write(str);
			}

		} catch (Exception e) {

			System.out.println("Ошибка записи в файл");
			System.exit(0);
		} finally {
			try {
				bufferedWriter.close();
			} catch (Exception e) {
				System.out.println("Ошибка закрытия потока");
				System.exit(0);
			}
		}

	}

	private ArrayList<Integer> sort(ArrayList<Integer> a, ArrayList<Integer> b, boolean asc) {
		ArrayList<Integer> c = new ArrayList<Integer>();

		int i = 0, j = 0;
		for (int k = 0; k < a.size() + b.size(); k++) {

			if (i > a.size() - 1) {

				c.add(b.get(j));
				j++;
			} else if (j > b.size() - 1) {

				c.add(a.get(i));
				i++;
			} else if (a.get(i) < b.get(j) && asc) {

				c.add(a.get(i));
				i++;
			} else if (a.get(i) > b.get(j) && !asc) {
				c.add(a.get(i));
				i++;
			} else {

				c.add(b.get(j));
				j++;
			}
		}

		return c;

	}

}
