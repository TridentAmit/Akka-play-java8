
package com.metlife.gsp.colombia.batch;





import java.io.IOException;

import java.net.URI;

import java.net.URISyntaxException;

import java.security.KeyManagementException;

import java.security.KeyStoreException;

import java.security.NoSuchAlgorithmException;

import java.security.SecureRandom;

import java.util.List;



import javax.net.ssl.SSLContext;



import org.apache.http.Header;

import org.apache.http.HttpEntity;

import org.apache.http.client.ClientProtocolException;

import org.apache.http.client.CookieStore;

import org.apache.http.client.methods.CloseableHttpResponse;

import org.apache.http.client.methods.HttpGet;

import org.apache.http.client.methods.HttpUriRequest;

import org.apache.http.client.methods.RequestBuilder;

import org.apache.http.client.protocol.HttpClientContext;

import org.apache.http.conn.ssl.NoopHostnameVerifier;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;

import org.apache.http.ssl.SSLContexts;

import org.apache.http.conn.ssl.TrustSelfSignedStrategy;

import org.apache.http.cookie.Cookie;

import org.apache.http.impl.client.BasicCookieStore;

import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClientBuilder;

import org.apache.http.impl.client.HttpClients;

import org.apache.http.impl.client.LaxRedirectStrategy;

import org.apache.http.impl.cookie.BasicClientCookie;

import org.apache.http.util.EntityUtils;



public class SiteminderConnection {



	private static final String PASSWORD = "metlife1";

	private static final String USER_NAME = "4000006";



	private static final String SITEMINDER_LOGIN_URL = "https://int.salespilot.metlife.com.co/";

	//private static final String SITEMINDER_LOGIN_URL = "https://ssologin-dev.metlife.com/siteminderagent/forms/ldap/verify.fcc";

	//private static final String SITEMINDER_LOGIN_URL = "https://int.salespilot.metlife.com.co/siteminderagent/forms/login.fcc";

	

	private static final String SITEMINDER_PROTECTED_RESOURCE = "https://int.salespilot.metlife.com.co/GSP-Rest/public/cancelApps";

	//private static final String SITEMINDER_PROTECTED_RESOURCE = "https://int.salespilot.metlife.com.co/public/keepalive.jsp";

	

	



	public static void main(String[] args) throws Exception {



		BasicCookieStore cookieStore = buildBasicCookieStore();

		SSLContext sslcontext = buildSSLContext();

		SSLConnectionSocketFactory sslsf = buildSSLConnectionSocketFactory(sslcontext);

		CloseableHttpClient httpclient = buildHttpClient(cookieStore, sslsf);



		try {



			String nextLocation = executeLogin(cookieStore, httpclient);



			// Result should be "Proceso de cancelacion automatica de la solicitud completado." and not the login page

			accessProtectedResource(httpclient, nextLocation); 



		} finally {

			httpclient.close();

		}

	}

	

	private static BasicCookieStore buildBasicCookieStore() {

		

		BasicCookieStore cookieStore = new BasicCookieStore();

		String strCookie = "__g_c=c%3A191724312155210%7Cd%3A0%7Ca%3A0%7Cb%3A2%7Ce%3A0%7Cf%3A1%7Ch%3A1; __g_u=191724312155210_0; ";

		String[] cookies = strCookie.split(";");



		for (String item : cookies) {

			String[] keyValue = item.split("=");

			if (keyValue.length == 2) {

                BasicClientCookie cookie = new BasicClientCookie(keyValue[0].trim(), keyValue[1].trim());

                cookieStore.addCookie(cookie);				

			}

		}

		return cookieStore;

	}



	private static SSLContext buildSSLContext() throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {

		SSLContext sslcontext = SSLContexts.custom()

				.setSecureRandom(new SecureRandom())

				.loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();

		return sslcontext;

	}



	private static SSLConnectionSocketFactory buildSSLConnectionSocketFactory(SSLContext sslcontext) {

		//SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, NoopHostnameVerifier.INSTANCE);

		return sslsf;

	}



	private static CloseableHttpClient buildHttpClient(BasicCookieStore cookieStore, SSLConnectionSocketFactory sslsf) {

		

		//HttpClientBuilder builder = HttpClients.custom();

		

		CloseableHttpClient httpclient = HttpClients.custom()

				.setSSLSocketFactory(sslsf)

				.setDefaultCookieStore(cookieStore)

				.setRedirectStrategy(new LaxRedirectStrategy())

				.build();

		

		return httpclient;

	}



	private static String executeLogin(BasicCookieStore cookieStore,

			CloseableHttpClient httpclient) throws URISyntaxException,

