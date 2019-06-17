package Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import jdk.jfr.events.FileWriteEvent;

public class FileOp {
	/**
	 * @throws IOException
	 * 
	 */
	public static void readFile(String fileName) {
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fileReader);
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void writeFile(String line) {
		String suffix="a.txt";
        String prefix = suffix.substring(suffix.lastIndexOf(".") + 1);
        Random random = new Random();
        Integer randomFileName = random.nextInt(1000);
        String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + randomFileName + "." + prefix;
		try {
			File writeName=new File(fileName);
			writeName.createNewFile();
			FileWriter writer=new FileWriter(writeName);
			BufferedWriter out=new BufferedWriter(writer);
			out.write(line);
			out.flush();
		}catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
