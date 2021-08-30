package javaIntro_6_Task_3;

import java.util.List;
import java.util.ArrayList;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

public class XmlArchive {
	
	private static final File xmlFile = new File("src/files","archive.xml");
	private static Document xmlDocument;
	protected static List<Student> studentList = new ArrayList<>();
	
	public static void main(String[] args) {
       
		if (xmlFile.exists()) {
			readXml();
		}
		else {
			createXml();
		}
	}
	
	public static void createXml() {
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);			
			xmlDocument = factory.newDocumentBuilder().newDocument();
			
			Element root = xmlDocument.createElement("students");
			xmlDocument.appendChild(root);
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			transformer.transform(new DOMSource(xmlDocument), new StreamResult(xmlFile));
		} catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static void readXml() {
        
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			xmlDocument = factory.newDocumentBuilder().parse(xmlFile);
			xmlDocument.getDocumentElement().normalize();
	        
	        NodeList studentElements = xmlDocument.getDocumentElement().getElementsByTagName("student");

	        for (int i = 0; i < studentElements.getLength(); i++) {
		    	NamedNodeMap nnm = studentElements.item(i).getAttributes();
			    Student s = extractStudent(studentElements.item(i));
			    s.setId(Integer.parseInt(nnm.getNamedItem("id").getNodeValue()));
	        	studentList.add(s);
	        }
		} catch (Exception e) {
            e.printStackTrace();
        }		
	}
	
    private static Student extractStudent(Node node) {
        Student student = new Student();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            student.setName(getTagValue("name", element));
            student.setBirthDate(getTagValue("birthDate", element));
            student.SetGroup(getTagValue("group", element));
        }
        return student;
    }
    
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
	
    public static void writeXml(Student student, String flag) {
        
    	try {

	        if (flag.equals("a")) {
		        addNode(student);
	        }
	        else if (flag.equals("u")) {
	        	updateNode(student);
	        }
	                
	        xmlDocument.getDocumentElement().normalize();
	        
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			Element root = xmlDocument.getDocumentElement();
			NodeList rootChild = root.getChildNodes();
			for (int i = 0; i < rootChild.getLength(); i++) {
				if (rootChild.item(i).getChildNodes().getLength() == 0) {
					root.removeChild(rootChild.item(i));
				}
			}
			
			NodeList studentList = xmlDocument.getDocumentElement().getElementsByTagName("student");
			for (int i = 0; i < studentList.getLength(); i++) {
				NodeList studentChild = studentList.item(i).getChildNodes();
				for (int j = 0; j < studentChild.getLength(); j++) {
					if (studentChild.item(j).getNodeType() != 1) {
						studentList.item(i).removeChild(studentChild.item(j));
					}				
				}
			}

			transformer.transform(new DOMSource(xmlDocument), new StreamResult(xmlFile));
	        
    	} catch (Exception e) {
            e.printStackTrace();
    	}	
    }
	
	public static void addStudent(Student student) {
		studentList.add(student);
		writeXml(student, "a");
	}
	
	public static void editStudent(String[] str) {
		
		boolean blank = true;
		
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId() == Integer.parseInt(str[0])) {
				if (!str[1].isBlank()) {
					studentList.get(i).setName(str[1].trim());
					blank = false;
				}
				
				if (!str[2].isBlank()) {
					studentList.get(i).setBirthDate(str[2].trim());
					blank = false;
				}
				
				if (!str[3].isBlank()) {
					studentList.get(i).SetGroup(str[3].trim());
					blank = false;
				}
				
				if (blank) {
					break;
				}
				else {
					writeXml(studentList.get(i), "e");
					break;
				}
			}
		}
	}

    public static void addNode(Student student) {  	
    	xmlDocument.getDocumentElement().appendChild(getStudentNode(student));   	       
    }
    
    private static Node getStudentNode(Student student) {
        
    	Element studentElement = xmlDocument.createElement("student");
    	studentElement.setAttribute("id", String.valueOf(student.getId()));
    	studentElement.appendChild(getStudentElement(studentElement, "name", student.getName()));
    	studentElement.appendChild(getStudentElement(studentElement, "birthDate", student.getBirthDate())); 
    	studentElement.appendChild(getStudentElement(studentElement, "group", student.getGroup())); 
    	studentElement.normalize();
    	
        return studentElement;   
    }
    
    private static Node getStudentElement(Element element, String name, String value) {
        Element node = xmlDocument.createElement(name);
        node.appendChild(xmlDocument.createTextNode(value));
        return node;
    }
    
    public static void updateNode(Student student) {
		
    	Element root = xmlDocument.getDocumentElement();
		NodeList rootChild = root.getElementsByTagName("student");
		for (int i = 0; i < rootChild.getLength(); i++) {
			NamedNodeMap nnm = rootChild.item(i).getAttributes();
			if (nnm.getNamedItem("id").getNodeValue().equals(String.valueOf(student.getId()))) {
				Element studentElement = (Element) rootChild.item(i);
				Node name = studentElement.getElementsByTagName("name").item(0).getFirstChild();
				name.setNodeValue(student.getName());
				Node birthDate = studentElement.getElementsByTagName("birthDate").item(0).getFirstChild();
				birthDate.setNodeValue(student.getBirthDate());
				Node group = studentElement.getElementsByTagName("group").item(0).getFirstChild();
				group.setNodeValue(student.getGroup());
				break;
			}
		}
    }
    
}
