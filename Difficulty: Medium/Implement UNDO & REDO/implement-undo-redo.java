import java.util.*;

class Solution {
    private StringBuilder document;
    private Stack<Character> undoStack;
    private Stack<Character> redoStack;
    
    public Solution() {
        document = new StringBuilder();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }
    
    public void append(char x) {
        // Append character to document and push to undo stack
        // Clear redo stack as new operation breaks redo chain
        document.append(x);
        undoStack.push(x);
        redoStack.clear();
    }
    
    public void undo() {
        // If undo stack is not empty, pop last char and push to redo stack
        if (!undoStack.isEmpty()) {
            char lastChar = undoStack.pop();
            redoStack.push(lastChar);
            document.deleteCharAt(document.length() - 1);
        }
    }
    
    public void redo() {
        // If redo stack is not empty, pop char and push back to undo stack
        if (!redoStack.isEmpty()) {
            char redoChar = redoStack.pop();
            undoStack.push(redoChar);
            document.append(redoChar);
        }
    }
    
    public String read() {
        return document.toString();
    }
}
