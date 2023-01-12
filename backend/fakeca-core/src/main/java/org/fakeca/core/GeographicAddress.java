package org.fakeca.core;

import java.util.Set;

public record GeographicAddress(String countryIsoCode,
                                String state,
                                String locality,
                                String streetAddress) implements RDNConvertible {

    @Override
    public Set<RelativeDistinguishedName> toRdns() {
        return Set.of(
                new RelativeDistinguishedName(SubjectAttributeType.CountryName, countryIsoCode),
                new RelativeDistinguishedName(SubjectAttributeType.Province, state),
                new RelativeDistinguishedName(SubjectAttributeType.Locality, locality),
                new RelativeDistinguishedName(SubjectAttributeType.Street, streetAddress)
        );
    }


}
