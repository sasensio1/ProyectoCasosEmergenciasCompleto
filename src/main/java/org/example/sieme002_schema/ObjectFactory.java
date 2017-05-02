
package org.example.sieme002_schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.sieme002_schema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCalleRequest_QNAME = new QName("http://www.example.org/SIEME002_Schema/", "GetCalleRequest");
    private final static QName _GetCalleResponse_QNAME = new QName("http://www.example.org/SIEME002_Schema/", "GetCalleResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.sieme002_schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCalleRequestType }
     * 
     */
    public GetCalleRequestType createGetCalleRequestType() {
        return new GetCalleRequestType();
    }

    /**
     * Create an instance of {@link GetCalleResponseType }
     * 
     */
    public GetCalleResponseType createGetCalleResponseType() {
        return new GetCalleResponseType();
    }

    /**
     * Create an instance of {@link CalleType }
     * 
     */
    public CalleType createCalleType() {
        return new CalleType();
    }

    /**
     * Create an instance of {@link GetCalleMsgRequestType }
     * 
     */
    public GetCalleMsgRequestType createGetCalleMsgRequestType() {
        return new GetCalleMsgRequestType();
    }

    /**
     * Create an instance of {@link GetCalleMsgResponseType }
     * 
     */
    public GetCalleMsgResponseType createGetCalleMsgResponseType() {
        return new GetCalleMsgResponseType();
    }

    /**
     * Create an instance of {@link ListadoCallesType }
     * 
     */
    public ListadoCallesType createListadoCallesType() {
        return new ListadoCallesType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCalleRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/SIEME002_Schema/", name = "GetCalleRequest")
    public JAXBElement<GetCalleRequestType> createGetCalleRequest(GetCalleRequestType value) {
        return new JAXBElement<GetCalleRequestType>(_GetCalleRequest_QNAME, GetCalleRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCalleResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/SIEME002_Schema/", name = "GetCalleResponse")
    public JAXBElement<GetCalleResponseType> createGetCalleResponse(GetCalleResponseType value) {
        return new JAXBElement<GetCalleResponseType>(_GetCalleResponse_QNAME, GetCalleResponseType.class, null, value);
    }

}
