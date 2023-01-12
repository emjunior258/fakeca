package org.fakeca.core;

import org.fakeca.core.spec.CertificateSubject;
import org.fakeca.core.spec.PublicKeyUsage;

import java.time.LocalDate;
import java.util.Set;

public class CertificateSpec {

    private CertificateSubject subject;

    private LocalDate expiryDate;

    private KeyStrength keyStrength;

    private Set<PublicKeyUsage> publicKeyUsages;

    private boolean certificateAuthority = false;

    public CertificateSpec(CertificateSubject subject, KeyStrength keyStrength, LocalDate expiryDate, Set<PublicKeyUsage> keyUsages, boolean certificateAuthority){
        if(subject==null)
            throw new IllegalArgumentException("subject MUST not be null");
        if(keyStrength==null)
            throw new IllegalArgumentException("key strength MUST not be null");
        if(expiryDate==null)
            throw new IllegalArgumentException("expiry date MUST not be null");
        if(keyUsages==null || keyUsages.isEmpty())
            throw new IllegalArgumentException("key usages SET must NOT be null nor empty");
        this.subject = subject;
        this.keyStrength = keyStrength;
        this.expiryDate = expiryDate;
        this.publicKeyUsages = keyUsages;
        this.certificateAuthority = certificateAuthority;
    }

    public CertificateSubject getSubject() {
        return subject;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public Set<PublicKeyUsage> getPublicKeyUsages() {
        return publicKeyUsages;
    }

    public KeyStrength getKeyStrength() {
        return keyStrength;
    }

    public boolean isCertificateAuthority() {
        return certificateAuthority;
    }
}
