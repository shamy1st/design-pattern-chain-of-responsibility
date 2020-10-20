package com.shamy1st;

import com.shamy1st.chainOfResponsibility.Authenticator;
import com.shamy1st.chainOfResponsibility.Compressor;
import com.shamy1st.chainOfResponsibility.HttpRequest;
import com.shamy1st.chainOfResponsibility.Logger;
import com.shamy1st.chainOfResponsibility.WebServer;

public class Main {

	public static void main(String[] args) {

		// Authenticator -> Logger -> Compressor
		Compressor compressor = new Compressor(null);
		Logger logger = new Logger(compressor);
		Authenticator authenticator = new Authenticator(logger);
		WebServer server = new WebServer(authenticator);
		server.handle(new HttpRequest("admin", "1234"));
	}

}
