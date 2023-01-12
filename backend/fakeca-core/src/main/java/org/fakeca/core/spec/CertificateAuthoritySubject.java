package org.fakeca.core.spec;

import org.fakeca.core.DistinguishedName;
import org.fakeca.core.GeographicAddress;
import org.fakeca.core.RelativeDistinguishedName;
import org.fakeca.core.SubjectAttributeType;

public final class CertificateAuthoritySubject extends CertificateSubject {

    public CertificateAuthoritySubject(String name, GeographicAddress address) {
        if(name==null)
            throw new IllegalArgumentException("ca commonName MUST not be null");
        if(address==null)
            throw new IllegalArgumentException("address MUST not be null");
        this.setDistinguishedName(DistinguishedName.builder()
                .append(new RelativeDistinguishedName(SubjectAttributeType.CommonName, name))
                .append(address)
                .build()
        );
    }


}
