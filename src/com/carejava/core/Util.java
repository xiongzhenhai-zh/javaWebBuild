package com.carejava.core;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Util {

	/**
	public static List<String> getImports(File file) {
		List<String> pkgs = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(file);
			BufferedReader bufferedreader = new BufferedReader(fr);
			String line = null;
			while ((line = bufferedreader.readLine().trim()) != null) {
				if (0 != line.length()) {
					if (line.contains("import")) {
						if (line.contains(";")) {
							pkgs.add(line.substring(line.indexOf("import") + 6,
									line.indexOf(";")).trim());
						} else {
							System.out.println("导入包语法格式不正确");
						}
					}
				}
			}
			fr.close();
		} catch (Exception e) {
		}
		return pkgs;
	}
	*/

	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0))){
			return s;
		}else{
			StringBuilder sb = new StringBuilder();
			sb.append(""+Character.toLowerCase(s.charAt(0)));
			sb.append(s.substring(1));
			return sb.toString();
		}
	}

	public static String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder())
					.append(""+Character.toUpperCase(s.charAt(0)))
					.append(s.substring(1)).toString();
	}

	public static void createFolder(String path) {
		File folder = new File(path);
		if (!folder.exists()){
			folder.mkdir();
		}
	}

	public static boolean removeFolder(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
				flag = true;
			}
		}
		return flag;
	}

	private static void delFolder(String folderPath) {
		try {
			removeFolder(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void copyFolder(String oldPath, String newPath)
			throws IOException {
		// 新建目标目录
		(new File(newPath)).mkdirs();
		// 获取源文件夹当前下的文件或目录
		File[] file = (new File(oldPath)).listFiles();
		for (int i = 0; i < file.length; i++) {
			if (file[i].isFile()) {
				// 源文件
				File sourceFile = file[i];
				// 目标文件
				File targetFile = new File(new File(newPath).getAbsolutePath()
						+ File.separator + file[i].getName());
				Util.copyFile(sourceFile, targetFile);
			}
			if (file[i].isDirectory()) {
				// 准备复制的源文件夹
				String dir1 = oldPath + "/" + file[i].getName();
				// 准备复制的目标文件夹
				String dir2 = newPath + "/" + file[i].getName();
				Util.copyFolder(dir1, dir2);
			}
		}
	}

	public static void createFile(String path, String name, String context) {
		try {
			int total = context.length();
			System.out.println(total);
			int curr = 0;
			FileOutputStream fs = new FileOutputStream(path+name);
			while(curr<total){
				int length = (total-curr)<1444?(total-curr):1444;
				System.out.println(curr+","+length);
				byte[] bts = context.substring(curr,curr+length).getBytes();
				fs.write(bts, 0, bts.length);
				curr = curr + length;
			}
			fs.close();
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();
		}
	}

	public static void removeFile(String path) {
		File temp = new File(path);
		if (temp.isFile()) {
			temp.delete();
		}
	}

	public static void copyFile(String oldPath, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) { // 文件存在时
				InputStream inStream = new FileInputStream(oldPath); // 读入原文件
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // 字节数 文件大小
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				fs.close();
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();
		}
	}

	public static void copyFile(File sourceFile, File targetFile)
			throws IOException {
		// 新建文件输入流并对它进行缓冲
		FileInputStream input = new FileInputStream(sourceFile);
		BufferedInputStream inBuff = new BufferedInputStream(input);

		// 新建文件输出流并对它进行缓冲
		FileOutputStream output = new FileOutputStream(targetFile);
		BufferedOutputStream outBuff = new BufferedOutputStream(output);

		// 缓冲数组
		byte[] b = new byte[1024 * 5];
		int len;
		while ((len = inBuff.read(b)) != -1) {
			outBuff.write(b, 0, len);
		}
		// 刷新此缓冲的输出流
		outBuff.flush();

		// 关闭流
		inBuff.close();
		outBuff.close();
		output.close();
		input.close();
	}
	
	public static String jsonFormatter(String str){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(str);
		String prettyJsonString = gson.toJson(je);
		return prettyJsonString;
	}
}
