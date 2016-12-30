package com.casosemergencias.logic.ws.handlers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;

import javax.annotation.Resource;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.log4j.Logger;

import com.casosemergencias.util.constants.ConstantesTibcoWS;

@Resource
public class TibcoRequestsSOAPHandler implements SOAPHandler<SOAPMessageContext> {
	final static Logger logger = Logger.getLogger(TibcoRequestsSOAPHandler.class);

	private String username;
	private String password;
	
	@Override
	public boolean handleMessage(SOAPMessageContext soapMessageContext) {		
		try {
			logger.trace("-- Inicio -- handleMessage()");
			SOAPMessage soapMessage = soapMessageContext.getMessage();
			SOAPHeader soapHeader = soapMessage.getSOAPHeader();
			SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
			
			if (soapHeader == null) {
				soapHeader = soapEnvelope.addHeader();
			}

			QName qNameSecurity = new QName(ConstantesTibcoWS.XMLNS_WSSE_XSD, ConstantesTibcoWS.SOAP_WSS_HEADER_NODE_SECURITY);
			SOAPHeaderElement securityNode = soapHeader.addHeaderElement(qNameSecurity);
			securityNode.addNamespaceDeclaration(ConstantesTibcoWS.XMLNS_WSSE_NS, ConstantesTibcoWS.XMLNS_WSSE_XSD);
			securityNode.addNamespaceDeclaration(ConstantesTibcoWS.XMLNS_WSU_NS, ConstantesTibcoWS.XMLNS_WSU_XSD);
			
			QName qNameUserToken = new QName(ConstantesTibcoWS.XMLNS_WSSE_XSD, ConstantesTibcoWS.SOAP_WSS_HEADER_NODE_USERNAMETOKEN);
			SOAPHeaderElement usernameTokenNode = soapHeader.addHeaderElement(qNameUserToken);

			QName qNameUsername = new QName(ConstantesTibcoWS.XMLNS_WSSE_XSD, ConstantesTibcoWS.SOAP_WSS_HEADER_NODE_USERNAME);
			SOAPHeaderElement usernameNode = soapHeader.addHeaderElement(qNameUsername);
			usernameNode.addTextNode(username);

			QName qNamePassword = new QName(ConstantesTibcoWS.XMLNS_WSSE_XSD, ConstantesTibcoWS.SOAP_WSS_HEADER_NODE_PASSWORD);
			SOAPHeaderElement passwordNode = soapHeader.addHeaderElement(qNamePassword);
			passwordNode.setAttribute(ConstantesTibcoWS.SOAP_WSS_HEADER_ATTRIBUTE_TYPE, ConstantesTibcoWS.XMLNS_PASSWORD_URL);
			passwordNode.addTextNode(password);

			usernameTokenNode.addChildElement(usernameNode);
			usernameTokenNode.addChildElement(passwordNode);
			securityNode.addChildElement(usernameTokenNode);
			soapMessage.saveChanges();
			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			soapMessage.writeTo(stream);
			logger.debug("Mensaje SOAP: \n" + stream.toString());
		} catch (SOAPException | IOException exception) {
			logger.error("Error añadiendo credenciales a la cabecera SOAP", exception);
		}
		logger.trace("-- Fin -- handleMessage()");
		return true;
	}

	@Override
	public void close(MessageContext messageContext) {
		logger.debug("Metodo close invocado");
	}

	@Override
	public boolean handleFault(SOAPMessageContext soapMessageContext) {
		logger.debug("Metodo handleFault invocado");
		return false;
	}

	@Override
	public Set<QName> getHeaders() {
		logger.debug("Metodo getHeaders invocado");
		return null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}