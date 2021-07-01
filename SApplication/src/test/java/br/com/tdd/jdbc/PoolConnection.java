package br.com.tdd.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class PoolConnection {

	private static final String URI = null;

	/*
	 * private void servletCode() throws Exception{ HttpClient httpClient =
	 * HttpClients.custom() .setConnectionTimeToLive(20, TimeUnit.SECONDS)
	 * .setMaxConnTotal(400).setMaxConnPerRoute(400)
	 * .setDefaultRequestConfig(RequestConfig.custom()
	 * .setSocketTimeout(30000).setConnectTimeout(5000).build())
	 * .setRetryHandler(new DefaultHttpRequestRetryHandler(5, true)) .build(); //
	 * the httpClient should be re-used because it is pooled and thread-safe.
	 * 
	 * HttpGet request = new HttpGet(uri); HttpResponse response =
	 * httpClient.execute(request); reader = new BufferedReader(new
	 * InputStreamReader(response.getEntity().getContent())); // handle response ...
	 * }
	 */
	private void pool() throws IOException {

		BufferedReader reader;
		try {
			URL url = new URL(URI);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
		} catch (MalformedURLException e) {
			throw new IOException("Expecting a well-formed URL: " + e);
		}

		String buffer;
		StringBuilder result = new StringBuilder();
		while (null != (buffer = reader.readLine())) {
			result.append(buffer);
		}
		reader.close();

	}

}
