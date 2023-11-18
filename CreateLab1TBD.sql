CREATE DATABASE voluntariadoTBD
USE voluntariadoTBD

-- Tabla Habilidad
CREATE TABLE habilidad(
    id_habilidad SERIAL PRIMARY KEY,
    nombre_habilidad VARCHAR(50)
);

-- Tabla Estado_tarea
CREATE TABLE estado_tarea(
    id_estado_tarea SERIAL PRIMARY KEY,
    estado VARCHAR(50)
);

-- Tabla Coordinador
CREATE TABLE coordinador(
    id_coordinador SERIAL PRIMARY KEY,
    nombre_coordinador VARCHAR(50),
    email_coordinador VARCHAR(50),
    password_coordinador VARCHAR(50)
);

-- Tabla Institución
CREATE TABLE institucion(
    id_institucion SERIAL PRIMARY KEY,
    id_coordinador BIGINT REFERENCES coordinador(id_coordinador),
    nombre_institucion VARCHAR(100),
    telefono INT,
    ubicacion_institucion VARCHAR(50)
);

-- Tabla Emergencia
CREATE TABLE emergencia(
    id_emergencia SERIAL PRIMARY KEY,
    id_institucion BIGINT REFERENCES institucion(id_institucion),
    tipo VARCHAR(50),
    ubicacion VARCHAR(50),
    equipamiento_necesario VARCHAR(50),
    titulo VARCHAR(50),
    descripcion VARCHAR(100)
);

-- Tabla Eme_habilidad
CREATE TABLE eme_habilidad(
    id_eme_habilidad SERIAL PRIMARY KEY,
    id_emergencia BIGINT REFERENCES emergencia(id_emergencia),
    id_habilidad BIGINT REFERENCES habilidad(id_habilidad)
);

-- Tabla Tarea
CREATE TABLE tarea(
    id_tarea SERIAL PRIMARY KEY,
    id_emergencia BIGINT REFERENCES emergencia(id_emergencia),
    id_estado_tarea BIGINT REFERENCES estado_tarea(id_estado_tarea),
    nombre_tarea VARCHAR(50)
);

-- Tabla Voluntario
CREATE TABLE voluntario(
    id_voluntario SERIAL PRIMARY KEY,
    nombre_voluntario VARCHAR(50),
    edad INT,
    equipamiento VARCHAR(100),
    estado_salud BOOLEAN,
    disponibilidad BOOLEAN,
    email_voluntario VARCHAR(50),
    password_voluntario VARCHAR(50)
);

-- Tabla Ranking
CREATE TABLE ranking(
    id_ranking SERIAL PRIMARY KEY,
    id_voluntario BIGINT REFERENCES voluntario(id_voluntario),
    id_tarea BIGINT REFERENCES tarea(id_tarea),
    puntos_requisito INT
);

-- Tabla Vol_habilidad
CREATE TABLE vol_habilidad(
    id_vol_habilidad SERIAL PRIMARY KEY,
    id_voluntario BIGINT REFERENCES voluntario(id_voluntario),
    id_habilidad BIGINT REFERENCES habilidad(id_habilidad)
);

-- Tabla Tarea_habilidad
CREATE TABLE tarea_habilidad(
    id_tarea_habilidad SERIAL PRIMARY KEY,
    id_tarea BIGINT REFERENCES tarea(id_tarea),
    id_habilidad BIGINT REFERENCES habilidad(id_habilidad)
);


-- TRIGGERS 

-- Trigger para emergencia

-- operación INSERT
CREATE OR REPLACE FUNCTION emergencia_insert_trigger()
RETURNS TRIGGER AS $$
BEGIN
  INSERT INTO emergencia_log (accion, fecha, id_emergencia, id_institucion, tipo, ubicacion, equipamiento_necesario, titulo, descripcion)
  VALUES ('INSERT', NOW(), NEW.id_emergencia, NEW.id_institucion, NEW.tipo, NEW.ubicacion, NEW.equipamiento_necesario, NEW.titulo, NEW.descripcion);
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- operación UPDATE
CREATE OR REPLACE FUNCTION emergencia_update_trigger()
RETURNS TRIGGER AS $$
BEGIN
  INSERT INTO emergencia_log (accion, fecha, id_emergencia, id_institucion, tipo, ubicacion, equipamiento_necesario, titulo, descripcion)
  VALUES ('UPDATE', NOW(), NEW.id_emergencia, NEW.id_institucion, NEW.tipo, NEW.ubicacion, NEW.equipamiento_necesario, NEW.titulo, NEW.descripcion);
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- operación DELETE
CREATE OR REPLACE FUNCTION emergencia_delete_trigger()
RETURNS TRIGGER AS $$
BEGIN
  INSERT INTO emergencia_log (accion, fecha, id_emergencia, id_institucion, tipo, ubicacion, equipamiento_necesario, titulo, descripcion)
  VALUES ('DELETE', NOW(), OLD.id_emergencia, OLD.id_institucion, OLD.tipo, OLD.ubicacion, OLD.equipamiento_necesario, OLD.titulo, OLD.descripcion);
  RETURN OLD;
