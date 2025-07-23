// for reading in a file, line by line

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class readFile {
	private String filepath = null;
	private String ln = null;
	private FileReader fr;
	private BufferedReader br;

	public readFile(String file) throws FileNotFoundException {
		this.filepath = file;
		this.fr = new FileReader(filepath);
		this.br = new BufferedReader(fr);
	}

	public String line() throws IOException {
		this.ln = this.br.readLine();
		if (this.ln == null) {
			this.br.close();
			return null;
		}
		return ln;
	}

	public String filename() {
		return this.filepath;
	}
}
