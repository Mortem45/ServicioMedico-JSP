create sequence SEQ_SEGURO
/

create sequence SEQ_SUSPENSION_MEDICA
/

create sequence SEQ_COMPANIA_TELEFONO
/

create sequence SEQ_TIPO_TELEFONO
/

create sequence SEQ_TELEFONO
/

create sequence SEQ_ENFERMEDAD
/

create sequence SEQ_TIPO_ENFERMEDAD
/

create sequence SEQ_TIPO_SANGRE
/

create sequence SEQ_TIPO_SEGURO
/

create sequence SEQ_HISTORIAL_CLINICO
/

create sequence SEQ_ROL
/

create sequence SEQ_PAIS
  cache 2
/

create sequence SEQ_DEPARTAMENTO
  cache 2
/

create sequence SEQ_MUNICIPIO
  cache 2
/

create sequence SEQ_ZONAS
  cache 2
/

create sequence SEQ_COLONIA
  cache 2
/

create sequence SEQ_TIPO_SUSPENCION
/

create table BANCOS
(
  ID_BANCO NUMBER not null
    constraint BANCOS_PK
    primary key,
  BANCO    VARCHAR2(100)
)
/

create table CITA_PERSONA
(
  ID_CITA    NUMBER not null,
  ID_PERSONA NUMBER not null,
  constraint CITA_PERSONA_PK
  primary key (ID_CITA, ID_PERSONA)
)
/

create table COMPANIA_TELEFONO
(
  ID_COMPANIA NUMBER not null
    constraint COMPANIA_TELEFONO_PK
    primary key,
  COMPANIA    VARCHAR2(25)
)
/

create trigger T_SEQ_COMPANIA_TELEFONO
  before insert
  on COMPANIA_TELEFONO
  for each row
  begin
    if (inserting)
    then
      if ((:new.ID_COMPANIA is null) or (:new.ID_COMPANIA = 0))
      then
        select SEQ_COMPANIA_TELEFONO.NEXTVAL into :new.ID_COMPANIA from DUAL;
      end if;
    end if;
  end T_SEQ_COMPANIA_TELEFONO;
/

create table COMPRAS
(
  ID_COMPRA    NUMBER not null
    constraint COMPRAS_PK
    primary key,
  ID_LOTE      NUMBER,
  ID_PROVEEDOR NUMBER,
  NO_FACTURA   VARCHAR2(25),
  FECHA        DATE,
  RECARGOS     NUMBER,
  DESCUENTOS   NUMBER,
  TOTAL        NUMBER
)
/

create table DETALLE_COMPRA
(
  ID_COMPRA     NUMBER not null
    constraint DETALLE_COMPRA_COMPRAS_FK
    references COMPRAS,
  ID_PRODUCTO   NUMBER,
  CANTIDAD      NUMBER,
  PRECIO_UNIDAD NUMBER,
  TOTAL         NUMBER
)
/

create table DETALLE_PAGO
(
  ID_DETALLE_PAGO        NUMBER not null
    constraint DETALLE_PAGO_PK
    primary key,
  ID_PAGO                NUMBER,
  ID_COMPRA              NUMBER not null
    constraint DETALLE_PAGO_COMPRAS_FK
    references COMPRAS,
  ID_MEDIO_PAGO          NUMBER,
  ID_CUENTA_PROVEEDOR    NUMBER,
  ID_TIPO_DOCUMENTO_PAGO NUMBER,
  NO_DOC_PAGO            NUMBER,
  MONTO_PAGO             NUMBER
)
/

create table ESPECIALIDAD
(
  ID_ESPECIALIDAD NUMBER not null
    constraint ESPECIALIDAD_PK
    primary key,
  ESPECIALIDAD    VARCHAR2(100)
)
/

create table LAB_FARMACEUTICOS_INSUMOS
(
  ID_LABORATORIO NUMBER not null
    constraint LABORATORIOS_INSUMOS_PK
    primary key,
  NOMBRE         VARCHAR2(100)
)
/

create table INSUMO
(
  ID_INSUMO      NUMBER not null
    constraint INSUMO_PK
    primary key,
  ID_LOTE        NUMBER,
  NOMBRE         VARCHAR2(100),
  ID_LABORATORIO NUMBER not null
    constraint INSUMO_LABORATORIOS_INSUMOS_FK
    references LAB_FARMACEUTICOS_INSUMOS
)
/

create table INSUMO_LABORATORIOS
(
  ID_INSUMO NUMBER not null
    constraint INSUMO_LABORATORIOS_INSUMO_FK
    references INSUMO,
  CANTIDAD  NUMBER(5)
)
/

create table MENU
(
  ID_MENU  NUMBER not null
    constraint MENU_PK
    primary key,
  NOMBRE   VARCHAR2(50),
  URL      VARCHAR2(500),
  ID_PADRE NUMBER
)
/

create table PAIS
(
  ID_PAIS NUMBER not null
    constraint PAIS_PK
    primary key,
  PAIS    VARCHAR2(30)
    constraint UNIQUEPAIS
    unique
)
/

create trigger T_SEQ_PAIS
  before insert
  on PAIS
  for each row
  begin
    if (inserting)
    then
      if ((:new.ID_PAIS is null) or (:new.ID_PAIS = 0))
      then
        select SEQ_PAIS.NEXTVAL into :new.ID_PAIS from DUAL;
      end if;
    end if;
  end T_SEQ_PAIS;
/

create table DEPARTAMENTO
(
  ID_DEPARTAMENTO NUMBER not null
    constraint DEPARTAMENTO_PK
    primary key,
  ID_PAIS         NUMBER not null
    constraint DEPARTAMENTO_PAIS_FK
    references PAIS,
  DEPARTAMENTO    VARCHAR2(50),
  FECHA_REGISTRO  DATE,
  constraint UNIQUEDEPARTAMENTO
  unique (ID_PAIS, DEPARTAMENTO)
)
/

create trigger T_SEQ_DEPARTAMENTO
  before insert
  on DEPARTAMENTO
  for each row
  begin
    if (inserting)
    then
      if ((:new.ID_DEPARTAMENTO is null) or (:new.ID_DEPARTAMENTO = 0))
      then
        select SEQ_DEPARTAMENTO.NEXTVAL into :new.ID_DEPARTAMENTO from DUAL;
      end if;
    end if;
  end T_SEQ_DEPARTAMENTO;
/

create table MUNICIPIO
(
  ID_MUNICIPIO    NUMBER not null
    constraint MUNICIPIOS_PK
    primary key,
  ID_DEPARTAMENTO NUMBER
    constraint MUNICIPIO_DEPARTAMENTO_FK
    references DEPARTAMENTO,
  ID_PAIS         NUMBER,
  MUNICIPIO       VARCHAR2(50),
  FECHA_REGISTRO  DATE
)
/

create trigger T_SEQ_MUNICIPIO
  before insert
  on MUNICIPIO
  for each row
  begin
    if (inserting)
    then
      if ((:new.ID_MUNICIPIO is null) or (:new.ID_MUNICIPIO = 0))
      then
        select SEQ_MUNICIPIO.NEXTVAL into :new.ID_MUNICIPIO from DUAL;
      end if;
    end if;
  end T_SEQ_MUNICIPIO;
/

create table COLONIA
(
  ID_COLONIA   NUMBER not null
    constraint COLONIA_PK
    primary key,
  ID_MUNICIPIO NUMBER not null
    constraint COLONIA_MUNICIPIOS_FK
    references MUNICIPIO,
  COLONIA      VARCHAR2(30)
)
/

