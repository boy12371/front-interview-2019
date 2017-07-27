package package1;

import java.util.Scanner;

public class ManagerController {
	
	private ManagerModel muser;
	private ManagerView view;
	
	
	private Message message;
	
	
	
	

	


	public ManagerController() {
		muser=new ManagerModel();
	}

	public ManagerController(ManagerModel model, ManagerView view, Message message) {
		super();
		this.muser = model;
		this.view = view;
	
		this.message = message;
	}

	public ManagerModel getModel() {
		return muser;
	}

	public void setModel(ManagerModel model) {
		this.muser = model;
	}

	public ManagerView getView() {
		return view;
	}

	public void setView(ManagerView view) {
		this.view = view;
	}



	

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	

	public void updateView() {
		
	}
public void deletUser() {
		
	}
public void deletMessage() {
	
}



public int register(String account,String password)
{
	 return  this.muser.register(account,password);
}
public int login(String account,String password)
{
	 return  this.muser.login(account,password);
}

	
}