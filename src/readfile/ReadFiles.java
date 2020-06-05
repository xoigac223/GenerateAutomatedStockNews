package readfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFiles {
	private String namePath;	
	private File file;
	private int row;
	private int column;
	private String[][] items;
	
	
	public ReadFiles() {
		column = 0;
		row = 0;
	}
	
	
	public ReadFiles(String namePath) {
		this.namePath = namePath;
		file = new File(this.namePath);
		row = 0;
		column = 0;
	}
	
	public boolean isFile() {
		return file.isFile();
	}
	
	public int findRowNumber() {
		if (isFile()) {
			BufferedReader reader = null;
			try {
				reader =  new BufferedReader(new FileReader(file));
				while(reader.readLine() != null) {
					row++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
	                if (reader != null)
	                    reader.close();
	            } catch (IOException crunchifyException) {
	                crunchifyException.printStackTrace();
	            }
			}
			
		} else {
			System.out.println("Không tồn tại file!");
		}
		return row;
	}
	
	public int findColumnNumber() {
		if (isFile()) {
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(file));
				String s = reader.readLine();
				String[] splitData = s.split(",");
				column = splitData.length;
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
	                if (reader != null)
	                    reader.close();
	            } catch (IOException crunchifyException) {
	                crunchifyException.printStackTrace();
	            }
			}
			
		} else {
			System.out.println("Không tồn tại file!");
		}
		return column;
	}
	
	public void convertToArray() {
		int r = 0;
		items = new String[findRowNumber()][findColumnNumber()];
		BufferedReader reader = null;
		try {
			String line;
			reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {
				String[] splitData = line.split(",");
				for (int c = 0;c < column; c++) {
					items[r][c] = splitData[c];
				}
				r++;
			}
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
                if (reader != null)
                    reader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
		}
	}
	
	public void printArray() {
		for (int i = 0; i < items.length; i++) {
			System.out.printf("%s - ", (i+1));
			for (int j = 0; j < items[i].length; j++) {
				System.out.printf("%s ", items[i][j]);
			}
			System.out.println();
		}
	}
	
	public String[][] getArray(){
		convertToArray();
		return items;
	}
}
