/**
 * This reads Project Summary HML file
 * This is the base class
 * This class is inherited by SironaProjectSampleType class
 */
package workshop.panel.hml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * @author kazu
 * @version August 21 2018
 *
 */
@SuppressWarnings("restriction")
public class StaxProjectHMLReader {
	protected List<String> sampleList;
	protected Map<String, List<String>> sampleType;
	protected String dbVersion;

	/**
	 * 
	 */
	public StaxProjectHMLReader( String filePath ) {
		// TODO Auto-generated constructor stub
		sampleList = new ArrayList<String>();
		sampleType = new HashMap<String, List<String>>();
		read(filePath);
	}
	
	public void read(String  filepath) {
		try {
			FileInputStream fileInputStream = new FileInputStream(filepath);
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(fileInputStream);
			
			while (xmlStreamReader.hasNext()) {
				readSampleList(xmlStreamReader);
			}
			xmlStreamReader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	private void readSampleList(XMLStreamReader reader) throws XMLStreamException {
		int eventCode = reader.next();
		switch (eventCode) {
		case XMLStreamReader.START_ELEMENT:
			String key = reader.getLocalName();
			if (key.equals("sample")) {
				readSample(reader);
			}
			break;
		}
	}
	
	private void readSample(XMLStreamReader reader) throws XMLStreamException {
		String name = "";
		String value = "";		
		
		String avalue = reader.getAttributeValue(0);
		String sample = avalue;
		sampleList.add(sample);
		List<String> list = new ArrayList<String>();
		
		while (reader.hasNext()) {			
			int eventCode = reader.next();
			switch (eventCode) {
			case XMLStreamReader.START_ELEMENT:
				name = reader.getLocalName();
				if (name.equals("allele-assignment")) {
					dbVersion = reader.getAttributeValue(1);
				}
				break;
			case XMLStreamReader.END_ELEMENT:
				name = reader.getLocalName();
				if (name.equals("sample")) {
					sampleType.put(sample, list);
					return;
				}
				break;
			case XMLStreamReader.CHARACTERS:
				value = reader.getText();
				if (name.equals("glstring")) {
					String tmp = value.replaceAll("\\s+", "");	// remove any white space
					if (tmp.length() != 0) {
						list.add(tmp);
//						System.out.println(tmp);
					}				
				}
				break;
			}
		}
		return;
	}
	
	public List<String> getSampleList() {
		return sampleList;
	}
	
	public Map<String, List<String>> getSampleType() {
		return sampleType;
	}
	
	public String getDBversion() {
		return dbVersion;
	}

}
