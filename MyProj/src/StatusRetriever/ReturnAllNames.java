package org.tiaa.in.StatusRetriever;

import java.io.File;
import java.util.List;

public class ReturnAllNames {

	public String[] returnNames(String path, String type) {

		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		String[] empty = { "NA" };
		StringBuffer filebf = new StringBuffer();
		StringBuffer folderbf = new StringBuffer();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				filebf.append(listOfFiles[i].getName().toString());
				if (i != (listOfFiles.length - 1)) {
					filebf.append(";");
				}
			} else if (listOfFiles[i].isDirectory()) {
				folderbf.append(listOfFiles[i].getName().toString());
				if (i != (listOfFiles.length - 1)) {
					folderbf.append(";");
				}
			}
		}
		String[] folderNames = { "FOLDER", folderbf.toString() };
		String[] fileNames = { "FILE", filebf.toString() };
		if (type.equalsIgnoreCase("folder")) {
			return folderNames;
		} else if (type.equalsIgnoreCase("file")) {
			return fileNames;
		}
		return empty;
	}

	public String[][] returnNames2(String path, String type) {

		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		StringBuffer filebf = new StringBuffer();
		StringBuffer folderbf = new StringBuffer();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				filebf.append(listOfFiles[i].getName().toString());
				if (i != (listOfFiles.length - 1)) {
					filebf.append(";");
				}
			} else if (listOfFiles[i].isDirectory()) {
				folderbf.append(listOfFiles[i].getName().toString());
				if (i != (listOfFiles.length - 1)) {
					folderbf.append(";");
				}
			}
		}
		String[][] returnFolderAndFile = {{ "FOLDER", folderbf.toString() },{ "FILE", filebf.toString() }};
		return returnFolderAndFile;
	}

	public void fileName(File folder, List<String> name) {

		for (File f : folder.listFiles()) {
			if (f.isDirectory()) {
				System.out.println("Folder :" + f.getName());
			} else if (f.isFile()) {
				System.out.println("File :" + f.getName());
				name.add(f.getName().toString());
			}
		}
	}
}
