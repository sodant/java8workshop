package humanresourcemanagement.data.helpers;

import java.io.File;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Class for general editing of xml files
 * @author Brendan
 */
public class XMLDocument 
{
	Document doc;
	
	/**
	 * Constructor that initializes an instant of org.w3c.dom.Document bases on an existing xml file
    * @param filePath	Location where the xml file to be edited is located 
    */
	public XMLDocument(File filePath)
	{
		try
		{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.parse(filePath);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns a list of all elements in the xml file with the same name as the passed string
    * @param elementName	Name of the element that is being searched in the xml file
    * @return The nodelist of matching elements
    */
	public NodeList getElementsByName(String elementName)
	{
		return doc.getElementsByTagName(elementName);
	}
	
	/**
	 * Returns a list of all elements in the xml file with the same name as the passed string within the given element
	 * @param elem	the element which will be searched for matching elements
	 * @param elementName	Name of the element that is being searched within the given element
	 * @return The nodelist of matching elements
	 */
	public NodeList getElementsByName(Element elem, String elementName)
	{
		return elem.getElementsByTagName(elementName);
	}
	
	/**
	 * Returns an element within the xml file that matches the given name and attribute value(s)
	 * @param elementName The name of the element to be found in the xml
	 * @param attributes One or multiple attributes to be compared in the xml file
	 * @return The correct element
	 */
	public Element getElementByAttribute(String elementName, Attribute... attributes)
	{
		NodeList nl = getElementsByName(elementName);
		Stream<Node> nodeStream = IntStream.range(0, nl.getLength())
                .mapToObj(nl::item);
		return (Element) nodeStream.filter(
				elem -> Stream.of(attributes).allMatch(
						att -> matchAttribute(elem, att)))
						.findFirst().get();	
	}
	
	private boolean matchAttribute(Node e, Attribute attribute)
	{
		Optional<Node> n = Optional.ofNullable(e.getAttributes().getNamedItem(attribute.getAttrName()));
		if(n.isPresent())//Attribute exists, check if it matches the parameter
		{
			String s = n.get().getNodeValue();
			boolean x = s.equals(attribute.getAttrValue());
			return  x;
		}
		else //Attribute doesn't exist, return false
		{
			return false;
		}
	}
	
	/**
	 * Add an element to an existing element and returns the new element
	 * @param parent The element the new element is to be added to
	 * @param childName The name of the new element
	 * @return The new element
	 */
	public Element addElement(Element parent, String childName)
	{
		Element newElement = doc.createElement(childName);
		parent.appendChild(newElement);
		return newElement;
	}
	
	/**
	 * Add text to an existing element
	 * @param parent The element the text is to be added to
	 * @param text The text to be added
	 */
	public  void addTextToElement(Element parent, String text)
	{
		parent.appendChild(doc.createTextNode(text));
	}
	
	/**
	 * Edit an existing text of an element
	 * @param parent The element whose text is to be changed
	 * @param text The text to be added in place of the existing text
	 */
	public void editTextValue(Element parent, String text)
	{
		parent.setTextContent(text);
	}
	
	/**
	 * Add an attribute to an existing element
	 * @param parent The element the attribute is to be added to
	 * @param newAttribute The new attribute to be added
	 */
	public void addAttributeToElement(Element parent, Attribute newAttribute)
	{
		Attr attribute = doc.createAttribute(newAttribute.getAttrName());
		attribute.setNodeValue(newAttribute.getAttrValue());
		parent.setAttributeNode(attribute);
	}
	
	/**
	 * Edit an attribute of an existing element
	 * @param parent The Element whose attribute value is to be changed
	 * @param newAttribute The attribute with the updated attribute value
	 */
	public void editAttributeValue(Element parent, Attribute newAttribute)
	{
		Attr attribute = parent.getAttributeNode(newAttribute.getAttrName());
		attribute.setNodeValue(newAttribute.getAttrValue());
	}
	
	public String getAttributeValue(Element parent, String name)
	{
		Attr attribute = parent.getAttributeNode(name);
		return attribute.getNodeValue();		
	}
	
	/**
	 * Save the editted xml file to a certain location
	 * @param filePath The location where the xml file will be saved
	 * @param fileName The desired name of the new xml file
	 */
	public void saveDocument(String filePath, String fileName)
	{
		try
		{
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filePath+fileName));
			transformer.transform(source, result);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	

}



