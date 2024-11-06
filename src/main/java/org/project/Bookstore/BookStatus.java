package org.project.Bookstore;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

public enum BookStatus { // Enum for representing different statuses of a book
    AVAILABLE, // When the book is available to buy
    SOLD,      // When the book has been sold
    RESOLD;    // When the book is resold back to us

    // Static inner class to handle conversions between the database and enum values
    @Converter(autoApply = true) // This applies the converter automatically to any BookStatus field
    public static class BookStatusConverter implements AttributeConverter<BookStatus, String> {

        @Override
        public String convertToDatabaseColumn(BookStatus status) {
            // Convert enum value to lowercase string for storage in the database
            if (status == null) {
                return null; // If no status, store as null in the database
            }
            return status.name().toLowerCase(); // Convert enum to lowercase string for the database
        }

        @Override
        public BookStatus convertToEntityAttribute(String dbData) {
            // Convert lowercase database value to uppercase enum constant
            if (dbData == null) {
                return null; // If there's no data, return null
            }
            try {
                return BookStatus.valueOf(dbData.toUpperCase()); // Convert the lowercase database value back to uppercase enum
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Unknown value for BookStatus in database: " + dbData, e); // Handle any unknown values
            }
        }
    }
}