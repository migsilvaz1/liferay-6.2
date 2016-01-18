create table vuv_gpr_service_builder_Act_Institucional (
	id_act_institucional LONG not null primary key,
	id_GPR_act_institucional LONG,
	content LONG,
	timeStamp DATE null,
	id_servicio LONG
);

create table vuv_gpr_service_builder_Caso (
	id_caso LONG not null primary key,
	id_GPR_caso LONG,
	content LONG,
	timeStamp DATE null,
	id_servicio LONG
);

create table vuv_gpr_service_builder_Centro (
	id_centro LONG not null primary key,
	id_GPR_centro LONG,
	content LONG,
	timeStamp DATE null,
	id_caso LONG
);

create table vuv_gpr_service_builder_Indicador (
	id_indicador LONG not null primary key,
	id_GPR_indicador LONG,
	content LONG,
	timeStamp DATE null,
	id_servicio LONG
);

create table vuv_gpr_service_builder_Institucion (
	id_institucion LONG not null primary key,
	id_GPR_institucion LONG,
	content LONG,
	timeStamp DATE null
);

create table vuv_gpr_service_builder_Paso (
	id_paso LONG not null primary key,
	id_GPR_paso LONG,
	content LONG,
	timeStamp DATE null,
	id_caso LONG
);

create table vuv_gpr_service_builder_Requisito (
	id_requisito LONG not null primary key,
	id_GPR_requisito LONG,
	content LONG,
	timeStamp DATE null,
	id_paso LONG
);

create table vuv_gpr_service_builder_Servicio (
	id_GPR_servicio LONG,
	content LONG,
	timeStamp DATE null,
	id_servicio LONG not null primary key,
	id_institucion LONG
);