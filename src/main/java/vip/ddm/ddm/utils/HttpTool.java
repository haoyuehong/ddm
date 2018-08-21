package vip.ddm.ddm.utils;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.List;

public class HttpTool {

	static CookieManager manager = new CookieManager();
	static {
		CookieHandler.setDefault(manager);
	}

	public static String POST(String url, HashMap<String,String> prams, HashMap<String,String> header, String charset) throws Exception{
		HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(url).openConnection();
		// 设置通用的请求属性
		httpURLConnection.setRequestProperty("accept","*/*");
		httpURLConnection.setRequestProperty("connection","Keep-Alive");
		httpURLConnection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		httpURLConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		httpURLConnection.setConnectTimeout(30000);
		httpURLConnection.setReadTimeout(30000);
		// 发送POST请求必须设置如下两行
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setDoInput(true);
		// 默认是 GET方式
		httpURLConnection.setRequestMethod("POST");
		// Post 请求不能使用缓存
		httpURLConnection.setUseCaches(false);
		httpURLConnection.setInstanceFollowRedirects(true);

		if(header!=null){
			for (String key : header.keySet()) {
				httpURLConnection.setRequestProperty(key,header.get(key));
			}
		}

		if(prams!=null){
			StringBuilder params=new StringBuilder();
			for (String key : prams.keySet()) {
				params.append(key + "=" + URLEncoder.encode(prams.get(key),"utf-8")+"&");
			}
			String param=params.toString().substring(0,params.toString().length()-1);
			System.out.println(param);
			DataOutputStream out = new DataOutputStream(httpURLConnection.getOutputStream());
			out.write(param.getBytes("UTF-8"));
			out.flush();
		}

		if(charset==null){
			charset="utf-8";
		}
		InputStreamReader in =new InputStreamReader(httpURLConnection.getInputStream(),charset);
		StringBuilder result=new StringBuilder();
		int line;
		while ((line=in.read()) != -1) {
			result.append((char)line);
		}
		in.close();
		System.out.println(result);
		return result.toString();
	}

	public static String GET(String url, HashMap<String,String> prams,HashMap<String,String> header,String charset) throws Exception{
		String param="";
		if(prams!=null){
			StringBuilder params=new StringBuilder();
			for (String key : prams.keySet()) {
				params.append(key + "=" + URLEncoder.encode(prams.get(key),"utf-8")+"&");
			}
			param="?"+params.toString().substring(0,params.toString().length()-1);
		}
		HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(url+param).openConnection();
		// 设置通用的请求属性
		httpURLConnection.setRequestProperty("accept","*/*");
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		httpURLConnection.setConnectTimeout(30000);
		httpURLConnection.setReadTimeout(30000);
		httpURLConnection.setInstanceFollowRedirects(true);

		if(header!=null){
			for (String key : header.keySet()) {
				httpURLConnection.setRequestProperty(key,header.get(key));
			}
		}
		if(charset==null){
			charset="utf-8";
		}
		httpURLConnection.connect();

		InputStreamReader in =new InputStreamReader(httpURLConnection.getInputStream(),charset);
		StringBuilder result=new StringBuilder();
		int line;
		while ((line=in.read()) != -1) {
			result.append((char)line);
		}
		in.close();
		System.out.println(result);
		return result.toString();
	}

	public static List<HttpCookie> getCookies(){
		List<HttpCookie> cookies = HttpTool.manager.getCookieStore().getCookies();
		for (HttpCookie cookie : cookies) {
			System.out.println(cookie);
		}
		return cookies;
	}

	public static File downloadFile(String url,String file_path)throws Exception{
		URL link_url=new URL(url);
		HttpURLConnection urlcn=(HttpURLConnection)link_url.openConnection();
		//urlcn.setInstanceFollowRedirects(true);
		urlcn.connect();
		int filelength = urlcn.getContentLength();
		int downlength=0;
		File file =  new File(file_path);
		if (file.exists())
		{
			file.delete();
		}
		file.getParentFile().mkdirs();
		file.createNewFile();
		OutputStream output = null;
		InputStream stream=new BufferedInputStream(urlcn.getInputStream());
		try
		{
			output = new FileOutputStream(file);
			final byte[] buffer = new byte[1024];
			int read;
			while ((read = stream.read(buffer)) != -1)
			{
				output.write(buffer, 0, read);
				downlength += read;
			}
			output.flush();
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		finally
		{
			try
			{
				output.close();
				stream.close();
				urlcn.disconnect();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return file;
	}

}
