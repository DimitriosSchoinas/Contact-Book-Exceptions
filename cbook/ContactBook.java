package cbook;

import java.util.Iterator;

public interface ContactBook {

	/**
	 * Verifica se ja existe um contacto com o nome dado
	 * @param name indica o nome do contacto 
	 * @return <code>true</code> se o contacto com nome <code>name</code> existe,
	 * 			<code>false</code> caso contrario
	 */
	boolean hasContact(String name);

	/**
	 * Devolve o numero de contactos
	 * @return o numero de contactos
	 */
	public int getNumberOfContacts();

	/**
	 * Adiciona um novo contacto 'a agenda
	 * @param name indica o nome do contacto 
	 * @param phone indica o numero de telefone do contacto
	 * @param email indica o email do contacto
	 * @throws SameContactException 
	 * @pre !hasContact(name)
	 */
	void addContact(String name, String phone, String email) throws SameContactException,InvalidPhoneNumberException;

	/**
	 * Remove um contacto dado o  nome
	 * @param name indica o nome do contacto a remover
	 * @pre hasContact(name)
	 */
	void deleteContact(String name) throws InexistentContactException;

	/**
	 * Consulta o numero de telefone de um contacto dado o seu nome
	 * @param name indica o nome do contacto a consultar o telefone
	 * @return o numero de telefone do contacto associado ao nome dado
	 * @pre hasContact(name)
	 */
	String getPhone(String name)throws InexistentContactException;

	/**
	 * Consulta o email de um contacto dado o seu nome
	 * @param name indica o nome do contacto a consultar o telefone
	 * @return o email do contacto associado ao nome dado
	 * @pre hasContact(name)
	 */
	String getEmail(String name) throws InexistentContactException;

	/**
	 * Altera o telefone de um dado contacto
	 * @param name indica o nome do contacto a moficar o telefone
	 * @param phone indica o novo numero de telefone
	 * @pre hasContact(name)
	 */
	void setPhone(String name, String phone)throws InexistentContactException, InvalidPhoneNumberException;
	
	/**
	 * Altera o email de um dado contacto
	 * @param name indica o nome do contacto a moficar o email
	 * @param email indica o novo email
	 * @pre hasContact(name)
	 */
	void setEmail(String name, String email)throws InexistentContactException;

	/**
	 * Devolve um iterador para os contactos
	 * @return um iterador para os contactos 
	 */
	Iterator<Contact> listContacts() throws EmptyBookException;
	
	boolean isValidPhone(String phone);
	
}
