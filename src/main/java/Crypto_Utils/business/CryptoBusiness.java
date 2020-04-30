package Crypto_Utils.business;

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
 * 
 * Source code taken from: https://medium.com/@nipun.357/aes-encryption-decryption-java-python-6e9f261c24d6
 */
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class CryptoBusiness {

	private static String factoryInstance = "PBKDF2WithHmacSHA256";
	private static String cipherInstance = "AES/CBC/PKCS5PADDING";
	private static String secretKeyType = "AES";
	private static byte[] ivCode = new byte[16];

	public String encrypt(String secretKey,String salt, String value) throws Exception {
		Cipher cipher = initCipher(secretKey, salt, Cipher.ENCRYPT_MODE);
		byte[] encrypted = cipher.doFinal(value.getBytes());
		byte[] cipherWithIv = addIVToCipher(encrypted);
		return Base64.encodeBase64String(cipherWithIv);
	}

	public String decrypt(String secretKey,String salt, String encrypted) throws Exception {
		Cipher cipher = initCipher(secretKey, salt, Cipher.DECRYPT_MODE);
		byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
		byte[] originalWithoutIv = Arrays.copyOfRange(original, 16, original.length);
		return new String(originalWithoutIv);
	}

	private static Cipher initCipher(String secretKey, String salt, int mode) throws Exception {
		SecretKeyFactory factory = SecretKeyFactory.getInstance(factoryInstance);
		KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
		SecretKey tmp = factory.generateSecret(spec);
		SecretKeySpec skeySpec = new SecretKeySpec(tmp.getEncoded(), secretKeyType);
		Cipher cipher = Cipher.getInstance(cipherInstance);
		// Generating random IV
		SecureRandom random = new SecureRandom();
		random.nextBytes(ivCode);

		cipher.init(mode, skeySpec, new IvParameterSpec(ivCode));
		return cipher;
	}

	private static byte[] addIVToCipher(byte[] encrypted) {
		byte[] cipherWithIv = new byte[ivCode.length + encrypted.length];
		System.arraycopy(ivCode, 0, cipherWithIv, 0, ivCode.length);
		System.arraycopy(encrypted, 0, cipherWithIv, encrypted.length, encrypted.length);
		return cipherWithIv;
	}

}