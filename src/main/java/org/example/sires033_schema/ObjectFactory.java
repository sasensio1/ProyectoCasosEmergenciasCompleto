
package org.example.sires033_schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.sires033_schema package. 
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

    private final static QName _ConsultaDatosSuministroRequest_QNAME = new QName("http://www.example.org/SIRES033_Schema", "ConsultaDatosSuministroRequest");
    private final static QName _ConsultaDatosSuministroResponse_QNAME = new QName("http://www.example.org/SIRES033_Schema", "ConsultaDatosSuministroResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.sires033_schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultaDatosSuministroRequestType }
     * 
     */
    public ConsultaDatosSuministroRequestType createConsultaDatosSuministroRequestType() {
        return new ConsultaDatosSuministroRequestType();
    }

    /**
     * Create an instance of {@link ConsultaDatosSuministroResponseType }
     * 
     */
    public ConsultaDatosSuministroResponseType createConsultaDatosSuministroResponseType() {
        return new ConsultaDatosSuministroResponseType();
    }

    /**
     * Create an instance of {@link ConsultaDatosSuministroMsgRequestType }
     * 
     */
    public ConsultaDatosSuministroMsgRequestType createConsultaDatosSuministroMsgRequestType() {
        return new ConsultaDatosSuministroMsgRequestType();
    }

    /**
     * Create an instance of {@link ConsultaDatosSuministroMsgResponseType }
     * 
     */
    public ConsultaDatosSuministroMsgResponseType createConsultaDatosSuministroMsgResponseType() {
        return new ConsultaDatosSuministroMsgResponseType();
    }

    /**
     * Create an instance of {@link ListadoSuministrosType }
     * 
     */
    public ListadoSuministrosType createListadoSuministrosType() {
        return new ListadoSuministrosType();
    }

    /**
     * Create an instance of {@link OrdenType }
     * 
     */
    public OrdenType createOrdenType() {
        return new OrdenType();
    }

    /**
     * Create an instance of {@link SuministroType }
     * 
     */
    public SuministroType createSuministroType() {
        return new SuministroType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaDatosSuministroRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/SIRES033_Schema", name = "ConsultaDatosSuministroRequest")
    public JAXBElement<ConsultaDatosSuministroRequestType> createConsultaDatosSuministroRequest(ConsultaDatosSuministroRequestType value) {
        return new JAXBElement<ConsultaDatosSuministroRequestType>(_ConsultaDatosSuministroRequest_QNAME, ConsultaDatosSuministroRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaDatosSuministroResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/SIRES033_Schema", name = "ConsultaDatosSuministroResponse")
    public JAXBElement<ConsultaDatosSuministroResponseType> createConsultaDatosSuministroResponse(ConsultaDatosSuministroResponseType value) {
        return new JAXBElement<ConsultaDatosSuministroResponseType>(_ConsultaDatosSuministroResponse_QNAME, ConsultaDatosSuministroResponseType.class, null, value);
    }

}
