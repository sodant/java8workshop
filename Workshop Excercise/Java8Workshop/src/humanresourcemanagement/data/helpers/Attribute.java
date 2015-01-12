package humanresourcemanagement.data.helpers;

/**
 * Class representing an attribute for xml elements
 * @author Brendan
 *
 */
public class Attribute 
{
	private String attrName;
	private String attrValue;
	
	/**
	 * Cunstructor for setting the name and value of the attribute
	 * @param attrName Name of the attribute
	 * @param attrValue Value of the attribute
	 */
	public Attribute(String attrName, String attrValue)
	{
		setAttrName(attrName);
		setAttrValue(attrValue);
	}
	
	/**
	 * Setter for attrName
	 * @param attrName Name of the attribute
	 */
	public void setAttrName(String attrName)
	{
		this.attrName = attrName;
	}
	
	/**
	 * Setter for attrValue
	 * @param attrValue Value of the attribute
	 */
	public void setAttrValue(String attrValue)
	{
		this.attrValue = attrValue;
	}
	
	/**
	 * Getter for attrName
	 * @return Name of the attribute
	 */
	public String getAttrName()
	{
		return attrName;
	}
	
	/**
	 * Getter for attrValue
	 * @return Value of the attribute
	 */
	public String getAttrValue()
	{
		return attrValue;
	}
}
