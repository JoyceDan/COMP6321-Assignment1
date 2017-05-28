package Server_MTL;

import java.rmi.RemoteException;

import RemoteInterface.CenterServerInterface;

public class Server_MTL implements CenterServerInterface{

	@Override
	public String createTRecord(String firstName, String lastName, String address, String phone, String specialization,
			String location) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createSRecord(String firstName, String lastName, String courseRegistered, String status,
			String statusDate) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRecordCounts() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editRecord(String recordID, String fieldName, String newValue) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
