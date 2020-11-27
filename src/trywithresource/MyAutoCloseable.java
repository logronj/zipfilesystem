package trywithresource;

import java.io.IOException;

public class MyAutoCloseable implements AutoCloseable{

	void saySomething() throws Exception {
		throw new IOException("something exception");
	}
	
	@Override
	public void close() throws Exception {
		throw new IOException("close exception");
	}

}
