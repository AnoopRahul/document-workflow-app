package com.demo;

public class Document {

    private Status status;

    public Document() {
        this.status = Status.DRAFT;
    }

    public Status getStatus() {
        return status;
    }

    public void submit() {
        if (status != Status.DRAFT)
            throw new IllegalStateException("Invalid transition");
        status = Status.SUBMITTED;
    }

    public void review() {
        if (status != Status.SUBMITTED)
            throw new IllegalStateException("Invalid transition");
        status = Status.UNDER_REVIEW;
    }

    public void approve() {
        if (status != Status.UNDER_REVIEW)
            throw new IllegalStateException("Invalid transition");
        status = Status.APPROVED;
    }

    public void reject() {
        if (status != Status.UNDER_REVIEW)
            throw new IllegalStateException("Invalid transition");
        status = Status.REJECTED;
    }

    public void finalizeDoc() {
        if (status != Status.APPROVED)
            throw new IllegalStateException("Invalid transition");
        status = Status.FINALIZED;
    }

    // Optional main (for simple run test)
    public static void main(String[] args) {
        Document doc = new Document();
        doc.submit();
        doc.review();
        doc.approve();
        doc.finalizeDoc();

        System.out.println("Final Status: " + doc.getStatus());
    }
}