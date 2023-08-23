package CSV_db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Table {
	
	private String URL;
	private File file;
	private List<String> lista = new ArrayList<String>();
	
	public Table(String url) {
		this.URL = url;
		create();
		readerAllTable();
	}
	
	private void create() {
		try {
			file = new File(URL);
			
			if(file.createNewFile()) {
				System.out.println("Novo arquivo criado");
			} else {
				if(file.exists()) {
					System.out.println("Arquivo já criado");
				} else {
					System.out.println("Falha ao criar arquivo");
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private boolean fileExist() {
		if(file.exists()) {
			return true;
		} else {
			return false;
		}
	}
	
	private List<String> readerAllTable() {
		try {
			Scanner sc = new Scanner(getFile());
			sc.useDelimiter(";");
			while(sc.hasNext()) {
				lista.add(sc.next());
			}
			
			return lista;
		} catch (Exception e) {
			return null;
		}
	}
	
	public void readerAll() {
		if(fileExist()) {
			for(int i = 0;i < getList().size();i++) {
				System.out.println(getList().get(i).toString());
			}
		}
	}
	
	public String containInfo(String info) {
		
		if(lista.contains(info)) {
			return info;
		} else {
			return "";
		}
		
	}
	
	public void insertItem(String item) throws FileNotFoundException {
		if(!item.isEmpty()) {
			try(PrintWriter write = new PrintWriter(getFile())) {
				StringBuilder sb = new StringBuilder();
				var lista = getList();
				
				if(lista.size() >= 1) {
					for(int i = 0;i < lista.size();i++) {
						sb.append(lista.get(i));
						sb.append(';');
					}
				}
				
				sb.append(item);
				
				write.write(sb.toString());
				write.close();
				
				System.out.println("Icnlude feito com sucesso");
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.err.println("Informe um item");
		}
	}
	
	
	public File getFile() {
		return fileExist() ? file : null;
	}
	
	public String getURL() {
		return URL;
	}
	
	public List<String> getList() {
		if(lista.size() == 0 || lista.isEmpty()) {
			readerAllTable();
			return lista;
		} else {
			return lista;
		}
	}

}
