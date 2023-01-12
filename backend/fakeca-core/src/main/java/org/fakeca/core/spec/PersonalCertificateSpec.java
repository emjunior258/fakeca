package org.fakeca.core.spec;

import org.fakeca.core.CertificateSpec;
import org.fakeca.core.KeyStrength;

import java.time.LocalDate;
import java.util.Set;

public class PersonalCertificateSpec extends CertificateSpec {

    public PersonalCertificateSpec(PersonalIdentitySubject subject, KeyStrength keyStrength, LocalDate expiryDate) {
        super(subject, keyStrength, expiryDate, Set.of(PublicKeyUsage.DigitalSignature, PublicKeyUsage.NonRepudiation), false);
    }
}
