# Crypto_Utils
Esta librería sirve para encriptar y desencriptar textos en base64
```bash
java -jar Crypto_Utils-0.0.1-SNAPSHOT.jar --help
```
## DESCRIPCIÓN

Esta utilidad implementa la librería Crypto de javax para poder encriptar y desencriptar.
Utilizando el tipo de cifrado AES.

## OPCIONES

--license -&gt; Tipo de licencia

--encrypt -&gt; para encriptar debes pasar el argumento --encript llave secreta en base64 salto en base64 'mensaje a encriptar' todo separado por espacio

--decrypt -&gt; para desencriptar debes pasar el argumento --decrypt llave secreta en base64 salto en base64 'mensaje a desencriptar' todo separado por espacio

## EJEMPLO
```bash
java -jar [Nombre_jar].jar --encrypt U2VjcmV0S2V5 MTIzNDU= 'Hola Mundo'
java -jar [Nombre_jar].jar --decrypt U2VjcmV0S2V5 MTIzNDU= 'DCMO75w8TEaMYxYyEIuGqlF2cR6afodf4y+c996Vqqs='
```
