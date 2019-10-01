package nesting;

public class Line {
    private String line;
    private int value;

    public Line(String line, int value) {
        this.line = line;
        this.value = value;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return (this.getLine()+"::::::::::::::"+this.getValue());
    }

}
