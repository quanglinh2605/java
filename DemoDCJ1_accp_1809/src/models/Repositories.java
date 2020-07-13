package models;

public class Repositories {
	private dsvattu lsvattu = new dsvattu();

	public void setfield(dsvattu value) {
		lsvattu = value;
	}

	public dsvattu getfield() {
		return lsvattu;
	}

	public void createVT(vattu newItem) {
		ConnectionSQL myconn = new ConnectionSQL();
		myconn.Connect();
		String str = "insert into vattu values(?,?,?,?)";
		String[] parameters = { newItem.gettenVT(), newItem.getdvt(), String.valueOf(newItem.getgia()),
				String.valueOf(newItem.getslton()) };
		myconn.Create(str, parameters);
	}

	public static boolean demo() {
		return true;
	}
}
