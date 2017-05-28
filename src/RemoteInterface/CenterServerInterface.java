package RemoteInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * design an interface
 * @author DanQiao
 *
 */
public interface CenterServerInterface extends Remote{
	public String createTRecord (String firstName, String lastName, String address, String phone, String specialization, String location) throws RemoteException;
	public String createSRecord (String firstName, String lastName,  String courseRegistered, String status, String statusDate) throws RemoteException;
	public String getRecordCounts() throws RemoteException;
	public String editRecord (String recordID, String fieldName, String newValue) throws RemoteException;
}
