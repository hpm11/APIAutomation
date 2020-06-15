package maven.demo.RestAssuredAuto;

import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Scanner;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
//import groovy.util.NodeList;

public class CommonApiHelper {
	
	
	
	public static HashMap<String,String> getResponse(String Url,String ContentType) throws Exception{
		
		HashMap <String,String> result = new HashMap<String, String>();
		Properties configproperties = Config.loadConfigFile("");
		
		return result;
		
	}
	
	// Convert the Json API Response to HashMap/
	
	public TreeMap<Integer,TreeMap<String , HashMap>> JsonToHashMap(String JsonPath, String strNodeName, String[] arrAccount)throws Exception{
		
		TreeMap<Integer,TreeMap<String , HashMap>> convertedResponse = new TreeMap<>();
		try{
			String strResBody =  getTextContent(JsonPath);
			JSONObject json = (JSONObject)JSONValue.parse(strResBody);
			JSONArray elements = (JSONArray) json.get(strNodeName);
			for(int i=0;i<elements.size();i++){
				JSONObject element = (JSONObject) elements.get(i);
				TreeMap map = new TreeMap();
				String key="";
				for(int b=0;b<arrAccount.length;b++){
					for(Entry entry : element.entrySet()){
						if(entry.getKey().equals(arrAccount[b])){
							if(entry.getValue() != null  || entry.getValue()!=" " ){
								map.put(entry.getKey(), entry.getValue());
							}else{
								map.put(entry.getKey(), " ");
							}
						}
					}
					
				}
				
			//	map = (TreeMap)convertToTreeMapSortByValues(map);
				convertedResponse.put(i, map);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return convertedResponse;
	}
	
	public String getTextContent(String textpath){
		String strFileData = "";
		File myObj = new File(textpath);
		Scanner myReader;
		try{
			myReader =  new Scanner(myObj);
			while(myReader.hasNextLine()){
				if (strFileData.length()>0){
					strFileData = strFileData+myReader.nextLine();
				}else{
					strFileData = myReader.nextLine();
					
				}
				
				
			}
			myReader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return strFileData;
	}
	
	// Convert API XML Respose to Hashmap 
	public TreeMap<Integer,TreeMap<String , HashMap>> XMLToHashMap (String XmlPath, String strNodeName, String[] arrAccount) throws Exception{
		TreeMap<Integer,TreeMap<String , HashMap>> convertedResponse = new TreeMap<>();
		HashMap result = new HashMap();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(XmlPath));
			//Normalize the xml structure it is imp
			document.getDocumentElement().normalize();
			//here comes the root node
			Element root = document.getDocumentElement();
			//get all the details
			NodeList nlist = document.getElementsByTagName(strNodeName);
			for(int temp =0; temp<nlist.getLength(); temp++){
				TreeMap map = new TreeMap();
				Node node = nlist.item(temp);
				if (node.getNodeType() == Node.ELEMENT_NODE){
					//print each employees details
					Element eElement = (Element)node;
				for(int a=0;a<arrAccount.length;a++){
					if(arrAccount[a].length()>0){
						map.put(arrAccount[a], eElement.getElementsByTagName(arrAccount[a]).item(0).getTextContent());
						if(eElement.getElementsByTagName(arrAccount[a]).item(0).getTextContent().length()>0){
							map.put(arrAccount[a], eElement.getElementsByTagName(arrAccount[a]).item(0).getTextContent());
						}else{
							map.put(arrAccount[a], " ");
						}
						
					}
				}
				}
				convertedResponse.put(temp, map);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return convertedResponse;
	}
	
	//get API JSON Count
	
	public String JsonToElement(String strResBody, String strNodeName){
		JSONObject json = (JSONObject) JSONValue.parse(strResBody);
		String eleVel = ""+json.get(strNodeName);
		return eleVel;
		
	}
	
	// get API XML Count
	
	public Integer XMLToElement (String xmlFile,String strNodeName)throws Exception {
		HashMap convertedRes = new HashMap();
		int intCount=0;
		HashMap result = new HashMap();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(xmlFile));
			//Normalize the xml structure 
			document.getDocumentElement().normalize();
			// here comes the root node
			Element root = document.getDocumentElement();
			//Get All Account Details
			NodeList nlist = document.getElementsByTagName("DataResponse");
			for(int temp =0; temp<nlist.getLength(); temp++){
				TreeMap map = new TreeMap();
				Node node = nlist.item(temp);
				if (node.getNodeType() == Node.ELEMENT_NODE){
					//print each employees details
					Element eElement = (Element)node;
					
					intCount = Integer.parseInt(eElement.getElementsByTagName(strNodeName).item(0).getTextContent());
					
		}
				
	}

	
	
}catch (ParserConfigurationException e){
	e.printStackTrace();
}
	return 	intCount;
	
	}
	
	}
