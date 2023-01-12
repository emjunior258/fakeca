package org.fakeca.core;

import org.fakeca.core.spec.CertificateAuthoritySpec;

import java.util.List;
import java.util.Optional;

/**
 * A context within which there can only be one Certificate Authority and all certificates are signed/issued by that one CA.
 */
public final class SingleCAContext {

    private CertificateGenerator generator;
    private CertStorage storage;
    private Certificate certificateAuthority;

    public SingleCAContext(CertificateGenerator generator, CertStorage storage){
        if(generator==null)
            throw new IllegalArgumentException("generator MUST not be null");
        if(storage ==null)
            throw new IllegalArgumentException("storage MUST not be null");
        this.generator = generator;
        this.storage = storage;
    }

    public boolean isCertificateAuthorityReady(){

        return storage.getRootCert().isPresent();

    }

    public Optional<Certificate> getCertificateAuthorityCert(){

        return storage.getRootCert();

    }

    private Certificate getCaRootCert(){
        this.requireCA();
        if(certificateAuthority != null)
            return certificateAuthority;
        return certificateAuthority = getCertificateAuthorityCert().get();
    }

    public Certificate setupCertificateAuthority(CertificateAuthoritySpec spec){
        if(spec==null)
            throw new IllegalArgumentException("spec MUST not be null");
        if(isCertificateAuthorityReady())
            throw new IllegalStateException("certificate authority already configured");
        Certificate certificate = generator.generate(spec);
        storage.putRootCert(certificate);
        return certificate;
    }

    private void requireCA(){
        if(!isCertificateAuthorityReady())
            throw new IllegalStateException("certificate authority NOT configured");
    }

    public Certificate issueCertificate(CertificateSpec spec){
        if(spec==null)
            throw new IllegalArgumentException("spec MUST not be null");
        if(spec instanceof CertificateAuthoritySpec)
            throw new IllegalArgumentException("CertificateAuthoritySpec not allowed");
        this.requireCA();
        Certificate certificate = this.generator.generate(spec,getCaRootCert());
        this.storage.putChildCert(certificate);
        return certificate;
    }

    public List<CertificateSummary> listIssuedCertificates(){

        return this.storage.listChildCerts();

    }

    public Optional<Certificate> getIssuedCertificate(String serial){
        if(serial==null || serial.isEmpty())
            throw new IllegalArgumentException("serial MUST not be null nor empty");
        return this.storage.getChildBySerial(serial);
    }

}
