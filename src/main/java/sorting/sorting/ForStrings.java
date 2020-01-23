package sorting.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ForStrings {

	public ForStrings(List<String> list, boolean asc, File output) {
		ArrayList<String> arr[] = new ArrayList[list.size()];

		for (int i = 0; i < list.size(); i++) {
			arr[i] = new ArrayList<String>();
		}
		BufferedReader bufferedReader = null;
		for (int i = 0; i < list.size(); i++) {

			try {
				bufferedReader = new BufferedReader(new FileReader(list.get(i)));

			} catch (FileNotFoundException e) {
				System.out.println("Файл не найден");
				System.exit(0);
			}
			ArrayList<String> strs = new ArrayList<String>();

			String line;
			try {
				while ((line = bufferedReader.readLine()) != null) {
					strs.add(line);
				}
			} catch (IOException e) {
				System.out.println("Ошибка чтения из файла");
				System.exit(0);
			} finally {
				try {
					bufferedReader.close();
				} catch (Exception e) {
					System.out.println("Ошибка закрытия потока");
					System.exit(0);
				}
			}

			String str1 = null;
			for (int j = 0; j < strs.size(); j++) {
				str1 = strs.get(j).trim();
				arr[i].add(str1);
			}

		}

		ArrayList<String> out = new ArrayList<String>();// итоговый массив

		out = arr[0];
		for (int i = 0; i < list.size() - 1; i++) {

			out = sort(out, arr[i + 1], asc);
		}

		
		BufferedWriter bufferedWriter = null;
		try {
			
			bufferedWriter = new BufferedWriter(new FileWriter(output));

			String str;
			for (int i = 0; i < out.size(); i++) {
				str = out.get(i) + '\n';
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

	private ArrayList<String> sort(ArrayList<String> a, ArrayList<String> b, boolean asc) {
		ArrayList<String> c = new ArrayList<String>();

		int i = 0, j = 0;
		for (int k = 0; k < a.size() + b.size(); k++) {

			if (i > a.size() - 1) {

				c.add(b.get(j));
				j++;
			} else if (j > b.size() - 1) {

				c.add(a.get(i));
				i++;
			} else if (a.get(i).compareTo(b.get(j)) < 0 && asc) {

				c.add(a.get(i));
				i++;
			} else if (a.get(i).compareTo(b.get(j)) > 0 && !asc) {
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