create trigger T_SEQ_COLONIA
  before insert
  on COLONIA
  for each row
  begin
    if (inserting)
    then
      if ((:new.ID_COLONIA is null) or (:new.ID_COLONIA = 0))
      then
        select SEQ_COLONIA.NEXTVAL into :new.ID_COLONIA from DUAL;
      end if;
    end if;
  end T_SEQ_COLONIA;
/

create table ROL
(
  ID_ROL_USUARIO   NUMBER not null
    constraint ROL_USUARIO_PK
    primary key,
  NOMBRE           VARCHAR2(50),
  DESCRIPCION_ROL  VARCHAR2(100),
  FECHA_CREACION   DATE,
  USUARIO_CREACION VARCHAR2(25),
  STATUS           NUMBER
)
/

create trigger T_SEQ_ROL
  before insert
  on ROL
  for each row
  begin
    if (inserting)
    then
      if ((:new.ID_ROL_USUARIO is null) or (:new.ID_ROL_USUARIO = 0))
      then
        select SEQ_ROL.NEXTVAL into :new.ID_ROL_USUARIO from DUAL;
      end if;
    end if;
  end T_SEQ_ROL;
/

create table ROL_APLICACION
(
  ID_ROL_APLICACION NUMBER not null
    constraint ROL_APLICACION_PK
    primary key,
  ID_MENU           NUMBER not null
    constraint ROL_APLICACION_MENU_FK
    references MENU
)
/

create table ROL_PERSONA
(
  ID_ROL           NUMBER not null
    constraint ROL_PK
    primary key,
  ROL              VARCHAR2(50),
  ESTADO           VARCHAR2(25),
  USUARIO_REGISTRO VARCHAR2(25),
  FECHA_REGISTRO   DATE
)
/

create table SEDE
(
  ID_SEDE      NUMBER not null
    constraint SEDE_PK
    primary key,
  ID_DIRECCION NUMBER,
  NOMBRE       VARCHAR2(100)
)
/

create table CLINICAS
(
  ID_CLINICA  NUMBER not null
    constraint CLINICAS_PK
    primary key,
  ID_SEDE     NUMBER not null
    constraint CLINICAS_SEDE_FK
    references SEDE,
  DESCRIPCION VARCHAR2(50)
)
/

create table FARMACIAS
(
  ID_FARMACIA NUMBER not null
    constraint FARMACIAS_PK
    primary key,
  ID_SEDE     NUMBER not null
    constraint FARMACIAS_SEDE_FK
    references SEDE,
  NOMBRE      VARCHAR2(100)
)
/

create table INSUMO_CLINICAS
(
  ID_CLINICA NUMBER not null
    constraint INSUMO_CLINICAS_CLINICAS_FK
    references CLINICAS,
  ID_INSUMO  NUMBER not null
    constraint INSUMO_CLINICAS_INSUMO_FK
    references INSUMO,
  ID_LOTE    NUMBER not null,
  CANTIDAD   NUMBER(4),
  constraint INSUMO_CLINICAS_PK
  primary key (ID_INSUMO, ID_LOTE)
)
/

create table LOTES
(
  ID_INSUMO                 NUMBER not null,
  ID_LOTE                   NUMBER not null
    constraint LOTES_COMPRAS_FK
    references COMPRAS,
  FECHA_VENCIMIENTO         DATE,
  INSUMO_CLINICAS_ID_INSUMO NUMBER not null,
  INSUMO_CLINICAS_ID_LOTE   NUMBER not null,
  constraint LOTES_PK
  primary key (ID_INSUMO, ID_LOTE),
  constraint LOTES_INSUMO_CLINICAS_FK
  foreign key (INSUMO_CLINICAS_ID_INSUMO, INSUMO_CLINICAS_ID_LOTE) references INSUMO_CLINICAS
)
/

create table PRODUCTO_FARMACIA
(
  ID_FARMACIA NUMBER not null
    constraint FARMACIA_FARMACIAS_FK
    references FARMACIAS,
  ID_INSUMO   NUMBER not null
    constraint FARMACIA_INSUMO_FK
    references INSUMO,
  CANTIDAD    NUMBER(4)
)
/

create table SIGNOS_VITALES
(
  ID_SIGNOS_VITALES NUMBER not null
    constraint SIGNOS_VITALES_PK
    primary key,
  ID_PERSONA        NUMBER,
  FECHA_REGISTRO    DATE,
  USUARIO_REGISTRO  VARCHAR2(25),
  PRESION           NUMBER(5, 2),
  PULSO             NUMBER(5, 2),
  RESPIRACION       NUMBER(5, 2),
  PESO              NUMBER(5, 2),
  ALTURA            NUMBER(5, 2),
  TEMPERATURA       NUMBER(5, 2)
)
/

create table STATUS
(
  ID_STATUS     NUMBER not null
    constraint STATUS_PK
    primary key,
  NOMBRE_STATUS VARCHAR2(50)
)
/

create table TIPO_DOCUMENTOS_PAGO
(
  ID_TIPO_DOCUMENTO NUMBER not null
    constraint TIPO_DOCUMENTOS_PK
    primary key
    constraint TIPODOCPAG_DETPAGO
    references DETALLE_PAGO,
  DOCUMENTO         VARCHAR2(50)
)
/

create table TIPO_PAGO_CLIENTES
(
  ID_TIPO_PAGO      NUMBER not null
    constraint TIPO_PAGO_CLIENTES_PK
    primary key,
  TIPO_PAGO_CLIENTE VARCHAR2(100)
)
/

create table TIPO_PERSONAL_TECNICO
(
  ID_TIPO_PERSONAL_T NUMBER not null
    constraint TIPO_PERSONAL_TECNICO_PK
    primary key,
  DESCRIPCION        VARCHAR2(50)
)
/

create table TIPO_SANGRE
(
  ID_TIPO_SANGRE   NUMBER not null
    constraint TIPO_SANGRE_PK
    primary key,
  TIPO_SANGRE      VARCHAR2(10),
  USUARIO_REGISTRO VARCHAR2(25)
)
/

create trigger T_SEQ_TIPO_SANGRE
  before insert
  on TIPO_SANGRE
  for each row
  begin
    if (inserting)
    then
      if ((:new.ID_TIPO_SANGRE is null) or (:new.ID_TIPO_SANGRE = 0))
      then
        select SEQ_TIPO_SANGRE.NEXTVAL into :new.ID_TIPO_SANGRE from DUAL;
      end if;
    end if;
  end T_SEQ_TIPO_SANGRE;
/

create table TIPO_SEGURO
(
  ID_TIPO_SEGURO NUMBER not null
    constraint TIPO_SEGURO_PK
    primary key,
  TIPO_SEGURO    VARCHAR2(30)
)
/

create trigger T_SEQ_TIPO_SEGURO
  before insert
  on TIPO_SEGURO
  for each row
  begin
    if (inserting)
    then
      if ((:new.ID_TIPO_SEGURO is null) or (:new.ID_TIPO_SEGURO = 0))
      then
        select SEQ_TIPO_SEGURO.NEXTVAL into :new.ID_TIPO_SEGURO from DUAL;
      end if;
    end if;
  end T_SEQ_TIPO_SEGURO;
/

