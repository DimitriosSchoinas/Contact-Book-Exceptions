package cbook;


import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class ContactBookInList implements ContactBook {
	/**
	 * Coleccao de contactos.
	 */
	private List<Contact> contacts;
	
	/**
	 * Construtor por omissao
	 */
	public ContactBookInList() {
		contacts = new LinkedList<Contact>();
	}

	@Override 
	public boolean hasContact(String name) {
		return this.getContact(name) != null;
	}

	@Override 
	public int getNumberOfContacts() {
		return contacts.size();
	}
	@Override
	public boolean isValidPhone(String phone) {
		
		boolean result = true;
		String phoneString = phone;
		
		for(int i = 0; i < phoneString.length(); i++) {
			if(phoneString.charAt(i) > 57 || phoneString.charAt(i) < 47) {
				result = false;
			}
		}
		return result;
	}

	@Override 
	public void addContact(String name, String phone, String email) throws SameContactException,InvalidPhoneNumberException{
	
		if(isValidPhone(phone) == false)
			throw new InvalidPhoneNumberException();
		
		if(hasContact(name)) 
			throw new SameContactException();
		
		
		contacts.add(new ContactClass(name, phone, email));
	}

	@Override 
	public void deleteContact(String name) throws InexistentContactException{
		// Uma alternativa seria o seguinte codigo:
		// Contact c = this.getContact(name);
		// contacts.remove(c);
		// mas esta solucao involve duas procuras na lista
		
		// A solucao seguinte exige que exista o metodo equals(Object o) 
		// implementado na ContactClass e um construtor que receba como
		// como argumento apenas o name
		
		if(hasContact(name) == false) 
			throw new InexistentContactException();
		
		contacts.remove(new ContactClass(name));
	}

	@Override 
	public String getPhone(String name) throws InexistentContactException{
		
		if(hasContact(name) == false) {
			throw new InexistentContactException();
		}
		
		return this.getContact(name).getPhone();
	}

	@Override 
	public String getEmail(String name) throws InexistentContactException{
		
		if(hasContact(name) == false) {
			throw new InexistentContactException();
		}
		return this.getContact(name).getEmail();
	}
	
	

	@Override 
	public void setPhone(String name, String phone) throws InexistentContactException, InvalidPhoneNumberException{
		
		if(isValidPhone(phone) == false) {
			throw new InvalidPhoneNumberException();
		}
		if(hasContact(name) == false) {
			throw new InexistentContactException();
		}
		this.getContact(name).setPhone(phone);
	}

	@Override 
	public void setEmail(String name, String email) throws InexistentContactException{
		
		if(hasContact(name) == false) {
			throw new InexistentContactException();
		}
		this.getContact(name).setEmail(email);
	}

	@Override 
	public Iterator<Contact> listContacts() throws EmptyBookException{
		
		if(contacts.size() == 0) {
			throw new EmptyBookException();
		}
		return contacts.iterator();
	}
	
	/**
	 * @param name nome do contacto a procurar na lista
	 * @return o contacto com nome <code>name</code> caso exista,
	 * 			<code>null</code> caso contrario
	 */
	private Contact getContact(String name) {
		for (Contact c: contacts)
			if (c.getName().equals(name))
				return c;
		return null;
	}

	
}
