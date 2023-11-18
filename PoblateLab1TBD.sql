-- Insertar datos en la tabla Habilidad
INSERT INTO habilidad (id_habilidad, nombre_habilidad) VALUES (1, 'Primeros Auxilios');
INSERT INTO habilidad (id_habilidad, nombre_habilidad) VALUES (2, 'Rescate en Terreno');
INSERT INTO habilidad (id_habilidad, nombre_habilidad) VALUES (3, 'Manejo de Equipos de Comunicación');
INSERT INTO habilidad (id_habilidad, nombre_habilidad) VALUES (4, 'Construcción de Refugios');
INSERT INTO habilidad (id_habilidad, nombre_habilidad) VALUES (5, 'Apoyo Psicológico');

-- Insertar datos en la tabla Estado_tarea
INSERT INTO estado_tarea (id_estado_tarea, estado) VALUES (1, 'En Proceso');
INSERT INTO estado_tarea (id_estado_tarea, estado) VALUES (2, 'Completada');
INSERT INTO estado_tarea (id_estado_tarea, estado) VALUES (3, 'Pendiente');

-- Insertar datos en la tabla Coordinador
INSERT INTO coordinador (id_coordinador, nombre_coordinador, email_coordinador, password_coordinador) VALUES (1,'María González', 'maria.gonzalez@example.com', 'claveSegura456');
INSERT INTO coordinador (id_coordinador, nombre_coordinador, email_coordinador, password_coordinador) VALUES (2,'Juana Rojas', 'juana.rojas@example.com', 'claveroja133');


-- Insertar datos en la tabla Institución
INSERT INTO institucion (id_institucion, id_coordinador, nombre_institucion, telefono, ubicacion_institucion) VALUES (1, 1, 'Equipo de Rescate de terremotos', 987654321, 'Ciudad de Valparaíso');
INSERT INTO institucion (id_institucion, id_coordinador, nombre_institucion, telefono, ubicacion_institucion) VALUES (2, 2, 'Cruz Roja de Chile', 987839475, 'Ciudad de Santiago');

-- Insertar datos en la tabla Emergencia
INSERT INTO emergencia (id_emergencia, id_institucion, tipo, ubicacion, equipamiento_necesario, titulo, descripcion) VALUES (1, 1, 'Sismo', 'La Moneda, Santiago', 'Equipo de Rescate', 'Operación Rescate Terremoto 9.8', 'Rescate de personas y animales atrapados por infraestructura, evaluación de daños');
INSERT INTO emergencia (id_emergencia, id_institucion, tipo, ubicacion, equipamiento_necesario, titulo, descripcion) VALUES (2, 2, 'Accidente en vía Pública', 'Estación Central, Santiago','Botiquin básico de primeros auxilios' , 'Atención primaria vía publica', 'Se requiere asistencia en el lugar para joven desmayado en vía publica, presenta leves lesiones');

-- Insertar datos en la tabla Eme_habilidad
INSERT INTO eme_habilidad (id_eme_habilidad, id_emergencia, id_habilidad) VALUES (1, 1, 1);
INSERT INTO eme_habilidad (id_eme_habilidad, id_emergencia, id_habilidad) VALUES (2, 1, 2);
INSERT INTO eme_habilidad (id_eme_habilidad, id_emergencia, id_habilidad) VALUES (3, 1, 3);
INSERT INTO eme_habilidad (id_eme_habilidad, id_emergencia, id_habilidad) VALUES (4, 1, 4);
INSERT INTO eme_habilidad (id_eme_habilidad, id_emergencia, id_habilidad) VALUES (5, 1, 5);
INSERT INTO eme_habilidad (id_eme_habilidad, id_emergencia, id_habilidad) VALUES (6, 2, 1);
INSERT INTO eme_habilidad (id_eme_habilidad, id_emergencia, id_habilidad) VALUES (7, 2, 5);

-- Insertar datos en la tabla Tarea
INSERT INTO tarea (id_tarea, id_emergencia, id_estado_tarea, nombre_tarea) VALUES (1, 1, 1, 'Búsqueda de personas atrapadas');
INSERT INTO tarea (id_tarea, id_emergencia, id_estado_tarea, nombre_tarea) VALUES (2, 1, 2, 'Evaluación de Daños');
INSERT INTO tarea (id_tarea, id_emergencia, id_estado_tarea, nombre_tarea) VALUES (3, 1, 1, 'Primeros auxilios a personas rescatadas');
INSERT INTO tarea (id_tarea, id_emergencia, id_estado_tarea, nombre_tarea) VALUES (4, 1, 2, 'Construcción de refugios temporales');
INSERT INTO tarea (id_tarea, id_emergencia, id_estado_tarea, nombre_tarea) VALUES (5, 2, 1, 'Atención primaria a joven desmayado');

