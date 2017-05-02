
package org.example.sieme009_schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.sieme009_schema package. 
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

    private final static QName _GetEventosRelRequest_QNAME = new QName("http://www.example.org/SIEME009_Schema/", "GetEventosRelRequest");
    private final static QName _GetEventosRelResponse_QNAME = new QName("http://www.example.org/SIEME009_Schema/", "GetEventosRelResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.sieme009_schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEventosRelRequestType }
     * 
     */
    public GetEventosRelRequestType createGetEventosRelRequestType() {
        return new GetEventosRelRequestType();
    }

    /**
     * Create an instance of {@link GetEventosRelResponseType }
     * 
     */
    public GetEventosRelResponseType createGetEventosRelResponseType() {
        return new GetEventosRelResponseType();
    }

    /**
     * Create an instance of {@link EventoType }
     * 
     */
    public EventoType createEventoType() {
        return new EventoType();
    }

    /**
     * Create an instance of {@link GetEventosRelMsgRequestType }
     * 
     */
    public GetEventosRelMsgRequestType createGetEventosRelMsgRequestType() {
        return new GetEventosRelMsgRequestType();
    }

    /**
     * Create an instance of {@link GetEventosRelMsgResponseType }
     * 
     */
    public GetEventosRelMsgResponseType createGetEventosRelMsgResponseType() {
        return new GetEventosRelMsgResponseType();
    }

    /**
     * Create an instance of {@link ListadoEventosType }
     * 
     */
    public ListadoEventosType createListadoEventosType() {
        return new ListadoEventosType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEventosRelRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/SIEME009_Schema/", name = "GetEventosRelRequest")
    public JAXBElement<GetEventosRelRequestType> createGetEventosRelRequest(GetEventosRelRequestType value) {
        return new JAXBElement<GetEventosRelRequestType>(_GetEventosRelRequest_QNAME, GetEventosRelRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEventosRelResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/SIEME009_Schema/", name = "GetEventosRelResponse")
    public JAXBElement<GetEventosRelResponseType> createGetEventosRelResponse(GetEventosRelResponseType value) {
        return new JAXBElement<GetEventosRelResponseType>(_GetEventosRelResponse_QNAME, GetEventosRelResponseType.class, null, value);
    }

}
