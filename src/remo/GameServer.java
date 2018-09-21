package remo;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class GameServer {

	public static void main(String[] args) {
		try {
			Context namingContext = new InitialContext();
			IRemoteServer rmObj = new RemoteServerImpl();
			LocateRegistry.createRegistry(8888);
			namingContext.rebind("rmi://localhost:8888/RMObj", rmObj);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
