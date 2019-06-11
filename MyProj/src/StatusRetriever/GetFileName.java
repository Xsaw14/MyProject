package org.tiaa.in.StatusRetriever;

import java.io.File;
import java.util.LinkedList;

public class GetFileName {

	public LinkedList<String> getFileNames(String path){
		LinkedList<String> fileName = new LinkedList<String>();
		try{
			File reportFile = new File(path);
			for(File f : reportFile.listFiles()){
				if(f.isFile()){
					fileName.add(f.getName().toString());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return fileName;
	}
}
