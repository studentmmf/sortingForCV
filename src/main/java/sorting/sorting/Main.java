package sorting.sorting;
import java.io.File;

public class Main {

	private static File output;

	public static void main(String[] args) {

		Options opt = new Options(args);

		try {
			output = new File(opt.getOutName());
		} catch (NullPointerException e) {
			System.out.println("Не задано имя выходного файла");
			System.exit(0);
		}

		if (opt.isString()) {

			new ForStrings(opt.getList(), opt.isAsc(), output);

		}

		else {

			new ForIntegers(opt.getList(), opt.isAsc(), output);
		}
	}

}