create table SEGURO
(
  ID_SEGURO       NUMBER not null
    constraint SEGURO_PK
    primary key,
  ID_TIPO_SEGURO  NUMBER not null
    constraint SEGURO_TIPO_SEGURO_FK
    references TIPO_SEGURO,
  SEGURO          VARCHAR2(30),
  FECHA_REGISTRO  DATE,
  VIGENCIA_SEGURO DATE
)
/

create trigger T_SEQ_SEGURO
  before insert
  on SEGURO
  for each row
  begin
    if (inserting)
    then
      if ((:new.ID_SEGURO is null) or (:new.ID_SEGURO = 0))
      then
        select SEQ_SEGURO.NEXTVAL into :new.ID_SEGURO from DUAL;
      end if;
    end if;
  end T_SEQ_SEGURO;
/

create table TIPO_SERVICIO
(
  ID_TIPO_SERVICIO NUMBER not null
    constraint TIPO_SERVICIO_PK
    primary key,
  TIPO_SERVICIO    VARCHAR2(100),
  PRECIO_PUBLICO   NUMBER(5),
  PRECIO_COSTO     NUMBER(5)
)
/

create table TIPO_SUSPENCION
(
  ID_TIPO_SUSPENCION NUMBER not null
    constraint TIPO_SUSPENCION_PK
    primary key,
  TIPO_SUSPENCION    VARCHAR2(50)
)
/

create trigger T_SEQ_TIPO_SUSPENCION
  before insert
  on TIPO_SUSPENCION
  for each row
  begin
    if (inserting)
    then
      if ((:new.ID_TIPO_SUSPENCION is null) or (:new.ID_TIPO_SUSPENCION = 0))
      then
        select SEQ_TIPO_SUSPENCION.NEXTVAL into :new.ID_TIPO_SUSPENCION from DUAL;
      end if;
    end if;
  end T_SEQ_TIPO_SUSPENCION;
/

create table TIPO_TELEFONO
(
  ID_TIPO_TELEFONO NUMBER not null
    constraint TIPO_TELEFONO_PK
    primary key,
  TIPO_TELEFONO    VARCHAR2(50)
)
/

create trigger T_SEQ_TIPO_TELEFONO
  before insert
  on TIPO_TELEFONO
  for each row
  begin
    if (inserting)
    then
      if ((:new.ID_TIPO_TELEFONO is null) or (:new.ID_TIPO_TELEFONO = 0))
      then
        select SEQ_TIPO_TELEFONO.NEXTVAL into :new.ID_TIPO_TELEFONO from DUAL;
      end if;
    end if;
  end T_SEQ_TIPO_TELEFONO;
/

create table TELEFONO
(
  ID_TELEFONO      NUMBER not null
    constraint TELEFONO_PK
    primary key,
  ID_TIPO_TELEFONO NUMBER
    constraint TIPOTELEFONO_T___FK
    references TIPO_TELEFONO,
  ID_COMPANIA      NUMBER
    constraint COMPANIAT___FK
    references COMPANIA_TELEFONO,
  TELEFONO         NUMBER(15)
)
/

create trigger T_SEQ_TELEFONO
  before insert
  on TELEFONO
  for each row
  begin
    if (inserting)
    then
      if ((:new.ID_TELEFONO is null) or (:new.ID_TELEFONO = 0))
      then
        select SEQ_TELEFONO.NEXTVAL into :new.ID_TELEFONO from DUAL;
      end if;
    end if;
  end T_SEQ_TELEFONO;
/

create table PERSONA
(
  ID_PERSONA       NUMBER not null
    constraint PERSONA_PK
    primary key,
  ID_TELEFONO      NUMBER
    constraint TELEFONO_P___FK
    references TELEFONO,
  ID_SEGURO        NUMBER,
  ID_TIPO_SANGRE   NUMBER not null
    constraint PERSONA_TIPO_SANGRE_FK
    references TIPO_SANGRE,
  ID_ROL           NUMBER not null
    constraint PERSONA_ROL_FK
    references ROL_PERSONA,
  PRIMER_NOMBRE    VARCHAR2(30),
  SEGUNDO_NOMBRE   VARCHAR2(30),
  PRIMER_APELLIDO  VARCHAR2(30),
  SEGUNDO_APELLIDO VARCHAR2(30),
  APELLIDO_CASADA  VARCHAR2(30),
  FECHA_NACIMIENTO DATE,
  GENERO           VARCHAR2(1)
    constraint CHECKGENERO
    check (GENERO = 'F' OR GENERO = 'M')
)
/

create table CITA
(
  ID_CITA             NUMBER not null
    constraint CITA_PK
    primary key,
  ID_SEGURO           NUMBER not null
    constraint CITA_SEGURO_FK
    references SEGURO,
  ID_PERSONA_PACIENTE NUMBER not null
    constraint CITA_PERSONA_FK
    references PERSONA,
  CITA                VARCHAR2(30),
  FECHA_REGISTRO      DATE,
  USUARIO_REGISTRO    VARCHAR2(25),
  FECHA_CITA          DATE,
  HORA_CITA           DATE,
  ID_CLINICA          NUMBER not null
    constraint CITA_CLINICAS_FK
    references CLINICAS
)
/

create table DOCUMENTO_PERSONA
(
  ID_TIPO_DOCUMENTO NUMBER not null
    constraint DOCUMENTO_PERSONA_PK
    primary key,
  ID_PERSONA        NUMBER not null
    constraint DOCUMENTO_PERSONA_PERSONA_FK
    references PERSONA
)
/

create table ENCARGADO_SEDE
(
  ID_PERSONA        NUMBER not null
    constraint ENCARGADO_SEDE_PERSONA_FK
    references PERSONA,
  ID_SEDE           NUMBER not null
    constraint ENCARGADO_SEDE_SEDE_FK
    references SEDE,
  ID_ENCARGADO_SEDE NUMBER not null
    constraint ENCARGADO_SEDE_PK
    primary key
)
/

create table EXAMENES
(
  ID_EXAMEN        NUMBER not null
    constraint EXAMENES_PK
    primary key,
  EXAMEN           VARCHAR2(100),
  OBSERVACIONES    VARCHAR2(100),
  USUARIO_REGISTRO NUMBER
    constraint PERSONA_E___FK
    references PERSONA,
  FECHA_REGISTRO   DATE
)
/

create table EXAMEN_PERSONA
(
  ID_PERSONA   NUMBER not null
    constraint EXAMEN_PERSONA_PERSONA_FK
    references PERSONA,
  ID_EXAMEN    NUMBER not null
    constraint EXAMEN_PERSONA_EXAMENES_FK
    references EXAMENES,
  RESULTADO    VARCHAR2(500),
  FECHA_EXAMEN DATE,
  constraint EXAMEN_PERSONA_PK
  primary key (ID_PERSONA, ID_EXAMEN)
)
/

create table HISTORIAL_CLINICO
(
  ID_HISTORIAL_CLINICO NUMBER not null
    constraint HISTORIAL_CLINICO_PK
    primary key,
  ID_PERSONA           NUMBER not null
    constraint HISTORIAL_CLINICO_PERSONA_FK
    references PERSONA,
  ID_SIGNOS_VITALES    NUMBER not null
    constraint HISTORIAL_SIGNOS
    references SIGNOS_VITALES,
  VIA_INGRESO          VARCHAR2(50),
  USUARIO_REGISTRO     VARCHAR2(25),
  CLINICA              VARCHAR2(50),
  OBSERVACIONES        VARCHAR2(1000),
  FECHA_INGRESO        DATE,
  ALTURA               NUMBER(5),
  PESO_ACTUAL          NUMBER(4),
  PESO_ANTERIOR        NUMBER(4),
  MEDIDA_CINTURA       NUMBER(5),
  MASA_MUSCULAR        NUMBER(4),
  FECHA_REGISTRO       DATE,
  PRESION_ARTERIAL     VARCHAR2(5)
)
/

