package com.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DocumentTest {

    @Test
    void testValidFlow() {
        Document doc = new Document();

        doc.submit();
        doc.review();
        doc.approve();
        doc.finalizeDoc();

        assertEquals(Status.FINALIZED, doc.getStatus());
    }

    @Test
    void testRejectFlow() {
        Document doc = new Document();

        doc.submit();
        doc.review();
        doc.reject();

        assertEquals(Status.REJECTED, doc.getStatus());
    }

    @Test
    void testInvalidTransition() {
        Document doc = new Document();

        assertThrows(IllegalStateException.class, () -> {
            doc.approve(); // invalid
        });
    }
}