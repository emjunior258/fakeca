package org.fakeca.bouncycastle;

import org.fakeca.core.Certificate;
import org.fakeca.core.PEMEncoder;

import java.io.OutputStream;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 *
 */
public class BouncyCastlePEMEncoder implements PEMEncoder {

    @Override
    public void encodePublicKey(PublicKey publicKey, OutputStream outputStream) {

    }

    @Override
    public void encodePrivateKey(PrivateKey privateKey, OutputStream outputStream) {

    }

    @Override
    public void encodeCertificate(Certificate certificate, OutputStream outputStream) {

    }

}