create trigger T_SEQ_HISTORIAL_CLINICO
  before insert
  on HISTORIAL_CLINICO
  for each row
  begin
    if (inserting)
    then
      if ((:new.ID_HISTORIAL_CLINICO is null) or (:new.ID_HISTORIAL_CLINICO = 0))
      then
        select SEQ_HISTORIAL_CLINICO.NEXTVAL into :new.ID_HISTORIAL_CLINICO from DUAL;
      end if;
    end if;
  end T_SEQ_HISTORIAL_CLINICO;
/

create table MEDICO
(
  ID_PERSONA      NUMBER not null
    constraint MEDICO_PK
    primary key
    constraint MEDICO_PERSONA_FK
    references PERSONA,
  ID_MEDICO       NUMBER,
  ID_ESPECIALIDAD NUMBER not null,
  FECHA_INGRESO   DATE
)
/

create table ESPECIALIDAD_MEDICO
(
  ID_MEDICO       NUMBER not null
    constraint ESPECIAL_MEDICO
    references MEDICO,
  ID_ESPECIALIDAD NUMBER not null
    constraint ESPECIALIDAD_ESPECIAMD
    references ESPECIALIDAD,
  FECHA_REGISTRO  DATE,
  constraint ESPECIALIDAD_MEDICO_PK
  primary key (ID_MEDICO, ID_ESPECIALIDAD)
)
/

create table PACIENTE_ODONTOLOGIA
(
  ID_PERSONA              NUMBER not null
    constraint PACIENTE_PK
    primary key
    constraint ODONTO_PERSONA
    references PERSONA,
  ID_PACIENTE_ODONTOLOGIA NUMBER,
  ID_MEDICO               NUMBER,
  ID_CLINICA              NUMBER not null
    constraint ODONTO_CLINICAS
    references CLINICAS
)
/

create table PERSONAL_TECNICO
(
  ID_PERSONAL_T            NUMBER not null
    constraint PERSONAL_TECNICO_PK
    primary key,
  ID_TIPO_PERSONAL_TECNICO NUMBER not null
    constraint PERSONAL_TECNICO
    references TIPO_PERSONAL_TECNICO,
  ID_PERSONA               NUMBER not null
    constraint PERSONAL_TECNICO_PERSONA_FK
    references PERSONA
)
/

create table RAZON_SOCIAL_PERSONA
(
  ID_RAZON_SOCIAL      NUMBER not null
    constraint RAZON_SOCIAL_PERSONA_PK
    primary key,
  ID_PERSONA           NUMBER not null
    constraint RAZONSOCIAL_PERSONA
    references PERSONA,
  ID_TIPO_RAZON_SOCIAL VARCHAR2(100),
  NIT                  VARCHAR2(25)
)
/

create table CLIENTE
(
  ID_CLIENTE        NUMBER not null
    constraint CLIENTE_PK
    primary key,
  ID_PERSONA        NUMBER not null
    constraint CLIENTE_PERSONA_FK
    references PERSONA,
  ID_RAZON_SOCIAL_P NUMBER not null
    constraint CLIENTE_RSOCIALP
    references RAZON_SOCIAL_PERSONA
)
/

create table RESULTADOS_LABORATORIOS
(
  ID_EXAMEN        NUMBER not null
    constraint LABORATORIO_EXAMEN
    references EXAMENES,
  ID_LABORATORISTA NUMBER not null
    constraint RESULTADO_PERSONALTECNICO
    references PERSONAL_TECNICO,
  RESULTADO        VARCHAR2(100)
)
/

create table ROL_USUARIO
(
  ID_USUARIO        NUMBER not null,
  ID_ROL_USUARIO    NUMBER not null
    constraint ROL_USUARIO_ROL_FK
    references ROL,
  ID_ROL_APLICACION NUMBER not null
    constraint ID_ROLAPLICACION_USUARIO
    references ROL_APLICACION,
  ID_PERSONA        NUMBER not null
    constraint ROL_USUARIO_PERSONA_FK
    references PERSONA,
  constraint ROL_USUARIO_NEW_PK
  primary key (ID_ROL_USUARIO, ID_USUARIO)
)
/

create table SUSPENCION_MEDICA
(
  ID_SUSPENCION      NUMBER not null
    constraint SUSPENCION_MEDICA_PK
    primary key,
  ID_TIPO_SUSPENCION NUMBER not null
    constraint SUSPEN_TIPOSUSPEN
    references TIPO_SUSPENCION,
  ID_PERSONA         NUMBER not null
    constraint SUSPENCION_MEDICA_PERSONA_FK
    references PERSONA,
  SUSPENCION         VARCHAR2(50),
  USUARIO_REGISTRO   VARCHAR2(25),
  FECHA_REGISTRO     DATE,
  MOTIVO             VARCHAR2(500)
)
/

create trigger T_SEQ_SUSPENSION_MEDICA
  before insert
  on SUSPENCION_MEDICA
  for each row
  begin
    if (inserting)
    then
      if ((:new.ID_SUSPENCION is null) or (:new.ID_SUSPENCION = 0))
      then
        select SEQ_SUSPENSION_MEDICA.NEXTVAL into :new.ID_SUSPENCION from DUAL;
      end if;
    end if;
  end T_SEQ_SUSPENSION_MEDICA;
/

create table SUSPENCION_PERSONA
(
  ID_SUSPENCION NUMBER not null
    constraint SUSPENCION_PERSONA_PK
    primary key,
  ID_PERSONA    NUMBER not null
    constraint SUSPENCION_PERSONA_PERSONA_FK
    references PERSONA
)
/

create table TELEFONO_PROVEEDORES
(
  ID_TELEFONO  NUMBER not null
    constraint TELEFONO_PROVEEDORES_PK
    primary key
    constraint TELPROV_TEL
    references TELEFONO,
  ID_PROVEEDOR NUMBER
)
/

create table TIPO_DOCUMENTO
(
  ID_TIPO_DOCUMENTO NUMBER not null
    constraint TIPO_DOCUMENTO_PK
    primary key
    constraint TIPODOC_DOCPERSONA
    references DOCUMENTO_PERSONA,
  TIPO_DOCUMENTO    VARCHAR2(30)
)
/

create table TIPO_ENFERMEDAD
(
  ID_TIPO_ENFERMEDAD NUMBER not null
    constraint TIPO_ENFERMEDAD_PK
    primary key,
  TIPO_ENFERMEDAD    VARCHAR2(50),
  USUARIO_REGISTRO   NUMBER
    constraint PERSONA_T_E___FK
    references PERSONA,
  FECHA_REGISTRO     DATE
)
/

create trigger T_SEQ_TIPO_ENFERMEDAD
  before insert
  on TIPO_ENFERMEDAD
  for each row
  begin
    if (inserting)
    then
      if ((:new.ID_TIPO_ENFERMEDAD is null) or (:new.ID_TIPO_ENFERMEDAD = 0))
      then
        select SEQ_TIPO_ENFERMEDAD.NEXTVAL into :new.ID_TIPO_ENFERMEDAD from DUAL;
      end if;
    end if;
  end T_SEQ_TIPO_ENFERMEDAD;
