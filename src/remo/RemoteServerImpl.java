package remo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RemoteServerImpl extends UnicastRemoteObject implements IRemoteServer {

	private static final long serialVersionUID = -3838498695374906017L;
	private List<IRemoteClient> userList = new ArrayList<IRemoteClient>();
	
	public RemoteServerImpl() throws RemoteException {
	}

	@Override
	public String login(IRemoteClient client, String userName) throws RemoteException {
		if(!userList.contains(client)) {
			userList.add(client);
		}
		for(IRemoteClient cli : userList) {
			cli.showName(userName + 1);
		}
		return userName + 1;
	}

}
