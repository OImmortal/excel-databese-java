package CSV_db.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import CSV_db.Index;

public class Teste {
	public static void main(String args[]){
        try (PrintWriter writer = new PrintWriter(new File("D:\\data\\test.csv"))) {

            StringBuilder sb = new StringBuilder();
//            sb.append("id");
//            sb.append(';');
//            sb.append("Name");
//            sb.append(';');
//            sb.append("Address");
//            sb.append('\n');

            sb.append("101");
            sb.append(';');
            sb.append("John Doe");
            sb.append(';');
            sb.append("Las Vegas");
            sb.append('\n');
            
            sb.append("102");
            sb.append(';');
            sb.append("Joao Pedro");
            sb.append(';');
            sb.append("Lobato");
            
            


            writer.write(sb.toString());
            writer.close();
            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Teste testCSV =  new Teste();
        testCSV.readCSVFile();
    }

    public void readCSVFile(){
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("D:\\data\\test.csv"));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(records.toString());
    }
    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(";");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