/

create table ENFERMEDAD
(
  ID_ENFERMEDAD      NUMBER not null
    constraint ENFERMEDAD_PK
    primary key,
  ID_TIPO_ENFERMEDAD NUMBER not null
    constraint ENFERMEDAD_TIPO_ENFERMEDAD_FK
    references TIPO_ENFERMEDAD,
  ENFERMEDAD         VARCHAR2(50),
  USUARIO_REGISTRO   NUMBER
    constraint PERSONA_ENF__FK
    references PERSONA,
  DESCRIPCION        VARCHAR2(500),
  SOLUCION           VARCHAR2(500),
  FECHA_REGISTRO     DATE
)
/

create trigger T_SEQ_ENFERMEDAD
  before insert
  on ENFERMEDAD
  for each row
  begin
    if (inserting)
    then
      if ((:new.ID_ENFERMEDAD is null) or (:new.ID_ENFERMEDAD = 0))
      then
        select SEQ_ENFERMEDAD.NEXTVAL into :new.ID_ENFERMEDAD from DUAL;
      end if;
    end if;
  end T_SEQ_ENFERMEDAD;
/

create table DIAGNOSTICO
(
  ID_DIAGNOSTICO       NUMBER not null
    constraint DIAGNOSTICO_PK
    primary key,
  ID_PERSONA           NUMBER not null
    constraint DIAGNOSTICO_PERSONA_FK
    references PERSONA,
  ID_HISTORIAL_CLINICO NUMBER not null
    constraint DIAGNOSTICOEHISTCLINC
    references HISTORIAL_CLINICO,
  DIAGNOSTICO          VARCHAR2(100),
  FECHA_REGISTRO       DATE,
  ID_ENFERMEDAD        NUMBER not null
    constraint DIAGNOSTICO_ENFERMEDAD_FK
    references ENFERMEDAD
)
/

create table MOVIMIENTOS_HISTORIAL
(
  ID_MOVIMIENTO_HISTORIAL NUMBER not null
    constraint MOVIMIENTOS_HISTORIAL_PK
    primary key,
  ID_ENFERMEDAD           NUMBER not null
    constraint HISTORIAL_ENFER
    references ENFERMEDAD,
  ID_EXAMEN               NUMBER not null
    constraint MOVIMIENTO_EXAMENES
    references EXAMENES,
  ID_SUSPENCION           NUMBER,
  FALLECIMIENTO           VARCHAR2(50),
  ALTAS                   VARCHAR2(50),
  USUARIO_REGISTRO        NUMBER
    constraint M_H___FK
    references PERSONA,
  FECHA_REGISTRO          DATE
)
/

create table TIPO_RAZON_SOCIAL
(
  ID_TIPO_RAZON_SOCIAL NUMBER not null
    constraint TIPO_RAZON_SOCIAL_PK
    primary key
    constraint ID_RAZONSOCIAL
    references RAZON_SOCIAL_PERSONA,
  TIPO_RAZON_SOCIAL    VARCHAR2(100)
)
/

create table TRANSACCIONES
(
  ID_TRANSACCION   NUMBER not null
    constraint TRANSACCIONES_PK
    primary key,
  ID_FACTURA       NUMBER,
  ID_CLIENTE       NUMBER,
  ID_CAJA          NUMBER,
  ID_PAGO          NUMBER,
  USUARIO_REGISTRO VARCHAR2(25)
)
/

create table FACTURACION
(
  ID_FACTURA        NUMBER not null
    constraint FACTURACION_PK
    primary key,
  ID_CLIENTE        NUMBER not null
    constraint FACTURACION_CLIENTE_FK
    references CLIENTE,
  ID_TIPO_SERVICIO  NUMBER not null,
  CANTIDAD          NUMBER,
  TOTAL             NUMBER(5, 2),
  FECHA_TRANSACCION DATE,
  USUARIO_REGISTRO  VARCHAR2(25),
  ID_TRANSACCION    NUMBER not null
    constraint FACTURACION_TRANSACCIONES_FK
    references TRANSACCIONES
)
/

create table DETALLE_FACTURA
(
  ID_DETALLE_FACTURA NUMBER not null
    constraint DETALLE_FACTURA_PK
    primary key,
  ID_FACTURA         NUMBER not null
    constraint DETALLE_FACTURA_FACTURACION_FK
    references FACTURACION,
  ID_TIPO_SERVICIO   NUMBER not null
    constraint DETALLE_TIPOSERVICIO
    references TIPO_SERVICIO
)
/

create table PAGOS_CLIENTES
(
  ID_PAGO          NUMBER not null
    constraint PAGOS_CLIENTES_PK
    primary key,
  ID_TRANSACCION   NUMBER not null
    constraint PAGOS_TRANSAC
    references TRANSACCIONES,
  ID_TIPO_PAGO     NUMBER not null
    constraint PAGO_TIPOPAGOS
    references TIPO_PAGO_CLIENTES,
  MONTO_CANCELADO  NUMBER(5, 2),
  USUARIO_REGISTRO VARCHAR2(25)
)
/

create table ZONAS
(
  ID_ZONA          NUMBER not null
    constraint ZONAS_PK
    primary key,
  ID_MUNICIPIO     NUMBER
    constraint MUNICIPIO_Z___FK
    references MUNICIPIO,
  ZONA             NUMBER(2),
  FECHA_REGISTRO   DATE,
  USUARIO_REGISTRO VARCHAR2(25)
)
/

create trigger T_SEQ_ZONAS
  before insert
  on ZONAS
  for each row
  begin
    if (inserting)
    then
      if ((:new.ID_ZONA is null) or (:new.ID_ZONA = 0))
      then
        select SEQ_ZONAS.NEXTVAL into :new.ID_ZONA from DUAL;
      end if;
    end if;
  end T_SEQ_ZONAS;
/

create table DIRECCION
(
  ID_DIRECCION  NUMBER not null
    constraint DIRECCION_PK
    primary key,
  ID_ZONA       NUMBER not null
    constraint DIRECCION_ZONAS_FK
    references ZONAS,
  ID_MUNICIPIO  NUMBER not null
    constraint DIRECCION_MUNICIPIOS_FK
    references MUNICIPIO,
  ID_COLONIA    NUMBER not null
    constraint DIRECCION_COLONIA_FK
    references COLONIA,
  CALLE_AVENIDA VARCHAR2(200),
  NUMERO        VARCHAR2(50),
  EDIFICIO      VARCHAR2(200)
)
/

create table DIRECCION_PERSONA
(
  ID_DIRECCION NUMBER not null
    constraint DIRECCION_PERSONA_DIRECCION_FK
    references DIRECCION,
  ID_PERSONA   NUMBER not null
    constraint DIRECCION_PERSONA_PERSONA_FK
    references PERSONA,
  constraint DIRECCION_PERSONA_PK
  primary key (ID_DIRECCION, ID_PERSONA)
)
/

create table DIRECCION_PROVEEDORES
(
  ID_DIRECCION_PROV NUMBER not null
    constraint DIRECCION_PROVEEDORES_PK
    primary key
    constraint DIRECC_PROVEE
    references DIRECCION,
  ID_PROVEEDOR      NUMBER
)
/

