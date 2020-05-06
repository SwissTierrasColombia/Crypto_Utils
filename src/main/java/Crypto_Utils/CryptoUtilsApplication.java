package Crypto_Utils;
import org.apache.commons.codec.binary.Base64;

import Crypto_Utils.business.CryptoBusiness;

public class CryptoUtilsApplication {

	public static void main(String[] args) {
		try {
			CryptoBusiness objCrypto = new CryptoBusiness();
			if (args[0].equals("--encrypt")) {
				byte[] secretKeyBase64 = Base64.decodeBase64(args[1].getBytes());
				byte[] saltBase64 = Base64.decodeBase64(args[2].getBytes());
				String value = args[3];
				String secretKey = new String(secretKeyBase64);
				String salt = new String(saltBase64);
				System.out.println(objCrypto.encrypt(secretKey, salt, value));
			}else if (args[0].equals("--decrypt")) {
				byte[] secretKeyBase64 = Base64.decodeBase64(args[1].getBytes());
				byte[] saltBase64 = Base64.decodeBase64(args[2].getBytes());
				String value = args[3];
				String secretKey = new String(secretKeyBase64);
				String salt = new String(saltBase64);
				System.out.println(objCrypto.decrypt(secretKey, salt, value));
			}   else if (args[0].equals("--license")) {
				System.out.println(
						"\n * Licensed to the Apache Software Foundation (ASF) under one \n * or more contributor license agreements.  See the NOTICE file \n * distributed with this work for additional information \n * regarding copyright ownership.  The ASF licenses this file \n * to you under the Apache License, Version 2.0 (the \n * 'License'); you may not use this file except in compliance \n * with the License.  You may obtain a copy of the License at \n * \n *     http://www.apache.org/licenses/LICENSE-2.0 \n * \n * Unless required by applicable law or agreed to in writing, software \n * distributed under the License is distributed on an 'AS IS' BASIS, \n * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. \n * See the License for the specific language governing permissions and \n * limitations under the License.");
			} else if (args[0].equals("--help")) {
				System.out.println();
				System.out.println("DESCRIPCIÓN \n");
				System.out.println(
						"Esta utilidad implementa la libreria Crypto de javax para poder encriptar y desencriptar.");
				System.out.println("Utilizando el tipo de cifrado AES. \n");
				System.out.println("OPCIONES");
				System.out.println("\n --license -> Tipo de licencia");
				System.out.println("\n --encrypt -> para encriptar debes pasar el argumento --encript llave secreta en base64 salto en base64 'mensaje a encriptar' todo separado por espacio");
				System.out.println("\n --decrypt -> para desencriptar debes pasar el argumento --decrypt llave secreta en base64 salto en base64 'mensaje a desencriptar' todo separado por espacio \n");
				System.out.println("EJEMPLO \n \n java -jar [Nombre_jar].jar --encrypt U2VjcmV0S2V5 MTIzNDU= 'Hola Mundo' \n java -jar [Nombre_jar].jar --decrypt U2VjcmV0S2V5 MTIzNDU= 'DCMO75w8TEaMYxYyEIuGqlF2cR6afodf4y+c996Vqqs='");
			} else {
				System.out.println("Por favor ejecuta: \n java -jar [Nombre_jar].jar --help");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
