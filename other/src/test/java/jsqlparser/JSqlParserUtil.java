/*
 * Meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package jsqlparser;

import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.sql.parser.SQLParserUtils;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.AllColumns;
import net.sf.jsqlparser.statement.select.AllTableColumns;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectBody;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.statement.select.SelectItem;
import net.sf.jsqlparser.statement.select.SelectItemVisitor;
import net.sf.jsqlparser.statement.select.SelectVisitor;
import net.sf.jsqlparser.statement.select.SetOperationList;
import net.sf.jsqlparser.statement.select.WithItem;
import net.sf.jsqlparser.statement.values.ValuesStatement;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * @author wb_zhanggaoyu@meituan.com
 * @version JSqlParserUtil.class  2023-08-09 11:02
 * @since
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JSqlParserUtil {
    public static void main(String[] args) throws JSQLParserException, IOException {
        final String sql = getSql("/sql2.sql");
//        sqlParseTest1(sql);
        final SQLStatementParser sqlStatementParser = SQLParserUtils.createSQLStatementParser(sql, DbType.mysql);
        final List<SQLStatement> sqlStatements = sqlStatementParser.parseStatementList();
        for (SQLStatement sqlStatement : sqlStatements) {
            final MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
            sqlStatement.accept(visitor);
            System.out.println(visitor.getTables());
            System.out.println(visitor.getAggregateFunctions());
        }
        System.out.println("----");
    }

    private static void sqlParseTest1(String sql) throws JSQLParserException {
        final Statement parse = CCJSqlParserUtil.parse(sql);
        TableAggregationInfo info = new TableAggregationInfo();
        if (parse instanceof Select) {
            Select select = (Select) parse;
            final SelectBody selectBody = select.getSelectBody();
            selectBody.accept(new SelectVisitor() {
                @Override
                public void visit(PlainSelect plainSelect) {

                    final List<SelectItem> selectItems = plainSelect.getSelectItems();
                    selectItems.forEach(selectItem -> selectItem.accept(new SelectItemVisitor() {
                        @Override
                        public void visit(AllColumns allColumns) {
                            System.out.println("allColumns = " + allColumns);
                        }

                        @Override
                        public void visit(AllTableColumns allTableColumns) {
                            System.out.println("allTableColumns = " + allTableColumns);
                        }

                        @Override
                        public void visit(SelectExpressionItem selectExpressionItem) {
                            System.out.println("selectExpressionItem = " + selectExpressionItem);
                            System.out.println("selectExpressionItem.expression = " + selectExpressionItem.getExpression().getClass());
                        }
                    }));
                    System.out.println("plainSelect：" + plainSelect);
                }

                @Override
                public void visit(SetOperationList setOpList) {
                    System.out.println("setOpList = " + setOpList);
                }

                @Override
                public void visit(WithItem withItem) {
                    System.out.println("withItem = " + withItem);
                }

                @Override
                public void visit(ValuesStatement aThis) {
                    System.out.println("aThis = " + aThis);
                }
            });
        }
        System.out.println(parse);
    }

    private static String getSql(String path) throws IOException {
        final URL resource = JSqlParserUtil.class.getResource(path);
        assert resource != null;
        return IOUtils.toString(resource, StandardCharsets.UTF_8);
    }

    @Data
    private static class TableAggregationInfo {
        private List<String> groupFields;

        private Map<String, ColumnAggregationInfo> metricAggregationInfo;

        private String table;

        private TableAggregationInfo subTableAggregationInfo;
    }

    @Data
    private static class ColumnAggregationInfo {
        private String columnName;

//        private List<AggregationType> aggregationTypes;
    }
}