create table PROVEEDORES
(
  ID_PROVEEDOR                   NUMBER not null
    constraint PROVEEDORES_PK
    primary key
    constraint PROV_DIRECCION
    references DIRECCION_PROVEEDORES
    constraint PROV_TELEFONO
    references TELEFONO_PROVEEDORES,
  RAZON_SOCIAL                   VARCHAR2(200),
  NIT                            VARCHAR2(50),
  REPRESENTANTE_LEGAL_ID_PERSONA NUMBER,
  STATUS_PROVEEDOR               NUMBER
)
/

create table CUENTAS_POR_PAGAR
(
  ID_CUENTA         NUMBER not null
    constraint CUENTAS_POR_PAGAR_PK
    primary key,
  ID_PROVEEDOR      NUMBER not null
    constraint PORPAGARYPROVEE
    references PROVEEDORES,
  ID_COMPRA         NUMBER,
  ID_PAGO_REALIZADO NUMBER not null,
  ID_STATUS_PAGO    NUMBER not null
    constraint CUENTAS_POR_PAGAR_STATUS_FK
    references STATUS
)
/

create table CUENTA_PROVEEDORES
(
  ID_CUENTA_PROV  NUMBER not null
    constraint CUENTA_PROVEEDORES_PK
    primary key
    constraint RELACION_CUENTAS
    references CUENTAS_POR_PAGAR,
  ID_PROVEEDOR    NUMBER not null
    constraint CUENTAYPROVEEDORES
    references PROVEEDORES,
  ID_BANCO_CUENTA NUMBER not null
    constraint CUENTA_PROVEEDORES_BANCOS_FK
    references BANCOS,
  CUENTA          VARCHAR2(50)
)
/

create table PAGO_PROVEEDORES
(
  ID_PAGO      NUMBER not null
    constraint PAGO_PK
    primary key
    constraint PAGO_DETALLE_PAGO_FK
    references DETALLE_PAGO,
  FECHA_PAGO   DATE,
  ID_PROVEEDOR NUMBER not null
    constraint PAGO_PROVEEDORES_FK
    references PROVEEDORES
)
/

create table TIPO_ODONTOLOGIA
(
  ID_ODONTOLOGIA NUMBER(5) not null
    primary key,
  DESCRIPCION    VARCHAR2(1000)
)
/

create table TIPO_PACIENTE_O
(
  IDTIPOPACIENTE    NUMBER(5) not null
    primary key,
  IDPACIENTE        NUMBER    not null
    constraint PACIENTE_FK
    references PACIENTE_ODONTOLOGIA,
  IDTIPOODONTOLOGIA NUMBER(5) not null
    constraint TIPO_FK
    references TIPO_ODONTOLOGIA,
  IDDIAGNOSTICO     NUMBER    not null
    constraint DIAGNOSTICO_FK
    references DIAGNOSTICO,
  OBSERVACION       VARCHAR2(1000),
  FECHAREGISTRO     DATE
)
/

create table ALIMENTO
(
  ID_ALIMENTO NUMBER(9)     not null
    constraint ALIMENTO_PK
    primary key,
  ALIMENTO    VARCHAR2(128) not null
    unique
)
/

create table TIEMPO_COMIDA
(
  ID_TIEMPO_COMIDA NUMBER(5)     not null
    constraint TIEMPO_COMIDA_PK
    primary key,
  TIEMPO           VARCHAR2(128) not null
    unique
)
/

create table DIETA
(
  ID_DIETA       NUMBER(9) not null
    constraint DIETA_PK
    primary key,
  ID_CITA        NUMBER    not null
    constraint DIETA_CITA_FK
    references CITA,
  ID_MEDICO      NUMBER    not null
    constraint DIETA_MEDICO_FK
    references MEDICO,
  ID_DIAGNOSTICO NUMBER    not null
    constraint DIETA_DIAGNOSTICO_FK
    references DIAGNOSTICO
)
/

create table DETALLE_DIETA
(
  ID_DETALLE_DIETA NUMBER(9)     not null
    constraint DETALLE_DIETA_PK
    primary key,
  ID_DIETA         NUMBER(9)     not null
    constraint DETALLE_DIETA_FK
    references DIETA,
  ID_ALIMENTO      NUMBER(9)     not null
    constraint DETALLE_ALIMENTO_FK
    references ALIMENTO,
  CANTIDAD         VARCHAR2(100) not null,
  ID_TIEMPO_COMIDA NUMBER(5)     not null
    constraint DETALLE_TIEMPO_FK
    references TIEMPO_COMIDA,
  DESCRIPCION      VARCHAR2(1024)
)
/

comment on column DETALLE_DIETA.CANTIDAD
is 'Cantidad de alimento, gramos, cucharadas, vasos, porciones, etc.'
/

comment on column DETALLE_DIETA.DESCRIPCION
is 'Descripcion de como cocinar o consumir el alimento.'
/

create table BITACORA_HISTORIAL_CLINICO
(
  USUARIO          VARCHAR2(40),
  MODIFICADO       DATE,
  ALTURA           VARCHAR2(40),
  PESO_ACTUAL      VARCHAR2(10),
  PESO_ANTERIOR    VARCHAR2(10),
  MEDIDA_CINTURA   VARCHAR2(10),
  MASA_MUSCULAR    VARCHAR2(10),
  PRESION_ARTERIAL VARCHAR2(5)
)
/

create trigger TRG_CONSULTA
  before insert or update or delete
  on HISTORIAL_CLINICO
  for each row
  BEGIN
    IF INSERTING
    THEN
      INSERT INTO BITACORA_HISTORIAL_CLINICO
      VALUES (USER,
              SYSDATE,
              :NEW.ALTURA,
              :NEW.PESO_ACTUAL,
              :NEW.PESO_ANTERIOR,
              :NEW.MEDIDA_CINTURA,
              :NEW.MASA_MUSCULAR,
              :NEW.PRESION_ARTERIAL);
    END IF;

    IF UPDATING
    THEN
      INSERT INTO BITACORA_HISTORIAL_CLINICO
      VALUES (USER,
              SYSDATE,
              :OLD.ALTURA,
              :OLD.PESO_ACTUAL,
              :OLD.PESO_ANTERIOR,
              :OLD.MEDIDA_CINTURA,
              :OLD.MASA_MUSCULAR,
              :OLD.PRESION_ARTERIAL);
    END IF;

    IF DELETING
    THEN
      INSERT INTO BITACORA_HISTORIAL_CLINICO
      VALUES (USER,
              SYSDATE,
              :OLD.ALTURA,
              :OLD.PESO_ACTUAL,
              :OLD.PESO_ANTERIOR,
              :OLD.MEDIDA_CINTURA,
              :OLD.MASA_MUSCULAR,
              :OLD.PRESION_ARTERIAL);
    END IF;
  END;
/

create table BITACORA_SUSPENCION
(
  USUARIO    VARCHAR2(10),
  MODIFICADO DATE,
  SUSPENSION VARCHAR2(50),
  MOTIVO     VARCHAR2(500)
)
/

create trigger TRG_SUSPENCION
  before insert or update or delete
  on SUSPENCION_MEDICA
  for each row
  BEGIN
    IF INSERTING
    THEN
      INSERT INTO BITACORA_SUSPENCION VALUES (USER, SYSDATE, :NEW.SUSPENCION, :NEW.MOTIVO);
    END IF;

    IF UPDATING
    THEN
      INSERT INTO BITACORA_SUSPENCION VALUES (USER, SYSDATE, :OLD.SUSPENCION, :OLD.MOTIVO);
    END IF;

    IF DELETING
    THEN
      INSERT INTO BITACORA_SUSPENCION VALUES (USER, SYSDATE, :OLD.SUSPENCION, :OLD.MOTIVO);
    END IF;
  END;
