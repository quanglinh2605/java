package Helper;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FileHelper {
	public static String getConnectionString(String Path) {
		try {
			String data = "";
			File fxmlFile = new File(Path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fxmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("connectionString");
			Node nNode = nList.item(0);
			data = nNode.getTextContent();
			return data;
		} catch (Exception e) {

		}
		return null;
	}
}
