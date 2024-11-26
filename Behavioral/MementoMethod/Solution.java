package Behavioral.MementoMethod;

import java.util.ArrayList;
import java.util.List;

// It is a design pattern used to capture and restore the internal state of an object in the
// application without violating encapsulation. It allows you to save and restore the state of an
// object to the previous state, providing the ability to roll back all the changes made to the object.

// Imagine we are building a text editor application, and you want to implement an undo feature that allows users 
// to revert changes made to a document. The challenge is to store the state of document at various points in time
// and restore it when needed without exposing the internal implementatuon of the document.

// Originator
class Document {
    private String content;

    public Document(String content) {
        this.content = content;
    }

    public void write(String text) {
        this.content = this.content + text;
    }

    public String getContent() {
        return this.content;
    }

    public DocumentMemento createMemento() {
        return new DocumentMemento(this.content);
    }

    public void restoreFromMemento(DocumentMemento memento) {
        this.content = memento.getSavedContent();
    }
}

// Memento
class DocumentMemento {
    private String content;

    public DocumentMemento(String content) {
        this.content = content;
    }

    public String getSavedContent() {
        return this.content;
    }
}

// Caretaker
class History {
    private List<DocumentMemento> mementos;

    public History() {
        this.mementos = new ArrayList<>();
    }

    public void addMemento(DocumentMemento documentMemento) {
        this.mementos.add(documentMemento);
    }

    public DocumentMemento getMemento(int idx) {
        return this.mementos.get(idx);
    }
}

public class Solution {
    public static void main(String[] args) {
        Document document = new Document("Initial\n");
        History history = new History();

        // Writing some content on a document
        document.write("First additional\n");
        history.addMemento(document.createMemento());

        // Add more content
        document.write("Second additional content\n");
        history.addMemento(document.createMemento());

        // Restore to the previous state
        document.restoreFromMemento(history.getMemento(1));

        System.out.println(document.getContent());
    }
}