/

create PACKAGE paquete_rol AS
  PROCEDURE agregar_rol(Cnombre varchar2, Cdescripcion varchar2, Cusuario varchar2, Cactivo integer);
END paquete_rol;
/

create PACKAGE BODY paquete_rol AS
  PROCEDURE agregar_rol(Cnombre varchar2, Cdescripcion varchar2, Cusuario varchar2, Cactivo integer) IS
    BEGIN
      INSERT INTO ROL (id_rol_usuario, nombre, descripcion_rol, fecha_creacion, usuario_creacion, status)
      VALUES ((SELECT max(id_rol_usuario) + 1 FROM ROL), Cnombre, Cdescripcion, SYSDATE, Cusuario, Cactivo);
    END agregar_rol;
END paquete_rol;
/

create PACKAGE mod_expediente AS
  PROCEDURE suspencion_medica_por_persona(persona     INTEGER,
                                          fechaInicio VARCHAR2,
                                          fechaFin    VARCHAR2);

END mod_expediente;
/

create PACKAGE BODY mod_expediente AS
  -- body
  PROCEDURE suspencion_medica_por_persona(persona     INTEGER,
                                          fechaInicio VARCHAR2,
                                          fechaFin    VARCHAR2) IS
    BEGIN
      SELECT *
      FROM suspencion_medica
             JOIN persona ON suspencion_medica.id_persona = persona.id_persona
      WHERE suspencion_medica.fecha_registro >= fechaInicio
        AND suspencion_medica.fecha_registro >= fechaFin;
    END suspencion_medica_por_persona;
END mod_expediente;
/


-- ////// Sequences and Triggers
--ESPECIALIDAD
CREATE SEQUENCE  "PDB1"."SEQ_ESPECIALIDAD"
   MINVALUE 1
   MAXVALUE 9999999999999999999999999999
   INCREMENT BY 1
   START WITH 1
   CACHE 2
   NOORDER
   NOCYCLE ;

create or replace trigger T_SEQ_ESPECIALIDAD
  before insert
  on ESPECIALIDAD
  for each row
begin
  if (inserting)
  then
    if ((:new.ID_ESPECIALIDAD is null) or (:new.ID_ESPECIALIDAD = 0))
    then
      select SEQ_ESPECIALIDAD.NEXTVAL into :new.ID_ESPECIALIDAD
      from DUAL;
    end if;
  end if;
end T_SEQ_ESPECIALIDAD;

-- ROL_APLICACION
CREATE SEQUENCE  "PDB1"."SEQ_ROL_APLICACION"
   MINVALUE 1
   MAXVALUE 9999999999999999999999999999
   INCREMENT BY 1
   START WITH 1
   CACHE 2
   NOORDER
   NOCYCLE ;

create or replace trigger T_SEQ_ROL_APLICACION
  before insert
  on ROL_APLICACION
  for each row
begin
  if (inserting)
  then
    if ((:new.ID_ROL_APLICACION is null) or (:new.ID_ROL_APLICACION = 0))
    then
      select SEQ_ROL_APLICACION.NEXTVAL into :new.ID_ROL_APLICACION
      from DUAL;
    end if;
  end if;
end T_SEQ_ROL_APLICACION;

--ROL
CREATE SEQUENCE  "PDB1"."SEQ_ROL"
   MINVALUE 1
   MAXVALUE 9999999999999999999999999999
   INCREMENT BY 1
   START WITH 1
   CACHE 2
   NOORDER
   NOCYCLE ;

create or replace trigger T_SEQ_ROL
  before insert
  on ROL
  for each row
begin
  if (inserting)
  then
    if ((:new.ID_ROL is null) or (:new.ID_ROL = 0))
    then
      select SEQ_ROL.NEXTVAL into :new.ID_ROL
      from DUAL;
    end if;
  end if;
end T_SEQ_ROL;

-- STATUS

CREATE SEQUENCE  "PDB1"."SEQ_ROL_APLICACION"
   MINVALUE 1
   MAXVALUE 9999999999999999999999999999
   INCREMENT BY 1
   START WITH 1
   CACHE 2
   NOORDER
   NOCYCLE ;

create or replace trigger T_SEQ_STATUS
  before insert
  on STATUS
  for each row
begin
  if (inserting)
  then
    if ((:new.ID_STATUS is null) or (:new.ID_STATUS = 0))
    then
      select SEQ_STATUS.NEXTVAL into :new.ID_STATUS
      from DUAL;
    end if;
  end if;
end T_SEQ_STATUS;

-- TIPO_PERSONA

CREATE SEQUENCE  "PDB1"."SEQ_TIPO_SEGURO"
   MINVALUE 1
   MAXVALUE 9999999999999999999999999999
   INCREMENT BY 1
   START WITH 1
   CACHE 2
   NOORDER
   NOCYCLE ;

create or replace trigger T_SEQ_TIPO_SEGURO
  before insert
  on TIPO_SEGURO
  for each row
begin
  if (inserting)
  then
    if ((:new.ID_TIPO_SEGURO is null) or (:new.ID_TIPO_SEGURO = 0))
    then
      select SEQ_TIPO_SEGURO.NEXTVAL into :new.ID_TIPO_SEGURO
      from DUAL;
    end if;
  end if;
end T_SEQ_TIPO_SEGURO;

-- CITA_PERSONA
CREATE SEQUENCE  "PDB1"."SEQ_CITA_PERSONA"
   MINVALUE 1
   MAXVALUE 9999999999999999999999999999
   INCREMENT BY 1
   START WITH 1
   CACHE 2
   NOORDER
   NOCYCLE ;

create or replace trigger T_SEQ_CITA_PERSONA
  before insert
  on CITA_PERSONA
  for each row
begin
  if (inserting)
  then
    if ((:new.ID_CITA_PERSONA is null) or (:new.ID_CITA_PERSONA = 0))
    then
      select SEQ_CITA_PERSONA.NEXTVAL into :new.ID_CITA_PERSONA
      from DUAL;
    end if;
  end if;
end T_SEQ_CITA_PERSONA;

--CITA
CREATE SEQUENCE  "PDB1"."SEQ_CITA"
   MINVALUE 1
   MAXVALUE 9999999999999999999999999999
   INCREMENT BY 1
   START WITH 1
   CACHE 2
   NOORDER
   NOCYCLE ;

create or replace trigger T_SEQ_CITA
  before insert
  on CITA
  for each row
begin
  if (inserting)
  then
    if ((:new.ID_CITA is null) or (:new.ID_CITA = 0))
    then
      select SEQ_CITA.NEXTVAL into :new.ID_CITA
      from DUAL;
    end if;
  end if;
end T_SEQ_CITA;

--CLINICA
CREATE SEQUENCE  "PDB1"."SEQ_CLINICA"
   MINVALUE 1
   MAXVALUE 9999999999999999999999999999
   INCREMENT BY 1
   START WITH 1
   CACHE 2
   NOORDER
   NOCYCLE ;

create or replace trigger T_SEQ_CLINICA
  before insert
  on CLINICA
  for each row
