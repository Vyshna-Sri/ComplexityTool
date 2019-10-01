package nesting;

public class StatementArray {
    public static int sno;
    String statement;
    int cncValue = 0;
    String status;
    public StatementArray(int sno, String statement, int cncValue,String status) {
        this.sno = sno;
        this.statement = statement;
        this.cncValue = cncValue;
        this.status = status;
    }

    public static int getSno() {
        return sno;
    }

    public int setSno() {
        return StatementArray.sno++;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public int getCncValue() {
        return cncValue;
    }

    public void setCncValue(int cncValue) {
        this.cncValue = cncValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
