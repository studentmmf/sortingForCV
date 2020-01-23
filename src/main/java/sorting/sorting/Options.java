package sorting.sorting;
import java.util.ArrayList;
import java.util.List;

public class Options {

	private boolean asc = true;// флаг сортировки по возрастанию
	private boolean string = false;// тип данных для сортировки
	private String outName = null;// имя выходного файла
	private List<String> list = new ArrayList<String>();// список имен файлов для сортировки
	public static final String ASC_SORT = "-a";
	public static final String DESC_SORT = "-d";
	public static final String INT_SORT = "-i";
	public static final String STR_SORT = "-s";
	
	public Options(String[] args) {
		try {
		if (!args[0].equals(ASC_SORT) && !args[0].equals(DESC_SORT)) {
			asc = true;
			if (args[0].equals(STR_SORT)) {
				string = true;
			} else if (args[0].equals(INT_SORT)) {
				string = false;
			} else {
				System.out.println("Некорректный аргумент");
			}
			outName = args[1];
			for (int i = 2; i < args.length; i++) {
				list.add(args[i]);
			}
		} else if (args[0].equals(ASC_SORT) || args[0].equals(DESC_SORT)) {

			if (args[0].equals(ASC_SORT)) {
				asc = true;
			}

			if (args[0].equals(DESC_SORT)) {
				asc = false;
			}

			if (args[1].equals(STR_SORT)) {
				string = true;
			} else if (args[1].equals(INT_SORT)) {
				string = false;
			} else {
				System.out.println("Некорректный аргумент");
			}
			outName = args[2];
			for (int i = 3; i < args.length; i++) {
				list.add(args[i]);
			}
		}
		}
		catch(Exception e) {
			System.out.println("Некорректный аргумент");
			System.exit(0);
		}
	}

	public boolean isAsc() {
		return asc;
	}

	public void setAsc(boolean asc) {
		this.asc = asc;
	}

	public boolean isString() {
		return string;
	}

	public void setString(boolean string) {
		this.string = string;
	}

	public String getOutName() {
		return outName;
	}

	public void setOutName(String outName) {
		this.outName = outName;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}
