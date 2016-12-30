
package com.endesa.xmlns.commonschemas;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.endesa.xmlns.commonschemas package. 
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

    private final static QName _Audit_QNAME = new QName("http://xmlns.endesa.com/CommonSchemas", "Audit");
    private final static QName _Error_QNAME = new QName("http://xmlns.endesa.com/CommonSchemas", "Error");
    private final static QName _ErrorType_QNAME = new QName("http://xmlns.endesa.com/CommonSchemas", "ErrorType");
    private final static QName _MCDError_QNAME = new QName("http://xmlns.endesa.com/CommonSchemas", "MCD_Error");
    private final static QName _Message_QNAME = new QName("http://xmlns.endesa.com/CommonSchemas", "Message");
    private final static QName _SOAHeader_QNAME = new QName("http://xmlns.endesa.com/CommonSchemas", "SOAHeader");
    private final static QName _SOAHeaderResponse_QNAME = new QName("http://xmlns.endesa.com/CommonSchemas", "SOAHeaderResponse");
    private final static QName _SOAParameters_QNAME = new QName("http://xmlns.endesa.com/CommonSchemas", "SOAParameters");
    private final static QName _TraceData_QNAME = new QName("http://xmlns.endesa.com/CommonSchemas", "TraceData");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.endesa.xmlns.commonschemas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AuditType }
     * 
     */
    public AuditType createAuditType() {
        return new AuditType();
    }

    /**
     * Create an instance of {@link ErrorType }
     * 
     */
    public ErrorType createErrorType() {
        return new ErrorType();
    }

    /**
     * Create an instance of {@link MCDERROR }
     * 
     */
    public MCDERROR createMCDERROR() {
        return new MCDERROR();
    }

    /**
     * Create an instance of {@link SOAHeaderType }
     * 
     */
    public SOAHeaderType createSOAHeaderType() {
        return new SOAHeaderType();
    }

    /**
     * Create an instance of {@link SOAHeaderResponseType }
     * 
     */
    public SOAHeaderResponseType createSOAHeaderResponseType() {
        return new SOAHeaderResponseType();
    }

    /**
     * Create an instance of {@link SOAParametersType }
     * 
     */
    public SOAParametersType createSOAParametersType() {
        return new SOAParametersType();
    }

    /**
     * Create an instance of {@link TraceDataType }
     * 
     */
    public TraceDataType createTraceDataType() {
        return new TraceDataType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuditType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.endesa.com/CommonSchemas", name = "Audit")
    public JAXBElement<AuditType> createAudit(AuditType value) {
        return new JAXBElement<AuditType>(_Audit_QNAME, AuditType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.endesa.com/CommonSchemas", name = "Error")
    public JAXBElement<ErrorType> createError(ErrorType value) {
        return new JAXBElement<ErrorType>(_Error_QNAME, ErrorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.endesa.com/CommonSchemas", name = "ErrorType")
    public JAXBElement<String> createErrorType(String value) {
        return new JAXBElement<String>(_ErrorType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MCDERROR }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.endesa.com/CommonSchemas", name = "MCD_Error")
    public JAXBElement<MCDERROR> createMCDError(MCDERROR value) {
        return new JAXBElement<MCDERROR>(_MCDError_QNAME, MCDERROR.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.endesa.com/CommonSchemas", name = "Message")
    public JAXBElement<String> createMessage(String value) {
        return new JAXBElement<String>(_Message_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SOAHeaderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.endesa.com/CommonSchemas", name = "SOAHeader")
    public JAXBElement<SOAHeaderType> createSOAHeader(SOAHeaderType value) {
        return new JAXBElement<SOAHeaderType>(_SOAHeader_QNAME, SOAHeaderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SOAHeaderResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.endesa.com/CommonSchemas", name = "SOAHeaderResponse")
    public JAXBElement<SOAHeaderResponseType> createSOAHeaderResponse(SOAHeaderResponseType value) {
        return new JAXBElement<SOAHeaderResponseType>(_SOAHeaderResponse_QNAME, SOAHeaderResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SOAParametersType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.endesa.com/CommonSchemas", name = "SOAParameters")
    public JAXBElement<SOAParametersType> createSOAParameters(SOAParametersType value) {
        return new JAXBElement<SOAParametersType>(_SOAParameters_QNAME, SOAParametersType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TraceDataType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.endesa.com/CommonSchemas", name = "TraceData")
    public JAXBElement<TraceDataType> createTraceData(TraceDataType value) {
        return new JAXBElement<TraceDataType>(_TraceData_QNAME, TraceDataType.class, null, value);
    }

}
