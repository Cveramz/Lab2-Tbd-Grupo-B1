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
INSERT INTO emergencia (id_emergencia, id_institucion, tipo, latitud, longitud, ubicacion_geom, direccion, equipamiento_necesario, titulo, descripcion) VALUES (1, 1, 'Sismo', -33.4429, -70.6505, ST_SetSRID(ST_MakePoint(-70.6505, -33.4429), 4326),'La Moneda, Santiago de Chile', 'Equipo de Rescate', 'Operación Rescate Terremoto 9.8', 'Rescate de personas y animales atrapados por infraestructura, evaluación de daños');
INSERT INTO emergencia (id_emergencia, id_institucion, tipo, latitud, longitud, ubicacion_geom, direccion, equipamiento_necesario, titulo, descripcion) VALUES (2, 2, 'Accidente en vía Pública', -33.4514, -70.6788, ST_SetSRID(ST_MakePoint(-70.6788, -33.4514), 4326),'Juan Maestro, Estación Central, Chile', 'Botiquin básico de primeros auxilios', 'Atención primaria vía publica por accidente multiple', 'Se requiere asistencia en el lugar para personas desmayadas y heridas en vía publica, presentan leves lesiones');

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
INSERT INTO tarea (id_tarea, id_emergencia, id_estado_tarea, nombre_tarea) VALUES (5, 2, 1, 'Atención primaria a personas accidentadas');

-- Insertar datos en la tabla Voluntario
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario, latitud, longitud, ubicacion_geom) VALUES (1, 'Laura Martínez', 28, 'Equipo de rescate', true, true, 'laura@example.com', 'voluntario123', -33.4429, -70.6505, ST_SetSRID(ST_MakePoint(-70.6505, -33.4429), 4326));
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario, latitud, longitud, ubicacion_geom) VALUES (2, 'Isidora Marin', 28, 'Equipo de rescate', true, true, 'Isidorita@example.com', 'voluntaisi123', -33.444732106165446, -70.656062980687, ST_SetSRID(ST_MakePoint(-70.656062980687, -33.444732106165446), 4326));
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario, latitud, longitud, ubicacion_geom) VALUES (3, 'Cristobal Sierra', 43, 'Equipo de rescate', true, true, 'CristoSierra@example.com', 'SierraCris123', -33.44349541985361, -70.65529439777717, ST_SetSRID(ST_MakePoint(-70.65529439777717, -33.44349541985361), 4326));
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario, latitud, longitud, ubicacion_geom) VALUES (4, 'José Montoya', 30, 'Equipo de rescate', true, true, 'MontoyaJ@example.com', 'Josesito32xd', -33.445833928617645, -70.65406286431762, ST_SetSRID(ST_MakePoint(70.65406286431762, -33.445833928617645), 4326));
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario, latitud, longitud, ubicacion_geom) VALUES (5, 'Carlos Rodríguez', 35, 'Botiquín de Primeros Auxilios', true, true, 'carlosR@example.com', 'ayuda456', -33.44108075631248, -70.65427718783765, ST_SetSRID(ST_MakePoint(-70.65427718783765, -33.44108075631248), 4326));
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario, latitud, longitud, ubicacion_geom) VALUES (6, 'Felipe Rodríguez', 36, 'Botiquín de Primeros Auxilios', true, true, 'felipeR@example.com', 'ayudo980', -33.44101575556715, -70.65288128190268, ST_SetSRID(ST_MakePoint(-70.65288128190268, -33.44101575556715), 4326));
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario, latitud, longitud, ubicacion_geom) VALUES (7, 'Ignacia Araya', 22, 'Botiquín de Primeros Auxilios', true, true, 'IgnaciaA@example.com', 'nacha23126', -33.44612672170549, -70.66033919112263, ST_SetSRID(ST_MakePoint(-70.66033919112263, -33.44612672170549), 4326));
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario, latitud, longitud, ubicacion_geom) VALUES (8, 'Leonardo Moya', 23, 'Equipo de telecomunicaciones', true, true, 'Lmoya@example.com', 'teayudo273', -33.448613063227036, -70.65254900451036, ST_SetSRID(ST_MakePoint(-70.65254900451036, -33.448613063227036), 4326));
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario, latitud, longitud, ubicacion_geom) VALUES (9, 'Mauricio Iturbe', 19, 'Equipo de construcción de refugios', true, true, 'MauricioConstru@example.com', 'elmejorconstru123', -33.61866288630716, -70.59033676281989, ST_SetSRID(ST_MakePoint(-70.59033676281989, -33.61866288630716), 4326));
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario, latitud, longitud, ubicacion_geom) VALUES (10, 'Lucio Aguilar', 48, 'Equipo de construcción de refugios', true, true, 'LucioghConstru@example.com', 'LUCIOconstru123', -33.443265788933516, -70.65064297491985, ST_SetSRID(ST_MakePoint(-70.65064297491985, -33.443265788933516), 4326));
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario, latitud, longitud, ubicacion_geom) VALUES (11, 'Nicolas Hermosillo', 61, 'Equipo de construcción de refugios', true, true, 'Hernosillo@example.com', 'hermoso16', -33.444594007297276, -70.65167489366853, ST_SetSRID(ST_MakePoint(-70.65167489366853, -33.444594007297276), 4326));
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario, latitud, longitud, ubicacion_geom) VALUES (12, 'Camila Perez', 25, 'Equipo de atención psicológica', true, true, 'Camilatru@example.com', 'camilatru123', -33.439853368637905, -70.6531493165479, ST_SetSRID(ST_MakePoint(-70.6531493165479, -33.439853368637905), 4326));
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario, latitud, longitud, ubicacion_geom) VALUES (13, 'Javier Fernandez', 29, 'Equipo de atención psicológica', true, true, 'javierf@example.com', 'javi436', -38.747261132858426, -72.62204671166168, ST_SetSRID(ST_MakePoint(-72.62204671166168, -38.747261132858426), 4326));

INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario, latitud, longitud, ubicacion_geom) VALUES (14, 'Franco Escobar', 24, 'Botiquín de Primeros Auxilios', true, true, 'franco@example.com', 'ayudo2343456', -33.4510704755736, -70.6843392759994, ST_SetSRID(ST_MakePoint(-70.6843392759994, -33.4510704755736), 4326));
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario, latitud, longitud, ubicacion_geom) VALUES (15, 'Gabriel Ramirez', 24, 'Atención Psicológica', true, true, 'gabo@example.com', 'ayudo2343456', -33.44975596409554, -70.68728720224989, ST_SetSRID(ST_MakePoint(-70.68728720224989, -33.44975596409554), 4326));
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario, latitud, longitud, ubicacion_geom) VALUES (16, 'Francisca Godoy', 24, 'Botiquin Primeros Auxilios ', true, true, 'pancha@example.com', 'ayudo2343456', -33.453753608012974, -70.67979260259467, ST_SetSRID(ST_MakePoint(-70.67979260259467, -33.453753608012974), 4326));
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario, latitud, longitud, ubicacion_geom) VALUES (17, 'Catalina Perez', 24, 'Botiquin de Primeros Auxilios', true, true, 'cata@example.com', 'ayudo2343456', -33.45450429018095, -70.67972410793526, ST_SetSRID(ST_MakePoint(-70.67972410793526, -33.45450429018095), 4326));
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario, latitud, longitud, ubicacion_geom) VALUES (18, 'Luciano Guerra', 24, 'Atención psicológica', true, true, 'lucianowar@example.com', 'ayudo2343456', -33.45257296148268, -70.67833200242924, ST_SetSRID(ST_MakePoint(-70.67833200242924, -33.45257296148268), 4326));
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario, latitud, longitud, ubicacion_geom) VALUES (19, 'Agustin Galvez', 24, 'Atención psicológica', true, true, 'titingalvez@example.com', 'ayudo2343456', -33.452155032357346, -70.67949590245608, ST_SetSRID(ST_MakePoint(-70.67949590245608, -33.452155032357346), 4326));
INSERT INTO voluntario (id_voluntario, nombre_voluntario, edad, equipamiento, estado_salud, disponibilidad, email_voluntario, password_voluntario, latitud, longitud, ubicacion_geom) VALUES (20, 'Juliana Merino', 24, 'Botiquín de Primeros Auxilios', true, true, 'julianamer@example.com', 'ayudo2343456', -33.45274796835803, -70.69225830226941, ST_SetSRID(ST_MakePoint(-70.69225830226941, -33.45274796835803), 4326));

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
INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito) VALUES (16, 16, 5, 90);
INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito) VALUES (17, 17, 5, 85);
INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito) VALUES (18, 18, 5, 60);
INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito) VALUES (19, 19, 5, 53);
INSERT INTO ranking (id_ranking, id_voluntario, id_tarea, puntos_requisito) VALUES (20, 20, 5, 100);


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
INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (16, 16, 1);
INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (17, 17, 1);
INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (18, 18, 5);
INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (19, 19, 5);
INSERT INTO vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad) VALUES (20, 20, 1);


-- Insertar datos en la tabla Tarea_habilidad
INSERT INTO tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (1, 1, 2);
INSERT INTO tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (2, 2, 2);
INSERT INTO tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (3, 2, 3);
INSERT INTO tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (4, 3, 1);
INSERT INTO tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (5, 4, 4);
INSERT INTO tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (6, 5, 5);
INSERT INTO tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) VALUES (7, 5, 1);