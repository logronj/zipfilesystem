package zipfilesystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ZipMain {
	public static void main(String[] args) {
		String[] data = {
				"Line 1",
				"Line 2 2",
				"Line 3 3 3",
				"Line 4 4 4 4",
				"Line 5 5 5 5 5"
		};
		
		try(FileSystem zFs = openZip(Paths.get("myData.zip"))){
			copyToZip(zFs);
			writeToFileInZip1(zFs,data);
			writeToFileInZip2(zFs,data);
		}catch (Exception e) {
			System.out.println(e.getClass().getSimpleName()+"-"+e.getMessage());
		}
	}

	public static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException{
		Map<String,String> providerProps = new HashMap<>();
		providerProps.put("create", "true");
		
		URI zipUri = new URI("jar:file",zipPath.toUri().getPath(),null);
		FileSystem zipFs = FileSystems.newFileSystem(zipUri, providerProps);
		return zipFs;
	}
	
	public static void copyToZip(FileSystem zipFs) throws IOException {
		Path sourceFile = Paths.get("filename.txt");
		Path destFile = zipFs.getPath("/filenamecopy.txt");
		Files.copy(sourceFile, destFile,StandardCopyOption.REPLACE_EXISTING);
	}
	
	private static void writeToFileInZip1(FileSystem zFs, String[] data) {
		try(BufferedWriter bw = Files.newBufferedWriter(zFs.getPath("/newFile.txt"))){
			for(String s : data) {
				bw.write(s);
				bw.newLine();
			}
		}catch (Exception e) {
			System.out.println(e.getClass().getSimpleName()+"-"+e.getMessage());
		}
	}
	
	private static void writeToFileInZip2(FileSystem zFs, String[] data) throws IOException {
		Files.write(zFs.getPath("/newFile2.txt"),Arrays.asList(data), Charset.defaultCharset(), StandardOpenOption.CREATE);
	}

}
