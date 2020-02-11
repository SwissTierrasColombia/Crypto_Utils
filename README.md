# Crypto_Utils

## Descripción

Esta utilidad implementa la libreria Crypto de javax para poder encriptar y desencriptar.
Utilizando el tipo de cifrado AES. 

## Opciones
```
 --license  -> Tipo de licencia

 --encrypt  -> para encriptar debes pasar el argumento --encript llave secreta en base64 salto en base64 'mensaje a encriptar' todo separado por espacio

 --decrypt  -> para desencriptar debes pasar el argumento --decrypt llave secreta en base64 salto en base64 'mensaje a desencriptar' todo separado por espacio
 ```
## Ejemplo 
 ```
 java -jar CryptoUtils.jar --encrypt U2VjcmV0S2V5 MTIzNDU= 'Hola Mundo' 
 java -jar CryptoUtils.jar --decrypt U2VjcmV0S2V5 MTIzNDU= 'DCMO75w8TEaMYxYyEIuGqlF2cR6afodf4y+c996Vqqs='
 ```