			IOException, ClientProtocolException {



		HttpUriRequest loginPost = createPostRequest();



		System.out.println("\n-------------------------Pre logon cookies-------------------------");

		System.out.println();

		displayCookies(cookieStore);



		System.out.println("\n------------------------- Login to SiteMinder -------------------------");

		System.out.println("*** Will submit request to: " + loginPost.getRequestLine() + "\n");

		

		HttpClientContext httpClientContext = new HttpClientContext();



		CloseableHttpResponse loginResponse = httpclient.execute(loginPost,httpClientContext);

		String nexLocation;

		

		try {

			HttpEntity loginResponseEntity = loginResponse.getEntity();



			System.out.println("*** Login form POST result: " + loginResponse.getStatusLine());

			EntityUtils.consume(loginResponseEntity);

			System.out.println();



			System.out.println("\n-------------------------Post logon cookies-------------------------");

			System.out.println();

			displayCookies(cookieStore);

			System.out.println();



			System.out.println("\n-------------------------Post cookies from HttpClientContext-------------------------");

			System.out.println();

			displayCookies(httpClientContext.getCookieStore());

			System.out.println();



			System.out.println("------------------------- Login Post Headers -------------------------");

			displayHeaders(loginResponse);



			System.out.println();



			nexLocation = SITEMINDER_PROTECTED_RESOURCE;

		} finally {

			loginResponse.close();

		}



		return nexLocation;

	}

	

	private static HttpUriRequest createPostRequest() throws URISyntaxException {

		HttpUriRequest postRequest = RequestBuilder.post().setUri(new URI(SITEMINDER_LOGIN_URL))

				.addParameter("flowExecUrl", "")

				.addParameter("language", "es_CO")

				.addParameter("target", "/sales/j_spring_security_check?CN='COL'")

				.addParameter("smauthreason", "0")

				.addParameter("SMENC", "ISO-8859-1")

				.addParameter("SMLOCALE", "US-EN")

				.addParameter("smquerydata", "")

				.addParameter("smagentname", "jEjP9krCRpY9+Ec0fh6uxRSqvQvieAvPci/9dokW7prhGomfP2c+PluD/8POgpGG1dIVzVtxyfhV7mh+VKJM3fZPP8PUIkKJ")

				.addParameter("postpreservationdata", "")

				.addParameter("authFailMsg", "")

				.addParameter("CN", "COL")

				.addParameter("USER", USER_NAME)

				.addParameter("PASSWORD", PASSWORD).build();

		

		postRequest.addHeader("Accept", "text/html, application/xhtml+xml, */*");

		postRequest.addHeader("Referer", "https://int.salespilot.metlife.com.co/siteminderagent/forms/login.fcc?TYPE=33554433&REALMOID=06-0003cc6c-369a-1848-a07d-e417ac18a05e&GUID=&SMAUTHREASON=0&METHOD=GET&SMAGENTNAME=$SM$jEjP9krCRpY9%2bEc0fh6uxRSqvQvieAvPci%2f9dokW7prhGomfP2c%2bPluD%2f8POgpGG1dIVzVtxyfhV7mh%2bVKJM3fZPP8PUIkKJ&TARGET=$SM$%2f");

		postRequest.addHeader("Accept-Language", "en-US");

		postRequest.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko");

		postRequest.addHeader("Content-Type", "application/x-www-form-urlencoded");

		postRequest.addHeader("Accept-Encoding", "gzip, deflate");

		postRequest.addHeader("Host", "int.salespilot.metlife.com.co");

		postRequest.addHeader("Connection", "Keep-Alive");

		postRequest.addHeader("Cache-Control", "no-cache");



		return postRequest;

	}



	private static void accessProtectedResource(CloseableHttpClient httpclient, String nextLocation) throws IOException, ClientProtocolException {

		HttpGet appGet = new HttpGet(nextLocation);



		System.out.println("\n------------------------- Accessing a web resource -------------------------");

		System.out.println("\n*** Access resource: " + appGet.getRequestLine());



		CloseableHttpResponse response = httpclient.execute(appGet);

		try {

			HttpEntity entity = response.getEntity();



			System.out.println("*** Access resource result: " + response.getStatusLine());

			System.out.println("\n\n------------------Show page source---------------------- \n\n");



			System.out.println(EntityUtils.toString(entity));

			EntityUtils.consume(entity);



		} finally {

			response.close();

		}

	}

	

	private static void displayHeaders(CloseableHttpResponse loginResponse) {

		for (Header header : loginResponse.getAllHeaders()) {

			System.out.println(header);

		}

	}



	private static void displayCookies(CookieStore cookieStore) {

		List<Cookie> cookies = cookieStore.getCookies();

		if (cookies.isEmpty()) {

			System.out.println("None");

		} else {

			for (int i = 0; i < cookies.size(); i++) {

				System.out.println("- " + cookies.get(i).toString());

			}

		}

	}

	

}
