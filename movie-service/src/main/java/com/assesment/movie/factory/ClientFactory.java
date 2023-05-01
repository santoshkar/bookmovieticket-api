package com.assesment.movie.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.movie.clients.IClient;
import com.assesment.movie.clients.MirajClient;
import com.assesment.movie.clients.PVRClient;
import com.assesment.movie.clients.PrasadClient;

@Service
public class ClientFactory {

	@Autowired
	private PrasadClient prasadClient;

	@Autowired
	private PVRClient pvrClient;

	@Autowired
	private MirajClient mirajClient;

	public IClient getClientApiByClientName(String client) {
		client = client.toLowerCase();
		IClient iClient = null;
		switch (client) {
		case "prasad":
			iClient = prasadClient;
			break;
		case "miraj":
			iClient = mirajClient;
			break;
		case "pvr":
			iClient = pvrClient;
			break;
		}

		return iClient;
	}

	public List<String> getClientNames() {
		return new ArrayList<String>() {
			private static final long serialVersionUID = -8719431114688046909L;
			{
				add("PVR");
				add("Prasad");
				add("Miraj");
			}
		};
	}

}
