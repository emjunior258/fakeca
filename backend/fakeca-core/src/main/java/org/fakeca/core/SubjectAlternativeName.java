package org.fakeca.core;

/**
 * Represents an alternative commonName that can be used to reference the subject of a {@link Certificate}.
 * @param type the type of alternative commonName
 * @param value the value of the alternative commonName
 */
public record SubjectAlternativeName(SubjectAlternativeNameType type, String value) {

    public SubjectAlternativeName(SubjectAlternativeNameType type, String value){
        if(type==null)
            throw new IllegalArgumentException("type must NOT be null");
        if(value==null || value.isEmpty())
            throw new IllegalArgumentException("value MUST NOT be null nor empty");
        this.type = type;
        this.value = value;
    }

}