begin
  if (inserting)
  then
    if ((:new.ID_CLINICA is null) or (:new.ID_CLINICA = 0))
    then
      select SEQ_CLINICA.NEXTVAL into :new.ID_CLINICA
      from DUAL;
    end if;
  end if;
end T_SEQ_CLINICA;

--DIAGNOSTICO
CREATE SEQUENCE  "PDB1"."SEQ_DIAGNOSTICO"
   MINVALUE 1
   MAXVALUE 9999999999999999999999999999
   INCREMENT BY 1
   START WITH 1
   CACHE 2
   NOORDER
   NOCYCLE ;

create or replace trigger T_SEQ_DIAGNOSTICO
  before insert
  on DIAGNOSTICO
  for each row
begin
  if (inserting)
  then
    if ((:new.ID_DIAGNOSTICO is null) or (:new.ID_DIAGNOSTICO = 0))
    then
      select SEQ_DIAGNOSTICO.NEXTVAL into :new.ID_DIAGNOSTICO
      from DUAL;
    end if;
  end if;
end T_SEQ_DIAGNOSTICO;

--DOCUMENTO_PERSONA
CREATE SEQUENCE  "PDB1"."SEQ_DOCUMENTO_PERSONA"
   MINVALUE 1
   MAXVALUE 9999999999999999999999999999
   INCREMENT BY 1
   START WITH 1
   CACHE 2
   NOORDER
   NOCYCLE ;

create or replace trigger T_SEQ_DOCUMENTO_PERSONA
  before insert
  on DOCUMENTO_PERSONA
  for each row
begin
  if (inserting)
  then
    if ((:new.ID_DOCUMENTO_PERSONA is null) or (:new.ID_DOCUMENTO_PERSONA = 0))
    then
      select SEQ_DOCUMENTO_PERSONA.NEXTVAL into :new.ID_DOCUMENTO_PERSONA
      from DUAL;
    end if;
  end if;
end T_SEQ_DOCUMENTO_PERSONA;

--ENFERMEDAD
CREATE SEQUENCE  "PDB1"."SEQ_ENFERMEDAD"
   MINVALUE 1
   MAXVALUE 9999999999999999999999999999
   INCREMENT BY 1
   START WITH 1
   CACHE 2
   NOORDER
   NOCYCLE ;

create or replace trigger T_SEQ_ENFERMEDAD
  before insert
  on ENFERMEDAD
  for each row
begin
  if (inserting)
  then
    if ((:new.ID_ENFERMEDAD is null) or (:new.ID_ENFERMEDAD = 0))
    then
      select SEQ_ENFERMEDAD.NEXTVAL into :new.ID_ENFERMEDAD
      from DUAL;
    end if;
  end if;
end T_SEQ_ENFERMEDAD;

--ESPECIALIDAD_MEDICO
CREATE SEQUENCE  "PDB1"."SEQ_ESPECIALIDAD_MEDICO"
   MINVALUE 1
   MAXVALUE 9999999999999999999999999999
   INCREMENT BY 1
   START WITH 1
   CACHE 2
   NOORDER
   NOCYCLE ;

create or replace trigger T_SEQ_ESPECIALIDAD_MEDICO
  before insert
  on ESPECIALIDAD_MEDICO
  for each row
begin
  if (inserting)
  then
    if ((:new.ID_ESPECIALIDAD_MEDICO is null) or (:new.ID_ESPECIALIDAD_MEDICO = 0))
    then
      select SEQ_ESPECIALIDAD_MEDICO.NEXTVAL into :new.ID_ESPECIALIDAD_MEDICO
      from DUAL;
    end if;
  end if;
end T_SEQ_ESPECIALIDAD_MEDICO;

--HISTORIAL_CLINICO
CREATE SEQUENCE  "PDB1"."SEQ_HISTORIAL_CLINICO"
   MINVALUE 1
   MAXVALUE 9999999999999999999999999999
   INCREMENT BY 1
   START WITH 1
   CACHE 2
   NOORDER
   NOCYCLE ;

create or replace trigger T_SEQ_HISTORIAL_CLINICO
  before insert
  on HISTORIAL_CLINICO
  for each row
begin
  if (inserting)
  then
    if ((:new.ID_HISTORIAL_CLINICO is null) or (:new.ID_HISTORIAL_CLINICO = 0))
    then
      select SEQ_HISTORIAL_CLINICO.NEXTVAL into :new.ID_HISTORIAL_CLINICO
      from DUAL;
    end if;
  end if;
end T_SEQ_HISTORIAL_CLINICO;

--MEDICO
CREATE SEQUENCE  "PDB1"."SEQ_MEDICO"
   MINVALUE 1
   MAXVALUE 9999999999999999999999999999
   INCREMENT BY 1
   START WITH 1
   CACHE 2
   NOORDER
   NOCYCLE ;

create or replace trigger T_SEQ_MEDICO
  before insert
  on MEDICO
  for each row
begin
  if (inserting)
  then
    if ((:new.ID_MEDICO is null) or (:new.ID_MEDICO = 0))
    then
      select SEQ_MEDICO.NEXTVAL into :new.ID_MEDICO
      from DUAL;
    end if;
  end if;
end T_SEQ_MEDICO;

--RESULTADOS_LABORATORIO
CREATE SEQUENCE  "PDB1"."SEQ_RESULTADOS_LABORATORIO"
   MINVALUE 1
   MAXVALUE 9999999999999999999999999999
   INCREMENT BY 1
   START WITH 1
   CACHE 2
   NOORDER
   NOCYCLE ;

create or replace trigger T_SEQ_RESULTADOS_LABORATORIO
  before insert
  on RESULTADOS_LABORATORIO
  for each row
begin
  if (inserting)
  then
    if ((:new.ID_RESULTADOS_LABORATORIO is null) or (:new.ID_RESULTADOS_LABORATORIO = 0))
    then
      select SEQ_RESULTADOS_LABORATORIO.NEXTVAL into :new.ID_RESULTADOS_LABORATORIO
      from DUAL;
    end if;
  end if;
end T_SEQ_RESULTADOS_LABORATORIO;

--SEGURO
CREATE SEQUENCE  "PDB1"."SEQ_SEGURO"
   MINVALUE 1
   MAXVALUE 9999999999999999999999999999
   INCREMENT BY 1
   START WITH 1
   CACHE 2
   NOORDER
   NOCYCLE ;

create or replace trigger T_SEQ_SEGURO
  before insert
  on SEGURO
  for each row
begin
  if (inserting)
  then
    if ((:new.ID_SEGURO is null) or (:new.ID_SEGURO = 0))
    then
      select SEQ_SEGURO.NEXTVAL into :new.ID_SEGURO
      from DUAL;
    end if;
  end if;
end T_SEQ_SEGURO;

--TELEFONO
CREATE SEQUENCE  "PDB1"."SEQ_TELEFONO"
   MINVALUE 1
   MAXVALUE 9999999999999999999999999999
   INCREMENT BY 1
   START WITH 1
   CACHE 2
   NOORDER
   NOCYCLE ;

create or replace trigger T_SEQ_TELEFONO
  before insert
  on TELEFONO
  for each row
begin
  if (inserting)
  then
    if ((:new.ID_TELEFONO is null) or (:new.ID_TELEFONO = 0))
    then
      select SEQ_TELEFONO.NEXTVAL into :new.ID_TELEFONO
      from DUAL;
    end if;
  end if;
end T_SEQ_TELEFONO;