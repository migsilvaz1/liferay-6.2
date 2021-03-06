//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.23 at 01:12:14 PM CEST 
//


package ec.gob.snap.vuv.dynamic.form.entities;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.gob.snap.vuv.dynamic.form.entities package. 
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

    private final static QName _PropertiesOnChangeScript_QNAME = new QName("", "onChangeScript");
    private final static QName _PropertiesTitle_QNAME = new QName("", "title");
    private final static QName _PropertiesHeight_QNAME = new QName("", "height");
    private final static QName _PropertiesReadOnly_QNAME = new QName("", "readOnly");
    private final static QName _PropertiesMaxLength_QNAME = new QName("", "maxLength");
    private final static QName _PropertiesGroupWithPrevious_QNAME = new QName("", "groupWithPrevious");
    private final static QName _PropertiesValue_QNAME = new QName("", "value");
    private final static QName _PropertiesLabel_QNAME = new QName("", "label");
    private final static QName _PropertiesType_QNAME = new QName("", "type");
    private final static QName _PropertiesFieldRequired_QNAME = new QName("", "fieldRequired");
    private final static QName _PropertiesAccion_QNAME = new QName("", "accion");
    private final static QName _PropertiesSize_QNAME = new QName("", "size");
    private final static QName _TemplateFormularioMultipleSubFormCancelItemTextQu_QNAME = new QName("", "qu");
    private final static QName _TemplateFormularioMultipleSubFormCancelItemTextEn_QNAME = new QName("", "en");
    private final static QName _TemplateFormularioMultipleSubFormCancelItemTextEs_QNAME = new QName("", "es");
    private final static QName _TemplateFormularioAcciones_QNAME = new QName("", "acciones");
    private final static QName _TemplateFormularioInputDate_QNAME = new QName("", "inputDate");
    private final static QName _TemplateFormularioCheckedBox_QNAME = new QName("", "checkedBox");
    private final static QName _TemplateFormularioTextArea_QNAME = new QName("", "textArea");
    private final static QName _TemplateFormularioInputText_QNAME = new QName("", "inputText");
    private final static QName _TemplateFormularioOutputText_QNAME = new QName("", "outputText");
    private final static QName _TemplateFormularioRadioButton_QNAME = new QName("", "radioButton");
    private final static QName _TemplateFormularioMultipleSubForm_QNAME = new QName("", "multipleSubForm");
    private final static QName _TemplateFormularioSubForm_QNAME = new QName("", "subForm");
    private final static QName _TemplateFormularioSelectBox_QNAME = new QName("", "selectBox");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.gob.snap.vuv.dynamic.form.entities
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Template }
     * 
     */
    public Template createTemplate() {
        return new Template();
    }

    /**
     * Create an instance of {@link Properties }
     * 
     */
    public Properties createProperties() {
        return new Properties();
    }

    /**
     * Create an instance of {@link PropertiesDate }
     * 
     */
    public PropertiesDate createPropertiesDate() {
        return new PropertiesDate();
    }

    /**
     * Create an instance of {@link Template.Formulario }
     * 
     */
    public Template.Formulario createTemplateFormulario() {
        return new Template.Formulario();
    }

    /**
     * Create an instance of {@link Template.Formulario.MultipleSubForm }
     * 
     */
    public Template.Formulario.MultipleSubForm createTemplateFormularioMultipleSubForm() {
        return new Template.Formulario.MultipleSubForm();
    }

    /**
     * Create an instance of {@link Template.Formulario.MultipleSubForm.SubForm }
     * 
     */
    public Template.Formulario.MultipleSubForm.SubForm createTemplateFormularioMultipleSubFormSubForm() {
        return new Template.Formulario.MultipleSubForm.SubForm();
    }

    /**
     * Create an instance of {@link Template.Formulario.MultipleSubForm.SubForm.SelectBox }
     * 
     */
    public Template.Formulario.MultipleSubForm.SubForm.SelectBox createTemplateFormularioMultipleSubFormSubFormSelectBox() {
        return new Template.Formulario.MultipleSubForm.SubForm.SelectBox();
    }

    /**
     * Create an instance of {@link Template.Formulario.MultipleSubForm.SubForm.SelectBox.Options }
     * 
     */
    public Template.Formulario.MultipleSubForm.SubForm.SelectBox.Options createTemplateFormularioMultipleSubFormSubFormSelectBoxOptions() {
        return new Template.Formulario.MultipleSubForm.SubForm.SelectBox.Options();
    }

    /**
     * Create an instance of {@link Template.Formulario.MultipleSubForm.SubForm.SelectBox.Options.Option }
     * 
     */
    public Template.Formulario.MultipleSubForm.SubForm.SelectBox.Options.Option createTemplateFormularioMultipleSubFormSubFormSelectBoxOptionsOption() {
        return new Template.Formulario.MultipleSubForm.SubForm.SelectBox.Options.Option();
    }

    /**
     * Create an instance of {@link Template.Formulario.SubForm }
     * 
     */
    public Template.Formulario.SubForm createTemplateFormularioSubForm() {
        return new Template.Formulario.SubForm();
    }

    /**
     * Create an instance of {@link Template.Formulario.SubForm.SelectBox }
     * 
     */
    public Template.Formulario.SubForm.SelectBox createTemplateFormularioSubFormSelectBox() {
        return new Template.Formulario.SubForm.SelectBox();
    }

    /**
     * Create an instance of {@link Template.Formulario.SubForm.SelectBox.Options }
     * 
     */
    public Template.Formulario.SubForm.SelectBox.Options createTemplateFormularioSubFormSelectBoxOptions() {
        return new Template.Formulario.SubForm.SelectBox.Options();
    }

    /**
     * Create an instance of {@link Template.Formulario.SubForm.SelectBox.Options.Option }
     * 
     */
    public Template.Formulario.SubForm.SelectBox.Options.Option createTemplateFormularioSubFormSelectBoxOptionsOption() {
        return new Template.Formulario.SubForm.SelectBox.Options.Option();
    }

    /**
     * Create an instance of {@link Template.Formulario.SelectBox }
     * 
     */
    public Template.Formulario.SelectBox createTemplateFormularioSelectBox() {
        return new Template.Formulario.SelectBox();
    }

    /**
     * Create an instance of {@link Template.Formulario.SelectBox.Options }
     * 
     */
    public Template.Formulario.SelectBox.Options createTemplateFormularioSelectBoxOptions() {
        return new Template.Formulario.SelectBox.Options();
    }

    /**
     * Create an instance of {@link Template.Formulario.SelectBox.Options.Option }
     * 
     */
    public Template.Formulario.SelectBox.Options.Option createTemplateFormularioSelectBoxOptionsOption() {
        return new Template.Formulario.SelectBox.Options.Option();
    }

    /**
     * Create an instance of {@link Template.Variables }
     * 
     */
    public Template.Variables createTemplateVariables() {
        return new Template.Variables();
    }

    /**
     * Create an instance of {@link Template.Variables.Output }
     * 
     */
    public Template.Variables.Output createTemplateVariablesOutput() {
        return new Template.Variables.Output();
    }

    /**
     * Create an instance of {@link InputD }
     * 
     */
    public InputD createInputD() {
        return new InputD();
    }

    /**
     * Create an instance of {@link Input }
     * 
     */
    public Input createInput() {
        return new Input();
    }

    /**
     * Create an instance of {@link ec.gob.snap.vuv.dynamic.form.entities.Var }
     * 
     */
    public ec.gob.snap.vuv.dynamic.form.entities.Var createVar() {
        return new ec.gob.snap.vuv.dynamic.form.entities.Var();
    }

    /**
     * Create an instance of {@link InputLabel }
     * 
     */
    public InputLabel createInputLabel() {
        return new InputLabel();
    }

    /**
     * Create an instance of {@link Properties.Label }
     * 
     */
    public Properties.Label createPropertiesLabel() {
        return new Properties.Label();
    }

    /**
     * Create an instance of {@link Properties.Title }
     * 
     */
    public Properties.Title createPropertiesTitle() {
        return new Properties.Title();
    }

    /**
     * Create an instance of {@link PropertiesDate.Label }
     * 
     */
    public PropertiesDate.Label createPropertiesDateLabel() {
        return new PropertiesDate.Label();
    }

    /**
     * Create an instance of {@link PropertiesDate.Title }
     * 
     */
    public PropertiesDate.Title createPropertiesDateTitle() {
        return new PropertiesDate.Title();
    }

    /**
     * Create an instance of {@link Template.Formulario.Acciones }
     * 
     */
    public Template.Formulario.Acciones createTemplateFormularioAcciones() {
        return new Template.Formulario.Acciones();
    }

    /**
     * Create an instance of {@link Template.Formulario.MultipleSubForm.AddItemText }
     * 
     */
    public Template.Formulario.MultipleSubForm.AddItemText createTemplateFormularioMultipleSubFormAddItemText() {
        return new Template.Formulario.MultipleSubForm.AddItemText();
    }

    /**
     * Create an instance of {@link Template.Formulario.MultipleSubForm.CancelItemText }
     * 
     */
    public Template.Formulario.MultipleSubForm.CancelItemText createTemplateFormularioMultipleSubFormCancelItemText() {
        return new Template.Formulario.MultipleSubForm.CancelItemText();
    }

    /**
     * Create an instance of {@link Template.Formulario.MultipleSubForm.NewItemText }
     * 
     */
    public Template.Formulario.MultipleSubForm.NewItemText createTemplateFormularioMultipleSubFormNewItemText() {
        return new Template.Formulario.MultipleSubForm.NewItemText();
    }

    /**
     * Create an instance of {@link Template.Formulario.MultipleSubForm.SubForm.SelectBox.Options.Option.Label }
     * 
     */
    public Template.Formulario.MultipleSubForm.SubForm.SelectBox.Options.Option.Label createTemplateFormularioMultipleSubFormSubFormSelectBoxOptionsOptionLabel() {
        return new Template.Formulario.MultipleSubForm.SubForm.SelectBox.Options.Option.Label();
    }

    /**
     * Create an instance of {@link Template.Formulario.SubForm.SelectBox.Options.Option.Label }
     * 
     */
    public Template.Formulario.SubForm.SelectBox.Options.Option.Label createTemplateFormularioSubFormSelectBoxOptionsOptionLabel() {
        return new Template.Formulario.SubForm.SelectBox.Options.Option.Label();
    }

    /**
     * Create an instance of {@link Template.Formulario.SelectBox.Options.Option.Label }
     * 
     */
    public Template.Formulario.SelectBox.Options.Option.Label createTemplateFormularioSelectBoxOptionsOptionLabel() {
        return new Template.Formulario.SelectBox.Options.Option.Label();
    }

    /**
     * Create an instance of {@link Template.Variables.Proceso }
     * 
     */
    public Template.Variables.Proceso createTemplateVariablesProceso() {
        return new Template.Variables.Proceso();
    }

    /**
     * Create an instance of {@link Template.Variables.Local }
     * 
     */
    public Template.Variables.Local createTemplateVariablesLocal() {
        return new Template.Variables.Local();
    }

    /**
     * Create an instance of {@link Template.Variables.Output.Var }
     * 
     */
    public Template.Variables.Output.Var createTemplateVariablesOutputVar() {
        return new Template.Variables.Output.Var();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "onChangeScript", scope = Properties.class)
    public JAXBElement<String> createPropertiesOnChangeScript(String value) {
        return new JAXBElement<String>(_PropertiesOnChangeScript_QNAME, String.class, Properties.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Properties.Title }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "title", scope = Properties.class)
    public JAXBElement<Properties.Title> createPropertiesTitle(Properties.Title value) {
        return new JAXBElement<Properties.Title>(_PropertiesTitle_QNAME, Properties.Title.class, Properties.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "height", scope = Properties.class)
    public JAXBElement<Integer> createPropertiesHeight(Integer value) {
        return new JAXBElement<Integer>(_PropertiesHeight_QNAME, Integer.class, Properties.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoBoolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "readOnly", scope = Properties.class)
    public JAXBElement<TipoBoolean> createPropertiesReadOnly(TipoBoolean value) {
        return new JAXBElement<TipoBoolean>(_PropertiesReadOnly_QNAME, TipoBoolean.class, Properties.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "maxLength", scope = Properties.class)
    public JAXBElement<Integer> createPropertiesMaxLength(Integer value) {
        return new JAXBElement<Integer>(_PropertiesMaxLength_QNAME, Integer.class, Properties.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoBoolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "groupWithPrevious", scope = Properties.class)
    public JAXBElement<TipoBoolean> createPropertiesGroupWithPrevious(TipoBoolean value) {
        return new JAXBElement<TipoBoolean>(_PropertiesGroupWithPrevious_QNAME, TipoBoolean.class, Properties.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "value", scope = Properties.class)
    public JAXBElement<String> createPropertiesValue(String value) {
        return new JAXBElement<String>(_PropertiesValue_QNAME, String.class, Properties.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Properties.Label }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "label", scope = Properties.class)
    public JAXBElement<Properties.Label> createPropertiesLabel(Properties.Label value) {
        return new JAXBElement<Properties.Label>(_PropertiesLabel_QNAME, Properties.Label.class, Properties.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tipo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "type", scope = Properties.class)
    public JAXBElement<Tipo> createPropertiesType(Tipo value) {
        return new JAXBElement<Tipo>(_PropertiesType_QNAME, Tipo.class, Properties.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoBoolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "fieldRequired", scope = Properties.class)
    public JAXBElement<TipoBoolean> createPropertiesFieldRequired(TipoBoolean value) {
        return new JAXBElement<TipoBoolean>(_PropertiesFieldRequired_QNAME, TipoBoolean.class, Properties.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "accion", scope = Properties.class)
    public JAXBElement<String> createPropertiesAccion(String value) {
        return new JAXBElement<String>(_PropertiesAccion_QNAME, String.class, Properties.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "size", scope = Properties.class)
    public JAXBElement<Integer> createPropertiesSize(Integer value) {
        return new JAXBElement<Integer>(_PropertiesSize_QNAME, Integer.class, Properties.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "qu", scope = Template.Formulario.MultipleSubForm.CancelItemText.class)
    public JAXBElement<Object> createTemplateFormularioMultipleSubFormCancelItemTextQu(Object value) {
        return new JAXBElement<Object>(_TemplateFormularioMultipleSubFormCancelItemTextQu_QNAME, Object.class, Template.Formulario.MultipleSubForm.CancelItemText.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "en", scope = Template.Formulario.MultipleSubForm.CancelItemText.class)
    public JAXBElement<Object> createTemplateFormularioMultipleSubFormCancelItemTextEn(Object value) {
        return new JAXBElement<Object>(_TemplateFormularioMultipleSubFormCancelItemTextEn_QNAME, Object.class, Template.Formulario.MultipleSubForm.CancelItemText.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "es", scope = Template.Formulario.MultipleSubForm.CancelItemText.class)
    public JAXBElement<Object> createTemplateFormularioMultipleSubFormCancelItemTextEs(Object value) {
        return new JAXBElement<Object>(_TemplateFormularioMultipleSubFormCancelItemTextEs_QNAME, Object.class, Template.Formulario.MultipleSubForm.CancelItemText.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Template.Formulario.Acciones }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "acciones", scope = Template.Formulario.class)
    public JAXBElement<Template.Formulario.Acciones> createTemplateFormularioAcciones(Template.Formulario.Acciones value) {
        return new JAXBElement<Template.Formulario.Acciones>(_TemplateFormularioAcciones_QNAME, Template.Formulario.Acciones.class, Template.Formulario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InputD }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "inputDate", scope = Template.Formulario.class)
    public JAXBElement<InputD> createTemplateFormularioInputDate(InputD value) {
        return new JAXBElement<InputD>(_TemplateFormularioInputDate_QNAME, InputD.class, Template.Formulario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "checkedBox", scope = Template.Formulario.class)
    public JAXBElement<Input> createTemplateFormularioCheckedBox(Input value) {
        return new JAXBElement<Input>(_TemplateFormularioCheckedBox_QNAME, Input.class, Template.Formulario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "textArea", scope = Template.Formulario.class)
    public JAXBElement<Input> createTemplateFormularioTextArea(Input value) {
        return new JAXBElement<Input>(_TemplateFormularioTextArea_QNAME, Input.class, Template.Formulario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "inputText", scope = Template.Formulario.class)
    public JAXBElement<Input> createTemplateFormularioInputText(Input value) {
        return new JAXBElement<Input>(_TemplateFormularioInputText_QNAME, Input.class, Template.Formulario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InputLabel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "outputText", scope = Template.Formulario.class)
    public JAXBElement<InputLabel> createTemplateFormularioOutputText(InputLabel value) {
        return new JAXBElement<InputLabel>(_TemplateFormularioOutputText_QNAME, InputLabel.class, Template.Formulario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "radioButton", scope = Template.Formulario.class)
    public JAXBElement<Input> createTemplateFormularioRadioButton(Input value) {
        return new JAXBElement<Input>(_TemplateFormularioRadioButton_QNAME, Input.class, Template.Formulario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Template.Formulario.MultipleSubForm }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "multipleSubForm", scope = Template.Formulario.class)
    public JAXBElement<Template.Formulario.MultipleSubForm> createTemplateFormularioMultipleSubForm(Template.Formulario.MultipleSubForm value) {
        return new JAXBElement<Template.Formulario.MultipleSubForm>(_TemplateFormularioMultipleSubForm_QNAME, Template.Formulario.MultipleSubForm.class, Template.Formulario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Template.Formulario.SubForm }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "subForm", scope = Template.Formulario.class)
    public JAXBElement<Template.Formulario.SubForm> createTemplateFormularioSubForm(Template.Formulario.SubForm value) {
        return new JAXBElement<Template.Formulario.SubForm>(_TemplateFormularioSubForm_QNAME, Template.Formulario.SubForm.class, Template.Formulario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Template.Formulario.SelectBox }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "selectBox", scope = Template.Formulario.class)
    public JAXBElement<Template.Formulario.SelectBox> createTemplateFormularioSelectBox(Template.Formulario.SelectBox value) {
        return new JAXBElement<Template.Formulario.SelectBox>(_TemplateFormularioSelectBox_QNAME, Template.Formulario.SelectBox.class, Template.Formulario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "qu", scope = Template.Formulario.MultipleSubForm.SubForm.SelectBox.Options.Option.Label.class)
    public JAXBElement<Object> createTemplateFormularioMultipleSubFormSubFormSelectBoxOptionsOptionLabelQu(Object value) {
        return new JAXBElement<Object>(_TemplateFormularioMultipleSubFormCancelItemTextQu_QNAME, Object.class, Template.Formulario.MultipleSubForm.SubForm.SelectBox.Options.Option.Label.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "en", scope = Template.Formulario.MultipleSubForm.SubForm.SelectBox.Options.Option.Label.class)
    public JAXBElement<Object> createTemplateFormularioMultipleSubFormSubFormSelectBoxOptionsOptionLabelEn(Object value) {
        return new JAXBElement<Object>(_TemplateFormularioMultipleSubFormCancelItemTextEn_QNAME, Object.class, Template.Formulario.MultipleSubForm.SubForm.SelectBox.Options.Option.Label.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "es", scope = Template.Formulario.MultipleSubForm.SubForm.SelectBox.Options.Option.Label.class)
    public JAXBElement<Object> createTemplateFormularioMultipleSubFormSubFormSelectBoxOptionsOptionLabelEs(Object value) {
        return new JAXBElement<Object>(_TemplateFormularioMultipleSubFormCancelItemTextEs_QNAME, Object.class, Template.Formulario.MultipleSubForm.SubForm.SelectBox.Options.Option.Label.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "qu", scope = Template.Formulario.MultipleSubForm.AddItemText.class)
    public JAXBElement<Object> createTemplateFormularioMultipleSubFormAddItemTextQu(Object value) {
        return new JAXBElement<Object>(_TemplateFormularioMultipleSubFormCancelItemTextQu_QNAME, Object.class, Template.Formulario.MultipleSubForm.AddItemText.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "en", scope = Template.Formulario.MultipleSubForm.AddItemText.class)
    public JAXBElement<Object> createTemplateFormularioMultipleSubFormAddItemTextEn(Object value) {
        return new JAXBElement<Object>(_TemplateFormularioMultipleSubFormCancelItemTextEn_QNAME, Object.class, Template.Formulario.MultipleSubForm.AddItemText.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "es", scope = Template.Formulario.MultipleSubForm.AddItemText.class)
    public JAXBElement<Object> createTemplateFormularioMultipleSubFormAddItemTextEs(Object value) {
        return new JAXBElement<Object>(_TemplateFormularioMultipleSubFormCancelItemTextEs_QNAME, Object.class, Template.Formulario.MultipleSubForm.AddItemText.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InputD }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "inputDate", scope = Template.Formulario.MultipleSubForm.SubForm.class)
    public JAXBElement<InputD> createTemplateFormularioMultipleSubFormSubFormInputDate(InputD value) {
        return new JAXBElement<InputD>(_TemplateFormularioInputDate_QNAME, InputD.class, Template.Formulario.MultipleSubForm.SubForm.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "checkedBox", scope = Template.Formulario.MultipleSubForm.SubForm.class)
    public JAXBElement<Input> createTemplateFormularioMultipleSubFormSubFormCheckedBox(Input value) {
        return new JAXBElement<Input>(_TemplateFormularioCheckedBox_QNAME, Input.class, Template.Formulario.MultipleSubForm.SubForm.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "textArea", scope = Template.Formulario.MultipleSubForm.SubForm.class)
    public JAXBElement<Input> createTemplateFormularioMultipleSubFormSubFormTextArea(Input value) {
        return new JAXBElement<Input>(_TemplateFormularioTextArea_QNAME, Input.class, Template.Formulario.MultipleSubForm.SubForm.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "inputText", scope = Template.Formulario.MultipleSubForm.SubForm.class)
    public JAXBElement<Input> createTemplateFormularioMultipleSubFormSubFormInputText(Input value) {
        return new JAXBElement<Input>(_TemplateFormularioInputText_QNAME, Input.class, Template.Formulario.MultipleSubForm.SubForm.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InputLabel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "outputText", scope = Template.Formulario.MultipleSubForm.SubForm.class)
    public JAXBElement<InputLabel> createTemplateFormularioMultipleSubFormSubFormOutputText(InputLabel value) {
        return new JAXBElement<InputLabel>(_TemplateFormularioOutputText_QNAME, InputLabel.class, Template.Formulario.MultipleSubForm.SubForm.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "radioButton", scope = Template.Formulario.MultipleSubForm.SubForm.class)
    public JAXBElement<Input> createTemplateFormularioMultipleSubFormSubFormRadioButton(Input value) {
        return new JAXBElement<Input>(_TemplateFormularioRadioButton_QNAME, Input.class, Template.Formulario.MultipleSubForm.SubForm.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Template.Formulario.MultipleSubForm.SubForm.SelectBox }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "selectBox", scope = Template.Formulario.MultipleSubForm.SubForm.class)
    public JAXBElement<Template.Formulario.MultipleSubForm.SubForm.SelectBox> createTemplateFormularioMultipleSubFormSubFormSelectBox(Template.Formulario.MultipleSubForm.SubForm.SelectBox value) {
        return new JAXBElement<Template.Formulario.MultipleSubForm.SubForm.SelectBox>(_TemplateFormularioSelectBox_QNAME, Template.Formulario.MultipleSubForm.SubForm.SelectBox.class, Template.Formulario.MultipleSubForm.SubForm.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "onChangeScript", scope = PropertiesDate.class)
    public JAXBElement<String> createPropertiesDateOnChangeScript(String value) {
        return new JAXBElement<String>(_PropertiesOnChangeScript_QNAME, String.class, PropertiesDate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PropertiesDate.Title }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "title", scope = PropertiesDate.class)
    public JAXBElement<PropertiesDate.Title> createPropertiesDateTitle(PropertiesDate.Title value) {
        return new JAXBElement<PropertiesDate.Title>(_PropertiesTitle_QNAME, PropertiesDate.Title.class, PropertiesDate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoBoolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "readOnly", scope = PropertiesDate.class)
    public JAXBElement<TipoBoolean> createPropertiesDateReadOnly(TipoBoolean value) {
        return new JAXBElement<TipoBoolean>(_PropertiesReadOnly_QNAME, TipoBoolean.class, PropertiesDate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoBoolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "groupWithPrevious", scope = PropertiesDate.class)
    public JAXBElement<TipoBoolean> createPropertiesDateGroupWithPrevious(TipoBoolean value) {
        return new JAXBElement<TipoBoolean>(_PropertiesGroupWithPrevious_QNAME, TipoBoolean.class, PropertiesDate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "value", scope = PropertiesDate.class)
    public JAXBElement<Object> createPropertiesDateValue(Object value) {
        return new JAXBElement<Object>(_PropertiesValue_QNAME, Object.class, PropertiesDate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PropertiesDate.Label }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "label", scope = PropertiesDate.class)
    public JAXBElement<PropertiesDate.Label> createPropertiesDateLabel(PropertiesDate.Label value) {
        return new JAXBElement<PropertiesDate.Label>(_PropertiesLabel_QNAME, PropertiesDate.Label.class, PropertiesDate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "type", scope = PropertiesDate.class)
    public JAXBElement<TipoDate> createPropertiesDateType(TipoDate value) {
        return new JAXBElement<TipoDate>(_PropertiesType_QNAME, TipoDate.class, PropertiesDate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoBoolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "fieldRequired", scope = PropertiesDate.class)
    public JAXBElement<TipoBoolean> createPropertiesDateFieldRequired(TipoBoolean value) {
        return new JAXBElement<TipoBoolean>(_PropertiesFieldRequired_QNAME, TipoBoolean.class, PropertiesDate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InputD }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "inputDate", scope = Template.Formulario.SubForm.class)
    public JAXBElement<InputD> createTemplateFormularioSubFormInputDate(InputD value) {
        return new JAXBElement<InputD>(_TemplateFormularioInputDate_QNAME, InputD.class, Template.Formulario.SubForm.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "checkedBox", scope = Template.Formulario.SubForm.class)
    public JAXBElement<Input> createTemplateFormularioSubFormCheckedBox(Input value) {
        return new JAXBElement<Input>(_TemplateFormularioCheckedBox_QNAME, Input.class, Template.Formulario.SubForm.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "textArea", scope = Template.Formulario.SubForm.class)
    public JAXBElement<Input> createTemplateFormularioSubFormTextArea(Input value) {
        return new JAXBElement<Input>(_TemplateFormularioTextArea_QNAME, Input.class, Template.Formulario.SubForm.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "inputText", scope = Template.Formulario.SubForm.class)
    public JAXBElement<Input> createTemplateFormularioSubFormInputText(Input value) {
        return new JAXBElement<Input>(_TemplateFormularioInputText_QNAME, Input.class, Template.Formulario.SubForm.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InputLabel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "outputText", scope = Template.Formulario.SubForm.class)
    public JAXBElement<InputLabel> createTemplateFormularioSubFormOutputText(InputLabel value) {
        return new JAXBElement<InputLabel>(_TemplateFormularioOutputText_QNAME, InputLabel.class, Template.Formulario.SubForm.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "radioButton", scope = Template.Formulario.SubForm.class)
    public JAXBElement<Input> createTemplateFormularioSubFormRadioButton(Input value) {
        return new JAXBElement<Input>(_TemplateFormularioRadioButton_QNAME, Input.class, Template.Formulario.SubForm.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Template.Formulario.SubForm.SelectBox }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "selectBox", scope = Template.Formulario.SubForm.class)
    public JAXBElement<Template.Formulario.SubForm.SelectBox> createTemplateFormularioSubFormSelectBox(Template.Formulario.SubForm.SelectBox value) {
        return new JAXBElement<Template.Formulario.SubForm.SelectBox>(_TemplateFormularioSelectBox_QNAME, Template.Formulario.SubForm.SelectBox.class, Template.Formulario.SubForm.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "qu", scope = Template.Formulario.MultipleSubForm.NewItemText.class)
    public JAXBElement<Object> createTemplateFormularioMultipleSubFormNewItemTextQu(Object value) {
        return new JAXBElement<Object>(_TemplateFormularioMultipleSubFormCancelItemTextQu_QNAME, Object.class, Template.Formulario.MultipleSubForm.NewItemText.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "en", scope = Template.Formulario.MultipleSubForm.NewItemText.class)
    public JAXBElement<Object> createTemplateFormularioMultipleSubFormNewItemTextEn(Object value) {
        return new JAXBElement<Object>(_TemplateFormularioMultipleSubFormCancelItemTextEn_QNAME, Object.class, Template.Formulario.MultipleSubForm.NewItemText.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "es", scope = Template.Formulario.MultipleSubForm.NewItemText.class)
    public JAXBElement<Object> createTemplateFormularioMultipleSubFormNewItemTextEs(Object value) {
        return new JAXBElement<Object>(_TemplateFormularioMultipleSubFormCancelItemTextEs_QNAME, Object.class, Template.Formulario.MultipleSubForm.NewItemText.class, value);
    }

}
