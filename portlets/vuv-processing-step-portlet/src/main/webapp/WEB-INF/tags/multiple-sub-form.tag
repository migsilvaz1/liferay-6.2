<%@tag import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@tag import="java.util.Collections"%>
<%@tag import="com.liferay.portal.kernel.util.ListUtil"%>
<%@tag import="java.util.Locale"%>
<%@tag import="ec.gob.snap.vuv.dynamic.form.dao.MultipleSubFormDAO"%>
<%@tag
	import="ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.MultipleSubForm"%>
<%@tag import="java.util.List"%>
<%@tag import="ec.gob.snap.vuv.dynamic.form.dao.LabelDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui"%>
<%@ taglib prefix="vuv" tagdir="/WEB-INF/tags"%>

<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag description="Multiple Sub Form"%>
<%@ attribute name="tableData" required="true" rtexprvalue="true"
	type="ec.gob.snap.vuv.dynamic.form.entities.Template.Formulario.MultipleSubForm"%>
<portlet:defineObjects />
<!--   VARIABLES DE LA TABLA  -->
<%
	Locale locale = renderRequest.getLocale();
	MultipleSubFormDAO tableForm = new MultipleSubFormDAO(tableData,locale);
%>
<c:set var="locale" value="<%=locale%>" />
<div id="<portlet:namespace/><%=tableForm.getTableID()%>"
	title="<%=tableForm.getTableProperty()%>"
	class="w100 multiple-sub-form-table table-striped yui3-widget yui3-datatable table-selection table table-sortable table-scrollable-x unselectable"></div>

<script type="text/javascript">
	YUI().use(
			'aui-datatable',
			'aui-datatype',
			'datatable-sort',
			function(Y) {
				var remoteData = <%=tableForm.getTableRowsJSON()%>;
				var tablecolumns = <%=tableForm.getTableColumnsJSON(locale)%>;

				var nestedCols = [];

				for(var item in tablecolumns) {
					var column = tablecolumns[item];
					var typeEditor = new Y.TextCellEditor({
						inputFormatter : Y.DataType.String.evaluate, 
					    validator: {
						   rules: {
						      value: {
						           required: column.required
						      }
						  }
						}
					});
					switch (column.type) {
					case "inputText":
						typeEditor = new Y.TextCellEditor({
							inputFormatter : Y.DataType.String.evaluate, 
						    validator: {
							   rules: {
							      value: {
							           required: column.required
							      }
							  }
							}
						});
						break;
					case "selectBox":
						typeEditor = new Y.DropDownCellEditor({
						    editable: false,
						    multiple: false,
						    options: column.options,
						    validator: {
						      rules: {
						      	value: {
						           required: column.required
						      	}
						     }
						    }
						});
						break;
					case "numberInput":
						typeEditor = new Y.TextCellEditor({
							inputFormatter : Y.DataType.String.evaluate, 
						    validator: {
						      rules: {
						      	value: {
						      	   number: true,
						           required: column.required
						      	}
						     }
						    }
						});
						break;
					case "inputDate":
						typeEditor = new Y.DateCellEditor({
				            calendar: {
				                showNextMonth: true,
				                showPrevMonth: true,
				                width: '250px'
				              },
				              dateFormat: '%d/%m/%Y',
				              validator: {
				                rules: {
				                  value: {
				                    required: column.required
				                  }
				                }
				              }
						});
						break;
					case "radioButton":
						typeEditor = new Y.RadioCellEditor({
				            editable: false,
				            options: column.options
						});
						break;
					case "checkedBox":
						typeEditor = new Y.CheckboxCellEditor({
				            editable: false,
				            multiple: true,
				            options: column.options
						});
						break;
					case "textAreaInput":
						typeEditor = new Y.TextAreaCellEditor({
					        validator: {
					            rules: {
					              name: {
					                required: column.required
					              }
					            }
					          }
						});
						break;
					}
				    nestedCols.push({ 
				        editor 	: typeEditor,
				        key  		: column.key,
				        label		: column.name,
				        sortable 	: true, 
				        required 	: column.required
				    });
				}


				var dataTable = new Y.DataTable({
					columns : nestedCols,
					data : remoteData,
					editEvent : 'dblclick',
					plugins : [ {
						cfg : {
							highlightRange : false
						},
						fn : Y.Plugin.DataTableHighlight
					} ]
				}).render(<portlet:namespace/><%=tableForm.getTableID()%>);

				dataTable.get('boundingBox').unselectable();
			});
</script>