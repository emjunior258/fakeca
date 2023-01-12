package org.fakeca.core;

import java.util.List;
import java.util.Optional;

/**
 * Stores {@link Certificate}s of and issued by a single certificate Authority
 */
public interface CertStorage {

    Optional<Certificate> getRootCert();

    void putRootCert(Certificate certificate);

    void putChildCert(Certificate certificate);

    Optional<Certificate> getChildBySerial(String serial);

    List<CertificateSummary> listChildCerts();

    boolean deleteChildCert(Certificate certificate);

}