-- Insertar datos en la tabla Voluntario
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario) VALUES (1, 'Laura Martínez', 28, 'Equipo de rescate', true, true, 'laura@example.com', 'voluntario123');
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario) VALUES (2, 'Isidora Marin', 28, 'Equipo de rescate', true, true, 'Isidorita@example.com', 'voluntaisi123');
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario) VALUES (3, 'Cristobal Sierra', 43, 'Equipo de rescate', true, true, 'CristoSierra@example.com', 'SierraCris123');
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario) VALUES (4, 'José Montoya', 30, 'Equipo de rescate', true, true, 'MontoyaJ@example.com', 'Josesito32xd');
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario) VALUES (5, 'Carlos Rodríguez', 35, 'Botiquín de Primeros Auxilios', true, true, 'carlosR@example.com', 'ayuda456');
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario) VALUES (6, 'Felipe Rodríguez', 36, 'Botiquín de Primeros Auxilios', true, true, 'felipeR@example.com', 'ayudo980');
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario) VALUES (7, 'Ignacia Araya', 22, 'Botiquín de Primeros Auxilios', true, true, 'IgnaciaA@example.com', 'nacha23126');
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario) VALUES (8, 'Leonardo Moya', 23, 'Equipo de telecomunicaciones', true, true, 'Lmoya@example.com', 'teayudo273');
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario) VALUES (9, 'Mauricio Iturbe', 19, 'Equipo de construcción de refugios', true, true, 'MauricioConstru@example.com', 'elmejorconstru123');
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario) VALUES (10, 'Lucio Aguilar', 48, 'Equipo de construcción de refugios', true, true, 'LucioghConstru@example.com', 'LUCIOconstru123');
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario) VALUES (11, 'Nicolas Hermosillo', 61, 'Equipo de construcción de refugios', true, true, 'Hernosillo@example.com', 'hermoso16');
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario) VALUES (12, 'Camila Perez', 25, 'Equipo de atención psicológica', true, true, 'Camilatru@example.com', 'camilatru123');
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario) VALUES (13, 'Javier Fernandez', 29, 'Equipo de atención psicológica', true, true, 'javierf@example.com', 'javi436');

INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario) VALUES (14, 'Franco Escobar', 24, 'Botiquín de Primeros Auxilios', true, true, 'franco@example.com', 'ayudo2343456');
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario) VALUES (15, 'Carla Rosales', 43, 'Equipo de atención psicológica', true, true, 'Carlaro@example.com', 'carlaRo12');

-- Insertar datos en la tabla Ranking
INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito) VALUES (1, 1, 1, 95);
INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito) VALUES (2, 2, 1, 88);
INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito) VALUES (3, 3, 1, 90);
INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito) VALUES (4, 4, 2, 100);
INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito) VALUES (5, 5, 3, 70);
INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito) VALUES (6, 6, 3, 98);
INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito) VALUES (7, 7, 3, 84);
INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito) VALUES (8, 8, 2, 100);
INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito) VALUES (9, 9, 4, 99);
INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito) VALUES (10, 10, 4, 32);
INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito) VALUES (11, 11, 4, 80);
INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito) VALUES (12, 12, 3, 99);
INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito) VALUES (13, 13, 3, 78);

INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito) VALUES (14, 14, 5, 90);
INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito) VALUES (15, 15, 5, 80);


-- Insertar datos en la tabla Vol_habilidad
INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (1, 1, 2);
INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (2, 2, 2);
INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (3, 3, 2);
INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (4, 4, 2);
INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (5, 5, 1);
INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (6, 6, 1);
INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (7, 7, 1);
INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (8, 8, 3);
INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (9, 9, 4);
INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (10, 10, 4);
INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (11, 11, 4);
INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (12, 12, 5);
INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (13, 13, 5);

INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (14, 14, 1);
INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (15, 15, 5);


-- Insertar datos en la tabla Tarea_habilidad
INSERT INTO tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (1, 1, 2);
INSERT INTO tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (2, 2, 2);
INSERT INTO tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (3, 2, 3);
INSERT INTO tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (4, 3, 1);
INSERT INTO tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (5, 4, 4);
INSERT INTO tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (6, 5, 5);
INSERT INTO tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (7, 5, 1);