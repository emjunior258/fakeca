package org.fakeca.core;

import java.io.OutputStream;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Encodes {@link Certificate}s and keys (private & public) in PEM Format.
 */
public interface PEMEncoder {

    void encodePublicKey(PublicKey publicKey, OutputStream outputStream);
    void encodePrivateKey(PrivateKey privateKey, OutputStream outputStream);
    void encodeCertificate(Certificate certificate, OutputStream outputStream);

}
