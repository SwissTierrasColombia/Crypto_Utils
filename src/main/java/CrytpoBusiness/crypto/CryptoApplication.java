package CrytpoBusiness.crypto;
/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import org.springframework.boot.autoconfigure.SpringBootApplication;
import CrytpoBusiness.business.CryptoBusiness;
import org.apache.commons.codec.binary.Base64;

@SpringBootApplication
public class CryptoApplication {

	public static void main(String[] args) {
		try {
			CryptoBusiness objCrypto = new CryptoBusiness();
			if (args.length == 4) {
				byte[] secretKeyBase64 = Base64.decodeBase64(args[0].getBytes());
				byte[] saltBase64 = Base64.decodeBase64(args[1].getBytes());
				String type = args[2];
				String value = args[3];
				String secretKey = new String(secretKeyBase64);
				String salt = new String(saltBase64);
				if (type.equals("1")) {
					System.out.println(objCrypto.encrypt(secretKey, salt, value));
				} else if (type.equals("2")) {
					System.out.println(objCrypto.decrypt(secretKey, salt, value));
				} else {
					System.out.println("Error...");
				}
			} else if (args[0].equals("--help")) {
				System.out.println("\n * Licensed to the Apache Software Foundation (ASF) under one \n * or more contributor license agreements.  See the NOTICE file \n * distributed with this work for additional information \n * regarding copyright ownership.  The ASF licenses this file \n * to you under the Apache License, Version 2.0 (the \n * 'License'); you may not use this file except in compliance \n * with the License.  You may obtain a copy of the License at \n * \n *     http://www.apache.org/licenses/LICENSE-2.0 \n * \n * Unless required by applicable law or agreed to in writing, software \n * distributed under the License is distributed on an 'AS IS' BASIS, \n * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. \n * See the License for the specific language governing permissions and \n * limitations under the License.");
				System.out.println();
				System.out.println("se deben pasar los siguientes argumentos");
				System.out.println(
						"Los argumentos se deben pasar de la siguiente forma separados por espacio: \n llave secreta tipo Base64, \n salto tipo Base64, \n tipo: 1 -> Encriptar ó 2 -> Desencriptar \n valor tipo string entre comillas");
				System.out.println("Ejemplo: \n java -jar CryptoUtils.jar secretKey 12345 1 'Hola Mundo'");
				
			} else {
				System.out.println("Por favor ejecuta: \n java -jar CryptoUtils.jar --help");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
