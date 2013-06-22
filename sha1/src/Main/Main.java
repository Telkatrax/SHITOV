package Main;

import InterfaceSha1.InterfaceError;
import InterfaceSha1.InterfaceSha1;

public class Main   {
	public static void main(String[] args)  {
	
	try{	
		new InterfaceSha1();
	}
	catch(Exception e){new InterfaceError(e.getMessage());}
	
	}
	}
