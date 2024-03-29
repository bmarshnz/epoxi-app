package io.epoxi.util.sqlbuilder.statement;

import io.epoxi.util.sqlbuilder.clause.SqlClause;
import io.epoxi.util.sqlbuilder.clause.SqlInsertClause;
import io.epoxi.util.sqlbuilder.clause.SqlValuesClause;
import io.epoxi.util.sqlbuilder.types.RowField;
import io.epoxi.util.sqlbuilder.types.SqlFieldMap;

public class InsertStatement  extends SqlStatement implements SqlClause {

    public static InsertStatement insert(RowField... expressions)
    {
        InsertStatement statement = new InsertStatement();
        SqlInsertClause insert = new SqlInsertClause(statement, expressions);
        statement.clauses.add(insert);

        return statement;
    }

    public static InsertStatement insert(SqlFieldMap<String, ?> fieldList)
    {
        InsertStatement statement = new InsertStatement();
        SqlInsertClause insert = new SqlInsertClause(statement, fieldList);
        statement.clauses.add(insert);

        return statement;
    }

    public InsertStatement values(RowField... expressions)
    {
        SqlValuesClause values = new SqlValuesClause(expressions);
        this.clauses.add(values);
        return this;
    }

    public InsertStatement values(SqlFieldMap<String, ?> fieldList)
    {
        SqlValuesClause values = new SqlValuesClause(fieldList);
        this.clauses.add(values);
        return this;
    }

    public InsertStatement select(SelectStatement selectStatement)
    {
        clauses.add(selectStatement);
        return this;
    }



}
