DESC camareros;
DESC categorias;
DESC comandas;
DESC facturas;
DESC mesa_maestra_configuracion;
DESC prod_com_asoc;
DESC productos;

select * from productos;

-- INSERT CAMAREROS --
INSERT INTO camareros (nombre, username) VALUES ('Jonatan Valle', 'jvalle');
INSERT INTO camareros (nombre, username) VALUES ('David Salas', 'dsalas');
INSERT INTO camareros (nombre, username) VALUES ('Erik Cabezuelo', 'ecabezue');

-- INSERT CATEGORIAS --
INSERT INTO categorias (nombre) VALUES ('Bebidas');
INSERT INTO categorias (nombre) VALUES ('Cafeteria');
INSERT INTO categorias (nombre) VALUES ('Ensaladas');
INSERT INTO categorias (nombre) VALUES ('Pastas');
INSERT INTO categorias (nombre) VALUES ('Carnes');
INSERT INTO categorias (nombre) VALUES ('Pescados');
INSERT INTO categorias (nombre) VALUES ('Postres');

-- INSERTO PRODUCTOS --
-- CATEGORIA BEBIDAS --
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Coca Cola', 1.60, 'Bebida refrescante con gas con sabor a cola','..\res\img\imgCocaCola.jpg', 1);
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Fanta Naranja', 1.60, 'Bebida refrescante con gas con sabor a naranja','..\res\img\imgFantaNaranja.jpg', 1);
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Agua mineral', 1.50, 'Agua mineral de los lagos de Galicia','..\res\img\imgAguaMineral.jpg', 1);
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Cerveza', 1.70, 'Cerveza proviniente de Granada con baja fermentaci�n.','..\res\img\imgAlhambra.jpgjpg', 1);
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Nestea al lim�n', 1.75, 'Bebida refrescante con sabor a t� al lim�n.','..\res\img\imgNestea.jpg', 1);

-- CATEGORIA CAFETERIA --
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Caf� solo', 1.25, 'Taza peque�a con una carga de caf� sin leche.','..\res\img\imgCafeSolo.jpg', 2);
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Caf� cortado', 1.35, 'Taza mediana con una carga de caf� con un chorro de leche.','..\res\img\imgCafeCortado.jpg', 2);
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Caf� con leche', 1.50, 'Taza grande con doble carga de caf� y un chorro de leche.','..\res\img\imgCafeConLeche.jpg', 2);
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Caf� americano', 1.40, 'Taza mediana con doble carga de caf� sin leche.','..\res\img\imgCafeAmericano.jpg', 2);
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Carajillo de Baileys', 1.60, 'Taza mediana con una carga de caf� con un chorro de licor Baileys.','..\res\img\imgCarajillo.jpg', 2);

-- CATEGORIA ENSALADAS --
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Ensalada Cesar', 5.95, 'Ensalada con pollo, picatostes, salsa C�sar y frutos secos','..\res\img\imgEnsaladaCesar.jpg', 3);
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Ensalada de la huerta', 4.95, 'Ensalada con mezclum, brotes, tomate, pepino y ali�ada con aceite de oliva y vinagre','..\res\img\imgEnsaladaHuerta.jpg', 3);
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Ensalada tropical', 5.49, 'Ensalada con mezclum, pi�a y queso.','..\res\img\imgEnsaladaTropical.jpg', 3);
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Ensalada del mar', 6.95, 'Ensalada con mezclum, gambas y tomates.','..\res\img\imgEnsaladaMar.jpg', 3);

-- CATEGORIA PASTAS --
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Espaguetis a la carbonara', 5.95, 'Espaguettis con nata, bacon, huevo y nuez moscada','..\res\img\imgEspaguetiCarbonara.jpg', 4);
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Macarrones a la bolo�esa', 5.95, 'Macarrones con tomate y carne picada mixta de ternera y cerdo y queso parmesano','..\res\img\imgMacarronesBolonesa.jpg', 4);
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Pasta con frutos de mar', 7.49, 'Pasta a elecci�n con gambas, mejillones y escamarlán.','..\res\img\imgPastaConMarisco.jpg', 4);

-- CATEGORIA CARNES --
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Solomillo de cerdo ib�rico a la pimienta', 12.95, 'Solomillo de cerdo ib�rico con salsa de pimienta verde','..\res\img\imgSolomilloCerdo.jpg', 5);
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Abanico ib�rico', 11.95, 'Abanico de cerdo ib�rico con patatas de guarnaici�n.','..\res\img\imgAbanicoCerdo.jpg', 5);
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Entrecotte de ternera wagyu a la brasa', 23.49, 'Entrecotte de ternera WAGYU a la brasa con guarnici�n de patatas al caliu.','..\res\img\imgEntrecotteBrasa.jpg', 5);
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Solomillo de ternera a la brasa ahumado', 23.95, 'Solomillo de ternera a la brasa cocinado durante horas con sabor ahumado.','..\res\img\imgSolomilloTernera.jpg', 5);

-- CATEGORIA PESCADO --
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Lubina a la plancha con lim�n y ajetes', 16.49, 'Lubina hecha a la plancha con jugo de lim�n y ajetes braseados','..\res\img\imgLubinaAjetes.jpg', 6);
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Emperador con salsa verde', 21.99, 'Emperador hecho a la plancha con deliciosa salsa verde hecha a partir de vino blanco, ajo, lim�n, perejil y cebolla.','..\res\img\imgEmperador.jpg', 6);
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Merluza a la gallega', 15.95, 'Merluza con salsa gallega de tomate y base de patatas al horno.','..\res\img\imgMerluzaGallega.jpg', 6);

-- CATEGORIA POSTRES --
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Coulant de chocolate', 7.49, 'Peque�o pastel de chocolate relleno de foundant de chocolate suizo negro.','..\res\img\imgCoulant.jpg', 7);
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Tarta de queso New York', 5.49, 'Tarta de queso pintada con mermelada de frambuesa y base de galleta caramelizada.','..\res\img\imgTartaNY.jpg', 7);
INSERT INTO productos (nombre, precio_producto, descripcion, imagen, id_categoria) VALUES ('Crema catalana', 4.95, 'Crema catalana casera con az�car cremat.','..\res\img\imgCremaCatalana.jpg', 7);