END;
$$ LANGUAGE plpgsql;

-- para cada operación
CREATE TRIGGER emergencia_insert
AFTER INSERT ON emergencia
FOR EACH ROW
EXECUTE FUNCTION emergencia_insert_trigger();

CREATE TRIGGER emergencia_update
AFTER UPDATE ON emergencia
FOR EACH ROW
EXECUTE FUNCTION emergencia_update_trigger();

CREATE TRIGGER emergencia_delete
AFTER DELETE ON emergencia
FOR EACH ROW
EXECUTE FUNCTION emergencia_delete_trigger();


-- Trigger para voluntario:

-- operación INSERT 
CREATE OR REPLACE FUNCTION voluntario_insert_trigger()
RETURNS TRIGGER AS $$
BEGIN
  INSERT INTO voluntario_log (accion, fecha, id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario)
  VALUES ('INSERT', NOW(), NEW.id_voluntario, NEW.nombre_voluntario, NEW.edad, NEW.equipamiento, NEW.estado_salud, NEW.disponibilidad, NEW.email_voluntario);
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- operación UPDATE
CREATE OR REPLACE FUNCTION voluntario_update_trigger()
RETURNS TRIGGER AS $$
BEGIN
  INSERT INTO voluntario_log (accion, fecha, id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario)
  VALUES ('UPDATE', NOW(), NEW.id_voluntario, NEW.nombre_voluntario, NEW.edad, NEW.equipamiento, NEW.estado_salud, NEW.disponibilidad, NEW.email_voluntario);
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- operación DELETE
CREATE OR REPLACE FUNCTION voluntario_delete_trigger()
RETURNS TRIGGER AS $$
BEGIN
  INSERT INTO voluntario_log (accion, fecha, id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario)
  VALUES ('DELETE', NOW(), OLD.id_voluntario, OLD.nombre_voluntario, OLD.edad, OLD.equipamiento, OLD.estado_salud, OLD.disponibilidad, OLD.email_voluntario);
  RETURN OLD;
END;
$$ LANGUAGE plpgsql;

-- para cada operación
CREATE TRIGGER voluntario_insert
AFTER INSERT ON voluntario
FOR EACH ROW
EXECUTE FUNCTION voluntario_insert_trigger();

CREATE TRIGGER voluntario_update
AFTER UPDATE ON voluntario
FOR EACH ROW
EXECUTE FUNCTION voluntario_update_trigger();

CREATE TRIGGER voluntario_delete
AFTER DELETE ON voluntario
FOR EACH ROW
EXECUTE FUNCTION voluntario_delete_trigger();

CREATE TABLE emergencia_log (
                                id SERIAL PRIMARY KEY,
                                accion VARCHAR(50),
                                fecha TIMESTAMP,
                                id_emergencia BIGINT,
                                id_institucion BIGINT,
                                tipo VARCHAR(50),
                                ubicacion VARCHAR(50),
                                equipamiento_necesario VARCHAR(50),
                                titulo VARCHAR(50),
                                descripcion VARCHAR(100)
);

CREATE TABLE voluntario_log (
                                id SERIAL PRIMARY KEY,
                                accion VARCHAR(50),
                                fecha TIMESTAMP,
                                id_voluntario BIGINT,
                                nombre_voluntario VARCHAR(50),
                                edad INT,
                                equipamiento VARCHAR(100),
                                estado_salud BOOLEAN,
                                disponibilidad BOOLEAN,
                                email_voluntario VARCHAR(50)
);
